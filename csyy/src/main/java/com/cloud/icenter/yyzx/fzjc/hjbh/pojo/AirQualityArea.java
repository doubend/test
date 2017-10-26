package com.cloud.icenter.yyzx.fzjc.hjbh.pojo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.cloud.icenter.base.pojo.Pojo;
/**
 * 区域空气质量排名
 * @author Administrator
 *
 */
@Entity
@Table(name = "t_hjbh_kqzl_kqpm")
public class AirQualityArea extends Pojo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 32)
	private String id;//                        id                 主键  
	
	@Column(name = "county_name")
	private String county_name;//               varchar(20)        城市名称
	
	@Column(name = "ai_quality_val")
	private Integer ai_quality_val;//           int                空气质量
	
	@Column(name = "create_time")
	private Timestamp create_time;//            timestamp          创建时间
	
	@Column(name = "update_time")
	private Timestamp update_time;//            timestamp          更新时间
	
	@Column(name = "delete_time")
	private Timestamp delete_time;//            timestamp          删除时间
	
	@Column(name = "delete_state")
	private Integer delete_state;//              char(1)           1已删除，0正常

	public String getId() {
		return id;
	}

	public String getCounty_name() {
		return county_name;
	}

	public Integer getAi_quality_val() {
		return ai_quality_val;
	}

	public Timestamp getCreate_time() {
		return create_time;
	}

	public Timestamp getUpdate_time() {
		return update_time;
	}

	public Timestamp getDelete_time() {
		return delete_time;
	}

	public Integer getDelete_state() {
		return delete_state;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setCounty_name(String county_name) {
		this.county_name = county_name;
	}

	public void setAi_quality_val(Integer ai_quality_val) {
		this.ai_quality_val = ai_quality_val;
	}

	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}

	public void setUpdate_time(Timestamp update_time) {
		this.update_time = update_time;
	}

	public void setDelete_time(Timestamp delete_time) {
		this.delete_time = delete_time;
	}

	public void setDelete_state(Integer delete_state) {
		this.delete_state = delete_state;
	}
	
	
}
