package com.cloud.icenter.yyzx.fzjc.rk.pojo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.cloud.icenter.base.pojo.Pojo;




/**
 * 民族 宗教占比返回实体
 * @date 2017年9月27日
 * @author dxliug
 */
@Entity
@Table(name = "t_renk_rkfb_mzzj")
public class MzzjResult extends Pojo{
	     
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
		  * 少数民族总人
		  */
		 @Column(name = "ssmz_total")
		 private Float ssmzTotal;
		 @Column(name = "hz_rk")
	     private Float hzrk;
		 
		 @Column(name = "hz_zb")
	     private Float hzzb;
		 
		 @Column(name = "zz_rk")
	     private Float zzrk;
		 
		 @Column(name = "zz_zb")
	     private Float zzzb;
		 
		 @Column(name = "tyear",length = 1)
		 private Integer tyear;
		 
		 @Column(name = "hhz_rk")
	     private Float hhzrk;
		 @Column(name = "hhz_zb")
	     private Float hhzzb;
		 @Column(name = "mz_rk")
	     private Float mzrk;
		 @Column(name = "mz_zb")
	     private Float mzzb;
		 @Column(name = "wwez_rk")
	     private Float wwezrk;
		 @Column(name = "wwez_zb")
	     private Float wwezzb;
		 @Column(name = "fj_rk")
	     private Float fjrk;
		 @Column(name = "fj_zb")
	     private Float fjzb;
		 @Column(name = "ysl_rk")
	     private Float yslrk;
		 @Column(name = "ysl_zb")
	     private Float yslzb;
		 @Column(name = "tz_rk")
	     private Float tzrk;
		 @Column(name = "tz_zb")
	     private Float tzzb;
		 @Column(name = "jd_rk")
	     private Float jdrk;
		 @Column(name = "jd_zb")
	     private Float jdzb;
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
		public Float getHzrk() {
			return hzrk;
		}
		public void setHzrk(Float hzrk) {
			this.hzrk = hzrk;
		}
		public Float getHzzb() {
			return hzzb;
		}
		public void setHzzb(Float hzzb) {
			this.hzzb = hzzb;
		}
		public Float getZzrk() {
			return zzrk;
		}
		public void setZzrk(Float zzrk) {
			this.zzrk = zzrk;
		}
		public Float getZzzb() {
			return zzzb;
		}
		public void setZzzb(Float zzzb) {
			this.zzzb = zzzb;
		}
		public Float getHhzrk() {
			return hhzrk;
		}
		public void setHhzrk(Float hhzrk) {
			this.hhzrk = hhzrk;
		}
		public Float getHhzzb() {
			return hhzzb;
		}
		public void setHhzzb(Float hhzzb) {
			this.hhzzb = hhzzb;
		}
		public Float getMzrk() {
			return mzrk;
		}
		public void setMzrk(Float mzrk) {
			this.mzrk = mzrk;
		}
		public Float getMzzb() {
			return mzzb;
		}
		public void setMzzb(Float mzzb) {
			this.mzzb = mzzb;
		}
		public Float getWwezrk() {
			return wwezrk;
		}
		public void setWwezrk(Float wwezrk) {
			this.wwezrk = wwezrk;
		}
		public Float getWwezzb() {
			return wwezzb;
		}
		public void setWwezzb(Float wwezzb) {
			this.wwezzb = wwezzb;
		}
		public Float getFjrk() {
			return fjrk;
		}
		public void setFjrk(Float fjrk) {
			this.fjrk = fjrk;
		}
		public Float getFjzb() {
			return fjzb;
		}
		public void setFjzb(Float fjzb) {
			this.fjzb = fjzb;
		}
		public Float getYslrk() {
			return yslrk;
		}
		public void setYslrk(Float yslrk) {
			this.yslrk = yslrk;
		}
		public Float getYslzb() {
			return yslzb;
		}
		public void setYslzb(Float yslzb) {
			this.yslzb = yslzb;
		}
		public Float getTzrk() {
			return tzrk;
		}
		public void setTzrk(Float tzrk) {
			this.tzrk = tzrk;
		}
		public Float getTzzb() {
			return tzzb;
		}
		public void setTzzb(Float tzzb) {
			this.tzzb = tzzb;
		}
		public Float getJdrk() {
			return jdrk;
		}
		public void setJdrk(Float jdrk) {
			this.jdrk = jdrk;
		}
		public Float getJdzb() {
			return jdzb;
		}
		public void setJdzb(Float jdzb) {
			this.jdzb = jdzb;
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
		public Float getSsmzTotal() {
			return ssmzTotal;
		}
		public void setSsmzTotal(Float ssmzTotal) {
			this.ssmzTotal = ssmzTotal;
		}
		public Integer getTyear() {
			return tyear;
		}
		public void setTyear(Integer tyear) {
			this.tyear = tyear;
		}
}
