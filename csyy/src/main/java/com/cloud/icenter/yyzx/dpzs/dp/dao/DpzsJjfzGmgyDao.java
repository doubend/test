package com.cloud.icenter.yyzx.dpzs.dp.dao;

import java.util.List;
import java.util.Map;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpzsJjfzGmgyPojo;

/** 
* @author zhucy 
* @version 2017年4月11日 下午1:40:55 
* 说明 
*/
public interface DpzsJjfzGmgyDao extends BaseDao<DpzsJjfzGmgyPojo>{
	public List<DpzsJjfzGmgyPojo> getDpzsJjfzGmgyList();
	
	/**
	 * 省内排名信息
	 * @return
	 */
	public List<Map<String, Object>> getSnpm();
}
