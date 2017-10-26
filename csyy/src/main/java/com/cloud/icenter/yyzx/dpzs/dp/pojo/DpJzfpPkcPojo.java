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
 * 大屏-精准扶贫-贫困村信息
 * 
 * @author dbchenga
 */
@Entity
@Table(name = "t_poor_village")
public class DpJzfpPkcPojo extends Pojo {

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

	@Column(name = "year")
	@JsonIgnore
	private Integer year;// 年份

	@JsonProperty("name")
	@Column(name = "cm")
	private String cm;// 贫困村

	@Column(name = "lng")
	@JsonIgnore
	private Double lng;// 经度
	@Column(name = "lat")
	@JsonIgnore
	private Double lat;// 维度

	@Transient
	private Double[] geoCoord;

	@Column(name = "pkcd")
	@JsonIgnore
	private Integer pkcd;// 贫困程度[0：贫困，1：中度贫困，2：极度贫困]

	@Column(name = "status")
	@JsonIgnore
	private Integer status;

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

	public String getCm() {
		return cm;
	}

	public void setCm(String cm) {
		this.cm = cm;
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

	public Integer getPkcd() {
		return pkcd;
	}

	public void setPkcd(Integer pkcd) {
		this.pkcd = pkcd;
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

	public Double[] getGeoCoord() {
		geoCoord = new Double[2];
		geoCoord[0] = lng;
		geoCoord[1] = lat;
		return geoCoord;
	}

	public void setGeoCoord(Double[] geoCoord) {
		this.geoCoord = geoCoord;
	}

}
