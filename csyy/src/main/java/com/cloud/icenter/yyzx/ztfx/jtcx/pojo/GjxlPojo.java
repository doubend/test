package com.cloud.icenter.yyzx.ztfx.jtcx.pojo;

import java.util.Date;
import java.util.List;

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

/**
 * 公交线路实体类
 * 
 * @author dbchenga
 */
@Entity
@Table(name = "t_jtcx_gjxl")
public class GjxlPojo extends Pojo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "ID", unique = true, nullable = false, length = 32)
	private String id;

	@Column(name = "no")
	private Integer no;
	@Column(name = "name")
	private String name;
	@Column(name = "up_start")
	private String up_start;
	@Column(name = "down_start")
	private String down_start;
	@Transient
	private List<GjzdPojo> zhandian;

	@Column(name = "up_end")
	private String up_end;
	@Column(name = "down_end")
	private String down_end;

	@Column(name = "up_fast_time")
	private String up_fast_time;
	@Column(name = "down_fast_time")
	private String down_fast_time;

	@Column(name = "up_last_time")
	private String up_last_time;
	@Column(name = "down_last_time")
	private String down_last_time;

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

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUp_start() {
		return up_start;
	}

	public void setUp_start(String up_start) {
		this.up_start = up_start;
	}

	public String getDown_start() {
		return down_start;
	}

	public void setDown_start(String down_start) {
		this.down_start = down_start;
	}

	public String getUp_end() {
		return up_end;
	}

	public void setUp_end(String up_end) {
		this.up_end = up_end;
	}

	public String getDown_end() {
		return down_end;
	}

	public void setDown_end(String down_end) {
		this.down_end = down_end;
	}

	public String getUp_fast_time() {
		return up_fast_time;
	}

	public void setUp_fast_time(String up_fast_time) {
		this.up_fast_time = up_fast_time;
	}

	public String getDown_fast_time() {
		return down_fast_time;
	}

	public void setDown_fast_time(String down_fast_time) {
		this.down_fast_time = down_fast_time;
	}

	public String getUp_last_time() {
		return up_last_time;
	}

	public void setUp_last_time(String up_last_time) {
		this.up_last_time = up_last_time;
	}

	public String getDown_last_time() {
		return down_last_time;
	}

	public void setDown_last_time(String down_last_time) {
		this.down_last_time = down_last_time;
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

	public List<GjzdPojo> getZhandian() {
		return zhandian;
	}

	public void setZhandian(List<GjzdPojo> zhandian) {
		this.zhandian = zhandian;
	}

	public Date getRemove_time() {
		return remove_time;
	}

	public void setRemove_time(Date remove_time) {
		this.remove_time = remove_time;
	}

}
