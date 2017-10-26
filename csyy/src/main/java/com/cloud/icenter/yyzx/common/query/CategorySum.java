package com.cloud.icenter.yyzx.common.query;

public class CategorySum {

	//类别名称
	private String category;
	
	//类别总数
	private int sum;
	
	
	public void setCategory(String category){
		this.category=category;
	}
	public String getCategory(){
		return this.category;
	}
	public void setSum(int sum){
		this.sum=sum;
	}
	public int getSum(){
		return this.sum;
	}
}
