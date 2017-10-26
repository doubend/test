package com.cloud.icenter.yyzx.fzjc.fr.pojo;

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
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 人口年龄结构变化
 * 
 * @author Administrator
 * 
 */
@Entity
@Table(name = "t_fr_top8")
public class FRTop8Pojo extends Pojo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "ID", unique = true, nullable = false, length = 32)
	@JsonIgnore
	private String id;

	@Column(name = "year")
	@JsonIgnore
	private Integer year;

	private String top_one_name;
	private Integer top_one_num;

	private String top_two_name;
	private Integer top_two_num;

	private String top_thr_name;
	private Integer top_thr_num;

	private String top_four_name;
	private Integer top_four_num;

	private String top_five_name;
	private Integer top_five_num;

	private String top_six_name;
	private Integer top_six_num;

	private String top_seven_name;
	private Integer top_seven_num;

	private String top_eight_name;
	private Integer top_eight_num;

	@Column(name = "status")
	@JsonIgnore
	private Integer status;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time", length = 7)
	@JsonIgnore
	private Date create_time;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_time", length = 7)
	@JsonIgnore
	private Date update_time;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "remove_time", length = 7)
	@JsonIgnore
	private Date remove_time;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getTop_one_name() {
		return top_one_name;
	}

	public void setTop_one_name(String top_one_name) {
		this.top_one_name = top_one_name;
	}

	public Integer getTop_one_num() {
		return top_one_num;
	}

	public void setTop_one_num(Integer top_one_num) {
		this.top_one_num = top_one_num;
	}

	public String getTop_two_name() {
		return top_two_name;
	}

	public void setTop_two_name(String top_two_name) {
		this.top_two_name = top_two_name;
	}

	public Integer getTop_two_num() {
		return top_two_num;
	}

	public void setTop_two_num(Integer top_two_num) {
		this.top_two_num = top_two_num;
	}

	public String getTop_thr_name() {
		return top_thr_name;
	}

	public void setTop_thr_name(String top_thr_name) {
		this.top_thr_name = top_thr_name;
	}

	public Integer getTop_thr_num() {
		return top_thr_num;
	}

	public void setTop_thr_num(Integer top_thr_num) {
		this.top_thr_num = top_thr_num;
	}

	public String getTop_four_name() {
		return top_four_name;
	}

	public void setTop_four_name(String top_four_name) {
		this.top_four_name = top_four_name;
	}

	public Integer getTop_four_num() {
		return top_four_num;
	}

	public void setTop_four_num(Integer top_four_num) {
		this.top_four_num = top_four_num;
	}

	public String getTop_five_name() {
		return top_five_name;
	}

	public void setTop_five_name(String top_five_name) {
		this.top_five_name = top_five_name;
	}

	public Integer getTop_five_num() {
		return top_five_num;
	}

	public void setTop_five_num(Integer top_five_num) {
		this.top_five_num = top_five_num;
	}

	public String getTop_six_name() {
		return top_six_name;
	}

	public void setTop_six_name(String top_six_name) {
		this.top_six_name = top_six_name;
	}

	public Integer getTop_six_num() {
		return top_six_num;
	}

	public void setTop_six_num(Integer top_six_num) {
		this.top_six_num = top_six_num;
	}

	public String getTop_seven_name() {
		return top_seven_name;
	}

	public void setTop_seven_name(String top_seven_name) {
		this.top_seven_name = top_seven_name;
	}

	public Integer getTop_seven_num() {
		return top_seven_num;
	}

	public void setTop_seven_num(Integer top_seven_num) {
		this.top_seven_num = top_seven_num;
	}

	public String getTop_eight_name() {
		return top_eight_name;
	}

	public void setTop_eight_name(String top_eight_name) {
		this.top_eight_name = top_eight_name;
	}

	public Integer getTop_eight_num() {
		return top_eight_num;
	}

	public void setTop_eight_num(Integer top_eight_num) {
		this.top_eight_num = top_eight_num;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	public Date getRemove_time() {
		return remove_time;
	}

	public void setRemove_time(Date remove_time) {
		this.remove_time = remove_time;
	}

}
