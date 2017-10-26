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

import com.cloud.icenter.base.pojo.Pojo;

/**
 * 立柱交通出行
 * 
 * @author Administrator
 * 
 */
@Entity
@Table(name = "t_lz_jtcx")
public class LzJtcxPojo extends Pojo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "ID", unique = true, nullable = false, length = 32)
	private String id;

	@Column(name = "year")
	private Integer year;

	@Column(name = "zhishu")
	private Float zhishu;// 交通出行指数
	@Column(name = "gjcx")
	private Integer gjcx;// 公交出行人数
	@Column(name = "czccx")
	private Integer czccx;// 出租车出行人数

	@Column(name = "gjbc")
	private Integer gjbc;// 公交班次
	@Column(name = "czckzl")
	private Integer czckzl;// 出租车空载量

	@Column(name = "gj_xlts")
	private Integer gj_xlts;// 线路条数
	@Column(name = "gj_xlzc")
	private Integer gj_xlzc;// 线路总长

	@Column(name = "gj_lwmd")
	private Integer gj_lwmd;// 路网密度
	@Column(name = "gj_kyl")
	private Integer gj_kyl;// 客运量

	@Column(name = "czc_rjdcs")
	private Float czc_rjdcs;// 人均打车数
	@Column(name = "czc_rzkcs")
	private Integer czc_rzkcs;// 日载客次数

	@Column(name = "czc_yysj")
	private Integer czc_yysj;// 运营时间
	@Column(name = "czc_rzkjl")
	private Integer czc_rzkjl;// 日载客距离

	@Column(name = "status")
	private Integer status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time", length = 7)
	private Date create_time;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_time", length = 7)
	private Date update_time;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "remove_time", length = 7)
	private Date remove_time;

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

	public Float getZhishu() {
		return zhishu;
	}

	public void setZhishu(Float zhishu) {
		this.zhishu = zhishu;
	}

	public Integer getGjcx() {
		return gjcx;
	}

	public void setGjcx(Integer gjcx) {
		this.gjcx = gjcx;
	}

	public Integer getCzccx() {
		return czccx;
	}

	public void setCzccx(Integer czccx) {
		this.czccx = czccx;
	}

	public Integer getGjbc() {
		return gjbc;
	}

	public void setGjbc(Integer gjbc) {
		this.gjbc = gjbc;
	}

	public Integer getCzckzl() {
		return czckzl;
	}

	public void setCzckzl(Integer czckzl) {
		this.czckzl = czckzl;
	}

	public Integer getGj_xlts() {
		return gj_xlts;
	}

	public void setGj_xlts(Integer gj_xlts) {
		this.gj_xlts = gj_xlts;
	}

	public Integer getGj_xlzc() {
		return gj_xlzc;
	}

	public void setGj_xlzc(Integer gj_xlzc) {
		this.gj_xlzc = gj_xlzc;
	}

	public Integer getGj_lwmd() {
		return gj_lwmd;
	}

	public void setGj_lwmd(Integer gj_lwmd) {
		this.gj_lwmd = gj_lwmd;
	}

	public Integer getGj_kyl() {
		return gj_kyl;
	}

	public void setGj_kyl(Integer gj_kyl) {
		this.gj_kyl = gj_kyl;
	}

	public Float getCzc_rjdcs() {
		return czc_rjdcs;
	}

	public void setCzc_rjdcs(Float czc_rjdcs) {
		this.czc_rjdcs = czc_rjdcs;
	}

	public Integer getCzc_rzkcs() {
		return czc_rzkcs;
	}

	public void setCzc_rzkcs(Integer czc_rzkcs) {
		this.czc_rzkcs = czc_rzkcs;
	}

	public Integer getCzc_yysj() {
		return czc_yysj;
	}

	public void setCzc_yysj(Integer czc_yysj) {
		this.czc_yysj = czc_yysj;
	}

	public Integer getCzc_rzkjl() {
		return czc_rzkjl;
	}

	public void setCzc_rzkjl(Integer czc_rzkjl) {
		this.czc_rzkjl = czc_rzkjl;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	public Date getRemove_time() {
		return remove_time;
	}

	public void setRemove_time(Date remove_time) {
		this.remove_time = remove_time;
	}

}
