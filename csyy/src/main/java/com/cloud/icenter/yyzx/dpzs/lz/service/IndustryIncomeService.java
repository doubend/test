package  com.cloud.icenter.yyzx.dpzs.lz.service;

import java.util.List;

import com.cloud.icenter.base.service.BaseService;
import com.cloud.icenter.yyzx.common.query.Industry;
import com.cloud.icenter.yyzx.dpzs.lz.pojo.IndustryIncome;



/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-31 09:45:23
*/
public interface IndustryIncomeService extends BaseService<Industry> {
	public List<Industry> getIndustryIncome();
}