package com.cloud.icenter.yyzx.cstz.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.cloud.icenter.yyzx.cstz.service.CstzTzzssjService;
import com.cloud.icenter.yyzx.cstz.service.CstzYwzbService;

/** 
 * @author zhucy 
 * @version 2017年5月24日 下午2:57:37 
 * 说明 
 */
public class ZbjsQuartz {
	@Autowired
	private CstzYwzbService cstzYwzbService;
	@Autowired
	private CstzTzzssjService cstzTzzssjService;
	public void  execute() {
		try {
			System.out.println(">>>指标计算开始!");
			this.cstzYwzbService.zbCalDs();
			System.out.println("<<<指标计算结束!");
			System.out.println(">>>逐级计算开始!");
			this.cstzTzzssjService.calThree();
			this.cstzTzzssjService.calTwo();
			this.cstzTzzssjService.calOne();
			System.out.println(">>>逐级计算结束!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
