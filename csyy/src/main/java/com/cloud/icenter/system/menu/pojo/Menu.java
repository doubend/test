package com.cloud.icenter.system.menu.pojo;

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

import com.cloud.icenter.base.pojo.Pojo;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 菜单实体类
 * @author zhangle
 */
@Entity
@Table(name = "T_DMP_SYS_MENU")
public class Menu extends Pojo {

	public static final int TYPE_DIRECTORY = 1; // 类型:目录
	public static final int TYPE_LEAF = 2; // 类型:叶子

	public static final int EXPAND_FALSE = 0; // 是否展开:否
	public static final int EXPAND_TRUE = 1; // 是否展开:是

	public static final int STATUS_DEFAULT = 0; // 状态:默认
	public static final int STATUS_DISABLE = 1; // 状态:禁用

	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "MENU_ID", unique = true, nullable = false, length = 32)
	private String menuId;
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_AT", length = 7)
	private Date createdAt;

	@Column(name = "CREATOR_ID", length = 32)
	private String creatorId;

	@Column(name = "EXPAND", precision = 11, scale = 0)
	private Integer expand;

	@Column(name = "ICON", length = 50)
	private String icon;

	@Column(name = "ICON_OPEN", length = 50)
	private String iconOpen;

	@Column(name = "NAME", length = 32)
	private String name;

	@Column(name = "PARENT_ID", length = 32)
	private String parentId;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "SEQ_NUM", precision = 20, scale = 0)
	private Integer seqNum;

	@Column(name = "STATUS", precision = 11, scale = 0)
	private Integer status;

	@Column(name = "TARGET", length = 16)
	private String target;

	@Column(name = "TOOLTIPS", length = 32)
	private String tooltips;

	@Column(name = "TYPE", precision = 11, scale = 0)
	private Integer type;

	@Column(name = "URL", length = 100)
	private String url;
	
	@Column(name = "PATH", length = 512)
	private String path;  //父节点路径
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	// Property accessors
	public String getMenuId() {
		return this.menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getCreatorId() {
		return this.creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	public Integer getExpand() {
		return this.expand;
	}

	public void setExpand(Integer expand) {
		this.expand = expand;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getIconOpen() {
		return this.iconOpen;
	}

	public void setIconOpen(String iconOpen) {
		this.iconOpen = iconOpen;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentId() {
		return this.parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getSeqNum() {
		return this.seqNum;
	}

	public void setSeqNum(Integer seqNum) {
		this.seqNum = seqNum;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTarget() {
		return this.target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getTooltips() {
		return this.tooltips;
	}

	public void setTooltips(String tooltips) {
		this.tooltips = tooltips;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	@Transient
	private String[] checkedFunctionId; // 修改角色时,选中的功能ID

	@Transient
	private String[] uncheckdFunctionId; // 修改角色时,未选中的功能ID
	
	public String[] getCheckedFunctionId() {
		return checkedFunctionId;
	}

	public void setCheckedFunctionId(String[] checkedFunctionId) {
		this.checkedFunctionId = checkedFunctionId;
	}

	public String[] getUncheckdFunctionId() {
		return uncheckdFunctionId;
	}

	public void setUncheckdFunctionId(String[] uncheckdFunctionId) {
		this.uncheckdFunctionId = uncheckdFunctionId;
	}
}