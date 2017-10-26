package com.cloud.icenter.yyzx.fzjc.rkgx.pojo;

import com.cloud.icenter.base.pojo.Pojo;

public class SerchParam extends Pojo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 姓名
	 */
	private String name;
	
	/**
	 * 身份证号码
	 */
	private String sfz;
	
	/**
	 * 性别
	 */
	private String xb;
	
	/**
	 * 区县代码
	 */
	private String qxdm;
	
	/**
	 * 民族
	 */
	private String mz;
	
	/**
	 * 出生开始时间和结束时间(用于年龄查询)
	 */
	private String kssj;
	
	private String jssj;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSfz() {
		return sfz;
	}

	public void setSfz(String sfz) {
		this.sfz = sfz;
	}

	public String getXb() {
		return xb;
	}

	public void setXb(String xb) {
		this.xb = xb;
	}

	public String getQxdm() {
		return qxdm;
	}

	public void setQxdm(String qxdm) {
		this.qxdm = qxdm;
	}

	public String getMz() {
		return mz;
	}

	public void setMz(String mz) {
		this.mz = mz;
	}

	public String getKssj() {
		return kssj;
	}

	public void setKssj(String kssj) {
		this.kssj = kssj;
	}

	public String getJssj() {
		return jssj;
	}

	public void setJssj(String jssj) {
		this.jssj = jssj;
	}
}
