package com.cloud.icenter.common.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang3.StringUtils;

import com.cloud.icenter.common.utils.SpringUtil;
import com.cloud.icenter.system.auth.service.AuthService;
import com.cloud.icenter.system.onlineuser.pojo.OnlineUser;
import com.cloud.icenter.system.onlineuser.service.OnlineUserService;

/**
 * 权限验证自定义标签
 * @author zhangle
 */
public class AuthTag extends TagSupport {

	private String code;
	private String url;
	
	private AuthService authService;
	private OnlineUserService onlineUserService;
	
	@Override
	public void setPageContext(PageContext pageContext) {
		super.setPageContext(pageContext);
		authService=SpringUtil.getBean(AuthService.class);
		onlineUserService=SpringUtil.getBean(OnlineUserService.class);
	}
	
	@Override
	public int doStartTag() throws JspException {
		super.doStartTag();

		HttpServletRequest request=(HttpServletRequest) pageContext.getRequest();
		
		//取出登录用户
		OnlineUser loginUser=onlineUserService.getLoginUser(request);
		if(!StringUtils.isBlank(code)) {
			if(authService.checkCode(loginUser, code)) {
				return EVAL_BODY_INCLUDE;
			}
			return SKIP_BODY;
		}
		if(!StringUtils.isBlank(url)) {
			if(authService.checkUrl(loginUser, url)) {
				return EVAL_BODY_INCLUDE;
			}
			return SKIP_BODY;
		}
		return SKIP_BODY;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
