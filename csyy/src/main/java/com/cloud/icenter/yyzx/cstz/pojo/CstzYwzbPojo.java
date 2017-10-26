package com.cloud.icenter.yyzx.cstz.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import com.cloud.icenter.base.pojo.Pojo;
import com.fasterxml.jackson.annotation.JsonFormat;

/** 
* @author zhucy 
* @version 2017年4月5日 下午2:33:33 
* 城市体征——业务指标表
*/
@Entity
@Table(name = "t_cstz_ywzb")
public class CstzYwzbPojo extends Pojo{
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 32)
    private  String id;  
    
	/**
	 * 业务指标编码
	 */
	@Column(name = "code", length = 8)
    private  String code; 
	
	/**
	 * 业务指标名称：如居民生活用水缺口
	 */
	@Column(name = "ywzbmc", length = 32)
    private  String ywzbmc;  
    
	/**
	 * 数据频率：如年、月、周、日、小时、分钟等
	 */
	@Column(name = "sjpl", length = 32)
    private  String sjpl;  
    
	/**
	 * 数据单位：如吨、个等
	 */
	@Column(name = "sjdw", length = 32)
    private  String sjdw;  
    
	/**
	 * 数据来源：如统计局、园林局、公安局等
	 */
	@Column(name = "sjly", length = 64)
    private  String sjly;  
	
	/**
	 * 图标地址
	 */
	@Column(name="tbdz", length = 64)
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
	@Temporal(TemporalType.TIMESTAMP)
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
    

	public void setId (String id){
        this.id = id;
    }
    public String getId (){
        return this.id;
    }
    public void setCode (String code){
        this.code = code;
    }
    public String getCode (){
        return this.code;
    }
    public void setYwzbmc (String ywzbmc){
        this.ywzbmc = ywzbmc;
    }
    public String getYwzbmc (){
        return this.ywzbmc;
    }
    public void setSjpl (String sjpl){
        this.sjpl = sjpl;
    }
    public String getSjpl (){
        return this.sjpl;
    }
    public void setSjdw (String sjdw){
        this.sjdw = sjdw;
    }
    public String getSjdw (){
        return this.sjdw;
    }
    public void setSjly (String sjly){
        this.sjly = sjly;
    }
    public String getSjly (){
        return this.sjly;
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
}
