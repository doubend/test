package com.cloud.icenter.yyzx.rkyy.pojo;


import java.io.Serializable;
import java.sql.Date;



public class JiaTingInfoQueryQM implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    
    //家庭编号
    private String jtbh;
    
    //户主身份证件类型
    private String hzsfzlx;
    
    //户主身份证号
    private String hzsfz;
    
    //人口数量
    private Date rksl;
    
    //联系电话_宅电
    private String lxdhzd;
    
    //联系电话_手机
    private String lxdhsj;
    
    //家庭年总收入
    private String jtnzsr;
    
    //家庭住房所有权代码
    private String jtzfsyqdm;
    
    //家庭住房类型代码
    private String jtzflxdm;
    
    //赡抚养关系
    private String sfygx;
    
    //赡抚养费用
    private Date sfyfy;
    
    //赡抚养人数
    private String sfyrs;
    
    //被赡抚养人身份证号
    private Date bsfyrsfz;

	public String getJtbh() {
		return jtbh;
	}

	public void setJtbh(String jtbh) {
		this.jtbh = jtbh;
	}

	public String getHzsfzlx() {
		return hzsfzlx;
	}

	public void setHzsfzlx(String hzsfzlx) {
		this.hzsfzlx = hzsfzlx;
	}

	public String getHzsfz() {
		return hzsfz;
	}

	public void setHzsfz(String hzsfz) {
		this.hzsfz = hzsfz;
	}

	public Date getRksl() {
		return rksl;
	}

	public void setRksl(Date rksl) {
		this.rksl = rksl;
	}

	public String getLxdhzd() {
		return lxdhzd;
	}

	public void setLxdhzd(String lxdhzd) {
		this.lxdhzd = lxdhzd;
	}

	public String getLxdhsj() {
		return lxdhsj;
	}

	public void setLxdhsj(String lxdhsj) {
		this.lxdhsj = lxdhsj;
	}

	public String getJtnzsr() {
		return jtnzsr;
	}

	public void setJtnzsr(String jtnzsr) {
		this.jtnzsr = jtnzsr;
	}

	public String getJtzfsyqdm() {
		return jtzfsyqdm;
	}

	public void setJtzfsyqdm(String jtzfsyqdm) {
		this.jtzfsyqdm = jtzfsyqdm;
	}

	public String getJtzflxdm() {
		return jtzflxdm;
	}

	public void setJtzflxdm(String jtzflxdm) {
		this.jtzflxdm = jtzflxdm;
	}

	public String getSfygx() {
		return sfygx;
	}

	public void setSfygx(String sfygx) {
		this.sfygx = sfygx;
	}

	public Date getSfyfy() {
		return sfyfy;
	}

	public void setSfyfy(Date sfyfy) {
		this.sfyfy = sfyfy;
	}

	public String getSfyrs() {
		return sfyrs;
	}

	public void setSfyrs(String sfyrs) {
		this.sfyrs = sfyrs;
	}

	public Date getBsfyrsfz() {
		return bsfyrsfz;
	}

	public void setBsfyrsfz(Date bsfyrsfz) {
		this.bsfyrsfz = bsfyrsfz;
	}
    
    
    
    
    
    
}