package com.cloud.icenter.yyzx.cszc.zygl.dao;

import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.cszc.zygl.pojo.BjmbPojo;

/** 
* @author zhucy 
* @version 2017年3月24日 下午2:08:40 
* 资源分类>部件码表
*/
public interface BjmbDao extends BaseDao<BjmbPojo>{
	
	/**
	 * 获取子分类
	 * @param parentId	父分类ID,当parentId==null时,返回顶级分类
	 * @param status	删除状态
	 * @return
	 */
	public List<BjmbPojo> getChildren(String parentId,String status);
	
	
	/**
	 * 移动功能
	 * @param targetId		目标功能d
	 * @param sourceId		源功能id
	 * @param point			操作类型	取值范围: append,top,bottom
	 */
	public void move(String targetId,String sourceId,String point);
	
	/**
	 * 检查部件代码是否已经存在
	 * @param  dm
	 * */
	public boolean checkDm(String dm);
	
	/**
	 * 根据部件代码获取部件信息
	 * @param dm
	 * @return
	 */
	public BjmbPojo getBjmbPojoByDm(String dm);
	
}
