package com.cloud.icenter.yyzx.ztfx.jzfp.pojo;

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
 * 贫困人员的汇总信息体类
 * 
 * @author dbchenga
 */
@Entity
@Table(name = "t_poor_plan")
public class PoorPlanPojo extends Pojo {

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

	@JsonIgnore
	private Integer year;

	private String wushan;
	private String qinzhou;
	private String maiji;

	private String gangu;
	private String qinan;
	private String qingshui;
	private String zhangjiachuan;

	private String chanye;
	private String zijin;
	private String shehui;
	private String jishu;
	private String ydbq;
	private String bzjz;
	private String standby5;

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

	public String getWushan() {
		return wushan;
	}

	public void setWushan(String wushan) {
		this.wushan = wushan;
	}

	public String getQinzhou() {
		return qinzhou;
	}

	public void setQinzhou(String qinzhou) {
		this.qinzhou = qinzhou;
	}

	public String getMaiji() {
		return maiji;
	}

	public void setMaiji(String maiji) {
		this.maiji = maiji;
	}

	public String getGangu() {
		return gangu;
	}

	public void setGangu(String gangu) {
		this.gangu = gangu;
	}

	public String getQinan() {
		return qinan;
	}

	public void setQinan(String qinan) {
		this.qinan = qinan;
	}

	public String getQingshui() {
		return qingshui;
	}

	public void setQingshui(String qingshui) {
		this.qingshui = qingshui;
	}

	public String getZhangjiachuan() {
		return zhangjiachuan;
	}

	public void setZhangjiachuan(String zhangjiachuan) {
		this.zhangjiachuan = zhangjiachuan;
	}

	public String getChanye() {
		return chanye;
	}

	public void setChanye(String chanye) {
		this.chanye = chanye;
	}

	public String getZijin() {
		return zijin;
	}

	public void setZijin(String zijin) {
		this.zijin = zijin;
	}

	public String getShehui() {
		return shehui;
	}

	public void setShehui(String shehui) {
		this.shehui = shehui;
	}

	public String getJishu() {
		return jishu;
	}

	public void setJishu(String jishu) {
		this.jishu = jishu;
	}

	public String getYdbq() {
		return ydbq;
	}

	public void setYdbq(String ydbq) {
		this.ydbq = ydbq;
	}

	public String getBzjz() {
		return bzjz;
	}

	public void setBzjz(String bzjz) {
		this.bzjz = bzjz;
	}

	public String getStandby5() {
		return standby5;
	}

	public void setStandby5(String standby5) {
		this.standby5 = standby5;
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
