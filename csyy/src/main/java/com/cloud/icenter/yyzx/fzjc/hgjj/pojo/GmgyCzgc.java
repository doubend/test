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
 * 工业总产值构成
 * 
 * @author Administrator
 *
 */
@Entity
@Table(name = "t_jjfz_gmgy_czgc")
public class GmgyCzgc extends Pojo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 32)
	private String id;// unsigned bigint 主键

	@Column(name = "nian")
	private Integer nian;// int 年份

	@Column(name = "gocx")
	private String gocx;// varchar(20) 行业名称

	@Column(name = "gyzjz")
	private BigDecimal gyzjz;// decimal 行业增加值

	@Column(name = "gyzjztbzz")
	private BigDecimal gyzjztbzz;// decimal 行业增加值同比增长

	@Column(name = "gyscz")
	private BigDecimal gyscz;// decimal 行业生产值
	
	@Column(name = "gyscztbzz")
	private BigDecimal gyscztbzz;// decimal 行业生产值同比增长

	@Column(name = "create_time")
	private Timestamp create_time;// timestamp 创建时间

	@Column(name = "update_time")
	private Timestamp update_time;// timestamp 更新时间

	@Column(name = "delete_time")
	private Timestamp delete_time;// timestamp 删除时间

	@Column(name = "delete_state")
	private Integer delete_state;// unsigned tinyint 1已删除，0正常

	public Integer getNian() {
		return nian;
	}

	public String getGocx() {
		return gocx;
	}

	public BigDecimal getGyzjz() {
		return gyzjz;
	}

	public void setGyzjz(BigDecimal gyzjz) {
		this.gyzjz = gyzjz;
	}

	public BigDecimal getGyzjztbzz() {
		return gyzjztbzz;
	}

	public void setGyzjztbzz(BigDecimal gyzjztbzz) {
		this.gyzjztbzz = gyzjztbzz;
	}

	public BigDecimal getGyscz() {
		return gyscz;
	}

	public void setGyscz(BigDecimal gyscz) {
		this.gyscz = gyscz;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Timestamp getCreate_time() {
		return create_time;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Timestamp getUpdate_time() {
		return update_time;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
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

	public void setGocx(String gocx) {
		this.gocx = gocx;
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
