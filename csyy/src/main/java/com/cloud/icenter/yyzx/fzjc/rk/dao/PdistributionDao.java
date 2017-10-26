package com.cloud.icenter.yyzx.fzjc.rk.dao;

import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Agestructure;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Distribution;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Newborn;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Scale;
/**
 * 人口分布
 * @author Administrator
 *
 */
public interface PdistributionDao extends BaseDao<Distribution>{
	
	public List<Distribution> getPdistributionByYear(String year);
	
	
	public List<Scale> getSixNumber();
	
	
	public List<Newborn> getNewBornList();
	
	
	public List<Agestructure> getAgestructureList();

}
