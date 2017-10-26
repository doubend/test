package com.cloud.icenter.yyzx.cstz.pojo;

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
* @author zhucy 
* @version 2017年4月17日 下午2:04:06 
* 城市体征>体征指数数据表
*/
@Entity
@Table(name = "t_cstz_tzzssj")
public class CstzTzzssjPojo extends Pojo{
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 32)
    private  String id;  
	
	@Column(name = "tz_id")
	private String tzId;
	
	@Column(name = "tzz")
	private BigDecimal tzz;
	
	@Column(name = "tzzk")
	private String tzzk;
	
	/**
	 * 数据时间
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "data_time")
	private Date dataTime;
	
	/**
	 * 创建时间
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "create_time", length = 19)
    private  Date createTime;  
    
	/**
	 * 更新时间
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "update_time", length = 19)
    private  Date updateTime;  
    
	/**
	 * 删除时间
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "delete_time", length = 19)
    private  Date deleteTime;  
    
	/**
	 * 删除状态：0正常，1删除
	 */
	@Column(name = "delete_status", length = 1)
    private  String deleteStatus;  
    
	/**
	 * 创建者
	 */
	@Column(name = "creator", length = 32)
    private  String creator;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTzId() {
		return tzId;
	}

	public void setTzId(String tzId) {
		this.tzId = tzId;
	}

	public BigDecimal getTzz() {
		return tzz;
	}

	public void setTzz(BigDecimal tzz) {
		this.tzz = tzz;
	}

	public String getTzzk() {
		return tzzk;
	}

	public void setTzzk(String tzzk) {
		this.tzzk = tzzk;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	public Date getDataTime() {
		return dataTime;
	}

	public void setDataTime(Date dataTime) {
		this.dataTime = dataTime;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	public Date getCreateTime() {
		return createTime;
	}

	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	public Date getDeleteTime() {
		return deleteTime;
	}

	public void setDeleteTime(Date deleteTime) {
		this.deleteTime = deleteTime;
	}

	public String getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(String deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}
}
