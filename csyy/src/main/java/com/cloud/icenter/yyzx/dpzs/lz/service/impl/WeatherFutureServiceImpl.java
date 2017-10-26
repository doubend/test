package  com.cloud.icenter.yyzx.dpzs.lz.service.impl;

import org.apache.cxf.annotations.Logging;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.yyzx.dpzs.lz.dao.WeatherFutureDao;
import com.cloud.icenter.yyzx.dpzs.lz.pojo.WeatherFuture;
import com.cloud.icenter.yyzx.dpzs.lz.service.WeatherFutureService;

/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-31 09:42:47
*/
@Logging
@Service
public class WeatherFutureServiceImpl extends BaseServiceImpl<WeatherFuture>  implements WeatherFutureService{
	@Autowired 
	private WeatherFutureDao weatherFutureDao;

    @Override
    public WeatherFuture getLastByArea(String area) {
        return weatherFutureDao.getLastByArea(area);
    }
	
}