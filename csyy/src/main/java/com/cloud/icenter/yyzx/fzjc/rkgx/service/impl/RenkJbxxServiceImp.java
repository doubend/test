
package com.cloud.icenter.yyzx.fzjc.rkgx.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.common.utils.PagingUtil;
import com.cloud.icenter.yyzx.fzjc.rkgx.dao.RenkJbxxDao;
import com.cloud.icenter.yyzx.fzjc.rkgx.pojo.RenkJbxx;
import com.cloud.icenter.yyzx.fzjc.rkgx.pojo.SerchParam;
import com.cloud.icenter.yyzx.fzjc.rkgx.service.RenkJbxxService;
import com.cloud.icenter.system.logs.pojo.Logging;

/**
* Created with gender.
* @author: whcai
* Date: 2017-06-27 15:21:48
*/
@Logging
@Service
public class RenkJbxxServiceImp extends BaseServiceImpl<RenkJbxx>  implements RenkJbxxService{

	@Autowired private RenkJbxxDao rendJbxxDao;

	public Map<String, List<JSONObject>> getPopRelationBySfz(String sfz){
		return rendJbxxDao.getPopRelationBySfz(sfz);
	}
	
	public JSONObject getPopBasicInfoBySfz(String sfz){
		return rendJbxxDao.getPopBasicInfoBySfz(sfz);
	}
	
	public Map<String,Object> queryByCondition(SerchParam param, PagingUtil pagingUtil){
		return rendJbxxDao.queryByCondition(param, pagingUtil);	
	}

	@Override
	public JSONObject queryFristRow() {
		return rendJbxxDao.queryFristRow();
	}
}