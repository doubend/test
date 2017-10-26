package com.cloud.icenter.yyzx.rkyy.pojo;


import java.io.Serializable;



public class AddressCodeQueryQM extends PeopleBasicQuery implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    
    //类型
    private String addressType;
    
    //地址编码
    private String addressCode;
    
    //地址名称
    private String addressName;

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getAddressCode() {
		return addressCode;
	}

	public void setAddressCode(String addressCode) {
		this.addressCode = addressCode;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}
    
    
    
	
    
    
    
}