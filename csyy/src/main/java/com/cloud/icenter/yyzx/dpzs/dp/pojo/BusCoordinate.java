package com.cloud.icenter.yyzx.dpzs.dp.pojo;

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
* Created with gender.
* @author: liyao
* Date: 2017-05-27 10:59:02
*/
@Entity
@Table(name = "t_bus_coordinate")
public class BusCoordinate  extends Pojo {
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 32)
    private  String id;  
    
	/**
	 * 方位角
	 */
	@Column(name = "azimuth", length = 10)
    private  int azimuth;  
    
	/**
	 * 创建时间
	 */
	@Column(name = "create_date", length = 19)
    private  java.sql.Timestamp createDate;  
    
	/**
	 * 事件触发时间
	 */
	@Column(name = "date_time", length = 19)
    private  java.sql.Timestamp dateTime;  
    
	/**
	 * 保留字节
	 */
	@Column(name = "flg", length = 10)
    private  int flg;  
    
	/**
	 * gprs线路号（车载gps编号）
	 */
	@Column(name = "gprs_id", length = 10)
    private  int gprsId;  
    
	/**
	 * 高程
	 */
	@Column(name = "height", length = 10)
    private  int height;  
    
	/**
	 * 纬度_度
	 */
	@Column(name = "lat_du", length = 10)
    private  int latDu;  
    
	/**
	 * 纬度_分
	 */
	@Column(name = "lat_fen", length = 10)
    private  int latFen;  
    
	/**
	 * 经度_度
	 */
	@Column(name = "lng_du", length = 10)
    private  int lngDu;  
    
	/**
	 * 经度_分
	 */
	@Column(name = "lng_fen", length = 10)
    private  int lngFen;  
    
	/**
	 * 车辆ID
	 */
	@Column(name = "onboard_id", length = 10)
    private  int onboardId;  
    
	/**
	 * 车速
	 */
	@Column(name = "speed", length = 10)
    private  int speed;  
    
	/**
	 * 0:未营运 1: 营运中
	 */
	@Column(name = "status_operationflg", length = 10)
    private  int statusOperationflg;  
    
	/**
	 * 0：当前包 1：补发包
	 */
	@Column(name = "status_packageflg", length = 10)
    private  int statusPackageflg;  
    
	/**
	 * 0：上行 1：下行
	 */
	@Column(name = "status_streamflg", length = 10)
    private  int statusStreamflg;  
    

    public void setId (String id){
        this.id = id;
    }
    public String getId (){
        return this.id;
    }
    public void setAzimuth (int azimuth){
        this.azimuth = azimuth;
    }
    public int getAzimuth (){
        return this.azimuth;
    }
    public void setCreateDate (java.sql.Timestamp createDate){
        this.createDate = createDate;
    }
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public java.sql.Timestamp getCreateDate (){
        return this.createDate;
    }
    public void setDateTime (java.sql.Timestamp dateTime){
        this.dateTime = dateTime;
    }
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public java.sql.Timestamp getDateTime (){
        return this.dateTime;
    }
    public void setFlg (int flg){
        this.flg = flg;
    }
    public int getFlg (){
        return this.flg;
    }
    public void setGprsId (int gprsId){
        this.gprsId = gprsId;
    }
    public int getGprsId (){
        return this.gprsId;
    }
    public void setHeight (int height){
        this.height = height;
    }
    public int getHeight (){
        return this.height;
    }
    public void setLatDu (int latDu){
        this.latDu = latDu;
    }
    public int getLatDu (){
        return this.latDu;
    }
    public void setLatFen (int latFen){
        this.latFen = latFen;
    }
    public int getLatFen (){
        return this.latFen;
    }
    public void setLngDu (int lngDu){
        this.lngDu = lngDu;
    }
    public int getLngDu (){
        return this.lngDu;
    }
    public void setLngFen (int lngFen){
        this.lngFen = lngFen;
    }
    public int getLngFen (){
        return this.lngFen;
    }
    public void setOnboardId (int onboardId){
        this.onboardId = onboardId;
    }
    public int getOnboardId (){
        return this.onboardId;
    }
    public void setSpeed (int speed){
        this.speed = speed;
    }
    public int getSpeed (){
        return this.speed;
    }
    public void setStatusOperationflg (int statusOperationflg){
        this.statusOperationflg = statusOperationflg;
    }
    public int getStatusOperationflg (){
        return this.statusOperationflg;
    }
    public void setStatusPackageflg (int statusPackageflg){
        this.statusPackageflg = statusPackageflg;
    }
    public int getStatusPackageflg (){
        return this.statusPackageflg;
    }
    public void setStatusStreamflg (int statusStreamflg){
        this.statusStreamflg = statusStreamflg;
    }
    public int getStatusStreamflg (){
        return this.statusStreamflg;
    }
}