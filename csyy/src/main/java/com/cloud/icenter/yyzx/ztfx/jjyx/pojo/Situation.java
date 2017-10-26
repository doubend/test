package com.cloud.icenter.yyzx.ztfx.jjyx.pojo;

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
 * 工业经济概况
 * @author Administrator
 *
 */
@Entity
@Table(name = "t_jjfz_jjyx_jjgk")
public class Situation extends Pojo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 32)
	private String id;//                        varchar(32)       主键
	
	@Column(name = "tyear")
	private Integer tyear;//                     char(4)           年份
	
	@Column(name = "smonth")
	private Integer smonth;//                    char(2)           起始月
	
	@Column(name = "emonth")
	private Integer emonth;//                   char(2)           到某月
	
	@Column(name = "gyzjz")
	private BigDecimal gyzjz;//                     float             工业增加值
	
	@Column(name = "gyzjz_tbzz")
	private BigDecimal gyzjz_tbzz;//                float             同比增长
	
	@Column(name = "degyzcz")
	private BigDecimal degyzcz;//                   float             全省第二工业总产值
	
	@Column(name = "degyzcz_tbzz")
	private BigDecimal degyzcz_tbzz;//              float             同比增长
	
	@Column(name = "sevendcyzcz")
	private BigDecimal sevendcyzcz;//                   float             七大产业总产值
	
	@Column(name = "sevendcyzcz_tbzz")
	private BigDecimal sevendcyzcz_tbzz;//              float             同比增长
	
	@Column(name = "gyzczzb")
	private BigDecimal gyzczzb;//                  float             工业总产值占比
	
	@Column(name = "zysr")
	private BigDecimal zysr;//                      float             主营收入
	
	@Column(name = "zysr_tbzz")
	private BigDecimal zysr_tbzz;//                 float             主营收入同步增长
	
	@Column(name = "lr")
	private BigDecimal lr;//                       float             利润
	
	@Column(name = "lr_tbzz")
	private BigDecimal lr_tbzz;//                   float             利润同步增长
	
	@Column(name = "sj")
	private BigDecimal sj;//                       float             税金
	
	@Column(name = "sj_tbzz")
	private BigDecimal sj_tbzz;//                  float             税金同步增长
	
	@Column(name = "qspm")
	private Integer qspm; //全省排名
	
	@Column(name = "create_time")
	private Timestamp create_time;//              timestamp         创建时间
	
	@Column(name = "update_time")
	private Timestamp update_time;//               timestamp         更新时间
	
	@Column(name = "delete_time")
	private Timestamp delete_time;//              timestamp         删除时间
	
	@Column(name = "delete_state")
	private Integer delete_state;//              char(1)           1已删除，0正常

	public Integer getTyear() {
		return tyear;
	}

	public Integer getSmonth() {
		return smonth;
	}

	public Integer getEmonth() {
		return emonth;
	}

	public BigDecimal getGyzjz() {
		return gyzjz;
	}

	public BigDecimal getGyzjz_tbzz() {
		return gyzjz_tbzz;
	}

	public BigDecimal getDegyzcz() {
		return degyzcz;
	}

	public BigDecimal getDegyzcz_tbzz() {
		return degyzcz_tbzz;
	}

	public BigDecimal getSevendcyzcz() {
		return sevendcyzcz;
	}

	public BigDecimal getSevendcyzcz_tbzz() {
		return sevendcyzcz_tbzz;
	}

	public BigDecimal getGyzczzb() {
		return gyzczzb;
	}

	public BigDecimal getZysr() {
		return zysr;
	}

	public BigDecimal getZysr_tbzz() {
		return zysr_tbzz;
	}

	public BigDecimal getLr() {
		return lr;
	}

	public BigDecimal getLr_tbzz() {
		return lr_tbzz;
	}

	public BigDecimal getSj() {
		return sj;
	}

	public BigDecimal getSj_tbzz() {
		return sj_tbzz;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	public Timestamp getCreate_time() {
		return create_time;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	public Timestamp getUpdate_time() {
		return update_time;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
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

	public void setTyear(Integer tyear) {
		this.tyear = tyear;
	}

	public void setSmonth(Integer smonth) {
		this.smonth = smonth;
	}

	public void setEmonth(Integer emonth) {
		this.emonth = emonth;
	}

	public void setGyzjz(BigDecimal gyzjz) {
		this.gyzjz = gyzjz;
	}

	public void setGyzjz_tbzz(BigDecimal gyzjz_tbzz) {
		this.gyzjz_tbzz = gyzjz_tbzz;
	}

	public void setDegyzcz(BigDecimal degyzcz) {
		this.degyzcz = degyzcz;
	}

	public void setDegyzcz_tbzz(BigDecimal degyzcz_tbzz) {
		this.degyzcz_tbzz = degyzcz_tbzz;
	}

	public void setSevendcyzcz(BigDecimal sevendcyzcz) {
		this.sevendcyzcz = sevendcyzcz;
	}

	public void setSevendcyzcz_tbzz(BigDecimal sevendcyzcz_tbzz) {
		this.sevendcyzcz_tbzz = sevendcyzcz_tbzz;
	}

	public void setGyzczzb(BigDecimal gyzczzb) {
		this.gyzczzb = gyzczzb;
	}

	public void setZysr(BigDecimal zysr) {
		this.zysr = zysr;
	}

	public void setZysr_tbzz(BigDecimal zysr_tbzz) {
		this.zysr_tbzz = zysr_tbzz;
	}

	public void setLr(BigDecimal lr) {
		this.lr = lr;
	}

	public void setLr_tbzz(BigDecimal lr_tbzz) {
		this.lr_tbzz = lr_tbzz;
	}

	public void setSj(BigDecimal sj) {
		this.sj = sj;
	}

	public void setSj_tbzz(BigDecimal sj_tbzz) {
		this.sj_tbzz = sj_tbzz;
	}

	public Integer getQspm() {
		return qspm;
	}

	public void setQspm(Integer qspm) {
		this.qspm = qspm;
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
