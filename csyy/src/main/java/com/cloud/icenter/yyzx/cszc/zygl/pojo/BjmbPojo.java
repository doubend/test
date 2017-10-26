package com.cloud.icenter.yyzx.cszc.zygl.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import com.cloud.icenter.base.pojo.Pojo;
import com.fasterxml.jackson.annotation.JsonFormat;

/** 
* @author zhucy 
* @version 2017年3月24日 下午1:57:59 
* 资源分类>部件码表
*/
@Entity
@Table(name = "t_cszc_bjmb")
public class BjmbPojo extends Pojo{
	
	public static final int TYPE_DIRECTORY = 1; // 类型:目录
	public static final int TYPE_LEAF = 2; // 类型:叶子

	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 32)
	private String id;
	
	@Column(name = "dm")
	private String dm;
	
	@Column(name = "mc")
	private String mc;
	
	@Column(name = "sjbh",length = 32)
	private String sjbh;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "create_time")
	private Date createTime;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "update_time")
	private Date updateTime;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "delete_time")
	private Date deleteTime;
	
	@Column(name = "delete_status")
	private String deleteStatus;//1已删除，0正常
	
	@Column(name = "creator_id")
	private String creatorId;
	
	@Column(name = "type")
	private Integer type;
	
	@Column(name = "seq_num")
	private Integer seqNum;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDm() {
		return dm;
	}

	public void setDm(String dm) {
		this.dm = dm;
	}

	public String getMc() {
		return mc;
	}

	public void setMc(String mc) {
		this.mc = mc;
	}

	public String getSjbh() {
		return sjbh;
	}

	public void setSjbh(String sjbh) {
		this.sjbh = sjbh;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	public Date getDeleteTime() {
		return deleteTime;
	}

	public void setDeleteTime(Date deleteTime) {
		this.deleteTime = deleteTime;
	}

	public String getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(String deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public String getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getSeqNum() {
		return seqNum;
	}

	public void setSeqNum(Integer seqNum) {
		this.seqNum = seqNum;
	}
	
	
	
}
