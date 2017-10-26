package com.cloud.icenter.yyzx.cszc.tjfx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.system.logs.pojo.Logging;
import com.cloud.icenter.yyzx.cszc.tjfx.dao.EducationDao;
import com.cloud.icenter.yyzx.cszc.tjfx.pojo.WhcdNCPojo;
import com.cloud.icenter.yyzx.cszc.tjfx.pojo.WhcdPojo;
import com.cloud.icenter.yyzx.cszc.tjfx.service.EducationService;
/**
 * 教育分析--文化程度分析
 * @date 2017年10月11日
 * @author dxliug
 */
@Logging
@Service
public class EducationServiceImpl extends BaseServiceImpl<WhcdPojo> implements EducationService {
 
	
	 @Autowired
	 private EducationDao educationDao;
	
	@Override
	public List<WhcdPojo> getWhcdResult(String year,String areas) {
		return educationDao.getWhcdResult(year,areas);
	}

	@Override
	public List<WhcdPojo> getWhcdArea(String year, String areas) {
		return educationDao.getWhcdArea(year,areas);
	}

	@Override
	public List<WhcdPojo> getWhcdZB(String year, String areas) {
		return educationDao.getWhcdZB(year,areas);
	}

	@Override
	public List<WhcdNCPojo> getWhcdNC(String year, String areas) {
		return educationDao.getWhcdNC(year,areas);
	}

	
}
