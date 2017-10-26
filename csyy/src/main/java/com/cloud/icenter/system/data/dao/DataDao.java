package com.cloud.icenter.system.data.dao;

import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.base.pojo.SysDict;

/**
 * 基础数据Dao接口
 * @author zhangle
 */
public interface DataDao extends BaseDao<SysDict> {
	
	/**
	 * 获取子数据
	 * @param parentId	父数据ID,当parentId==null时,返回顶级数据
	 * @param status	状态,当status==null时,返回所有状态的数据,状态值详见Data.STATUS_*属性
	 * @return
	 */
	public List<SysDict> getChildren(String parentId,Integer status);

	
	
	/**
	 * 根据父节点的code,获取子数据
	 * 返回状态为默认的子数据
	 * @param code
	 * @return
	 */
	public List<SysDict> getChildren(String code);
	
	/**
	 * 根据code获取数据
	 * @param code
	 * @return
	 */
	public SysDict getByCode(String code);
	
	/**
	 * 根据code和value获取数据
	 * @param code
	 * @param value
	 * @return
	 */
	public SysDict getByCode(String code,String value);
	
	/**
	 * 移动数据
	 * @param targetId		目标数据id
	 * @param sourceId		源数据id
	 * @param point			操作类型	取值范围: append,top,bottom
	 */
	public void move(String targetId,String sourceId,String point);
	
	/**
	 * 通过id来查询对象
	 * @param ids SysDict主键id
	 * @return
	 * @author zhaojianda
	 */
	public List<SysDict> getSysDictById(List<String> ids);
	
	/**
	 * 通过名字和类型查询对象
	 * @param text 数据名字
	 * @param type 数据类型
	 * @return
	 * @author zhaojianda
	 */
	public SysDict getByTextAndType(String text, int type);


	/**
	 * 
	* @Title: getAllDict 
	* @Description: 获取所有数据字典信息
	* @param @return    设定文件 
	* @return List<SysDict>    返回类型 
	* @throws
	 */
	public List<SysDict> getAllDict();
	
	
}
