package com.cloud.icenter.yyzx.rkyy.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cloud.icenter.base.controller.ModelAction;
import com.cloud.icenter.common.utils.DateUtil;
import com.cloud.icenter.common.utils.JsonUtil;
import com.cloud.icenter.common.utils.PagingUtil;
import com.cloud.icenter.common.utils.StringUtil;
import com.cloud.icenter.yyzx.rkyy.pojo.Dictionary;
import com.cloud.icenter.yyzx.rkyy.pojo.HunYinInfoQueryQM;
import com.cloud.icenter.yyzx.rkyy.pojo.JiaTingInfoQueryQM;
import com.cloud.icenter.yyzx.rkyy.pojo.PeopleBasicQuery;
import com.cloud.icenter.yyzx.rkyy.pojo.PeopleBasicQueryQM;
import com.cloud.icenter.yyzx.rkyy.pojo.SheBaoInfoQueryQM;
import com.cloud.icenter.yyzx.rkyy.service.PeopleBasicQueryService;

/** 
* @author zhucy 
* @version 2017年4月26日 上午10:10:19 
* 说明 
*/
@Controller
@RequestMapping(value="/peopleBasicQueryAction")
public class PeopleBasicQueryAction extends ModelAction<PeopleBasicQuery>{
	
	@Autowired
	private PeopleBasicQueryService peopleBasicQueryService;
	
	/**
	 * 跳转到人口列表分页页面
	 * @return
	 */
	@RequestMapping(value="/toRkList",method=RequestMethod.GET)
	public String toRkList(){
		return "peopleBasicQuery/peopleBasicList";
	}
	
	/**
	 * 查询人口列表分页数据
	 * @param param
	 */
	@RequestMapping(value="/queryRkList",method=RequestMethod.POST)
	@ResponseBody
	public Object queryRkList(PeopleBasicQueryQM qm,PagingUtil pagingUtil){
		if(!StringUtil.isEmpty(getParameter("kssj1"))) {
			Date fromDate=DateUtil.parse(getParameter("kssj1"), "yyyy-MM-dd");
			qm.setKssj(fromDate);
		}
		if(!StringUtil.isEmpty(getParameter("jssj1"))) {
			Date toDate=DateUtil.parse(getParameter("jssj1")+" 23:59:59", "yyyy-MM-dd HH:mm:ss");
			qm.setJssj(toDate);
		}
		Map<String, ?> result = this.peopleBasicQueryService.getPageObjectBySql(qm, pagingUtil);
		return result;
	}
	
	/**
	 * 行政区划
	 * @returns
	 */
	@RequestMapping(value="/getAreaCombox",method=RequestMethod.GET)
	@ResponseBody
	public Object getAreaCombox(){
		List<Map<String, Object>> result = this.peopleBasicQueryService.getAreaCombox();
		List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
		if (null != result && result.size() > 0 ) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("code", "请选择");
			map.put("name", "请选择");
			data.add(map);
			data.addAll(result);
		}
		return data;
	}
	
	@RequestMapping(value="/toView")
    public ModelAndView toView(HttpServletRequest request){
		String sfz = request.getParameter("sfz");
		ModelAndView mv = new ModelAndView();
    	//解码身份证
    	mv.setViewName("peopleBasicQuery/view");
    	Map<String, Object> info =  this.peopleBasicQueryService.findBaseBySfz(sfz);
    	if(info == null){
    		info = new HashMap<String, Object>();
    		info.put("sfz",sfz);
    	}
    	Dictionary dqm = new Dictionary();
    	dqm.setDicType("rkk");
    	dqm.setDicState("1");
    	List<Dictionary> list = this.peopleBasicQueryService.getDictionary(dqm);
    	mv.addObject("info", info);
    	mv.addObject("list", JSON.toJSONString(list));
    	return mv;
    }
	
	/**
     * 基本信息页面
     */
    @RequestMapping(value="/toJiBen")
    public ModelAndView toJiBen(PeopleBasicQueryQM qm){
    	ModelAndView mv = new ModelAndView();
    	mv.setViewName("peopleBasicQuery/jibenInfo");
    	//解码身份证
    	mv.addObject("sfz", qm.getSfz());
    	Map<String, Object> info =  this.peopleBasicQueryService.findBaseBySfz(qm.getSfz());
    	mv.addObject("base", info);
    	mv.addObject("qm", qm);
    	return mv;
    }
    
    /**
     * 家庭基本信息
     */
    @RequestMapping(value="/toJiaTing")
    public ModelAndView toJiaTing(JiaTingInfoQueryQM qm){
    	ModelAndView mv = new ModelAndView();
    	mv.setViewName("peopleBasicQuery/jiatingInfo");
    	Map<String, Object> info = peopleBasicQueryService.getJtJbxx(qm);
    	List<Map<String, Object>> list = peopleBasicQueryService.getJtgx(qm);
    	mv.addObject("base", info);
    	mv.addObject("list", list);
    	return mv;
    }
    
//    /**
//     * 就业情况页面
//     */
//    @RequestMapping(value="/toJiuYe")
//    public ModelAndView toJiuYe(JiuYeInfoQueryQM qm){
//    	ModelAndView mv = new ModelAndView();
//    	mv.setViewName("peopleBasicQuery/jiuyeInfo");
//    	List<JSONObject> list = peopleBasicQueryService.findBaseListBySfz(qm, "jiuYeXinXi");
//    	mv.addObject("list", list);
//    	return mv;
//    }
    
    /**
     * 社保情况页面
     */
    @RequestMapping(value="/toSheBao")
    public ModelAndView toSheBao(SheBaoInfoQueryQM qm){
    	ModelAndView mv = new ModelAndView();
    	mv.setViewName("peopleBasicQuery/shebaoInfo");
    	List<Map<String, Object>> result = peopleBasicQueryService.getSbxx(qm);
    	mv.addObject("list", result);
    	return mv;
    }
    
    
    /**
	 * 跳转到社保详情页面
	 */
	@RequestMapping(value = "/toShebaoxq")
	public ModelAndView toShebaoxq(SheBaoInfoQueryQM qm) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("peopleBasicQuery/sheBaoxqInfo");
		mv.addObject("qm", qm);
		return mv;
	}
	
	/**
	 * 个人社保详情列表
	 * @return
	 */
	@RequestMapping(value = "/shebaoxq")
	@ResponseBody
    public Object shebaoMore(PeopleBasicQueryQM qm,PagingUtil pagingUtil,HttpServletRequest request){
    	String sfzhm = request.getParameter("sfzhm");
    	qm.setSfzhm(sfzhm);
    	Map<String, ?> result = this.peopleBasicQueryService.getPageSbxxObjectBySql(qm, pagingUtil);
		return result;
    }
    
//    /**
//     * 房产情况页面
//     */
//    @RequestMapping(value="/toFangChan")	
//    public ModelAndView toFangChan(FangChanInfoQueryQM qm){
//    	ModelAndView mv = new ModelAndView();
//    	//解码身份证
//    	String sfz=Base64Util.getFromBase64(qm.getFwsyqsfz());
//    	qm.setFwsyqsfz(sfz);
//    	mv.setViewName("peopleBasicQuery/fangchanInfo");
//    	List<JSONObject> list = peopleBasicQueryService.findBaseListBySfz(qm, "fangChanXinXi");
//    	if(list!=null){
//    		for(JSONObject j:list){
//        		j.put("SFZHM", Base64Util.getBase64(j.get("SFZHM").toString()));
//        	}
//    	}
//    	mv.addObject("list", list);
//    	return mv;
//    }
    
    
    /**
     * 婚姻情况页面
     */
    @RequestMapping(value="/toHunYin")
    public ModelAndView toHunYin(HunYinInfoQueryQM qm){
    	ModelAndView mv = new ModelAndView();
    	mv.setViewName("peopleBasicQuery/hunyinInfo");
    	List<Map<String, Object>> list = peopleBasicQueryService.getHyxx(qm);
    	mv.addObject("list", list);
    	return mv;
    }
    
    /**
     * 公积金
     */
    @RequestMapping(value="/toPersonAccumFundInfo")
    public ModelAndView personAccumFundInfo(PeopleBasicQueryQM qm){
    	ModelAndView mv = new ModelAndView();
    	mv.setViewName("peopleBasicQuery/personAccumFundInfo");
    	List<Map<String, Object>> result = peopleBasicQueryService.getGjjxx(qm);
		mv.addObject("list", result);
    	return mv;
    }
    
    /**
     * 公积金列表页面
     */
    @RequestMapping(value="/toPersonAccumFundListInfo")
    public ModelAndView personAccumFundListInfo(PeopleBasicQueryQM qm){
    	ModelAndView mv = new ModelAndView();
    	mv.setViewName("peopleBasicQuery/toPersonAccumFundListInfo");
    	mv.addObject("qm", qm);
    	return mv;
    }
    
    /**
     * 获取个人公积金详情
     * @param qm
     * @return
     */
	@RequestMapping(value = "/toGJJXQ")
	@ResponseBody
    public  Object gjjMore(PeopleBasicQueryQM qm,PagingUtil pagingUtil,HttpServletRequest request){
		String sfz = request.getParameter("sfz");
    	qm.setSfz(sfz);
    	Map<String, ?> result = this.peopleBasicQueryService.getPageGjjxxObjectBySql(qm, pagingUtil);
		return result;
    }
    	
    /**
     * 查看家庭关系拓展图
     */
    @RequestMapping(value="/toRelation")
    public ModelAndView toRelation(JiaTingInfoQueryQM qm){
    	ModelAndView mv = new ModelAndView();
    	mv.setViewName("peopleBasicQuery/jiaTingGuanXiInfo");
    	PeopleBasicQueryQM base = new PeopleBasicQueryQM();
    	base.setSfz(qm.getHzsfz());
    	List<Map<String, Object>> list = peopleBasicQueryService.getJtgxtzt(qm);
    	for (Map<String, Object> map : list) {
    		if(map.get("age")==null){
    			map.put("age", 20);
    		}
    		if(map.get("code")==null){
    			map.put("code", "0");
    		}
    		if(map.get("gxrlxdh")==null){
    			map.put("gxrlxdh", "");
    		}
    		if(map.get("ybbgx")==null){
    			map.put("ybbgx", "非亲属");
    		}
    		if(map.get("xb")==null){
    			map.put("xb", "1");
    		}
		}
    	Map<String, Object> result =  peopleBasicQueryService.findBaseBySfz(qm.getHzsfz());
    	mv.addObject("list", JsonUtil.toJson(list));
    	mv.addObject("info", result);
    	return mv;
    }
    
}
