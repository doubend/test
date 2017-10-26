package com.cloud.icenter.yyzx.fzjc.rk.pojo;

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
 * 流出(入)人口职业分布(单位：万人)
 * @author Administrator
 *
 */
@Entity
@Table(name = "t_renk_ldrk_zyfb")
public class Jobdistribution extends Pojo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 32)
	private String id;//                        varchar(32)       主键
	
	@Column(name = "type")
	private Integer type;//                      cahr(1)           1流出人口，2流入人口
	
	@Column(name = "occupation", length = 50)
	private String occupation;//                varchar(50)       职业
	
	@Column(name = "scale")
	private BigDecimal scale;//                     float             占比
	
	@Column(name = "create_time")
	private Timestamp create_time;//              timestamp         创建时间
	
	@Column(name = "update_time")
	private Timestamp update_time;//               timestamp         更新时间
	
	@Column(name = "delete_time")
	private Timestamp delete_time;//              timestamp         删除时间
	
	@Column(name = "delete_state")
	private Integer delete_state;//              char(1)           1已删除，0正常

	public Integer getType() {
		return type;
	}

	public String getOccupation() {
		return occupation;
	}

	public BigDecimal getScale() {
		return scale;
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

	public void setType(Integer type) {
		this.type = type;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public void setScale(BigDecimal scale) {
		this.scale = scale;
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
