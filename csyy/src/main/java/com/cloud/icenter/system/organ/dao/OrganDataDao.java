package com.cloud.icenter.system.organ.dao;

import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.system.organ.pojo.OrganData;

public interface OrganDataDao extends BaseDao<OrganData>{
	
	/**
	 * 根据组织机构编号获取组织机构数据
	 * @return
	 */
	public List<OrganData> getDataByOrganId(String organId);
	
	/**
	 * 批量更新组织机构数据
	 * @return
	 */
	public void add(String organId,OrganData[] organDatas);

}
