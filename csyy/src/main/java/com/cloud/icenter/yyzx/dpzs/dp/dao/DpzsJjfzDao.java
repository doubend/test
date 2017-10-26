package com.cloud.icenter.yyzx.dpzs.dp.dao;

import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpzsJjfzPojo;

/** 
* @author zhucy 
* @version 2017年3月28日 上午11:06:04 
* 大屏展示经济发展
*/
public interface DpzsJjfzDao extends BaseDao<DpzsJjfzPojo>{
	List<DpzsJjfzPojo> getList();
}
