package com.cloud.icenter.yyzx.cstz.dao;

import java.util.List;
import java.util.Map;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.common.utils.Pagination;
import com.cloud.icenter.common.utils.PagingUtil;
import com.cloud.icenter.yyzx.cstz.pojo.CstzYwtzPojo;

/** 
* @author zhucy 
* @version 2017年4月5日 下午6:12:54 
* 说明 
*/
public interface CstzYwtzDao extends BaseDao<CstzYwtzPojo>{
	
	/**
	 * 根据业务指标id查询关联业务体征
	 * @param ywzb_id
	 * @return
	 */
	List<CstzYwtzPojo> getListByYwzbId(String ywzbId);
	
	/**
	 * 查询体征信息列表
	 * @param pagin 分页信息
	 * @param signId 体征编码
	 * @param ywzbmc 指标名称
	 */
	Map<String, ?> getYwtzList(PagingUtil pagingUtil , String signId , String ywzbmc);
    
    CstzYwtzPojo getCstzYwtzPojoByYwzbId(String ywzbId);
}
