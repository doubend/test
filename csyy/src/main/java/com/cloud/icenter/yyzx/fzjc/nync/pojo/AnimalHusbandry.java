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
* @author: yaoli
* Date: 2017-03-08 15:37:25
*/
@Entity
@Table(name = "t_nync_xmy_jbxx")
public class AnimalHusbandry  extends Pojo {
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
	 * 类别
	 */
	@Column(name = "lb", length = 32)
    private  int lb;  
    
	/**
	 * 名称
	 */
	@Column(name = "scmc", length = 32)
    private  String name;  
    
	/**
	 * 存栏量
	 */
	@Column(name = "cunll", length = 10)
    private  float stock;  
    
	/**
	 * 出栏量
	 */
	@Column(name = "chull", length = 10)
    private  float slau;  
    
	/**
	 * 出栏率
	 */
	@Column(name = "cll", length = 12)
    private  float cll;  
    
	/**
	 * 产值
	 */
	@Column(name = "cz", length = 12)
    private  float cz;  
    
	/**
	 * 散户数量
	 */
	@Column(name = "shsl", length = 10)
    private  int shsl;  
    
	/**
	 * 散户养殖数量
	 */
	@Column(name = "sh_yzsl", length = 10)
    private  int shYzsl;  
    
	/**
	 * 养殖场数量
	 */
	@Column(name = "yzcsl", length = 10)
    private  int yzcsl;  
    
	/**
	 * 养殖场养殖数量
	 */
	@Column(name = "yzc_yzsl", length = 10)
    private  int yzcYzsl;  
    
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
    public void setStock (float stock){
        this.stock = stock;
    }
    public float getStock (){
        return this.stock;
    }
    public void setSlau (float slau){
        this.slau = slau;
    }
    public float getSlau (){
        return this.slau;
    }
    public void setCll (float cll){
        this.cll = cll;
    }
    public float getCll (){
        return this.cll;
    }
    public void setCz (float cz){
        this.cz = cz;
    }
    public float getCz (){
        return this.cz;
    }
    public void setShsl (int shsl){
        this.shsl = shsl;
    }
    public int getShsl (){
        return this.shsl;
    }
    public void setShYzsl (int shYzsl){
        this.shYzsl = shYzsl;
    }
    public int getShYzsl (){
        return this.shYzsl;
    }
    public void setYzcsl (int yzcsl){
        this.yzcsl = yzcsl;
    }
    public int getYzcsl (){
        return this.yzcsl;
    }
    public void setYzcYzsl (int yzcYzsl){
        this.yzcYzsl = yzcYzsl;
    }
    public int getYzcYzsl (){
        return this.yzcYzsl;
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