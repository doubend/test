package  com.cloud.icenter.yyzx.dpzs.lz.service;

import com.cloud.icenter.base.service.BaseService;
import com.cloud.icenter.yyzx.dpzs.lz.pojo.WeatherFuture;



/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-31 09:42:47
*/
public interface WeatherFutureService extends BaseService<WeatherFuture> {

    WeatherFuture getLastByArea(String area);
	
}