package com.cloud.icenter.base.pojo;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="T_DMP_SYS_DICT")
public class TreeNode {

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
	
	//@Column(name = "PARENT_ID", length = 32)
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)  
    @JoinColumn(name = "PARENT_ID")  
	private TreeNode parent;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "parent", fetch = FetchType.EAGER)
	private Set<TreeNode> children = new LinkedHashSet<TreeNode>();  

	public Set<TreeNode> getChildren() {
		return children;
	}

	public void setChildren(Set<TreeNode> children) {
		this.children = children;
	}

	@Column(name = "STATUS", precision = 11, scale = 0)
	private Integer status;

	@Column(name = "TEXT", length = 100)
	private String text;

	@Column(name = "TYPE", precision = 11, scale = 0)
	private Integer type;
	
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

	public TreeNode getParentId() {
		return this.parent;
	}

	public void setParentId(TreeNode parent) {
		this.parent = parent;
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

}
