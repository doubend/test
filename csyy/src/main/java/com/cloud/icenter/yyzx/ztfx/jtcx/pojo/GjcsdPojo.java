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

import com.cloud.icenter.base.pojo.Pojo;
@Entity
@Table(name = "t_bus_sd")
public class GjcsdPojo extends Pojo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "ID", unique = true, nullable = false, length = 32)
	private String id;
	@Column(name = "xl")
	private String xl;
	
	@Column(name = "lineid")
	private String lineid;
	
	@Column(name = "gprs_id")
	private String gprs_id;
	
	@Column(name = "pjsd")
	private String pjsd;
	
	@Column(name = "sxx")
	private String sxx;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "create_time")
	private Date create_time;
	@Temporal(TemporalType.DATE)
	@Column(name = "date_time")
	private Date date_time;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getXl() {
		return xl;
	}
	public void setXl(String xl) {
		this.xl = xl;
	}
	public String getLineid() {
		return lineid;
	}
	public void setLineid(String lineid) {
		this.lineid = lineid;
	}
	public String getPjsd() {
		return pjsd;
	}
	public void setPjsd(String pjsd) {
		this.pjsd = pjsd;
	}
	public String getSxx() {
		return sxx;
	}
	public void setSxx(String sxx) {
		this.sxx = sxx;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	
	public Date getDate_time() {
		return date_time;
	}
	public void setDate_time(Date date_time) {
		this.date_time = date_time;
	}
	public String getGprs_id() {
		return gprs_id;
	}
	public void setGprs_id(String gprs_id) {
		this.gprs_id = gprs_id;
	}
	@Override
	
	public String toString() {
		return "GjcsdPojo [id=" + id + ", xl=" + xl + ", lineid=" + lineid
				+ ", gprs_id=" + gprs_id + ", pjsd=" + pjsd + ", sxx=" + sxx
				+ ", create_time=" + create_time + ", date_time=" + date_time
				+ "]";
	}
	
	

}
