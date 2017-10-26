package com.cloud.icenter.yyzx.fzjc.rkgx.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.cloud.icenter.base.controller.ModelAction;
import com.cloud.icenter.common.utils.JsonUtil;
import com.cloud.icenter.common.utils.PagingUtil;
import com.cloud.icenter.yyzx.fzjc.rkgx.pojo.RenkJbxx;
import com.cloud.icenter.yyzx.fzjc.rkgx.pojo.SerchParam;
import com.cloud.icenter.yyzx.fzjc.rkgx.service.RenkJbxxService;

/**
 * @date 2017年9月18日
 * @author dxliug
 *   人员核查
 */
@Controller
@RequestMapping(value="/fzjc/rkgx")
public class rkgxAction extends ModelAction<RenkJbxx>{
	
	@Autowired private RenkJbxxService renkJbxxService;
	
	/**
	 * 人口关系首页
	 * @return
	 */
	@RequestMapping(value="/RkRelation", method = {RequestMethod.POST, RequestMethod.GET})
	public String RkRelation(){
		//默认查询第一条数据，显示第一条数据的关系图
		JSONObject resInfo = renkJbxxService.queryFristRow();
		String sfz = resInfo.getString("sfzhm");
		//查询个人基本信息
		JSONObject info = renkJbxxService.getPopBasicInfoBySfz(sfz);
		setAttribute("info", info);
		//查询人口关系
		Map<String, List<JSONObject>> mapRkgx = renkJbxxService.getPopRelationBySfz(sfz);
		String jsonMap = JsonUtil.toJson(mapRkgx);
		setAttribute("dataMap", jsonMap);
		
		return "fzjc/rkgx/PopRelation";
	}
	/**
     * 条件查询
     * @param param
     */
    @RequestMapping(value="/queryByCondition",method=RequestMethod.POST)
    public void queryByCondition(SerchParam param, PagingUtil pagingUtil){
    	Map<String,Object> resMap = renkJbxxService.queryByCondition(param, pagingUtil);
   	    String json = JsonUtil.toJson(resMap);
		 printJson(json);
    }
	/**
	 * 查询人口关系
	 * @param sfz
	 */
	@RequestMapping(value="/queryRkgxBySfz", method = {RequestMethod.POST, RequestMethod.GET})
	public void queryRkgxBySfz(String sfz){
		//查询人口关系
		Map<String, List<JSONObject>> mapRkgx = renkJbxxService.getPopRelationBySfz(sfz);
		
		String json = JsonUtil.toJson(mapRkgx);
		printJson(json);
	}
	
	/**
	 * 个人基本信息
	 * @param sfz
	 * @return
	 */
	@RequestMapping(value="/toPersonInfo/{sfz}", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView toPersonInfo(@PathVariable String sfz){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("fzjc/rkgx/personInfo");
    
		JSONObject info = renkJbxxService.getPopBasicInfoBySfz(sfz);
    	mv.addObject("base", info);

    	return mv;
	}
}
