package com.cloud.icenter.yyzx.dpzs.dp.pojo;

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
 * 大屏-精准扶贫-大屏精准扶贫任务
 * 
 * @author dbchenga
 */
@Entity
@Table(name = "t_dp_jzfp_rw")
public class DpJzfprwPojo extends Pojo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "ID", unique = true, nullable = false, length = 32)
	private String id;

	@Column(name = "year")
	private Integer year;// 年份

	@Column(name = "cun")
	private BigDecimal cun;// 贫困村
	@Column(name = "hu")
	private BigDecimal hu;// 贫困户
	@Column(name = "ren")
	private BigDecimal ren;// 人口

	private BigDecimal cun_mn;// 下一年贫困村
	private BigDecimal hu_mn;// 下一年贫困户
	private BigDecimal ren_mn;// 下一年人口

	private BigDecimal cun_hn;// 下两年贫困村
	private BigDecimal hu_hn;// 下两年贫困户
	private BigDecimal ren_hn;// 下两年人口

	@Column(name = "status")
	private Integer status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time", length = 7)
	private Date create_time;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_time", length = 7)
	private Date update_time;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "remove_time", length = 7)
	private Date remove_time;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public BigDecimal getCun() {
		return cun;
	}

	public void setCun(BigDecimal cun) {
		this.cun = cun;
	}

	public BigDecimal getHu() {
		return hu;
	}

	public void setHu(BigDecimal hu) {
		this.hu = hu;
	}

	public BigDecimal getRen() {
		return ren;
	}

	public void setRen(BigDecimal ren) {
		this.ren = ren;
	}

	public BigDecimal getCun_mn() {
		return cun_mn;
	}

	public void setCun_mn(BigDecimal cun_mn) {
		this.cun_mn = cun_mn;
	}

	public BigDecimal getHu_mn() {
		return hu_mn;
	}

	public void setHu_mn(BigDecimal hu_mn) {
		this.hu_mn = hu_mn;
	}

	public BigDecimal getRen_mn() {
		return ren_mn;
	}

	public void setRen_mn(BigDecimal ren_mn) {
		this.ren_mn = ren_mn;
	}

	public BigDecimal getCun_hn() {
		return cun_hn;
	}

	public void setCun_hn(BigDecimal cun_hn) {
		this.cun_hn = cun_hn;
	}

	public BigDecimal getHu_hn() {
		return hu_hn;
	}

	public void setHu_hn(BigDecimal hu_hn) {
		this.hu_hn = hu_hn;
	}

	public BigDecimal getRen_hn() {
		return ren_hn;
	}

	public void setRen_hn(BigDecimal ren_hn) {
		this.ren_hn = ren_hn;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	public Date getRemove_time() {
		return remove_time;
	}

	public void setRemove_time(Date remove_time) {
		this.remove_time = remove_time;
	}

}
