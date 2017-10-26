package  com.cloud.icenter.yyzx.dpzs.lz.service.impl;

import org.apache.cxf.annotations.Logging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.yyzx.dpzs.lz.dao.WeatherTodayDao;
import com.cloud.icenter.yyzx.dpzs.lz.pojo.WeatherToday;
import com.cloud.icenter.yyzx.dpzs.lz.service.WeatherTodayService;

/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-31 09:42:47
*/
@Logging
@Service
public class WeatherTodayServiceImpl extends BaseServiceImpl<WeatherToday>  implements WeatherTodayService{
	@Autowired 
	private WeatherTodayDao weatherTodayDao;

    @Override
    public WeatherToday getLastByArea(String area) {
        return weatherTodayDao.getLastByArea(area);
    }
	
}