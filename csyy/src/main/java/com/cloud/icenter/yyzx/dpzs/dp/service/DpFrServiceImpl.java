package com.cloud.icenter.yyzx.dpzs.dp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.system.logs.pojo.Logging;
import com.cloud.icenter.yyzx.dpzs.dp.dao.DpFrQyjyzqDao;
import com.cloud.icenter.yyzx.dpzs.dp.dao.DpFrqyryDao;
import com.cloud.icenter.yyzx.dpzs.dp.dao.DpFrzbDao;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpFrFrfbPojo;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpFrFrqyryPojo;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpFrFrzbPojo;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpFrQyjyzqPojo;
import com.cloud.icenter.yyzx.fzjc.fr.dao.FREconDao;
import com.cloud.icenter.yyzx.fzjc.fr.dao.FRQyhyDao;
import com.cloud.icenter.yyzx.fzjc.fr.dao.FRRegonDao;
import com.cloud.icenter.yyzx.fzjc.fr.dao.FRZxwDao;
import com.cloud.icenter.yyzx.fzjc.fr.pojo.FRQyhyPojo;
import com.cloud.icenter.yyzx.fzjc.fr.pojo.FRRegonPojo;
import com.cloud.icenter.yyzx.fzjc.fr.pojo.FRZxwPojo;

/**
 * @author dbchenga
 */
@Logging
@Service
public class DpFrServiceImpl extends BaseServiceImpl<DpFrQyjyzqPojo> implements DpFrService {

	@Autowired
	private DpFrQyjyzqDao dpFrQyjyzqDao;

	@Autowired
	private DpFrqyryDao dpFrqyryDao;
	@Autowired
	private FRZxwDao fRZxwDao;

	@Autowired
	private FRQyhyDao fRQyhyDao;

	@Autowired
	private FREconDao fREconDao;

	@Autowired
	private FRRegonDao fRRegonDao;

	@Autowired
	private DpFrzbDao dpFrzbDao;

	@Override
	public List<DpFrQyjyzqPojo> getCurQyjyzq() {
		// TODO Auto-generated method stub
		return dpFrQyjyzqDao.getCurQyjyzq();
	}

	@Override
	public List<DpFrQyjyzqPojo> getQyjyzqByYear(int year) {
		// TODO Auto-generated method stub
		return dpFrQyjyzqDao.getQyjyzqByYear(year);
	}

	@Override
	public List<DpFrFrfbPojo> getCurFb() {
		List<DpFrFrfbPojo> fbList = new ArrayList<DpFrFrfbPojo>();

		String[] qyhys = { "工业", "建筑业", "批发", "零售业", "交通运输", "住宿餐饮", "高科技", "仓储物流" };

		for (String str : qyhys) {
			List<DpFrFrzbPojo> zb = getCurFrzb(2017, str, null);
			fbList.add(new DpFrFrfbPojo(str, zb.size()));

		}
		// TODO Auto-generated method stub
		return fbList;
	}

	@Override
	public List<FRRegonPojo> getRegonByNameSevevYear(String regonName) {
		// TODO Auto-generated method stub
		return fRRegonDao.getRegonByNameSevevYear(regonName);
	}

	@Override
	public List<FRQyhyPojo> getCurQyhy() {
		// TODO Auto-generated method stub
		return fRQyhyDao.getCurQyhy();
	}

	@Override
	public List<DpFrFrqyryPojo> getCurQyry() {
		// TODO Auto-generated method stub
		return dpFrqyryDao.getCurQyry();
	}

	@Override
	public List<DpFrFrqyryPojo> getQyryByYear(int year) {
		// TODO Auto-generated method stub
		return dpFrqyryDao.getQyryByYear(year);
	}

	@Override
	public List<FRZxwPojo> getSevenYearZxw() {
		// TODO Auto-generated method stub
		return fRZxwDao.getSevenYear();
	}

	@Override
	public List<DpFrFrzbPojo> getCurFrzb(int year, String qyhy, String qyxz) {
		// TODO Auto-generated method stub
		return dpFrzbDao.getCurFrzb(year, qyhy, qyxz);
	}

}
