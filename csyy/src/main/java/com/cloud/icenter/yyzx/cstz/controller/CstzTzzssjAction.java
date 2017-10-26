package com.cloud.icenter.yyzx.cstz.controller;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.icenter.base.controller.ModelAction;
import com.cloud.icenter.common.utils.JsonResult;
import com.cloud.icenter.common.utils.PagingUtil;
import com.cloud.icenter.yyzx.cstz.pojo.CstzTzzssjPojo;
import com.cloud.icenter.yyzx.cstz.pojo.CstzYwzbPojo;
import com.cloud.icenter.yyzx.cstz.service.CstzTzzssjService;
import com.cloud.icenter.yyzx.cstz.service.CstzYwzbService;

/** 
* @author zhucy 
* @version 2017年4月18日 上午11:05:26 
* 说明 
*/
@Controller
@RequestMapping(value="/cstzTzzssjAction")
public class CstzTzzssjAction extends ModelAction<CstzTzzssjPojo>{
	
	@Autowired
	private CstzYwzbService cstzYwzbService;
	
	@Autowired
	private CstzTzzssjService cstzTzzssjService;
	
	@RequestMapping(value="/toZbCal",method=RequestMethod.GET)
	public String toZbCal(){
		return "cstz/tzzssj-list";
	}
	
	/**
	 * 查询业务指标数据
	 * @param param
	 */
	@RequestMapping(value="/queryTzzssj",method=RequestMethod.POST)
	@ResponseBody
	public Object queryTzzssj(CstzYwzbPojo param,PagingUtil pagingUtil){
		Map<String, ?> result = cstzTzzssjService.getPageObjectBySql(param.getYwzbmc(), pagingUtil);
		return result;
	}
	
	/**
	 * 指标计算
	 * @return
	 */
	@RequestMapping(value="/zbCal",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult zbCal(){
		try {
			this.cstzYwzbService.initData();
			this.cstzYwzbService.zbCal();
			this.cstzTzzssjService.calThree();
			this.cstzTzzssjService.calTwo();
			this.cstzTzzssjService.calOne();
			System.out.println("*&*&*&*&*&*&*&*&*&**&*&*&*&*所有体征计算完毕*&*&*&*&**&*&*&*&**&*&*&*&*");
			return jsonResult(200, "执行成功!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonResult(-1, "执行失败!");
	}
	
	/**
	 * 逐级计算
	 * @return
	 */
	@RequestMapping(value="/upCal",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult upCal(){
		try {
			this.cstzTzzssjService.calThree();
			this.cstzTzzssjService.calTwo();
			this.cstzTzzssjService.calOne();
//			for (int i = 0; i < 3; i++) {
//				this.cstzTzzssjService.upCal();
//			}
//			this.cstzTzzssjService.upCal();
			System.out.println("*&*&*&*&*&*&*&*&*&**&*&*&*&*计算完毕*&*&*&*&**&*&*&*&**&*&*&*&*");
			return jsonResult(200, "执行成功!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonResult(-1, "执行失败!");
	}
	
	
}
