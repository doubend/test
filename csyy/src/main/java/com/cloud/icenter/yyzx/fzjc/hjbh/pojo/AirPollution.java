package com.cloud.icenter.yyzx.fzjc.hjbh.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.cloud.icenter.base.pojo.Pojo;

/**
 * 大气污染源企业排污
 * @author Administrator
 *
 */
@Entity
@Table(name = "t_hjbh_kqzl_qypw")
public class AirPollution extends Pojo{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 32)
	private String id;//                        varchar(32)        主键
	
	@Column(name = "company", length = 100)
	private String company;//                   varchar(100)       公司名称
	
	@Column(name = "SO2")
	private BigDecimal SO2;//                       float              SO2
	
	@Column(name = "SO2_trend")
	private Integer SO2_trend;//                 char(1)            SO2趋势（1上升，0下降）
	
	@Column(name = "NOx")
	private BigDecimal NOx;//                     float              NOx
	
	@Column(name = "NOx_trend")
	private Integer NOx_trend;//			      char(1)            NOx趋势（1上升，0下降）
	
	@Column(name = "ranking")
	private Integer ranking;//      	          smallint           排名
	
	@Column(name = "create_time")
	private Timestamp create_time;//               timestamp          创建时间
	
	@Column(name = "update_time")
	private Timestamp update_time;//               timestamp          更新时间
	
	@Column(name = "delete_time")
	private Timestamp delete_time;//               timestamp          删除时间
	
	@Column(name = "delete_state")
	private Integer delete_state;//            char(1)           1已删除，0正常

	public String getCompany() {
		return company;
	}

	public BigDecimal getSO2() {
		return SO2;
	}

	public Integer getSO2_trend() {
		return SO2_trend;
	}

	public BigDecimal getNOx() {
		return NOx;
	}

	public Integer getNOx_trend() {
		return NOx_trend;
	}

	public Integer getRanking() {
		return ranking;
	}

	public Timestamp getCreate_time() {
		return create_time;
	}

	public Timestamp getUpdate_time() {
		return update_time;
	}

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

	public void setCompany(String company) {
		this.company = company;
	}

	public void setSO2(BigDecimal sO2) {
		SO2 = sO2;
	}

	public void setSO2_trend(Integer sO2_trend) {
		SO2_trend = sO2_trend;
	}

	public void setNOx(BigDecimal nOx) {
		NOx = nOx;
	}

	public void setNOx_trend(Integer nOx_trend) {
		NOx_trend = nOx_trend;
	}

	public void setRanking(Integer ranking) {
		this.ranking = ranking;
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
