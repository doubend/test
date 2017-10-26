package com.cloud.icenter.system.user.pojo;

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
import org.springframework.format.annotation.DateTimeFormat;

import com.cloud.icenter.base.pojo.Pojo;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 用户实体类
 * 
 * @author zhangle
 */
@Entity
@Table(name = "T_DMP_SYS_USER")
public class User extends Pojo {

	public static final int STATUS_DEFAULT = 0; // 状态:默认
	public static final int STATUS_LOCKED = 1; // 状态:锁定
	
	public static final String DATA_RIGTH_ENABLE="1"; //数据权限，只能按照用户所属组织机构登记信息资源
	public static final String DATA_RIGTH_DISABLE="0"; //不启用，可以登记所有信息资源

	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "USER_ID", unique = true, nullable = false, length = 32)
	private String userId;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_AT", length = 7)
	private Date createdAt;

	@Column(name = "CREATOR_ID", length = 32)
	private String creatorId;

	@Column(name = "LOGIN_NUM", precision = 11, scale = 0)
	private int loginNum;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LOGON_AT", length = 7)
	private Date logonAt;

	/**
	 * 用户名
	 */
	@Column(name = "USERNAME", length = 32)
	private String username;

	@Column(name = "NICKNAME", length = 32)
	private String nickname;

	@Column(name = "PASSWORD", length = 32)
	private String password;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "SALT", length = 32)
	private String salt;

	@Column(name = "STATUS", precision = 11, scale = 0)
	private Integer status;
	
	@Transient
	private String[] checkedRoleId; // 修改用户时,选中的角色ID
	
	@Column(name = "DATARIGHT", length = 1)
	private String dataRight;//资产登记数据权限，1启用，0不启用
	
	@Transient
	private String organUserId;
	
	@Column(name = "IDCARD")
	private String idcard;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String userId , String organUserId , String username , String nickname , Integer status , int loginNum , String description){
		this.userId = userId;
		this.organUserId = organUserId;
		this.username = username;
		this.nickname = nickname;
		this.status = status;
		this.loginNum = loginNum;
		this.description = description;
	}
	
	public String getDataRight() {
		return dataRight;
	}

	public void setDataRight(String dataRight) {
		this.dataRight = dataRight;
	}

	// Property accessors
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
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

	public int getLoginNum() {
		return this.loginNum;
	}

	public void setLoginNum(int i) {
		this.loginNum = i;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	public Date getLogonAt() {
		return this.logonAt;
	}

	public void setLogonAt(Date logonAt) {
		this.logonAt = logonAt;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	public String[] getCheckedRoleId() {
		return checkedRoleId;
	}

	public void setCheckedRoleId(String[] checkedRoleId) {
		this.checkedRoleId = checkedRoleId;
	}

	public String getOrganUserId() {
		return organUserId;
	}

	public void setOrganUserId(String organUserId) {
		this.organUserId = organUserId;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	
}
