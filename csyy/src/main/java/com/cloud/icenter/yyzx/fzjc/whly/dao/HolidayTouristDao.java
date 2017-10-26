
package com.cloud.icenter.yyzx.fzjc.whly.dao;

import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.fzjc.whly.pojo.HolidayTourist;
/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-16 14:40:00
*/
public interface HolidayTouristDao extends BaseDao<HolidayTourist> {
	public List<HolidayTourist> getYkl();
}