package com.cloud.icenter.yyzx.dpzs.dp.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.cxf.annotations.Logging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.yyzx.dpzs.dp.dao.DpzsJjfzGmgyDao;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpzsJjfzGmgyPojo;
import com.cloud.icenter.yyzx.dpzs.dp.service.DpzsJjfzGmgyService;

/** 
* @author zhucy 
* @version 2017年4月11日 下午1:42:59 
* 说明 
*/
@Logging
@Service
public class DpzsJjfzGmgyServiceImpl extends BaseServiceImpl<DpzsJjfzGmgyPojo> implements DpzsJjfzGmgyService{

	@Autowired
	private DpzsJjfzGmgyDao dpzsJjfzGmgyDao;
	
	@Override
	public List<DpzsJjfzGmgyPojo> getDpzsJjfzGmgyList() {
		return dpzsJjfzGmgyDao.getDpzsJjfzGmgyList();
	}

	@Override
	public List<Map<String, Object>> getSnpm() {
		// TODO Auto-generated method stub
		return dpzsJjfzGmgyDao.getSnpm();
	}

}
