package  com.cloud.icenter.yyzx.dpzs.lz.service.impl;

import java.util.List;

import org.apache.cxf.annotations.Logging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.yyzx.common.query.Tourism;
import com.cloud.icenter.yyzx.dpzs.lz.dao.SourceDayDao;
import com.cloud.icenter.yyzx.dpzs.lz.pojo.SourceDay;
import com.cloud.icenter.yyzx.dpzs.lz.service.SourceDayService;

/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-31 09:44:46
*/
@Logging
@Service
public class SourceDayServiceImp extends BaseServiceImpl<SourceDay>  implements SourceDayService{
	@Autowired private SourceDayDao dayDao;
	public List<Tourism> getDaySource(){
		return dayDao.getDaySource();
	}
	
}