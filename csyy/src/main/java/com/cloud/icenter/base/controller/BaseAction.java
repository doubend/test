package com.cloud.icenter.base.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.cloud.icenter.common.constants.Constants;
import com.cloud.icenter.common.utils.JsonResult;
import com.cloud.icenter.common.utils.JsonUtil;
import com.cloud.icenter.common.utils.Pagination;
import com.cloud.icenter.system.onlineuser.pojo.OnlineUser;
import com.cloud.icenter.system.onlineuser.service.OnlineUserService;

/**
 * Action基础类,系统里所有Action都必须继承该Action
 * @author zhangle
 */
public abstract class BaseAction {
	private static final Log logger = LogFactory.getLog(BaseAction.class);
	private static ThreadLocal<Map<String,Object>> dataThreadLocal=new ThreadLocal<Map<String,Object>>();
	
	@Autowired private OnlineUserService onlineUserService;
	
	@ModelAttribute
	private void initServlet(HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("request", request);
		map.put("response", response);
		getDataThreadLocal().set(map);
	}
	
	//把OnlineUser放到ThreadLocal中，在任何位置都可以获取loginUser
	public static OnlineUser getOnlinUser(){
		return (OnlineUser)getDataThreadLocal().get().get("loginUser");
	}
	
	protected String forward(String path) {
		return "forward:"+path;
	}
	
	protected String redirect(String path) {
		return "redirect:"+path;
	}
	
	protected HttpServletRequest getRequest() {
		return (HttpServletRequest) getDataThreadLocal().get().get("request");
	}
	
	protected HttpSession getSession() {
		return getRequest().getSession();
	}
	
	protected ServletContext getServletContext() {
		return getSession().getServletContext();
	}
	
	protected HttpServletResponse getResponse() {
		return (HttpServletResponse) getDataThreadLocal().get().get("response");
	}
	
	/**
	 * 获取response对象
	 */
	protected HttpServletResponse getResponse(String contentType,String encode) {
		HttpServletResponse response=getResponse();
		response.setContentType(contentType);
		response.setCharacterEncoding(encode);
		return response;
	}
	
	/**
	 * 获取真实路径
	 */
	protected String getRealPath(String path) {
		return getServletContext().getRealPath(path);
	}
	
	/**
	 * 获取请求参数
	 */
	protected String getParameter(String name) {
		return getRequest().getParameter(name);
	}
	
	/**
	 * 获取请求参数数组
	 */
	protected String[] getParameterValues(String name) {
		return getRequest().getParameterValues(name);
	}
	
	/**
	 * 获取int类型请求参数
	 */
	protected int getIntParameter(String name) {
		return Integer.parseInt(getParameter(name));
	}

	/**
	 * 获取int类型请求参数,当出错时,返回defaultValue
	 */
	protected int getIntParameter(String name,int defaultValue) {
		try {
			return Integer.parseInt(getParameter(name));
		} catch(Exception e) {
			return defaultValue;
		}
	}
	
	/**
	 * 设置attribute到request中
	 */
	protected void setAttribute(String name,Object value) {
		getRequest().setAttribute(name, value);
	}
	
	/**
	 * 从request中获取attribute
	 */
	protected Object getAttribute(String name) {
		return getRequest().getAttribute(name);
	}
	
	/**
	 * 设置attribute到session中
	 */
	protected void setSessionAttribute(String name,Object value) {
		getSession().setAttribute(name, value);
	}
	
	/**
	 * 从session中获取attribute
	 */
	protected Object getSessionAttribute(String name) {
		return getSession().getAttribute(name);
	}
	
	/**
	 * 设置attribute到application中
	 */
	protected void setAppAttribute(String name,Object value) {
		getServletContext().setAttribute(name, value);
	}
	
	/**
	 * 从application中获取attribute
	 */
	protected Object getAppAttribute(String name) {
		return getServletContext().getAttribute(name);
	}
	
	/**
	 * 获取登录用户
	 */
	protected OnlineUser getLoginUser() {
		return onlineUserService.getLoginUser(getRequest());
	}
	
	/**
	 * 打印文本字符到response
	 */
	protected void printText(String text) {
		try {
			HttpServletResponse response = getResponse("text/plain;charset=UTF-8","UTF-8");
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache,no-store,max-age=0");
			response.setDateHeader("Expires",-1);
			response.getWriter().print(text);
		} catch (Exception e) {
			throw new RuntimeException("输出文本数据出错!",e);
		}
	}
	
	/**
	 * 打印文本字符到response
	 */
	protected void printHtml(String html) {
		try {
			HttpServletResponse response = getResponse("text/html;charset=UTF-8","UTF-8");
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache,no-store,max-age=0");
			response.setDateHeader("Expires",-1);
			response.getWriter().print(html);
		} catch (Exception e) {
			throw new RuntimeException("输出html数据出错!",e);
		}
	}
	
	/**
	 * 打印json字符到response
	 */
	protected void printJson(String json) {
		try {
			HttpServletResponse response = getResponse("text/json;charset=UTF-8","UTF-8");
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache,no-store,max-age=0");
			response.setDateHeader("Expires",-1);
			response.getWriter().print(json);
		} catch (Exception e) {
			throw new RuntimeException("输出json数据出错!",e);
		}
	}
	
	/**
	 * 打印json字符到response
	 */
	protected void printJson(Object obj) {
		try {
			String json=JsonUtil.toJson(obj);
			printJson(json);
		} catch (Exception e) {
			throw new RuntimeException("输出json数据出错!",e);
		}
	}
	
	/**
	 * 打印json字符到response
	 * @param pagin
	 */
	protected void printJson(Pagination<?> pagin) {
		Map<String, Object> jsonMap=new HashMap<String, Object>();
		jsonMap.put("total", pagin.getTotalCount());
		jsonMap.put("rows", pagin.getDataList());
		printJson(jsonMap);
	}
	
	/**
	 * 打印JsonResult到response
	 */
	protected void printJsonResult(int code,String msg) {
		printJson(jsonResult(code,msg));
	}
	
	/**
	 * 获取JsonResult对象
	 */
	protected JsonResult jsonResult(int code,String msg) {
		JsonResult result=new JsonResult(code,msg);
		return result;
	}
	
	/**
	 * 打印JsonResult到response
	 */
	protected void printJsonResult(int code,String msg,Object data) {
		printJson(jsonResult(code,msg,data));
	}
	
	/**
	 * 获取JsonResult对象
	 */
	protected JsonResult jsonResult(int code,String msg,Object data) {
		JsonResult result=new JsonResult(code,msg,data);
		return result;
	}
	
	/**
	 * 错误处理
	 */
	@ExceptionHandler(Exception.class)
	protected void handleException(Exception e) {
		logger.error(e.getMessage(),e); 
		getRequest().setAttribute("EXCEPTION", e);
		try {
			getRequest().getRequestDispatcher(Constants.SYSTEM_ERROR_PAGE).forward(getRequest(), getResponse());
		} catch (Exception e1) {}
	}
	
	/**
	 * 快速获取id参数
	 * @return
	 */
	protected String getId() {
		return getParameter("id");
	}

	public static ThreadLocal<Map<String,Object>> getDataThreadLocal() {
		return dataThreadLocal;
	}
}
