package com.cloud.icenter.yyzx.dpzs.slp.service;

import java.util.List;

import com.cloud.icenter.yyzx.dpzs.slp.pojo.SlpJtcxRdmapPojo;
import com.cloud.icenter.yyzx.dpzs.slp.pojo.SlpJtcxTenPojo;
import com.cloud.icenter.yyzx.dpzs.slp.pojo.SlpJtcxTimePojo;

public interface SlpJtcxService {

	public List<SlpJtcxRdmapPojo> getYesterdayRd();

	public List<SlpJtcxTenPojo> getTenHotspot();

	public List<SlpJtcxTimePojo> getTimeHotspot();

}
