package com.cloud.icenter.system.datasync.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cloud.icenter.base.controller.BaseAction;
import com.cloud.icenter.common.utils.DateUtil;
import com.cloud.icenter.common.utils.StringUtil;
import com.cloud.icenter.common.utils.SystemConfig;
import com.cloud.icenter.system.datasync.service.DataSyncService;

@Controller
@RequestMapping(value = "/datasync")
public class DataSyncAction extends BaseAction {
	private final String key = SystemConfig.getProperty("sync.signkey");
	@Autowired
	private DataSyncService dataSyncService;

	@RequestMapping(value = "/sync", method = { RequestMethod.GET,
			RequestMethod.POST })
	public void sync() {
		try {
//			String string =getParameter("json");
//			 dataSyncService.syncOrgan(getParameter("json"));
			String timestamp = getParameter("timestamp");
			String sign = getParameter("sign");
			if (StringUtil.isEmpty(timestamp) || StringUtil.isEmpty(sign)) {
				printJsonResult(-1, "请求参数错误! ");
			} else {
				Date date = DateUtil.parse(timestamp, "yyyyMMddHHmmss");
				long between = ((new Date()).getTime() - date.getTime()) / 1000;
				String signsString = StringUtil.toSignature(timestamp, key);
				if (sign.equals(signsString)) {
					printJsonResult(200, dataSyncService.sync());
				} else {
					printJsonResult(-1, "签名错误! ");
				}
			}

		} catch (Exception e) {
			printJsonResult(-1, e.getMessage());
		}

	}
}
