package  com.cloud.icenter.yyzx.dpzs.lz.service;

import java.util.List;

import com.cloud.icenter.base.service.BaseService;
import com.cloud.icenter.yyzx.common.query.Tourism;
import com.cloud.icenter.yyzx.dpzs.lz.pojo.GovernmentService;



/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-31 09:42:47
*/
public interface GovernmentServiceService extends BaseService<GovernmentService> {
	public List<Tourism> getDayData();
	public List<Tourism> getMonthData();
	public List<Tourism> getYearData();
}