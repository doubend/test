package  com.cloud.icenter.yyzx.dpzs.lz.service;

import com.cloud.icenter.base.service.BaseService;
import com.cloud.icenter.yyzx.dpzs.lz.pojo.WeatherToday;



/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-31 09:42:47
*/
public interface WeatherTodayService extends BaseService<WeatherToday> {

    WeatherToday getLastByArea(String area);
	
}