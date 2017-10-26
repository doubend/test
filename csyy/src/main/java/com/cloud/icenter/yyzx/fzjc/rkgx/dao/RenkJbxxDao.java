
package com.cloud.icenter.yyzx.fzjc.rkgx.dao;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.common.utils.PagingUtil;
import com.cloud.icenter.yyzx.fzjc.rkgx.pojo.RenkJbxx;
import com.cloud.icenter.yyzx.fzjc.rkgx.pojo.SerchParam;

/**
* Created with gender.
* @author: whcai
* Date: 2017-06-27 15:21:48
*/
public interface RenkJbxxDao extends BaseDao<RenkJbxx> {

	/**
	 * 查询人口关系
	 * @param sfz
	 * @return
	 */
	public Map<String, List<JSONObject>> getPopRelationBySfz(String sfz);
	
	/**
	 * 查询个人基本信息
	 * @return
	 */
	public JSONObject getPopBasicInfoBySfz(String sfz);
	
	/**
	 * 查询人口信息
	 * @param param
	 * @return
	 */
	public Map<String,Object> queryByCondition(SerchParam param, PagingUtil pagingUtil);
        /**
         * 查询第一条信息
         * @return
         */
	public JSONObject queryFristRow();
}