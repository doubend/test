package com.cloud.icenter.system.onlineuser.utils;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.cloud.icenter.base.controller.BaseAction;
import com.cloud.icenter.common.constants.Constants;
import com.cloud.icenter.system.onlineuser.pojo.OnlineUser;
import com.cloud.icenter.system.organ.pojo.Organ;
import com.cloud.icenter.system.role.pojo.Role;

/**
 * 登录人信息获取
 * @author menglit
 *
 */
public class OnlineUtils {
	/**
	 * 获取登录人信息
	 * @return
	 */
	public static OnlineUser getLoginUser(){
		HttpServletRequest request = (HttpServletRequest)BaseAction.getDataThreadLocal().get().get("request");
		return (OnlineUser)request.getSession().getAttribute(Constants.LOGIN_USER_SESSION_KEY);
	}
	/**
	 * 获取登录人所在组织
	 * @return
	 */
	public static Organ getUserOrgan(){
		OnlineUser user = getLoginUser();
		return user.getDepartment();
	}
	/**
	 * 获取登录人姓名
	 * @return
	 */
	public static String getUserName(){
		return getLoginUser().getNickname();
	}
	
	/**
	 * 获取登录人ID
	 * @return
	 */
	public static String getUserId(){
		return getLoginUser().getUserId();
	}
	
	/**
	 * 获取登录人所在部门的名称
	 * @return
	 */
	public static String getLoginUserOrganName(){
		Organ organ = getUserOrgan();
		if(organ != null){
			return organ.getName();
		}
		return null;
	}
	
	/**
	 * 获取用户的角色
	 * @return
	 */
	public static List<Role> getUserRoles(){
		OnlineUser onlin =  getLoginUser();
		return onlin.getRoles();
	}
	
	/**
	 * 获取用户的角色id集合
	 * @return
	 */
	public static List<String> getUserRoleIds(){
		List<String> roleIds = new ArrayList<String>();
		List<Role> roles =  getLoginUser().getRoles();
		for(Role role:roles){
			roleIds.add(role.getRoleId());
		}
		return roleIds;
	}
	
	/**
	 * 获取登录人部门ID
	 * @return
	 */
	public static String getUserOrganId(){
		return getUserOrgan().getOrgId();
	}
}
