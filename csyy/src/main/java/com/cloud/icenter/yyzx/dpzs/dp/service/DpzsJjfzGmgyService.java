package com.cloud.icenter.yyzx.dpzs.dp.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.cloud.icenter.base.service.BaseService;
import com.cloud.icenter.yyzx.dpzs.dp.dao.DpzsJjfzGmgyDao;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpzsJjfzGmgyPojo;

/** 
* @author zhucy 
* @version 2017年4月11日 下午1:42:29 
* 说明 
*/
public interface DpzsJjfzGmgyService extends BaseService<DpzsJjfzGmgyPojo>{
	
	public List<DpzsJjfzGmgyPojo> getDpzsJjfzGmgyList();
	
	/**
	 * 省内排名信息
	 * @return
	 */
	public List<Map<String, Object>> getSnpm();
}
