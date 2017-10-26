package com.cloud.icenter.yyzx.ztfx.jtcx.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cloud.icenter.base.controller.BaseAction;
import com.cloud.icenter.common.utils.JsonResult;
import com.cloud.icenter.common.utils.JsonUtil;
import com.cloud.icenter.common.utils.StringUtil;
import com.cloud.icenter.yyzx.ztfx.jtcx.pojo.GjcPojo;
import com.cloud.icenter.yyzx.ztfx.jtcx.pojo.GjcsdPojo;
import com.cloud.icenter.yyzx.ztfx.jtcx.pojo.GjxlPojo;
import com.cloud.icenter.yyzx.ztfx.jtcx.pojo.GjzbPojo;
import com.cloud.icenter.yyzx.ztfx.jtcx.service.GjcsdService;
import com.cloud.icenter.yyzx.ztfx.jtcx.service.JtcxService;
import com.sun.org.apache.xpath.internal.axes.HasPositionalPredChecker;

/**
 * 交通出行后台
 * 
 * @author dbchega
 */
@Controller
@RequestMapping(value = "/jtcx")
@SuppressWarnings("all") 
public class JtcxAction extends BaseAction {

	@Autowired
	private JtcxService jtcxService;
	@Autowired
	private GjcsdService gjcsdService;
	/**
	 * 专题分析——交通出行——公交线路分析
	 * @return
	 */
	@RequestMapping(value="/busline",method=RequestMethod.GET)
	public String busline(){
		return "ztfx/jtcx/busline";
	}
	/**
	 * 专题分析——交通出行——公交线路分析
	 * @return
	 */
	@RequestMapping(value="/ydfx",method=RequestMethod.GET)
	public String ydfx(){
		return "ztfx/jtcx/buslineCongestion";
	}
	/**
	 * 专题分析-交通出行-公交车
	 * 
	 * @return
	 */
	@RequestMapping(value = "/gjc", method = RequestMethod.GET)
	public String gjc() {
		List<GjcPojo> gjcList = jtcxService.getSixYear();

		String year = "";
		String renci = "";
		String ka = "";
		String wanren = "";
		String xianlu = "";
		String fendan = "";

		for (GjcPojo pojo : gjcList) {
			year += pojo.getYear() + ",";
			renci += pojo.getRenci() + ",";
			ka += pojo.getKa() + ",";
			wanren += pojo.getWanren() + ",";
			xianlu += pojo.getXianlu() + ",";
			fendan += pojo.getFendan() + ",";
		}

		setAttribute("year", "[" + year.substring(0, year.length() - 1) + "]");
		setAttribute("renci", "[" + renci.substring(0, renci.length() - 1)
				+ "]");
		setAttribute("ka", "[" + ka.substring(0, ka.length() - 1) + "]");
		setAttribute("wanren", "[" + wanren.substring(0, wanren.length() - 1)
				+ "]");
		setAttribute("xianlu", "[" + xianlu.substring(0, xianlu.length() - 1)
				+ "]");
		setAttribute("fendan", "[" + fendan.substring(0, fendan.length() - 1)
				+ "]");

		List<GjzbPojo> gjzbList = jtcxService.getCurGjzb();
		setAttribute("gjzbList", gjzbList);

		List<GjxlPojo> gjxlList = jtcxService.getAll();
		setAttribute("gjxlList", gjxlList);
		setAttribute("gjxlJson", JsonUtil.toJson(gjxlList));
		setAttribute("curline", gjxlList.get(0));

		return "ztfx/jtcx/traffic";
	}
	
	
	/**
	 * 每条线站点停车时间
	 * @param name
	 * @param dir
	 */
	@RequestMapping(value = "/getStopTmeList", method = RequestMethod.POST)
	public void getStopTmeList(String name,String dir){
		List<?> list = jtcxService.getStopTimeList(name,dir);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("wbjList", list);
		String json = JsonUtil.toJson(map);
		printJson(json);
		
	}
	
	
	/**
	 * 公交线路覆盖情况
	 * @param name
	 * @param dir
	 * @return
	 */
	@RequestMapping(value = "/getGjxlList", method = RequestMethod.POST)
	@ResponseBody
	public Object getGjxlList(String name,String dir){
		List<Map<String,Object>> list = jtcxService.getGjxlList(name,dir);
		JSONArray array = new JSONArray();
		JSONArray array2 = new JSONArray();
		array2.add("站名");
        array2.add("条数");
        array2.add("线路名称");
        array.add(array2);
		for (Map<String, Object> map : list) {
			JSONArray array1 = new JSONArray();
			String str = (String) map.get("xl");
			String newStr= "";
	    	String aa [] = str.split(",");
	        int j = 0;
	        for (int i = 0; i < aa.length; i++) {
				j = aa[i].indexOf("路");
				newStr += aa[i].substring(0, j)+",";

			}
	        newStr = newStr.substring(0,newStr.length()-1);	 

	        map.put("xl", newStr);
	        array1.add(map.get("name"));
	        array1.add(map.get("count"));
	        array1.add(map.get("xl").toString().split(","));
	        array.add(array1);
		}

		return array;
	}
	
	
	/**
	 * 平均速度
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getPjsdList", method = RequestMethod.POST)
	@ResponseBody
	public Object getPjsdList(HttpServletRequest request){

		String name = request.getParameter("name");
		String dir = request.getParameter("dir");
		//String ydsj = this.gjcsdService.getPjsdList(name);
		String ydsj = this.gjcsdService.getPjsdList(name,dir);
		
		if (StringUtil.isEmpty(ydsj)) {
			return "";
		}
		return ydsj;
	}
	
	
	/**
	 * 获得所需要的站点名称
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getZmList", method = RequestMethod.POST)
	@ResponseBody
	public Object getZmList(HttpServletRequest request){

		String name = request.getParameter("name");
		String dir = request.getParameter("dir");
		List<Map<String,Object>> list = this.gjcsdService.getZmList(name,dir);
//		JSONArray array1 = new JSONArray();
//		List<String> ayy = new ArrayList<String>();
//			for (Map<String, Object> map : list) {
//	 		 
//				 ayy.add((String) map.get("name"));
//			}
//			array1.add(ayy);
		return list;
	}
	
	/**
	 * 专题分析——交通出行——出租车分析
	 * @return
	 */
	@RequestMapping(value="/getTaxi",method=RequestMethod.GET)
	public String getTaxi(){
		return "ztfx/jtcx/taxi";
	}
	
	
	/**
	 * 出租车的空载率
	 */
	@RequestMapping(value="/getKzlList", method = RequestMethod.POST)
	@ResponseBody
	public Object getKzlList(){
		
		List<Map<String,Object>> list = this.jtcxService.getKzlList();
		List<String> xqy = new ArrayList<String>();
		List<String> zb2 = new ArrayList<String>();
		List<String> zb3 = new ArrayList<String>();
		List<String> zb4 = new ArrayList<String>();
		List<String> zb5 = new ArrayList<String>();
		List<String> zb6 = new ArrayList<String>();
		List<String> zb7 = new ArrayList<String>();
		
		for (Map<String, Object> map : list) {
			
			// System.out.println(map.get("xq").toString());
			 String str = map.get("xq").toString();
			if(str.equals("星期一")){
				xqy.add(map.get("zb").toString());
				
			}
			if(str.equals("星期二")){
				zb2.add(map.get("zb").toString());
			}
			if(str.equals("星期三")){
				zb3.add(map.get("zb").toString());
			}
			if(str.equals("星期四")){
				zb4.add(map.get("zb").toString());
			}
			if(str.equals("星期五")){
				zb5.add(map.get("zb").toString());
			}
			if(str.equals("星期六")){
				zb6.add(map.get("zb").toString());
			}
			if(str.equals("星期日")){
				zb7.add(map.get("zb").toString());
			}
			
		}
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("xq1", xqy);
		map.put("xq2", zb2);
		map.put("xq3", zb3);
		map.put("xq4", zb4);
		map.put("xq5", zb5);
		map.put("xq6", zb6);
		map.put("xq7", zb7);
		return map;        
		
	}
	/**
	 * 出租车的平均速度
	 * @return
	 */
	@RequestMapping(value="/getSpeedList", method = RequestMethod.POST)
	@ResponseBody
	public Object getSpeedList(){
		//工作日的平均速度
		List<Object> workList = this.jtcxService.getWorkSpeedList();
		//周末的平均速度
		List<Object> weekList = this.jtcxService.getWeekSpeedList();
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("work", workList);
		map.put("week", weekList);
		return map;
		
	}
	
	
	/**
	 * 出租车平均营收情况
	 * @return
	 */
	@RequestMapping(value="/getYsList", method = RequestMethod.POST)
	@ResponseBody
	public Object getYsList(){
		List<Object> t1 = this.jtcxService.getYsList();
		return t1;
	}
	
	/**
	 * 出租车实时载客状态统计
	 * @return
	 */
	@RequestMapping(value="/getZkDkList", method = RequestMethod.POST)
	@ResponseBody
	public Object getZkDkList(HttpServletRequest request){
		String hour = request.getParameter("hour");
		List<Map<String, Object>> list = this.jtcxService.getZkDkList(hour);
		List<Map<String, Object>> ssList = this.jtcxService.getSsZkDkList(hour);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("list", list);
		map.put("ssList", ssList);
		return map;
	}
	
	
	/**
	 * 专题分析——交通出行——出租车OD分析
	 * @return
	 */
	@RequestMapping(value="/getTaxiOD",method=RequestMethod.GET)
	public String getTaxiOD(){
		return "ztfx/jtcx/taxiOD";
	}
	
	@RequestMapping(value="/getTaxiSxxList", method = RequestMethod.POST)
	@ResponseBody
	public Object getTaxiSxxList(HttpServletRequest request){
		String type = request.getParameter("name");
		//上客点
		List<Object> skd  = this.jtcxService.getTaxiSkdList(type);
		//下客点
		List<Object> xkd  = this.jtcxService.getTaxiXkdList(type);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("skd", skd);
		map.put("xkd", xkd);
		return map;
	}
	@RequestMapping(value="/getJjrList", method = RequestMethod.POST)
	@ResponseBody
	public Object getJjrList(HttpServletRequest request){
		String type = request.getParameter("name");
		//上客点
		List<Object> skd  = this.jtcxService.getTaxiSkdList(type);
		//下客点
		List<Object> xkd  = this.jtcxService.getTaxiXkdList(type);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("skd", skd);
		map.put("xkd", xkd);
		return map;
	}
	
}
