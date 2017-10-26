package com.cloud.icenter.yyzx.fzjc.hjbh.controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.icenter.base.controller.ModelAction;
import com.cloud.icenter.common.utils.JsonResult;
import com.cloud.icenter.common.utils.JsonUtil;
import com.cloud.icenter.common.utils.StringUtil;
import com.cloud.icenter.yyzx.fzjc.hjbh.pojo.AirPollution;
import com.cloud.icenter.yyzx.fzjc.hjbh.pojo.AirQualityArea;
import com.cloud.icenter.yyzx.fzjc.hjbh.pojo.AirQualityCity;
import com.cloud.icenter.yyzx.fzjc.hjbh.service.AirService;
/**
 * 空气质量
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "/hjbh/airQuality")
public class AirController extends ModelAction<AirPollution>{
	
	@Autowired
	private AirService airService;
	
	/**
	 * 获取大气污染源企业排污排名列表
	 * @param num 返回条数
	 * @return jso
	 */
	@RequestMapping(value = "/getAirPollutionList/{num}", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public JsonResult getAirPollutionList(@PathVariable int num){
		List<AirPollution> alist = airService.getAirPollutionList(num);
		return jsonResult(200, "数据获取成功", alist);
	}
	
	
	/**
	 * 如果时间为空的情况下，默认取当前向前七天数据
	 * @param sttime 开始时间
	 * @param edtime 结束时间
	 * @return json
	 * @throws ParseException 
	 */
	@RequestMapping(value = "/getAirQualityCityForSeven", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public JsonResult getAirQualityCityForSeven(@RequestParam(required=false) String sttime,
			                                    @RequestParam(required=false) String edtime)
			                                    		throws ParseException{
		List<AirQualityCity> alist = null;
		if(sttime!=null && !"".equals(sttime)&&edtime!=null && !"".equals(edtime)){
			SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
			Timestamp datest = new Timestamp(sdf.parse(sttime + " 00:00:00").getTime());
			Timestamp dateed = new Timestamp(sdf.parse(edtime + " 23:59:59").getTime());
			alist = airService.getAirQualityCityForSeven(datest, dateed);
		}else{
			alist = airService.getAirQualityCityForSeven(null, null);
		}
		return jsonResult(200, "数据获取成功", alist);
	}
	
	
	/**
	 * 根据时间获取一天内一个区域的环境数据
	 */
	@RequestMapping(value = "/getAirQualityAreaByDate", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public JsonResult getAirQualityAreaByDate(@RequestParam(required=false) String date){
		List<AirQualityArea> alist = null;
		if(date!=null && !"".equals(date)){
			alist = airService.getAirQualityAreaByDate(date);
		}else{
			alist = airService.getAirQualityAreaByDate(null);
		}
		return jsonResult(200, "数据获取成功", alist);
	}
	
	/**
	 * 获取所有时间列表
	 * @return json
	 */
	@RequestMapping(value = "/getAllDateList", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public JsonResult getAllDateList(){
		List<AirQualityArea> list = airService.getAllDateList();
		return jsonResult(200, "数据获取成功", list);
	}
	
	
	/**
	  * @author zhucy 
	  * @version 2017年6月20日 上午10:17:48 
	  * 说明:跳转到空气质量分析页面
	 */
	@RequestMapping("/toAirPage")
	public String toAirPage(){
		List<Map<String, Object>> alist = airService.getZxsj();
		if (null != alist && alist.size() > 0 ) {
			setAttribute("zxdate", alist.get(0).get("data_time").toString().replace(".0", ""));
			setAttribute("zxAqi", alist.get(0).get("aqi"));
			if (null != alist.get(0).get("aqi")) {
				int aqi = Integer.parseInt(alist.get(0).get("aqi").toString());
				String dj = "";
				String wxts = "";
				if (0 <= aqi && aqi <= 50) {
					dj = "<i class='fine1'>优</i>";
					wxts = "<div>温馨提示：空气质量令人满意，各类人群可正常活动</div>";
				}
				if (51 <= aqi && aqi <= 100) {
					dj = "<i class='fine2'>良</i>";
					wxts = "<div>温馨提示：空气质量可接受，建议极少数异常敏感人群应减少户外活动。</div>";
				}
				if (101 <= aqi && aqi <= 150) {
					dj = "<i class='fine3'>轻度污染</i>";
					wxts = "<div>温馨提示：空气质量状况属于轻度污染。易感人群症状有轻度加剧，<br/>建议儿童、老年人及心脏病、呼吸系统疾病患者应减少长时间、高强度的户外锻炼。</div>";
				}
				if (151 <= aqi && aqi <= 200) {
					dj = "<i class='fine4'>中度污染</i>";
					wxts = "<div>温馨提示：空气质量状况属于中度污染。进一步加剧易感人群症状，<br/>可能对健康人群心脏、呼吸系统有影响，建议疾病患者避免长时间、<br/>高强度的户外锻练，一般人群适量减少户外运动。</div>";
				}
				if (201 <= aqi && aqi <= 300) {
					dj = "<i class='fine5'>重度污染</i>";
					wxts = "<div>温馨提示：空气质量状况属于重度污染。心脏病和肺病患者症状显著加剧，<br/>运动耐受力降低，健康人群普遍出现症状，建议儿童、老年人和心脏病、<br/>肺病患者应停留在室内，停止户外运动，一般人群减少户外运动。</div>";
				}
				if (300 < aqi ) {
					dj = "<i class='fine6'>严重污染</i>";
					wxts = "<div>温馨提示：空气质量状况属于严重污染。健康人群运动耐受力降低，<br/>有明显强烈症状，提前出现某些疾病，建议儿童、<br/>老年人和病人应当留在室内，避免体力消耗，一般人群应避免户外活动。</div>";
				}
				setAttribute("dj", dj);
				setAttribute("wxts",wxts);
			}
		}
		return "fzjc/hjbh/airQuality";
	}

	
	
	@RequestMapping(value = "/getDataForSeven", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public JsonResult getDataForSeven(@RequestParam(required=false) String jczd,
			@RequestParam(required=false) String dateTime) throws Exception{
		List<Map<String, Object>> alist = null;
		if(!StringUtil.isEmpty(jczd)){
			alist = airService.getDataForSeven(jczd, dateTime);
		}else{
			alist = airService.getDataForSeven(null, null);
		}
		return jsonResult(200, "数据获取成功", alist);
	}
	
	@RequestMapping(value = "/getTsSsKqzl", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public Object getTsSsKqzl(){
		List<Map<String, Object>> result = this.airService.getSskqzl();
		return result;
	}
	
	@RequestMapping(value = "/getKqzlRb", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public Object getKqzlRb(){
		List<Map<String, Object>> result = this.airService.getKqzlRb();
		return result;
	}
	
	@RequestMapping(value = "/getTsSszbSj", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public Object getTsSszbSj(){
		List<Map<String, Object>> result = this.airService.getTsSszbSj();
		return result;
	}
	
	@RequestMapping(value = "/getJynTsYltsTj", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public Object getJynTsYltsTj(){
		Map<String, Object> result = this.airService.getJynTsYltsTj();
		return result;
	}
	@RequestMapping(value="/getSites",method={RequestMethod.POST,RequestMethod.GET})
	public void showQualitySite(){
		List<Map<String,Object>> siteList=airService.showQualitySite();
		printJson(JsonUtil.toJson(siteList));
	}
}
