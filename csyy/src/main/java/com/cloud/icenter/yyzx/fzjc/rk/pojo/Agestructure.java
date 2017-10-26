package com.cloud.icenter.yyzx.fzjc.rk.pojo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import com.cloud.icenter.base.pojo.Pojo;
import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 人口年龄结构变化
 * @author Administrator
 *
 */
@Entity
@Table(name = "t_renk_rkfb_nljg")
public class Agestructure extends Pojo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 32)
	private String id;//                        varchar(32)       主键
	
	@Column(name = "segment_min")
	private Integer segment_min;//				  smallint          年龄段(最小值)
	
	@Column(name = "segment_max")
	private Integer segment_max;//              smallint          年龄段(最大值)
	
	@Column(name = "man_val")
	private Integer man_val;//                   int               男人数量
	
	@Column(name = "wom_val")
	private Integer wom_val;//                  int               女人数量
	
	@Column(name = "create_time")
	private Timestamp create_time;//              timestamp         创建时间
	
	@Column(name = "update_time")
	private Timestamp update_time;//              timestamp         更新时间
	
	@Column(name = "delete_time")
	private Timestamp delete_time;//              timestamp         删除时间
	
	@Column(name = "delete_state")
	private Integer delete_state;//              char(1)           1已删除，0正常

	public Integer getSegment_min() {
		return segment_min;
	}

	public Integer getSegment_max() {
		return segment_max;
	}

	public Integer getMan_val() {
		return man_val;
	}

	public Integer getWom_val() {
		return wom_val;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	public Timestamp getCreate_time() {
		return create_time;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	public Timestamp getUpdate_time() {
		return update_time;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	public Timestamp getDelete_time() {
		return delete_time;
	}

	public Integer getDelete_state() {
		return delete_state;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setSegment_min(Integer segment_min) {
		this.segment_min = segment_min;
	}

	public void setSegment_max(Integer segment_max) {
		this.segment_max = segment_max;
	}

	public void setMan_val(Integer man_val) {
		this.man_val = man_val;
	}

	public void setWom_val(Integer wom_val) {
		this.wom_val = wom_val;
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
