
package com.cloud.icenter.yyzx.fzjc.education.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.yyzx.fzjc.education.dao.SchoolInfoDao;
import com.cloud.icenter.yyzx.fzjc.education.pojo.SchoolInfo;
import com.cloud.icenter.yyzx.fzjc.education.service.SchoolInfoService;
import com.cloud.icenter.yyzx.fzjc.education.pojo.SchoolQueryParam;
import com.cloud.icenter.system.logs.pojo.Logging;

/**
* Created with gender.
* @author: whcai
* Date: 2017-07-04 17:37:40
*/
@Logging
@Service
public class SchoolInfoServiceImp extends BaseServiceImpl<SchoolInfo>  implements SchoolInfoService{

	@Autowired private SchoolInfoDao schoolDao;
	
	public List<JSONObject> getSchoolByXxlx(SchoolQueryParam param){
		return schoolDao.getSchoolByXxlx(param);
	}
	
	public List<JSONObject> getXqInfoByName(String xxlx, String name, int nf){
		return schoolDao.getXqInfoByName(xxlx, name, nf);
	}
	
	public Map<String, Object> getZsmeAndSlxt(String xxlx, String xzqdm){
		return schoolDao.getZsmeAndSlxt(xxlx, xzqdm);
	}
	
	public Map<String, Object> getZsmeAndSlxtByName(String xxlx, String name){
		return schoolDao.getZsmeAndSlxtByName(xxlx, name);
	}
}