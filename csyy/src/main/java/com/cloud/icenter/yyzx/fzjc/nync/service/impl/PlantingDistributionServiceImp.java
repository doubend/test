
package com.cloud.icenter.yyzx.fzjc.nync.service.impl;

import java.util.List;

import org.apache.cxf.annotations.Logging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.yyzx.fzjc.nync.dao.PlantingDistributionDao;
import com.cloud.icenter.yyzx.fzjc.nync.pojo.PlantingDistribution;
import com.cloud.icenter.yyzx.fzjc.nync.service.PlantingDistributionService;
/**
* @author: yaoli
* Date: 2017-03-02 18:03:47
*/
@Logging
@Service
public class PlantingDistributionServiceImp extends BaseServiceImpl<PlantingDistribution>  implements PlantingDistributionService{
	@Autowired
	private PlantingDistributionDao distributionDao;
	public List<PlantingDistribution> getDistribution(){
		return distributionDao.getDistribution();
	}
}