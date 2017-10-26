package com.cloud.icenter.yyzx.cstz.pojo;

import java.math.BigDecimal;

import com.cloud.icenter.base.pojo.Pojo;

public class CstzValue extends Pojo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 体正值
	 */
	private Double tzz;
	
	public Double getTzz(){
		return this.tzz;
	}
	public void setTzz(BigDecimal tzz){
		this.tzz = tzz.doubleValue();
	}

}
