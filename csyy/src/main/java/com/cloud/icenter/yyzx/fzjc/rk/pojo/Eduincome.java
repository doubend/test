package com.cloud.icenter.yyzx.fzjc.rk.pojo;

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

/**
 * 流出人口学历及收入（元）
 * @author Administrator
 *
 */
@Entity
@Table(name = "t_renk_ldrk_xlsr")
public class Eduincome extends Pojo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 32)
	private String id;//                        varchar(32)       主键
	
	@Column(name = "education", length = 20)
	private String education;//                 varchar(20)       学历
	
	@Column(name = "eorder")   //排序
	private Integer eorder;
	
	@Column(name = "number")
	private BigDecimal number;//                    float             人数（万人）
	
	@Column(name = "scale")
	private BigDecimal scale;//                     float             比例
	
	@Column(name = "income")
	private Integer income;//                    int               收入
	
	@Column(name = "average_age")
	private Integer average_age;//			  tinyint           平均年龄
	
	@Column(name = "create_time")
	private Timestamp create_time;//               timestamp         创建时间
	
	@Column(name = "update_time")
	private Timestamp update_time;//               timestamp         更新时间
	
	@Column(name = "delete_time")
	private Timestamp delete_time;//               timestamp         删除时间
	
	@Column(name = "delete_state")
	private String delete_state;//              char(1)           1已删除，0正常

	public String getEducation() {
		return education;
	}

	public Integer getEorder() {
		return eorder;
	}

	public BigDecimal getNumber() {
		return number;
	}

	public BigDecimal getScale() {
		return scale;
	}

	public Integer getIncome() {
		return income;
	}

	public Integer getAverage_age() {
		return average_age;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	public Timestamp getCreate_time() {
		return create_time;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	public Timestamp getUpdate_time() {
		return update_time;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	public Timestamp getDelete_time() {
		return delete_time;
	}

	public String getDelete_state() {
		return delete_state;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public void setEorder(Integer eorder) {
		this.eorder = eorder;
	}

	public void setNumber(BigDecimal number) {
		this.number = number;
	}

	public void setScale(BigDecimal scale) {
		this.scale = scale;
	}

	public void setIncome(Integer income) {
		this.income = income;
	}

	public void setAverage_age(Integer average_age) {
		this.average_age = average_age;
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

	public void setDelete_state(String delete_state) {
		this.delete_state = delete_state;
	}
	

}
