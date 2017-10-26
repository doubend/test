
package com.cloud.icenter.yyzx.fzjc.nync.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.cxf.annotations.Logging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.yyzx.common.query.AnimalClCl;
import com.cloud.icenter.yyzx.fzjc.nync.dao.AnimalHusbandryDao;
import com.cloud.icenter.yyzx.fzjc.nync.dao.PlantingBasicDao;
import com.cloud.icenter.yyzx.fzjc.nync.pojo.AnimalHusbandry;
import com.cloud.icenter.yyzx.fzjc.nync.service.AnimalHusbandryService;

/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-08 15:37:25
*/
@Logging
@Service
public class AnimalHusbandryServiceImp extends BaseServiceImpl<AnimalHusbandry>  implements AnimalHusbandryService{
	@Autowired
	private AnimalHusbandryDao animalHusbandaryDao;
	public List<AnimalHusbandry> getCurrentSum(){		
		return animalHusbandaryDao.getCurrentSum();
	}
	public List<AnimalHusbandry> getHistoryStock(int lb){
		return animalHusbandaryDao.getHistoryStock(lb);
	}
	public List<AnimalClCl> getHistoryList(){
		return animalHusbandaryDao.getHistoryList();
	}
	public List<AnimalClCl> getCurrentList(){
		return animalHusbandaryDao.getCurrentList();				
	}
	public List<BigDecimal> getDpzbList(){
		return animalHusbandaryDao.getDpzbList();
	}
}