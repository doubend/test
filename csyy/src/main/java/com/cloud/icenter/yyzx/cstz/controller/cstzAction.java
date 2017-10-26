package com.cloud.icenter.yyzx.cstz.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.cloud.icenter.base.controller.BaseAction;
import com.cloud.icenter.common.utils.JsonUtil;
import com.cloud.icenter.common.utils.StringUtil;
import com.cloud.icenter.common.utils.TreeNode;
import com.cloud.icenter.yyzx.common.util.str.ChineseUtil;
import com.cloud.icenter.yyzx.cstz.pojo.CstzAllBusPojo;
import com.cloud.icenter.yyzx.cstz.pojo.CstzCommonPojo;
import com.cloud.icenter.yyzx.cstz.pojo.CstzTzmxPojo;
import com.cloud.icenter.yyzx.cstz.pojo.ZbphPojo;
import com.cloud.icenter.yyzx.cstz.service.CstzTzmxService;
import com.cloud.icenter.yyzx.cstz.service.SignModelService;
import com.cloud.icenter.yyzx.cszc.zygl.pojo.BjmbPojo;

/**
 * 城市体征
 * @author whcai
 *
 */
@Controller
@RequestMapping(value="/cstz")
public class cstzAction extends BaseAction {

	@Autowired private SignModelService signModelService;
	@Autowired private CstzTzmxService cstzTzmxService;
	
	/**
	 * 城市体征——体征模型
	 * @return
	 */
	@RequestMapping(value="/tzmx",method=RequestMethod.GET)
    public String tzmx() {
		//获取综合体征最新日期
		Map<String, Integer> dtMap = signModelService.getTheNewestDate();
		setAttribute("dt", dtMap);
		//获取最新的体征数据
		List<CstzCommonPojo> objList = signModelService.getTheNewestSign();
		setAttribute("result", objList);
		List<CstzCommonPojo> zcList = signModelService.getZcTzsjById("1");
		setAttribute("zcList", zcList);
    	return "cstz/signModel";
    }
	
	/**
	 * 城市体征——综合体征一级
	 * @return
	 */
	@RequestMapping(value="/zhtz",method=RequestMethod.GET)
    public String zhtz() {
		//获取该体征和它的下级体征数据
		List<CstzCommonPojo> themeList = signModelService.getJuniorSignData("综合体征");
		setAttribute("themeSign", themeList);
		
		String themejson = JsonUtil.toJson(themeList);
		setAttribute("themejson", themejson);
		//指标排行重写 20170615 zhucy
		//获取四级体征占综合体征复合权重
//		List<CstzCommonPojo> lstComplexQz = signModelService.getBusSignComplexQz();
		//获取第四级体征根据体征贡献值排序后的集合(按对体征贡献升序)
//		List<CstzCommonPojo> lstSignSort = signModelService.getSignContributionSort(lstComplexQz);
		//获取最差指标Top5
//		List<CstzCommonPojo> worstLst = signModelService.getWorstTop(lstSignSort, 5);
		List<ZbphPojo> worstLst = signModelService.getZhtzYjZbphData(0);
		setAttribute("worstMap", worstLst);
		
		//获取最优指标Top5
//		List<CstzCommonPojo> optimalLst = signModelService.getOptimalTop(lstSignSort, 5);
		List<ZbphPojo> optimalLst = signModelService.getZhtzYjZbphData(1);
		setAttribute("optimalMap", optimalLst);
		
		//全部指标
//		List<CstzAllBusPojo> allBusLst = signModelService.getAllBusIndex(lstComplexQz, 5);
		List<ZbphPojo> allBusLst = signModelService.getZhtzYjZbphData(2);
		setAttribute("allBusMap", allBusLst); 
		List<CstzCommonPojo> zcList = signModelService.getZcTzsjById("1");
		setAttribute("zcList", zcList);
		
		
		
    	return "cstz/generalSigns1";
    }
	
	@RequestMapping(value="/toGeneralSigns2",method=RequestMethod.GET)
	public String toGeneralSigns2(HttpServletRequest request){
		String tzmc = request.getParameter("tzmc");
		if (ChineseUtil.isMessyCode(tzmc)) {
			try {
				tzmc = new String(tzmc.getBytes("ISO8859-1"), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
		}
		//获取最差指标Top3
//		List<CstzCommonPojo> worstLst = signModelService.getWorstTop(mapSignSort, 3);
		List<ZbphPojo> worstLst = signModelService.geteZhtzEjZbphData(tzmc, 0);
		setAttribute("worstMap", worstLst);
		//获取最优指标Top3
//		List<CstzCommonPojo> optimalLst = signModelService.getOptimalTop(mapSignSort, 3);
		List<ZbphPojo> optimalLst = signModelService.geteZhtzEjZbphData(tzmc, 1);
		setAttribute("optimalMap", optimalLst);
		//全部指标
//		List<CstzAllBusPojo> allBusLst = signModelService.getAllBusIndex(mapComplexQz, 3);
		List<ZbphPojo> allBusLst = signModelService.geteZhtzEjZbphData(tzmc, 2);
		setAttribute("allBusMap", allBusLst); 
		setAttribute("tzmc", tzmc);
		List<CstzCommonPojo> zcList = signModelService.getZcTzsjByName(tzmc);
		setAttribute("zcList", zcList);
		return "cstz/generalSigns2";
	}
	
	
	/**
	 * 城市体征——综合体征二级
	 * @return
	 */
	@RequestMapping(value="/zhtzTwo", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
    public void zhtzTwo(String tzmc) {
		if (ChineseUtil.isMessyCode(tzmc)) {
			try {
				tzmc = new String(tzmc.getBytes("ISO8859-1"), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
		}
		//获取该体征和它的下级体征数据
		List<CstzCommonPojo> lstJunior = signModelService.getJuniorSignData(tzmc);
		
		//指标排行重写 20170616 zhucy
		//获取四级体征占综合体征复合权重
//		List<CstzCommonPojo> mapComplexQz = signModelService.getComplexQzByTzmc(tzmc);
		//获取第四级体征根据体征贡献值排序后的集合(按对体征贡献升序)
//		List<CstzCommonPojo> mapSignSort = signModelService.getSignContributionByTzmc(mapComplexQz, tzmc);
		//获取最差指标Top3
//		List<CstzCommonPojo> worstLst = signModelService.getWorstTop(mapSignSort, 3);
//		List<ZbphPojo> worstLst = signModelService.geteZhtzEjZbphData(tzmc, 0);
//		//获取最优指标Top3
////		List<CstzCommonPojo> optimalLst = signModelService.getOptimalTop(mapSignSort, 3);
//		List<ZbphPojo> optimalLst = signModelService.geteZhtzEjZbphData(tzmc, 1);
//		//全部指标
////		List<CstzAllBusPojo> allBusLst = signModelService.getAllBusIndex(mapComplexQz, 3);
//		List<ZbphPojo> allBusLst = signModelService.geteZhtzEjZbphData(tzmc, 2);

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("junior", lstJunior);
//		jsonMap.put("worstMap", worstLst);
//		jsonMap.put("optimalMap", optimalLst);
//		jsonMap.put("allBusMap", allBusLst);

		String json = JsonUtil.toJson(jsonMap);
		printJson(json); 
    }
	
	/**
	 * 城市体征——专题体征一级(菜单)
	 * @return
	 */
	@RequestMapping(value="/zttzOne/{tzID}",method=RequestMethod.GET)
	public String zttzOne(@PathVariable String tzID){	
		setAttribute("tzID", tzID);
		
		return "cstz/specialSign";
	}
	
	/**
	 * 城市体征——专题体征一级
	 * @return
	 */
	@RequestMapping(value="/zttz/{tzID}",method=RequestMethod.GET)
    public String zttz(@PathVariable String tzID) {
		//获取该体征和它的下级体征数据
		List<CstzCommonPojo> lstJunior = signModelService.getJuniorSignDataByID(tzID);
		String juniorjson = JsonUtil.toJson(lstJunior);
		setAttribute("subSign", juniorjson);
		
		//获取指标排行数据
//		List<CstzCommonPojo> rankMap = signModelService.getZttzOneIndexRank(tzID);
		List<ZbphPojo> rankMap = signModelService.getZttzOneIndexRankNew(tzID);
//		String rankjson = JsonUtil.toJson(rankMap);
//		setAttribute("rankMap", rankjson);
		setAttribute("rankMap", rankMap);
		setAttribute("tzID",tzID);
		
    	return "cstz/specialSigns1";
    }
	
	/**
	 * 城市体征——专题体征二级(业务指标)
	 * @return
	 */
	@RequestMapping(value="/zttzTwo/{tzID}", method = {RequestMethod.POST, RequestMethod.GET})
    public String zttzTwo(@PathVariable String tzID) {
		//获取专题体征二级页面数据
		List<CstzCommonPojo> resData = signModelService.getZttzTwoData(tzID);
		if (null != resData && resData.size() > 0 ) {
			String dw = resData.get(0).getSjdw();
			String px = "style=\"padding-right:18px;\"";
			if (!StringUtil.isEmpty(dw)) {
				if (dw.length() == 1) {
					px = "style=\"padding-right:18px;\"";;
				}else if (dw.length() > 1 && dw.length() <= 3) {
					px = "style=\"padding-right:40px;\"";;
				}else {
					px = "style=\"padding-right:70px;\"";;
				}
				
			}
			setAttribute("px", px);
			setAttribute("dw", dw);
			setAttribute("sjly", resData.get(0).getSjly());
			setAttribute("sjpl", resData.get(0).getSjpl());
			String resJson = JsonUtil.toJson(resData);
			setAttribute("resJson", resJson);
		}

    	return "cstz/specialSigns2";
    }
	
	/**
	 * 城市体征——历史体征
	 * @return
	 */
	@RequestMapping(value="/lstz", method = {RequestMethod.POST, RequestMethod.GET})
    public String lstz() {
		//获取综合体征最新日期
		Map<String, Integer> dtMap = signModelService.getTheNewestDate();
		setAttribute("dt", dtMap);
		//获取最新综合体征数据
		List<CstzCommonPojo> zhtzLst = signModelService.getNewestZhtzData("综合体征");
		//setAttribute("zhtzMap", zhtzLst);
		String zhtzJson = JsonUtil.toJson(zhtzLst);
		setAttribute("zhtzMapJson", zhtzJson);
		/*
		//综合历史体征
		List<Float> lstZhtz = signModelService.getLstzByIdAndYear('1', 2016);
		//基础设施历史体征
		List<Float> lstJcss = signModelService.getLstzByIdAndYear('2', 2016);
		//交通出行历史体征
		List<Float> lstJtcx = signModelService.getLstzByIdAndYear('3', 2016);
		//公共安全历史体征
		List<Float> lstGgaq = signModelService.getLstzByIdAndYear('4', 2016);
		//生态环境历史体征
		List<Float> lstSthj = signModelService.getLstzByIdAndYear('5', 2016);
		
		Map<String, Object> lstzMap = new HashMap<String, Object>();
		lstzMap.put("zhLstz", lstZhtz);
		lstzMap.put("jcssLstz", lstJcss);
		lstzMap.put("jtcxLstz", lstJtcx);
		lstzMap.put("ggaqLstz", lstGgaq);
		lstzMap.put("sthjLstz", lstSthj);
		String json = JsonUtil.toJson(lstzMap);
		setAttribute("lstzMap", json);
		*/
    	return "cstz/historySign";
    }
	
	/**
	 * 城市体征——指标管理
	 * @return
	 */
	@RequestMapping(value="/zbgl",method=RequestMethod.GET)
    public String zbgl() {
    	return "cstz/thresholdConfig";
    }
	
	//**********************************************************************************//
	
	/**
	 * 查询城市体征模型数据
	 * @return
	 */
	@RequestMapping(value = "/queryCstzModelData", method = {RequestMethod.POST, RequestMethod.GET})
	public void queryCstzModelData(){
		JSONArray arrRes = signModelService.queryCstzModelData();
		
		String json = JsonUtil.toJson(arrRes);
		printJson(json); 
	}
	
	/**
	 * 根据体征ID和年份查询历史体征值
	 * @param signID
	 * @param nf
	 */
//	@RequestMapping(value = "/queryLstzByIdAndYear", method = RequestMethod.POST)
//	public void queryLstzByIdAndYear(String tzID, int nf) {
//		List<Double> lstValue = signModelService.getLstzByIdAndYear(tzID, nf);
//		String json = JsonUtil.toJson(lstValue);
//		printJson(json);
//	}
	
	@RequestMapping(value = "/queryLstzByIdAndYear", method = RequestMethod.POST)
	public void queryLstzByIdAndYear(String tzID, int nf) {
		Map<String, Object> lstValue = signModelService.getLstzByIdAndYear(tzID, nf);
		printJson(lstValue);
	}
	
	/**
	 * 根据体征名称和年份查询历史体征值
	 * @param signID
	 * @param nf
	 */
//	@RequestMapping(value = "/queryLstzByNameAndYear", method = RequestMethod.POST)
//	public void queryLstzByNameAndYear(String tzmc, int nf) {
//		List<Double> lstValue = signModelService.getLstzByNameAndYear(tzmc, nf);
//		String json = JsonUtil.toJson(lstValue);
//		printJson(json);
//	}
	
	@RequestMapping(value = "/queryLstzByNameAndYear", method = RequestMethod.POST)
	public void queryLstzByNameAndYear(String tzmc, int nf) {
		if (ChineseUtil.isMessyCode(tzmc)) {
			try {
				tzmc = new String(tzmc.getBytes("ISO8859-1"), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
		}
		Map<String, Object> lstValue = signModelService.getLstzByNameAndYear(tzmc, nf);
		printJson(lstValue);
	}
	
	/**
	 * 根据不同index获取不同视图
	 * @param tzmc   
	 * @param nf
	 * @param index
	 */
	@RequestMapping(value = "/queryLstzByIndex", method = RequestMethod.POST)
	public void queryLstzByIndex(String tzmc, int nf, int index){
		if (index == 2) {//年
			queryLstzByNameAndYear(tzmc, nf);
		}else{//日和月
			if (ChineseUtil.isMessyCode(tzmc)) {
				try {
					tzmc = new String(tzmc.getBytes("ISO8859-1"), "UTF-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				};
			}
			Map<String, Object> result = this.signModelService.getLstzByIndex(tzmc, nf, index);
			printJson(result);
		}
	}
	
	@RequestMapping(value = "/queryLstzByIndexAndId", method = RequestMethod.POST)
	public void queryLstzByIndexAndId(int index, String tzID, int nf){
		if (index == 2) {//年
			queryLstzByIdAndYear(tzID, nf);
		}else{//日和月
			Map<String, Object> result = this.signModelService.getLstzByIndexById(tzID, nf, index);
			printJson(result);
		}
	}
	
	@RequestMapping(value = "/getXByYear", method = RequestMethod.POST)
	public void getXByYear(int nf){
		List<String> list = new ArrayList<String>();
		for (int i = 1; i < 13; i++) {
			String str = nf+"年"+i+"月";
			list.add(str);
		}
		printJson(list);
	}
	
	@RequestMapping(value="/queryTzmxTree",method=RequestMethod.POST)
	@ResponseBody
	public Object query(HttpServletRequest request ) {
		String tzID = request.getParameter("tzID");
		if (StringUtil.isEmpty(tzID)) {
			tzID = "6";
		}
		CstzTzmxPojo cstzTzmxPojo = this.cstzTzmxService.get(tzID);
		//得到一级数据
		List<CstzTzmxPojo> cstzTzmxPojos=cstzTzmxService.getChildren("1", "0");
		List<TreeNode> treeNodes = this.treeZh(this.treeHanle(cstzTzmxPojos,tzID,cstzTzmxPojo.getParentId()),tzID,cstzTzmxPojo.getParentId());
		return treeNodes;
	}
	
	public List<TreeNode> treeZh(List<TreeNode> tree,String tzID,String pId){
		for (TreeNode treeNode : tree) {
			List<CstzTzmxPojo> childrenList=cstzTzmxService.getChildren(treeNode.getAttributes().get("id").toString(), "0");
			if (null != childrenList && childrenList.size() > 0 ) {
				List<TreeNode> childrenTree = this.treeHanle(childrenList,tzID,pId);
				treeNode.setChildren(childrenTree);
				this.treeZh(childrenTree,tzID,pId);
			}
		}
		return tree;
	}
	
	public List<TreeNode> treeHanle(List<CstzTzmxPojo> cstzTzmxPojos,String tzID,String pId){
		List<TreeNode> tree=new ArrayList(cstzTzmxPojos.size());
		for(CstzTzmxPojo f:cstzTzmxPojos) {
			TreeNode node=new TreeNode();
			node.setId(f.getId());
			node.setText(f.getTzmc());
			if (f.getTzlx().equals("1")) {//二级体征图标设置
				if (f.getId().equals("2")) {//基础设施
					node.setIconCls("ifont ifont-gear-o");
				}
				if (f.getId().equals("3")) {//交通出行
					node.setIconCls("ifont ifont-car-o");
				}
				if (f.getId().equals("4")) {//公共安全
					node.setIconCls("ifont ifont-shield-o");
				}
				if (f.getId().equals("5")) {//生态环境
					node.setIconCls("ifont ifont-globe-o");
				}
				if (!f.getId().equals(pId)) {
					node.setState(TreeNode.STATE_CLOSED);
				}
			}
			if (f.getTzlx().equals("2")) {//三级体征图标设置
				node.setIconCls("fa fa-table");
			}
			if (f.getTzlx().equals("2") && !f.getId().equals(tzID)) {
				node.setState(TreeNode.STATE_CLOSED);
			}
			if (f.getTzlx().equals("3")) {
				node.setIconCls("fa fa-building");
				
			}
			
			node.getAttributes().put("name", f.getTzmc());
			node.getAttributes().put("id", f.getId());
			node.getAttributes().put("level", f.getTzlx());
			tree.add(node);
		}
		return tree;
	}
}
