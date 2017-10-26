package com.cloud.icenter.system.menu.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.cloud.icenter.base.pojo.Pojo;
/**
 * 菜单与功能关联表
 * 
 * @author YHT
 */
@Entity
@Table(name = "T_DMP_SYS_MENU_FUNCTION")
public class MenuFunction  extends Pojo {
	
	//private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "ID", unique = true, nullable = false, length = 32)
	private String id;

	@Column(name = "MENU_ID", length = 32)
	private String menuId;

	@Column(name = "FUNCTION_ID", length = 32)
	private String functionId;

	// Property accessors
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMenuId() {
		return this.menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getFunctionId() {
		return this.functionId;
	}

	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}

}
