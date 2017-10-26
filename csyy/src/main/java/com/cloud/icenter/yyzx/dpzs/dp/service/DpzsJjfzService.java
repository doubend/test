package com.cloud.icenter.yyzx.dpzs.dp.service;

import java.util.List;

import com.cloud.icenter.base.service.BaseService;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpzsJjfzPojo;

/** 
* @author zhucy 
* @version 2017年3月28日 上午11:11:43 
* 大屏展示经济发展
*/
public interface DpzsJjfzService extends BaseService<DpzsJjfzPojo>{
	List<DpzsJjfzPojo> getList();
}
