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

import com.cloud.icenter.base.pojo.Pojo;

/**
 * 大屏-法人-大屏法人企业从业人员
 * 
 * @author dbchenga
 */
@Entity
@Table(name = "t_dp_fr_qyry")
public class DpFrFrqyryPojo extends Pojo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "ID", unique = true, nullable = false, length = 32)
	private String id;

	@Column(name = "year")
	private Integer year;// 年份

	@Column(name = "qdhy")
	private Integer qdhy;// 7大行业企业
	@Column(name = "nlmy")
	private Integer nlmy;// 农林牧渔企业
	@Column(name = "whly")
	private Integer whly;// 文化旅游企业

	@Column(name = "qdhyry")
	private Integer qdhyry;// 7大行业人员
	@Column(name = "nlmyry")
	private Integer nlmyry;// 农林牧渔人员
	@Column(name = "whlyry")
	private Integer whlyry;// 文化旅游人员
	@Column(name = "status")
	private Integer status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time", length = 7)
	private Date create_time;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_time", length = 7)
	private Date update_time;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "remove_time", length = 7)
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

	public Integer getQdhy() {
		return qdhy;
	}

	public void setQdhy(Integer qdhy) {
		this.qdhy = qdhy;
	}

	public Integer getNlmy() {
		return nlmy;
	}

	public void setNlmy(Integer nlmy) {
		this.nlmy = nlmy;
	}

	public Integer getWhly() {
		return whly;
	}

	public void setWhly(Integer whly) {
		this.whly = whly;
	}

	public Integer getQdhyry() {
		return qdhyry;
	}

	public void setQdhyry(Integer qdhyry) {
		this.qdhyry = qdhyry;
	}

	public Integer getNlmyry() {
		return nlmyry;
	}

	public void setNlmyry(Integer nlmyry) {
		this.nlmyry = nlmyry;
	}

	public Integer getWhlyry() {
		return whlyry;
	}

	public void setWhlyry(Integer whlyry) {
		this.whlyry = whlyry;
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
