package com.cloud.icenter.system.function.service;

import java.util.List;

import com.cloud.icenter.base.service.BaseService;
import com.cloud.icenter.system.function.pojo.Function;

/**
 * 功能服务接口
 * @author zhangle
 */
public interface FunctionService extends BaseService<Function>{
	
	/**
	 * 获取子功能
	 * @param parentId	父功能ID,当parentId==null时,返回顶级功能
	 * @param status	状态,当status==null时,返回所有状态的功能,状态值详见Function.STATUS_*属性
	 * @return
	 */
	public List<Function> getChildren(String parentId,Integer status);

	/**
	 * 获取角色关联的子功能
	 * @param roleId		角色ID
	 * @param parentId		父功能ID,当parentId==null时,返回顶级功能
	 * @param status		状态,当status==null时,返回所有状态的功能,状态值详见Function.STATUS_*属性
	 * @return
	 */
	public List<Function> getChildrenForRole(String roleId,String parentId,Integer status);
	
	/**
	 * 获取菜单关联的子功能
	 * @param menuId		菜单ID
	 * @param parentId		父功能ID,当parentId==null时,返回顶级功能
	 * @param status		状态,当status==null时,返回所有状态的功能,状态值详见Function.STATUS_*属性
	 * @return
	 * add by YHT
	 */
	public List<Function> getChildrenForMenu(String menuId,String parentId,Integer status);
	
	/**
	 * 获取组织机构关联的子功能
	 * @param organId		组织机构ID
	 * @param parentId		父功能ID,当parentId==null时,返回顶级功能
	 * @param status		状态,当status==null时,返回所有状态的功能,状态值详见Function.STATUS_*属性
	 * @return
	 */
	public List<Function> getChildrenForOrgan(String organId,String parentId,Integer status);
	
	/**
	 * 移动功能
	 * @param targetId		目标功能d
	 * @param sourceId		源功能id
	 * @param point			操作类型	取值范围: append,top,bottom
	 */
	public void move(String targetId,String sourceId,String point);
	
	/**
	 * 检查code是否已经存在
	 * @param code 菜单code
	 * @author yuhaitao
	 * */
	public boolean checkCode(String code);
}
