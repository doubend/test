package com.cloud.icenter.yyzx.cszc.tjfx.service;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.cloud.icenter.yyzx.cszc.security.pojo.QueryPojo;



/**   
 * @author hujianyang
 * @date 2017年4月10日 下午2:44:32  
 * @version 版本号码   
  
 * @TODO 就业信息service
 */ 
public interface EmploymentInfoService {
	
	/**
	 * 
	 * TODO 根据年份查询所有区域的就业人口数
	 * @param sql 查询的sql语句
	 * @param pojo 查询条件的封装类
	 * @return 返回查询的结果集
	 */
	public List<Map<String , String>> getEmploymentByYear(String sql , QueryPojo pojo);
	
	/**
	 * 
	 * TODO 根据年份查询所有区域的三大产业就业人口数以及总的就业人数(为了计算占比)
	 * @param sql 查询的sql语句
	 * @param pojo 查询条件的封装类
	 * @return 返回查询的结果集
	 */
	public List<Map<String , String>> queryThreeIndustryByYear(String sql, QueryPojo pojo);
	
	/**
	 * 
	 * TODO 根据年份查询所所有区域     下岗再就业,离退休再就业,农村劳动力转岗三种类型的就业人数
	 * @param sql 查询的sql语句
	 * @param pojo 查询条件的封装类
	 * @return 返回查询的结果集
	 */
	public List<Map<String , String>> queryOnceEmployment(String sql , QueryPojo pojo);
	
	/**
	 * 
	 * TODO 查询返回一产,二产,三产的各个文化程度的人数,以及一产,二产,三产的参保人数
	 * @param sql 查询的sql语句
	 * @param pojo 查询条件的封装类
	 * @return 返回查询的结果集
	 */
	public List<Map<String , String>> queryEdudegree(String sql ,QueryPojo pojo);
	
	public List<JSONObject> getListPram(String sql, Object obj);
}
