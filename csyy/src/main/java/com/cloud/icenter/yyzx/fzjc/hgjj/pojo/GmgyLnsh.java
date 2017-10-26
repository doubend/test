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
 * 规模工业历年数据汇总
 * @author Administrator
 *
 */
@Entity
@Table(name = "t_jjfz_gmgy_lnsj")
public class GmgyLnsh extends Pojo{

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
	
	@Column(name = "zejz")
	private BigDecimal zejz;//            decimal                      增加值
	
	@Column(name = "touz")
	private BigDecimal touz;//            decimal                      投资
	
	@Column(name = "gdp")
	private BigDecimal gdp;//             decimal                      GDP
	
	@Column(name = "zocz")
	private BigDecimal zocz;//            decimal                      工业总产值
	
	@Column(name = "zensu")
	private BigDecimal zensu;//           decimal                      增速
	
	@Column(name = "cyzsu")
	private BigDecimal cyzsu;//           decimal                      产业增速
	
	@Column(name = "zczzb")
	private BigDecimal zczzb;//           decimal                      工业总产值占比
	
	@Column(name = "zjze")
	private BigDecimal zjze;//            decimal                      资金总额
	
	@Column(name = "zysr")
	private BigDecimal zysr;//            decimal                      主营业收入
	
	@Column(name = "lrze")
	private BigDecimal lrze;//            decimal                      利润总额
	
	@Column(name = "gycxl")
	private BigDecimal gycxl;//           decimal                      工业产效率
	
	@Column(name = "zyywsr")
	private BigDecimal zyywsr;//          decimal                      主营业务收入
	
	@Column(name = "ckzz")
	private BigDecimal ckzz;//            decimal                      出口总值
	
	@Column(name = "jkzz")
	private BigDecimal jkzz;//            decimal                      进口总值
	
	@Column(name = "lrwz")
	private BigDecimal lrwz;//            decimal                      利用外资（亿元）
	
	@Column(name = "yodl")
	private BigDecimal yodl;//            decimal                      用电量（万千瓦时）
	
	@Column(name = "create_time")
	private Timestamp create_time;//     timestamp                    创建时间
	
	@Column(name = "update_time")
	private Timestamp update_time;//     timestamp                    更新时间
	
	@Column(name = "delete_time")
	private Timestamp delete_time;//     timestamp                    删除时间
	
	@Column(name = "delete_state")
	private int delete_state;//    unsigned tinyint             1已删除，0正常

	public Integer getNian() {
		return nian;
	}
	public BigDecimal getZejz() {
		return zejz;
	}
	public BigDecimal getTouz() {
		return touz;
	}
	public BigDecimal getGdp() {
		return gdp;
	}
	public BigDecimal getZocz() {
		return zocz;
	}
	public BigDecimal getZensu() {
		return zensu;
	}
	public BigDecimal getCyzsu() {
		return cyzsu;
	}
	public BigDecimal getZczzb() {
		return zczzb;
	}
	public BigDecimal getZjze() {
		return zjze;
	}
	public BigDecimal getZysr() {
		return zysr;
	}
	public BigDecimal getLrze() {
		return lrze;
	}
	public BigDecimal getGycxl() {
		return gycxl;
	}
	public BigDecimal getZyywsr() {
		return zyywsr;
	}
	public BigDecimal getCkzz() {
		return ckzz;
	}
	public BigDecimal getJkzz() {
		return jkzz;
	}
	public BigDecimal getLrwz() {
		return lrwz;
	}
	public BigDecimal getYodl() {
		return yodl;
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
	public int getDelete_state() {
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
	public void setZejz(BigDecimal zejz) {
		this.zejz = zejz;
	}
	public void setTouz(BigDecimal touz) {
		this.touz = touz;
	}
	public void setGdp(BigDecimal gdp) {
		this.gdp = gdp;
	}
	public void setZocz(BigDecimal zocz) {
		this.zocz = zocz;
	}
	public void setZensu(BigDecimal zensu) {
		this.zensu = zensu;
	}
	public void setCyzsu(BigDecimal cyzsu) {
		this.cyzsu = cyzsu;
	}
	public void setZczzb(BigDecimal zczzb) {
		this.zczzb = zczzb;
	}
	public void setZjze(BigDecimal zjze) {
		this.zjze = zjze;
	}
	public void setZysr(BigDecimal zysr) {
		this.zysr = zysr;
	}
	public void setLrze(BigDecimal lrze) {
		this.lrze = lrze;
	}
	public void setGycxl(BigDecimal gycxl) {
		this.gycxl = gycxl;
	}
	public void setZyywsr(BigDecimal zyywsr) {
		this.zyywsr = zyywsr;
	}
	public void setCkzz(BigDecimal ckzz) {
		this.ckzz = ckzz;
	}
	public void setJkzz(BigDecimal jkzz) {
		this.jkzz = jkzz;
	}
	public void setLrwz(BigDecimal lrwz) {
		this.lrwz = lrwz;
	}
	public void setYodl(BigDecimal yodl) {
		this.yodl = yodl;
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
	public void setDelete_state(int delete_state) {
		this.delete_state = delete_state;
	}
	
	

}
