package com.cloud.icenter.yyzx.timer.govservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cloud.icenter.yyzx.dpzs.lz.service.IGovServiceCountService;

/**
 * 行政审批数据定时更新
 * 
 * @author wzy_0216
 *
 */
@Controller
public class GovServiceTimer {

	public static final Logger logger = LoggerFactory.getLogger(GovServiceTimer.class);
	
	@Autowired
	private IGovServiceCountService govServiceCountService;

	public void timerDataUpdate() {
		try {
			logger.error("=====行政审批数据更新开始=====");
			govServiceCountService.updateGovServiceCountData();
			logger.error("=====行政审批数据更新结束=====");
		} catch (Exception e) {
			logger.error("调度异常=" + e);
			e.printStackTrace();
		}
	}

}
