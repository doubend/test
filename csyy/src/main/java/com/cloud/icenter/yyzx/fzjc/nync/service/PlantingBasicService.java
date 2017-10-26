
package com.cloud.icenter.yyzx.fzjc.nync.service;

import java.util.List;

import com.cloud.icenter.base.service.BaseService;
import com.cloud.icenter.yyzx.fzjc.nync.pojo.PlantingBasic;

/**
* @author: yaoli
* Date: 2017-03-02 18:32:09
*/
public interface PlantingBasicService extends BaseService<PlantingBasic> {
	
	public List<PlantingBasic> getCropsValues();
}