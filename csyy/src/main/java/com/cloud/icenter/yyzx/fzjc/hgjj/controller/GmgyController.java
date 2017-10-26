package com.cloud.icenter.yyzx.fzjc.hgjj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.icenter.base.controller.BaseAction;
import com.cloud.icenter.common.utils.JsonResult;
import com.cloud.icenter.yyzx.fzjc.hgjj.pojo.GmgyCzgc;
import com.cloud.icenter.yyzx.fzjc.hgjj.pojo.GmgyLnsh;
import com.cloud.icenter.yyzx.fzjc.hgjj.pojo.GmgyTop;
import com.cloud.icenter.yyzx.fzjc.hgjj.service.GmgyService;

/**
 * 经济发展->规模工业
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value="/jjfz/gmgy")
public class GmgyController extends BaseAction{
	
	@Autowired
	private GmgyService gmgyservice;
	
	@RequestMapping(value = "/toPage",method=RequestMethod.GET)
	public String toPage(){
		return "fzjc/hgjj/industry";
	}
	
	/**
	 * 获取规模工业历年数据
	 * @return
	 */
	@RequestMapping(value = "/getGmgyLnshList", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public JsonResult getGmgyLnshList(){
		List<GmgyLnsh> glist = gmgyservice.getGmgyLnshList();
		return jsonResult(200, "数据获取成功", glist);
	}
	
	
	/**
	 * 企业总产值TOP5排行情况
	 * @return
	 */
	@RequestMapping(value = "/getGmgyTopList", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public JsonResult getGmgyTopList(){
		List<GmgyTop> glist = gmgyservice.getGmgyTopList();
		return jsonResult(200, "数据获取成功", glist);
	}
	
	
	/**
	 * 工业总产值构成
	 * @return
	 */
	@RequestMapping(value = "/getGmgyCzgcList", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public JsonResult getGmgyCzgcList(){
		List<GmgyCzgc> glist = gmgyservice.getGmgyCzgcList();
		return jsonResult(200, "数据获取成功", glist);
	}

}
