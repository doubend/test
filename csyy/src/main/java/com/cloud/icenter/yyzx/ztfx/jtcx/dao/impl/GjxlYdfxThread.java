package com.cloud.icenter.yyzx.ztfx.jtcx.dao.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.cloud.icenter.common.utils.SpringUtil;
import com.cloud.icenter.yyzx.ztfx.jtcx.service.JtcxYdfxService;

/** 
 * @author zhucy 
 * @version 2017年8月16日 下午2:30:02 
 * 说明：多线程执行公交数据计算
 */
public class GjxlYdfxThread extends Thread{
	
	private String sxx = null;//上下行
	
	private Map<String, Object> map= null;//当前执行的线路名称
	
	public GjxlYdfxThread (Map<String, Object> xl,String bs) {
		this.map = xl;
		this.sxx = bs;
	}

	@Override
	public void run() {
		if (sxx.equals("0")) {
			SpringUtil.getBean(JtcxYdfxService.class).dataHandleSx(map);
		}else {
			SpringUtil.getBean(JtcxYdfxService.class).dataHandleXx(map);
		}
		
	}
	
	
}
