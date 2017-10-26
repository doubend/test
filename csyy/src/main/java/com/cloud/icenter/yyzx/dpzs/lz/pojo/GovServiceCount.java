package com.cloud.icenter.yyzx.dpzs.lz.pojo;

import java.util.Date;

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
 * 
 * 政务服务-行政审批统计
 * 
 * @author wzy_0216
 *
 */
@Entity
@Table(name = "t_zwfw_sx_tj")
public class GovServiceCount extends Pojo {

	private static final long serialVersionUID = -4651324520605659365L;

	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "ID", unique = true, nullable = false, length = 32)
	private String id;

	// 当前年已预受理
	@Column(name = "NOWYEARACCEPTING")
	private String yearAccepting;

	// 当前年已受理
	@Column(name = "NOWYEARACCEPTED")
	private String yearAccepted;

	// 当前年正在办理
	@Column(name = "NOWYEARHANDLE")
	private String yearHandle;

	// 当前年已办结
	@Column(name = "NOWYEARHANDLED")
	private String yearHandled;

	// 当前月已预受理
	@Column(name = "NOWMONTHACCEPTING")
	private String monthAccepting;

	// 当前月已受理
	@Column(name = "NOWMONTHACCEPTED")
	private String monthAccepted;

	// 当前月正在办理
	@Column(name = "NOWMONTHHANDLE")
	private String monthHandle;

	// 当前月已办结
	@Column(name = "NOWMONTHHANDLED")
	private String monthHandled;

	// 当前日已预受理
	@Column(name = "NOWDAYACCEPTING")
	private String dayAccepting;

	// 当前日已受理
	@Column(name = "NOWDAYACCEPTED")
	private String dayAccepted;

	// 当前日正在办理
	@Column(name = "NOWDAYHANDLE")
	private String dayHandle;

	// 当前日已办结
	@Column(name = "NOWDAYHANDLED")
	private String dayHandled;

	// 当前日
	@Column(name = "NOWDAY")
	private String day;

	// 当前月
	@Column(name = "NOWMONTH")
	private String month;

	// 当前年
	@Column(name = "NOWYEAR")
	private String year;

	// 创建时间
	@Column(name = "CREATE_DATE")
	private Date createdDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getYearAccepting() {
		return yearAccepting;
	}

	public void setYearAccepting(String yearAccepting) {
		this.yearAccepting = yearAccepting;
	}

	public String getYearAccepted() {
		return yearAccepted;
	}

	public void setYearAccepted(String yearAccepted) {
		this.yearAccepted = yearAccepted;
	}

	public String getYearHandle() {
		return yearHandle;
	}

	public void setYearHandle(String yearHandle) {
		this.yearHandle = yearHandle;
	}

	public String getYearHandled() {
		return yearHandled;
	}

	public void setYearHandled(String yearHandled) {
		this.yearHandled = yearHandled;
	}

	public String getMonthAccepting() {
		return monthAccepting;
	}

	public void setMonthAccepting(String monthAccepting) {
		this.monthAccepting = monthAccepting;
	}

	public String getMonthAccepted() {
		return monthAccepted;
	}

	public void setMonthAccepted(String monthAccepted) {
		this.monthAccepted = monthAccepted;
	}

	public String getMonthHandle() {
		return monthHandle;
	}

	public void setMonthHandle(String monthHandle) {
		this.monthHandle = monthHandle;
	}

	public String getMonthHandled() {
		return monthHandled;
	}

	public void setMonthHandled(String monthHandled) {
		this.monthHandled = monthHandled;
	}

	public String getDayAccepting() {
		return dayAccepting;
	}

	public void setDayAccepting(String dayAccepting) {
		this.dayAccepting = dayAccepting;
	}

	public String getDayAccepted() {
		return dayAccepted;
	}

	public void setDayAccepted(String dayAccepted) {
		this.dayAccepted = dayAccepted;
	}

	public String getDayHandle() {
		return dayHandle;
	}

	public void setDayHandle(String dayHandle) {
		this.dayHandle = dayHandle;
	}

	public String getDayHandled() {
		return dayHandled;
	}

	public void setDayHandled(String dayHandled) {
		this.dayHandled = dayHandled;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public GovServiceCount() {
	}

	@Override
	public String toString() {
		return "GovServiceCount [id=" + id + ", yearAccepting=" + yearAccepting
				+ ", yearAccepted=" + yearAccepted + ", yearHandle="
				+ yearHandle + ", yearHandled=" + yearHandled
				+ ", monthAccepting=" + monthAccepting + ", monthAccepted="
				+ monthAccepted + ", monthHandle=" + monthHandle
				+ ", monthHandled=" + monthHandled + ", dayAccepting="
				+ dayAccepting + ", dayAccepted=" + dayAccepted
				+ ", dayHandle=" + dayHandle + ", dayHandled=" + dayHandled
				+ ", day=" + day + ", month=" + month + ", year=" + year
				+ ", createdDate=" + createdDate + "]";
	}

}
