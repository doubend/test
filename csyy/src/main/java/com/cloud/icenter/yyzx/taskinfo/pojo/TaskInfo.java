
package com.cloud.icenter.yyzx.taskinfo.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cloud.icenter.base.pojo.Pojo;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
* 城市体征——业务指标数据
* @author: whcai
* Date: 2017-03-20 15:54:44
*/
@Entity
@Table(name = "t_task_info")
public class TaskInfo  extends Pojo {
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false, length = 32)
    private  String id;  
    
	/**
     * 任务名称
     */
	@Column(name = "name", length = 50)
    private String name;
	/**
	 * 调度计划运行规则
	 */
	@Column(name = "cron", length = 50)
	private String cron;

    /**
     * 调度计划运行规则备注，例：30秒执行一次
     */
    @Column(name = "remarks", length = 255)
    private String remarks;

    /**
     * 调度计划实际使用的任务实例id<br>
     * 即spring中的注册名，默认调度其execute(String json)来执行任务
     */
    @Column(name = "task_bean_id", length = 50)
    private String taskBeanId;
    /**
     * 执行任务时使用的参数
     */
    @Column(name = "json", length = 2000)
    private String json;
    
    /**
     * 启用状态
     * 0：禁用，1启用
     */
    @Column(name = "STATUS", length = 2)
    private String status;
    
	/**
	 * 创建时间
	 */
	@Column(name = "create_time", length = 19)
    private  java.sql.Timestamp createTime;  
    
	/**
	 * 更新时间
	 */
	@Column(name = "update_time", length = 19)
    private  java.sql.Timestamp updateTime;  
    
	/**
	 * 删除时间
	 */
	@Column(name = "delete_time", length = 19)
    private  java.sql.Timestamp deleteTime;  
    
	/**
	 * 删除状态：0正常，1删除
	 */
	@Column(name = "delete_status", length = 1)
    private  String deleteStatus;  
    
	/**
	 * 创建者
	 */
	@Column(name = "creator", length = 32)
    private  String creator;  
    

    public void setId (String id){
        this.id = id;
    }
    public String getId (){
        return this.id;
    }
  
    public void setCreateTime (java.sql.Timestamp createTime){
        this.createTime = createTime;
    }
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public java.sql.Timestamp getCreateTime (){
        return this.createTime;
    }
    public void setUpdateTime (java.sql.Timestamp updateTime){
        this.updateTime = updateTime;
    }
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public java.sql.Timestamp getUpdateTime (){
        return this.updateTime;
    }
    public void setDeleteTime (java.sql.Timestamp deleteTime){
        this.deleteTime = deleteTime;
    }
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public java.sql.Timestamp getDeleteTime (){
        return this.deleteTime;
    }
    public void setDeleteStatus (String deleteStatus){
        this.deleteStatus = deleteStatus;
    }
    public String getDeleteStatus (){
        return this.deleteStatus;
    }
    public void setCreator (String creator){
        this.creator = creator;
    }
    public String getCreator (){
        return this.creator;
    }
    public String getCron() {
        return cron;
    }
    public void setCron(String cron) {
        this.cron = cron;
    }
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public String getTaskBeanId() {
        return taskBeanId;
    }
    public void setTaskBeanId(String taskBeanId) {
        this.taskBeanId = taskBeanId;
    }
    public String getJson() {
        return json;
    }
    public void setJson(String json) {
        this.json = json;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    
    
}