package com.cloud.icenter.system.sync.dto;

public class UserMsg {
	private String userId;
	private String username;
	private String nickname;
	private String password;
	private String description;
	private String salt;
	private Integer status;
	private String roleNames;
	private String orgIds;
	
	private String idcard;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRoleNames() {
		return roleNames;
	}

	public void setRoleNames(String roleNames) {
		this.roleNames = roleNames;
	}

	public String getOrgIds() {
		return orgIds;
	}

	public void setOrgIds(String orgIds) {
		this.orgIds = orgIds;
	}

	/**
	 * @return 返回 idcard
	 */
	public String getIdcard() {
		return idcard;
	}

	/**
	 * @param idcard 设置 idcard
	 */
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
}
