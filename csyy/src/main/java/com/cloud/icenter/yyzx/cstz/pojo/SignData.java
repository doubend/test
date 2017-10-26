
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
* 城市体征——体征历史数据表
* @author: whcai
* Date: 2017-03-20 15:53:01
*/
@Entity
@Table(name = "t_cstz_tzzssj")
public class SignData  extends Pojo {
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 32)
    private  String id;  
    
	/**
	 * 体征ID
	 */
	@Column(name = "tz_id", length = 32)
    private  String tzId;  
    
	/**
	 * 体征值：0.0-10.0
	 */
	@Column(name = "tzz", length = 8)
    private  float tzz;  
    
	/**
	 * 体征状况：优、良、中、差
	 */
	@Column(name = "tzzk", length = 32)
    private  String tzzk;  
    
	/**
	 * 数据时间
	 */
	@Column(name = "data_time", length = 19)
    private  java.sql.Timestamp dataTime;  
    
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
    public String getTzId() {
		return tzId;
	}
	public void setTzId(String tzId) {
		this.tzId = tzId;
	}
	public void setTzz (float tzz){
        this.tzz = tzz;
    }
    public float getTzz (){
        return this.tzz;
    }
    public void setTzzk (String tzzk){
        this.tzzk = tzzk;
    }
    public String getTzzk (){
        return this.tzzk;
    }
    public void setDataTime (java.sql.Timestamp dataTime){
        this.dataTime = dataTime;
    }
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public java.sql.Timestamp getDataTime (){
        return this.dataTime;
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