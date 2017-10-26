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
 * 人民生活历年数据
 * @author Administrator
 *
 */
@Entity
@Table(name = "t_rmsh_lnsh")
public class RmshLnsh extends Pojo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 32)
	private String id;//              unsigned bigint              主键
	
	@Column(name = "nian")
	private Integer nian;//            int                          年份
	
	@Column(name = "engels")
	private BigDecimal engels;//          decimal(10,2)                恩格尔系数
	
	@Column(name = "cz_kzpsr")
	private BigDecimal cz_kzpsr;//        decimal(10,2)                城镇居民可支配收入（万元）
	
	@Column(name = "rjck")
	private BigDecimal rjck;//            decimal(10,2)                人均存款（万元）
	
	@Column(name = "rjgdp")
	private BigDecimal rjgdp;//           decimal(10,2)                人均GDP（万元）
	
	@Column(name = "nc_jmcsr")
	private BigDecimal nc_jmcsr;//        decimal(10,2)                农村居民纯收入
	
	@Column(name = "dbrs")
	private BigDecimal dbrs;//            decimal(10,2)                低保人数（万人）
	
	@Column(name = "csdbrs")
	private BigDecimal csdbrs;//          decimal(10,2)                城市低保人数（万人）
	
	@Column(name = "ncdbrs")
	private BigDecimal ncdbrs;//          decimal(10,2)                农村低保人数（万人）
	
	@Column(name = "dbffje")
	private BigDecimal dbffje;//          decimal(10,2)                低保发放金额（亿元）
	
	@Column(name = "csdbffje")
	private BigDecimal csdbffje;//       decimal(10,2)                城市低保发放金额
	
	@Column(name = "ncdbffje")
	private BigDecimal ncdbffje;//        decimal(10,2)                农村低保发放金额
	
	@Column(name = "create_time")
	private Timestamp create_time;//    timestamp                    创建时间
	
	@Column(name = "update_time")
	private Timestamp update_time;//     timestamp                    更新时间
	
	@Column(name = "delete_time")
	private Timestamp delete_time;//     timestamp                    删除时间
	
	@Column(name = "delete_state")
	private Integer delete_state;//    unsigned tinyint             1已删除，0正常

	public Integer getNian() {
		return nian;
	}
	public BigDecimal getEngels() {
		return engels;
	}
	public BigDecimal getCz_kzpsr() {
		return cz_kzpsr;
	}
	public BigDecimal getRjck() {
		return rjck;
	}
	public BigDecimal getRjgdp() {
		return rjgdp;
	}
	public BigDecimal getNc_jmcsr() {
		return nc_jmcsr;
	}
	public BigDecimal getDbrs() {
		return dbrs;
	}
	public BigDecimal getCsdbrs() {
		return csdbrs;
	}
	public BigDecimal getNcdbrs() {
		return ncdbrs;
	}
	public BigDecimal getDbffje() {
		return dbffje;
	}
	public BigDecimal getCsdbffje() {
		return csdbffje;
	}
	public BigDecimal getNcdbffje() {
		return ncdbffje;
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
	public void setNian(Integer nian) {
		this.nian = nian;
	}
	public void setEngels(BigDecimal engels) {
		this.engels = engels;
	}
	public void setCz_kzpsr(BigDecimal cz_kzpsr) {
		this.cz_kzpsr = cz_kzpsr;
	}
	public void setRjck(BigDecimal rjck) {
		this.rjck = rjck;
	}
	public void setRjgdp(BigDecimal rjgdp) {
		this.rjgdp = rjgdp;
	}
	public void setNc_jmcsr(BigDecimal nc_jmcsr) {
		this.nc_jmcsr = nc_jmcsr;
	}
	public void setDbrs(BigDecimal dbrs) {
		this.dbrs = dbrs;
	}
	public void setCsdbrs(BigDecimal csdbrs) {
		this.csdbrs = csdbrs;
	}
	public void setNcdbrs(BigDecimal ncdbrs) {
		this.ncdbrs = ncdbrs;
	}
	public void setDbffje(BigDecimal dbffje) {
		this.dbffje = dbffje;
	}
	public void setCsdbffje(BigDecimal csdbffje) {
		this.csdbffje = csdbffje;
	}
	public void setNcdbffje(BigDecimal ncdbffje) {
		this.ncdbffje = ncdbffje;
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
