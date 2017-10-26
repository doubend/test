package com.cloud.icenter.yyzx.fzjc.rk.service.impl;

import java.util.List;

import org.apache.cxf.annotations.Logging;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.common.utils.Pagination;
import com.cloud.icenter.yyzx.fzjc.rk.dao.MzzjDao;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Agestructure;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Distribution;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.MzzjAreaResult;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.MzzjResult;
import com.cloud.icenter.yyzx.fzjc.rk.service.MzzjService;

/**
 * 民族宗教 
 * @date 2017年9月27日
 * @author dxliug
 */
@Logging
@Service
public class MzzjServiceImpl extends BaseServiceImpl<MzzjResult> implements MzzjService{
    
	
	@Autowired
	private MzzjDao mzzjDao;
	
	@Override
	public List<MzzjResult> getRenkMzzj(String year) {
		return mzzjDao.getRenkMzzj(year);
	}
	@Override
	public List<MzzjAreaResult> getRenkMzzjArea(String year) {
		return mzzjDao.getRenkMzzjArea(year);
	}
	@Override
	public List<Agestructure> getRenkMzzjAge(String year) {
		return mzzjDao.getRenkMzzjAge(year);
	}

	
}
