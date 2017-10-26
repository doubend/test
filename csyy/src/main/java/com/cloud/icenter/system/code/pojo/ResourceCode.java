package com.cloud.icenter.system.code.pojo;

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
 * 编码管理
 * @author xieyn
 */
@Entity
@Table(name = "T_DMP_SYS_CODE")
public class ResourceCode extends Pojo{
	private static final long serialVersionUID = -5626398144192866731L;

	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "ID", unique = true, nullable = false, length = 32)
    private  String id;  // 主键(必填)
	
	@Column(name = "CODE_NAME", length = 50)
    private  String codeName;  // 编码名称
	
	@Column(name = "PRE_CODE", length = 50)
    private  String preCode;  // 前段码
	
	@Column(name = "PLIPT_SIGN", length = 1)
    private  String spliptSign;  // 分割符
	
	@Column(name = "IS_USE_ORGAN", length = 1)
    private  String isUseOrgan;  //是否使用机构编码
	
	@Column(name = "GROW_TYPE", length = 32)
    private  String growType;  // 增长方式
	
	@Column(name = "IS_USE", length = 1)
    private  String isUse;  // 标识符是否使用
	
	@Column(name = "CODE_TYPE", length = 1)
    private  String codeType;  // 1、信息资源标识符 2、数据项标识符
	
	@Column(name = "DES", length = 255)
    private  String des;  // 备注
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE", length = 7)
	private  Date createDate;  // 创建日期     
	@Column(name = "CREATE_USER_ID", length = 32)
    private  String createUserId;  // 创建人
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EDIT_DATE", length = 7)
    private  Date editDate;  // 编辑日期     
	@Column(name = "EDIT_USER_ID", length = 32)
    private  String editUserId;  // 编辑人     
	@Column(name = "STATUS", length = 1)
    private  String status;  // 状态     
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCodeName() {
		return codeName;
	}
	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}
	public String getPreCode() {
		return preCode;
	}
	public void setPreCode(String preCode) {
		this.preCode = preCode;
	}
	public String getSpliptSign() {
		return spliptSign;
	}
	public void setSpliptSign(String spliptSign) {
		this.spliptSign = spliptSign;
	}
	public String getIsUseOrgan() {
		return isUseOrgan;
	}
	public void setIsUseOrgan(String isUseOrgan) {
		this.isUseOrgan = isUseOrgan;
	}
	public String getGrowType() {
		return growType;
	}
	public void setGrowType(String growType) {
		this.growType = growType;
	}
	public String getIsUse() {
		return isUse;
	}
	public void setIsUse(String isUse) {
		this.isUse = isUse;
	}
	public String getCodeType() {
		return codeType;
	}
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	public Date getEditDate() {
		return editDate;
	}
	public void setEditDate(Date editDate) {
		this.editDate = editDate;
	}
	public String getEditUserId() {
		return editUserId;
	}
	public void setEditUserId(String editUserId) {
		this.editUserId = editUserId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}

