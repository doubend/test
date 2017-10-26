package com.cloud.icenter.yyzx.rkyy.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_gasp_sys_data_dic")
public class Dictionary implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private BigDecimal id;

	@Column(name = "dic_name")
	private String dicName;// 字典名称

	@Column(name = "dic_code")
	private String dicCode;// 字典编码

	@Column(name = "dic_state")
	private String dicState;// 当前状态

	@Column(name = "dic_type")
	private String dicType;// 图例类型(rkk表示人口库，frk表示法人库)

	

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getDicName() {
		return dicName;
	}

	public void setDicName(String dicName) {
		this.dicName = dicName;
	}

	public String getDicCode() {
		return dicCode;
	}

	public void setDicCode(String dicCode) {
		this.dicCode = dicCode;
	}

	public String getDicState() {
		return dicState;
	}

	public void setDicState(String dicState) {
		this.dicState = dicState;
	}

	public String getDicType() {
		return dicType;
	}

	public void setDicType(String dicType) {
		this.dicType = dicType;
	}

	@Override
	public String toString() {
		return "Dictionary [id=" + id + ", dicName=" + dicName + ", dicCode="
				+ dicCode + ", dicState=" + dicState + ", dicType=" + dicType
				+ "]";
	}

}
