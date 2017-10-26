package com.cloud.icenter.yyzx.fryy.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cloud.icenter.common.util.QueryCondition;

public class CorpBasicQuery implements Serializable {
    
	/**
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）
	 *
	 * @since 1.0.0
	 */
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name="corp_id")
	private Long id;
	@Column(name="corporation")
	private String corporation;		//法人
	@Column(name="organization_code")
	private String organizationCode;	//组织机构代码
	@Column(name="company_Name")
	private String companyName;	//企业名称
	 @Column(name="register_time")
     @Temporal(TemporalType.DATE)
    private Date registerTime;           //注册登记时间
	@Column(name="enterprise_type")
	private String enterpriseType;	//企业类型:MY:民营，GQ：国企，ZWHZ:中外合资
	@Column(name="enterprise_scale")
	private String enterpriseScale;	//企业规模:0：1-100人，1:100-500人，2:500-5000人，3:5000人以上
	@Column(name="cancel")
	private String cancel;			//是否注销：0否，1是
	@Column(name="change")
	private String change;			//是否变更：0否，1是
	@Column(name="accumulation_fund")
	private String accumulationFund;		//公积金：0未交，1已交
	@Column(name="credit")
	private String credit;			//信用：0：良好，1一般，2差
	@Column(name="tax")
	private String tax;			//纳税：0：良好，1一般，2差
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCorporation() {
		return corporation;
	}
	public void setCorporation(String corporation) {
		this.corporation = corporation;
	}
	public String getOrganizationCode() {
		return organizationCode;
	}
	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}
	public Date getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	public String getEnterpriseType() {
		return enterpriseType;
	}
	public void setEnterpriseType(String enterpriseType) {
		this.enterpriseType = enterpriseType;
	}
	public String getEnterpriseScale() {
		return enterpriseScale;
	}
	public void setEnterpriseScale(String enterpriseScale) {
		this.enterpriseScale = enterpriseScale;
	}
	public String getCancel() {
		return cancel;
	}
	public void setCancel(String cancel) {
		this.cancel = cancel;
	}
	public String getChange() {
		return change;
	}
	public void setChange(String change) {
		this.change = change;
	}
	public String getAccumulationFund() {
		return accumulationFund;
	}
	public void setAccumulationFund(String accumulationFund) {
		this.accumulationFund = accumulationFund;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getTax() {
		return tax;
	}
	public void setTax(String tax) {
		this.tax = tax;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	
	
}
