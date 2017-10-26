package com.cloud.icenter.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 皮肤切换过滤器
 * 实现皮肤切换,目前为初级版本,没有实现切换,先保留,待以后扩展
 * @author zhangle
 */
public class SkinFilter implements Filter {

	private String contextPath;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.contextPath=filterConfig.getServletContext().getContextPath();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
		
		request.setAttribute("commonSkin", contextPath+"/skins/common");
		request.setAttribute("skin", contextPath+"/skins/default");
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {}
}
