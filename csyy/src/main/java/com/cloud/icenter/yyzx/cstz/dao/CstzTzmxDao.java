package com.cloud.icenter.yyzx.cstz.dao;

import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.cstz.pojo.CstzTzmxPojo;

/** 
* @author zhucy 
* @version 2017年4月12日 上午9:21:10 
* 说明 
*/
public interface CstzTzmxDao extends BaseDao<CstzTzmxPojo>{
	/**
	 * 获取子分类
	 * @param parentId	父分类ID,当parentId==null时,返回顶级分类
	 * @param status	删除状态
	 * @return
	 */
	public List<CstzTzmxPojo> getChildren(String parentId,String status);
	
	
	/**
	 * 移动功能
	 * @param targetId		目标功能d
	 * @param sourceId		源功能id
	 * @param point			操作类型	取值范围: append,top,bottom
	 */
	public void move(String targetId,String sourceId,String point);
	
	/**
	 * 检查体征模型是否已经存在
	 * @param  tzmc
	 * */
	public boolean checkTzmc(String tzmc);
	
	/**
	 * 根据模型id获取模型信息
	 * @param id
	 * @return
	 */
	public CstzTzmxPojo getCstzTzmxPojoById(String id);
	
	/**
	 * 检查关联的业务体征是否已经被关联使用
	 * @param ywtzId
	 * @return
	 */
	public boolean checkYwtzId(String ywtzId);
	
	/**
	 * 获取最大排序值
	 * @return
	 */
	public int getMaxXssx();
}
