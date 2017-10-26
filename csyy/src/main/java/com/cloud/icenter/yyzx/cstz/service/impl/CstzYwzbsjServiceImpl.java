package com.cloud.icenter.yyzx.cstz.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.common.utils.Pagination;
import com.cloud.icenter.system.logs.pojo.Logging;
import com.cloud.icenter.yyzx.cstz.pojo.CstzYwzbsjPojo;
import com.cloud.icenter.yyzx.cstz.service.CstzYwzbsjService;

/** 
 * @author zhucy 
 * @version 2017年6月14日 上午10:40:17 
 * 说明 
 */
@Logging
@Service
public class CstzYwzbsjServiceImpl extends BaseServiceImpl<CstzYwzbsjPojo> implements CstzYwzbsjService {

	@Override
//	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public void update(CstzYwzbsjPojo obj) {
		// TODO Auto-generated method stub
		super.update(obj);
	}

}
