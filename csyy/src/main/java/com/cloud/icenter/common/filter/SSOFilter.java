package com.cloud.icenter.common.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cloud.icenter.common.utils.HttpUtil;
import com.cloud.icenter.common.utils.JsonResult;
import com.cloud.icenter.common.utils.JsonUtil;
import com.cloud.icenter.common.utils.SpringUtil;
import com.cloud.icenter.common.utils.SystemConfig;
import com.cloud.icenter.system.login.bean.SSOKey;
import com.cloud.icenter.system.onlineuser.pojo.OnlineUser;
import com.cloud.icenter.system.onlineuser.service.OnlineUserService;

public class SSOFilter implements Filter {
	
	private String loginUrl;
	private String noticketloginUrl;
	private String ticketloginUrl;
	private String getAppId;
	private String getPublicKey;
	private Pattern[] excludeUrlPattern;
	private Map<String,String> excludeUrlCache;
	private OnlineUserService onlineUserService;
	
	
    public void init(FilterConfig filterConfig)
		    throws ServletException{
    	onlineUserService=SpringUtil.getBean(OnlineUserService.class);
    	String tyrzUrl = SystemConfig.getProperty("tyrz.Url");
    	loginUrl = tyrzUrl+SystemConfig.getProperty("tyrz.loginUrl");
    	noticketloginUrl = tyrzUrl+SystemConfig.getProperty("tyrz.noticketlogin");
    	ticketloginUrl = tyrzUrl+SystemConfig.getProperty("tyrz.ticketlogin");
    	getAppId = tyrzUrl+SystemConfig.getProperty("tyrz.getAppId");
    	getPublicKey = tyrzUrl+SystemConfig.getProperty("tyrz.getPublicKey");
		excludeUrlPattern=getExcludeUrlPattern(filterConfig);
		excludeUrlCache=new HashMap<String,String>(200);
    }

	public void destroy() {
		// TODO Auto-generated method stub
		
	}


	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest httprequest = (HttpServletRequest)request;
		HttpServletResponse httpresponse = (HttpServletResponse)response;
		HttpSession session = httprequest.getSession();
		ServletContext application = session.getServletContext();
		
		//获取请求的URL
		String requestUrl=getRequestUrl(httprequest);
		
		//如果是排除验证的URL,那么直接通过,无需权限验证
		if(isExcludedUrl(requestUrl)) {
			chain.doFilter(request, response);
			return;
		}
		
		//查看服务器缓存中是否存在appId若不存在则像认证服务器获取
		Object appId = application.getAttribute("appId");
		if(appId==null){
			appId = HttpUtil.HttpGet(getAppId+"?appUrl="+getUrl(httprequest));
			if(appId!=null && !appId.equals("")){
				application.setAttribute("appId", appId);
			}
		}
			
		//查看会话中是否存在密钥，若不存在则向认证服务器获取
		Object keyobj = session.getAttribute("publickey");
		SSOKey key = null;
		if(keyobj==null){
			String result = HttpUtil.HttpGet(getPublicKey+"?appId="+appId.toString());
			if(result!=null && !result.equals("")){
				key = JsonUtil.toObject(result, SSOKey.class);
				session.setAttribute("publickey",key);
			}
		}else{
			key = (SSOKey)keyobj;
		}
			
		//改造为通过onlinuser判断是否已登录
		//Object username = session.getAttribute("username");
		OnlineUser loginUser=onlineUserService.getLoginUser(httprequest);
		//会话缓存中没有用户凭证则重定向到认证服务器进行认证
		if(loginUser==null){
			//httpresponse.sendRedirect(noticketloginUrl+"?appId="+appId.toString());
			httpresponse.sendRedirect(loginUrl);
			return ;
		}
		String username = loginUser.getUsername();
		Date checktime = (Date)session.getAttribute("checktime");
		Date nowdate = Calendar.getInstance().getTime();
		
		//未超出认证时间则放行
		if(nowdate.before(checktime)){
			chain.doFilter(request, response);
			return;
		}
			
		String uid = (String)session.getAttribute("ssouid");
		String ip = HttpUtil.getIpAddress(httprequest);
		//进行有凭证的统一认证
		String result = HttpUtil.HttpGet(ticketloginUrl
										+"?appId="+appId
										+"&username="+username.toString()
										+"&ip="+ip
										+"&uid="+uid);
		JsonResult jsonresult = null;
		if(result!=null && !result.equals("")){
			jsonresult = JsonUtil.toObject(result,JsonResult.class);
		}
			
		//检查认证服务器返回的用户凭证是否与本地会话缓存中的一致
		if(jsonresult!=null && jsonresult.getCode()==200){
			String checkfreetime = (String)session.getAttribute("checkfreetime");
			Calendar newCalendar= Calendar.getInstance();
			newCalendar.add(Calendar.SECOND, Integer.parseInt(checkfreetime));
			checktime = newCalendar.getTime();
			session.setAttribute("checktime",checktime);
		}else{
			//认证失败直接重定向到登录页面
			httprequest.getSession().setAttribute("loginerrormsg", jsonresult.getMessage());
			httpresponse.sendRedirect(loginUrl);
			return ;
		}
			
		chain.doFilter(request, response);
	}
	
	private String getUrl(HttpServletRequest httprequest){
		StringBuffer url = httprequest.getRequestURL();
		return url.substring(0,
			   url.indexOf(httprequest.getContextPath())
			   +httprequest.getContextPath().length()
			   );
		
	}

	/**
	 * 获取排除验证的url
	 */
	private Pattern[] getExcludeUrlPattern(FilterConfig filterConfig) {
		Pattern[] excludeUrlPattern=null;
		String excludeUrl=filterConfig.getInitParameter("exclude-url");
		if(excludeUrl==null || excludeUrl.equals("")) {
			excludeUrlPattern=new Pattern[0];
		} else {
			
			String[] url=excludeUrl.split(",|\\s+");
			List<Pattern> pl=new ArrayList<Pattern>();
			for(int i=0;i<url.length;i++) {
				if(url[i]==null || url[i].equals("")) continue;
				pl.add(Pattern.compile(url[i]));
			}
			excludeUrlPattern=pl.toArray(new Pattern[pl.size()]);
		}
		return excludeUrlPattern;
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
	 * 获取请求的URL路径
	 */
	private String getRequestUrl(HttpServletRequest request) {
		
		int contextPathLength=request.getContextPath().length();
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

}