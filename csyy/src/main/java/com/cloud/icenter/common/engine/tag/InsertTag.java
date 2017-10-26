package com.cloud.icenter.common.engine.tag;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
/**
 * 
 * <p>Title:InsertTag</p>
 * <p>Description:insert 标签      </p>
 * <p>Copyright: Copyright (c) </p>
 * <p>Company: XXXX</p>
 * <p>Date:2015年1月3日</p>
 * @author CHEN_JIAN
 * @version 1.0
 */
@XStreamAlias(value="insert")
public class InsertTag extends commTag{
	@XStreamAsAttribute
	private String sequence;
	@XStreamAsAttribute
	private String primaryKey;

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public String getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(String primaryKey) {
		this.primaryKey = primaryKey;
	}

}
