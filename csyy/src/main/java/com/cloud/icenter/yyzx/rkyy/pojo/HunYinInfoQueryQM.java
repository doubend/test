package com.cloud.icenter.yyzx.rkyy.pojo;


import java.io.Serializable;



public class HunYinInfoQueryQM extends PeopleBasicQuery implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    //身份证号码
    private String sfz;
    
    //男方身份证号码
    private String mnfsfzhm;
    
    //女方身份证号码
    private String fnfsfzhm;
    
    //办理机关编号
    private String bljgbh;
    
    //办理机关名称
    private String bljgmc;
    
    //办理机关组织机构代码
    private String bljgzzjgdm;
    
    //统一社会信用代码
    private String tyshxydm;
    
    //业务类型代码
    private String ywlxdm;
    
    //补领婚姻登记证号码
    private String blhydjzhm;
    
    //男方证件印刷号
    private String mnfzjysh;
    
    //女方证件印刷号
    private String fnfzjysh;
    
    //男方证件证明材料
    private String Mnfzjzmcl;
    
    //女方证件证明材料
    private String fnfzjzmcl;
    
    //登记日期
    private String djrq;
    
    //新领证件登记字号/撤销决定字号
    private String zlzjdjzh;
    
    //复婚标识 
    private String fhbs;
    
    //补办结婚标识
    private String bbjhbs;
    
    //离婚原因代码
    private String lhyydm;
    
    //补领原因代码
    private String blyydm;
    
    //有效标识
    private String yxbs;
    
    //婚姻登记管理机关名称
    private String hydjgljgmc;
    
    //婚姻登记管理机关单位代码
    private String hydjgljgdwdm;
    
    //婚姻登记管理机关统一社会信用代码
    private String hydjgljgtyshxydm;

	public String getMnfsfzhm() {
		return mnfsfzhm;
	}

	public void setMnfsfzhm(String mnfsfzhm) {
		this.mnfsfzhm = mnfsfzhm;
	}

	public String getFnfsfzhm() {
		return fnfsfzhm;
	}

	public void setFnfsfzhm(String fnfsfzhm) {
		this.fnfsfzhm = fnfsfzhm;
	}

	public String getBljgbh() {
		return bljgbh;
	}

	public void setBljgbh(String bljgbh) {
		this.bljgbh = bljgbh;
	}

	public String getBljgmc() {
		return bljgmc;
	}

	public void setBljgmc(String bljgmc) {
		this.bljgmc = bljgmc;
	}

	public String getBljgzzjgdm() {
		return bljgzzjgdm;
	}

	public void setBljgzzjgdm(String bljgzzjgdm) {
		this.bljgzzjgdm = bljgzzjgdm;
	}

	public String getTyshxydm() {
		return tyshxydm;
	}

	public void setTyshxydm(String tyshxydm) {
		this.tyshxydm = tyshxydm;
	}

	public String getYwlxdm() {
		return ywlxdm;
	}

	public void setYwlxdm(String ywlxdm) {
		this.ywlxdm = ywlxdm;
	}

	public String getBlhydjzhm() {
		return blhydjzhm;
	}

	public void setBlhydjzhm(String blhydjzhm) {
		this.blhydjzhm = blhydjzhm;
	}

	public String getMnfzjysh() {
		return mnfzjysh;
	}

	public void setMnfzjysh(String mnfzjysh) {
		this.mnfzjysh = mnfzjysh;
	}

	public String getFnfzjysh() {
		return fnfzjysh;
	}

	public void setFnfzjysh(String fnfzjysh) {
		this.fnfzjysh = fnfzjysh;
	}

	public String getMnfzjzmcl() {
		return Mnfzjzmcl;
	}

	public void setMnfzjzmcl(String mnfzjzmcl) {
		Mnfzjzmcl = mnfzjzmcl;
	}

	public String getFnfzjzmcl() {
		return fnfzjzmcl;
	}

	public void setFnfzjzmcl(String fnfzjzmcl) {
		this.fnfzjzmcl = fnfzjzmcl;
	}

	public String getDjrq() {
		return djrq;
	}

	public void setDjrq(String djrq) {
		this.djrq = djrq;
	}

	public String getZlzjdjzh() {
		return zlzjdjzh;
	}

	public void setZlzjdjzh(String zlzjdjzh) {
		this.zlzjdjzh = zlzjdjzh;
	}

	public String getFhbs() {
		return fhbs;
	}

	public void setFhbs(String fhbs) {
		this.fhbs = fhbs;
	}

	public String getBbjhbs() {
		return bbjhbs;
	}

	public void setBbjhbs(String bbjhbs) {
		this.bbjhbs = bbjhbs;
	}

	public String getLhyydm() {
		return lhyydm;
	}

	public void setLhyydm(String lhyydm) {
		this.lhyydm = lhyydm;
	}

	public String getBlyydm() {
		return blyydm;
	}

	public void setBlyydm(String blyydm) {
		this.blyydm = blyydm;
	}

	public String getYxbs() {
		return yxbs;
	}

	public void setYxbs(String yxbs) {
		this.yxbs = yxbs;
	}

	public String getHydjgljgmc() {
		return hydjgljgmc;
	}

	public void setHydjgljgmc(String hydjgljgmc) {
		this.hydjgljgmc = hydjgljgmc;
	}

	public String getHydjgljgdwdm() {
		return hydjgljgdwdm;
	}

	public void setHydjgljgdwdm(String hydjgljgdwdm) {
		this.hydjgljgdwdm = hydjgljgdwdm;
	}

	public String getHydjgljgtyshxydm() {
		return hydjgljgtyshxydm;
	}

	public void setHydjgljgtyshxydm(String hydjgljgtyshxydm) {
		this.hydjgljgtyshxydm = hydjgljgtyshxydm;
	}

	public String getSfz() {
		return sfz;
	}

	public void setSfz(String sfz) {
		this.sfz = sfz;
	}

	
    
    
    
}