package com.cloud.icenter.yyzx.fzjc.rk.pojo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.cloud.icenter.base.pojo.Pojo;

/**
 * 民族宗教区域分布实体
 * @date 2017年9月28日
 * @author dxliug
 */
@Entity
@Table(name = "t_renk_rkfb_mzzj_area")
public class MzzjAreaResult extends Pojo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 32)
     private String id;
     /**
      * 总人口
      */
	 @Column(name = "total")
     private Float total;
	 /**
	  * 区域
	  */
	 @Column(name = "area")
	 private String area;
	 @Column(name = "hz_rk")
     private Float hzrk;
	
	 @Column(name = "zz_rk")
     private Float zzrk;
	 

	 
	 @Column(name = "tyear",length = 1)
	 private Integer tyear;
	 
	 @Column(name = "hhz_rk")
     private Float hhzrk;
	
	 @Column(name = "mz_rk")
     private Float mzrk;
	
	 @Column(name = "wwez_rk")
     private Float wwezrk;

	 @Column(name = "fj_rk")
     private Float fjrk;

	 @Column(name = "ysl_rk")
     private Float yslrk;
	
	 @Column(name = "tz_rk")
     private Float tzrk;

	 @Column(name = "jd_rk")
     private Float jdrk;
	
	 @Column(name = "create_time")
     private Timestamp createTime;
	 @Column(name = "update_time")
     private Timestamp updateTime;
	 @Column(name = "delete_time")
     private Timestamp deleteTime;
	 @Column(name = "delete_state", length = 32 )
     private String deleteState;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Float getTotal() {
		return total;
	}
	public void setTotal(Float total) {
		this.total = total;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Float getHzrk() {
		return hzrk;
	}
	public void setHzrk(Float hzrk) {
		this.hzrk = hzrk;
	}
	public Float getZzrk() {
		return zzrk;
	}
	public void setZzrk(Float zzrk) {
		this.zzrk = zzrk;
	}
	public Integer getTyear() {
		return tyear;
	}
	public void setTyear(Integer tyear) {
		this.tyear = tyear;
	}
	public Float getHhzrk() {
		return hhzrk;
	}
	public void setHhzrk(Float hhzrk) {
		this.hhzrk = hhzrk;
	}
	public Float getMzrk() {
		return mzrk;
	}
	public void setMzrk(Float mzrk) {
		this.mzrk = mzrk;
	}
	public Float getWwezrk() {
		return wwezrk;
	}
	public void setWwezrk(Float wwezrk) {
		this.wwezrk = wwezrk;
	}
	public Float getFjrk() {
		return fjrk;
	}
	public void setFjrk(Float fjrk) {
		this.fjrk = fjrk;
	}
	public Float getYslrk() {
		return yslrk;
	}
	public void setYslrk(Float yslrk) {
		this.yslrk = yslrk;
	}
	public Float getTzrk() {
		return tzrk;
	}
	public void setTzrk(Float tzrk) {
		this.tzrk = tzrk;
	}
	public Float getJdrk() {
		return jdrk;
	}
	public void setJdrk(Float jdrk) {
		this.jdrk = jdrk;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	public Timestamp getDeleteTime() {
		return deleteTime;
	}
	public void setDeleteTime(Timestamp deleteTime) {
		this.deleteTime = deleteTime;
	}
	public String getDeleteState() {
		return deleteState;
	}
	public void setDeleteState(String deleteState) {
		this.deleteState = deleteState;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
