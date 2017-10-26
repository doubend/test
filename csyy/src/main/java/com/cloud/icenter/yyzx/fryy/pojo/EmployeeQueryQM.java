package com.cloud.icenter.yyzx.fryy.pojo;

import java.io.Serializable;

import javax.persistence.Entity;

public class EmployeeQueryQM implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4534830085144984084L;
	private String zzjgdm;
	private String zzjgmc;
	private String sfzhm;
	private String xm;
	private String tssfz;// 同事身份证
	private String jfyf;//缴费月份

	public String getJfyf() {
		return jfyf;
	}

	public void setJfyf(String jfyf) {
		this.jfyf = jfyf;
	}

	private String xb;

	private String csrq;

	public String getXb() {
		return xb;
	}

	public void setXb(String xb) {
		this.xb = xb;
	}

	public String getCsrq() {
		return csrq;
	}

	public void setCsrq(String csrq) {
		this.csrq = csrq;
	}

	public String getZzjgdm() {
		return zzjgdm;
	}

	public void setZzjgdm(String zzjgdm) {
		this.zzjgdm = zzjgdm;
	}

	public String getZzjgmc() {
		return zzjgmc;
	}

	public void setZzjgmc(String zzjgmc) {
		this.zzjgmc = zzjgmc;
	}

	public String getSfzhm() {
		return sfzhm;
	}

	public void setSfzhm(String sfzhm) {
		this.sfzhm = sfzhm;
	}

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getTssfz() {
		return tssfz;
	}

	public void setTssfz(String tssfz) {
		this.tssfz = tssfz;
	}

}
