
package com.cloud.icenter.yyzx.fzjc.education.dao;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.fzjc.education.pojo.SchoolInfo;
import com.cloud.icenter.yyzx.fzjc.education.pojo.SchoolQueryParam;

/**
* Created with gender.
* @author: whcai
* Date: 2017-07-04 17:37:40
*/
public interface SchoolInfoDao extends BaseDao<SchoolInfo> {

	/**
	 * 根据学校类型查询学校信息
	 * @param xxlx : 1幼儿园； 2小学； 3初中； 4高中 等
	 * @return
	 */
	public List<JSONObject> getSchoolByXxlx(SchoolQueryParam param);
	
	/**
	 * 获取学区信息
	 * @param name ： 学校名称
	 * @return
	 */
	public List<JSONObject> getXqInfoByName(String xxlx, String name, int nf);
	
	/**
	 * 获取历年(2010-2017)招生名额和适龄学童
	 * @return
	 */
	public Map<String, Object> getZsmeAndSlxt(String xxlx, String xzqdm);
	
	/**
     * 获取学校历年(2010-2017)招生名额和适龄学童
     * @param xxlx  学校类型
     * @param name  学校名称
     * @return
     */
	public Map<String, Object> getZsmeAndSlxtByName(String xxlx, String name);
}