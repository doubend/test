package com.cloud.icenter.common.engine.tag;

import com.cloud.icenter.common.engine.command.GroupCommand;
import com.cloud.icenter.common.engine.command.OrderCommand;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

/**
 * 
 * <p>Title:SelectTag</p>
 * <p>Description: select标签     </p>
 * <p>Copyright: Copyright (c) </p>
 * <p>Company: XXXX</p>
 * <p>Date:2015年1月3日</p>
 * @author CHEN_JIAN
 * @version 1.0
 */
@XStreamAlias(value="select")
public class SelectTag extends commTag{
	@XStreamAsAttribute
	private String resultType;

	private OrderCommand order;
	
	private GroupCommand group;


	public String getResultType() {
		return resultType;
	}
	public void setResultType(String resultType) {
		this.resultType = resultType;
	}
	public OrderCommand getOrder() {
		return order;
	}
	public void setOrder(OrderCommand order) {
		this.order = order;
	}
	public GroupCommand getGroup() {
		return group;
	}
	public void setGroup(GroupCommand group) {
		this.group = group;
	}


}
