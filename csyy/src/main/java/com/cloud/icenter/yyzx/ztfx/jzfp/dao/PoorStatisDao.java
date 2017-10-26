package com.cloud.icenter.yyzx.ztfx.jzfp.dao;

import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.ztfx.jzfp.pojo.PoorStatisPojo;

public interface PoorStatisDao extends BaseDao<PoorStatisPojo>{
	/**
	 * 获取当前年份的贫困概况
	 * @param name
	 * @return
	 */
	public List<PoorStatisPojo> getCurStatis();
	public List<PoorStatisPojo> getCurStatis(int type);
	public List<PoorStatisPojo> getStatisByYear(int year);
	public List<PoorStatisPojo> getStatisByYear(int year,int type);
	
}
