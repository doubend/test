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
/**
 * 
 * @author Administrator
 *
 */
@Entity
@Table(name = "t_jjfz_jjyx_ghyz")
public class Industrytotal extends Pojo{

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
	
	@Column(name = "industry", length = 30)
	private String industry;//                  varchar(30)       行业名称
	
	@Column(name = "productionval")
	private BigDecimal productionval;//            float             产值
	
	@Column(name = "scale")
	private BigDecimal scale;//                     float             占总产值比例
	
	@Column(name = "growth")
	private BigDecimal growth;//					  float             同比增长
	
	@Column(name = "zjz")
	private BigDecimal zjz;//					  float             增加值
	
	@Column(name = "zjztbzz")
	private BigDecimal zjztbzz;//					  float             增加值同比增长
	
	@Column(name = "zjzscale")
	private BigDecimal zjzscale;//                     float             占总增加值比例
	
	@Column(name = "create_time")
	private Timestamp create_time;//               timestamp         创建时间
	
	@Column(name = "update_time")
	private Timestamp update_time;//             timestamp         更新时间
	
	@Column(name = "delete_time")
	private Timestamp delete_time;//               timestamp         删除时间
	
	@Column(name = "delete_state")
	private Integer delete_state;//             char(1)           1已删除，0正常

	public Integer getTyear() {
		return tyear;
	}

	public String getIndustry() {
		return industry;
	}

	public BigDecimal getProductionval() {
		return productionval;
	}

	public BigDecimal getScale() {
		return scale;
	}

	public BigDecimal getGrowth() {
		return growth;
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

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public void setProductionval(BigDecimal productionval) {
		this.productionval = productionval;
	}

	public void setScale(BigDecimal scale) {
		this.scale = scale;
	}

	public void setGrowth(BigDecimal growth) {
		this.growth = growth;
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
