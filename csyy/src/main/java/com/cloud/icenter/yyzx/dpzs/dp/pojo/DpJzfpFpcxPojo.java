package com.cloud.icenter.yyzx.dpzs.dp.pojo;

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
 * 大屏-精准扶贫-扶贫成效
 * 
 * @author dbchenga
 */
@Entity
@Table(name = "t_dp_jzfp_tpcx")
public class DpJzfpFpcxPojo extends Pojo {

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
	private Integer year;// 年份

	@Column(name = "wushan")
	private Integer wushan;// 武山
	@Column(name = "qinzhou")
	private Integer qinzhou;// 秦州
	@Column(name = "maiji")
	private Integer maiji;// 麦积
	@Column(name = "gangu")
	private Integer gangu;// 甘谷

	@Column(name = "qinan")
	private Integer qinan;// 秦安
	@Column(name = "qingshui")
	private Integer qingshui;// 清水
	@Column(name = "zhangjiachuan")
	private Integer zhangjiachuan;// 张家川
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

	public Integer getWushan() {
		return wushan;
	}

	public void setWushan(Integer wushan) {
		this.wushan = wushan;
	}

	public Integer getQinzhou() {
		return qinzhou;
	}

	public void setQinzhou(Integer qinzhou) {
		this.qinzhou = qinzhou;
	}

	public Integer getMaiji() {
		return maiji;
	}

	public void setMaiji(Integer maiji) {
		this.maiji = maiji;
	}

	public Integer getGangu() {
		return gangu;
	}

	public void setGangu(Integer gangu) {
		this.gangu = gangu;
	}

	public Integer getQinan() {
		return qinan;
	}

	public void setQinan(Integer qinan) {
		this.qinan = qinan;
	}

	public Integer getQingshui() {
		return qingshui;
	}

	public void setQingshui(Integer qingshui) {
		this.qingshui = qingshui;
	}

	public Integer getZhangjiachuan() {
		return zhangjiachuan;
	}

	public void setZhangjiachuan(Integer zhangjiachuan) {
		this.zhangjiachuan = zhangjiachuan;
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
