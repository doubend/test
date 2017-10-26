package com.cloud.icenter.yyzx.cstz.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import com.cloud.icenter.base.pojo.Pojo;
import com.fasterxml.jackson.annotation.JsonFormat;

/** 
* @author zhucy 
* @version 2017年4月5日 下午6:07:59 
* 说明 
*/
@Entity
@Table(name = "t_cstz_ywtz")
public class CstzYwtzPojo extends Pojo{

	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 32)
    private  String id;  
    
	/**
	 * 业务指标ID
	 */
	@Column(name = "ywzb_id", length = 32)
    private  String ywzbId;  
	
	@Transient
	private String ywzbmc;
    
	/**
	 * 业务体征ID
	 */
	@Column(name = "code", length = 8)
    private  String code;  
    
	/**
	 * 阈值：业务数据绝对值阈值区间，中间以逗号隔开，如 {0,10,50,100}
	 */
	@Column(name = "yz", length = 128)
    private  String yz;  
    
	/**
	 * 优良中差范围区间：如 {0，2，5，8，10}
	 */
	@Column(name = "ylzcfw", length = 64)
    private  String ylzcfw;  
    
	/**
	 * 最优值标识位：如阈值区间的0或者100的标识位
	 */
	@Column(name = "zyzbs", length = 1)
    private  String zyzbs;  
    
	/**
	 * 计算公式：业务数据到指数的计算方法，只有业务指标才需要，上级指标根据权重计算
	 */
	@Column(name = "jsgs", length = 256)
    private  String jsgs;  
    
	/**
	 * 图标地址
	 */
	@Column(name = "tbdz", length = 64)
	private String tbdz;
	
	/**
	 * 创建时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time", length = 19)
    private  Date createTime;  
    
	/**
	 * 更新时间
	 */
	@Column(name = "update_time", length = 19)
    private  Date updateTime;  
    
	/**
	 * 删除时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "delete_time", length = 19)
    private  Date deleteTime;  
    
	/**
	 * 删除状态：0正常，1删除
	 */
	@Column(name = "delete_status", length = 1)
    private  String deleteStatus;  
    
	/**
	 * 创建者
	 */
	@Column(name = "creator", length = 32)
    private  String creator;  
    
	
	public CstzYwtzPojo(){
		super();
	}
	public CstzYwtzPojo(String id, String ywzbId, String ywzbmc, String code, String yz, String ylzcfw, String zyzbs,
			String jsgs, String tbdz, Date createTime) {
		super();
		this.id = id;
		this.ywzbId = ywzbId;
		this.ywzbmc = ywzbmc;
		this.code = code;
		this.yz = yz;
		this.ylzcfw = ylzcfw;
		this.zyzbs = zyzbs;
		this.jsgs = jsgs;
		this.tbdz = tbdz;
		this.createTime = createTime;
	}

    public void setId (String id){
        this.id = id;
    }
    public String getId (){
        return this.id;
    }
    public String getYwzbId() {
		return ywzbId;
	}
	public void setYwzbId(String ywzbId) {
		this.ywzbId = ywzbId;
	}
	public void setCode (String code){
        this.code = code;
    }
    public String getCode (){
        return this.code;
    }
    public void setYz (String yz){
        this.yz = yz;
    }
    public String getYz (){
        return this.yz;
    }
    public void setYlzcfw (String ylzcfw){
        this.ylzcfw = ylzcfw;
    }
    public String getYlzcfw (){
        return this.ylzcfw;
    }
    public void setZyzbs (String zyzbs){
        this.zyzbs = zyzbs;
    }
    public String getZyzbs (){
        return this.zyzbs;
    }
    public void setJsgs (String jsgs){
        this.jsgs = jsgs;
    }
    public String getJsgs (){
        return this.jsgs;
    }
    public String getTbdz() {
		return tbdz;
	}
	public void setTbdz(String tbdz) {
		this.tbdz = tbdz;
	}
	public void setCreateTime (Date createTime){
        this.createTime = createTime;
    }
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getCreateTime (){
        return this.createTime;
    }
    public void setUpdateTime (Date updateTime){
        this.updateTime = updateTime;
    }
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getUpdateTime (){
        return this.updateTime;
    }
    public void setDeleteTime (Date deleteTime){
        this.deleteTime = deleteTime;
    }
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getDeleteTime (){
        return this.deleteTime;
    }
    public void setDeleteStatus (String deleteStatus){
        this.deleteStatus = deleteStatus;
    }
    public String getDeleteStatus (){
        return this.deleteStatus;
    }
    public void setCreator (String creator){
        this.creator = creator;
    }
    public String getCreator (){
        return this.creator;
    }
	public String getYwzbmc() {
		return ywzbmc;
	}
	public void setYwzbmc(String ywzbmc) {
		this.ywzbmc = ywzbmc;
	}
}
