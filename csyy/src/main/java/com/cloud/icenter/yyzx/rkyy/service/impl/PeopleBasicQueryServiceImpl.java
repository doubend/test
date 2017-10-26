package com.cloud.icenter.yyzx.rkyy.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.common.utils.PagingUtil;
import com.cloud.icenter.system.logs.pojo.Logging;
import com.cloud.icenter.yyzx.rkyy.dao.PeopleBasicQueryDao;
import com.cloud.icenter.yyzx.rkyy.pojo.Dictionary;
import com.cloud.icenter.yyzx.rkyy.pojo.HunYinInfoQueryQM;
import com.cloud.icenter.yyzx.rkyy.pojo.JiaTingInfoQueryQM;
import com.cloud.icenter.yyzx.rkyy.pojo.PeopleBasicQuery;
import com.cloud.icenter.yyzx.rkyy.pojo.PeopleBasicQueryQM;
import com.cloud.icenter.yyzx.rkyy.pojo.SheBaoInfoQueryQM;
import com.cloud.icenter.yyzx.rkyy.service.PeopleBasicQueryService;

/** 
* @author zhucy 
* @version 2017年4月26日 上午10:09:23 
* 说明 
*/
@Logging
@Service
public class PeopleBasicQueryServiceImpl extends BaseServiceImpl<PeopleBasicQuery> implements PeopleBasicQueryService{

	@Autowired
	private PeopleBasicQueryDao peopleBasicQueryDao;
	
	@Override
	public Map<String, ?> getPageObjectBySql(PeopleBasicQueryQM qm, PagingUtil pagingUtil) {
		// TODO Auto-generated method stub
		return this.peopleBasicQueryDao.getPageObjectBySql(qm, pagingUtil);
	}

	@Override
	public List<Map<String, Object>> getAreaCombox() {
		// TODO Auto-generated method stub
		return this.peopleBasicQueryDao.getAreaCombox();
	}

	@Override
	public Map<String, Object> findBaseBySfz(String sfz) {
		// TODO Auto-generated method stub
		return this.peopleBasicQueryDao.findBaseBySfz(sfz);
	}

	@Override
	public List<Dictionary> getDictionary(Dictionary dqm) {
		// TODO Auto-generated method stub
		return this.peopleBasicQueryDao.getDictionary(dqm);
	}

	@Override
	public Map<String, Object> getJtJbxx(JiaTingInfoQueryQM qm) {
		// TODO Auto-generated method stub
		return this.peopleBasicQueryDao.getJtJbxx(qm);
	}

	@Override
	public List<Map<String, Object>> getJtgx(JiaTingInfoQueryQM qm) {
		// TODO Auto-generated method stub
		return this.peopleBasicQueryDao.getJtgx(qm);
	}

	@Override
	public List<Map<String, Object>> getSbxx(SheBaoInfoQueryQM qm) {
		// TODO Auto-generated method stub
		return this.peopleBasicQueryDao.getSbxx(qm);
	}

	@Override
	public List<Map<String, Object>> getHyxx(HunYinInfoQueryQM qm) {
		// TODO Auto-generated method stub
		return this.peopleBasicQueryDao.getHyxx(qm);
	}

	@Override
	public List<Map<String, Object>> getGjjxx(PeopleBasicQueryQM qm) {
		// TODO Auto-generated method stub
		return this.peopleBasicQueryDao.getGjjxx(qm);
	}

	@Override
	public List<Map<String, Object>> getJtgxtzt(JiaTingInfoQueryQM qm) {
		// TODO Auto-generated method stub
		return this.peopleBasicQueryDao.getJtgxtzt(qm);
	}

	@Override
	public Map<String, ?> getPageSbxxObjectBySql(PeopleBasicQueryQM qm, PagingUtil pagingUtil) {
		// TODO Auto-generated method stub
		return this.peopleBasicQueryDao.getPageSbxxObjectBySql(qm, pagingUtil);
	}

	@Override
	public Map<String, ?> getPageGjjxxObjectBySql(PeopleBasicQueryQM qm, PagingUtil pagingUtil) {
		// TODO Auto-generated method stub
		return this.peopleBasicQueryDao.getPageGjjxxObjectBySql(qm, pagingUtil);
	}
	

}
