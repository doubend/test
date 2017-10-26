package com.cloud.icenter.system.code.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.common.constants.Constants;
import com.cloud.icenter.system.code.dao.ResourceCodeDao;
import com.cloud.icenter.system.code.pojo.ResourceCode;

@Repository
public class ResourceCodeDaoImpl extends BaseDaoImpl<ResourceCode> implements ResourceCodeDao {

	@Override
	public void startCode(String id) {
		//更新所有为停用状态
		String sql = "update t_dmp_sys_code t set t.IS_USE = '"+Constants.DATA_STATUS_INVALID+"'";
		createSQLQuery(sql).executeUpdate();
		
		//更新当前ID为：启用状态
		String sqlStart = "update t_dmp_sys_code t set t.IS_USE = '"+Constants.DATA_STATUS_VALID+"' where t.id='"+id+"'"; 
		createSQLQuery(sqlStart).executeUpdate();
	}

	@Override
	public boolean checkStatus(String id) {
		String hql = "select t from ResourceCode t where t.id=?";
		List<ResourceCode> list = executeQuery(hql, id);
		if (list != null && !list.isEmpty()) {
			ResourceCode code = list.get(0);
			if (code != null ) {
				if (String.valueOf(Constants.DATA_STATUS_INVALID).equals(code.getIsUse())) {
					return true;
				} else {
					return false;
				}
			}
			return false;
		} else {
			return false;
		}
	}

	@Override
	public ResourceCode getUsed() {
		String hql = "select t from ResourceCode t where t.isUse=?";
		List<ResourceCode> list = executeQuery(hql, String.valueOf(Constants.DATA_STATUS_VALID));
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public String getCurrentCode(String organId) {
		String sql = "select t.RESOURCE_NUM from irsp_resources_info t where t.ORGAN_ID='"+organId+"' order by t.CREATE_TIME desc";
		List<String> list = createSQLQuery(sql).list();
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

}
