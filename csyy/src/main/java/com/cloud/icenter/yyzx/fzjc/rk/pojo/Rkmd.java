package com.cloud.icenter.yyzx.fzjc.rk.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 新生婴儿性别比及分布
 * 
 * @author Administrator
 *
 */
public class Rkmd {

	public Rkmd(String city, int total_population) {

		this.city = city;
		if (city.equals("张家川")) {
			this.city = "张家川回族自治县";
		}
		this.total_population = total_population;
	}

	@JsonProperty("name")
	private String city;// varchar(20) 城市名称

	@JsonProperty("value")
	private Integer total_population;// int 人口

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getTotal_population() {
		return total_population;
	}

	public void setTotal_population(Integer total_population) {
		this.total_population = total_population;
	}

}
