package com.cloud.icenter.yyzx.fzjc.whly.service.impl;

import java.util.List;

import org.apache.cxf.annotations.Logging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.yyzx.fzjc.whly.dao.HolidayTouristDao;
import com.cloud.icenter.yyzx.fzjc.whly.pojo.HolidayTourist;
import com.cloud.icenter.yyzx.fzjc.whly.service.HolidayTouristService;

/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-16 14:40:00
*/
@Logging
@Service
public class HolidayTouristServiceImp extends BaseServiceImpl<HolidayTourist>  implements HolidayTouristService{
	@Autowired
	private HolidayTouristDao holidayDao;
	public List<HolidayTourist> getYkl(){
		return holidayDao.getYkl();
	}
}