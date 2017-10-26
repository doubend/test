package com.cloud.icenter.yyzx.fzjc.education.controller;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONObject;
import com.cloud.icenter.base.controller.ModelAction;
import com.cloud.icenter.common.utils.JsonUtil;
import com.cloud.icenter.yyzx.fzjc.education.pojo.SchoolInfo;
import com.cloud.icenter.yyzx.fzjc.education.pojo.SchoolQueryParam;
import com.cloud.icenter.yyzx.fzjc.education.service.SchoolInfoService;

/**
 * 教育资源页面
 * @date 2017年9月25日
 * @author dxliug
 */
@Controller
@RequestMapping(value="/fzjc/education")
public class educationAction extends ModelAction<SchoolInfo>{
	
	@Autowired private SchoolInfoService schoolService;
	
	/**
	 * 教育资源均衡情况页面
	 * @return
	 */
	@RequestMapping(value="/ShowEducation", method = {RequestMethod.POST, RequestMethod.GET})
	public String ShowEducation(){
		//查询学校信息
		Calendar now = Calendar.getInstance();
		int curYear = now.get(now.YEAR);
		SchoolQueryParam param = new SchoolQueryParam();
		param.setNf(curYear);
		param.setXxlx("小学");	
		List<JSONObject> lstSchool = schoolService.getSchoolByXxlx(param);
		setAttribute("lstSchool", lstSchool);
		
		return "fzjc/education/education";
	}
	
	/**
	 * 查询学校信息
	 * @param param
	 */
	@RequestMapping(value="/querySchoolByCondition", method = {RequestMethod.POST, RequestMethod.GET})
	public void querySchoolByCondition(SchoolQueryParam param){
		List<JSONObject> lstSchool = schoolService.getSchoolByXxlx(param);
		
		String json = JsonUtil.toJson(lstSchool);
		printJson(json);
	}
	
	/**
	 * 获取学区信息
	 * @param xxlx : 学校类型
	 * @param name : 学校名称
	 */
	@RequestMapping(value="/queryXqInfoByName", method = {RequestMethod.POST, RequestMethod.GET})
	public void queryXqInfoByName(String xxlx, String name, int nf){
		List<JSONObject> lstXqInfo = schoolService.getXqInfoByName(xxlx, name, nf);
		
		String json = JsonUtil.toJson(lstXqInfo);
		printJson(json);
	}
	
	/**
	 * 获取历年(2010-2017)招生名额和适龄学童
	 * @param xxlx ： 学校类型
	 * @param xzqdm ： 行政区代码
	 */
	@RequestMapping(value="/queryZsmeAndSlxt", method = {RequestMethod.POST, RequestMethod.GET})
	public void queryZsmeAndSlxt(String xxlx, String xzqdm){
		Map<String, Object> resMap = schoolService.getZsmeAndSlxt(xxlx, xzqdm);
		
		String json = JsonUtil.toJson(resMap);
		printJson(json);
	}
	
	/**
	 * 获取学校历年(2010-2017)招生名额和适龄学童
	 * @param xxlx ：学校类型
	 * @param name ： 学校简称
	 */
	@RequestMapping(value="/queryZsmeAndSlxtByName", method = {RequestMethod.POST, RequestMethod.GET})
	public void queryZsmeAndSlxtByName(String xxlx, String name){
		Map<String, Object> resMap = schoolService.getZsmeAndSlxtByName(xxlx, name);
		
		String json = JsonUtil.toJson(resMap);
		printJson(json);
	}
}
