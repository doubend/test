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
 * 全市空气质量记录
 * @author Administrator
 *
 */
@Entity
@Table(name = "t_hjbh_kqzl_jiac")
public class AirQualityCity extends Pojo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 32)
	private String id;//                  varchar(32)       主键
	
	@Column(name = "PM10")
	private BigDecimal PM10;//				  float             PM10
	
	@Column(name = "PM2P5")
	private BigDecimal PM2P5;//                float             PM2.5  
	
	@Column(name = "NO2")
	private BigDecimal NO2;//                  float             NO2
	
	@Column(name = "CO")
	private BigDecimal CO;//                   float             CO
	
	@Column(name = "SO2")
	private BigDecimal SO2;//	              float             SO2
	
	@Column(name = "O3")
	private BigDecimal O3;//                   float             O3
	
	@Column(name = "create_time")
	private Timestamp create_time;//      timestamp         创建时间
	
	@Column(name = "update_time")
	private Timestamp update_time;//      timestamp         更新时间
	
	@Column(name = "delete_time")
	private Timestamp delete_time;//      timestamp         删除时间
	
	@Column(name = "delete_state")
	private Integer delete_state;//     char(1)           1已删除，0正常

	public BigDecimal getPM10() {
		return PM10;
	}

	public BigDecimal getPM2P5() {
		return PM2P5;
	}

	public BigDecimal getNO2() {
		return NO2;
	}

	public BigDecimal getCO() {
		return CO;
	}

	public BigDecimal getSO2() {
		return SO2;
	}

	public BigDecimal getO3() {
		return O3;
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

	public void setPM10(BigDecimal pM10) {
		PM10 = pM10;
	}

	public void setPM2P5(BigDecimal pM2P5) {
		PM2P5 = pM2P5;
	}

	public void setNO2(BigDecimal nO2) {
		NO2 = nO2;
	}

	public void setCO(BigDecimal cO) {
		CO = cO;
	}

	public void setSO2(BigDecimal sO2) {
		SO2 = sO2;
	}

	public void setO3(BigDecimal o3) {
		O3 = o3;
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
