
package com.cloud.icenter.yyzx.cszc.tjfx.pojo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.cloud.icenter.base.pojo.Pojo;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
* Created with gender.
* @author: liyao
* Date: 2017-04-19 14:27:14
*/
@Entity
@Table(name = "t_cszc_xsjl")
public class RepairInfo  extends Pojo {
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 32)
    private  String id;  
    
	/**
	 * 部件标识码
	 */
	@Column(name = "bjbsm", length = 32)
    private  String bjbsm;  
    
	/**
	 * 
	 */
	@Column(name = "dm", length = 32)
    private  String dm;  
    
	/**
	 * 养护单位
	 */
	@Column(name = "yhdw", length = 32)
    private  String yhdw;  
    
	/**
	 * 责任人
	 */
	@Column(name = "zrr", length = 32)
    private  String zrr;  
    
	/**
	 * 开始时间
	 */
	@Column(name = "start_time", length = 19)
    private  java.sql.Timestamp startTime;  
    
	/**
	 * 结束时间
	 */
	@Column(name = "end_time", length = 19)
    private  java.sql.Timestamp endTime;  
    
	/**
	 * 报修原因[破损;丢失;占用]
	 */
	@Column(name = "bxyy", length = 32)
    private  String bxyy;  
    
	/**
	 * 养护类型
	 */
	@Column(name = "yhlx", length = 32)
    private  String yhlx;  
    
	/**
	 * 备注
	 */
	@Column(name = "remarks", length = 32)
    private  String remarks;  
    
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
	 * 删除时间
	 */
	@Column(name = "delete_time", length = 19)
    private  java.sql.Timestamp deleteTime;  
    
	/**
	 * 状态
	 */
	@Column(name = "delete_status", length = 1)
    private  String deleteStatus;  
    
	/**
	 * 创建者
	 */
	@Column(name = "creator_id", length = 32)
    private  String creatorId;  
    

    public void setId (String id){
        this.id = id;
    }
    public String getId (){
        return this.id;
    }
    public void setBjbsm (String bjbsm){
        this.bjbsm = bjbsm;
    }
    public String getBjbsm (){
        return this.bjbsm;
    }
    public void setDm (String dm){
        this.dm = dm;
    }
    public String getDm (){
        return this.dm;
    }
    public void setYhdw (String yhdw){
        this.yhdw = yhdw;
    }
    public String getYhdw (){
        return this.yhdw;
    }
    public void setZrr (String zrr){
        this.zrr = zrr;
    }
    public String getZrr (){
        return this.zrr;
    }
    public void setStartTime (java.sql.Timestamp startTime){
        this.startTime = startTime;
    }
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public java.sql.Timestamp getStartTime (){
        return this.startTime;
    }
    public void setEndTime (java.sql.Timestamp endTime){
        this.endTime = endTime;
    }
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public java.sql.Timestamp getEndTime (){
        return this.endTime;
    }
    public void setBxyy (String bxyy){
        this.bxyy = bxyy;
    }
    public String getBxyy (){
        return this.bxyy;
    }
    public void setYhlx (String yhlx){
        this.yhlx = yhlx;
    }
    public String getYhlx (){
        return this.yhlx;
    }
    public void setRemarks (String remarks){
        this.remarks = remarks;
    }
    public String getRemarks (){
        return this.remarks;
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