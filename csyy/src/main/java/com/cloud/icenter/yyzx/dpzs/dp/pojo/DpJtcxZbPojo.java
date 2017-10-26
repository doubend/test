package com.cloud.icenter.yyzx.dpzs.dp.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.cloud.icenter.base.pojo.Pojo;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 大屏-交通出行-出租车
 * 
 * @author dbchenga
 */
@Entity
@Table(name = "t_dp_jtcx_zb")
public class DpJtcxZbPojo extends Pojo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "ID", unique = true, nullable = false, length = 32)
	@JsonIgnore
	private String id;

	@JsonIgnore
	private Integer year;// 年份

	private String zbname;// 贫困村
	private String zbvalue;// 贫困村

	private Integer wz;
	@JsonIgnore
	private String rq;//

	@JsonIgnore
	private Integer status;

	@JsonIgnore
	private Date create_time;
	@JsonIgnore
	private Date update_time;
	@JsonIgnore
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

	public String getZbname() {
		return zbname;
	}

	public void setZbname(String zbname) {
		this.zbname = zbname;
	}

	public String getZbvalue() {
		return zbvalue;
	}

	public void setZbvalue(String zbvalue) {
		this.zbvalue = zbvalue;
	}

	public Integer getWz() {
		return wz;
	}

	public void setWz(Integer wz) {
		this.wz = wz;
	}

	public String getRq() {
		return rq;
	}

	public void setRq(String rq) {
		this.rq = rq;
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
