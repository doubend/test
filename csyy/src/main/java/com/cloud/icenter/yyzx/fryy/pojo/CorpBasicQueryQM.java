package com.cloud.icenter.yyzx.fryy.pojo;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;


public class CorpBasicQueryQM extends CorpBasicQuery implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private String xm;


	private String zzjgdm;
    
    private String fddbrxm;
    
    private String jgdz;
    
    private String xzqh;//行政区划
    
    private String zzjgmc;
    
    private String fddbrzjhm; //法定代表人证件号码
    
    private String jclx;//缴存类型
    
    private String jfsj;
    
    
    private Date statTime;
    
    private Date endTime;
    
    public Date getStatTime() {
		return statTime;
	}

	public void setStatTime(Date statTime) {
		this.statTime = statTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getJfsj() {
		return jfsj;
	}

	public void setJfsj(String jfsj) {
		this.jfsj = jfsj;
	}

	private String sfz;
    
    private Date jcsj;
    
    private Date startDate;
    
    private Date endDate;

	public String getZzjgdm() {
		return zzjgdm;
	}

	public void setZzjgdm(String zzjgdm) {
		this.zzjgdm = zzjgdm;
	}

	public String getFddbrxm() {
		return fddbrxm;
	}

	public void setFddbrxm(String fddbrxm) {
		this.fddbrxm = fddbrxm;
	}

	public String getJgdz() {
		return jgdz;
	}

	public void setJgdz(String jgdz) {
		this.jgdz = jgdz;
	}

	public String getXzqh() {
		if (this.xzqh!=null && this.xzqh.isEmpty()){
			this.xzqh = null;
		}
		return xzqh;
	}

	public void setXzqh(String xzqh) {
		this.xzqh = xzqh;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getZzjgmc() {
		return zzjgmc;
	}

	public void setZzjgmc(String zzjgmc) {
		this.zzjgmc = zzjgmc;
	}

	public String getFddbrzjhm() {
		return fddbrzjhm;
	}

	public void setFddbrzjhm(String fddbrzjhm) {
		this.fddbrzjhm = fddbrzjhm;
	}

	public String getSfz() {
		return sfz;
	}

	public void setSfz(String sfz) {
		this.sfz = sfz;
	}
    public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getJclx() {
		return jclx;
	}

	public Date getJcsj() {
		return jcsj;
	}

	public void setJcsj(Date jcsj) {
		this.jcsj = jcsj;
	}

	public void setJclx(String jclx) {
		this.jclx = jclx;
	}
	
}