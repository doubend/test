package com.cloud.icenter.yyzx.cszc.dtzs.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONArray;
import com.cloud.icenter.base.controller.ModelAction;
import com.cloud.icenter.common.utils.JsonUtil;
import com.cloud.icenter.yyzx.common.query.CategorySum;
import com.cloud.icenter.yyzx.cszc.dtzs.pojo.CszcDetailsPojo;
import com.cloud.icenter.yyzx.cszc.dtzs.pojo.CszcInfoPojo;
import com.cloud.icenter.yyzx.cszc.tjfx.pojo.BaseInfo;
import com.cloud.icenter.yyzx.cszc.tjfx.service.BaseInfoService;
import com.cloud.icenter.yyzx.cszc.tjfx.service.RepairInfoService;

/**
 * 城市资产——gis展示
 * @author whcai
 *
 */
@Controller
@RequestMapping(value="/cszc")
public class gisShowAction extends ModelAction<BaseInfo> {
	
	
	@Autowired private BaseInfoService baseInfoService;
	
	@Autowired private RepairInfoService repairInfoService;
	
	/**
	 * 城市资产——gis展示，查询定位
	 */
	@RequestMapping(value="/gisShow",method=RequestMethod.GET)
    public String zcgl() {
    	return "cszc/assetsShow";
    }
	
	/**
	 * 城市资产——地图展示页面左侧面板树结构
	 */
	@RequestMapping(value = "/dtzs/queryCszcModelData", method = {RequestMethod.POST, RequestMethod.GET})
	public void queryCszcModelData(){
		JSONArray arrRes = baseInfoService.queryCszcModelData();
		
		String json = JsonUtil.toJson(arrRes);
		printJson(json); 
	}
	
	/**
	 * 通过部件名称查询城市资产
	 * @param zcmc
	 * @return
	 */
	@RequestMapping(value="/dtzs/queryCszcByName",method=RequestMethod.POST)
	public void queryCszcByName(String zcmc){
		List<CszcInfoPojo> dataLst = baseInfoService.queryCszcByName(zcmc);
		
		String json = JsonUtil.toJson(dataLst);
		printJson(json); 
	}
	
	/**
	 * 查询城市资产
	 * @param zcmc   资产名称
	 * @param xzqmc  行政区名称
	 * @param ztmc   状态名称
	 */
	@RequestMapping(value="/dtzs/queryCszcByZcmcAndQxAndZt",method=RequestMethod.POST)
	public void queryCszcByZcmcAndQxAndZt(String zcmc, String xzqmc, String ztmc){
		List<CszcInfoPojo> dataLst = baseInfoService.queryCszcByZcmcAndQxAndZt(zcmc, xzqmc, ztmc);
		
		String json = JsonUtil.toJson(dataLst);
		printJson(json); 
	}
	
	/**
  	* 条件查询
    */
    @RequestMapping(value="/dtzs/queryByCondition",method=RequestMethod.POST)
  	public void queryByCondition(BaseInfo param) {    
        DetachedCriteria criteria=getPagination().getCriteria();
		if(!StringUtils.isEmpty(param.getSsqy())) {
			criteria.add(Restrictions.like("xzqmc",param.getSsqy(), MatchMode.ANYWHERE));
		}
		if(!StringUtils.isEmpty(param.getSsejflbh())) {
			criteria.add(Restrictions.like("ssejflbh",param.getSsejflbh(), MatchMode.ANYWHERE));
		}
		if(!StringUtils.isEmpty(param.getZtmc()) && !param.getZtmc().equals("总数")) {
			criteria.add(Restrictions.like("state",param.getZtmc(), MatchMode.ANYWHERE));
		}
		
     	//强制不分页
        getPagination().setPage(0);
        getPagination().setPageSize(0);
        
        baseInfoService.find(getPagination());
  		printJson(getPagination());
  	}
    
    /**
     * 查询城市资产统计报表数据
     */
    @RequestMapping(value="/dtzs/queryStatisticalReport",method=RequestMethod.POST)
    public void queryStatisticalReport(String zcmc){
    	//总数
    	List<Integer> allLst = baseInfoService.getCountByZcmcAndZczt(zcmc, 0);
    	
    	//完好
    	List<Integer> whLst = baseInfoService.getCountByZcmcAndZczt(zcmc, 1);
    	
    	//破损
    	List<Integer> psLst = baseInfoService.getCountByZcmcAndZczt(zcmc, 2);
    	
    	//丢失
    	List<Integer> dsLst = baseInfoService.getCountByZcmcAndZczt(zcmc, 3);
    	
    	//占用
    	List<Integer> zyLst = baseInfoService.getCountByZcmcAndZczt(zcmc, 4);
    	
    	//待养护分布
    	List<Integer> dyhLst = baseInfoService.getCountByZcmcAndZczt(zcmc, -1);
    	
    	//累计养护次数
    	List<Integer> ljyhcsLst = repairInfoService.getLjyhcsByZcmc(zcmc);
    	
    	Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("allLst", allLst);
		jsonMap.put("whLst", whLst);
		jsonMap.put("psLst", psLst);
		jsonMap.put("dsLst", dsLst);
		jsonMap.put("zyLst", zyLst);
		jsonMap.put("dyhLst", dyhLst);
		jsonMap.put("ljyhcsLst", ljyhcsLst);
		
		String json = JsonUtil.toJson(jsonMap);
		printJson(json); 
    }
    
    /**
     * 查询学校统计报表数据
     */
    @RequestMapping(value="/dtzs/queryXxReport",method=RequestMethod.POST)
    public void queryXxReport(){
    	//获取各类型学校数量
    	List<Integer> xxlxLst = baseInfoService.getXxlxCount();
    	
    	//中学
    	List<Integer> seniorLst = baseInfoService.getSchoolCountByXxlx("中学");
    	
    	//小学
    	List<Integer> primaryLst = baseInfoService.getSchoolCountByXxlx("小学");
    	
    	//幼儿园
    	List<Integer> nurseryLst = baseInfoService.getSchoolCountByXxlx("幼儿园");
		
    	Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("xxlxLst", xxlxLst);
		jsonMap.put("seniorLst", seniorLst);
		jsonMap.put("primaryLst", primaryLst);
		jsonMap.put("nurseryLst", nurseryLst);
		
		String json = JsonUtil.toJson(jsonMap);
		printJson(json);
    }
    
    /**
     * 查询城市资产-地图展示默认页报表数据
     */
    @RequestMapping(value="/dtzs/queryCszcReport",method=RequestMethod.POST)
    public void queryCszcReport(){
    	//公用设施
    	List<Integer> gyssLst = baseInfoService.getCszcCountQyfb("公用设施");
    	
    	//交通设施
    	List<Integer> jtssLst = baseInfoService.getCszcCountQyfb("交通设施");
    	
    	//市容环境
    	List<Integer> srhjLst = baseInfoService.getCszcCountQyfb("市容环境");
    	
    	//公共单位
    	List<Integer> ggdwLst = baseInfoService.getCszcCountQyfb("公共单位");
    	
    	//其他部件
    	List<Integer> qtbjLst = baseInfoService.getCszcCountQyfb("其他部件");
    	
    	Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("gyssLst", gyssLst);
		jsonMap.put("jtssLst", jtssLst);
		jsonMap.put("srhjLst", srhjLst);
		jsonMap.put("ggdwLst", ggdwLst);
		jsonMap.put("qtbjLst", qtbjLst);
		
		String json = JsonUtil.toJson(jsonMap);
		printJson(json);
    }
    
    /**
	 * 城市资产区域分布
	 * @param zcmc
	 */
	@RequestMapping(value="/zcgk/getCszcFbByZcmc", method = {RequestMethod.POST, RequestMethod.GET})
	public void getCszcFbByZcmc(String zcmc){
		List<Integer> resLst = baseInfoService.getCountByZcmcAndZczt(zcmc, 0);
		
		String json = JsonUtil.toJson(resLst);
		printJson(json);
	}
	
	/**
	 * 城市资产近年发展
	 * @param zcmc
	 */
	@RequestMapping(value="/zcgk/getCszcRecentYears", method = {RequestMethod.POST, RequestMethod.GET})
	public void getCszcRecentYears(String zcmc){
		List<Integer> resLst = baseInfoService.getCountByZcmcAndYear(zcmc);
		
		String json = JsonUtil.toJson(resLst);
		printJson(json);
	}
	
	/**
	 * 城市资产近年发展
	 * @param zcmc
	 */
	@RequestMapping(value="/zcgk/getCszcZtfbByZcmc", method = {RequestMethod.POST, RequestMethod.GET})
	public void getCszcZtfbByZcmc(String zcmc){
		List<Integer> resLst = baseInfoService.getCszcZtfb(zcmc);
		
		String json = JsonUtil.toJson(resLst);
		printJson(json);
	}
	
	/**
	 * 资产概况详情列表
	 * @param zcmc
	 */
	@RequestMapping(value="/zcgk/getCszcDetailsList", method = {RequestMethod.POST, RequestMethod.GET})
	public void getCszcDetailsList(String zcmc){
		List<CszcDetailsPojo> resLst = baseInfoService.getCszcDetailsInfo(zcmc, "", "", "");
		
		String json = JsonUtil.toJson(resLst);
		printJson(json);
	}
	
	/**
	 * 资产概况详情列表查询
	 * @param zcmc 
	 * @param zczt
	 * @param xzqmc
	 */
	@RequestMapping(value="/zcgk/queryCszcDetailsByCondition", method = {RequestMethod.POST, RequestMethod.GET})
	public void queryCszcDetailsByCondition(String zcmc, String zymc, String zczt, String xzqmc){
		List<CszcDetailsPojo> resLst = baseInfoService.getCszcDetailsInfo(zcmc, zymc, zczt, xzqmc);
		
		String json = JsonUtil.toJson(resLst);
		printJson(json);
	}
	
	/**
	 * 获取各类城市资产数量
	 */
	@RequestMapping(value="/zcgk/getAllCszcCount", method = {RequestMethod.POST, RequestMethod.GET})
	public void getAllCszcCount(){
		List<Integer> resLst = baseInfoService.getAllCszcCount();
		
		String json = JsonUtil.toJson(resLst);
		printJson(json);
	}
	
	/**
	 * 各类型学校数量统计
	 */
	@RequestMapping(value="/zcgk/getSchoolCount", method = {RequestMethod.POST, RequestMethod.GET})
	public void getSchoolCount(){
		List<Integer> resLst = baseInfoService.getSchoolCount();
		
		String json = JsonUtil.toJson(resLst);
		printJson(json);
	}
	
	/**
	 * 教育资金分布情况
	 */
	@RequestMapping(value="/zcgk/getJyzjFbqk", method = {RequestMethod.POST, RequestMethod.GET})
	public void getJyzjFbqk(){
		List<Map<String, Object>> resMap = baseInfoService.getJyzjFbqk();
		
		String json = JsonUtil.toJson(resMap);
		printJson(json);
	}
	
	/**
	 * 学校生源分布情况
	 */
	@RequestMapping(value="/zcgk/getXxsyFbqk", method = {RequestMethod.POST, RequestMethod.GET})
	public void getXxsyFbqk(){
		List<Map<String, Object>> resMap = baseInfoService.getXxsyFbqk();
		
		String json = JsonUtil.toJson(resMap);
		printJson(json);
	}
	
	/**
	 * 教育资源与学生入学情况
	 */
	@RequestMapping(value="/zcgk/getJyzyYuXsrxQk", method = {RequestMethod.POST, RequestMethod.GET})
	public void getJyzyYuXsrxQk(){
		//小学招生人数分布情况
		List<Integer> zsrsLst = baseInfoService.getZsrsFbqk();
		//义务教育适龄人口分布情况
		List<Integer> slrkLst = baseInfoService.getSlrkFbqk();
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("zsrs", zsrsLst);
		jsonMap.put("slrk", slrkLst);
		
		String json = JsonUtil.toJson(jsonMap);
		printJson(json);
	}
    
}
