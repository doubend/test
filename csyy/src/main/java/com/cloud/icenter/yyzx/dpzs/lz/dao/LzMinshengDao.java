package com.cloud.icenter.yyzx.dpzs.lz.dao;

import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.dpzs.lz.pojo.LzMinshengPojo;

public interface LzMinshengDao extends BaseDao<LzMinshengPojo> {
	/**
	 * 获取当前年份的贫困概况
	 * 
	 * @param name
	 * @return
	 */
	public List<LzMinshengPojo> getCurMinsheng();

	public List<LzMinshengPojo> getCurMinsheng(int type);

	public List<LzMinshengPojo> getMinshengByYear(int year);

}
