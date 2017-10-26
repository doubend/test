package com.cloud.icenter.yyzx.fzjc.nync.dao;

import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.fzjc.nync.pojo.PlantingDistribution;

/**
* @author: yaoli
* Date: 2017-03-02 18:03:47
*/
public interface PlantingDistributionDao extends BaseDao<PlantingDistribution> {
	public List<PlantingDistribution> getDistribution();
}