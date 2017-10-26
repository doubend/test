package com.cloud.icenter.yyzx.ztfx.jtcx.pojo;

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
 * @version 2017年7月28日 上午11:09:21 
 * 说明 ：公交线路拥堵分析
 */
@Entity
@Table(name = "t_gjxl_ydfx")
public class GJxlYdfxPojo extends Pojo{
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 32)
    private  String id;  
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "lineid")
	private  String lineid;
	
	@Column(name = "gprsid")
	private String gprsid;
	
	@Column(name = "ydsj")
	private String ydsj;
	
	@Column(name = "sxl")
	private String sxl;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_time")
    private  Date dateTime;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "create_time")
    private  Date createTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLineid() {
		return lineid;
	}

	public void setLineid(String lineid) {
		this.lineid = lineid;
	}

	public String getGprsid() {
		return gprsid;
	}

	public void setGprsid(String gprsid) {
		this.gprsid = gprsid;
	}

	public String getYdsj() {
		return ydsj;
	}

	public void setYdsj(String ydsj) {
		this.ydsj = ydsj;
	}
	
	public String getSxl() {
		return sxl;
	}

	public void setSxl(String sxl) {
		this.sxl = sxl;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}  
	
	
    
	
}
