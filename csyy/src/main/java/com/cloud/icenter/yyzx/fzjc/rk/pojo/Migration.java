package com.cloud.icenter.yyzx.fzjc.rk.pojo;

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
@Entity
@Table(name = "t_renk_ldrk_dtsj")
public class Migration extends Pojo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 32)
	private String id;//                        varchar(32)       主键
	
	@Column(name = "outmigrate", length = 20)
	private String outmigrate;//                varchar(20)       迁出地
	
	@Column(name = "immigration", length = 20)
	private String immigration;//               varchar(20)       迁入地
	
	@Column(name = "number")
	private Float number;//                    int               人数
	
	@Column(name = "create_time")
	private Timestamp create_time;//               timestamp         创建时间
	
	@Column(name = "update_time")
	private Timestamp update_time;//              timestamp         更新时间
	
	@Column(name = "delete_time")
	private Timestamp delete_time;//              timestamp         删除时间
	
	@Column(name = "delete_state")
	private Integer delete_state;//             char(1)           1已删除，0正常

	public String getOutmigrate() {
		return outmigrate;
	}

	public String getImmigration() {
		return immigration;
	}

	public Float getNumber() {
		return number;
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

	public void setOutmigrate(String outmigrate) {
		this.outmigrate = outmigrate;
	}

	public void setImmigration(String immigration) {
		this.immigration = immigration;
	}

	public void setNumber(Float number) {
		this.number = number;
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
