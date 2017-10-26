package com.cloud.icenter.yyzx.rkyy.pojo;


import java.io.Serializable;
import java.sql.Date;



public class JiuYeInfoQueryQM extends PeopleBasicQuery implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    
    //身份证号
    private String sfz;
    
    //就业状态
    private String jyzt;
    
    //失业证号码
    private String syzhm;
    
    //是否就业困难
    private String sfjykn;
    
    //是否无业人员
    private String sfwyrw;
    
    //是否失保人员
    private String sfsbry;
    
    //工作单位组织机构代码
    private String gzdwzzjgdm;
    
    //工作单位统一社会信用代码
    private String gzdwtyshxydm;
    
    //单位电话
    private String dwdh;
    
    //单位地址编码
    private String dwdzbm;
    
    //是否签订劳动合同
    private String sfqdldht;
    
    //工作起始日期
    private Date gzqsrq;
    
    //工作截止日期
    private Date gzjzrq;
    
    //工作起始日期开始
    private Date gzqsrqks;
    
    //工作起始日期结束
    private Date gzqsrqjs;
    
    //工作截至日期开始
    private Date gzjzrqks;
    
    //工作截至日期结束
    private Date gzjzrqjs;

	public String getSfz() {
		return sfz;
	}

	public void setSfz(String sfz) {
		this.sfz = sfz;
	}

	public String getJyzt() {
		return jyzt;
	}

	public void setJyzt(String jyzt) {
		this.jyzt = jyzt;
	}

	public String getSyzhm() {
		return syzhm;
	}

	public void setSyzhm(String syzhm) {
		this.syzhm = syzhm;
	}

	public String getSfjykn() {
		return sfjykn;
	}

	public void setSfjykn(String sfjykn) {
		this.sfjykn = sfjykn;
	}

	public String getSfwyrw() {
		return sfwyrw;
	}

	public void setSfwyrw(String sfwyrw) {
		this.sfwyrw = sfwyrw;
	}

	public String getSfsbry() {
		return sfsbry;
	}

	public void setSfsbry(String sfsbry) {
		this.sfsbry = sfsbry;
	}

	public String getGzdwzzjgdm() {
		return gzdwzzjgdm;
	}

	public void setGzdwzzjgdm(String gzdwzzjgdm) {
		this.gzdwzzjgdm = gzdwzzjgdm;
	}

	public String getGzdwtyshxydm() {
		return gzdwtyshxydm;
	}

	public void setGzdwtyshxydm(String gzdwtyshxydm) {
		this.gzdwtyshxydm = gzdwtyshxydm;
	}

	public String getDwdh() {
		return dwdh;
	}

	public void setDwdh(String dwdh) {
		this.dwdh = dwdh;
	}

	public String getDwdzbm() {
		return dwdzbm;
	}

	public void setDwdzbm(String dwdzbm) {
		this.dwdzbm = dwdzbm;
	}

	public String getSfqdldht() {
		return sfqdldht;
	}

	public void setSfqdldht(String sfqdldht) {
		this.sfqdldht = sfqdldht;
	}

	public Date getGzqsrq() {
		return gzqsrq;
	}

	public void setGzqsrq(Date gzqsrq) {
		this.gzqsrq = gzqsrq;
	}

	public Date getGzjzrq() {
		return gzjzrq;
	}

	public void setGzjzrq(Date gzjzrq) {
		this.gzjzrq = gzjzrq;
	}

	public Date getGzqsrqks() {
		return gzqsrqks;
	}

	public void setGzqsrqks(Date gzqsrqks) {
		this.gzqsrqks = gzqsrqks;
	}

	public Date getGzqsrqjs() {
		return gzqsrqjs;
	}

	public void setGzqsrqjs(Date gzqsrqjs) {
		this.gzqsrqjs = gzqsrqjs;
	}

	public Date getGzjzrqks() {
		return gzjzrqks;
	}

	public void setGzjzrqks(Date gzjzrqks) {
		this.gzjzrqks = gzjzrqks;
	}

	public Date getGzjzrqjs() {
		return gzjzrqjs;
	}

	public void setGzjzrqjs(Date gzjzrqjs) {
		this.gzjzrqjs = gzjzrqjs;
	}
    
    
    
    
    
}