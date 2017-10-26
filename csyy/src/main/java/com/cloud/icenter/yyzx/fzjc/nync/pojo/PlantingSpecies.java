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
* Date: 2017-06-20 11:48:22
*/
@Entity
@Table(name = "t_nync_zzy_lb")
public class PlantingSpecies  extends Pojo {
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 32)
    private  String id;  
    
	/**
	 * 区域
	 */
	@Column(name = "qy", length = 255)
    private  String qy;  
    
	/**
	 * 年份
	 */
	@Column(name = "nf", length = 10)
    private  int nf;  
    
	/**
	 * 种类代码
	 */
	@Column(name = "zldm", length = 10)
    private  int zldm;  
    
	/**
	 * 名称
	 */
	@Column(name = "zlmc", length = 32)
    private  String zlmc;  
    
	/**
	 * 面积
	 */
	@Column(name = "mj", length = 16)
    private  int mj;  
    
	/**
	 * 产量
	 */
	@Column(name = "cl", length = 11)
    private  int cl;  
    
	/**
	 * 面积增量
	 */
	@Column(name = "mjzl", length = 10)
    private  int mjzl;  
    
	/**
	 * 产量增量
	 */
	@Column(name = "clzl", length = 10)
    private  int clzl;  
    
	/**
	 * 
	 */
	@Column(name = "dj", length = 8)
    private  int dj;  
    
	/**
	 * 产值
	 */
	@Column(name = "cz", length = 11)
    private  int cz;  
    
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
    public void setQy (String qy){
        this.qy = qy;
    }
    public String getQy (){
        return this.qy;
    }
    public void setNf (int nf){
        this.nf = nf;
    }
    public int getNf (){
        return this.nf;
    }
    public void setZldm (int zldm){
        this.zldm = zldm;
    }
    public int getZldm (){
        return this.zldm;
    }
    public void setZlmc (String zlmc){
        this.zlmc = zlmc;
    }
    public String getZlmc (){
        return this.zlmc;
    }
    public void setMj (int mj){
        this.mj = mj;
    }
    public int getMj (){
        return this.mj;
    }
    public void setCl (int cl){
        this.cl = cl;
    }
    public int getCl (){
        return this.cl;
    }
    public void setMjzl (int mjzl){
        this.mjzl = mjzl;
    }
    public int getMjzl (){
        return this.mjzl;
    }
    public void setClzl (int clzl){
        this.clzl = clzl;
    }
    public int getClzl (){
        return this.clzl;
    }
    public void setDj (int dj){
        this.dj = dj;
    }
    public int getDj (){
        return this.dj;
    }
    public void setCz (int cz){
        this.cz = cz;
    }
    public int getCz (){
        return this.cz;
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