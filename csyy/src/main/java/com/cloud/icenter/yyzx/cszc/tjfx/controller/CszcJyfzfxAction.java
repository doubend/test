package com.cloud.icenter.yyzx.cszc.tjfx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.icenter.base.controller.ModelAction;
import com.cloud.icenter.common.utils.JsonResult;
import com.cloud.icenter.yyzx.cszc.tjfx.pojo.CszcJyfzfxDqPoJo;
import com.cloud.icenter.yyzx.cszc.tjfx.pojo.CszcJyfzfxDsjPojo;
import com.cloud.icenter.yyzx.cszc.tjfx.pojo.CszcJyfzfxNfPoJo;
import com.cloud.icenter.yyzx.cszc.tjfx.service.CszcJyfzfxService;

/** 
* @author zhucy 
* @version 2017年4月21日 上午9:26:09 
*  教育发展分析
*/
@Controller
@RequestMapping(value="/cszcJyfzfxAction")
public class CszcJyfzfxAction extends ModelAction<CszcJyfzfxNfPoJo>{
	
	@Autowired
	private CszcJyfzfxService cszcJyfzfxService;
	
	/**
	 * 城市资产——教育
	 * @return
	 */
	@RequestMapping(value="/education",method=RequestMethod.GET)
	public String getEducation(){
		//教育发展详情
		List<CszcJyfzfxNfPoJo> list = this.cszcJyfzfxService.getJyfzxq();
		setAttribute("jyfzxq", list);
		//教育大事记
		List<CszcJyfzfxDsjPojo> cszcJyfzfxDsjPojos = this.cszcJyfzfxService.getDsjTopSix();
		setAttribute("topDsj", cszcJyfzfxDsjPojos);
		//教育大事记列表
		List<CszcJyfzfxDsjPojo> dsjPojos = this.cszcJyfzfxService.getDsjList();
		setAttribute("dsjList", dsjPojos);
		return "/cszc/statistics/education";
	}
	
	/**
	 * 基础教育发展
	 * @return
	 */
	@RequestMapping(value = "/getJcjyfz", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public JsonResult getJcjyfz(){
		List<CszcJyfzfxNfPoJo> list = this.cszcJyfzfxService.getJcjyfz();
		return jsonResult(200, "数据获取成功", list);
	}
	
	/**
	 * 职业教育发展
	 * @return
	 */
	@RequestMapping(value = "/getZyjyfz", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public JsonResult getZyjyfz(){
		List<CszcJyfzfxNfPoJo> list = this.cszcJyfzfxService.getZyjyfz();
		return jsonResult(200, "数据获取成功", list);
	}
	
	/**
	 * 基础教育分布
	 * @return
	 */
	@RequestMapping(value = "/getJcjyfb", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public JsonResult getJcjyfb(){
		List<CszcJyfzfxDqPoJo> list = this.cszcJyfzfxService.getJcjyfb();
		return jsonResult(200, "数据获取成功", list);
	}
}
