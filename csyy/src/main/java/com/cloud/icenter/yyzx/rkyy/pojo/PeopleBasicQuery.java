package com.cloud.icenter.yyzx.rkyy.pojo;

import java.io.Serializable;
import java.util.Date;

/** 
* @author zhucy 
* @version 2017年4月26日 上午10:02:04 
* 人口查询
*/
public class PeopleBasicQuery implements Serializable{
	 
		/**
		 * serialVersionUID:TODO（用一句话描述这个变量表示什么）
		 *
		 * @since 1.0.0
		 */
		
		private static final long serialVersionUID = 1L;
		private Long id;
		private String peopleName;		//姓名
		private String sex;				//性别：man男,women女
		private String nation;	//民族
		private String age;				//年龄
	    private Date birth;           //出生年月
		private String phone;			//联系电话
		private String address;			//住址
		private String idNumber;		//身份证号码
		private String maritalStatus;		//婚姻状况：WH未婚，YH已婚
		private String job;		//就业状况：0未就业，1已就业
		private String education;	//教育：0小学，1中学，2本科及专科，3研究生
		private String income;			//收入：0:3000-5000/月，1:5000-7000/月，2：7000-9000/月，3：9000及以上
		private String socialSecurity;			//社保：0未交，1已交
		private String houseProperty;			//房产：0：无，1：一套，2：两套及以上
		private String credit;			//信用：0：良好，1一般，2差
		private String healthPlanning;			//卫生计生：0：良好，1一般，2差
		private String tax;			//税务：0：良好，1一般，2差
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getPeopleName() {
			return peopleName;
		}
		public void setPeopleName(String peopleName) {
			this.peopleName = peopleName;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		public String getAge() {
			return age;
		}
		public void setAge(String age) {
			this.age = age;
		}
		public Date getBirth() {
			return birth;
		}
		public void setBirth(Date birth) {
			this.birth = birth;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getIdNumber() {
			return idNumber;
		}
		public void setIdNumber(String idNumber) {
			this.idNumber = idNumber;
		}
		public String getMaritalStatus() {
			return maritalStatus;
		}
		public void setMaritalStatus(String maritalStatus) {
			this.maritalStatus = maritalStatus;
		}
		public String getJob() {
			return job;
		}
		public void setJob(String job) {
			this.job = job;
		}
		public String getEducation() {
			return education;
		}
		public void setEducation(String education) {
			this.education = education;
		}
		public String getIncome() {
			return income;
		}
		public void setIncome(String income) {
			this.income = income;
		}
		public String getSocialSecurity() {
			return socialSecurity;
		}
		public void setSocialSecurity(String socialSecurity) {
			this.socialSecurity = socialSecurity;
		}
		public String getHouseProperty() {
			return houseProperty;
		}
		public void setHouseProperty(String houseProperty) {
			this.houseProperty = houseProperty;
		}
		public String getCredit() {
			return credit;
		}
		public void setCredit(String credit) {
			this.credit = credit;
		}
		public String getHealthPlanning() {
			return healthPlanning;
		}
		public void setHealthPlanning(String healthPlanning) {
			this.healthPlanning = healthPlanning;
		}
		public String getTax() {
			return tax;
		}
		public void setTax(String tax) {
			this.tax = tax;
		}
		public String getNation() {
			return nation;
		}
		public void setNation(String nation) {
			this.nation = nation;
		}
}
