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
import com.fasterxml.jackson.annotation.JsonIgnore;

/** 
* @author zhucy 
* @version 2017年3月28日 上午10:23:12 
* 大屏展示 经济发展
*/
@Entity
@Table(name = "t_dpzs_jjfz")
public class DpzsJjfzPojo extends Pojo{
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 32)
	private String id;
	
	@Column(name = "nian")
	private Integer nian;//年份
	
	@Column(name = "gdp")
	private BigDecimal gdp;//GDP总值
	
	@Column(name = "gdp_zf")
	private BigDecimal gdpZf;//GDP增幅
	
	@Column(name = "czjmrjkzpsr")
	private BigDecimal czjmrjkzpsr;//城镇居民人均可支配收入
	
	@Column(name = "czjmrjkzpsr_zf")
	private BigDecimal czjmrjkzpsrZf;//城镇居民人均可支配收入增幅
	
	@Column(name = "ncjmrjkzpsr")
	private BigDecimal ncjmrjkzpsr;//农村居民人均可支配收入
	
	@Column(name = "ncjmrjkzpsr_zf")
	private BigDecimal ncjmrjkzpsrZf;//农村居民人均可支配收入增幅
	
	@Column(name = "jrjgcke")
	private BigDecimal jrjgcke;//金融机构存款额
	
	@Column(name = "jrjgcke_zf")
	private BigDecimal jrjgckeZf;//金融机构存款额增幅
	
	@Column(name = "jrjgdke")
	private BigDecimal jrjgdke;//金融机构贷款额
	
	@Column(name = "jrjgdke_zf")
	private BigDecimal jrjgdkeZf;//金融机构贷款额增幅
	
	@Column(name = "jrjgrze")
	private BigDecimal jrjgrze;//金融机构融资额
	
	@Column(name = "jrjgrze_zf")
	private BigDecimal jrjgrzeZf;//金融机构直接融资额增幅
	
	@Column(name = "czsr")
	private BigDecimal czsr;//财政收入
	
	@Column(name = "czsr_zf")
	private BigDecimal czsrZf;//财政收入增幅
	
	@Column(name = "czzc")
	private BigDecimal czzc;//财政支出
	
	@Column(name = "czzc_zf")
	private BigDecimal czzcZf;//财政支出增幅
	
	@Column(name = "wmjk")
	private BigDecimal wmjk;//外贸进口
	
	@Column(name = "wmjk_zf")
	private BigDecimal wmjkZf;//外贸进口增幅
	
	@Column(name = "wmck")
	private BigDecimal wmck;//外贸出口
	
	@Column(name = "wmck_zf")
	private BigDecimal wmckZf;//外贸出口增幅
	
	@Column(name = "pf")
	private BigDecimal pf;//批发
	
	@Column(name = "ls")
	private BigDecimal ls;//零售
	
	@Column(name = "zs")
	private BigDecimal zs;//住宿
	
	@Column(name = "cy")
	private BigDecimal cy;//餐饮
	
	@Column(name = "cz_shxfpze")
	private BigDecimal czShxfpze;
	
	@Column(name = "nc_shxfpze")
	private BigDecimal ncShxfpze;
	
	@Column(name = "nlmy")
	private BigDecimal nlmy;//农林牧业
	
	@Column(name = "nlmy_zf")
	private BigDecimal nlmyZf;//农林牧业增幅
	
	@Column(name = "whly")
	private BigDecimal whly;//文化旅游
	
	@Column(name = "whly_zf")
	private BigDecimal whlyZf;//文化旅游增幅
	
	@Column(name = "jxzb")
	private BigDecimal jxzb;//机械装备
	
	@Column(name = "jxzb_zf")
	private BigDecimal jxzbZf;//机械装备增幅
	
	@Column(name = "xxjs")
	private BigDecimal xxjs;//信息技术
	
	@Column(name = "xxjs_zf")
	private BigDecimal xxjsZf;//信息技术增幅
	
	@Column(name = "gdzctz")
	private BigDecimal gdzctz;//固定资产投资
	
	@Column(name = "gdzctz_zf")
	private BigDecimal gdzctzZf;//固定资产投资增幅
	
	@Column(name = "yctze")
	private BigDecimal yctze;//一产投资额
	
	@Column(name = "yctze_zf")
	private BigDecimal yctzeZf;//一产投资额增幅
	
	@Column(name = "ectze")
	private BigDecimal ectze;//二产投资额
	
	@Column(name = "ectze_zf")
	private BigDecimal ectzeZf;//二产投资额增幅
	
	@Column(name = "xmtze")
	private BigDecimal xmtze;//项目投资额
	
	@Column(name = "xmtze_zf")
	private BigDecimal xmtzeZf;//项目投资额增幅
	
	@Column(name = "sctze")
	private BigDecimal sctze;//三产投资额
	
	@Column(name = "sctze_zf")
	private BigDecimal sctzeZf;//三产投资额增幅
	
	@Column(name = "fdctze")
	private BigDecimal fdctze;//房地产投资额
	
	@Column(name = "fdctze_zf")
	private BigDecimal fdctzeZf;//房地产投资额增幅
	
	@Column(name = "dycy_id")
	private String dycyId;//第一产业标识
	
	@Column(name = "decy_id")
	private String decyTd;//第二产业标识
	
	@Column(name = "dscy_id")
	private String dscyId;//第三产业标识
	
	@Column(name = "dycycz")
	private BigDecimal dycycz;
	
	@Column(name = "dycyczzf")
	private BigDecimal dycyczzf;
	
	@Column(name = "decycz")
	private BigDecimal decycz;
	
	@Column(name = "decyczzf")
	private BigDecimal decyczzf;
	
	@Column(name = "dscycz")
	private BigDecimal dscycz;
	
	@Column(name = "dscyczzf")
	private BigDecimal dscyczzf;
	
	@Column(name = "nycz")
	private BigDecimal nycz;
	
	@Column(name = "nyczzf")
	private BigDecimal nyczzf;
	
	@Column(name = "nyczzb")
	private BigDecimal nyczzb;
	
	@Column(name = "lycz")
	private BigDecimal lycz;
	
	@Column(name = "lyczzf")
	private BigDecimal lyczzf;
	
	@Column(name = "lyczzb")
	private BigDecimal lyczzb;
	
	@Column(name = "mycz")
	private BigDecimal mycz;
	
	@Column(name = "myczzf")
	private BigDecimal myczzf;
	
	@Column(name = "myczzb")
	private BigDecimal myczzb;
	
	@Column(name = "yycz")
	private BigDecimal yycz;
	
	@Column(name = "yyczzf")
	private BigDecimal yyczzf;
	
	@Column(name = "yyczzb")
	private BigDecimal yyczzb;
	
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

	public Integer getNian() {
		return nian;
	}

	public void setNian(Integer nian) {
		this.nian = nian;
	}

	public BigDecimal getGdp() {
		return gdp;
	}

	public void setGdp(BigDecimal gdp) {
		this.gdp = gdp;
	}

	public BigDecimal getGdpZf() {
		return gdpZf;
	}

	public void setGdpZf(BigDecimal gdpZf) {
		this.gdpZf = gdpZf;
	}

	public BigDecimal getCzjmrjkzpsr() {
		return czjmrjkzpsr;
	}

	public void setCzjmrjkzpsr(BigDecimal czjmrjkzpsr) {
		this.czjmrjkzpsr = czjmrjkzpsr;
	}

	public BigDecimal getCzjmrjkzpsrZf() {
		return czjmrjkzpsrZf;
	}

	public void setCzjmrjkzpsrZf(BigDecimal czjmrjkzpsrZf) {
		this.czjmrjkzpsrZf = czjmrjkzpsrZf;
	}

	public BigDecimal getJrjgcke() {
		return jrjgcke;
	}

	public void setJrjgcke(BigDecimal jrjgcke) {
		this.jrjgcke = jrjgcke;
	}

	public BigDecimal getJrjgckeZf() {
		return jrjgckeZf;
	}

	public void setJrjgckeZf(BigDecimal jrjgckeZf) {
		this.jrjgckeZf = jrjgckeZf;
	}

	public BigDecimal getJrjgdke() {
		return jrjgdke;
	}

	public void setJrjgdke(BigDecimal jrjgdke) {
		this.jrjgdke = jrjgdke;
	}

	public BigDecimal getJrjgdkeZf() {
		return jrjgdkeZf;
	}

	public void setJrjgdkeZf(BigDecimal jrjgdkeZf) {
		this.jrjgdkeZf = jrjgdkeZf;
	}

	public BigDecimal getJrjgrze() {
		return jrjgrze;
	}

	public void setJrjgrze(BigDecimal jrjgrze) {
		this.jrjgrze = jrjgrze;
	}

	public BigDecimal getJrjgrzeZf() {
		return jrjgrzeZf;
	}

	public void setJrjgrzeZf(BigDecimal jrjgrzeZf) {
		this.jrjgrzeZf = jrjgrzeZf;
	}

	public BigDecimal getCzsr() {
		return czsr;
	}

	public void setCzsr(BigDecimal czsr) {
		this.czsr = czsr;
	}

	public BigDecimal getCzsrZf() {
		return czsrZf;
	}

	public void setCzsrZf(BigDecimal czsrZf) {
		this.czsrZf = czsrZf;
	}

	public BigDecimal getCzzc() {
		return czzc;
	}

	public void setCzzc(BigDecimal czzc) {
		this.czzc = czzc;
	}

	public BigDecimal getCzzcZf() {
		return czzcZf;
	}

	public void setCzzcZf(BigDecimal czzcZf) {
		this.czzcZf = czzcZf;
	}

	public BigDecimal getWmjk() {
		return wmjk;
	}

	public void setWmjk(BigDecimal wmjk) {
		this.wmjk = wmjk;
	}

	public BigDecimal getWmjkZf() {
		return wmjkZf;
	}

	public void setWmjkZf(BigDecimal wmjkZf) {
		this.wmjkZf = wmjkZf;
	}

	public BigDecimal getWmck() {
		return wmck;
	}

	public void setWmck(BigDecimal wmck) {
		this.wmck = wmck;
	}

	public BigDecimal getWmckZf() {
		return wmckZf;
	}

	public void setWmckZf(BigDecimal wmckZf) {
		this.wmckZf = wmckZf;
	}

	public BigDecimal getPf() {
		return pf;
	}

	public void setPf(BigDecimal pf) {
		this.pf = pf;
	}

	

	public BigDecimal getZs() {
		return zs;
	}

	public void setZs(BigDecimal zs) {
		this.zs = zs;
	}


	public BigDecimal getCy() {
		return cy;
	}

	public void setCy(BigDecimal cy) {
		this.cy = cy;
	}


	public BigDecimal getCzShxfpze() {
		return czShxfpze;
	}

	public void setCzShxfpze(BigDecimal czShxfpze) {
		this.czShxfpze = czShxfpze;
	}

	public BigDecimal getNcShxfpze() {
		return ncShxfpze;
	}

	public void setNcShxfpze(BigDecimal ncShxfpze) {
		this.ncShxfpze = ncShxfpze;
	}

	public BigDecimal getNlmy() {
		return nlmy;
	}

	public void setNlmy(BigDecimal nlmy) {
		this.nlmy = nlmy;
	}

	public BigDecimal getNlmyZf() {
		return nlmyZf;
	}

	public void setNlmyZf(BigDecimal nlmyZf) {
		this.nlmyZf = nlmyZf;
	}

	public BigDecimal getWhly() {
		return whly;
	}

	public void setWhly(BigDecimal whly) {
		this.whly = whly;
	}

	public BigDecimal getWhlyZf() {
		return whlyZf;
	}

	public void setWhlyZf(BigDecimal whlyZf) {
		this.whlyZf = whlyZf;
	}

	public BigDecimal getJxzb() {
		return jxzb;
	}

	public void setJxzb(BigDecimal jxzb) {
		this.jxzb = jxzb;
	}

	public BigDecimal getJxzbZf() {
		return jxzbZf;
	}

	public void setJxzbZf(BigDecimal jxzbZf) {
		this.jxzbZf = jxzbZf;
	}

	public BigDecimal getXxjs() {
		return xxjs;
	}

	public void setXxjs(BigDecimal xxjs) {
		this.xxjs = xxjs;
	}

	public BigDecimal getXxjsZf() {
		return xxjsZf;
	}

	public void setXxjsZf(BigDecimal xxjsZf) {
		this.xxjsZf = xxjsZf;
	}

	public BigDecimal getGdzctz() {
		return gdzctz;
	}

	public void setGdzctz(BigDecimal gdzctz) {
		this.gdzctz = gdzctz;
	}

	public BigDecimal getGdzctzZf() {
		return gdzctzZf;
	}

	public void setGdzctzZf(BigDecimal gdzctzZf) {
		this.gdzctzZf = gdzctzZf;
	}

	public BigDecimal getYctze() {
		return yctze;
	}

	public void setYctze(BigDecimal yctze) {
		this.yctze = yctze;
	}

	public BigDecimal getYctzeZf() {
		return yctzeZf;
	}

	public void setYctzeZf(BigDecimal yctzeZf) {
		this.yctzeZf = yctzeZf;
	}

	public BigDecimal getEctze() {
		return ectze;
	}

	public void setEctze(BigDecimal ectze) {
		this.ectze = ectze;
	}

	public BigDecimal getEctzeZf() {
		return ectzeZf;
	}

	public void setEctzeZf(BigDecimal ectzeZf) {
		this.ectzeZf = ectzeZf;
	}

	public BigDecimal getSctze() {
		return sctze;
	}

	public void setSctze(BigDecimal sctze) {
		this.sctze = sctze;
	}

	public BigDecimal getSctzeZf() {
		return sctzeZf;
	}

	public void setSctzeZf(BigDecimal sctzeZf) {
		this.sctzeZf = sctzeZf;
	}

	public BigDecimal getFdctze() {
		return fdctze;
	}

	public void setFdctze(BigDecimal fdctze) {
		this.fdctze = fdctze;
	}

	public BigDecimal getFdctzeZf() {
		return fdctzeZf;
	}

	public void setFdctzeZf(BigDecimal fdctzeZf) {
		this.fdctzeZf = fdctzeZf;
	}

	public String getDycyId() {
		return dycyId;
	}

	public void setDycyId(String dycyId) {
		this.dycyId = dycyId;
	}

	public String getDecyTd() {
		return decyTd;
	}

	public void setDecyTd(String decyTd) {
		this.decyTd = decyTd;
	}

	public String getDscyId() {
		return dscyId;
	}

	public void setDscyId(String dscyId) {
		this.dscyId = dscyId;
	}

	
	public BigDecimal getDycycz() {
		return dycycz;
	}

	public void setDycycz(BigDecimal dycycz) {
		this.dycycz = dycycz;
	}

	public BigDecimal getDycyczzf() {
		return dycyczzf;
	}

	public void setDycyczzf(BigDecimal dycyczzf) {
		this.dycyczzf = dycyczzf;
	}

	public BigDecimal getDecycz() {
		return decycz;
	}

	public void setDecycz(BigDecimal decycz) {
		this.decycz = decycz;
	}

	public BigDecimal getDecyczzf() {
		return decyczzf;
	}

	public void setDecyczzf(BigDecimal decyczzf) {
		this.decyczzf = decyczzf;
	}

	public BigDecimal getDscycz() {
		return dscycz;
	}

	public void setDscycz(BigDecimal dscycz) {
		this.dscycz = dscycz;
	}

	public BigDecimal getDscyczzf() {
		return dscyczzf;
	}

	public void setDscyczzf(BigDecimal dscyczzf) {
		this.dscyczzf = dscyczzf;
	}

	public BigDecimal getNycz() {
		return nycz;
	}

	public void setNycz(BigDecimal nycz) {
		this.nycz = nycz;
	}

	public BigDecimal getNyczzf() {
		return nyczzf;
	}

	public void setNyczzf(BigDecimal nyczzf) {
		this.nyczzf = nyczzf;
	}

	public BigDecimal getNyczzb() {
		return nyczzb;
	}

	public void setNyczzb(BigDecimal nyczzb) {
		this.nyczzb = nyczzb;
	}

	public BigDecimal getLycz() {
		return lycz;
	}

	public void setLycz(BigDecimal lycz) {
		this.lycz = lycz;
	}

	public BigDecimal getLyczzf() {
		return lyczzf;
	}

	public void setLyczzf(BigDecimal lyczzf) {
		this.lyczzf = lyczzf;
	}

	public BigDecimal getLyczzb() {
		return lyczzb;
	}

	public void setLyczzb(BigDecimal lyczzb) {
		this.lyczzb = lyczzb;
	}

	public BigDecimal getMycz() {
		return mycz;
	}

	public void setMycz(BigDecimal mycz) {
		this.mycz = mycz;
	}

	public BigDecimal getMyczzf() {
		return myczzf;
	}

	public void setMyczzf(BigDecimal myczzf) {
		this.myczzf = myczzf;
	}

	public BigDecimal getMyczzb() {
		return myczzb;
	}

	public void setMyczzb(BigDecimal myczzb) {
		this.myczzb = myczzb;
	}

	public BigDecimal getYycz() {
		return yycz;
	}

	public void setYycz(BigDecimal yycz) {
		this.yycz = yycz;
	}

	public BigDecimal getYyczzf() {
		return yyczzf;
	}

	public void setYyczzf(BigDecimal yyczzf) {
		this.yyczzf = yyczzf;
	}

	public BigDecimal getYyczzb() {
		return yyczzb;
	}

	public void setYyczzb(BigDecimal yyczzb) {
		this.yyczzb = yyczzb;
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

	public BigDecimal getNcjmrjkzpsr() {
		return ncjmrjkzpsr;
	}

	public void setNcjmrjkzpsr(BigDecimal ncjmrjkzpsr) {
		this.ncjmrjkzpsr = ncjmrjkzpsr;
	}

	public BigDecimal getNcjmrjkzpsrZf() {
		return ncjmrjkzpsrZf;
	}

	public void setNcjmrjkzpsrZf(BigDecimal ncjmrjkzpsrZf) {
		this.ncjmrjkzpsrZf = ncjmrjkzpsrZf;
	}

	public BigDecimal getXmtze() {
		return xmtze;
	}

	public void setXmtze(BigDecimal xmtze) {
		this.xmtze = xmtze;
	}

	public BigDecimal getXmtzeZf() {
		return xmtzeZf;
	}

	public void setXmtzeZf(BigDecimal xmtzeZf) {
		this.xmtzeZf = xmtzeZf;
	}
	
	public BigDecimal getLs() {
		return ls;
	}

	public void setLs(BigDecimal ls) {
		this.ls = ls;
	}
	

}
