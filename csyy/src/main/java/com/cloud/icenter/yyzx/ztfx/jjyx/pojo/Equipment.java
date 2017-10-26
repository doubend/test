package com.cloud.icenter.yyzx.ztfx.jjyx.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import com.cloud.icenter.base.pojo.Pojo;
import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Table(name = "t_jjfz_jjyx_zdzb")
public class Equipment extends Pojo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 32)
	private String id;//                        varchar(32)       主键
	
	@Column(name = "tyear")
	private Integer tyear;//                     char(4)           年份
	
	@Column(name = "equipment", length = 50)
	private String equipment;//                 varchar(50)       装备名称
	
	@Column(name = "income")
	private BigDecimal income;//                    float             收入
	
	@Column(name = "create_time")
	private Timestamp create_time;//               timestamp         创建时间
	
	@Column(name = "update_time")
	private Timestamp update_time;//              timestamp         更新时间
	
	@Column(name = "delete_time")
	private Timestamp delete_time;//               timestamp         删除时间
	
	@Column(name = "delete_state")
	private Integer delete_state;//              char(1)           1已删除，0正常

	public Integer getTyear() {
		return tyear;
	}

	public String getEquipment() {
		return equipment;
	}

	public BigDecimal getIncome() {
		return income;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	public Timestamp getCreate_time() {
		return create_time;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	public Timestamp getUpdate_time() {
		return update_time;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	public Timestamp getDelete_time() {
		return delete_time;
	}

	public Integer getDelete_state() {
		return delete_state;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setTyear(Integer tyear) {
		this.tyear = tyear;
	}

	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}

	public void setIncome(BigDecimal income) {
		this.income = income;
	}

	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}

	public void setUpdate_time(Timestamp update_time) {
		this.update_time = update_time;
	}

	public void setDelete_time(Timestamp delete_time) {
		this.delete_time = delete_time;
	}

	public void setDelete_state(Integer delete_state) {
		this.delete_state = delete_state;
	}
	


}
