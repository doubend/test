package com.cloud.icenter.yyzx.dpzs.lz.pojo;

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
* Date: 2017-03-31 09:42:47
*/
@Entity
@Table(name = "t_zwfw_sx_detail")
public class GovernmentService  extends Pojo {
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 32)
    private  String id;  
    
	/**
	 * 日期
	 */
	@Column(name = "rq", length = 10)
    private  java.sql.Date rq;  
    
	/**
	 * 事项名称
	 */
	@Column(name = "sxmc", length = 64)
    private  String sxmc;  
    
	/**
	 * 办理状态
	 */
	@Column(name = "blzt", length = 32)
    private  String blzt;  
    
	/**
	 * 所属类别
	 */
	@Column(name = "sslb", length = 32)
    private  String sslb;  
    
	/**
	 * 所属部门
	 */
	@Column(name = "ssbm", length = 32)
    private  String ssbm;  
    
	/**
	 * 可否在线办理
	 */
	@Column(name = "kfzxbl", length = 1)
    private  String kfzxbl;  
    
	/**
	 * 是否子项
	 */
	@Column(name = "sfzx", length = 1)
    private  String sfzx;  
    
	/**
	 * 事项名称代码
	 */
	@Column(name = "sxmcdm", length = 10)
    private  int sxmcdm;  
    
	/**
	 * 办理状态代码
	 */
	@Column(name = "blztdm", length = 10)
    private  int blztdm;  
    
	/**
	 * 所属类别代码
	 */
	@Column(name = "sslbdm", length = 10)
    private  int sslbdm;  
    
	/**
	 * 所属部门代码
	 */
	@Column(name = "ssbmdm", length = 10)
    private  int ssbmdm;  
    
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
	@Column(name = "creator", length = 8)
    private  String creator;  
    

    public void setId (String id){
        this.id = id;
    }
    public String getId (){
        return this.id;
    }
    public void setRq (java.sql.Date rq){
        this.rq = rq;
    }
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public java.sql.Date getRq (){
        return this.rq;
    }
    public void setSxmc (String sxmc){
        this.sxmc = sxmc;
    }
    public String getSxmc (){
        return this.sxmc;
    }
    public void setBlzt (String blzt){
        this.blzt = blzt;
    }
    public String getBlzt (){
        return this.blzt;
    }
    public void setSslb (String sslb){
        this.sslb = sslb;
    }
    public String getSslb (){
        return this.sslb;
    }
    public void setSsbm (String ssbm){
        this.ssbm = ssbm;
    }
    public String getSsbm (){
        return this.ssbm;
    }
    public void setKfzxbl (String kfzxbl){
        this.kfzxbl = kfzxbl;
    }
    public String getKfzxbl (){
        return this.kfzxbl;
    }
    public void setSfzx (String sfzx){
        this.sfzx = sfzx;
    }
    public String getSfzx (){
        return this.sfzx;
    }
    public void setSxmcdm (int sxmcdm){
        this.sxmcdm = sxmcdm;
    }
    public int getSxmcdm (){
        return this.sxmcdm;
    }
    public void setBlztdm (int blztdm){
        this.blztdm = blztdm;
    }
    public int getBlztdm (){
        return this.blztdm;
    }
    public void setSslbdm (int sslbdm){
        this.sslbdm = sslbdm;
    }
    public int getSslbdm (){
        return this.sslbdm;
    }
    public void setSsbmdm (int ssbmdm){
        this.ssbmdm = ssbmdm;
    }
    public int getSsbmdm (){
        return this.ssbmdm;
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