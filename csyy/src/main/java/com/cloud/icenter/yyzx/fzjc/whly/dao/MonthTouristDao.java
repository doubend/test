
package com.cloud.icenter.yyzx.fzjc.whly.dao;

import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.fzjc.whly.pojo.MonthTourist;
/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-16 14:38:45
*/
public interface MonthTouristDao extends BaseDao<MonthTourist> {
	public List<MonthTourist> getYkl();
}