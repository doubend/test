package com.cloud.icenter.system.organ.pojo;

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

@Entity
@Table(name = "T_DMP_SYS_ORG")
public class Organ extends Pojo {
	private static final long serialVersionUID = 1L;
	
	//共享平台服务平台修改
	public static final int TYPE_FOLDER = 1;//政府机构
	public static final int QY_TYPE = 2; //企业
	public static final int QUYU_TYPE = 3; //区域
	public static final int DEPARTMENT_FOLDER = 4; //政府部门
	public static final int KS_TYPE = 5; //科室
	/**
	 * 所用用到该常量的请注意后期版本，可能会删除
	 * 请尽可能修改掉，目前仅留下政府机构与企业两种类型
	 */
	@Deprecated
	public static final int TYPE_DEPARTMENT = 2; // 类型:政府部门
	
	public static final int TYPE_ENTERPRISE = 1; // 类型:企业
	
	public static final int TYPE_OTHER = 99;//其它
	
	public static final String OTHER_ID = "OTHER";
	
	/**
	 * 所用用到该常量的请注意后期版本，可能会删除
	 * 请尽可能修改掉，目前仅留下政府机构与企业两种类型
	 */
	@Deprecated
	public static final int TYPE_DEPARTMENT_ADMIN = 3; // 类型:企业部门
	
	@Deprecated
	public static final int TYPE_EMPLOYEE = 4; // 类型:人员

	// 是否主要:当type为4(即类型为人员)时才使用
	public static final int MAIN_NO = 0; // 是否主要:否
	public static final int MAIN_YES = 1; // 是否主要:是

	/**
	 * 状态过时，不在单独存储，使用常量接口内定义的
	 */
	public static final int STATUS_DEFAULT = 0; // 状态:默认
	@Deprecated
	public static final int STATUS_DELETED = 2; // 状态:删除
	
	public static final int STATUS_DISABLE = 1; // 状态禁用

	@Deprecated
	public static final String SEX_MALE = "M"; // 性别:男
	@Deprecated
	public static final String SEX_FEMALE = "F"; // 性别:女

	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "ORG_ID", unique = true, nullable = false, length = 32)
	private String orgId;

	@Column(name = "ADDRESS", length = 100)
	private String address;
	@Temporal(TemporalType.DATE)
	@Column(name = "BIRTHDAY", length = 7)
	private Date birthday;
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_AT", length = 7)
	private Date createdAt;

	@Column(name = "CREATOR_ID", length = 32)
	private String creatorId;

	@Column(name = "EMP_NO", length = 32)
	private String empNo;

	@Column(name = "FAX", length = 16)
	private String fax;

	@Column(name = "MAIL", length = 50)
	private String mail;

	@Column(name = "MAIN", precision = 11, scale = 0)
	private Integer main;

	@Column(name = "MOBILE", length = 16)
	private String mobile;

	@Column(name = "NAME", length = 50)
	private String name;

	@Column(name = "OFFICE_PHONE", length = 16)
	private String officePhone;

	@Column(name = "PARENT_ID", length = 32)
	private String parentId;

	@Column(name = "QQ", length = 32)
	private String qq;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "SEQ_NUM", precision = 20, scale = 0)
	private Integer seqNum;

	@Column(name = "SEX", length = 1)
	private String sex;

	@Column(name = "SHORT_NAME", length = 32)
	private String shortName;

	@Column(name = "STATUS", precision = 11, scale = 0)
	private Integer status;

	@Column(name = "TYPE", precision = 11, scale = 0)
	private Integer type;

	@Column(name = "USER_ID", length = 32)
	private String userId;

	@Column(name = "PATH", length = 512)
	private String path;  //父节点路径
	
	@Column(name = "CODE", length = 256)
	private String code;  //编码
	
	@Column(name="SYSCODE", length = 50)
	private String sysCode;
	
	//资产发布:中心树构建用临时字段
	@Transient
	private Long published;//已发布数
	@Transient
	private Long notpublished;//待发布数
	@Transient
	private Long total;//通过中心审核的总数
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	// Property accessors
	public String getOrgId() {
		return this.orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
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

	public String getEmpNo() {
		return this.empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Integer getMain() {
		return this.main;
	}

	public void setMain(Integer main) {
		this.main = main;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOfficePhone() {
		return this.officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	public String getParentId() {
		return this.parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
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

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getShortName() {
		return this.shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
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

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Long getPublished() {
		return published;
	}

	public void setPublished(Long published) {
		this.published = published;
	}

	public Long getNotpublished() {
		return notpublished;
	}

	public void setNotpublished(Long notpublished) {
		this.notpublished = notpublished;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSysCode() {
		return sysCode;
	}

	public void setSysCode(String sysCode) {
		this.sysCode = sysCode;
	}
	
}
