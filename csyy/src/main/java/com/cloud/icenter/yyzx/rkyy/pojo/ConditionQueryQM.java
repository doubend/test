package com.cloud.icenter.yyzx.rkyy.pojo;

import java.io.Serializable;


/**
 * 人口关系页面条件查询
 * @author whcai
 *
 */
public class ConditionQueryQM extends PeopleBasicQuery implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
      
    //中文姓名
    private String zwxm;
    
    //身份证号
    private String sfz;
    
    //性别
    private String xb;
    
    //年龄区间
    private int startAge;
    private int endAge;
    
    //区县编码
    private String qxbm;

	public String getZwxm() {
		return zwxm;
	}

	public void setZwxm(String zwxm) {
		this.zwxm = zwxm;
	}

	public String getSfz() {
		return sfz;
	}

	public void setSfz(String sfz) {
		this.sfz = sfz;
	}

	public String getXb() {
		return xb;
	}

	public void setXb(String xb) {
		this.xb = xb;
	}
	
	public int getStartAge() {
		return startAge;
	}

	public void setStartAge(int startAge) {
		this.startAge = startAge;
	}
	
	public int getEndAge() {
		return endAge;
	}

	public void setEndAge(int endAge) {
		this.endAge = endAge;
	}
	
	public String getQxbm() {
		return qxbm;
	}

	public void setQxbm(String qxbm) {
		this.qxbm = qxbm;
	}
        
}