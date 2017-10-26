package com.cloud.icenter.yyzx.cstz.service;

import java.util.Map;

import com.cloud.icenter.base.service.BaseService;
import com.cloud.icenter.common.utils.PagingUtil;
import com.cloud.icenter.yyzx.cstz.pojo.CstzTzzssjPojo;

/** 
* @author zhucy 
* @version 2017年4月18日 上午11:03:14 
* 说明 
*/
public interface CstzTzzssjService extends BaseService<CstzTzzssjPojo>{
	
	Map<String,?> getPageObjectBySql(String ywzbmc,PagingUtil pagingUtil);
	
	/**
	 * 逐级计算体征指数
	 */
	void upCal();
	
	void calThree();
	
	void calTwo();
	
	void calOne();
}
