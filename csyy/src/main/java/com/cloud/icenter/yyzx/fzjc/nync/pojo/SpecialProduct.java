
package com.cloud.icenter.yyzx.fzjc.nync.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import com.cloud.icenter.base.pojo.Pojo;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
* @author: yaoli
* 特色农产品信息
* Date: 2017-03-02 18:32:42
*/
@Entity
@Table(name = "t_nync_zzy_ts")
public class SpecialProduct  extends Pojo {
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 32)
    private  String id;  
    
	/**
	 * 年份
	 */
	@Column(name = "nf", length = 4)
    private  int year;  
    
	/**
	 * 类别
	 */
	@Column(name = "lb", length = 1)
    private  int lb;  
    
	/**
	 * 产品名称
	 */
	@Column(name = "cpmc", length = 32)
    private  String name;  
    
	/**
	 * 种植面积
	 */
	@Column(name = "mj", length = 12)
    private  float area;  
    
	/**
	 * 产量
	 */
	@Column(name = "cl", length = 12)
    private  float cl;  
    
	/**
	 * 产值
	 */
	@Column(name = "cz", length = 12)
    private  float cz;  
    
	/**
	 * 专业户数量
	 */
	@Column(name = "zyhsl", length = 10)
    private  int zyhsl;  
    
	/**
	 * 散户数量
	 */
	@Column(name = "shsl", length = 10)
    private  int shsl;  
    
	/**
	 * 专业户种植面积
	 */
	@Column(name = "zyhzzmj", length = 12)
    private  float zyhzzmj;  
    
	/**
	 * 散户种植面积
	 */
	@Column(name = "shzzmj", length = 12)
    private  float shzzmj;  
    
	/**
	 * 主要销售渠道
	 */
	@Column(name = "xsqd", length = 64)
    private  String xsqd;  
    
	/**
	 * 主要销售地
	 */
	@Column(name = "xsd", length = 64)
    private  String xsd;  
    
	/**
	 * 政策投入资金
	 */
	@Column(name = "zctrzj", length = 8)
    private  int zctrzj;  
    
	/**
	 * 插入时间
	 */
	@Column(name = "create_time", length = 19)
    private  java.sql.Timestamp createTime;  
    
	/**
	 * 更新时间
	 */
	@Column(name = "update_time", length = 19)
    private  java.sql.Timestamp updateTime;  
    
	/**
	 * 移除时间
	 */
	@Column(name = "delete_time", length = 19)
    private  java.sql.Timestamp deleteTime;  
    
	/**
	 * 0正常，1删除
	 */
	@Column(name = "delete_status", length = 1)
    private  String deleteStatus;  
    
	/**
	 * 创建者
	 */
	@Column(name = "creator_id", length = 8)
    private  String creator;  
    

    public void setId (String id){
        this.id = id;
    }
    public String getId (){
        return this.id;
    }
    public void setYear (int year){
        this.year = year;
    }
    public int getYear (){
        return this.year;
    }
    public void setLb (int lb){
        this.lb = lb;
    }
    public int getLb (){
        return this.lb;
    }
    public void setName (String name){
        this.name = name;
    }
    public String getName (){
        return this.name;
    }
    public void setArea (float area){
        this.area = area;
    }
    public float getArea (){
        return this.area;
    }
    public void setCl (float cl){
        this.cl = cl;
    }
    public float getCl (){
        return this.cl;
    }
    public void setCz (float cz){
        this.cz = cz;
    }
    public float getCz (){
        return this.cz;
    }
    public void setZyhsl (int zyhsl){
        this.zyhsl = zyhsl;
    }
    public int getZyhsl (){
        return this.zyhsl;
    }
    public void setShsl (int shsl){
        this.shsl = shsl;
    }
    public int getShsl (){
        return this.shsl;
    }
    public void setZyhzzmj (float zyhzzmj){
        this.zyhzzmj = zyhzzmj;
    }
    public float getZyhzzmj (){
        return this.zyhzzmj;
    }
    public void setShzzmj (float shzzmj){
        this.shzzmj = shzzmj;
    }
    public float getShzzmj (){
        return this.shzzmj;
    }
    public void setXsqd (String xsqd){
        this.xsqd = xsqd;
    }
    public String getXsqd (){
        return this.xsqd;
    }
    public void setXsd (String xsd){
        this.xsd = xsd;
    }
    public String getXsd (){
        return this.xsd;
    }
    public void setZctrzj (int zctrzj){
        this.zctrzj = zctrzj;
    }
    public int getZctrzj (){
        return this.zctrzj;
    }
    public void setCreateTime (java.sql.Timestamp createTime){
        this.createTime = createTime;
    }
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public java.sql.Timestamp getCreateTime (){
        return this.createTime;
    }
    public void setUpdateTime (java.sql.Timestamp updateTime){
        this.updateTime = updateTime;
    }
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public java.sql.Timestamp getUpdateTime (){
        return this.updateTime;
    }
    public void setDeleteTime (java.sql.Timestamp deleteTime){
        this.deleteTime = deleteTime;
    }
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public java.sql.Timestamp getDeleteTime (){
        return this.deleteTime;
    }
    public void setDeleteStatus (String deleteStatus){
        this.deleteStatus = deleteStatus;
    }
    public String getDeleteStatus (){
        return this.deleteStatus;
    }
    public void setCreator (String creator){
        this.creator = creator;
    }
    public String getCreator (){
        return this.creator;
    }
}