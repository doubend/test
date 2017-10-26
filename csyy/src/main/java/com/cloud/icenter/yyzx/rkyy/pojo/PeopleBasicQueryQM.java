package com.cloud.icenter.yyzx.rkyy.pojo;


import java.io.Serializable;
import java.util.Date;



public class PeopleBasicQueryQM extends PeopleBasicQuery implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    //姓名
    private String zwxm;
    
    //身份证号
    private String sfz;
    
    //性别
    private String xb;
    
    //民族
    private String mz;
    
    //出生日期
    private Date csrq;
    
    //籍贯国家（地区）
    private String gj;
    
    //籍贯省市县（区）
    private String jg;
    
    //户籍所在地
    private String hjszd;
    
    //户籍所在地代码
    private String hjszddm;
    
    //现居住地
    private String xjzd;
    
    //现住地址编号
    private String xzdzbh;
    
    //外文名字
    private String wwmz;
    
    //政治面貌
    private String zzmm;
    
    //婚姻状况
    private String hyzk;
    
    //文化程度
    private String whcd;
    
    //宗教信仰
    private String zjxy;
    
    //兵役状况
    private String byzk;
    
    //信息级别
    private String xxjb;
    
    //户籍所在省市县代码
    private String hjszdssx;
    
    //户籍所在乡镇代码
    private String hjszdjlx;
    
    //户籍所在地社区（村）
    private String hjszdsq;
    
    //联系方式
    private String lxfs;
    
    private int isRelation;
    
    private String sfzhm;
    
    public String getSfzhm() {
		return sfzhm;
	}

	public void setSfzhm(String sfzhm) {
		this.sfzhm = sfzhm;
	}

	public int getIsRelation() {
		return isRelation;
	}

	public void setIsRelation(int isRelation) {
		this.isRelation = isRelation;
	}

	/**
     * 开始时间(使用的地方：列表查询使用)
     */
    private Date kssj;
    
    /**
     * 结束时间(使用的地方：列表查询使用)
     */
    private Date jssj;
    

	

	public String getZwxm() {
		return zwxm;
	}

	public void setZwxm(String zwxm) {
		this.zwxm = zwxm;
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

	public String getMz() {
		return mz;
	}

	public void setMz(String mz) {
		this.mz = mz;
	}

	public Date getCsrq() {
		return csrq;
	}

	public void setCsrq(Date csrq) {
		this.csrq = csrq;
	}

	public String getGj() {
		return gj;
	}

	public void setGj(String gj) {
		this.gj = gj;
	}

	public String getJg() {
		return jg;
	}

	public void setJg(String jg) {
		this.jg = jg;
	}

	public String getHjszd() {
		return hjszd;
	}

	public void setHjszd(String hjszd) {
		this.hjszd = hjszd;
	}

	public String getHjszddm() {
		return hjszddm;
	}

	public void setHjszddm(String hjszddm) {
		this.hjszddm = hjszddm;
	}

	public String getXjzd() {
		return xjzd;
	}

	public void setXjzd(String xjzd) {
		this.xjzd = xjzd;
	}

	public String getXzdzbh() {
		return xzdzbh;
	}

	public void setXzdzbh(String xzdzbh) {
		this.xzdzbh = xzdzbh;
	}

	public String getWwmz() {
		return wwmz;
	}

	public void setWwmz(String wwmz) {
		this.wwmz = wwmz;
	}

	public String getZzmm() {
		return zzmm;
	}

	public void setZzmm(String zzmm) {
		this.zzmm = zzmm;
	}

	public String getHyzk() {
		return hyzk;
	}

	public void setHyzk(String hyzk) {
		this.hyzk = hyzk;
	}

	public String getWhcd() {
		return whcd;
	}

	public void setWhcd(String whcd) {
		this.whcd = whcd;
	}

	public String getZjxy() {
		return zjxy;
	}

	public void setZjxy(String zjxy) {
		this.zjxy = zjxy;
	}

	public String getByzk() {
		return byzk;
	}

	public void setByzk(String byzk) {
		this.byzk = byzk;
	}

	public String getXxjb() {
		return xxjb;
	}

	public void setXxjb(String xxjb) {
		this.xxjb = xxjb;
	}

	public Date getKssj() {
		return kssj;
	}

	public void setKssj(Date kssj) {
		this.kssj = kssj;
	}

	public Date getJssj() {
		return jssj;
	}

	public void setJssj(Date jssj) {
		this.jssj = jssj;
	}

	public String getHjszdssx() {
		return hjszdssx;
	}

	public void setHjszdssx(String hjszdssx) {
		this.hjszdssx = hjszdssx;
	}

	public String getHjszdjlx() {
		return hjszdjlx;
	}

	public void setHjszdjlx(String hjszdjlx) {
		this.hjszdjlx = hjszdjlx;
	}

	public String getHjszdsq() {
		return hjszdsq;
	}

	public void setHjszdsq(String hjszdsq) {
		this.hjszdsq = hjszdsq;
	}

	public String getLxfs() {
		return lxfs;
	}

	public void setLxfs(String lxfs) {
		this.lxfs = lxfs;
	}

	

	

	
    
    
    
}