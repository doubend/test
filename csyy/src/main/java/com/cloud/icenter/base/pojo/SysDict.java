package com.cloud.icenter.base.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="T_DMP_SYS_DICT")
public class SysDict extends Pojo {
	
	private static final long serialVersionUID = 1L;

	public static final int TYPE_DIRECTORY=1;		//类型:目录
	public static final int TYPE_LEAF=2;			//类型:叶子
	 
	public static final int STATUS_DEFAULT=0;		//状态:默认
	public static final int STATUS_DISABLE=1;		//状态:禁用
	 
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "DICT_ID", unique = true, nullable = false, length = 32)
	private String dictId;

	@Column(name = "CODE", length = 256)
	private String code;
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_AT", length = 7)
	private Date createdAt;

	@Column(name = "CREATOR_ID", length = 32)
	private String creatorId;

	@Column(name = "PARENT_ID", length = 32)
	private String parentId;

	@Column(name = "DISCRIPTION")
	private String discription;

	@Column(name = "SEQ_NUM", precision = 20, scale = 0)
	private long seqNum;

	@Column(name = "STATUS", precision = 11, scale = 0)
	private Integer status;

	@Column(name = "TEXT", length = 100)
	private String text;

	@Column(name = "TYPE", precision = 11, scale = 0)
	private Integer type;

	@Column(name = "VALUE", length = 100)
	private String value;

	@Column(name = "PATH", length = 512)
	private String path;  //父节点路径
	
	@Transient
	private String total; //查询该字典数据对应的信息资源的数量,记录在该字典当中
	
	public SysDict(){
	    
	}
	
	public SysDict(String code,String parentId,Integer status,String text,Integer type,String value,String path){
        this.code = code;
        this.parentId = parentId;
        this.status = status;
        this.text = text;
        this.type = type;
        this.value = value;
        this.path = path;
    }
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	// Property accessors
	public String getDictId() {
		return this.dictId;
	}

	public void setDictId(String dictId) {
		this.dictId = dictId;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getCreatorId() {
		return this.creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	public String getParentId() {
		return this.parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getDiscription() {
		return this.discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public long getSeqNum() {
		return this.seqNum;
	}

	public void setSeqNum(long seqNum) {
		this.seqNum = seqNum;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

}