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
 * 大屏-法人-大屏法人企业法人注册注销
 * 
 * @author dbchenga
 */
@Entity
@Table(name = "t_dp_fr_frzx")
public class DpFrFrzcPojo extends Pojo {

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

	@Column(name = "lx")
	private String lx;// 类型

	@Column(name = "zxsl")
	private Integer zxsl;// 注销数量
	@Column(name = "zxgmys")
	private Integer zxgmys;// 注销规模以上数量
	@Column(name = "zcsl")
	private Integer zcsl;// 注册数量
	@Column(name = "gmys")
	private Integer gmys;// 规模以上数量
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

	public String getLx() {
		return lx;
	}

	public void setLx(String lx) {
		this.lx = lx;
	}

	public Integer getZcsl() {
		return zcsl;
	}

	public void setZcsl(Integer zcsl) {
		this.zcsl = zcsl;
	}

	public Integer getGmys() {
		return gmys;
	}

	public void setGmys(Integer gmys) {
		this.gmys = gmys;
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

	public Integer getZxsl() {
		return zxsl;
	}

	public void setZxsl(Integer zxsl) {
		this.zxsl = zxsl;
	}

	public Integer getZxgmys() {
		return zxgmys;
	}

	public void setZxgmys(Integer zxgmys) {
		this.zxgmys = zxgmys;
	}

}
