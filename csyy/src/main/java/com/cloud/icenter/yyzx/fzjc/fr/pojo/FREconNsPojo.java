package com.cloud.icenter.yyzx.fzjc.fr.pojo;

import com.cloud.icenter.base.pojo.Pojo;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FREconNsPojo extends Pojo {

	private static final long serialVersionUID = 1L;

	@JsonProperty("name")
	private String type;

	@JsonProperty("value")
	private Float nsnum;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Float getNsnum() {
		return nsnum;
	}

	public void setNsnum(Float nsnum) {
		this.nsnum = nsnum;
	}

}
