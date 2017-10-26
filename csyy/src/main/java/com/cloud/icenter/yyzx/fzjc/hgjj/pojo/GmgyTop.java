package com.cloud.icenter.yyzx.fzjc.hgjj.pojo;

import java.math.BigDecimal;
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
 * 企业总产值TOP5排行情况
 * @author Administrator
 *
 */
@Entity
@Table(name = "t_jjfz_gmgy_top")
public class GmgyTop extends Pojo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 32)
	private String id;//              unsigned bigint              主键
	
	@Column(name = "nian")
	private Integer nian;//            int                          年份
	
	@Column(name = "top_one_qy")
	private String top1qy;//          varchar(50)                  top1企业名称
	
	@Column(name = "top_one_cz")
	private BigDecimal top1_cz;//         decimal                      top1企业产值
	
	@Column(name = "top_tow_qy")
	private String top2qy;//         varchar(50)                  top2企业名称
	
	@Column(name = "top_tow_cz")
	private BigDecimal top2_cz;//         decimal                      top2企业产值
	
	@Column(name = "top_three_qy")
	private String top3qy;//         varchar(50)                  top3企业名称
	
	@Column(name = "top_three_cz")
	private BigDecimal top3_cz;//         decimal                      top3企业产值
	
	@Column(name = "top_four_qy")
	private String top4qy;//          varchar(50)                  top4企业名称
	
	@Column(name = "top_four_cz")
	private BigDecimal top4_cz;//         decimal                      top4企业产值
	
	@Column(name = "top_five_qy")
	private String top5qy;//         varchar(50)                  top5企业名称
	
	@Column(name = "top_five_cz")
	private BigDecimal top5_cz;//         decimal                      top5企业产值
	
	@Column(name = "create_time")
	private Timestamp create_time;//     timestamp                    创建时间
	
	@Column(name = "update_time")
	private Timestamp update_time;//     timestamp                    更新时间
	
	@Column(name = "delete_time")
	private Timestamp delete_time;//     timestamp                    删除时间
	
	@Column(name = "delete_state")
	private Integer delete_state;//   unsigned tinyint             1已删除，0正常

	public Integer getNian() {
		return nian;
	}
	public String getTop1qy() {
		return top1qy;
	}
	public BigDecimal getTop1_cz() {
		return top1_cz;
	}
	public String getTop2qy() {
		return top2qy;
	}
	public BigDecimal getTop2_cz() {
		return top2_cz;
	}
	public String getTop3qy() {
		return top3qy;
	}
	public BigDecimal getTop3_cz() {
		return top3_cz;
	}
	public String getTop4qy() {
		return top4qy;
	}
	public BigDecimal getTop4_cz() {
		return top4_cz;
	}
	public String getTop5qy() {
		return top5qy;
	}
	public BigDecimal getTop5_cz() {
		return top5_cz;
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
	public void setNian(Integer nian) {
		this.nian = nian;
	}
	public void setTop1qy(String top1qy) {
		this.top1qy = top1qy;
	}
	public void setTop1_cz(BigDecimal top1_cz) {
		this.top1_cz = top1_cz;
	}
	public void setTop2qy(String top2qy) {
		this.top2qy = top2qy;
	}
	public void setTop2_cz(BigDecimal top2_cz) {
		this.top2_cz = top2_cz;
	}
	public void setTop3qy(String top3qy) {
		this.top3qy = top3qy;
	}
	public void setTop3_cz(BigDecimal top3_cz) {
		this.top3_cz = top3_cz;
	}
	public void setTop4qy(String top4qy) {
		this.top4qy = top4qy;
	}
	public void setTop4_cz(BigDecimal top4_cz) {
		this.top4_cz = top4_cz;
	}
	public void setTop5qy(String top5qy) {
		this.top5qy = top5qy;
	}
	public void setTop5_cz(BigDecimal top5_cz) {
		this.top5_cz = top5_cz;
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
