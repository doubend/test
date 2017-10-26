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
* Created with gender.
* @author: yuhaitao
* Date: 2017-03-20 15:56:00
*/
@Entity
@Table(name = "t_nync_xmy_cp")
public class AnimalProduct  extends Pojo {
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 19)
    private  String id;  
    
	/**
	 * 年份
	 */
	@Column(name = "nf", length = 10)
    private  int year;  
    
	/**
	 * 单位
	 */
	@Column(name = "lb", length = 10)
    private  int lb;  
    
	/**
	 * 产品名称
	 */
	@Column(name = "cpmc", length = 32)
    private  String name;  
    
	/**
	 * 单价
	 */
	@Column(name = "cpjg", length = 8)
    private  int price;  
    
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
    private  String creatorId;  
    

    public void setId (String id){
        this.id = id;
    }
    public String getId (){
        return this.id;
    }
    public void setNf (int nf){
        this.year = nf;
    }
    public int getNf (){
        return this.year;
    }
    public void setLb (int lb){
        this.lb = lb;
    }
    public int getLb (){
        return this.lb;
    }
    public void setCpmc (String cpmc){
        this.name = cpmc;
    }
    public String getCpmc (){
        return this.name;
    }
    public void setCpjg (int cpjg){
        this.price = cpjg;
    }
    public int getCpjg (){
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
    public void setCreatorId (String creatorId){
        this.creatorId = creatorId;
    }
    public String getCreatorId (){
        return this.creatorId;
    }
}