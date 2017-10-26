package com.cloud.icenter.common.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.cloud.icenter.common.constants.Constants;
import com.cloud.icenter.common.utils.SpringUtil;
import com.cloud.icenter.system.auth.service.AuthService;
import com.cloud.icenter.system.onlineuser.pojo.OnlineUser;
import com.cloud.icenter.system.onlineuser.service.OnlineUserService;

/**
 * 权限验证过滤器
 * @author zhangle
 */
public class AuthFilter implements Filter {
	
	private static final Log logger = LogFactory.getLog(AuthFilter.class);
	
	private AuthService authService;
	private OnlineUserService onlineUserService;
	private Pattern[] excludeUrlPattern;
	private Map<String,String> excludeUrlCache;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		authService=SpringUtil.getBean(AuthService.class);
		onlineUserService=SpringUtil.getBean(OnlineUserService.class);
		excludeUrlPattern=getExcludeUrlPattern(filterConfig);
		excludeUrlCache=new HashMap<String,String>(200);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		
		//获取请求的URL
		String requestUrl=getRequestUrl(req);
		//如果是排除验证的URL,那么直接通过,无需权限验证
		if(isExcludedUrl(requestUrl)) {
			chain.doFilter(request, response);
			return;
		}
		
		logger.debug("权限验证地址:"+requestUrl);
		OnlineUser loginUser=onlineUserService.getLoginUser(req);
		if(loginUser==null) {
			//如果未登录,那么检查是否未登录也可访问.不可访问则跳到登录页,否则通过
			if(!authService.checkUrl(null, requestUrl)) {
				gotoLogin(req,res,"用户超时或未登录,请先登录!");
			} else {
				chain.doFilter(request, response);
			}
			return;
		}
		
		//此处代表用户已登录,如果有权访问,那么通过;否则跳到拒绝访问页面
		if(authService.checkUrl(loginUser, requestUrl)) {
			chain.doFilter(request, response);
		} else {
			accessDenied(req,res);
		}
	}

	@Override
	public void destroy() {}
	
	/**
	 * 获取排除验证的url
	 */
	private Pattern[] getExcludeUrlPattern(FilterConfig filterConfig) {
		Pattern[] excludeUrlPattern=null;
		String excludeUrl=filterConfig.getInitParameter("exclude-url");
		if(StringUtils.isBlank(excludeUrl)) {
			excludeUrlPattern=new Pattern[0];
		} else {
			
			String[] url=excludeUrl.split(",|\\s+");
			List<Pattern> pl=new ArrayList<Pattern>();
			for(int i=0;i<url.length;i++) {
				if(StringUtils.isBlank(url[i])) continue;
				pl.add(Pattern.compile(url[i]));
			}
			excludeUrlPattern=pl.toArray(new Pattern[pl.size()]);
		}
		return excludeUrlPattern;
	}
	
	/**
	 * 获取请求的URL路径
	 */
	private String getRequestUrl(HttpServletRequest request) {
		//获取路劲
		int contextPathLength=request.getContextPath().length();
		//获取url
		String requestUrl=request.getRequestURI().substring(contextPathLength);
		/*
		//验证权限的url是否需要加入querystring参数,如果需要请去掉此注释.本系统基于rest风格,推荐不加入,提升性能
		String queryString=request.getQueryString();
		if(queryString==null) return requestUrl;
		queryString=queryString.replaceFirst("_=\\d+", "");	//去掉easyui自动加入的防缓存参数
		if(queryString.length()>0) {		//加入querystring
			requestUrl+="?"+request.getQueryString();
		}*/
		return requestUrl;
	}
	
	/**
	 * 检查请求路径是否不需要验证权限
	 */
	private boolean isExcludedUrl(String path) {
		if(excludeUrlCache.containsKey(path)) return true;
		
		for(Pattern p:excludeUrlPattern) {
			if(p.matcher(path).matches()) {
				excludeUrlCache.put(path, "OK");
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 跳到登录页面
	 */
	private void gotoLogin(HttpServletRequest request,HttpServletResponse response,String systemMessage) {
		try {
			response.sendRedirect(request.getContextPath()+Constants.LOGIN_PAGE);
		} catch (IOException e) {}
	}
	
	/**
	 * 拒绝访问处理
	 */
	private void accessDenied(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		logger.warn("权限不够,拒绝访问!	url="+getRequestUrl(request));
		request.getRequestDispatcher(Constants.ACCESS_DENIED_PAGE).forward(request, response);
	}
}
