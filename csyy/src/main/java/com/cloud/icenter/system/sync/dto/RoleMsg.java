package com.cloud.icenter.system.sync.dto;

public class RoleMsg {
	private String roleId;	//角色编码
	private String roleName;	//角色名称。新增时不为空，修改删除(逻辑删除)时可为空
	private String description; //备注
	private Integer status; //状态 
	
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
