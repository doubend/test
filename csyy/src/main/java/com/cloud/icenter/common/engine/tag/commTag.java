package com.cloud.icenter.common.engine.tag;

import com.cloud.icenter.common.engine.command.TrimCommand;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * 
 * <p>Title:BaseCommand</p>
 * <p>Description: 标签基类     </p>
 * <p>Copyright: Copyright (c) </p>
 * <p>Company: XXXX</p>
 * <p>Date:2015年1月3日</p>
 * @author CHEN_JIAN
 * @version 1.0
 */

//@XStreamConverter(value=ToAttributedValueConverter.class, strings={"sql"})
public  class commTag {
    @XStreamAsAttribute
	private String key;
    @XStreamAsAttribute
	private String parameterType;
    @XStreamAsAttribute
	private String author;
    @XStreamAsAttribute
	private String des;

	public String sql;
	private TrimCommand trim;

	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getParameterType() {
		return parameterType;
	}
	public void setParameterType(String parameterType) {
		this.parameterType = parameterType;
	}

	public TrimCommand getTrim() {
		return trim;
	}
	public void setTrim(TrimCommand trim) {
		this.trim = trim;
	}
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}




}
