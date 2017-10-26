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
 * 全市水质记录表（过去七天内的数据）
 * @author Administrator
 *
 */
@Entity
@Table(name = "t_hjbh_szfx_jiac")
public class WaterQualityCity extends Pojo{

	/**
	 * .....
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 32)
	private String id;//                        varchar(32)       主键
	
	@Column(name = "KMNO")
	private BigDecimal KMNO;//					  float             高锰酸钾
	
	@Column(name = "conductance")
	private BigDecimal conductance;//               float             电导率
	
	@Column(name = "solution")
	private BigDecimal solution;//                  float             溶解液
	
	@Column(name = "NH4")
	private BigDecimal NH4;//                       float             氨氮
	
	@Column(name = "PH")
	private BigDecimal PH;//                        float             PH值
	
	@Column(name = "create_time")
	private Timestamp create_time;//               timestamp         创建时间
	
	@Column(name = "update_time")
	private Timestamp update_time;//               timestamp         更新时间
	
	@Column(name = "delete_time")
	private Timestamp delete_time;//               timestamp         删除时间
	
	@Column(name = "delete_state",length = 1)
	private Integer delete_state;//              char(1)           1已删除，0正常

	public BigDecimal getKMNO() {
		return KMNO;
	}

	public BigDecimal getConductance() {
		return conductance;
	}

	public BigDecimal getSolution() {
		return solution;
	}

	public BigDecimal getNH4() {
		return NH4;
	}

	public BigDecimal getPH() {
		return PH;
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

	public void setKMNO(BigDecimal kMNO) {
		KMNO = kMNO;
	}

	public void setConductance(BigDecimal conductance) {
		this.conductance = conductance;
	}

	public void setSolution(BigDecimal solution) {
		this.solution = solution;
	}

	public void setNH4(BigDecimal nH4) {
		NH4 = nH4;
	}

	public void setPH(BigDecimal pH) {
		PH = pH;
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
