package com.cloud.icenter.yyzx.cszc.dtzs.pojo;

import java.math.BigDecimal;

import com.cloud.icenter.base.pojo.Pojo;

/**
 * 城市资产基本信息自定义类
 * @author whcai
 *
 */
public class CszcInfoPojo extends Pojo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 序号
	 */
	private Integer xh;

	/**
	 * 部件标识码
	 */
	private String objID;
	
	/**
	 * 资源名称
	 */
	private String zymc;
	
	/**
	 * 所属区县
	 */
	private String ssqy;
	
	/**
	 * 经度
	 */
	private Double x;
	
	/**
	 * 纬度
	 */
	private Double y;
	
	/**
	 * 坐标类型 :  1:点 2:线 3:面
	 */
	private String zblx;
	
	/**
	 * 坐标组    点: X,Y; 线：X,Y;X,Y; 面：X,Y;X,Y;X,Y;
	 */
	private String zbz;
	
	/**
	 * 资源状态[完好;破损;丢失;占用]
	 */
	private String ztmc;
	
	/**
	 * 资产名称
	 */
	private String zcmc;

	
	public String getObjID() {
		return objID;
	}

	public void setObjID(String objID) {
		this.objID = objID;
	}

	public String getZymc() {
		return zymc;
	}

	public void setZymc(String zymc) {
		this.zymc = zymc;
	}

	public String getSsqy() {
		return ssqy;
	}

	public void setSsqy(String ssqy) {
		this.ssqy = ssqy;
	}

	public String getZtmc() {
		return ztmc;
	}

	public void setZtmc(String ztmc) {
		this.ztmc = ztmc;
	}

	public Double getX() {
		return x;
	}

	public void setX(BigDecimal x) {
		this.x = x.doubleValue();
	}

	public Double getY() {
		return y;
	}

	public void setY(BigDecimal y) {
		this.y = y.doubleValue();
	}

	public String getZcmc() {
		return zcmc;
	}

	public void setZcmc(String zcmc) {
		this.zcmc = zcmc;
	}

	public Integer getXh() {
		return xh;
	}

	public void setXh(Integer xh) {
		this.xh = xh;
	}
	
	public String getZblx() {
		return zblx;
	}

	public void setZblx(String zblx) {
		this.zblx = zblx;
	}

	public String getZbz() {
		return zbz;
	}

	public void setZbz(String zbz) {
		this.zbz = zbz;
	}
}
