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
 * 大屏-精准扶贫-资金
 * 
 * @author dbchenga
 */
@Entity
@Table(name = "t_dp_jzfp_zj")
public class DpJzfpzjPojo extends Pojo {

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

	@Column(name = "guojia")
	private Integer guojia;// 国家

	@Column(name = "sheng")
	private Integer sheng;// 省
	@Column(name = "shi")
	private Integer shi;// 市
	@Column(name = "qu")
	private Integer qu;// 区
	@Column(name = "zongji")
	private Integer zongji;// 总计
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

	public Integer getGuojia() {
		return guojia;
	}

	public void setGuojia(Integer guojia) {
		this.guojia = guojia;
	}

	public Integer getSheng() {
		return sheng;
	}

	public void setSheng(Integer sheng) {
		this.sheng = sheng;
	}

	public Integer getShi() {
		return shi;
	}

	public void setShi(Integer shi) {
		this.shi = shi;
	}

	public Integer getQu() {
		return qu;
	}

	public void setQu(Integer qu) {
		this.qu = qu;
	}

	public Integer getZongji() {
		return zongji;
	}

	public void setZongji(Integer zongji) {
		this.zongji = zongji;
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
