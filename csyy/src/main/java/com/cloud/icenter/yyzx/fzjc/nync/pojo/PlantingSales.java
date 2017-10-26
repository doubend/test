
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
* 种植业销售情况
* Date: 2017-03-02 18:33:16
*/
@Entity
@Table(name = "t_nync_zzy_xl")
public class PlantingSales  extends Pojo {
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
	@Column(name = "zl", length = 32)
    private  String zl;  
	/**
	 * 种类编号
	 */
	@Column(name = "zlbh", length = 1)
    private  int zlbh;  
    
	/**
	 * 销售渠道
	 */
	@Column(name = "xsqd", length = 32)
    private  String xsqd;  
	/**
	 * 销售渠道编号
	 */
	@Column(name = "xsqdbh", length = 1)
    private  int xsqdbh;  
    
	/**
	 * 销售额
	 */
	@Column(name = "xse", length = 12)
    private  float xse;  
    
	/**
	 * 销售量
	 */
	@Column(name = "xsl", length = 12)
    private  float xsl;  
    
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
    public void setZl (String zl){
        this.zl = zl;
    }
    public String getZl (){
        return this.zl;
    }
    public void setZlbh (int zlbh){
        this.zlbh = zlbh;
    }
    public int getZlbh(){
        return this.zlbh;
    }
    public void setXsqd (String xsqd){
        this.xsqd = xsqd;
    }
    public String getXsqd (){
        return this.xsqd;
    }
    public void setXsqdbh (int xsqdbh){
        this.xsqdbh = xsqdbh;
    }
    public int getXsqdbh (){
        return this.xsqdbh;
    }
    public void setXse (float xse){
        this.xse = xse;
    }
    public float getXse (){
        return this.xse;
    }
    public void setXsl (float xsl){
        this.xsl = xsl;
    }
    public float getXsl (){
        return this.xsl;
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