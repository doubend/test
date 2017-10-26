package com.cloud.icenter.yyzx.cszc.tjfx.pojo;

import java.math.BigDecimal;
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
* @author: liyao
* Date: 2017-04-23 17:57:20
*/
@Entity
@Table(name = "t_cszc_jbxx")
public class BaseInfo  extends Pojo {
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 32)
    private  String id;  
    
	/**
	 * 资源名称
	 */
	@Column(name = "zymc", length = 32)
    private  String zymc;  
    
	/**
	 * 所属区域
	 */
	@Column(name = "ssqy", length = 32)
    private  String ssqy;  
    
	/**
	 * 区域代码
	 */
	@Column(name = "qydm", length = 10)
    private  int qydm;  
    
	/**
	 * 所属一级分类编号
	 */
	@Column(name = "ssyjflbh", length = 32)
    private  String ssyjflbh;  
    
	/**
	 * 所属二级分类编号
	 */
	@Column(name = "ssejflbh", length = 32)
    private  String ssejflbh;  
    
	/**
	 * 描述
	 */
	@Column(name = "ms", length = 256)
    private  String ms;  
    
	/**
	 * 启用时间
	 */
	@Column(name = "start_time", length = 10)
    private  java.sql.Date startTime;  
    
	/**
	 * 废弃时间
	 */
	@Column(name = "disabled_time", length = 10)
    private  java.sql.Date disabledTime;  
    
	/**
	 * 主管部门
	 */
	@Column(name = "zgbm", length = 32)
    private  String zgbm;  
    
	/**
	 * 部门编码
	 */
	@Column(name = "zgbmbh", length = 10)
    private  int zgbmbh;  
    
	/**
	 * 权属单位
	 */
	@Column(name = "qsdw", length = 32)
    private  String qsdw;  
    
	/**
	 * 养护单位
	 */
	@Column(name = "yhdw", length = 32)
    private  String yhdw;  
    
	/**
	 * 所属路段
	 */
	@Column(name = "ssld", length = 32)
    private  String ssld;  
    
	/**
	 * 地址
	 */
	@Column(name = "dz", length = 32)
    private  String dz;  
    
	/**
	 * X坐标
	 */
	@Column(name = "X", length = 11)
    private  Double x;  
    
	/**
	 * Y坐标
	 */
	@Column(name = "Y", length = 11)
    private  Double y;  
    
	/**
	 * 状态名称[完好;破损;丢失;占用]
	 */
	@Column(name = "ztmc", length = 32)
    private  String ztmc;  
    
	/**
	 * 状态代码[1;2;3;4]
	 */
	@Column(name = "ztdm", length = 10)
    private  int ztdm;  
    
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
    public void setZymc (String zymc){
        this.zymc = zymc;
    }
    public String getZymc (){
        return this.zymc;
    }
    public void setSsqy (String ssqy){
        this.ssqy = ssqy;
    }
    public String getSsqy (){
        return this.ssqy;
    }
    public void setQydm (int qydm){
        this.qydm = qydm;
    }
    public int getQydm (){
        return this.qydm;
    }
    public void setSsyjflbh (String ssyjflbh){
        this.ssyjflbh = ssyjflbh;
    }
    public String getSsyjflbh (){
        return this.ssyjflbh;
    }
    public void setSsejflbh (String ssejflbh){
        this.ssejflbh = ssejflbh;
    }
    public String getSsejflbh (){
        return this.ssejflbh;
    }
    public void setMs (String ms){
        this.ms = ms;
    }
    public String getMs (){
        return this.ms;
    }
    public void setStartTime (java.sql.Date startTime){
        this.startTime = startTime;
    }
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public java.sql.Date getStartTime (){
        return this.startTime;
    }
    public void setDisabledTime (java.sql.Date disabledTime){
        this.disabledTime = disabledTime;
    }
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public java.sql.Date getDisabledTime (){
        return this.disabledTime;
    }
    public void setZgbm (String zgbm){
        this.zgbm = zgbm;
    }
    public String getZgbm (){
        return this.zgbm;
    }
    public void setZgbmbh (int zgbmbh){
        this.zgbmbh = zgbmbh;
    }
    public int getZgbmbh (){
        return this.zgbmbh;
    }
    public void setQsdw (String qsdw){
        this.qsdw = qsdw;
    }
    public String getQsdw (){
        return this.qsdw;
    }
    public void setYhdw (String yhdw){
        this.yhdw = yhdw;
    }
    public String getYhdw (){
        return this.yhdw;
    }
    public void setSsld (String ssld){
        this.ssld = ssld;
    }
    public String getSsld (){
        return this.ssld;
    }
    public void setDz (String dz){
        this.dz = dz;
    }
    public String getDz (){
        return this.dz;
    }
    public void setX (BigDecimal x){
        this.x = x.doubleValue();
    }
    public Double getX (){
        return this.x;
    }
    public void setY (BigDecimal y){
        this.y = y.doubleValue();
    }
    public Double getY (){
        return this.y;
    }
    public void setZtmc (String ztmc){
        this.ztmc = ztmc;
    }
    public String getZtmc (){
        return this.ztmc;
    }
    public void setZtdm (int ztdm){
        this.ztdm = ztdm;
    }
    public int getZtdm (){
        return this.ztdm;
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