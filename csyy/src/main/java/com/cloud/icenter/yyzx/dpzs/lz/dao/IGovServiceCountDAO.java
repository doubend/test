package com.cloud.icenter.yyzx.dpzs.lz.dao;

import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.dpzs.lz.pojo.GovServiceCount;

/**
 * 
 * 政务服务-行政审批数据统计DAO
 * 
 * @author wzy_0216
 *
 */
public interface IGovServiceCountDAO extends BaseDao<GovServiceCount> {

	/**
	 * 获取平台库今天行政审批数据
	 * 
	 * @return
	 */
	public GovServiceCount getCurrDayData();

	/**
	 * 获取采集中心库今天行政审批数据
	 * 
	 * @return
	 */
	public List<GovServiceCount> getDayData();

	/**
	 * 平台库修改行政审批数据
	 * 
	 * @param govServiceCount
	 * @return
	 */
	public Integer updateData(GovServiceCount govServiceCount);

}
