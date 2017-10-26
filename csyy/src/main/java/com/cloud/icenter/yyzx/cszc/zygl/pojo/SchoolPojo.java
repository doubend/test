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
* @version 2017年3月21日 下午2:07:30 
* 说明 
*/
@ExcelObject(true)
@Entity
@Table(name = "t_cszc_xxlsxx")
public class SchoolPojo extends Pojo{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 32)
	private String id;
	
	@Column(name = "bjbsm")
	private String bjbsm;
	
	@ExcelField(index = "1")
	@Column(name = "xxmc")
	private String xxmc;
	
	@ExcelField(index = "2")
	@Column(name = "xxlx")
	private String xxlx;
	
	@ExcelField(index = "3")
	@Column(name = "cssl")
	private Integer cssl;
	
	@ExcelField(index = "4")
	@Column(name = "jssl")
	private Integer jssl;
	
	@ExcelField(index = "5")
	@Column(name = "zsrs")
	private Integer zsrs;
	
	@ExcelField(index = "6")
	@Column(name = "zsnf")
	private Integer zsnf;
	
	@ExcelField(index = "7")
	@Column(name = "bdsys")
	private Integer bdsys;
	
	@ExcelField(index = "8")
	@Column(name = "wdsys")
	private Integer wdsys;
	
	@ExcelField(index = "9")
	@Column(name = "sylrd")
	private String sylrd;
	
	@ExcelField(index = "10")
	@Column(name = "jyzjtr")
	private Float jyzjtr;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "create_time")
	private Date createTime;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "update_time")
	private Date updateTime;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "delete_time")
	private Date deleteTime;
	
	@Column(name = "delete_status", length = 1)
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

	public String getXxmc() {
		return xxmc;
	}

	public void setXxmc(String xxmc) {
		this.xxmc = xxmc;
	}

	public String getXxlx() {
		return xxlx;
	}

	public void setXxlx(String xxlx) {
		this.xxlx = xxlx;
	}

	public Integer getCssl() {
		return cssl;
	}

	public void setCssl(Integer cssl) {
		this.cssl = cssl;
	}

	public Integer getJssl() {
		return jssl;
	}

	public void setJssl(Integer jssl) {
		this.jssl = jssl;
	}

	public Integer getZsrs() {
		return zsrs;
	}

	public void setZsrs(Integer zsrs) {
		this.zsrs = zsrs;
	}

	public Integer getZsnf() {
		return zsnf;
	}

	public void setZsnf(Integer zsnf) {
		this.zsnf = zsnf;
	}

	public Integer getBdsys() {
		return bdsys;
	}

	public void setBdsys(Integer bdsys) {
		this.bdsys = bdsys;
	}

	public Integer getWdsys() {
		return wdsys;
	}

	public void setWdsys(Integer wdsys) {
		this.wdsys = wdsys;
	}

	public String getSylrd() {
		return sylrd;
	}

	public void setSylrd(String sylrd) {
		this.sylrd = sylrd;
	}

	public Float getJyzjtr() {
		return jyzjtr;
	}

	public void setJyzjtr(Float jyzjtr) {
		this.jyzjtr = jyzjtr;
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
