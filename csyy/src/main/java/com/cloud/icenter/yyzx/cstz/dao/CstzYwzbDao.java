package com.cloud.icenter.yyzx.cstz.dao;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.cstz.pojo.CstzYwzbPojo;

/** 
* @author zhucy 
* @version 2017年4月5日 下午2:37:52 
* 说明 
*/
public interface CstzYwzbDao extends BaseDao<CstzYwzbPojo>{
	/**
	 * 指标计算(由业务指标值转换成体征指数)
	 */
	public void zbCal();
	public void initData();
	public void zbCalDs();
}
