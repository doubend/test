package com.cloud.icenter.yyzx.ztfx.jtcx.pojo;

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
 * 公交车体类
 * 
 * @author dbchenga
 */
@Entity
@Table(name = "t_jtcx_gjc")
public class GjcPojo extends Pojo {

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
	private Integer year;

	@Column(name = "renci")
	private Integer renci;
	@Column(name = "ka")
	private Integer ka;
	@Column(name = "wanren")
	private Integer wanren;

	@Column(name = "xianlu")
	private Integer xianlu;

	@Column(name = "fendan")
	private float fendan;

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

	public Integer getRenci() {
		return renci;
	}

	public void setRenci(Integer renci) {
		this.renci = renci;
	}

	public Integer getKa() {
		return ka;
	}

	public void setKa(Integer ka) {
		this.ka = ka;
	}

	public Integer getWanren() {
		return wanren;
	}

	public void setWanren(Integer wanren) {
		this.wanren = wanren;
	}

	public Integer getXianlu() {
		return xianlu;
	}

	public void setXianlu(Integer xianlu) {
		this.xianlu = xianlu;
	}

	public float getFendan() {
		return fendan;
	}

	public void setFendan(float fendan) {
		this.fendan = fendan;
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
