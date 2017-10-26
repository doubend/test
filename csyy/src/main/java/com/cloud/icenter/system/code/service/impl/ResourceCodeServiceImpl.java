package com.cloud.icenter.system.code.service.impl;

import org.apache.cxf.annotations.Logging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.system.code.dao.ResourceCodeDao;
import com.cloud.icenter.system.code.pojo.ResourceCode;
import com.cloud.icenter.system.code.service.ResourceCodeService;

@Service
@Logging
public class ResourceCodeServiceImpl extends BaseServiceImpl<ResourceCode> implements ResourceCodeService {

	@Autowired
	private ResourceCodeDao resourceCodeDao;

	@Override
	public void startCode(String id) {
		resourceCodeDao.startCode(id);
	}

	@Override
	public boolean checkStatus(String id) {
		return resourceCodeDao.checkStatus(id);
	}

	@Override
	public ResourceCode getUsed() {
		return resourceCodeDao.getUsed();
	}

	@Override
	public String getCurrentCode(String organId) {
		return resourceCodeDao.getCurrentCode(organId);
	}
}
