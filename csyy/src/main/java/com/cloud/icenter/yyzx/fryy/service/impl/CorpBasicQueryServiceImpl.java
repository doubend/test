package com.cloud.icenter.yyzx.fryy.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.common.utils.PagingUtil;
import com.cloud.icenter.system.logs.pojo.Logging;
import com.cloud.icenter.yyzx.fryy.dao.CorpBasicQueryDao;
import com.cloud.icenter.yyzx.fryy.pojo.CorpBasicQuery;
import com.cloud.icenter.yyzx.fryy.pojo.CorpBasicQueryQM;
import com.cloud.icenter.yyzx.fryy.pojo.CorpCancelQueryQM;
import com.cloud.icenter.yyzx.fryy.pojo.CorpChangeQueryQM;
import com.cloud.icenter.yyzx.fryy.pojo.EmployeeQueryQM;
import com.cloud.icenter.yyzx.fryy.pojo.SocialSecurityQueryQM;
import com.cloud.icenter.yyzx.fryy.pojo.TaxQueryQM;
import com.cloud.icenter.yyzx.fryy.pojo.TaxRegistQueryQM;
import com.cloud.icenter.yyzx.fryy.service.CorpBasicQueryService;

/** 
* @author zhucy 
* @version 2017年5月4日 下午2:35:26 
* 说明 
*/
@Logging
@Service
public class CorpBasicQueryServiceImpl extends BaseServiceImpl<CorpBasicQuery> implements CorpBasicQueryService{
	@Autowired
	private CorpBasicQueryDao corpBasicQueryDao;
	@Override
	public Map<String, ?> getPageObjectBySql(CorpBasicQueryQM qm, PagingUtil pagingUtil) {
		// TODO Auto-generated method stub
		return this.corpBasicQueryDao.getPageObjectBySql(qm, pagingUtil);
	}
	@Override
	public Map<String, Object> findBaseByParam(CorpBasicQueryQM qm) {
		// TODO Auto-generated method stub
		return this.corpBasicQueryDao.findBaseByParam(qm);
	}
	@Override
	public List<Map<String, Object>> findBaseListByParam(SocialSecurityQueryQM qm) {
		// TODO Auto-generated method stub
		return this.corpBasicQueryDao.findBaseListByParam(qm);
	}
	@Override
	public List<Map<String, Object>> findBaseListByParam(TaxRegistQueryQM qm) {
		// TODO Auto-generated method stub
		return this.corpBasicQueryDao.findBaseListByParam(qm);
	}
	@Override
	public List<Map<String, Object>> findBaseListByParam(TaxQueryQM qm) {
		// TODO Auto-generated method stub
		return this.corpBasicQueryDao.findBaseListByParam(qm);
	}
	@Override
	public List<Map<String, Object>> findBaseListByParam(CorpCancelQueryQM qm) {
		// TODO Auto-generated method stub
		return this.corpBasicQueryDao.findBaseListByParam(qm);
	}
	@Override
	public List<Map<String, Object>> findBaseListByParam(CorpChangeQueryQM qm) {
		// TODO Auto-generated method stub
		return this.corpBasicQueryDao.findBaseListByParam(qm);
	}
	@Override
	public List<Map<String, Object>> findBaseListByParam(CorpBasicQueryQM qm) {
		// TODO Auto-generated method stub
		return this.corpBasicQueryDao.findBaseListByParam(qm);
	}
	@Override
	public Map<String, ?> getPageObjectBySql(EmployeeQueryQM qm, PagingUtil pagingUtil) {
		// TODO Auto-generated method stub
		return this.corpBasicQueryDao.getPageObjectBySql(qm, pagingUtil);
	}

}
