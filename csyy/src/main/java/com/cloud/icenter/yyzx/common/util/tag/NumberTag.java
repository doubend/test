package com.cloud.icenter.yyzx.common.util.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.cloud.icenter.common.utils.StringUtil;

/** 
* @author zhucy 
* @version 2017年3月28日 下午4:22:43 
* 说明 
*/
public class NumberTag extends TagSupport{
	private String value;//待处理参数

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public int doStartTag() throws JspException {
		super.doStartTag();
		HttpServletRequest request = (HttpServletRequest) pageContext
				.getRequest();
		String html = "";
		if (!StringUtil.isEmpty(value)) {
			if (value.endsWith(".00")) {
				html = value.replace(".00", "");
			}else{
				html = value;
			}
		}
		try {
			//输出html到页面
			pageContext.getOut().print(html);
			pageContext.getOut().flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SKIP_BODY;
	}
	
	
}
