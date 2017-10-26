package com.cloud.icenter.yyzx.ztfx.jtcx.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.icenter.base.controller.BaseAction;
import com.cloud.icenter.common.utils.JsonResult;
import com.cloud.icenter.common.utils.JsonUtil;
import com.cloud.icenter.common.utils.StringUtil;
import com.cloud.icenter.yyzx.ztfx.jtcx.service.GJxlYdfxService;
import com.cloud.icenter.yyzx.ztfx.jtcx.service.JtcxYdfxService;

/** 
 * @author zhucy 
 * @version 2017年7月26日 上午10:29:18 
 * 说明 ：公交拥堵数据查询
 */
@Controller
@RequestMapping("/jtcxYdfxAction")
public class JtcxYdfxAction extends BaseAction{
	@Autowired
	JtcxYdfxService jtcxYdfxService;
	
	@Autowired
	GJxlYdfxService gJxlYdfxService;
	
	@RequestMapping(value="/getYdph")
	@ResponseBody
	public Object getYdph(HttpServletRequest request){
		Map<String, Object> result = this.jtcxYdfxService.getGfsdYdph();
		return result;
	}
	
	
	@RequestMapping(value="/getYdsj",method=RequestMethod.POST)
	@ResponseBody
	public Object getYdsj(HttpServletRequest request){
		String name = request.getParameter("name");
		String sxx = request.getParameter("sxx");
		String ydsj = this.gJxlYdfxService.getYdsj(name,sxx);
		if (StringUtil.isEmpty(ydsj)) {
			return "";
		}
		return ydsj;
	}
}
