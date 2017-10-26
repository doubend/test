package com.cloud.icenter.system.sync.pojo;

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
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "T_DMP_SYS_SYNCLOGS")
public class Synclog extends Pojo{
	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "SYNCLOG_ID", unique = true, nullable = false, length = 32)
	private String synclogId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_AT", nullable = false, length = 7)
	@JsonFormat(pattern = "yyyyMMddHHmmss", timezone = "GMT+8")
	private Date createdAt;
	
	@Column(name = "SYNCTABLE", length = 50)
	private String syncTable;
	
	@Column(name = "SYNCTYPE", length = 50)
	private String syncType;
	
	@Column(name = "SYNCID", length = 50)
	private String syncId;

	public Synclog(){
		
	}
	
	public String getSynclogId() {
		return synclogId;
	}

	public void setSynclogId(String synclogId) {
		this.synclogId = synclogId;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getSyncTable() {
		return syncTable;
	}

	public void setSyncTable(String syncTable) {
		this.syncTable = syncTable;
	}

	public String getSyncType() {
		return syncType;
	}

	public void setSyncType(String syncType) {
		this.syncType = syncType;
	}

	public String getSyncId() {
		return syncId;
	}

	public void setSyncId(String syncId) {
		this.syncId = syncId;
	}
	
}
