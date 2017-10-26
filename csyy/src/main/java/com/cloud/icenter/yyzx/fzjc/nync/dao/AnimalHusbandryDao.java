
package com.cloud.icenter.yyzx.fzjc.nync.dao;


import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.common.query.AnimalClCl;
import com.cloud.icenter.yyzx.fzjc.nync.pojo.AnimalHusbandry;

/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-08 15:37:25
*/
public interface AnimalHusbandryDao extends BaseDao<AnimalHusbandry> {
	public List<AnimalHusbandry> getCurrentSum();
	public List<AnimalHusbandry> getHistoryStock(int lb);
	public List<AnimalClCl> getHistoryList();
	public List<AnimalClCl> getCurrentList();
	public List<BigDecimal> getDpzbList();
}
