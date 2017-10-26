
package com.cloud.icenter.yyzx.cstz.pojo;

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
* 城市体征——体征模型表
* @author: whcai
* Date: 2017-03-20 15:49:08
*/
@Entity
@Table(name = "t_cstz_tzmx")
public class SignModel  extends Pojo {
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
	@Column(name = "qz", length = 8)
    private  float qz;  
    
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
	 * 显示顺序
	 */
	@Column(name = "xssx", length = 8)
	private int xssx;
	
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
	 * 标识是否是初始化数据: 0:初始化不能删除   1:非初始化可以删除
	 */
	@Column(name = "is_del", length = 1)
	private String isDel;
    
	/**
	 * 创建时间
	 */
	@Column(name = "create_time", length = 19)
    private  java.sql.Timestamp createTime;  
    
	/**
	 * 更新时间
	 */
	@Column(name = "update_time", length = 19)
    private  java.sql.Timestamp updateTime;  
    
	/**
	 * 删除时间
	 */
	@Column(name = "delete_time", length = 19)
    private  java.sql.Timestamp deleteTime;  
    
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
    public String getYwtzId() {
		return ywtzId;
	}
	public void setYwtzId(String ywtzId) {
		this.ywtzId = ywtzId;
	}
	public int getXssx() {
		return xssx;
	}
	public void setXssx(int xssx) {
		this.xssx = xssx;
	}
	public String getTbdz() {
		return tbdz;
	}
	public void setTbdz(String tbdz) {
		this.tbdz = tbdz;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getIsDel() {
		return isDel;
	}
	public void setIsDel(String isDel) {
		this.isDel = isDel;
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
    public void setQz (float qz){
        this.qz = qz;
    }
    public float getQz (){
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
    public void setCreateTime (java.sql.Timestamp createTime){
        this.createTime = createTime;
    }
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public java.sql.Timestamp getCreateTime (){
        return this.createTime;
    }
    public void setUpdateTime (java.sql.Timestamp updateTime){
        this.updateTime = updateTime;
    }
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public java.sql.Timestamp getUpdateTime (){
        return this.updateTime;
    }
    public void setDeleteTime (java.sql.Timestamp deleteTime){
        this.deleteTime = deleteTime;
    }
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public java.sql.Timestamp getDeleteTime (){
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