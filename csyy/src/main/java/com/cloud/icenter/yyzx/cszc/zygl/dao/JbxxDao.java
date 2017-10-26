package com.cloud.icenter.yyzx.cszc.zygl.dao;

import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.cszc.zygl.pojo.JbxxPojo;

/** 
* @author zhucy 
* @version 2017年3月21日 下午2:36:13 
* 城市资源基本信息
*/
public interface JbxxDao extends BaseDao<JbxxPojo>{
	
	/**
	 * 通过资源所属分类查询资源记录
	 * @param fenlei
	 * @return
	 */
	List<JbxxPojo> getListByFenlei(String fenlei);

}
