package com.cloud.icenter.yyzx.fzjc.fr.pojo;

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
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 人口年龄结构变化
 * 
 * @author Administrator
 * 
 */
@Entity
@Table(name = "t_fr_econ")
public class FREconPojo extends Pojo {

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
	private Integer year;

	@Column(name = "type")
	@JsonProperty("name")
	private String type;

	@Column(name = "num")
	@JsonProperty("value")
	private Integer num;
	
	@Column(name = "nsnum")
	@JsonIgnore
	private Float nsnum;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
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

	public Float getNsnum() {
		return nsnum;
	}

	public void setNsnum(Float nsnum) {
		this.nsnum = nsnum;
	}

}
