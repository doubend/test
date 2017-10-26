package com.cloud.icenter.yyzx.cstz.pojo;

import com.cloud.icenter.base.pojo.Pojo;

public class SimpleDatePojo extends Pojo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 年
	 */
	private int year;
	
	/**
	 * 月
	 */
	private int mouth;
	
	/**
	 * 日
	 */
	private int day;
	
	public int getYear() {
		return this.year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	public int getMouth(){
		return this.mouth;
	}
	public void setMouth(int mouth){
		this.mouth = mouth;
	}
	
	public int getDay(){
		return this.day;
	}
	public void setDay(int day){
		this.day = day;
	}
}
