package com.cloud.icenter.yyzx.dpzs.dp.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 大屏-法人-企业分布
 * 
 * @author dbchenga
 */
public class DpFrFrfbPojo {
	@JsonProperty("name")
	private String type;

	@JsonProperty("value")
	private Integer num;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public DpFrFrfbPojo(String hy, int hysl) {
		type = hy;
		num = hysl;
	}

}
