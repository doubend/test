package com.cloud.icenter.yyzx.common.query;

public class Industry {

	private String hybmc;
	private  float sr;
	private  float increase; 
	private int nf;
	
	public void setHybmc (String hybmc){
        this.hybmc = hybmc;
    }
    public String getHybmc (){
        return this.hybmc;
    }
    public void setSr (float sr){
        this.sr = sr;
    }
    public float getSr (){
        return this.sr;
    }
    public void setIncrease(float increase){
    	this.increase=increase;
    }
    public float getIncrease(){
    	return increase;
    }
    public void setYear(int nf){
    	this.nf=nf;
    }
    public int getYear(){
    	return nf;
    }
}
