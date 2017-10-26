package com.cloud.icenter.yyzx.fzjc.nync.service.impl;

import java.util.List;

import org.apache.cxf.annotations.Logging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.yyzx.fzjc.nync.dao.PlantingSpeciesDao;
import com.cloud.icenter.yyzx.fzjc.nync.pojo.PlantingSpecies;
import com.cloud.icenter.yyzx.fzjc.nync.service.PlantingSpeciesService;

/**
* Created with gender.
* @author: yaoli
* Date: 2017-06-20 11:48:22
*/
@Logging
@Service
public class PlantingSpeciesServiceImp extends BaseServiceImpl<PlantingSpecies>  implements PlantingSpeciesService{
	@Autowired private PlantingSpeciesDao speciesDao;
	public List<PlantingSpecies> getAreaClByName(String qy){
		return speciesDao.getAreaClByName(qy);
	}
	public List<PlantingSpecies> getAreaByName(String qy){
		return speciesDao.getAreaByName(qy);
	}
	public List<PlantingSpecies> getFruitByName(String qy){
		return speciesDao.getFruitByName(qy);
	}
}