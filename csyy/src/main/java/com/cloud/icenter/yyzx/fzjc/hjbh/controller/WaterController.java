package com.cloud.icenter.yyzx.fzjc.hjbh.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cloud.icenter.base.controller.ModelAction;
import com.cloud.icenter.common.utils.JsonResult;
import com.cloud.icenter.yyzx.fzjc.hjbh.pojo.AirQualityArea;
import com.cloud.icenter.yyzx.fzjc.hjbh.pojo.AirQualityCity;
import com.cloud.icenter.yyzx.fzjc.hjbh.pojo.WaterPollution;
import com.cloud.icenter.yyzx.fzjc.hjbh.pojo.WaterQualityArea;
import com.cloud.icenter.yyzx.fzjc.hjbh.pojo.WaterQualityCity;
import com.cloud.icenter.yyzx.fzjc.hjbh.service.WaterService;
/**
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "/hjbh/waterQuality")
public class WaterController extends ModelAction<WaterPollution>{
	
	@Autowired
	private WaterService waterService;
	
	
	/**
	 * 获取水体污染源企业排污总量排名
	 * @param num 返回条数
	 * @return jso
	 */
	@RequestMapping(value = "/getWaterPollutionList/{num}", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public JsonResult getWaterPollutionList(@PathVariable int num){
		List<WaterPollution> alist = waterService.getWaterPollutionList(num);
		return jsonResult(200, "数据获取成功", alist);
	}
	
	/**
	 * 如果时间为空的情况下，默认取当前向前七天数据
	 * @param sttime 开始时间
	 * @param edtime 结束时间
	 * @return json
	 */
	@RequestMapping(value = "/getWaterQualityCityForSeven", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public JsonResult getWaterQualityCityForSeven(@RequestParam(required=false) String sttime,
            									  @RequestParam(required=false) String edtime){
		List<WaterQualityCity> alist = null;
		if(sttime!=null && !"".equals(sttime)&&edtime!=null && !"".equals(edtime)){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String datest = sdf.format(sttime + " 00:00:00");
			String dateed = sdf.format(edtime + " 23:59:59");
			alist = waterService.getWaterQualityCityForSeven(Timestamp.valueOf(datest), Timestamp.valueOf(dateed));
		}else{
			alist = waterService.getWaterQualityCityForSeven(null, null);
		}
		return jsonResult(200, "数据获取成功", alist);
	}
	
	/**
	 * 区域水体质量排名
	 * @param date 日期
	 * @return json
	 */
	@RequestMapping(value = "/getWaterQualityAreaByDate", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public JsonResult getWaterQualityAreaByDate(@RequestParam(required=false) String date){
		List<WaterQualityArea> alist = null;
		if(date!=null && !"".equals(date)){
			alist = waterService.getWaterQualityAreaByDate(date);
		}else{
			alist = waterService.getWaterQualityAreaByDate(null);
		}
		return jsonResult(200, "数据获取成功", alist);
	}
	/**
	  * @author zhucy 
	  * @version 2017年7月19日 上午11:33:39 
	  * 说明 跳转到水质分析页面
	 */
	@RequestMapping(value="/toWaterQuality")
	public String getWaterQuality(){
		//获取河流流域
		List<String> hlfz = this.waterService.getHlfz();
		setAttribute("hlfz", hlfz);
		List<Map<String, Object>> dbsJczb = this.waterService.getDbsJczb();
		List<Map<String, Object>> yysJczb = this.waterService.getYysJczb(); 
		setAttribute("dbsJczb", dbsJczb);
		setAttribute("yysJczb", yysJczb);
 		return "/fzjc/hjbh/waterQuality";
	}
	
	/**
	  * @author zhucy 
	  * @version 2017年7月19日 下午4:20:01 
	  * 说明:监测站点获取
	 */
	@RequestMapping(value="/dbsjczd")
	@ResponseBody
	public Object dbsjczd(HttpServletRequest request){
		String ly = request.getParameter("ly");
		List<Map<String, Object>> dbsJczd = this.waterService.getDbsJczd(ly);
		JSONArray array = new JSONArray();
		JSONArray tableTh = new JSONArray();
		tableTh.add("河流");
		tableTh.add("断面");
		tableTh.add("水质类别");
		array.add(tableTh);
		for (Map<String, Object> map : dbsJczd) {
			JSONArray array1 = new JSONArray();
			array1.add(map.get("sshl"));
			array1.add(map.get("jczd"));
			array1.add(map.get("szlb"));
			array.add(array1);
		}
		return array;
	}
	
	/**
	  * @author zhucy 
	  * @version 2017年7月19日 下午4:20:01 
	  * 说明:监测站点获取
	 */
	@RequestMapping(value="/yysjczd")
	@ResponseBody
	public Object yysjczd(){
		List<Map<String, Object>> yysJczd = this.waterService.getYysJczd();
		JSONArray array1 = new JSONArray();
		JSONArray tableTh1 = new JSONArray();
		tableTh1.add("水源地名称");
		tableTh1.add("水质类别");
		array1.add(tableTh1);
		for (Map<String, Object> map : yysJczd) {
			JSONArray array2 = new JSONArray();
			array2.add(map.get("jczd"));
			array2.add(map.get("szlb"));
			array1.add(array2);
		}
		return array1;
	}
	
	@RequestMapping(value="/getJcsj")
	@ResponseBody
	public Object getJcsj(HttpServletRequest request){
		String zb = request.getParameter("zb");
		String nf = request.getParameter("nf");
		String jczd = request.getParameter("jczd");
		List<Map<String, Object>> result = this.waterService.getJcsj(jczd, zb, nf);
		return result;
	}

}
