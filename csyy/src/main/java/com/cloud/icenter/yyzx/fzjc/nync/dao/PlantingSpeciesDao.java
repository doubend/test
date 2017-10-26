package com.cloud.icenter.yyzx.fzjc.nync.dao;

import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.fzjc.nync.pojo.PlantingSpecies;
/**
* Created with gender.
* @author: yaoli
* Date: 2017-06-20 11:48:22
*/
public interface PlantingSpeciesDao extends BaseDao<PlantingSpecies> {

	public List<PlantingSpecies> getAreaClByName(String qy);
	public List<PlantingSpecies> getAreaByName(String qy);
	public List<PlantingSpecies> getFruitByName(String qy);
}