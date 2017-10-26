package com.cloud.icenter.yyzx.rkyy.pojo;


import java.io.Serializable;
import java.util.Date;



public class SheBaoInfoQueryQM extends PeopleBasicQuery implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    
    //身份证号
    private String sfzhm;
    
    //首次参保时间
    private String sccbsj;
    
    //停止参保时间
    private String tzcbsj;
    
    //参保状态
    private String cbzt;
    
    //社会保障号码
    private String shbzhm;
    
    //籍贯省市县（区）
    private String jg;
    
    //现居住地
    private String xjzd;
    
    //现住地址编号
    private String xjzdbm;
    
    //电话号码
    private String dhhm;
    
    //单位编号
    private String dwbh;
    
    //单位名称
    private String dwmc;
    
    //缴费月份
    private String jfyf;
    
    
    //首次参保时间开始
    private Date sccbsjks;
    
    //首次参保时间结束
    private Date sccbsjjs;
    
    

	

	public String getSfzhm() {
		return sfzhm;
	}

	public void setSfzhm(String sfzhm) {
		this.sfzhm = sfzhm;
	}

	public String getSccbsj() {
		return sccbsj;
	}

	public void setSccbsj(String sccbsj) {
		this.sccbsj = sccbsj;
	}

	public String getTzcbsj() {
		return tzcbsj;
	}

	public void setTzcbsj(String tzcbsj) {
		this.tzcbsj = tzcbsj;
	}

	public String getShbzhm() {
		return shbzhm;
	}

	public void setShbzhm(String shbzhm) {
		this.shbzhm = shbzhm;
	}

	public String getJg() {
		return jg;
	}

	public void setJg(String jg) {
		this.jg = jg;
	}

	public String getXjzd() {
		return xjzd;
	}

	public void setXjzd(String xjzd) {
		this.xjzd = xjzd;
	}

	public String getXjzdbm() {
		return xjzdbm;
	}

	public void setXjzdbm(String xjzdbm) {
		this.xjzdbm = xjzdbm;
	}

	public String getDhhm() {
		return dhhm;
	}

	public void setDhhm(String dhhm) {
		this.dhhm = dhhm;
	}

	public String getDwbh() {
		return dwbh;
	}

	public void setDwbh(String dwbh) {
		this.dwbh = dwbh;
	}

	public String getDwmc() {
		return dwmc;
	}

	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}

	public String getJfyf() {
		return jfyf;
	}

	public void setJfyf(String jfyf) {
		this.jfyf = jfyf;
	}

	public String getCbzt() {
		return cbzt;
	}

	public void setCbzt(String cbzt) {
		this.cbzt = cbzt;
	}

	public Date getSccbsjks() {
		return sccbsjks;
	}

	public void setSccbsjks(Date sccbsjks) {
		this.sccbsjks = sccbsjks;
	}

	public Date getSccbsjjs() {
		return sccbsjjs;
	}

	public void setSccbsjjs(Date sccbsjjs) {
		this.sccbsjjs = sccbsjjs;
	}

	

	
    
    
    
}