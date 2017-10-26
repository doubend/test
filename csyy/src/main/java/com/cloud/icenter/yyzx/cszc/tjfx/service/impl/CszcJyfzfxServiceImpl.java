package com.cloud.icenter.yyzx.cszc.tjfx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.system.logs.pojo.Logging;
import com.cloud.icenter.yyzx.cszc.tjfx.dao.CszcJyfzfxDao;
import com.cloud.icenter.yyzx.cszc.tjfx.pojo.CszcJyfzfxDqPoJo;
import com.cloud.icenter.yyzx.cszc.tjfx.pojo.CszcJyfzfxDsjPojo;
import com.cloud.icenter.yyzx.cszc.tjfx.pojo.CszcJyfzfxNfPoJo;
import com.cloud.icenter.yyzx.cszc.tjfx.service.CszcJyfzfxService;

/** 
* @author zhucy 
* @version 2017年4月20日 下午5:45:38 
* 说明 
*/
@Logging
@Service
public class CszcJyfzfxServiceImpl extends BaseServiceImpl<CszcJyfzfxNfPoJo> implements CszcJyfzfxService{

	@Autowired
	private CszcJyfzfxDao cszcJyfzfxDao;
	
	@Override
	public List<CszcJyfzfxNfPoJo> getJcjyfz() {
		// TODO Auto-generated method stub
		return this.cszcJyfzfxDao.getJcjyfz();
	}

	@Override
	public List<CszcJyfzfxNfPoJo> getZyjyfz() {
		// TODO Auto-generated method stub
		return this.cszcJyfzfxDao.getZyjyfz();
	}

	@Override
	public List<CszcJyfzfxDqPoJo> getJcjyfb() {
		// TODO Auto-generated method stub
		return this.cszcJyfzfxDao.getJcjyfb();
	}

	@Override
	public List<CszcJyfzfxNfPoJo> getJyfzxq() {
		// TODO Auto-generated method stub
		return this.cszcJyfzfxDao.getJyfzxq();
	}

	@Override
	public List<CszcJyfzfxDsjPojo> getDsjTopSix() {
		// TODO Auto-generated method stub
		return this.cszcJyfzfxDao.getDsjTopSix();
	}

	@Override
	public List<CszcJyfzfxDsjPojo> getDsjList() {
		// TODO Auto-generated method stub
		return this.cszcJyfzfxDao.getDsjList();
	}

}
