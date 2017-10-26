package com.cloud.icenter.yyzx.cszc.zygl.pojo;

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
import com.cloud.icenter.yyzx.common.util.excel.annotation.ExcelField;
import com.cloud.icenter.yyzx.common.util.excel.annotation.ExcelObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/** 
* @author zhucy 
* @version 2017年3月23日 上午10:58:47 
* 资源修缮记录
*/
@ExcelObject(true)
@Entity
@Table(name = "t_cszc_xsjl")
public class XsjlPojo extends Pojo{

	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 32)
	private String id;
	/*
	 * 部件标识码
	 */
	@Column(name = "jbxx_id")
	private String jbxxId;
	
	/*
	 * 部件编码
	 */
	@Column(name = "dm")
	private String dm;
	
	/*
	 * 养护单位
	 */
	@ExcelField(index = "1")
	@Column(name = "yhdw")
	private String yhdw;
	
	@ExcelField(index = "2")
	@Column(name = "zrr")
	private String zrr;
	
	@ExcelField(index = "3",dateFormat = "yyyy/MM/dd")
	@Temporal(TemporalType.DATE)
	@Column(name = "start_time")
	private Date startTime;
	
	@ExcelField(index = "4",dateFormat = "yyyy/MM/dd")
	@Temporal(TemporalType.DATE)
	@Column(name = "end_time")
	private Date endTime;
	
	@ExcelField(index = "5")
	@Column(name = "bxyy")
	private String bxyy;
	
	@ExcelField(index = "6")
	@Column(name = "yhlx")
	private String yhlx;
	
	@ExcelField(index = "7")
	@Column(name = "remarks")
	private String remarks;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "create_time")
	private Date createTime;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "update_time")
	private Date updateTime;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "delete_time")
	private Date deleteTime;
	
	@Column(name = "delete_status")
	private String deleteStatus;//1已删除，0正常
	
	@Column(name = "creator_id")
	private String creatorId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	

	public String getJbxxId() {
		return jbxxId;
	}

	public void setJbxxId(String jbxxId) {
		this.jbxxId = jbxxId;
	}

	public String getDm() {
		return dm;
	}
	public void setDm(String dm) {
		this.dm = dm;
	}

	public String getYhdw() {
		return yhdw;
	}

	public void setYhdw(String yhdw) {
		this.yhdw = yhdw;
	}

	public String getZrr() {
		return zrr;
	}

	public void setZrr(String zrr) {
		this.zrr = zrr;
	}
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getBxyy() {
		return bxyy;
	}

	public void setBxyy(String bxyy) {
		this.bxyy = bxyy;
	}

	public String getYhlx() {
		return yhlx;
	}

	public void setYhlx(String yhlx) {
		this.yhlx = yhlx;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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

	public String getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}
	
	
	
	
}
