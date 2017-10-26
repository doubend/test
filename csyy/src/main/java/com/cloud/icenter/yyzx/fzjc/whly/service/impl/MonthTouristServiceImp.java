package com.cloud.icenter.yyzx.fzjc.whly.service.impl;

import java.util.List;

import org.apache.cxf.annotations.Logging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.yyzx.fzjc.whly.dao.HolidayTouristDao;
import com.cloud.icenter.yyzx.fzjc.whly.dao.MonthTouristDao;
import com.cloud.icenter.yyzx.fzjc.whly.pojo.HolidayTourist;
import com.cloud.icenter.yyzx.fzjc.whly.pojo.MonthTourist;
import com.cloud.icenter.yyzx.fzjc.whly.service.MonthTouristService;

/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-16 14:38:45
*/
@Logging
@Service
public class MonthTouristServiceImp extends BaseServiceImpl<MonthTourist>  implements MonthTouristService{
	@Autowired
	private MonthTouristDao monthDao;
	public List<MonthTourist> getYkl(){
		return monthDao.getYkl();
	}
}