
package com.cloud.icenter.yyzx.fzjc.nync.service.impl;

import java.util.List;

import org.apache.cxf.annotations.Logging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.yyzx.fzjc.nync.dao.PlantingBasicDao;
import com.cloud.icenter.yyzx.fzjc.nync.pojo.PlantingBasic;
import com.cloud.icenter.yyzx.fzjc.nync.service.PlantingBasicService;
/**
* @author: yaoli
* Date: 2017-03-02 18:32:09
*/
@Logging
@Service
public class PlantingBasicServiceImp extends BaseServiceImpl<PlantingBasic>  implements PlantingBasicService{

	@Autowired
	private PlantingBasicDao plantBasicDao;
	public List<PlantingBasic> getCropsValues(){
		return plantBasicDao.getCropsValues();
	}
}