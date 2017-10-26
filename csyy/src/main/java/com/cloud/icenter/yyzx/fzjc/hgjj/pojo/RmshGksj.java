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
 * 人民生活页面左上角基本概况数据
 * @author Administrator
 *
 */
@Entity
@Table(name = "t_rmsh_gksj")
public class RmshGksj extends Pojo{

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
	private Integer nian;//年份
	
	@Column(name = "szrk")
	private BigDecimal szrk;//            decimal(10,2)                市总人口
	
	@Column(name = "szrk_zf")
	private BigDecimal szrk_zf;//市总人口增幅
	
	@Column(name = "nnxbb")
	private BigDecimal nnxbb;//          decimal(10,2)                男女性别比
	
	@Column(name = "nyrk")
	private BigDecimal nyrk;//            decimal(10,2)                农业人口
	
	@Column(name = "nyrk_zf")
	private BigDecimal nyrk_zf; //农业人口增幅
	
	@Column(name = "czhl")
	private BigDecimal czhl;//            decimal(10,2)                城镇化率
	
	@Column(name = "ldrk")
	private BigDecimal ldrk;//           decimal(10,2)                流动人口
	
	@Column(name = "ldrk_zf")
	private BigDecimal ldrk_zf;//流动人口增幅
	
	@Column(name = "zhanb")
	private BigDecimal zhanb;//           decimal(10,2)                流动人口占比
	
	@Column(name = "xsye")
	private BigDecimal xsye;//            decimal(10,2)                新生婴儿
	
	@Column(name = "xsye_zf")
	private BigDecimal xsye_zf;//新生婴儿增幅
	
	@Column(name = "zfyb")
	private BigDecimal zfyb;//            decimal(10,2)                总抚养比
	
	@Column(name = "ybrs")
	private BigDecimal ybrs;//            decimal(10,2)                参加医保人数
	
	@Column(name = "rjgd")
	private BigDecimal rjgd;//           decimal(10,2)                人均耕地
	
	@Column(name = "czdwcyry")
	private int czdwcyry;//城镇单位从业人员
	
	@Column(name = "f_czdwcyry")
	private int f_czdwcyry;//非城镇单位从业人员
	
	@Column(name = "czgtsycyry")
	private int czgtsycyry;//城镇个体私营从业人员
	
	@Column(name = "f_czgtsycyry")
	private int f_czgtsycyry;//非城镇个体私营从业人员
	
	@Column(name = "nccyry")
	private int nccyry;//农村从业人员
	
	@Column(name = "f_nccyry")
	private int f_nccyry;//非农村从业人员
	
	@Column(name = "gnwgjy")
	private int gnwgjy;//国内务工就业
	
	@Column(name = "xzswlwjy")
	private int xzswlwjy;//新增涉外劳务就业
	
	@Column(name = "tsnycyjjq")
	private int tsnycyjjq;//特色农业和产业集聚区就近就地就业
	
	@Column(name = "create_time")
	private Timestamp create_time;//     timestamp                    创建时间
	
	@Column(name = "update_time")
	private Timestamp update_time;//     timestamp                    更新时间
	
	@Column(name = "delete_time")
	private Timestamp delete_time;//     timestamp                    删除时间
	
	@Column(name = "delete_state")
	private Integer delete_state;//    unsigned tinyint             1已删除，0正常

	public BigDecimal getSzrk() {
		return szrk;
	}
	public BigDecimal getNnxbb() {
		return nnxbb;
	}
	public BigDecimal getNyrk() {
		return nyrk;
	}
	public BigDecimal getCzhl() {
		return czhl;
	}
	public BigDecimal getLdrk() {
		return ldrk;
	}
	public BigDecimal getZhanb() {
		return zhanb;
	}
	public BigDecimal getXsye() {
		return xsye;
	}
	public BigDecimal getZfyb() {
		return zfyb;
	}
	public BigDecimal getYbrs() {
		return ybrs;
	}
	public BigDecimal getRjgd() {
		return rjgd;
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
	public void setSzrk(BigDecimal szrk) {
		this.szrk = szrk;
	}
	public void setNnxbb(BigDecimal nnxbb) {
		this.nnxbb = nnxbb;
	}
	public void setNyrk(BigDecimal nyrk) {
		this.nyrk = nyrk;
	}
	public void setCzhl(BigDecimal czhl) {
		this.czhl = czhl;
	}
	public void setLdrk(BigDecimal ldrk) {
		this.ldrk = ldrk;
	}
	public void setZhanb(BigDecimal zhanb) {
		this.zhanb = zhanb;
	}
	public void setXsye(BigDecimal xsye) {
		this.xsye = xsye;
	}
	public void setZfyb(BigDecimal zfyb) {
		this.zfyb = zfyb;
	}
	public void setYbrs(BigDecimal ybrs) {
		this.ybrs = ybrs;
	}
	public void setRjgd(BigDecimal rjgd) {
		this.rjgd = rjgd;
	}
	public int getCzdwcyry() {
		return czdwcyry;
	}
	public void setCzdwcyry(int czdwcyry) {
		this.czdwcyry = czdwcyry;
	}
	public int getF_czdwcyry() {
		return f_czdwcyry;
	}
	public void setF_czdwcyry(int f_czdwcyry) {
		this.f_czdwcyry = f_czdwcyry;
	}
	public int getCzgtsycyry() {
		return czgtsycyry;
	}
	public void setCzgtsycyry(int czgtsycyry) {
		this.czgtsycyry = czgtsycyry;
	}
	public int getF_czgtsycyry() {
		return f_czgtsycyry;
	}
	public void setF_czgtsycyry(int f_czgtsycyry) {
		this.f_czgtsycyry = f_czgtsycyry;
	}
	public int getNccyry() {
		return nccyry;
	}
	public void setNccyry(int nccyry) {
		this.nccyry = nccyry;
	}
	public int getF_nccyry() {
		return f_nccyry;
	}
	public void setF_nccyry(int f_nccyry) {
		this.f_nccyry = f_nccyry;
	}
	public int getGnwgjy() {
		return gnwgjy;
	}
	public void setGnwgjy(int gnwgjy) {
		this.gnwgjy = gnwgjy;
	}
	public int getXzswlwjy() {
		return xzswlwjy;
	}
	public void setXzswlwjy(int xzswlwjy) {
		this.xzswlwjy = xzswlwjy;
	}
	public int getTsnycyjjq() {
		return tsnycyjjq;
	}
	public void setTsnycyjjq(int tsnycyjjq) {
		this.tsnycyjjq = tsnycyjjq;
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
	public Integer getNian() {
		return nian;
	}
	public BigDecimal getSzrk_zf() {
		return szrk_zf;
	}
	public BigDecimal getNyrk_zf() {
		return nyrk_zf;
	}
	public BigDecimal getLdrk_zf() {
		return ldrk_zf;
	}
	public BigDecimal getXsye_zf() {
		return xsye_zf;
	}
	public void setNian(Integer nian) {
		this.nian = nian;
	}
	public void setSzrk_zf(BigDecimal szrk_zf) {
		this.szrk_zf = szrk_zf;
	}
	public void setNyrk_zf(BigDecimal nyrk_zf) {
		this.nyrk_zf = nyrk_zf;
	}
	public void setLdrk_zf(BigDecimal ldrk_zf) {
		this.ldrk_zf = ldrk_zf;
	}
	public void setXsye_zf(BigDecimal xsye_zf) {
		this.xsye_zf = xsye_zf;
	}

}
