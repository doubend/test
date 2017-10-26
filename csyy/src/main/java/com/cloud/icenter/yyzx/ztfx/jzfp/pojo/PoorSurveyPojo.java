package com.cloud.icenter.yyzx.ztfx.jzfp.pojo;

import java.math.BigDecimal;
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
@Table(name = "t_poor_survey")
public class PoorSurveyPojo extends Pojo {

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

	@Column(name = "village")
	private Integer village;
	@Column(name = "house")
	private BigDecimal house;
	@Column(name = "person")
	private BigDecimal person;

	@Column(name = "village_out")
	private Integer village_out;
	@Column(name = "house_out")
	private BigDecimal house_out;
	@Column(name = "person_out")
	private BigDecimal person_out;

	@Column(name = "village_ing")
	private Integer village_ing;
	@Column(name = "house_ing")
	private BigDecimal house_ing;
	@Column(name = "person_ing")
	private BigDecimal person_ing;

	@Column(name = "perent")
	private float perent;

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

	public Integer getVillage() {
		return village;
	}

	public void setVillage(Integer village) {
		this.village = village;
	}

	public BigDecimal getHouse() {
		return house;
	}

	public void setHouse(BigDecimal house) {
		this.house = house;
	}

	public BigDecimal getPerson() {
		return person;
	}

	public void setPerson(BigDecimal person) {
		this.person = person;
	}

	public Integer getVillage_out() {
		return village_out;
	}

	public void setVillage_out(Integer village_out) {
		this.village_out = village_out;
	}

	public BigDecimal getHouse_out() {
		return house_out;
	}

	public void setHouse_out(BigDecimal house_out) {
		this.house_out = house_out;
	}

	public BigDecimal getPerson_out() {
		return person_out;
	}

	public void setPerson_out(BigDecimal person_out) {
		this.person_out = person_out;
	}

	public Integer getVillage_ing() {
		return village_ing;
	}

	public void setVillage_ing(Integer village_ing) {
		this.village_ing = village_ing;
	}

	public BigDecimal getHouse_ing() {
		return house_ing;
	}

	public void setHouse_ing(BigDecimal house_ing) {
		this.house_ing = house_ing;
	}

	public BigDecimal getPerson_ing() {
		return person_ing;
	}

	public void setPerson_ing(BigDecimal person_ing) {
		this.person_ing = person_ing;
	}

	public float getPerent() {
		return perent;
	}

	public void setPerent(float perent) {
		this.perent = perent;
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
