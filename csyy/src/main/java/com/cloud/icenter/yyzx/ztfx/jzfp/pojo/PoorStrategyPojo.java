package com.cloud.icenter.yyzx.ztfx.jzfp.pojo;

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
 * 贫困人员的汇总信息体类
 * 
 * @author dbchenga
 */
@Entity
@Table(name = "t_poor_strategy")
public class PoorStrategyPojo extends Pojo {

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
	private Integer year;// 年份

	@Column(name = "strategy")
	private String strategy;// 脱贫策略
	@Column(name = "person")
	private Integer person;// 覆盖人口
	@Column(name = "house")
	private Integer house;// 覆盖贫困户

	@Column(name = "fsl")
	private Integer fsl;// 贫困发生率
	@Column(name = "rjys")
	private Integer rjys;// 人均增收

	@Column(name = "parent")
	private float parent;// 脱贫占比

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

	public String getStrategy() {
		return strategy;
	}

	public void setStrategy(String strategy) {
		this.strategy = strategy;
	}

	public Integer getPerson() {
		return person;
	}

	public void setPerson(Integer person) {
		this.person = person;
	}

	public Integer getHouse() {
		return house;
	}

	public void setHouse(Integer house) {
		this.house = house;
	}

	public float getParent() {
		return parent;
	}

	public void setParent(float parent) {
		this.parent = parent;
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

	public Integer getFsl() {
		return fsl;
	}

	public void setFsl(Integer fsl) {
		this.fsl = fsl;
	}

	public Integer getRjys() {
		return rjys;
	}

	public void setRjys(Integer rjys) {
		this.rjys = rjys;
	}

}
