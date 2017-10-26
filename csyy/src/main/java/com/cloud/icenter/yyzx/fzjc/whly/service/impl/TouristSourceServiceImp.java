package com.cloud.icenter.yyzx.fzjc.whly.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.cxf.annotations.Logging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.yyzx.fzjc.whly.dao.TouristSourceDao;
import com.cloud.icenter.yyzx.fzjc.whly.pojo.TouristSource;
import com.cloud.icenter.yyzx.fzjc.whly.service.TouristSourceService;

/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-14 15:34:32
*/
@Logging
@Service
public class TouristSourceServiceImp extends BaseServiceImpl<TouristSource>  implements TouristSourceService{
@Autowired
private TouristSourceDao dao;
public List<Map<String,Object>> getAll(){
	return dao.getAll();
}
public List<TouristSource> getZykl(){
	return dao.getZykl();
}
}