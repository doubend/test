package com.cloud.icenter.yyzx.fzjc.hgjj.pojo;

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
 * 城镇居民人均可支配收入情况
 * @author Administrator
 *
 */
@Entity
@Table(name = "t_rmsh_shru")
public class RmshShru extends Pojo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 32)
	private String id;//              unsigned bigint              主键
	
	@Column(name = "cz_zsru")
	private BigDecimal cz_zsru;//         decimal(10,2)                城镇居民总收入
	
	@Column(name = "cz_gzxsr")
	private BigDecimal cz_gzxsr;//        decimal(10,2)                城镇居民工资性收入
	
	@Column(name = "cz_jyxsr")
	private BigDecimal cz_jyxsr;//        decimal(10,2)                城镇居民经营性收入
	
	@Column(name = "cz_ccxsr")
	private BigDecimal cz_ccxsr;//        decimal(10,2)                城镇居民财产性收入
	
	@Column(name = "cz_zyxsr")
	private BigDecimal cz_zyxsr;//        decimal(10,2)                城镇居民转移性收入
	
	@Column(name = "cz_rjsr")
	private BigDecimal cz_rjsr;//			decimal(10,2) 				 城镇居民人均可支配收入
	
	@Column(name = "cz_zesu")
	private BigDecimal cz_zesu;//        decimal(10,2)                城镇增速
	
	@Column(name = "nc_zsru")
	private BigDecimal nc_zsru;//         decimal(10,2)                农村居民总收入
	
	@Column(name = "nc_gzxsr")
	private BigDecimal nc_gzxsr;//        decimal(10,2)                农村居民工资性收入
	
	@Column(name = "nc_jyxsr")
	private BigDecimal nc_jyxsr;//        decimal(10,2)                农村居民经营性收入
	
	@Column(name = "nc_ccxsr")
	private BigDecimal nc_ccxsr;//        decimal(10,2)                农村居民财产性收入
	
	@Column(name = "nc_zyxsr")
	private BigDecimal nc_zyxsr;//       decimal(10,2)                农村居民转移性收入
	
	@Column(name = "nc_rjsr")
	private BigDecimal nc_rjsr;//			decimal(10,2) 				 农村居民人均可支配收入
	
	@Column(name = "nc_zesu")
	private BigDecimal nc_zesu;//        decimal(10,2)                农村增速
	
	@Column(name = "create_time")
	private Timestamp create_time;//     timestamp                    创建时间
	
	@Column(name = "update_time")
	private Timestamp update_time;//     timestamp                    更新时间
	
	@Column(name = "delete_time")
	private Timestamp delete_time;//     timestamp                    删除时间
	
	@Column(name = "delete_state")
	private Integer delete_state;//    unsigned tinyint             1已删除，0正常

	public BigDecimal getCz_zsru() {
		return cz_zsru;
	}
	public BigDecimal getCz_gzxsr() {
		return cz_gzxsr;
	}
	public BigDecimal getCz_jyxsr() {
		return cz_jyxsr;
	}
	public BigDecimal getCz_ccxsr() {
		return cz_ccxsr;
	}
	public BigDecimal getCz_zyxsr() {
		return cz_zyxsr;
	}
	public BigDecimal getCz_rjsr() {
		return cz_rjsr;
	}
	public BigDecimal getCz_zesu() {
		return cz_zesu;
	}
	public BigDecimal getNc_zsru() {
		return nc_zsru;
	}
	public BigDecimal getNc_gzxsr() {
		return nc_gzxsr;
	}
	public BigDecimal getNc_jyxsr() {
		return nc_jyxsr;
	}
	public BigDecimal getNc_ccxsr() {
		return nc_ccxsr;
	}
	public BigDecimal getNc_zyxsr() {
		return nc_zyxsr;
	}
	public BigDecimal getNc_rjsr() {
		return nc_rjsr;
	}
	public BigDecimal getNc_zesu() {
		return nc_zesu;
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
	public void setCz_zsru(BigDecimal cz_zsru) {
		this.cz_zsru = cz_zsru;
	}
	public void setCz_gzxsr(BigDecimal cz_gzxsr) {
		this.cz_gzxsr = cz_gzxsr;
	}
	public void setCz_jyxsr(BigDecimal cz_jyxsr) {
		this.cz_jyxsr = cz_jyxsr;
	}
	public void setCz_ccxsr(BigDecimal cz_ccxsr) {
		this.cz_ccxsr = cz_ccxsr;
	}
	public void setCz_zyxsr(BigDecimal cz_zyxsr) {
		this.cz_zyxsr = cz_zyxsr;
	}
	public void setCz_rjsr(BigDecimal cz_rjsr) {
		this.cz_rjsr = cz_rjsr;
	}
	public void setCz_zesu(BigDecimal cz_zesu) {
		this.cz_zesu = cz_zesu;
	}
	public void setNc_zsru(BigDecimal nc_zsru) {
		this.nc_zsru = nc_zsru;
	}
	public void setNc_gzxsr(BigDecimal nc_gzxsr) {
		this.nc_gzxsr = nc_gzxsr;
	}
	public void setNc_jyxsr(BigDecimal nc_jyxsr) {
		this.nc_jyxsr = nc_jyxsr;
	}
	public void setNc_ccxsr(BigDecimal nc_ccxsr) {
		this.nc_ccxsr = nc_ccxsr;
	}
	public void setNc_zyxsr(BigDecimal nc_zyxsr) {
		this.nc_zyxsr = nc_zyxsr;
	}
	public void setNc_rjsr(BigDecimal nc_rjsr) {
		this.nc_rjsr = nc_rjsr;
	}
	public void setNc_zesu(BigDecimal nc_zesu) {
		this.nc_zesu = nc_zesu;
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
