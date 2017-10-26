package com.cloud.icenter.yyzx.cszc.security.pojo;

import com.cloud.icenter.base.pojo.Pojo;

/**
 * 年月与地区查询实体
 * @date 2017年3月31日
 * @author dxliug
 */
public class QueryPojo extends Pojo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String area = "桓台县";
	
	public static final String foreign="外来人口";
	
	public static final String resident="常驻人口";

	/**
	 * 去年
	 */
	private String befNian;
	
	
	/**
	 * 年份
	 */
	private String nian;
	
	/**
	 * 区域
	 */
	private String qy;
	
	
	

	public String getBefNian() {
		return befNian;
	}

	public void setBefNian(String befNian) {
		this.befNian = befNian;
	}

	public String getNian() {
		return nian;
	}

	public void setNian(String nian) {
		this.nian = nian;
	}

	public String getQy() {
		return qy;
	}

	public void setQy(String qy) {
		this.qy = qy;
	}
	public QueryPojo(String nian,String befNian) {
		super();
		this.nian = nian;
		this.befNian = befNian;
	}

	public QueryPojo() {
		super();
	}
	
}
