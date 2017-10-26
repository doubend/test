package com.cloud.icenter.system.login.bean;

import java.io.Serializable;
import java.util.Date;
public class SSOKey implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String keyId;
	
	private String modulus;
	
	private String publicexponent;
	
	private String privateexponent;
	
	private Integer status;
	
	private Date createdAt;

	private String creatorId;

	public SSOKey(){
		
	}
	
	public SSOKey(String keyId,String modulus,String publicexponent,String privateexponent,Integer status,Date createdAt,String creatorId){
		this.keyId=keyId;
		this.modulus=modulus;
		this.publicexponent=publicexponent;
		this.privateexponent=privateexponent;
		this.status=status;
		this.createdAt=createdAt;
		this.creatorId=creatorId;
	}
	
	public String getKeyId() {
		return keyId;
	}

	public void setKeyId(String keyId) {
		this.keyId = keyId;
	}

	public String getModulus() {
		return modulus;
	}

	public void setModulus(String modulus) {
		this.modulus = modulus;
	}

	public String getPublicexponent() {
		return publicexponent;
	}

	public void setPublicexponent(String publicexponent) {
		this.publicexponent = publicexponent;
	}

	public String getPrivateexponent() {
		return privateexponent;
	}

	public void setPrivateexponent(String privateexponent) {
		this.privateexponent = privateexponent;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}
}
