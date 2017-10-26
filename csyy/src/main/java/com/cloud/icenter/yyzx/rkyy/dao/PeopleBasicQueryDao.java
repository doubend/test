package com.cloud.icenter.yyzx.rkyy.dao;

import java.util.List;
import java.util.Map;

import com.cloud.icenter.base.service.BaseService;
import com.cloud.icenter.common.utils.PagingUtil;
import com.cloud.icenter.yyzx.rkyy.pojo.Dictionary;
import com.cloud.icenter.yyzx.rkyy.pojo.HunYinInfoQueryQM;
import com.cloud.icenter.yyzx.rkyy.pojo.JiaTingInfoQueryQM;
import com.cloud.icenter.yyzx.rkyy.pojo.PeopleBasicQuery;
import com.cloud.icenter.yyzx.rkyy.pojo.PeopleBasicQueryQM;
import com.cloud.icenter.yyzx.rkyy.pojo.SheBaoInfoQueryQM;

/** 
* @author zhucy 
* @version 2017年4月26日 上午10:05:35 
* 说明 
*/
public interface PeopleBasicQueryDao extends BaseService<PeopleBasicQuery>{
	/**
	 * 人口列表分页查询
	 * @param qm
	 * @param pagingUtil
	 * @return
	 */
	public Map<String, ?> getPageObjectBySql(PeopleBasicQueryQM qm, PagingUtil pagingUtil);
	
	/**
	 * 查询社保列表数据
	 */
	public Map<String, ?> getPageSbxxObjectBySql(PeopleBasicQueryQM qm, PagingUtil pagingUtil);
	
	/**
	 * 查询公积金列表数据
	 */
	public Map<String, ?> getPageGjjxxObjectBySql(PeopleBasicQueryQM qm, PagingUtil pagingUtil);
	
	/**
	 * 查询行政区划
	 * @return
	 */
	public List<Map<String, Object>> getAreaCombox();
	
	/**
	 * 根据身份证号获取个人基本信息
	 * @param sfz
	 * @return
	 */
	public Map<String, Object> findBaseBySfz(String sfz);
	
	/**
	 * 个人信息相关字典
	 * @return
	 */
	public List<Dictionary> getDictionary(Dictionary dqm);
	
	/**
	 * 家庭基本信息
	 * @return
	 */
	public Map<String, Object> getJtJbxx(JiaTingInfoQueryQM qm);
	
	/**
	 * 家庭关系
	 * @return
	 */
	public List<Map<String, Object>> getJtgx(JiaTingInfoQueryQM qm);
	
	/**
	 * 社保信息
	 * @return
	 */
	public List<Map<String, Object>> getSbxx(SheBaoInfoQueryQM qm);
	
	/**
	 * 婚姻情况
	 * @return
	 */
	public List<Map<String, Object>> getHyxx(HunYinInfoQueryQM qm);
	
	/**
	 * 公积金信息
	 * @return
	 */
	public List<Map<String, Object>> getGjjxx(PeopleBasicQueryQM qm);
	
	/**
	 * 家庭关系拓展图
	 * @param qm
	 * @return
	 */
	public List<Map<String, Object>> getJtgxtzt(JiaTingInfoQueryQM qm);

}
