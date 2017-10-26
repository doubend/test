package com.cloud.icenter.yyzx.cszc.tjfx.service;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.cloud.icenter.yyzx.cszc.security.pojo.QueryPojo;

/**
 * 教育情况serivce
 * @date 2017年3月30日
 * @author dxliug
 */
public interface EducationInfoService {
	/**
	 * 获取单条记录
	 */
	public Map<String, Object> getSingle(String sql);
	
	/**
	 * 获取多条记录
	 */
	public List<Map<String, Object>> getList(String sql);
	
	/**
	 * 获取多条记录(带参数)
	 */
	public List<JSONObject> getListPram(String sql,Object obj);
     /**
      * 获取多条记录(带参数)
      * @param pojo
      * @param string
      * @return
      */
	public List<Map<String,Object>> findBaseListBySfz(QueryPojo pojo);
	
	public List<Map<String,Object>> queryTeacherOffice(QueryPojo pojo, String string);

}
