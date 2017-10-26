package  com.cloud.icenter.yyzx.dpzs.lz.service;

import java.util.List;

import com.cloud.icenter.base.service.BaseService;
import com.cloud.icenter.yyzx.common.query.Tourism;
import com.cloud.icenter.yyzx.dpzs.lz.pojo.TicketNow;


/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-31 09:43:47
*/
public interface TicketNowService extends BaseService<Tourism> {
	public List<Tourism> getHourTicket();
}