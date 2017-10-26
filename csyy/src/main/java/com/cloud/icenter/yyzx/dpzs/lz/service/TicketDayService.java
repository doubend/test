package  com.cloud.icenter.yyzx.dpzs.lz.service;

import java.util.List;

import com.cloud.icenter.base.service.BaseService;
import com.cloud.icenter.yyzx.common.query.Tourism;
import com.cloud.icenter.yyzx.dpzs.lz.pojo.TicketDay;

/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-31 09:43:34
*/
public interface TicketDayService extends BaseService<TicketDay> {
	public List<Tourism> getDayTicket();
	public List<Tourism> getYearTicket();
	public List<Tourism> getOneYearTicket(int year);
}