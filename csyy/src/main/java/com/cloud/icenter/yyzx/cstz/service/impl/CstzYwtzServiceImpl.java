package com.cloud.icenter.yyzx.cstz.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.common.utils.Pagination;
import com.cloud.icenter.common.utils.PagingUtil;
import com.cloud.icenter.system.logs.pojo.Logging;
import com.cloud.icenter.yyzx.cstz.dao.CstzYwtzDao;
import com.cloud.icenter.yyzx.cstz.pojo.CstzYwtzPojo;
import com.cloud.icenter.yyzx.cstz.service.CstzYwtzService;

/** 
* @author zhucy 
* @version 2017年4月5日 下午6:17:29 
* 说明 
*/
@Logging
@Service
public class CstzYwtzServiceImpl extends BaseServiceImpl<CstzYwtzPojo> implements CstzYwtzService{

	@Autowired
	private CstzYwtzDao cstzYwtzDao;
	
	@Override
	public List<CstzYwtzPojo> getListByYwzbId(String ywzbId) {
		return this.cstzYwtzDao.getListByYwzbId(ywzbId);
	}

	@Override
	public Map<String, ?> getYwtzList(PagingUtil pagingUtil, String signId, String ywzbmc) {
		return this.cstzYwtzDao.getYwtzList(pagingUtil, signId, ywzbmc);
	}

	@Override
	public CstzYwtzPojo getCstzYwtzPojoByYwzbId(String ywzbId) {
		return this.cstzYwtzDao.getCstzYwtzPojoByYwzbId(ywzbId);
	}

}
