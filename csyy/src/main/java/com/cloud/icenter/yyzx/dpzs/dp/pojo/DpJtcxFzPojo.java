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
@Table(name = "t_dp_jtcx_fz")
public class DpJtcxFzPojo extends Pojo {

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

	private Integer gjxl;
	private Integer gjcxfdl;
	private Integer gjwr;
	private Integer gjrjzkl;
	private Integer czwr;
	private Integer czrjzkl;
	private Integer hyc;
	private Integer hyzl;

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

	public Integer getGjxl() {
		return gjxl;
	}

	public void setGjxl(Integer gjxl) {
		this.gjxl = gjxl;
	}

	public Integer getGjcxfdl() {
		return gjcxfdl;
	}

	public void setGjcxfdl(Integer gjcxfdl) {
		this.gjcxfdl = gjcxfdl;
	}

	public Integer getGjwr() {
		return gjwr;
	}

	public void setGjwr(Integer gjwr) {
		this.gjwr = gjwr;
	}

	public Integer getGjrjzkl() {
		return gjrjzkl;
	}

	public void setGjrjzkl(Integer gjrjzkl) {
		this.gjrjzkl = gjrjzkl;
	}

	public Integer getCzwr() {
		return czwr;
	}

	public void setCzwr(Integer czwr) {
		this.czwr = czwr;
	}

	public Integer getCzrjzkl() {
		return czrjzkl;
	}

	public void setCzrjzkl(Integer czrjzkl) {
		this.czrjzkl = czrjzkl;
	}

	public Integer getHyc() {
		return hyc;
	}

	public void setHyc(Integer hyc) {
		this.hyc = hyc;
	}

	public Integer getHyzl() {
		return hyzl;
	}

	public void setHyzl(Integer hyzl) {
		this.hyzl = hyzl;
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
