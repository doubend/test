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
@Table(name = "t_fr_qyhy")
public class FRQyhyPojo extends Pojo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "ID", unique = true, nullable = false, length = 32)
	@JsonIgnore
	private String id;

	@Column(name = "year")
	@JsonIgnore
	private Integer year;

	@Column(name = "name")
	@JsonProperty("name")
	private String name;

	@Column(name = "add")
	private Integer add;
	@Column(name = "del")
	private Integer del;
	@Column(name = "addgm")
	private Integer addgm;
	@Column(name = "delgm")
	private Integer delgm;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAdd() {
		return add;
	}

	public void setAdd(Integer add) {
		this.add = add;
	}

	public Integer getDel() {
		return del;
	}

	public void setDel(Integer del) {
		this.del = del;
	}

	public Integer getAddgm() {
		return addgm;
	}

	public void setAddgm(Integer addgm) {
		this.addgm = addgm;
	}

	public Integer getDelgm() {
		return delgm;
	}

	public void setDelgm(Integer delgm) {
		this.delgm = delgm;
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
