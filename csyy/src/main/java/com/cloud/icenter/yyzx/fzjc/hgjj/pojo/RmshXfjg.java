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
 * 居民消费价格基本情况
 * @author Administrator
 *
 */
@Entity
@Table(name = "t_rmsh_xfjg")
public class RmshXfjg extends Pojo{

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
	
	@Column(name = "yuef")
	private Integer yuef;//            int                          月份
	
	@Column(name = "tobi")
	private BigDecimal tobi;//            decimal(10,2)                同比
	
	@Column(name = "hubi")
	private BigDecimal hubi;//            decimal(10,2)                环比
	
	@Column(name = "create_time")
	private Timestamp create_time;//     timestamp                    创建时间
	
	@Column(name = "update_time")
	private Timestamp update_time;//     timestamp                    更新时间
	
	@Column(name = "delete_time")
	private Timestamp delete_time;//     timestamp                    删除时间
	
	@Column(name = "delete_state")
	private Integer delete_state;//    unsigned tinyint             1已删除，0正常

	public Integer getNian() {
		return nian;
	}
	public Integer getYuef() {
		return yuef;
	}
	public BigDecimal getTobi() {
		return tobi;
	}
	public BigDecimal getHubi() {
		return hubi;
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
	public void setYuef(Integer yuef) {
		this.yuef = yuef;
	}
	public void setTobi(BigDecimal tobi) {
		this.tobi = tobi;
	}
	public void setHubi(BigDecimal hubi) {
		this.hubi = hubi;
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
