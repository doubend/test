package com.cloud.icenter.yyzx.fzjc.whly.service.impl;

import java.util.List;

import org.apache.cxf.annotations.Logging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.yyzx.fzjc.whly.dao.TransportationDao;
import com.cloud.icenter.yyzx.fzjc.whly.pojo.Transportation;
import com.cloud.icenter.yyzx.fzjc.whly.service.TransportationService;

/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-15 10:42:49
*/
@Logging
@Service
public class TransportationServiceImp extends BaseServiceImpl<Transportation>  implements TransportationService{
	@Autowired
	private TransportationDao transDao;
	public List<Transportation> getTrans(){
		return transDao.getTrans();
	}
}