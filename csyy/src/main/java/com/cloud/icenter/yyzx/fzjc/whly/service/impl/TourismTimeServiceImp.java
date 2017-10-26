package com.cloud.icenter.yyzx.fzjc.whly.service.impl;

import java.util.List;

import org.apache.cxf.annotations.Logging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.yyzx.fzjc.whly.dao.HolidayTouristDao;
import com.cloud.icenter.yyzx.fzjc.whly.dao.TourismTimeDao;
import com.cloud.icenter.yyzx.fzjc.whly.pojo.HolidayTourist;
import com.cloud.icenter.yyzx.fzjc.whly.pojo.TourismTime;
import com.cloud.icenter.yyzx.fzjc.whly.service.TourismTimeService;

/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-16 14:38:07
*/
@Logging
@Service
public class TourismTimeServiceImp extends BaseServiceImpl<TourismTime>  implements TourismTimeService{
	@Autowired
	private TourismTimeDao timeDao;
	public List<TourismTime> getYkl(){
		return timeDao.getYkl();
	}
}