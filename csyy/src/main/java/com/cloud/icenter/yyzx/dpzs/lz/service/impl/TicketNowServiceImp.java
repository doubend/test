package  com.cloud.icenter.yyzx.dpzs.lz.service.impl;

import java.util.List;

import org.apache.cxf.annotations.Logging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.yyzx.common.query.Tourism;
import com.cloud.icenter.yyzx.dpzs.lz.dao.TicketNowDao;
import com.cloud.icenter.yyzx.dpzs.lz.dao.impl.TicketNowDaoImpl;
import com.cloud.icenter.yyzx.dpzs.lz.pojo.TicketNow;
import com.cloud.icenter.yyzx.dpzs.lz.service.TicketNowService;

/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-31 09:43:47
*/
@Logging
@Service
public class TicketNowServiceImp extends BaseServiceImpl<Tourism>  implements TicketNowService{

	@Autowired private TicketNowDao hourDao;
	public List<Tourism> getHourTicket(){
		return hourDao.getHourTicket();
	}
}