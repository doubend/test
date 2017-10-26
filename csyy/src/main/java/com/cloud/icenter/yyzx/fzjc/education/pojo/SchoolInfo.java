
package com.cloud.icenter.yyzx.fzjc.education.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import com.cloud.icenter.base.pojo.Pojo;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
* Created with gender.
* @author: whcai
* Date: 2017-07-04 17:37:40
*/
@Entity
@Table(name = "t_jy_xxjbxx")
public class SchoolInfo  extends Pojo {
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "xxjbxxwybsm", unique = true, nullable = false, length = 32)
    private  String xxjbxxwybsm;  
    
	/**
	 * 学校编号
	 */
	@Column(name = "xxbh", length = 8)
    private  String xxbh;  
    
	/**
	 * 学校名称
	 */
	@Column(name = "xxmc", length = 128)
    private  String xxmc;  
    
	/**
	 * 学校简称
	 */
	@Column(name = "xxjc", length = 32)
    private  String xxjc;  
    
	/**
	 * 所在地行政区划编码：753420
	 */
	@Column(name = "szdxzqhbm", length = 8)
    private  String szdxzqhbm;  
    
	/**
	 * 所在地行政区划名称：大武口区
	 */
	@Column(name = "szdxzqhmc", length = 128)
    private  String szdxzqhmc;  
    
	/**
	 * 学校类型：1幼儿园； 2小学； 3初中； 4高中 等
	 */
	@Column(name = "xxlx", length = 1)
    private  String xxlx;  
    
	/**
	 * 地址
	 */
	@Column(name = "dizhi", length = 256)
    private  String dizhi;  
    
	/**
	 * 经度
	 */
	@Column(name = "x", length = 11)
    private  int x;  
    
	/**
	 * 纬度
	 */
	@Column(name = "y", length = 11)
    private  int y;  
    
	/**
	 * 投入使用日期：YYYY-MM-DD
	 */
	@Column(name = "trsyrq", length = 19)
    private  java.sql.Timestamp trsyrq;  
    
	/**
	 * 学校办别：教育部门和集体办；企业办；等
	 */
	@Column(name = "xxb", length = 64)
    private  String xxb;  
    

    public void setXxjbxxwybsm (String xxjbxxwybsm){
        this.xxjbxxwybsm = xxjbxxwybsm;
    }
    public String getXxjbxxwybsm (){
        return this.xxjbxxwybsm;
    }
    public void setXxbh (String xxbh){
        this.xxbh = xxbh;
    }
    public String getXxbh (){
        return this.xxbh;
    }
    public void setXxmc (String xxmc){
        this.xxmc = xxmc;
    }
    public String getXxmc (){
        return this.xxmc;
    }
    public void setXxjc (String xxjc){
        this.xxjc = xxjc;
    }
    public String getXxjc (){
        return this.xxjc;
    }
    public void setSzdxzqhbm (String szdxzqhbm){
        this.szdxzqhbm = szdxzqhbm;
    }
    public String getSzdxzqhbm (){
        return this.szdxzqhbm;
    }
    public void setSzdxzqhmc (String szdxzqhmc){
        this.szdxzqhmc = szdxzqhmc;
    }
    public String getSzdxzqhmc (){
        return this.szdxzqhmc;
    }
    public void setXxlx (String xxlx){
        this.xxlx = xxlx;
    }
    public String getXxlx (){
        return this.xxlx;
    }
    public void setDizhi (String dizhi){
        this.dizhi = dizhi;
    }
    public String getDizhi (){
        return this.dizhi;
    }
    public void setX (int x){
        this.x = x;
    }
    public int getX (){
        return this.x;
    }
    public void setY (int y){
        this.y = y;
    }
    public int getY (){
        return this.y;
    }
    public void setTrsyrq (java.sql.Timestamp trsyrq){
        this.trsyrq = trsyrq;
    }
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public java.sql.Timestamp getTrsyrq (){
        return this.trsyrq;
    }
    public void setXxb (String xxb){
        this.xxb = xxb;
    }
    public String getXxb (){
        return this.xxb;
    }
}