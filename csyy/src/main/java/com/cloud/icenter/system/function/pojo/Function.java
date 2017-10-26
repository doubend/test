package com.cloud.icenter.system.function.pojo;

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
 * 功能实体类
 * 
 * @author zhangle
 */
@Entity
@Table(name = "T_DMP_SYS_FUNCTION")
public class Function extends Pojo {

	public static final int TYPE_DIRECTORY = 1; // 类型:目录
	public static final int TYPE_LEAF = 2; // 类型:叶子

	public static final int STATUS_DEFAULT = 0; // 状态:默认
	public static final int STATUS_DISABLE = 1; // 状态:禁用

	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "FUNC_ID", unique = true, nullable = false, length = 32)
	private String funcId;

	@Column(name = "CODE", length = 32)
	private String code;
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_AT", length = 7)
	private Date createdAt;

	@Column(name = "CREATOR_ID", length = 32)
	private String creatorId;

	@Column(name = "NAME", length = 50)
	private String name;

	@Column(name = "PARENT_ID", length = 32)
	private String parentId;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "SEQ_NUM", precision = 20, scale = 0)
	private Integer seqNum;

	@Column(name = "STATUS", precision = 11, scale = 0)
	private Integer status;

	@Column(name = "TYPE", precision = 11, scale = 0)
	private Integer type;

	@Column(name = "URL", length = 100)
	private String url;

	// Property accessors
	public String getFuncId() {
		return this.funcId;
	}

	public void setFuncId(String funcId) {
		this.funcId = funcId;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getCreatorId() {
		return this.creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentId() {
		return this.parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getSeqNum() {
		return this.seqNum;
	}

	public void setSeqNum(Integer seqNum) {
		this.seqNum = seqNum;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
