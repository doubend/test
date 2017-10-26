package com.cloud.icenter.yyzx.dpzs.lz.service;

import java.util.List;

import com.cloud.icenter.yyzx.dpzs.lz.pojo.LzJtcxPojo;
import com.cloud.icenter.yyzx.dpzs.lz.pojo.LzMinshengPojo;

public interface LzService {
	public List<LzMinshengPojo> getCurMinsheng();

	public List<LzMinshengPojo> getCurMinsheng(int type);

	public List<LzMinshengPojo> getMinshengByYear(int year);

	public LzJtcxPojo getCurJtcx();

	public LzJtcxPojo getJtcxByYear(int year);
}
