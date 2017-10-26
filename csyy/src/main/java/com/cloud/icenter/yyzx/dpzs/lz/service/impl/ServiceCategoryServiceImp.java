package  com.cloud.icenter.yyzx.dpzs.lz.service.impl;

import java.util.List;

import org.apache.cxf.annotations.Logging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.yyzx.common.query.Tourism;
import com.cloud.icenter.yyzx.dpzs.lz.dao.ServiceCategoryDao;
import com.cloud.icenter.yyzx.dpzs.lz.pojo.ServiceCategory;
import com.cloud.icenter.yyzx.dpzs.lz.service.ServiceCategoryService;

/**
* Created with gender.
* @author: yaoli
* Date: 2017-04-01 11:36:04
*/
@Logging
@Service
public class ServiceCategoryServiceImp extends BaseServiceImpl<ServiceCategory>  implements ServiceCategoryService{
    @Autowired private ServiceCategoryDao cateDao;
	public List<Tourism> getEventCount(){
		return cateDao.getEventCount();
	}
	public List<Tourism> getOnlineCount(){
		return cateDao.getOnlineCount();
	}
	public List<Tourism> getBureauOverview(String ssdw){
		return cateDao.getBureauOverview(ssdw);
	}
	public List<ServiceCategory> getEventList(String ssdw){
		return cateDao.getEventList(ssdw);
	}
	public JSONObject getAllData(){
		return cateDao.getAllData();
	}
}