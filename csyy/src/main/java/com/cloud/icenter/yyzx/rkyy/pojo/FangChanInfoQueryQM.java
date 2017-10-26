package com.cloud.icenter.yyzx.rkyy.pojo;


import java.io.Serializable;
import java.sql.Date;



public class FangChanInfoQueryQM implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    
    //身份证号
    private String fwsyqsfz;
    
    //户号
    private String hh;
    
    //户口类别
    private String hklb;
    
    //监护人一身份证号
    private Date jhrsfz;
    
    //监护人一监护关系
    private String jhrjhgx;
    
    //监护人二身份证号
    private String jhrsfz2;
    
    //监护人二监护关系
    private String jhrjhgx2;
    
    //父亲身份证号
    private String fqsfz;
    
    //母亲身份证号
    private String mqsfz;
    
    //配偶身份证号
    private String posfz;
    
    //何时迁来
    private Date hsql;
    
    //何地迁来
    private String hdql;
    
    //迁出日期
    private Date qcrq;
    
    //迁往地
    private String qwd;
    
    //户口迁移变动代码
    private String hkqybddm;
    
    //与户主关系
    private String yhzgx;

    
    private Date endTime;
    
    
    private Date statTime;
	

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getStatTime() {
		return statTime;
	}

	public void setStatTime(Date statTime) {
		this.statTime = statTime;
	}

	public String getFwsyqsfz() {
		return fwsyqsfz;
	}

	public void setFwsyqsfz(String fwsyqsfz) {
		this.fwsyqsfz = fwsyqsfz;
	}

	public String getHh() {
		return hh;
	}

	public void setHh(String hh) {
		this.hh = hh;
	}

	public String getHklb() {
		return hklb;
	}

	public void setHklb(String hklb) {
		this.hklb = hklb;
	}

	public Date getJhrsfz() {
		return jhrsfz;
	}

	public void setJhrsfz(Date jhrsfz) {
		this.jhrsfz = jhrsfz;
	}

	public String getJhrjhgx() {
		return jhrjhgx;
	}

	public void setJhrjhgx(String jhrjhgx) {
		this.jhrjhgx = jhrjhgx;
	}

	public String getJhrsfz2() {
		return jhrsfz2;
	}

	public void setJhrsfz2(String jhrsfz2) {
		this.jhrsfz2 = jhrsfz2;
	}

	public String getJhrjhgx2() {
		return jhrjhgx2;
	}

	public void setJhrjhgx2(String jhrjhgx2) {
		this.jhrjhgx2 = jhrjhgx2;
	}

	public String getFqsfz() {
		return fqsfz;
	}

	public void setFqsfz(String fqsfz) {
		this.fqsfz = fqsfz;
	}

	public String getMqsfz() {
		return mqsfz;
	}

	public void setMqsfz(String mqsfz) {
		this.mqsfz = mqsfz;
	}

	public String getPosfz() {
		return posfz;
	}

	public void setPosfz(String posfz) {
		this.posfz = posfz;
	}

	public Date getHsql() {
		return hsql;
	}

	public void setHsql(Date hsql) {
		this.hsql = hsql;
	}

	public String getHdql() {
		return hdql;
	}

	public void setHdql(String hdql) {
		this.hdql = hdql;
	}

	public Date getQcrq() {
		return qcrq;
	}

	public void setQcrq(Date qcrq) {
		this.qcrq = qcrq;
	}

	public String getQwd() {
		return qwd;
	}

	public void setQwd(String qwd) {
		this.qwd = qwd;
	}

	public String getHkqybddm() {
		return hkqybddm;
	}

	public void setHkqybddm(String hkqybddm) {
		this.hkqybddm = hkqybddm;
	}

	public String getYhzgx() {
		return yhzgx;
	}

	public void setYhzgx(String yhzgx) {
		this.yhzgx = yhzgx;
	}
    
    
    
    
}