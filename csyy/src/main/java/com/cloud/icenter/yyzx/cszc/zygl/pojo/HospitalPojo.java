package com.cloud.icenter.yyzx.cszc.zygl.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import com.cloud.icenter.base.pojo.Pojo;
import com.cloud.icenter.yyzx.common.util.excel.annotation.ExcelField;
import com.cloud.icenter.yyzx.common.util.excel.annotation.ExcelObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/** 
* @author zhucy 
* @version 2017年3月21日 下午2:29:41 
* 医院历史信息
*/
@ExcelObject(true)
@Entity
@Table(name = "t_cszc_yylsxx")
public class HospitalPojo extends Pojo{

	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 32)
	private String id;
	
	@Column(name = "bjbsm")
	private String bjbsm;
	
	@ExcelField(index="1")
	@Column(name = "nf")
	private Integer nf;
	
	@ExcelField(index="2")
	@Column(name = "yymc")
	private String yymc;
	
	@ExcelField(index="3")
	@Column(name = "yylb")
	private String yylb;
	
	@ExcelField(index="4")
	@Column(name = "yydj")
	private String yydj;
	
	@ExcelField(index="5")
	@Column(name = "yhrysl")
	private Integer yhrysl;
	
	@ExcelField(index="6")
	@Column(name = "cws")
	private Integer cws;
	
	@ExcelField(index="7")
	@Column(name = "jzl")
	private Integer jzl;
	
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
	
	@Transient
	private String zymc;
	
	public String getZymc() {
		return zymc;
	}

	public void setZymc(String zymc) {
		this.zymc = zymc;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBjbsm() {
		return bjbsm;
	}

	public void setBjbsm(String bjbsm) {
		this.bjbsm = bjbsm;
	}

	public Integer getNf() {
		return nf;
	}

	public void setNf(Integer nf) {
		this.nf = nf;
	}

	public String getYymc() {
		return yymc;
	}

	public void setYymc(String yymc) {
		this.yymc = yymc;
	}

	public String getYylb() {
		return yylb;
	}

	public void setYylb(String yylb) {
		this.yylb = yylb;
	}

	public String getYydj() {
		return yydj;
	}

	public void setYydj(String yydj) {
		this.yydj = yydj;
	}

	public Integer getYhrysl() {
		return yhrysl;
	}

	public void setYhrysl(Integer yhrysl) {
		this.yhrysl = yhrysl;
	}

	public Integer getCws() {
		return cws;
	}

	public void setCws(Integer cws) {
		this.cws = cws;
	}

	public Integer getJzl() {
		return jzl;
	}

	public void setJzl(Integer jzl) {
		this.jzl = jzl;
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
