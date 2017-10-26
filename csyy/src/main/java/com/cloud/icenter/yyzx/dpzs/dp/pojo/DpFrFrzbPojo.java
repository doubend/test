package com.cloud.icenter.yyzx.dpzs.dp.pojo;

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

import com.cloud.icenter.base.pojo.Pojo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 大屏-法人-企业坐标
 * 
 * @author dbchenga
 */
@Entity
@Table(name = "t_dp_fr_qyzb")
public class DpFrFrzbPojo extends Pojo {

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

	@JsonProperty("name")
	private String qymc;
	
	@JsonIgnore
	private String qyhy;
	@JsonIgnore
	private String qyxz;

	@JsonIgnore
	private Float lng;
	@JsonIgnore
	private Float lat;

	@JsonIgnore
	private Integer status;

	@Transient
	private float geoCoord[];

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time", length = 7)
	@JsonIgnore
	private Date create_time;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_time", length = 7)
	@JsonIgnore
	private Date update_time;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "remove_time", length = 7)
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

	public String getQymc() {
		return qymc;
	}

	public void setQymc(String qymc) {
		this.qymc = qymc;
	}

	public String getQyhy() {
		return qyhy;
	}

	public void setQyhy(String qyhy) {
		this.qyhy = qyhy;
	}

	public String getQyxz() {
		return qyxz;
	}

	public void setQyxz(String qyxz) {
		this.qyxz = qyxz;
	}

	public Float getLng() {
		return lng;
	}

	public void setLng(Float lng) {
		this.lng = lng;
	}

	public Float getLat() {
		return lat;
	}

	public void setLat(Float lat) {
		this.lat = lat;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public float[] getGeoCoord() {
		geoCoord = new float[2];
		geoCoord[0] = lng;
		geoCoord[1] = lat;
		return geoCoord;
	}

	public void setGeoCoord(float[] geoCoord) {

		this.geoCoord = geoCoord;
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
