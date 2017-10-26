package com.cloud.icenter.yyzx.ztfx.jtcx.service;

import java.util.List;
import java.util.Map;

import com.cloud.icenter.yyzx.ztfx.jtcx.pojo.GjcsdPojo;

public interface GjcsdService{
	
	public String getPjsdList(String name, String dir);
	
	public void writeXxData();
	
	public void writeSxData();

	public List<Map<String, Object>> getZmList(String name, String dir);

}
