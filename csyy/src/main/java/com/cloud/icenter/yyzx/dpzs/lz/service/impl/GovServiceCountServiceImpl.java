package com.cloud.icenter.yyzx.dpzs.lz.service.impl;

import java.util.List;

import org.apache.cxf.annotations.Logging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.common.utils.Md5Util;
import com.cloud.icenter.yyzx.dpzs.lz.dao.IGovServiceCountDAO;
import com.cloud.icenter.yyzx.dpzs.lz.pojo.GovServiceCount;
import com.cloud.icenter.yyzx.dpzs.lz.service.IGovServiceCountService;

@Logging
@Service
public class GovServiceCountServiceImpl extends BaseServiceImpl<GovServiceCount> implements IGovServiceCountService {

	@Autowired
	private IGovServiceCountDAO govServiceCountDAO;

	@Override
	public GovServiceCount getCurrDayData() {
		return govServiceCountDAO.getCurrDayData();
	}

	@Override
	public void updateGovServiceCountData() {
		List<GovServiceCount> cjjhCenterData = govServiceCountDAO.getDayData();
		if (cjjhCenterData == null || cjjhCenterData.size() <= 0) {
			return;
		}
		GovServiceCount newGovServiceCount = cjjhCenterData.get(0);
		GovServiceCount govServiceEntity = govServiceCountDAO.getCurrDayData();
		GovServiceCount govServiceCount = new GovServiceCount();
		govServiceCount.setId(Md5Util.randomUUID());
		govServiceCount.setYearAccepting(newGovServiceCount.getYearAccepting());
		govServiceCount.setYearAccepted(newGovServiceCount.getYearAccepted());
		govServiceCount.setYearHandle(newGovServiceCount.getYearHandle());
		govServiceCount.setYearHandled(newGovServiceCount.getYearHandled());
		govServiceCount.setMonthAccepting(newGovServiceCount.getMonthAccepting());
		govServiceCount.setMonthAccepted(newGovServiceCount.getMonthAccepted());
		govServiceCount.setMonthHandle(newGovServiceCount.getMonthHandle());
		govServiceCount.setMonthHandled(newGovServiceCount.getMonthHandled());
		govServiceCount.setDayAccepting(newGovServiceCount.getDayAccepting());
		govServiceCount.setDayAccepted(newGovServiceCount.getDayAccepted());
		govServiceCount.setDayHandle(newGovServiceCount.getDayHandle());
		govServiceCount.setDayHandled(newGovServiceCount.getDayHandled());
		govServiceCount.setDay(newGovServiceCount.getDay());
		govServiceCount.setMonth(newGovServiceCount.getMonth());
		govServiceCount.setYear(newGovServiceCount.getYear());
		govServiceCount.setCreatedDate(newGovServiceCount.getCreatedDate());
		if (govServiceEntity == null) {
			govServiceCountDAO.add(govServiceCount);
		} else {
			govServiceCountDAO.updateData(govServiceCount);
		}

	}
}
