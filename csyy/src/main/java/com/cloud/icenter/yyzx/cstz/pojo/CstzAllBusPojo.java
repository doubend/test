package com.cloud.icenter.yyzx.cstz.pojo;

import java.math.BigDecimal;
import java.util.List;

/**
 * 城市体征自定义实体类
 * @author whcai
 *
 */
public class CstzAllBusPojo implements Comparable<CstzAllBusPojo>{

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
		this.tzz = tzz.doubleValue();
	}
	
	public Double getQz(){
		return this.qz;
	}
	public void setQz(BigDecimal qz){
		this.qz = qz.doubleValue();
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
	//按属性字段排序(降序)
    @Override
    public int compareTo(CstzAllBusPojo m) {
        // 只能对一个字段做比较，如果做整个对象的比较就实现不了按指定字段排序了。
    	if(this.getQz() > m.getQz()){
    		return -1;
    	}else if(this.getQz() < m.getQz()){
    		return 1;
    	}else{
    		return 0;
    	}
    }
}
