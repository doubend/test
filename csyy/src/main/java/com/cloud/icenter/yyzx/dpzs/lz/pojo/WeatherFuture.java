package com.cloud.icenter.yyzx.dpzs.lz.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.cloud.icenter.base.pojo.Pojo;

/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-31 09:42:47
*/
@Entity
@Table(name = "t_zwfw_qx_jl")
public class WeatherFuture  extends Pojo {
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 32)
    private  String id;  
    
	/**
     * 返回的json字符串
     */
    @Column(name = "weather_json", length = 5000)
	private String weatherJson;
    /**
     * 天气地区
     */
    @Column(name = "area", length = 50)
    private String area;
    
    
	/**
	 * 插入时间
	 */
	@Column(name = "create_time", length = 19)
    private  java.sql.Timestamp createTime;  
    
	/**
	 * 更新时间
	 */
	@Column(name = "update_time", length = 19)
    private  java.sql.Timestamp updateTime;  
    
	/**
	 * 移除时间
	 */
	@Column(name = "delete_time", length = 19)
    private  java.sql.Timestamp deleteTime;  
    
	/**
	 * 0正常，1删除
	 */
	@Column(name = "delete_status", length = 1)
    private  String deleteStatus;  
    
	/**
	 * 创建者
	 */
	@Column(name = "creator", length = 8)
    private  String creator;  
    

    public void setId (String id){
        this.id = id;
    }
    public String getId (){
        return this.id;
    }
    public String getWeatherJson() {
        return weatherJson;
    }
    public void setWeatherJson(String weatherJson) {
        this.weatherJson = weatherJson;
    }
    public java.sql.Timestamp getCreateTime() {
        return createTime;
    }
    public void setCreateTime(java.sql.Timestamp createTime) {
        this.createTime = createTime;
    }
    public java.sql.Timestamp getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(java.sql.Timestamp updateTime) {
        this.updateTime = updateTime;
    }
    public java.sql.Timestamp getDeleteTime() {
        return deleteTime;
    }
    public void setDeleteTime(java.sql.Timestamp deleteTime) {
        this.deleteTime = deleteTime;
    }
    public String getDeleteStatus() {
        return deleteStatus;
    }
    public void setDeleteStatus(String deleteStatus) {
        this.deleteStatus = deleteStatus;
    }
    public String getCreator() {
        return creator;
    }
    public void setCreator(String creator) {
        this.creator = creator;
    }
    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }
  
    
}