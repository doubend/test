package com.cloud.icenter.yyzx.fzjc.whly.pojo;

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
* Created with gender.
* @author: yaoli
* Date: 2017-03-16 14:38:45
*/
@Entity
@Table(name = "t_whly_spl")
public class MonthTourist  extends Pojo {
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 32)
    private  String id;  
    
	/**
	 * 年份
	 */
	@Column(name = "nf", length = 10)
    private  int nf;  
    
	/**
	 * 月份
	 */
	@Column(name = "yf", length = 10)
    private  int yf;  
    
	/**
	 * 售票量
	 */
	@Column(name = "spl", length = 10)
    private  int spl;  
    
	/**
	 * 同比增长率
	 */
	@Column(name = "tbzzl", length = 8)
    private  double tbzzl;  
    
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
    public void setNf (int nf){
        this.nf = nf;
    }
    public int getNf (){
        return this.nf;
    }
    public void setYf (int yf){
        this.yf = yf;
    }
    public int getYf (){
        return this.yf;
    }
    public void setSpl (int spl){
        this.spl = spl;
    }
    public int getSpl (){
        return this.spl;
    }
    public void setTbzzl (double tbzzl){
        this.tbzzl = tbzzl;
    }
    public double getTbzzl (){
        return this.tbzzl;
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