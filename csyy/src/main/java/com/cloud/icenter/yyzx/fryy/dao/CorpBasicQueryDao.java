package com.cloud.icenter.yyzx.fryy.dao;

import java.util.List;
import java.util.Map;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.common.utils.PagingUtil;
import com.cloud.icenter.yyzx.fryy.pojo.CorpBasicQuery;
import com.cloud.icenter.yyzx.fryy.pojo.CorpBasicQueryQM;
import com.cloud.icenter.yyzx.fryy.pojo.CorpCancelQueryQM;
import com.cloud.icenter.yyzx.fryy.pojo.CorpChangeQueryQM;
import com.cloud.icenter.yyzx.fryy.pojo.EmployeeQueryQM;
import com.cloud.icenter.yyzx.fryy.pojo.SocialSecurityQueryQM;
import com.cloud.icenter.yyzx.fryy.pojo.TaxQueryQM;
import com.cloud.icenter.yyzx.fryy.pojo.TaxRegistQueryQM;

/** 
* @author zhucy 
* @version 2017年5月4日 下午2:35:48 
* 说明 
*/
public interface CorpBasicQueryDao extends BaseDao<CorpBasicQuery>{
	
	/**
	 * 查询法人数据
	 */
	public Map<String, ?> getPageObjectBySql(CorpBasicQueryQM qm, PagingUtil pagingUtil);
	
	/**
	 * 法人基本信息查询
	 * @return
	 */
	public Map<String, Object> findBaseByParam(CorpBasicQueryQM qm);
	
	/**
	 * 社保基本信息查询
	 * @return
	 */
	public List<Map<String, Object>> findBaseListByParam(SocialSecurityQueryQM qm);
	
	/**
	 * 税务基本信息查询
	 * @return
	 */
	public List<Map<String, Object>> findBaseListByParam(TaxRegistQueryQM qm);
	
	/**
	 * 税收
	 * @return
	 */
	public List<Map<String, Object>> findBaseListByParam(TaxQueryQM qm);
	
	/**
	 * 法人注销登记页面
	 * @return
	 */
	public List<Map<String, Object>> findBaseListByParam(CorpCancelQueryQM qm);
	
	/**
	 * 法人登记变更页面
	 * @return
	 */
	public List<Map<String, Object>> findBaseListByParam(CorpChangeQueryQM qm);
	
	/**
	 * 企业公积金最后缴存月份
	 * @return
	 */
	public List<Map<String, Object>> findBaseListByParam(CorpBasicQueryQM qm);
	
	/**
	 * 查询法人员工
	 */
	public Map<String, ?> getPageObjectBySql(EmployeeQueryQM qm, PagingUtil pagingUtil);

}
