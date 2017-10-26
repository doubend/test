package com.cloud.icenter.yyzx.cszc.tjfx.pojo;

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
* @version 2017年4月20日 下午5:37:47 
* 基础教育地区分布
*/
@Entity
@Table(name = "t_cszc_jyfzfx_dq")
public class CszcJyfzfxDqPoJo extends Pojo{
	
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 32)
    private  String id;  
	
	@Column(name = "dq")
	private String dq;
	
	@Column(name = "yey")
	private Integer yey;
	
	@Column(name = "wr_yey")
	private Integer wrYey;
	
	@Column(name = "xx")
	private Integer xx;
	
	@Column(name = "wr_xx")
	private Integer wrXx;
	
	@Column(name = "cz")
	private Integer cz;
	
	@Column(name = "wr_cz")
	private Integer wrCz;
	
	@Column(name = "jx")
	private Integer jx;
	
	@Column(name = "wr_jx")
	private Integer wrJx;
	
	/**
	 * 创建时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time", length = 19)
    private  Date createTime;  
    
	/**
	 * 更新时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_time", length = 19)
    private  Date updateTime;  
    
	/**
	 * 删除时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "delete_time", length = 19)
    private  Date deleteTime;  
    
	/**
	 * 删除状态：0正常，1删除
	 */
	@Column(name = "delete_status", length = 1)
    private  String deleteStatus;  
    
	/**
	 * 创建者
	 */
	@Column(name = "creator_id", length = 32)
    private  String creatorId;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDq() {
		return dq;
	}
	public void setDq(String dq) {
		this.dq = dq;
	}
	public Integer getYey() {
		return yey;
	}
	public void setYey(Integer yey) {
		this.yey = yey;
	}
	public Integer getWrYey() {
		return wrYey;
	}
	public void setWrYey(Integer wrYey) {
		this.wrYey = wrYey;
	}
	public Integer getXx() {
		return xx;
	}
	public void setXx(Integer xx) {
		this.xx = xx;
	}
	public Integer getWrXx() {
		return wrXx;
	}
	public void setWrXx(Integer wrXx) {
		this.wrXx = wrXx;
	}
	public Integer getCz() {
		return cz;
	}
	public void setCz(Integer cz) {
		this.cz = cz;
	}
	public Integer getWrCz() {
		return wrCz;
	}
	public void setWrCz(Integer wrCz) {
		this.wrCz = wrCz;
	}
	public Integer getJx() {
		return jx;
	}
	public void setJx(Integer jx) {
		this.jx = jx;
	}
	public Integer getWrJx() {
		return wrJx;
	}
	public void setWrJx(Integer wrJx) {
		this.wrJx = wrJx;
	}
	public String getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}
	public void setCreateTime (Date createTime){
        this.createTime = createTime;
    }
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getCreateTime (){
        return this.createTime;
    }
    public void setUpdateTime (Date updateTime){
        this.updateTime = updateTime;
    }
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getUpdateTime (){
        return this.updateTime;
    }
    public void setDeleteTime (Date deleteTime){
        this.deleteTime = deleteTime;
    }
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getDeleteTime (){
        return this.deleteTime;
    }
    public void setDeleteStatus (String deleteStatus){
        this.deleteStatus = deleteStatus;
    }
    public String getDeleteStatus (){
        return this.deleteStatus;
    }
}
