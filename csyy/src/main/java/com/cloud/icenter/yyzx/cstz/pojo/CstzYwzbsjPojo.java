package com.cloud.icenter.yyzx.cstz.pojo;

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
* @version 2017年4月17日 下午1:56:47 
* 城市体征>业务指标数据表
*/
@Entity
@Table(name = "t_cstz_ywzbsj")
public class CstzYwzbsjPojo extends Pojo{
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 32)
    private  String id;  
	
	/**
	 * 业务指标表主键ID
	 */
	@Column(name = "ywzb_id", length = 32)
	private String ywzbId;
	
	/**
	 * 业务指标数据值
	 */
	@Column(name = "ywzbsj", length = 32)
	private String ywzbsj;
	
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

	public String getYwzbId() {
		return ywzbId;
	}

	public void setYwzbId(String ywzbId) {
		this.ywzbId = ywzbId;
	}

	public String getYwzbsj() {
		return ywzbsj;
	}

	public void setYwzbsj(String ywzbsj) {
		this.ywzbsj = ywzbsj;
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
