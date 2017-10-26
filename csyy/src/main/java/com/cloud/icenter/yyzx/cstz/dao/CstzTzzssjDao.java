package com.cloud.icenter.yyzx.cstz.dao;

import java.util.Map;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.common.utils.PagingUtil;
import com.cloud.icenter.yyzx.cstz.pojo.CstzTzzssjPojo;

/** 
* @author zhucy 
* @version 2017年4月17日 下午2:11:21 
* 城市体征>体征指数数据表
*/
public interface CstzTzzssjDao extends BaseDao<CstzTzzssjPojo>{
	/**
	 * 查询体征指数数据
	 * @param ywzbmc
	 * @param pagingUtil
	 * @return
	 */
	Map<String, ?> getPageObjectBySql(String ywzbmc, PagingUtil pagingUtil);
	/**
	 * 逐级计算体征指数
	 */
	void upCal();
	
	void calThree();
	
	void calTwo();
	
	void calOne();
}
