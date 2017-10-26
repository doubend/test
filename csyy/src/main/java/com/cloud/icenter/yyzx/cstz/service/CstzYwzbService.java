package com.cloud.icenter.yyzx.cstz.service;

import com.cloud.icenter.base.service.BaseService;
import com.cloud.icenter.yyzx.cstz.pojo.CstzYwzbPojo;

/** 
* @author zhucy 
* @version 2017年4月5日 下午2:44:12 
* 说明 
*/
public interface CstzYwzbService extends BaseService<CstzYwzbPojo>{

	/**
	 * 指标计算(由业务指标值转换成体征指数)
	 */
	public void zbCal();
	
	public void zbCalDs();
	
	public void initData();
}
