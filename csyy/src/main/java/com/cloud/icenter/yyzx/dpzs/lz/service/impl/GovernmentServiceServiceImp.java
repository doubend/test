package  com.cloud.icenter.yyzx.dpzs.lz.service.impl;

import java.util.List;

import org.apache.cxf.annotations.Logging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.yyzx.common.query.Tourism;
import com.cloud.icenter.yyzx.dpzs.lz.dao.GovernmentServiceDao;
import com.cloud.icenter.yyzx.dpzs.lz.pojo.GovernmentService;
import com.cloud.icenter.yyzx.dpzs.lz.service.GovernmentServiceService;

/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-31 09:42:47
*/
@Logging
@Service
public class GovernmentServiceServiceImp extends BaseServiceImpl<GovernmentService>  implements GovernmentServiceService{
	@Autowired private GovernmentServiceDao governmentDao;
	public List<Tourism> getDayData(){
		return governmentDao.getDayData();
	}
	public List<Tourism> getMonthData(){
		return governmentDao.getMonthData();
	}
	public List<Tourism> getYearData(){
		return governmentDao.getYearData();
	}
}