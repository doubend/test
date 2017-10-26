package com.cloud.icenter.yyzx.dpzs.slp.pojo;

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
 * 三联屏-交通出行-十大热点
 * 
 * @author dbchenga
 */
@Entity
@Table(name = "t_slp_jtcx_ten")
public class SlpJtcxTenPojo extends Pojo {

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

	private String rdm;// 贫困村

	private Integer rdzs;// 经度
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

	public String getRdm() {
		return rdm;
	}

	public void setRdm(String rdm) {
		this.rdm = rdm;
	}

	public Integer getRdzs() {
		return rdzs;
	}

	public void setRdzs(Integer rdzs) {
		this.rdzs = rdzs;
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
