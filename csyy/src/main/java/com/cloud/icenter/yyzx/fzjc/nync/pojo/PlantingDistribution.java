
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
* 种植业地理分布
* Date: 2017-03-02 18:03:47
*/
@Entity
@Table(name = "t_nync_zzy_fb")
public class PlantingDistribution  extends Pojo {
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 32)
    private  String id;  
	
	/*
	 * 年份
	 */
	@Column(name = "nf", length = 4)
	private int year;
	/**
	 * 区域名称
	 */
	@Column(name = "qymc", length = 32)
    private  String qymc;  
    
	/**
	 * 区域代码
	 */
	@Column(name = "qydm", length = 10)
    private  int qydm;  
    
	/**
	 * 蔬菜面积
	 */
	@Column(name = "scmj", length = 12)
    private  float scmj;  
    
	/**
	 * 水果面积
	 */
	@Column(name = "sgmj", length = 12)
    private  float sgmj;  
    
	/**
	 * 药材面积
	 */
	@Column(name = "ycmj", length = 12)
    private  float ycmj;  
    
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
    public void setQymc (String qymc){
        this.qymc = qymc;
    }
    public String getQymc (){
        return this.qymc;
    }
    public void setQydm (int qydm){
        this.qydm = qydm;
    }
    public int getQydm (){
        return this.qydm;
    }
    public void setScmj (float scmj){
        this.scmj = scmj;
    }
    public float getScmj (){
        return this.scmj;
    }
    public void setSgmj (float sgmj){
        this.sgmj = sgmj;
    }
    public float getSgmj (){
        return this.sgmj;
    }
    public void setYcmj (float ycmj){
        this.ycmj = ycmj;
    }
    public float getYcmj (){
        return this.ycmj;
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