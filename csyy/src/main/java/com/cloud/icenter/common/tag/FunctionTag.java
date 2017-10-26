package com.cloud.icenter.common.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

import com.cloud.icenter.common.utils.SpringUtil;
import com.cloud.icenter.common.utils.StringUtil;
import com.cloud.icenter.system.auth.service.AuthService;
import com.cloud.icenter.system.onlineuser.service.OnlineUserService;

/**
 * 功能标签 用于在页面上根据权限显示按钮
 * 
 * @author yuhaitao
 */
public class FunctionTag extends TagSupport {
	private OnlineUserService onlineUserService;
	private AuthService authService;
	private String code; // 数据code
	private String output; // 输出模式,取值范围.span,text,select,json,jsonArray,combobox
	private boolean cache; // 是否缓存基础数据,同时也代表是否从缓存取数据,没取到则查询数据库,并加入缓存
	private String href; // 链接
	private String id; // 标签ID
	private String name; // 标签name
	private String onclick; // 事件
	private String cssClass; // css class
	private String style; // css样式
	private boolean disabled; // 是否禁用此控件
	private String dataOptions;
	private String text;
	private String group;
	private String title;
	
	
	
	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public FunctionTag() {
		output = "a";
		id = "";
		name = "";
		onclick = "";
		cssClass = "";
		style = "";
		disabled = true;
		dataOptions = "";
		href = "";
		text = "";
		group="";
		title="";
	}

	@Override
	public void setPageContext(PageContext pageContext) {
		super.setPageContext(pageContext);
		onlineUserService = SpringUtil.getBean(OnlineUserService.class);
		authService = SpringUtil.getBean(AuthService.class);
	}

	@Override
	public int doStartTag() throws JspException {
		super.doStartTag();

		HttpServletRequest request = (HttpServletRequest) pageContext
				.getRequest();

		// 取出登录用户
		//OnlineUser loginUser = onlineUserService.getLoginUser(request);
		//if (authService.checkCode(loginUser, code)) {
			try {
				pageContext.getOut().print(getHtml());//输出html到页面
				pageContext.getOut().flush();
			} catch (IOException e) {
				//e.printStackTrace();
			//}		
			
		}
		return SKIP_BODY;
	}

	private String getHtml() {
		StringBuilder sb = new StringBuilder();
		sb.append("<" + output);
		if (!StringUtil.isEmpty(id)) {
			sb.append(" id=\"" + id + "\"");
		}
		if (!StringUtil.isEmpty(name)) {
			sb.append(" name=\"" + name + "\"");
		}
		if (!StringUtil.isEmpty(onclick)) {
			sb.append(" onclick=\"" + onclick + "\"");
		}
		if (!StringUtil.isEmpty(cssClass)) {
			sb.append(" class=\"" + cssClass + "\"");
		}
		if (!StringUtil.isEmpty(dataOptions)) {
			sb.append(" data-options=\"" + dataOptions + "\"");
		}
		if (!StringUtil.isEmpty(href)) {
			sb.append(" href=\"" + href + "\"");
		}
		if (!StringUtil.isEmpty(group)) {
			sb.append(" group=\"" + group + "\"");
		}
		if (!StringUtil.isEmpty(title)) {
			sb.append(" title=\"" + title + "\"");
		}
		sb.append(">" + text + "</" + output + ">");
		return sb.toString();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public boolean isCache() {
		return cache;
	}

	public void setCache(boolean cache) {
		this.cache = cache;
	}

	/*
	 * public String getOptions() { return options; } public void
	 * setOptions(String options) { this.options = options; }
	 */
	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOnclick() {
		return onclick;
	}

	public void setOnclick(String onclick) {
		this.onclick = onclick;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public String getDataOptions() {
		return dataOptions;
	}

	public void setDataOptions(String dataOptions) {
		this.dataOptions = dataOptions;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getText() {
		return text;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setText(String text) {
		this.text = text;
	}
}
