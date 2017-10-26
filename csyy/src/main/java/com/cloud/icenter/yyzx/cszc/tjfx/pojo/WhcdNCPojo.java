package com.cloud.icenter.yyzx.cszc.tjfx.pojo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.cloud.icenter.base.pojo.Pojo;

/**
 * 城镇农村文化分析
 * @date 2017年10月12日
 * @author dxliug
 */
@Entity
@Table(name = "t_cszc_jyfzfx_nc_whcd")
public class WhcdNCPojo extends Pojo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 32)
    private  String id;  
	
	@Column(name="cp_type")
	private String cpType;
	
	@Column(name="cp_total")
	private Float cpTotal;
	
	@Column(name="np_total")
	private Float npTotal;
	
	 @Column(name = "tyear",length = 1)
	 private Integer tyear;//统计年份
	 
	 @Column(name = "create_time")
	 private Timestamp createTime;
	 @Column(name = "update_time")
	 private Timestamp updateTime;
	 @Column(name = "delete_time")
	 private Timestamp deleteTime;
	 @Column(name = "delete_state", length = 32 )
	 private String deleteState;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getTyear() {
		return tyear;
	}
	public void setTyear(Integer tyear) {
		this.tyear = tyear;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	public Timestamp getDeleteTime() {
		return deleteTime;
	}
	public void setDeleteTime(Timestamp deleteTime) {
		this.deleteTime = deleteTime;
	}
	public String getDeleteState() {
		return deleteState;
	}
	public void setDeleteState(String deleteState) {
		this.deleteState = deleteState;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getCpType() {
		return cpType;
	}
	public void setCpType(String cpType) {
		this.cpType = cpType;
	}
	public Float getCpTotal() {
		return cpTotal;
	}
	public void setCpTotal(Float cpTotal) {
		this.cpTotal = cpTotal;
	}
	public Float getNpTotal() {
		return npTotal;
	}
	public void setNpTotal(Float npTotal) {
		this.npTotal = npTotal;
	}
	 
	 
}
