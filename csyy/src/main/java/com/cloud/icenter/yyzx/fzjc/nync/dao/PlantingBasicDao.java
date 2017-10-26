
package com.cloud.icenter.yyzx.fzjc.nync.dao;

import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.fzjc.nync.pojo.PlantingBasic;

/**
* @author: yaoli
* Date: 2017-03-02 18:32:09
*/
public interface PlantingBasicDao extends BaseDao<PlantingBasic> {
	public List<PlantingBasic> getCropsValues();
}