package com.cloud.icenter.system.role.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.cloud.icenter.base.pojo.Pojo;

/**
 * 角色实体类
 * 
 * @author zhangle
 */
@Entity
@Table(name = "T_DMP_SYS_ROLE")
public class Role extends Pojo {

	public static final int STATUS_DEFAULT = 0; // 状态:默认
	public static final int STATUS_DISABLE = 1; // 状态:禁用

	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "ROLE_ID", length = 32)
	private String roleId;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_AT", length = 7)
	private Date createdAt;

	@Column(name = "CREATOR_ID", length = 32)
	private String creatorId;

	@Column(name = "ROLE_NAME", length = 50)
	private String roleName;

	@Column(name = "DESCRIPTION")
	private String description;
	
	//角色编码CODE
	@Column(name = "ROLE_CODE")
	private String roleCode;

	@Column(name = "SEQ_NUM", precision = 20, scale = 0)
	private long seqNum;

	@Column(name = "STATUS", precision = 11, scale = 0)
	private Integer status;
	
	@Transient
	private String[] checkedFunctionId; // 修改角色时,选中的功能ID

	@Transient
	private String[] uncheckdFunctionId; // 修改角色时,未选中的功能ID
	// Property accessors
	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getCreatorId() {
		return this.creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getSeqNum() {
		return this.seqNum;
	}

	public void setSeqNum(long seqNum) {
		this.seqNum = seqNum;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	public String[] getCheckedFunctionId() {
		return checkedFunctionId;
	}

	public void setCheckedFunctionId(String[] checkedFunctionId) {
		this.checkedFunctionId = checkedFunctionId;
	}

	public String[] getUncheckdFunctionId() {
		return uncheckdFunctionId;
	}

	public void setUncheckdFunctionId(String[] uncheckdFunctionId) {
		this.uncheckdFunctionId = uncheckdFunctionId;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	
}
