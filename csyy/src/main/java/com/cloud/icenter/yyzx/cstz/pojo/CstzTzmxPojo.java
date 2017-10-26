package com.cloud.icenter.yyzx.cstz.pojo;

import java.math.BigDecimal;
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
* @version 2017年4月12日 上午9:16:36 
* 城市体征>体征模型
*/
@Entity
@Table(name = "t_cstz_tzmx")
public class CstzTzmxPojo extends Pojo{
	
	public static final int TYPE_DIRECTORY = 1; // 类型:目录
	public static final int TYPE_LEAF = 2; // 类型:叶子
	
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 32)
    private  String id;  
	
	/**
	 * 业务体征编码
	 */
	@Column(name = "code", length = 8)
    private  String code;  
	
	/**
	 * 业务体征id
	 */
	@Column(name = "ywtz_id",length = 32)
	private String ywtzId;
	
	@Transient
	private String ywtzMc;
    
	/**
	 * 父级体征ID，若没有则为空
	 */
	@Column(name = "parent_id", length = 32)
    private  String parentId;  
    
	/**
	 * 体征名称：如居民生活用水缺口指数
	 */
	@Column(name = "tzmc", length = 32)
    private  String tzmc;  
    
	/**
	 * 体征类型：0：综合体征；1：主题体征；2：专题体征；3：业务指标体征
	 */
	@Column(name = "tzlx", length = 1)
    private  String tzlx;  
    
	/**
	 * 占上级体征的权重（0.0-1.0），若没有上级体征则为1.0
	 */
	@Column(name = "qz")
    private  BigDecimal qz;  
    
	/**
	 * 体征默认值：指数值（0.0-10.0）
	 */
	@Column(name = "mrz", length = 8)
    private  float mrz;  
    
	/**
	 * 告警值：当指标指数低于该值时出现告警提示
	 */
	@Column(name = "gjz", length = 8)
    private  float gjz;  
    
	/**
	 * 体征状态：0：启用；1：未启用（删除）
	 */
	@Column(name = "tzzt", length = 1)
    private  String tzzt;  
	
	/**
	 * 节点排序
	 */
	@Column(name = "xssx", length = 11)
	private int seqNum;
	
	/**
	 * 图标地址
	 */
	@Column(name = "tbdz", length = 64)
	private String tbdz;
	
	/**
	 * 节点类型
	 */
	@Column(name = "type", length = 11)
	private int type;
    
	/**
	 * 创建时间
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "create_time", length = 19)
    private  Date createTime;  
    
	/**
	 * 更新时间
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "update_time", length = 19)
    private  Date updateTime;  
    
	/**
	 * 删除时间
	 */
	@Temporal(TemporalType.DATE)
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
	
	/**
	 * 是否是初始化数据
	 */
	@Column(name = "is_del", length = 1)
	private String isDel;
    
	
	public void setId (String id){
        this.id = id;
    }
    public String getId (){
        return this.id;
    }
    
    
    public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getYwtzId() {
		return ywtzId;
	}
	public void setYwtzId(String ywtzId) {
		this.ywtzId = ywtzId;
	}
	public int getSeqNum() {
		return seqNum;
	}
	public void setSeqNum(int seqNum) {
		this.seqNum = seqNum;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getTbdz() {
		return tbdz;
	}
	public void setTbdz(String tbdz) {
		this.tbdz = tbdz;
	}
	public void setParentId (String parentId){
        this.parentId = parentId;
    }
    public String getParentId (){
        return this.parentId;
    }
    public void setTzmc (String tzmc){
        this.tzmc = tzmc;
    }
    public String getTzmc (){
        return this.tzmc;
    }
    public void setTzlx (String tzlx){
        this.tzlx = tzlx;
    }
    public String getTzlx (){
        return this.tzlx;
    }
    public void setQz (BigDecimal qz){
        this.qz = qz;
    }
    public BigDecimal getQz (){
        return this.qz;
    }
    public void setMrz (float mrz){
        this.mrz = mrz;
    }
    public float getMrz (){
        return this.mrz;
    }
    public void setGjz (float gjz){
        this.gjz = gjz;
    }
    public float getGjz (){
        return this.gjz;
    }
    public void setTzzt (String tzzt){
        this.tzzt = tzzt;
    }
    public String getTzzt (){
        return this.tzzt;
    }
    public void setCreateTime (Date createTime){
        this.createTime = createTime;
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    public Date getCreateTime (){
        return this.createTime;
    }
    public void setUpdateTime (Date updateTime){
        this.updateTime = updateTime;
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    public Date getUpdateTime (){
        return this.updateTime;
    }
    public void setDeleteTime (Date deleteTime){
        this.deleteTime = deleteTime;
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
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
	public String getYwtzMc() {
		return ywtzMc;
	}
	public void setYwtzMc(String ywtzMc) {
		this.ywtzMc = ywtzMc;
	}
	public String getIsDel() {
		return isDel;
	}
	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}
    
    
}
