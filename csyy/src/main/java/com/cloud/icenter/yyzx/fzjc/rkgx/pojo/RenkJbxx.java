
package com.cloud.icenter.yyzx.fzjc.rkgx.pojo;

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
* Date: 2017-06-27 15:21:48
*/
@Entity
@Table(name = "t_renk_base_jbxx")
public class RenkJbxx  extends Pojo {
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "rkjbxxwybsm", unique = true, nullable = false, length = 32)
    private  String rkjbxxwybsm;  
    
	/**
	 * 身份证号码
	 */
	@Column(name = "sfzhm", length = 18)
    private  String sfzhm;  
    
	/**
	 * 姓名
	 */
	@Column(name = "xingming", length = 128)
    private  String xingming;  
    
	/**
	 * 出生日期：YYYY-MM-DD
	 */
	@Column(name = "csrq", length = 19)
    private  java.sql.Timestamp csrq;  
    
	/**
	 * 性别：0男；1女
	 */
	@Column(name = "xingbie", length = 4)
    private  String xingbie;  
    
	/**
	 * 民族
	 */
	@Column(name = "minzu", length = 64)
    private  String minzu;  
    
	/**
	 * 楼牌号标识码
	 */
	@Column(name = "lphbsm", length = 32)
    private  String lphbsm;  
    
	/**
	 * 小区名称
	 */
	@Column(name = "xqmc", length = 128)
    private  String xqmc;  
    
	/**
	 * 楼牌号
	 */
	@Column(name = "lph", length = 128)
    private  String lph;  
    
	/**
	 * 详细地址
	 */
	@Column(name = "xxdz", length = 256)
    private  String xxdz;  
    
	/**
	 * 居住地行政区划编码
	 */
	@Column(name = "jzdxzqhbm", length = 8)
    private  String jzdxzqhbm;  
    
	/**
	 * 居住地行政区划名称：大武口区
	 */
	@Column(name = "jzdxzqhmc", length = 128)
    private  String jzdxzqhmc;  
    
	/**
	 * 调查日期：YYYY-MM-DD
	 */
	@Column(name = "dcrq", length = 19)
    private  java.sql.Timestamp dcrq;  
    
	/**
	 * 死亡状态：0生；1死
	 */
	@Column(name = "swzt", length = 1)
    private  String swzt;  
    
	/**
	 * 死亡日期：YYYY-MM-DD
	 */
	@Column(name = "swrq", length = 19)
    private  java.sql.Timestamp swrq;  
    
	/**
	 * 开始入住日期：YYYY-MM-DD
	 */
	@Column(name = "ksrzrq", length = 19)
    private  java.sql.Timestamp ksrzrq;  
    
	/**
	 * 出生时间：HH:MM:SS
	 */
	@Column(name = "cssj", length = 19)
    private  java.sql.Timestamp cssj;  
    
	/**
	 * 出生地行政区划编码
	 */
	@Column(name = "csdxzqhbm", length = 8)
    private  String csdxzqhbm;  
    
	/**
	 * 出生地行政区划名称
	 */
	@Column(name = "csdxzqhmc", length = 128)
    private  String csdxzqhmc;  
    
	/**
	 * 国籍
	 */
	@Column(name = "guoji", length = 128)
    private  String guoji;  
    
	/**
	 * 出生婴儿别名
	 */
	@Column(name = "csyebm", length = 128)
    private  String csyebm;  
    
	/**
	 * 母亲人口标识码
	 */
	@Column(name = "mqrkbsm", length = 32)
    private  String mqrkbsm;  
    
	/**
	 * 母亲身份证号码
	 */
	@Column(name = "mqsfzhm", length = 18)
    private  String mqsfzhm;  
    
	/**
	 * 母亲姓名
	 */
	@Column(name = "mqxm", length = 128)
    private  String mqxm;  
    
	/**
	 * 母亲年龄
	 */
	@Column(name = "mqnl", length = 10)
    private  int mqnl;  
    
	/**
	 * 母亲国籍
	 */
	@Column(name = "mqgj", length = 128)
    private  String mqgj;  
    
	/**
	 * 母亲民族：汉族\回族\维吾尔族\蒙古族 等
	 */
	@Column(name = "mqmz", length = 64)
    private  String mqmz;  
    
	/**
	 * 父亲人口标识码
	 */
	@Column(name = "fqrkbsm", length = 32)
    private  String fqrkbsm;  
    
	/**
	 * 父亲身份证号码
	 */
	@Column(name = "fqsfzhm", length = 18)
    private  String fqsfzhm;  
    
	/**
	 * 父亲姓名
	 */
	@Column(name = "fqxm", length = 128)
    private  String fqxm;  
    
	/**
	 * 父亲年龄
	 */
	@Column(name = "fqnl", length = 10)
    private  int fqnl;  
    
	/**
	 * 父亲国籍
	 */
	@Column(name = "fqgj", length = 128)
    private  String fqgj;  
    
	/**
	 * 父亲民族：汉族\回族\维吾尔族\蒙古族 等
	 */
	@Column(name = "fqmz", length = 64)
    private  String fqmz;  
    
	/**
	 * 接生机构名称
	 */
	@Column(name = "jsjgmc", length = 128)
    private  String jsjgmc;  
    
	/**
	 * 发证日期：YYYY-MM-DD
	 */
	@Column(name = "fzrq", length = 19)
    private  java.sql.Timestamp fzrq;  
    
	
    public void setRkjbxxwybsm (String rkjbxxwybsm){
        this.rkjbxxwybsm = rkjbxxwybsm;
    }
    public String getRkjbxxwybsm (){
        return this.rkjbxxwybsm;
    }
    public void setSfzhm (String sfzhm){
        this.sfzhm = sfzhm;
    }
    public String getSfzhm (){
        return this.sfzhm;
    }
    public void setXingming (String xingming){
        this.xingming = xingming;
    }
    public String getXingming (){
        return this.xingming;
    }
    public void setCsrq (java.sql.Timestamp csrq){
        this.csrq = csrq;
    }
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public java.sql.Timestamp getCsrq (){
        return this.csrq;
    }
    public void setXingbie (String xingbie){
        this.xingbie = xingbie;
    }
    public String getXingbie (){
        return this.xingbie;
    }
    public void setMinzu (String minzu){
        this.minzu = minzu;
    }
    public String getMinzu (){
        return this.minzu;
    }
    public void setLphbsm (String lphbsm){
        this.lphbsm = lphbsm;
    }
    public String getLphbsm (){
        return this.lphbsm;
    }
    public void setXqmc (String xqmc){
        this.xqmc = xqmc;
    }
    public String getXqmc (){
        return this.xqmc;
    }
    public void setLph (String lph){
        this.lph = lph;
    }
    public String getLph (){
        return this.lph;
    }
    public void setXxdz (String xxdz){
        this.xxdz = xxdz;
    }
    public String getXxdz (){
        return this.xxdz;
    }
    public void setJzdxzqhbm (String jzdxzqhbm){
        this.jzdxzqhbm = jzdxzqhbm;
    }
    public String getJzdxzqhbm (){
        return this.jzdxzqhbm;
    }
    public void setJzdxzqhmc (String jzdxzqhmc){
        this.jzdxzqhmc = jzdxzqhmc;
    }
    public String getJzdxzqhmc (){
        return this.jzdxzqhmc;
    }
    public void setDcrq (java.sql.Timestamp dcrq){
        this.dcrq = dcrq;
    }
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public java.sql.Timestamp getDcrq (){
        return this.dcrq;
    }
    public void setSwzt (String swzt){
        this.swzt = swzt;
    }
    public String getSwzt (){
        return this.swzt;
    }
    public void setSwrq (java.sql.Timestamp swrq){
        this.swrq = swrq;
    }
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public java.sql.Timestamp getSwrq (){
        return this.swrq;
    }
    public void setKsrzrq (java.sql.Timestamp ksrzrq){
        this.ksrzrq = ksrzrq;
    }
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public java.sql.Timestamp getKsrzrq (){
        return this.ksrzrq;
    }
    public void setCssj (java.sql.Timestamp cssj){
        this.cssj = cssj;
    }
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public java.sql.Timestamp getCssj (){
        return this.cssj;
    }
    public void setCsdxzqhbm (String csdxzqhbm){
        this.csdxzqhbm = csdxzqhbm;
    }
    public String getCsdxzqhbm (){
        return this.csdxzqhbm;
    }
    public void setCsdxzqhmc (String csdxzqhmc){
        this.csdxzqhmc = csdxzqhmc;
    }
    public String getCsdxzqhmc (){
        return this.csdxzqhmc;
    }
    public void setGuoji (String guoji){
        this.guoji = guoji;
    }
    public String getGuoji (){
        return this.guoji;
    }
    public void setCsyebm (String csyebm){
        this.csyebm = csyebm;
    }
    public String getCsyebm (){
        return this.csyebm;
    }
    public void setMqrkbsm (String mqrkbsm){
        this.mqrkbsm = mqrkbsm;
    }
    public String getMqrkbsm (){
        return this.mqrkbsm;
    }
    public void setMqsfzhm (String mqsfzhm){
        this.mqsfzhm = mqsfzhm;
    }
    public String getMqsfzhm (){
        return this.mqsfzhm;
    }
    public void setMqxm (String mqxm){
        this.mqxm = mqxm;
    }
    public String getMqxm (){
        return this.mqxm;
    }
    public void setMqnl (int mqnl){
        this.mqnl = mqnl;
    }
    public int getMqnl (){
        return this.mqnl;
    }
    public void setMqgj (String mqgj){
        this.mqgj = mqgj;
    }
    public String getMqgj (){
        return this.mqgj;
    }
    public void setMqmz (String mqmz){
        this.mqmz = mqmz;
    }
    public String getMqmz (){
        return this.mqmz;
    }
    public void setFqrkbsm (String fqrkbsm){
        this.fqrkbsm = fqrkbsm;
    }
    public String getFqrkbsm (){
        return this.fqrkbsm;
    }
    public void setFqsfzhm (String fqsfzhm){
        this.fqsfzhm = fqsfzhm;
    }
    public String getFqsfzhm (){
        return this.fqsfzhm;
    }
    public void setFqxm (String fqxm){
        this.fqxm = fqxm;
    }
    public String getFqxm (){
        return this.fqxm;
    }
    public void setFqnl (int fqnl){
        this.fqnl = fqnl;
    }
    public int getFqnl (){
        return this.fqnl;
    }
    public void setFqgj (String fqgj){
        this.fqgj = fqgj;
    }
    public String getFqgj (){
        return this.fqgj;
    }
    public void setFqmz (String fqmz){
        this.fqmz = fqmz;
    }
    public String getFqmz (){
        return this.fqmz;
    }
    public void setJsjgmc (String jsjgmc){
        this.jsjgmc = jsjgmc;
    }
    public String getJsjgmc (){
        return this.jsjgmc;
    }
    public void setFzrq (java.sql.Timestamp fzrq){
        this.fzrq = fzrq;
    }
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public java.sql.Timestamp getFzrq (){
        return this.fzrq;
    }
}