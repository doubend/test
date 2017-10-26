package com.cloud.icenter.yyzx.cszc.zygl.pojo;

import java.math.BigDecimal;
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

/** 
* @author zhucy 
* @version 2017年3月21日 下午1:33:07 
* 说明 
*/
@ExcelObject(true)
@Entity
@Table(name = "t_cszc_jbxx")
public class JbxxPojo extends Pojo{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 32)
	private String id;
	
	@ExcelField(index = "1")
	@Column(name = "zymc")
	private String zymc;
	
	@ExcelField(index = "2")
	@Column(name = "ssqy")
	private String ssqy;
	
	@Column(name = "qydm")
	private String qydm;
	
	@Column(name = "ssyjflbh")
	private String ssyjflbh;
	
	@Column(name = "ssejflbh")
	private String ssejflbh;
	
	@Column(name = "ssyjflid")
	private String ssyjflid;
	
	@Column(name = "ssejflid")
	private String ssejflid;
	
	@ExcelField(index = "3")
	@Column(name = "ms")
	private String ms;
	
	@ExcelField(index = "4",dateFormat = "yyyy/MM/dd")
	@Temporal(TemporalType.DATE)
	@Column(name = "start_time")
	private Date startTime;
	
	@ExcelField(index = "5",dateFormat = "yyyy/MM/dd")
	@Temporal(TemporalType.DATE)
	@Column(name = "disabled_time")
	private Date disabledTime;
	
	@ExcelField(index = "6")
	@Column(name = "zgbm")
	private String zgbm;
	
	@ExcelField(index = "7")
	@Column(name = "zgbmbh")
	private String zgbmbh;
	
	@ExcelField(index = "8")
	@Column(name = "qsdw")
	private String qsdw;
	
	@ExcelField(index = "9")
	@Column(name = "yhdw")
	private String yhdw;
	
	@ExcelField(index = "10")
	@Column(name = "ssld")
	private String ssld;
	
	@ExcelField(index = "11")
	@Column(name = "dz")
	private String dz;
	
	/*@Column(name = "X")
	private BigDecimal x;
	
	@Column(name = "Y")
	private BigDecimal y;*/
	
	@ExcelField(index = "12")
	@Column(name = "zblx")
	private String zblx;
	
	@ExcelField(index = "13")
	@Column(name = "zbz")
	private String zbz;
	
	@ExcelField(index = "14")
	@Column(name = "ztmc")
	private String ztmc;
	
	@Column(name = "ztdm")
	private Integer ztdm;
	
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
	@ExcelField(index = "15")
	private String errInfo;//导入错误信息
	
	public String getErrInfo() {
		return errInfo;
	}

	public void setErrInfo(String errInfo) {
		this.errInfo = errInfo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getZymc() {
		return zymc;
	}

	public void setZymc(String zymc) {
		this.zymc = zymc;
	}

	public String getSsqy() {
		return ssqy;
	}

	public void setSsqy(String ssqy) {
		this.ssqy = ssqy;
	}

	public String getQydm() {
		return qydm;
	}

	public void setQydm(String qydm) {
		this.qydm = qydm;
	}

	public String getSsyjflbh() {
		return ssyjflbh;
	}

	public void setSsyjflbh(String ssyjflbh) {
		this.ssyjflbh = ssyjflbh;
	}

	public String getSsejflbh() {
		return ssejflbh;
	}

	public void setSsejflbh(String ssejflbh) {
		this.ssejflbh = ssejflbh;
	}

	public String getMs() {
		return ms;
	}

	public void setMs(String ms) {
		this.ms = ms;
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
	public Date getDisabledTime() {
		return disabledTime;
	}

	public void setDisabledTime(Date disabledTime) {
		this.disabledTime = disabledTime;
	}

	public String getZgbm() {
		return zgbm;
	}

	public void setZgbm(String zgbm) {
		this.zgbm = zgbm;
	}

	public String getZgbmbh() {
		return zgbmbh;
	}

	public void setZgbmbh(String zgbmbh) {
		this.zgbmbh = zgbmbh;
	}

	public String getQsdw() {
		return qsdw;
	}

	public void setQsdw(String qsdw) {
		this.qsdw = qsdw;
	}

	public String getYhdw() {
		return yhdw;
	}

	public void setYhdw(String yhdw) {
		this.yhdw = yhdw;
	}

	public String getSsld() {
		return ssld;
	}

	public void setSsld(String ssld) {
		this.ssld = ssld;
	}

	public String getDz() {
		return dz;
	}

	public void setDz(String dz) {
		this.dz = dz;
	}

//	public BigDecimal getX() {
//		return x;
//	}
//
//	public void setX(BigDecimal x) {
//		this.x = x;
//	}
//
//	public BigDecimal getY() {
//		return y;
//	}
//
//	public void setY(BigDecimal y) {
//		this.y = y;
//	}
	
	public String getZblx() {
		return zblx;
	}

	public void setZblx(String zblx) {
		this.zblx = zblx;
	}

	public String getZbz() {
		return zbz;
	}

	public void setZbz(String zbz) {
		this.zbz = zbz;
	}

	public String getZtmc() {
		return ztmc;
	}

	public void setZtmc(String ztmc) {
		this.ztmc = ztmc;
	}

	public Integer getZtdm() {
		return ztdm;
	}

	public void setZtdm(Integer ztdm) {
		this.ztdm = ztdm;
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

	public String getSsyjflid() {
		return ssyjflid;
	}

	public void setSsyjflid(String ssyjflid) {
		this.ssyjflid = ssyjflid;
	}

	public String getSsejflid() {
		return ssejflid;
	}

	public void setSsejflid(String ssejflid) {
		this.ssejflid = ssejflid;
	}
	
}
