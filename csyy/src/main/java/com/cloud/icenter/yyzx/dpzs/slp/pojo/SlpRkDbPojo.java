package com.cloud.icenter.yyzx.dpzs.slp.pojo;

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
 * 三联屏低保大数据
 * 
 * @author dbchenga
 */
@Entity
@Table(name = "t_slp_rk_db")
public class SlpRkDbPojo extends Pojo {

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

	@Column(name = "dbzrk")
	private Integer dbzrk;// 低保总人口

	@Column(name = "zb")
	private Float zb;// 占比
	@Column(name = "cz")
	private Integer cz;// 城镇人口
	@Column(name = "nc")
	private Integer nc;// 农村人口
	@Column(name = "czbz")
	private Integer czbz;// 城镇补助

	@Column(name = "ncbz")
	private Integer ncbz;// 农村补助
	@Column(name = "czdbzj")
	private Integer czdbzj;// 城镇低保资金
	@Column(name = "ncdbzj")
	private Integer ncdbzj;// 农村低保资金
	@Column(name = "nctkry")
	private Integer nctkry;// 农村特困人员救助供养

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

	public Integer getDbzrk() {
		return dbzrk;
	}

	public void setDbzrk(Integer dbzrk) {
		this.dbzrk = dbzrk;
	}

	public Float getZb() {
		return zb;
	}

	public void setZb(Float zb) {
		this.zb = zb;
	}

	public Integer getCz() {
		return cz;
	}

	public void setCz(Integer cz) {
		this.cz = cz;
	}

	public Integer getNc() {
		return nc;
	}

	public void setNc(Integer nc) {
		this.nc = nc;
	}

	public Integer getCzbz() {
		return czbz;
	}

	public void setCzbz(Integer czbz) {
		this.czbz = czbz;
	}

	public Integer getNcbz() {
		return ncbz;
	}

	public void setNcbz(Integer ncbz) {
		this.ncbz = ncbz;
	}

	public Integer getCzdbzj() {
		return czdbzj;
	}

	public void setCzdbzj(Integer czdbzj) {
		this.czdbzj = czdbzj;
	}

	public Integer getNcdbzj() {
		return ncdbzj;
	}

	public void setNcdbzj(Integer ncdbzj) {
		this.ncdbzj = ncdbzj;
	}

	public Integer getNctkry() {
		return nctkry;
	}

	public void setNctkry(Integer nctkry) {
		this.nctkry = nctkry;
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
