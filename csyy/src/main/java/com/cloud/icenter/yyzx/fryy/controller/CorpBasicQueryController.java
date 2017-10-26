package com.cloud.icenter.yyzx.fryy.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cloud.icenter.base.controller.ModelAction;
import com.cloud.icenter.common.util.CbidSystemControlLog;
import com.cloud.icenter.common.util.SystemControllerLog;
import com.cloud.icenter.common.utils.DateUtil;
import com.cloud.icenter.common.utils.PagingUtil;
import com.cloud.icenter.common.utils.StringUtil;
import com.cloud.icenter.yyzx.fryy.pojo.CorpBasicQuery;
import com.cloud.icenter.yyzx.fryy.pojo.CorpBasicQueryQM;
import com.cloud.icenter.yyzx.fryy.pojo.CorpCancelQueryQM;
import com.cloud.icenter.yyzx.fryy.pojo.CorpChangeQueryQM;
import com.cloud.icenter.yyzx.fryy.pojo.DictionaryQM;
import com.cloud.icenter.yyzx.fryy.pojo.EmployeeQueryQM;
import com.cloud.icenter.yyzx.fryy.pojo.SocialSecurityQueryQM;
import com.cloud.icenter.yyzx.fryy.pojo.TaxQueryQM;
import com.cloud.icenter.yyzx.fryy.pojo.TaxRegistQueryQM;
import com.cloud.icenter.yyzx.fryy.service.CorpBasicQueryService;
import com.cloud.icenter.yyzx.rkyy.pojo.Dictionary;
import com.cloud.icenter.yyzx.rkyy.service.PeopleBasicQueryService;

/**
 * 法人页面
 * @date 2017年9月21日
 * @author dxliug
 */
@Controller
@RequestMapping(value="/corpbasicquery")
public class CorpBasicQueryController extends ModelAction<CorpBasicQuery>{

	@Autowired
	private CorpBasicQueryService corpBasicQueryService;
	
	@Autowired
	private PeopleBasicQueryService peopleBasicQueryService;
	
	/**
	 * 跳转到列表页
	 */
	@RequestMapping(value = "/toList")
	public ModelAndView toCorpBasicQueryList() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("corpBasicQuery/corpBasicList");
		/*CodeQueryQM qm = new CodeQueryQM();
		qm.setType("01");*/
		/*List<JSONObject> list = corpBasicQueryService.findBaseListByParam(qm, "toAddressList");
		mv.addObject("list", list);*/
		return mv;
	}
	
	/**
	 * 查询分页
	 */
	@RequestMapping(value = "/toPageList")
	@ResponseBody
	public  Object toPageList(CorpBasicQueryQM qm,PagingUtil pagingUtil) {
		if(!StringUtil.isEmpty(getParameter("kssj1"))) {
			Date fromDate=DateUtil.parse(getParameter("kssj1"), "yyyy-MM-dd");
			qm.setStartDate(fromDate);
		}
		if(!StringUtil.isEmpty(getParameter("jssj1"))) {
			Date toDate=DateUtil.parse(getParameter("jssj1")+" 23:59:59", "yyyy-MM-dd HH:mm:ss");
			qm.setEndDate(toDate);
		}
		Map<String, ?> result = this.corpBasicQueryService.getPageObjectBySql(qm, pagingUtil);
		return result;
	}
	
	
	/**
	 * 跳到查看页面
	 */
	@RequestMapping(value = "/toView")
	public ModelAndView toView(CorpBasicQueryQM qm) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("corpBasicQuery/view");
		Map<String, Object> obj = corpBasicQueryService.findBaseByParam(qm);
		DictionaryQM dqm = new DictionaryQM();
    	dqm.setDicType("frk");
    	dqm.setDicState("1");
    	List<Dictionary> list = this.peopleBasicQueryService.getDictionary(dqm);
		mv.addObject("zzjgdm", qm.getZzjgdm());
		mv.addObject("base", obj);
		mv.addObject("list", JSON.toJSONString(list));
		return mv;
	}
	
	
	/**
	 * 基本信息页面
	 */
	@RequestMapping(value = "/toCorpBasic")
	public ModelAndView toCorpBasic(CorpBasicQueryQM qm) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("corpBasicQuery/toCorpBasic");
		Map<String, Object> obj = corpBasicQueryService.findBaseByParam(qm);
		mv.addObject("base", obj);
		return mv;
	}
	
	
	/**
	 * 社保信息
	 * 
	 * @param qm
	 * @return
	 */
	@RequestMapping(value = "/toSocialSecurity")
	public ModelAndView toSocialSecurity(SocialSecurityQueryQM qm) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("corpBasicQuery/toSocialSecurity");
		List<Map<String, Object>> list = corpBasicQueryService.findBaseListByParam(qm);
		mv.addObject("base", list);
		return mv;
	}

	/**
	 * 税务登记页面
	 */
	@RequestMapping(value = "/toTaxRegist")
	public ModelAndView toTaxRegist(TaxRegistQueryQM qm) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("corpBasicQuery/toTaxRegist");
		List<Map<String, Object>> list = corpBasicQueryService.findBaseListByParam(qm);
		mv.addObject("base", list);
		return mv;
	}

	/**
	 * 税收页面
	 */
	@RequestMapping(value = "/toTax")
	public ModelAndView toTax(TaxQueryQM qm) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("corpBasicQuery/toTax");
		List<Map<String, Object>> list = corpBasicQueryService.findBaseListByParam(qm);
		mv.addObject("base", list);
		return mv;
	}

	/**
	 * 法人注销登记页面
	 */
	@RequestMapping(value = "/toCorpCancel")
	public ModelAndView toCorpCancel(CorpCancelQueryQM qm) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("corpBasicQuery/toCorpCancel");
		List<Map<String, Object>> list = corpBasicQueryService.findBaseListByParam(qm);
		mv.addObject("base", list);
		return mv;
	}

	/**
	 * 法人登记变更页面
	 */
	@RequestMapping(value = "/toCorpChange")
	public ModelAndView toCorpChange(CorpChangeQueryQM qm) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("corpBasicQuery/toCorpChange");
		List<Map<String, Object>> list = corpBasicQueryService.findBaseListByParam(qm);
		mv.addObject("base", list);
		return mv;
	}
	
	/**
	 * 企业公积金最后缴存月份
	 * @param qm
	 * @return
	 */
	@RequestMapping(value="/toLastAccumFundInfo")
	public ModelAndView toLastAccumFundInfo(CorpBasicQueryQM qm){
		ModelAndView mv = new ModelAndView();
		List<Map<String, Object>> list = corpBasicQueryService.findBaseListByParam(qm);
		mv.addObject("zzjgdm", qm.getZzjgdm());
		mv.addObject("fundInfo", list);
		mv.setViewName("corpBasicQuery/toLastAccumFundInfo");
		return mv;
	}
	
	/**
	 * 跳到查看内容
	 */
	@RequestMapping(value = "/toEmployeeView")
	public ModelAndView toEmployeeView(CorpBasicQueryQM qm) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("corpBasicQuery/toEmployeeView");
		mv.addObject("zzjgdm", qm.getZzjgdm());
		return mv;
	}
	
	
	@RequestMapping(value = "/toEmployeePageList")
	@ResponseBody
	public  Object toEmployeePageList(EmployeeQueryQM qm,PagingUtil pagingUtil) {
		Map<String, ?> result = this.corpBasicQueryService.getPageObjectBySql(qm, pagingUtil);
		return result;
	}
}
