package com.cloud.icenter.yyzx.cstz.pojo;

import java.math.BigDecimal;
import java.util.List;

/**
 * 城市体征自定义实体类
 * @author whcai
 *
 */
public class CstzCommonPojo implements Comparable<CstzCommonPojo>{
	
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
	private Double tzz;
	
	/**
	 * 体征状况
	 */
	private String tzzk;
	
	/**
	 * 权重
	 */
	private Double qz;
	
	/**
	 * 体征贡献值
	 */
	private Double gx;
	
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
	
	/**
	 * 数据来源
	 */
	private String sjly;
	
	/**
	 * 数据频率
	 */
	private String sjpl;
	
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
	
	public Double getTzz() {
		return this.tzz;
	}
	public void setTzz(BigDecimal tzz) {
		this.tzz = (double)(Math.round(tzz.doubleValue() * 10))/10;
	}
	
	public Double getQz(){
		return this.qz;
	}
	
	public void setQz(BigDecimal qz){
		this.qz = (double)(Math.round(qz.doubleValue() * 1000))/1000;
	}
	
	public Double getGx(){
		return this.gx;
	}
	public void setGx(Double gx){
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
	
	
	public String getSjly() {
		return sjly;
	}
	public void setSjly(String sjly) {
		this.sjly = sjly;
	}
	public String getSjpl() {
		return sjpl;
	}
	public void setSjpl(String sjpl) {
		this.sjpl = sjpl;
	}
	//按属性字段排序(升序)
    @Override
    public int compareTo(CstzCommonPojo m) {
        // 只能对一个字段做比较，如果做整个对象的比较就实现不了按指定字段排序了。
        return this.getTzz().compareTo(m.getTzz());
    }
}
