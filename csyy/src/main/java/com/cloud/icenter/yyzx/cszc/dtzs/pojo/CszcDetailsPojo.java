package com.cloud.icenter.yyzx.cszc.dtzs.pojo;

import com.cloud.icenter.base.pojo.Pojo;

/**
 * 城市资产详情列表
 * @author whcai
 *
 */
public class CszcDetailsPojo extends Pojo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 序号
	 */
	private Integer xh;
	
	/**
	 * 资源编码(基本信息表id)
	 */
	private String zybm;
	
	/**
	 * 资源名称
	 */
	private String zymc;
	
	/**
	 * 类别
	 */
	private String zylb;
	
	/**
	 * 类别代码
	 */
	private String lbdm;
	
	/**
	 * 投入使用时间
	 */
	private java.sql.Date trsysj;
	
	/**
	 * 所属单位
	 */
	private String ssdw;
	
	/**
	 * 地址
	 */
	private String dz;
	
	/**
	 * 状态
	 */
	private String zt;
	
	/**
	 * 备注
	 */
	private String bz;

	public Integer getXh() {
		return xh;
	}

	public void setXh(Integer xh) {
		this.xh = xh;
	}

	public String getZybm() {
		return zybm;
	}

	public void setZybm(String zybm) {
		this.zybm = zybm;
	}

	public String getZymc() {
		return zymc;
	}

	public void setZymc(String zymc) {
		this.zymc = zymc;
	}

	public String getZylb() {
		return zylb;
	}

	public void setZylb(String zylb) {
		this.zylb = zylb;
	}

	public String getLbdm() {
		return lbdm;
	}

	public void setLbdm(String lbdm) {
		this.lbdm = lbdm;
	}

	public java.sql.Date getTrsysj() {
		return trsysj;
	}

	public void setTrsysj(java.sql.Date trsysj) {
		this.trsysj = trsysj;
	}

	public String getSsdw() {
		return ssdw;
	}

	public void setSsdw(String ssdw) {
		this.ssdw = ssdw;
	}

	public String getDz() {
		return dz;
	}

	public void setDz(String dz) {
		this.dz = dz;
	}

	public String getZt() {
		return zt;
	}

	public void setZt(String zt) {
		this.zt = zt;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

}
