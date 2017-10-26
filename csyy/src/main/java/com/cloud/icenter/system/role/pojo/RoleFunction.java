package com.cloud.icenter.system.role.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 角色与功能的中间关联实体类
 * @author zhangle
 */
@Entity
@Table(name="T_DMP_SYS_ROLE_FUNCTION")
public class RoleFunction implements Serializable {

	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "ID", unique = true, nullable = false, length = 32)
	private String id;

	@Column(name = "FUNCTION_ID", nullable = false, length = 32)
	private String functionId;

	@Column(name = "ROLE_ID", nullable = false, length = 32)
	private String roleId;

	// Property accessors
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFunctionId() {
		return this.functionId;
	}

	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
}