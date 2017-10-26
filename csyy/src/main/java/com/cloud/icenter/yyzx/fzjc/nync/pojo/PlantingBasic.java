
package com.cloud.icenter.yyzx.fzjc.nync.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import com.cloud.icenter.base.pojo.Pojo;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
* @author: yaoli
* 种植业基本信息
* Date: 2017-03-02 18:32:09
*/
@Entity
@Table(name = "t_nync_zzy_jbxx")
public class PlantingBasic  extends Pojo {
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 32)
    private  String id;  
    
	/**
	 * 年份
	 */
	@Column(name = "nf", length = 10)
    private  int year;  
    
	/**
	 * 种类
	 */
	@Column(name = "zldm", length = 1)
    private  int category;  
    
	/**
	 * 名称
	 */
	@Column(name = "zlmc", length = 32)
    private  String name;  
    
	/**
	 * 面积
	 */
	@Column(name = "mj", length = 12)
    private  int area;  
    
	/**
	 * 产量
	 */
	@Column(name = "cl", length = 12)
    private  int yeild;  
    
	/**
	 * 产值
	 */
	@Column(name = "cz", length = 12)
    private  int output;  
	/**
	 * 单价
	 */
	@Column(name = "dj", length = 12)
    private  float price;  
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
    public void setCategory (int category){
        this.category = category;
    }
    public int getCategory (){
        return this.category;
    }
    public void setName (String name){
        this.name = name;
    }
    public String getName (){
        return this.name;
    }
    public void setArea (int area){
        this.area = area;
    }
    public int getArea (){
        return this.area;
    }
    public void setYeild (int yeild){
        this.yeild = yeild;
    }
    public int getYeild (){
        return this.yeild;
    }
    public void setOutput (int output){
        this.output = output;
    }
    public float getOutput (){
        return this.output;
    }
    
    public void setPrice (float price){
        this.price = price;
    }
    public float getPrice (){
        return this.price;
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