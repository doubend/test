package com.cloud.icenter.yyzx.fzjc.whly.service.impl;

import java.util.List;

import org.apache.cxf.annotations.Logging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.yyzx.fzjc.whly.dao.HolidayTouristDao;
import com.cloud.icenter.yyzx.fzjc.whly.dao.TicketWayDao;
import com.cloud.icenter.yyzx.fzjc.whly.pojo.HolidayTourist;
import com.cloud.icenter.yyzx.fzjc.whly.pojo.TicketWay;
import com.cloud.icenter.yyzx.fzjc.whly.service.TicketWayService;

/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-16 14:39:29
*/
@Logging
@Service
public class TicketWayServiceImp extends BaseServiceImpl<TicketWay>  implements TicketWayService{
	@Autowired
	private TicketWayDao ticketwayDao;
	public List<TicketWay> getYkl(){
		return ticketwayDao.getYkl();
	}
}