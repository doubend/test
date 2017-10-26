package com.cloud.icenter.yyzx.cstz.pojo;

import java.math.BigDecimal;
import java.util.List;

/**
 * 城市体征自定义实体类
 * @author whcai
 *
 */
public class ZbphPojo{
	
	/**
	 * 体征ID
	 */
	private String tzID; 
	
	/**
	 * 体征名称
	 */
	private String tzmc;
	
	/**
	 * 体征值
	 */
	private BigDecimal tzz;
	
	/**
	 * 体征状况
	 */
	private String tzzk;
	
	/**
	 * 权重
	 */
	private BigDecimal qz;
	
	/**
	 * 体征贡献值
	 */
	private BigDecimal gx;
	
	/**
	 * 显示顺序
	 */
	private Integer xssx;
	
	/**
	 * 业务指标数据
	 */
	private String ywzbsj;
	
	/**
	 * 数据单位
	 */
	private String sjdw;
	
	/**
	 * 阈值
	 */
	private String yz;
	
	/**
	 * 最优值标识
	 */
	private Integer zyzbs;
	
	/**
	 * 指标阈值
	 */
	private List<String> zbyz;
	
	/**
	 * 历史体征
	 */
	private List<String> lstz;
	
	/**
	 * x轴
	 */
	private List<String> x;
	
	private String ywtzID;
	
	public String getYwtzID() {
		return ywtzID;
	}
	public void setYwtzID(String ywtzID) {
		this.ywtzID = ywtzID;
	}
	public String getTzID(){
		return this.tzID;
	}
	public void setTzID(String tzID){
		this.tzID = tzID;
	}
	
	public String getTzmc(){
		return this.tzmc;
	}
	public void setTzmc(String tzmc){
		this.tzmc = tzmc;
	}
	
	
	
	public BigDecimal getTzz() {
		return tzz;
	}
	public void setTzz(BigDecimal tzz) {
		this.tzz = tzz;
	}
	public BigDecimal getQz() {
		return qz;
	}
	public void setQz(BigDecimal qz) {
		this.qz = qz;
	}
	public BigDecimal getGx() {
		return gx;
	}
	public void setGx(BigDecimal gx) {
		this.gx = gx;
	}
	public void setXssx(Integer xssx) {
		this.xssx = xssx;
	}
	public Integer getXssx() {
		return xssx;
	}
	
	public String getTzzk(){
		return this.tzzk;
	}
	public void setTzzk(String tzzk){
		this.tzzk = tzzk;
	}
	
	public String getYwzbsj(){
		return this.ywzbsj;
	}
	public void setYwzbsj(String ywzbsj){
		this.ywzbsj = ywzbsj;
	}
	
	public String getSjdw(){
		return this.sjdw;
	}
	public void setSjdw(String sjdw){
		this.sjdw = sjdw;
	}
	
	public String getYz(){
		return this.yz;
	}
	public void setYz(String yz){
		this.yz = yz;
	}
	
	public Integer getZyzbs(){
		return this.zyzbs;
	}
	public void setZyzbs(Integer zyzbs){
		this.zyzbs = zyzbs;
	}
	
	public List<String> getZbyz(){
		return this.zbyz;
	}
	public void setZbyz(List<String> zbyz){
		this.zbyz = zbyz;
	}
	
	public List<String> getLstz(){
		return this.lstz;
	}
	public void setLstz(List<String> lstz){
		this.lstz = lstz;
	}
	public List<String> getX() {
		return x;
	}
	public void setX(List<String> x) {
		this.x = x;
	}
}
