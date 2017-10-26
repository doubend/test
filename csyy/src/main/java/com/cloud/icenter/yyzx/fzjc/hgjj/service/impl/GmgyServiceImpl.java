package com.cloud.icenter.yyzx.fzjc.hgjj.service.impl;

import java.util.List;

import org.apache.cxf.annotations.Logging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.yyzx.fzjc.hgjj.dao.GmgyDao;
import com.cloud.icenter.yyzx.fzjc.hgjj.pojo.GmgyCzgc;
import com.cloud.icenter.yyzx.fzjc.hgjj.pojo.GmgyLnsh;
import com.cloud.icenter.yyzx.fzjc.hgjj.pojo.GmgyTop;
import com.cloud.icenter.yyzx.fzjc.hgjj.service.GmgyService;

@Logging
@Service
public class GmgyServiceImpl  extends BaseServiceImpl<GmgyLnsh> implements GmgyService {
	
	@Autowired
	private GmgyDao gmgyDao;

	@Override
	public List<GmgyLnsh> getGmgyLnshList() {
		return gmgyDao.getGmgyLnshList();
	}

	@Override
	public List<GmgyTop> getGmgyTopList() {
		return gmgyDao.getGmgyTopList();
	}

	@Override
	public List<GmgyCzgc> getGmgyCzgcList() {
		return gmgyDao.getGmgyCzgcList();
	}

}
