package com.cloud.icenter.yyzx.fzjc.rk.controller;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.icenter.base.controller.BaseAction;
import com.cloud.icenter.common.utils.JsonResult;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Agestructure;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.MzzjAreaResult;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.MzzjResult;
import com.cloud.icenter.yyzx.fzjc.rk.service.MzzjService;

/**
 * 民族宗教 
 * @date 2017年9月27日
 * @author dxliug
 */
@RequestMapping(value="/fzjc/pop")
@Controller
public class MzzjController extends BaseAction{
	
	@Autowired
	private MzzjService mzzjService;
	/**
	 * 民族宗教展示页面
	 * @return
	 */
	@RequestMapping(value="/mzzj",method=RequestMethod.GET)
	public String nationReligion(){
    	return "fzjc/rk/nationReligion";
	}
	/**
	 * 人民生活页面左上角基本概况数据
	 * @return
	 */
	@RequestMapping(value = "/getRenkMzzj", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public JsonResult getRenkMzzj(@RequestParam(required = false) String year){
		if (year == null) {
			Calendar a = Calendar.getInstance();
			year = a.get(Calendar.YEAR) + "";
		}
		List<MzzjResult> result = mzzjService.getRenkMzzj(year);
		return jsonResult(200, "数据获取成功", result.subList(0,result.size()));
	}
	/**
	 * 民族宗教区域分布图
	 * @return
	 */
	@RequestMapping(value = "/getRenkMzzjArea", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public JsonResult getRenkMzzjArea(@RequestParam(required = false) String year){
		if (year == null) {
			Calendar a = Calendar.getInstance();
			year = a.get(Calendar.YEAR) + "";
		}
		List<MzzjAreaResult> result = mzzjService.getRenkMzzjArea(year);
		return jsonResult(200, "数据获取成功", result);
	}
	/**
	 * 民族宗教信教年龄段男女对比图
	 * @return
	 */
	@RequestMapping(value = "/getRenkMzzjAge", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public JsonResult getRenkMzzjAge(@RequestParam(required = false) String year){
		if (year == null) {
			Calendar a = Calendar.getInstance();
			year = a.get(Calendar.YEAR) + "";
		}
		List<Agestructure> result = mzzjService.getRenkMzzjAge(year);
		return jsonResult(200, "数据获取成功", result);
	}
}
