package com.cloud.icenter.yyzx.fzjc.rk.dao;

import java.util.List;
import java.util.Map;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Eduincome;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Jobdistribution;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Migrant;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Migration;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Outflowsource;

/**
 * 人口流动
 * @author Administrator
 *
 */
public interface PmigrantDao extends BaseDao<Migrant>{
	
	
	public List<Migrant> getMigrantList();
	
	public List<Eduincome> getEduincomeList();
	
	public List<Jobdistribution> getJobdistributionByType(String type);
	
	public List<Outflowsource> getOutflowsourceListByYear(String year);
	
	public List<Migration> getMigrationList();
	
	public List<Migration> getDtsj(String type);
	/**
	 * 获取总流出人数和流入人数
	 * @return
	 */
	public List<Map<String, Object>> getLcAndLr();

}
