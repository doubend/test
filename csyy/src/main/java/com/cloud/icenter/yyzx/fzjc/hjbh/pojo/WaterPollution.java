package com.cloud.icenter.yyzx.fzjc.hjbh.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.cloud.icenter.base.pojo.Pojo;

/**
 * 水体污染源企业排污总量排名
 * @author Administrator
 *
 */
@Entity
@Table(name = "t_hjbh_szfx_qypw")
public class WaterPollution extends Pojo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 32)
	private String id;//                       varchar(32)        主键
	
	@Column(name = "company", length = 100)
	private String company;//                   varchar(100)       公司名称
	
	@Column(name = "KMNO")
	private BigDecimal KMNO;//                      float              高锰酸钾
	
	@Column(name = "KMNO_trend")
	private Integer KMNO_trend;   //             char(1)            高锰酸钾趋势（1上升，0下降）
	
	@Column(name = "conductance")
	private BigDecimal conductance;//               float              电导率
	
	@Column(name = "conductance_trend")
	private Integer conductance_trend;//	      char(1)            电导率趋势（1上升，0下降）
	
	@Column(name = "ranking")
	private Integer ranking;//      	          smallint           排名
	
	@Column(name = "create_time")
	private Timestamp create_time;//               timestamp          创建时间
	
	@Column(name = "update_time")
	private Timestamp update_time;//              timestamp          更新时间
	
	@Column(name = "delete_time")
	private Timestamp delete_time;//             timestamp          删除时间
	
	@Column(name = "delete_state")
	private Integer delete_state;//             char(1)            1已删除，0正常

	public String getId() {
		return id;
	}

	public String getCompany() {
		return company;
	}

	public BigDecimal getKMNO() {
		return KMNO;
	}

	public Integer getKMNO_trend() {
		return KMNO_trend;
	}

	public BigDecimal getConductance() {
		return conductance;
	}

	public Integer getConductance_trend() {
		return conductance_trend;
	}

	public Integer getRanking() {
		return ranking;
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

	public void setCompany(String company) {
		this.company = company;
	}

	public void setKMNO(BigDecimal kMNO) {
		KMNO = kMNO;
	}

	public void setKMNO_trend(Integer kMNO_trend) {
		KMNO_trend = kMNO_trend;
	}

	public void setConductance(BigDecimal conductance) {
		this.conductance = conductance;
	}

	public void setConductance_trend(Integer conductance_trend) {
		this.conductance_trend = conductance_trend;
	}

	public void setRanking(Integer ranking) {
		this.ranking = ranking;
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
