
package com.cloud.icenter.yyzx.fzjc.nync.service;

import java.util.List;

import com.cloud.icenter.base.service.BaseService;
import com.cloud.icenter.yyzx.fzjc.nync.pojo.PlantingDistribution;



/**
* @author: yaoli
* Date: 2017-03-02 18:03:47
*/
public interface PlantingDistributionService extends BaseService<PlantingDistribution> {
	public List<PlantingDistribution> getDistribution();
}