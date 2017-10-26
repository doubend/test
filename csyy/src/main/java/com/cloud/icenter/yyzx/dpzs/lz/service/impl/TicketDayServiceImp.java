package  com.cloud.icenter.yyzx.dpzs.lz.service.impl;

import java.util.List;

import org.apache.cxf.annotations.Logging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.yyzx.common.query.Tourism;
import com.cloud.icenter.yyzx.dpzs.lz.dao.TicketDayDao;
import com.cloud.icenter.yyzx.dpzs.lz.dao.TicketNowDao;
import com.cloud.icenter.yyzx.dpzs.lz.dao.impl.TicketNowDaoImpl;
import com.cloud.icenter.yyzx.dpzs.lz.pojo.TicketDay;
import com.cloud.icenter.yyzx.dpzs.lz.service.TicketDayService;

/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-31 09:43:34
*/
@Logging
@Service
public class TicketDayServiceImp extends BaseServiceImpl<TicketDay>  implements TicketDayService{

	@Autowired private TicketDayDao nowDao;
	public List<Tourism> getDayTicket(){
		return nowDao.getDayTicket();
	}
	public List<Tourism> getYearTicket(){
		return nowDao.getYearTicket();
	}
	public List<Tourism> getOneYearTicket(int year){
		return nowDao.getOneYearTicket(year);
	}
}