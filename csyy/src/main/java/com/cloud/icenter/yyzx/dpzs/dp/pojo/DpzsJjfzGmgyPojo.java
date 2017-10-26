package com.cloud.icenter.yyzx.dpzs.dp.pojo;

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
* @version 2017年4月11日 下午1:35:52 
* 大屏展示经济发展>规模以上工业增加值及增速
*/
@Entity
@Table(name = "t_dpzs_jjfz_gmgy")
public class DpzsJjfzGmgyPojo extends Pojo{
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 32)
	private String id;
	
	@Column(name = "year")
	private Integer year;
	
	@Column(name ="zjz")
	private BigDecimal zjz;
	
	@Column(name = "zs")
	private BigDecimal zs;
	
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

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public BigDecimal getZjz() {
		return zjz;
	}

	public void setZjz(BigDecimal zjz) {
		this.zjz = zjz;
	}

	public BigDecimal getZs() {
		return zs;
	}

	public void setZs(BigDecimal zs) {
		this.zs = zs;
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
