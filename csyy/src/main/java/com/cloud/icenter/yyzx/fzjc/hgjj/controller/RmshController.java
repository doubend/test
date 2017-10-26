package com.cloud.icenter.yyzx.fzjc.hgjj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.icenter.base.controller.BaseAction;
import com.cloud.icenter.common.utils.JsonResult;
import com.cloud.icenter.yyzx.fzjc.hgjj.pojo.RmshGksj;
import com.cloud.icenter.yyzx.fzjc.hgjj.pojo.RmshLnsh;
import com.cloud.icenter.yyzx.fzjc.hgjj.pojo.RmshShru;
import com.cloud.icenter.yyzx.fzjc.hgjj.pojo.RmshXfjg;
import com.cloud.icenter.yyzx.fzjc.hgjj.service.RmshService;
/**
 * 人民生活
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value="/jjfz/rmsh")
public class RmshController extends BaseAction{
	
	@Autowired
	private RmshService rmshService;
	
	@RequestMapping(value = "/toPage",method=RequestMethod.GET)
	public String toPage(){
		return "fzjc/hgjj/peopleLive";
	}
	
	/**
	 * 人民生活页面左上角基本概况数据
	 * @return
	 */
	@RequestMapping(value = "/getRmshGksj", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public JsonResult getRmshGksj(){
		RmshGksj rmshGksj = rmshService.getRmshGksj();
		return jsonResult(200, "数据获取成功", rmshGksj);
	}
	
	
	/**
	 * 历年数据变化情况
	 * @return
	 */
	@RequestMapping(value = "/getRmshLnshList", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public JsonResult getRmshLnshList(){
		List<RmshLnsh> list = rmshService.getRmshLnshList();
		return jsonResult(200, "数据获取成功", list);
	}
	
	
	/**
	 * 居民消费价格基本情况
	 * @return
	 */
	@RequestMapping(value = "/getRmshXfjgList", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public JsonResult getRmshXfjgList(){
		List<RmshXfjg> list = rmshService.getRmshXfjgList();
		return jsonResult(200, "数据获取成功", list);
	}
	
	
	/**
	 * 城镇居民人均可支配收入情况
	 * @return
	 */
	@RequestMapping(value = "/getRmshShruList", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public JsonResult getRmshShruList(){
		RmshShru shru = rmshService.getRmshShruList();
		return jsonResult(200, "数据获取成功", shru);
	}

}
