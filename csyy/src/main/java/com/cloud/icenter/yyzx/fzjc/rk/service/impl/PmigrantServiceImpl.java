package com.cloud.icenter.yyzx.fzjc.rk.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.cxf.annotations.Logging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.yyzx.fzjc.rk.dao.PmigrantDao;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Eduincome;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Jobdistribution;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Migrant;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Migration;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Outflowsource;
import com.cloud.icenter.yyzx.fzjc.rk.service.PmigrantService;

/**
 * 全市流动人口变化
 * @author Administrator
 *
 */
@Logging
@Service
public class PmigrantServiceImpl extends BaseServiceImpl<Migrant>  implements PmigrantService{
	
	@Autowired
	private PmigrantDao pmigrantDao;

	@Override
	public List<Migrant> getMigrantList() {
		return pmigrantDao.getMigrantList();
	}

	@Override
	public List<Eduincome> getEduincomeList() {
		return pmigrantDao.getEduincomeList();
	}

	@Override
	public List<Jobdistribution> getJobdistributionByType(String type) {
		return pmigrantDao.getJobdistributionByType(type);
	}

	@Override
	public List<Outflowsource> getOutflowsourceListByYear(String year) {
		return pmigrantDao.getOutflowsourceListByYear(year);
	}

	@Override
	public List<Migration> getMigrationList() {
		return pmigrantDao.getMigrationList();
	}

	@Override
	public List<Migration> getDtsj(String type) {
		return pmigrantDao.getDtsj(type);
	}

	@Override
	public List<Map<String, Object>> getLcAndLr() {
		// TODO Auto-generated method stub
		return pmigrantDao.getLcAndLr();
	}

}
