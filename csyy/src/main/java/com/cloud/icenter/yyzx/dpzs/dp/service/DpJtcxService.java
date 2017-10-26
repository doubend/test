package com.cloud.icenter.yyzx.dpzs.dp.service;

import java.util.List;

import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpJtcxCzcPojo;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpJtcxFzPojo;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpJtcxZbPojo;

public interface DpJtcxService {
	public List<DpJtcxCzcPojo> getCurCzc();

	public List<DpJtcxZbPojo> getCurZb();

	public List<DpJtcxFzPojo> getCurFiveYear();
}
