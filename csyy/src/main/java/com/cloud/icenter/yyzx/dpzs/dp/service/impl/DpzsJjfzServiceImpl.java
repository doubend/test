package com.cloud.icenter.yyzx.dpzs.dp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.system.logs.pojo.Logging;
import com.cloud.icenter.yyzx.dpzs.dp.dao.DpzsJjfzDao;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpzsJjfzPojo;
import com.cloud.icenter.yyzx.dpzs.dp.service.DpzsJjfzService;

/** 
* @author zhucy 
* @version 2017年3月28日 上午11:12:49 
* 大屏展示经济发展
*/
@Logging
@Service
public class DpzsJjfzServiceImpl extends BaseServiceImpl<DpzsJjfzPojo> implements DpzsJjfzService{
	@Autowired
	private DpzsJjfzDao dpzsJjfzDao;
	@Override
	public List<DpzsJjfzPojo> getList() {
		// TODO Auto-generated method stub
		return this.dpzsJjfzDao.getList();
	}

}
