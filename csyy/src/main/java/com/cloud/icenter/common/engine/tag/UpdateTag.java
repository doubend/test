package com.cloud.icenter.common.engine.tag;

import com.cloud.icenter.common.engine.command.SetCommand;
import com.cloud.icenter.common.engine.command.WhereCommand;
import com.thoughtworks.xstream.annotations.XStreamAlias;
/**
 * 
 * <p>Title:UpdateTag</p>
 * <p>Description: update 标签     </p>
 * <p>Copyright: Copyright (c) </p>
 * <p>Company: XXXX</p>
 * <p>Date:2015年1月3日</p>
 * @author CHEN_JIAN
 * @version 1.0
 */
@XStreamAlias(value="update")
public class UpdateTag extends commTag {
	private SetCommand set;
	private WhereCommand where;
	public SetCommand getSet() {
		return set;
	}
	public void setSet(SetCommand set) {
		this.set = set;
	}
	public WhereCommand getWhere() {
		return where;
	}
	public void setWhere(WhereCommand where) {
		this.where = where;
	}

}
