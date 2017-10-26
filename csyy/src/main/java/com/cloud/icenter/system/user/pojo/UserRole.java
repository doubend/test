package com.cloud.icenter.system.user.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.cloud.icenter.base.pojo.Pojo;

/**
 * 用户与角色的中间关联实体类
 * @author zhangle
 */
@Entity
@Table(name = "T_DMP_SYS_USER_ROLE")
public class UserRole extends Pojo {

	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "ID", unique = true, nullable = false, length = 32)
	private String id;

	@Column(name = "ROLE_ID", nullable = false, length = 32)
	private String roleId;

	@Column(name = "USER_ID", nullable = false, length = 32)
	private String userId;

	// Property accessors
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}