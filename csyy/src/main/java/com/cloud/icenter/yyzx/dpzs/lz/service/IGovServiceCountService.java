package com.cloud.icenter.yyzx.dpzs.lz.service;

import com.cloud.icenter.base.service.BaseService;
import com.cloud.icenter.yyzx.dpzs.lz.pojo.GovServiceCount;

public interface IGovServiceCountService extends BaseService<GovServiceCount> {

	public GovServiceCount getCurrDayData();

	public void updateGovServiceCountData();

}
