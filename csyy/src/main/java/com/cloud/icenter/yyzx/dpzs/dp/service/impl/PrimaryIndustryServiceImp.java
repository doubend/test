package com.cloud.icenter.yyzx.dpzs.dp.service.impl;

import java.util.List;

import org.apache.cxf.annotations.Logging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.yyzx.dpzs.dp.dao.PrimaryIndustryDao;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.PrimaryIndustry;
import com.cloud.icenter.yyzx.dpzs.dp.service.PrimaryIndustryService;

/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-31 09:41:24
*/
@Logging
@Service
public class PrimaryIndustryServiceImp extends BaseServiceImpl<PrimaryIndustry>  implements PrimaryIndustryService{
	@Autowired private PrimaryIndustryDao primaryDao;
	public List<PrimaryIndustry> getPrimaryIndustry(){
		return primaryDao.getPrimaryIndustry();
	}
}