package com.cloud.icenter.yyzx.fzjc.fr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.system.logs.pojo.Logging;
import com.cloud.icenter.yyzx.fzjc.fr.dao.FRCapitalDao;
import com.cloud.icenter.yyzx.fzjc.fr.dao.FREconDao;
import com.cloud.icenter.yyzx.fzjc.fr.dao.FRQyhyDao;
import com.cloud.icenter.yyzx.fzjc.fr.dao.FRQyinfoDao;
import com.cloud.icenter.yyzx.fzjc.fr.dao.FRRegonDao;
import com.cloud.icenter.yyzx.fzjc.fr.dao.FRTop5Dao;
import com.cloud.icenter.yyzx.fzjc.fr.dao.FRTop8Dao;
import com.cloud.icenter.yyzx.fzjc.fr.dao.FRZxwDao;
import com.cloud.icenter.yyzx.fzjc.fr.pojo.FRCapitalPojo;
import com.cloud.icenter.yyzx.fzjc.fr.pojo.FREconNsPojo;
import com.cloud.icenter.yyzx.fzjc.fr.pojo.FREconPojo;
import com.cloud.icenter.yyzx.fzjc.fr.pojo.FRQyhyPojo;
import com.cloud.icenter.yyzx.fzjc.fr.pojo.FRQyinfoPojo;
import com.cloud.icenter.yyzx.fzjc.fr.pojo.FRRegonPojo;
import com.cloud.icenter.yyzx.fzjc.fr.pojo.FRTop5Pojo;
import com.cloud.icenter.yyzx.fzjc.fr.pojo.FRTop8Pojo;
import com.cloud.icenter.yyzx.fzjc.fr.pojo.FRZxwPojo;

/**
 * @author dbchenga
 */
@Logging
@Service
public class FRServiceImpl extends BaseServiceImpl<FRZxwPojo> implements
		FRService {

	@Autowired
	private FRZxwDao frZxwDao;
	@Autowired
	private FRRegonDao frRegonDao;

	@Autowired
	private FREconDao frEconDao;

	@Autowired
	private FRCapitalDao frCapitalDao;

	@Autowired
	private FRQyhyDao frQyhyDao;

	@Autowired
	private FRQyinfoDao frQyinfoDao;

	@Autowired
	private FRTop5Dao frTop5Dao;

	@Autowired
	private FRTop8Dao frTop8Dao;

	@Override
	public List<FRCapitalPojo> getCurCapital() {
		// TODO Auto-generated method stub
		return frCapitalDao.getCurCapital();
	}

	@Override
	public List<FRCapitalPojo> getCapitalByYear(int year) {
		// TODO Auto-generated method stub
		return frCapitalDao.getCapitalByYear(year);
	}

	@Override
	public List<FREconPojo> getCurEcon() {
		// TODO Auto-generated method stub
		return frEconDao.getCurEcon();
	}

	@Override
	public List<FREconPojo> getEconByYear(int year) {
		// TODO Auto-generated method stub
		return frEconDao.getEconByYear(year);
	}

	@Override
	public List<FREconNsPojo> getCurEconNs() {
		// TODO Auto-generated method stub
		return frEconDao.getCurEconNs();
	}

	@Override
	public List<FREconNsPojo> getEconNsByYear(int year) {
		// TODO Auto-generated method stub
		return frEconDao.getEconNsByYear(year);
	}

	@Override
	public List<FRRegonPojo> getCurRegon() {
		// TODO Auto-generated method stub
		return frRegonDao.getCurRegon();
	}

	@Override
	public List<FRRegonPojo> getRegonByYear(int year) {
		// TODO Auto-generated method stub
		return frRegonDao.getRegonByYear(year);
	}

	@Override
	public List<FRZxwPojo> getFiveYearZxw() {
		// TODO Auto-generated method stub
		return frZxwDao.getFiveYearZxw();
	}

	@Override
	public FRZxwPojo getZxwByYear(int year) {
		// TODO Auto-generated method stub
		return frZxwDao.getZxwByYear(year);
	}

	@Override
	public List<FRQyhyPojo> getCurQyhy() {
		// TODO Auto-generated method stub
		return frQyhyDao.getCurQyhy();
	}

	@Override
	public List<FRQyhyPojo> getQyhyByYear(int year) {
		// TODO Auto-generated method stub
		return frQyhyDao.getQyhyByYear(year);
	}

	@Override
	public List<FRQyinfoPojo> getCurQyinfo() {
		// TODO Auto-generated method stub
		return frQyinfoDao.getCurQyinfo();
	}

	@Override
	public List<FRQyinfoPojo> getQyinfoByYear(int year) {
		// TODO Auto-generated method stub
		return frQyinfoDao.getQyinfoByYear(year);
	}

	@Override
	public List<FRTop5Pojo> getCurTop5() {
		// TODO Auto-generated method stub
		return frTop5Dao.getCurFiveYear();
	}

	@Override
	public List<FRTop8Pojo> getCurTop8() {
		// TODO Auto-generated method stub
		return frTop8Dao.getCurFourYear();
	}

}
