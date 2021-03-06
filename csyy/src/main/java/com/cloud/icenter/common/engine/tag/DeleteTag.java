package com.cloud.icenter.common.engine.tag;

import com.cloud.icenter.common.engine.command.WhereCommand;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 
 * <p>Title:DeleteTag</p>
 * <p>Description:   delete 标签   </p>
 * <p>Copyright: Copyright (c) </p>
 * <p>Company: XXXX</p>
 * <p>Date:2015年1月3日</p>
 * @author CHEN_JIAN
 * @version 1.0
 */
@XStreamAlias(value="delete")
public class DeleteTag extends commTag{
	private WhereCommand where;

	public WhereCommand getWhere() {
		return where;
	}

	public void setWhere(WhereCommand where) {
		this.where = where;
	}

}
