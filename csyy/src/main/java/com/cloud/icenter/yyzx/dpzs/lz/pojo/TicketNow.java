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
* Date: 2017-03-31 09:43:47
*/
@Entity
@Table(name = "t_whly_pwl_now")
public class TicketNow  extends Pojo {
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
	 * 时间段编码
	 */
	@Column(name = "sjdbm", length = 10)
    private  int sjdbm;  
    
	/**
	 * 时间段名称
	 */
	@Column(name = "sjdmc", length = 32)
    private  String sjdmc;  
    
	/**
	 * 总票务量
	 */
	@Column(name = "zpwl", length = 10)
    private  int zpwl;  
    
	/**
	 * 入园量
	 */
	@Column(name = "ryl", length = 10)
    private  int ryl;  
    
	/**
	 * 接待量
	 */
	@Column(name = "jdl", length = 10)
    private  int jdl;  
    
	/**
	 * 入园车辆
	 */
	@Column(name = "rycl", length = 10)
    private  int rycl;  
    
	/**
	 * 景区人流量
	 */
	@Column(name = "jqrll", length = 10)
    private  int jqrll;  
    
	/**
	 * 剩余车位
	 */
	@Column(name = "sycw", length = 10)
    private  int sycw;  
    
	/**
	 * 景区人流限制
	 */
	@Column(name = "jqrlxz", length = 10)
    private  int jqrlxz;  
    
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
    public void setRq (java.sql.Date rq){
        this.rq = rq;
    }
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public java.sql.Date getRq (){
        return this.rq;
    }
    public void setSjdbm (int sjdbm){
        this.sjdbm = sjdbm;
    }
    public int getSjdbm (){
        return this.sjdbm;
    }
    public void setSjdmc (String sjdmc){
        this.sjdmc = sjdmc;
    }
    public String getSjdmc (){
        return this.sjdmc;
    }
    public void setZpwl (int zpwl){
        this.zpwl = zpwl;
    }
    public int getZpwl (){
        return this.zpwl;
    }
    public void setRyl (int ryl){
        this.ryl = ryl;
    }
    public int getRyl (){
        return this.ryl;
    }
    public void setJdl (int jdl){
        this.jdl = jdl;
    }
    public int getJdl (){
        return this.jdl;
    }
    public void setRycl (int rycl){
        this.rycl = rycl;
    }
    public int getRycl (){
        return this.rycl;
    }
    public void setJqrll (int jqrll){
        this.jqrll = jqrll;
    }
    public int getJqrll (){
        return this.jqrll;
    }
    public void setSycw (int sycw){
        this.sycw = sycw;
    }
    public int getSycw (){
        return this.sycw;
    }
    public void setJqrlxz (int jqrlxz){
        this.jqrlxz = jqrlxz;
    }
    public int getJqrlxz (){
        return this.jqrlxz;
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