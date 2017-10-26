package com.cloud.icenter.yyzx.fzjc.hjbh.pojo;

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
 * @author zhucy 
 * @version 2017年8月2日 下午2:48:20 
 * 说明 
 */
@Entity
@Table(name = "t_hjbh_kqzl_jcsj")
public class KqzlJcsjPoJo extends Pojo{
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 32)
    private  String id;  
	
	@Column(name = "jczd_id")
	private String jczd_id;
	
	@Column(name = "SO2")
	private BigDecimal SO2;
	
	@Column(name = "O3_1h")
	private BigDecimal O3_1h;
	
	@Column(name = "PM2P5")
	private BigDecimal PM2P5;
	
	@Column(name = "primary_pollutant")
	private String primary_pollutant;
	
	@Column(name = "num")
	private int num;
	
	@Column(name = "CO")
	private BigDecimal CO;
	
	@Column(name = "NO2")
	private BigDecimal NO2;
	
	@Column(name = "aqi")
	private int aqi;
	
	@Column(name = "quality")
	private String quality;
	
	@Column(name = "PM10")
	private BigDecimal PM10;
	
	@Column(name = "O3_8h")
	private BigDecimal O3_8h;
	
	/**
	 * 数据时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_time")
	private Date dataTime;
	
	/**
	 * 创建时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time")
    private  Date createTime;  
    
	/**
	 * 更新时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_time")
    private  Date updateTime;  
    
	/**
	 * 删除时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "delete_time")
    private  Date deleteTime;  
    
	/**
	 * 删除状态：0正常，1删除
	 */
	@Column(name = "delete_status")
    private  String deleteStatus;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getJczd_id() {
		return jczd_id;
	}

	public void setJczd_id(String jczd_id) {
		this.jczd_id = jczd_id;
	}

	public BigDecimal getSO2() {
		return SO2;
	}

	public void setSO2(BigDecimal sO2) {
		SO2 = sO2;
	}

	public BigDecimal getO3_1h() {
		return O3_1h;
	}

	public void setO3_1h(BigDecimal o3_1h) {
		O3_1h = o3_1h;
	}

	public BigDecimal getPM2P5() {
		return PM2P5;
	}

	public void setPM2P5(BigDecimal pM2P5) {
		PM2P5 = pM2P5;
	}

	public String getPrimary_pollutant() {
		return primary_pollutant;
	}

	public void setPrimary_pollutant(String primary_pollutant) {
		this.primary_pollutant = primary_pollutant;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public BigDecimal getCO() {
		return CO;
	}

	public void setCO(BigDecimal cO) {
		CO = cO;
	}

	public BigDecimal getNO2() {
		return NO2;
	}

	public void setNO2(BigDecimal nO2) {
		NO2 = nO2;
	}

	public int getAqi() {
		return aqi;
	}

	public void setAqi(int aqi) {
		this.aqi = aqi;
	}

	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	public BigDecimal getPM10() {
		return PM10;
	}

	public void setPM10(BigDecimal pM10) {
		PM10 = pM10;
	}

	public BigDecimal getO3_8h() {
		return O3_8h;
	}

	public void setO3_8h(BigDecimal o3_8h) {
		O3_8h = o3_8h;
	}

	public Date getDataTime() {
		return dataTime;
	}

	public void setDataTime(Date dataTime) {
		this.dataTime = dataTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getDeleteTime() {
		return deleteTime;
	}

	public void setDeleteTime(Date deleteTime) {
		this.deleteTime = deleteTime;
	}

	public String getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(String deleteStatus) {
		this.deleteStatus = deleteStatus;
	}
	
	
}
