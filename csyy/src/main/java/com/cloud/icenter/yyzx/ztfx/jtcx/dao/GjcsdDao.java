package com.cloud.icenter.yyzx.ztfx.jtcx.dao;

import java.util.List;
import java.util.Map;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.ztfx.jtcx.pojo.GjcsdPojo;


public interface GjcsdDao extends BaseDao<GjcsdPojo>{

	String getPjsdList(String name, String dir);

	public void writeSxData();

	List<Map<String, Object>> getZmList(String name, String dir);

	public void writeXxData();

}
