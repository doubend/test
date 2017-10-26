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
 * 大屏-精准扶贫-贫困村信息
 * 
 * @author dbchenga
 */
@Entity
@Table(name = "t_slp_jtcx_ditu")
public class SlpJtcxRdmapPojo extends Pojo {

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

	private Double lng;// 经度
	private Double lat;// 维度

	private String rdfl;// 热点分类
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

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public String getRdfl() {
		return rdfl;
	}

	public void setRdfl(String rdfl) {
		this.rdfl = rdfl;
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
