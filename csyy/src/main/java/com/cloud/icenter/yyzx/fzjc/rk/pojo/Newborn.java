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
 * 新生婴儿性别比及分布
 * @author Administrator
 *
 */
@Entity
@Table(name = "t_renk_ldrk_xsyr")
public class Newborn extends Pojo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 32)
	private String id;//                        varchar(32)       主键
	
	@Column(name = "city", length = 20)
	private String city;//					  varchar(20)		城市名称
	
	@Column(name = "tyear")
	private Integer tyear;//					  char(4)           年份 
	
	@Column(name = "total_population")
	private Integer total_population;//		  int               人口
	
	@Column(name = "proportion")
	private BigDecimal proportion;//               float             占全市比例
	
	@Column(name = "mwb")
	private BigDecimal mwb;//                       float             男女比例
	
	@Column(name = "create_time")
	private Timestamp create_time;//            timestamp         创建时间
	
	@Column(name = "update_time")
	private Timestamp update_time;//              timestamp         更新时间
	
	@Column(name = "delete_time")
	private Timestamp delete_time;//              timestamp         删除时间
	
	@Column(name = "delete_state",length = 1)
	private Integer delete_state;//             char(1)           1已删除，0正常

	public String getCity() {
		return city;
	}

	public Integer getTyear() {
		return tyear;
	}

	public Integer getTotal_population() {
		return total_population;
	}

	public BigDecimal getProportion() {
		return proportion;
	}

	public BigDecimal getMwb() {
		return mwb;
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

	public Integer getDelete_state() {
		return delete_state;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setTyear(Integer tyear) {
		this.tyear = tyear;
	}

	public void setTotal_population(Integer total_population) {
		this.total_population = total_population;
	}

	public void setProportion(BigDecimal proportion) {
		this.proportion = proportion;
	}

	public void setMwb(BigDecimal mwb) {
		this.mwb = mwb;
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
