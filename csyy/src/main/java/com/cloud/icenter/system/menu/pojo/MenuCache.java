package com.cloud.icenter.system.menu.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.cloud.icenter.base.pojo.Pojo;

/**
 * 菜单缓存实体类
 * @author zhangle
 */
@Entity
@Table(name = "T_DMP_SYS_MENU_CACHE")
public class MenuCache extends Pojo {

	public static final String TYPE_ROLE = "role"; // 类型:角色与菜单的缓存
	public static final String TYPE_ORGAN = "organ"; // 类型:组织机构与菜单的缓存

	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "MENU_CACHE_ID", unique = true, nullable = false, length = 32)
	private String menuCacheId;

	@Column(name = "DATA_ID", length = 32)
	private String dataId;

	@Column(name = "MENU_ID", length = 32)
	private String menuId;

	@Column(name = "TYPE", length = 16)
	private String type;

	// Property accessors
	public String getMenuCacheId() {
		return this.menuCacheId;
	}

	public void setMenuCacheId(String menuCacheId) {
		this.menuCacheId = menuCacheId;
	}

	public String getDataId() {
		return this.dataId;
	}

	public void setDataId(String dataId) {
		this.dataId = dataId;
	}

	public String getMenuId() {
		return this.menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
}