package com.cloud.icenter.yyzx.fzjc.education.pojo;

import com.cloud.icenter.base.pojo.Pojo;

/**
 * 查询条件
 * @author whcai
 *
 */
public class SchoolQueryParam extends Pojo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 学校类型：幼儿园、小学、初中
	 */
	private String xxlx;
	
	/**
	 * 年份
	 */
	private int nf;
	
	/**
	 * 行政区代码
	 */
	private String xzqdm;
	
	/**
	 * 排序类型：招生名额、适龄学童、名额不足
	 */
	private String sortType;

	public String getXxlx() {
		return xxlx;
	}

	public void setXxlx(String xxlx) {
		this.xxlx = xxlx;
	}

	public int getNf() {
		return nf;
	}

	public void setNf(int nf) {
		this.nf = nf;
	}

	public String getXzqdm() {
		return xzqdm;
	}

	public void setXzqdm(String xzqdm) {
		this.xzqdm = xzqdm;
	}

	public String getSortType() {
		return sortType;
	}

	public void setSortType(String sortType) {
		this.sortType = sortType;
	}

}
