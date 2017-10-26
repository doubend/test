package com.cloud.icenter.yyzx.dpzs.dp.pojo;

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
 * 大屏-精准扶贫-大屏精准扶贫措施
 * 
 * @author dbchenga
 */
@Entity
@Table(name = "t_dp_jzfp_cs")
public class DpJzfpcsPojo extends Pojo {

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

	@Column(name = "cs")
	private String cs;// 扶贫措施

	@Column(name = "cun")
	private Integer cun;// 贫困村
	@Column(name = "hu")
	private Integer hu;// 贫困户
	@Column(name = "ren")
	private Integer ren;// 人口

	@Column(name = "parent")
	private Float parent;// 人口

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

	public String getCs() {
		return cs;
	}

	public void setCs(String cs) {
		this.cs = cs;
	}

	public Integer getCun() {
		return cun;
	}

	public void setCun(Integer cun) {
		this.cun = cun;
	}

	public Integer getHu() {
		return hu;
	}

	public void setHu(Integer hu) {
		this.hu = hu;
	}

	public Integer getRen() {
		return ren;
	}

	public void setRen(Integer ren) {
		this.ren = ren;
	}

	public Float getParent() {
		return parent;
	}

	public void setParent(Float parent) {
		this.parent = parent;
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
