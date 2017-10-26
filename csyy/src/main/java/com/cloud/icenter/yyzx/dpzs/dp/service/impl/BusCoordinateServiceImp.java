
package com.cloud.icenter.yyzx.dpzs.dp.service.impl;
import org.apache.cxf.annotations.Logging;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.yyzx.dpzs.dp.dao.BusCoordinateDao;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.BusCoordinate;
import com.cloud.icenter.yyzx.dpzs.dp.service.BusCoordinateService;

/**
* Created with gender.
* @author: liyao
* Date: 2017-05-27 10:59:02
*/
@Logging
@Service
public class BusCoordinateServiceImp extends BaseServiceImpl<BusCoordinate>  implements BusCoordinateService{
	@Autowired private BusCoordinateDao busDao;
	public JSONObject getBusCoordinates(){
		return busDao.getBusCoordinates();
	}
	public JSONObject getTaxiCoordinates(){
		return busDao.getTaxiCoordinates();
	}
	public JSONObject getBusStations(String linename,String dir){
		return busDao.getBusStations(linename,dir);
	}
	public JSONObject getBusLines() {
		return busDao.getBusLines();		
	}
	public JSONObject queryBusByLine(String linename,String dir){
		return busDao.queryBusByLine(linename, dir);
	}
	public JSONObject lineStartEnd(){
		return busDao.lineStartEnd();
	}
}