package com.cloud.icenter.quartz.sync;

import org.springframework.beans.factory.annotation.Autowired;

import com.cloud.icenter.common.utils.HttpUtil;
import com.cloud.icenter.common.utils.JsonResult;
import com.cloud.icenter.common.utils.JsonUtil;
import com.cloud.icenter.common.utils.SpringUtil;
import com.cloud.icenter.common.utils.SystemConfig;
import com.cloud.icenter.system.sync.controller.SyncInterfaceAction;

public class SyncQtz {
	
	SyncInterfaceAction syncInterfaceAction = new SyncInterfaceAction();
	
	String executedate = null;
	
	public SyncQtz(){
		
	}
	
	public void execute(){
		try{
			//第一次执行时间为null 获取当前时间。
			if(executedate==null){
				executedate=syncInterfaceAction.getSysdate();
			}
			
			//每次执行先获取当前时间
			String newdate = syncInterfaceAction.getSysdate();
			
			//执行日志增量同步
			//String result = HttpUtil.HttpGet("http://10.44.55.162:8888/irsp/system/syncinterface/syncByLog?starttime="+executedate+"&endtime="+ newdate);

			//生成请求地址
			String syncUrl = SystemConfig.getProperty("tyrz.sync.HostAddress")+"/system/syncinterface/syncByLog?starttime="+executedate+"&endtime="+ newdate;
			
			//执行日志增量同步
			String result = HttpUtil.HttpGet(syncUrl);

			//执行完成后将当前时间存入执行时间缓存
			executedate=newdate;

			System.out.println(executedate + "开始同步" + result);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
