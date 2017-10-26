package com.cloud.icenter.yyzx.dpzs.slp.dao;

import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.dpzs.slp.pojo.SlpRkNljgPojo;
import com.cloud.icenter.yyzx.dpzs.slp.pojo.SlpRkfbPojo;

public interface SlpRkfbDao extends BaseDao<SlpRkfbPojo> {
	/**
	 * @三联屏-人口-低保数据
	 * @param name
	 * @return
	 */
	public List<SlpRkfbPojo> getRkfbByYear(int year);

	public List<SlpRkNljgPojo> getRkNljgList();

}
