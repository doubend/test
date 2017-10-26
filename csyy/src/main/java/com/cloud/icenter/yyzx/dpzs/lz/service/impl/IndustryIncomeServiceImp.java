package  com.cloud.icenter.yyzx.dpzs.lz.service.impl;

import java.util.List;

import org.apache.cxf.annotations.Logging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.yyzx.common.query.Industry;
import com.cloud.icenter.yyzx.dpzs.lz.dao.IndustryIncomeDao;
import com.cloud.icenter.yyzx.dpzs.lz.pojo.IndustryIncome;
import com.cloud.icenter.yyzx.dpzs.lz.service.IndustryIncomeService;
/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-31 09:45:23
*/
@Logging
@Service
public class IndustryIncomeServiceImp extends BaseServiceImpl<Industry>  implements IndustryIncomeService{
	@Autowired private IndustryIncomeDao industryIncomeDao;
	public List<Industry> getIndustryIncome(){
		return industryIncomeDao.getIndustryIncome();
	}
}