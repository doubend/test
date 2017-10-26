package com.cloud.icenter.system.logs.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import com.cloud.icenter.base.pojo.Pojo;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 日志
 * 
 * @author zhangle
 * @email lezhang@isoftstone.com
 * @date 2013年10月6日 上午8:46:16
 */
@Entity
@Table(name = "T_DMP_SYS_LOGS")
public class Logs extends Pojo {

	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "SYS_LOG_ID", unique = true, nullable = false, length = 32)
	private String sysLogId;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_AT", nullable = false, length = 7)
	private Date createdAt;

	@Column(name = "ENTITY", length = 32)
	private String entity;

	@Column(name = "HOST", length = 32)
	private String host;

	@Column(name = "MODULE", length = 32)
	private String module;

	@Column(name = "DESCRIPTION", length = 500)
	private String description;

	@Column(name = "TYPE", length = 32)
	private String type;

	@Column(name = "USERNAME", length = 32)
	private String username;

	// Property accessors
	public String getSysLogId() {
		return this.sysLogId;
	}

	public void setSysLogId(String sysLogId) {
		this.sysLogId = sysLogId;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getEntity() {
		return this.entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public String getHost() {
		return this.host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getModule() {
		return this.module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
