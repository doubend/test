package com.cloud.icenter.yyzx.fzjc.nync.service;

import java.util.List;

import com.cloud.icenter.base.service.BaseService;
import com.cloud.icenter.yyzx.fzjc.nync.pojo.PlantingSpecies;
import com.cloud.icenter.yyzx.fzjc.nync.pojo.SpecialProduct;



/**
* Created with gender.
* @author: yaoli
* Date: 2017-06-20 11:48:22
*/
public interface PlantingSpeciesService extends BaseService<PlantingSpecies> {
	public List<PlantingSpecies> getAreaClByName(String qy);
	public List<PlantingSpecies> getAreaByName(String qy);
	public List<PlantingSpecies> getFruitByName(String qy);
}