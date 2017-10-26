package com.cloud.icenter.yyzx.ztfx.jzfp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cloud.icenter.base.controller.BaseAction;
import com.cloud.icenter.common.utils.JsonUtil;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpJzfpPkcPojo;
import com.cloud.icenter.yyzx.ztfx.jzfp.pojo.PoorPlanPojo;
import com.cloud.icenter.yyzx.ztfx.jzfp.pojo.PoorPopulationPojo;
import com.cloud.icenter.yyzx.ztfx.jzfp.pojo.PoorStatisPojo;
import com.cloud.icenter.yyzx.ztfx.jzfp.pojo.PoorStrategyPojo;
import com.cloud.icenter.yyzx.ztfx.jzfp.pojo.PoorSurveyPojo;
import com.cloud.icenter.yyzx.ztfx.jzfp.service.JZFPService;

/**
 * 精准扶贫后台
 * 
 * @author dbchega
 */
@Controller
@RequestMapping(value = "/jzfp")
public class JZFPAction extends BaseAction {

	@Autowired
	private JZFPService jzfpService;

	/**
	 * 专题分析-精准扶贫-脱贫规划
	 * 
	 * @return
	 */
	@RequestMapping(value = "/tpgh", method = RequestMethod.GET)
	public String tpgh() {
		PoorSurveyPojo ps = jzfpService.getCurSurvey();
		List<PoorStrategyPojo> poorStrategyList = jzfpService.getCurStrategy();
		List<PoorStatisPojo> poorReasonList = jzfpService.getCurStatis(1);

		// 贫困概况
		setAttribute("poorStrategyList", poorStrategyList);

		// 致贫原因
		setAttribute("poorReasonList", JsonUtil.toJson(poorReasonList));

		// 脱贫策略
		setAttribute("ps", ps);

		getGeo();

		getPKTZ();
		getPlanBin();

		return "ztfx/jzfp/poorPlan";
	}

	private void getGeo() {
		// 贫困村地图分布
		int type = 0;
		int year = 2016;
		List<DpJzfpPkcPojo> pkc0List_0 = jzfpService.gePkcByYear(type, year);
		List<DpJzfpPkcPojo> pkc1List_0 = jzfpService.gePkcByYear(++type, year);
		List<DpJzfpPkcPojo> pkc2List_0 = jzfpService.gePkcByYear(++type, year);
		setAttribute("pkc0List_0", JsonUtil.toJson(pkc0List_0));
		setAttribute("pkc1List_0", JsonUtil.toJson(pkc1List_0));
		setAttribute("pkc2List_0", JsonUtil.toJson(pkc2List_0));

		type = 0;
		year++;
		List<DpJzfpPkcPojo> pkc0List_1 = jzfpService.gePkcByYear(type, year);
		List<DpJzfpPkcPojo> pkc1List_1 = jzfpService.gePkcByYear(++type, year);
		List<DpJzfpPkcPojo> pkc2List_1 = jzfpService.gePkcByYear(++type, year);
		setAttribute("pkc0List_1", JsonUtil.toJson(pkc0List_1));
		setAttribute("pkc1List_1", JsonUtil.toJson(pkc1List_1));
		setAttribute("pkc2List_1", JsonUtil.toJson(pkc2List_1));

		type = 0;
		year++;
		List<DpJzfpPkcPojo> pkc0List_2 = jzfpService.gePkcByYear(type, year);
		List<DpJzfpPkcPojo> pkc1List_2 = jzfpService.gePkcByYear(++type, year);
		List<DpJzfpPkcPojo> pkc2List_2 = jzfpService.gePkcByYear(++type, year);
		setAttribute("pkc0List_2", JsonUtil.toJson(pkc0List_2));
		setAttribute("pkc1List_2", JsonUtil.toJson(pkc1List_2));
		setAttribute("pkc2List_2", JsonUtil.toJson(pkc2List_2));

		type = 0;
		year++;
		List<DpJzfpPkcPojo> pkc0List_3 = jzfpService.gePkcByYear(type, year);
		List<DpJzfpPkcPojo> pkc1List_3 = jzfpService.gePkcByYear(++type, year);
		List<DpJzfpPkcPojo> pkc2List_3 = jzfpService.gePkcByYear(++type, year);
		setAttribute("pkc0List_3", JsonUtil.toJson(pkc0List_3));
		setAttribute("pkc1List_3", JsonUtil.toJson(pkc1List_3));
		setAttribute("pkc2List_3", JsonUtil.toJson(pkc2List_3));

		type = 0;
		year++;
		List<DpJzfpPkcPojo> pkc0List_4 = jzfpService.gePkcByYear(type, year);
		List<DpJzfpPkcPojo> pkc1List_4 = jzfpService.gePkcByYear(++type, year);
		List<DpJzfpPkcPojo> pkc2List_4 = jzfpService.gePkcByYear(++type, year);
		setAttribute("pkc0List_4", JsonUtil.toJson(pkc0List_4));
		setAttribute("pkc1List_4", JsonUtil.toJson(pkc1List_4));
		setAttribute("pkc2List_4", JsonUtil.toJson(pkc2List_4));
	}

	/**
	 * 专题分析-精准扶贫-贫困概况
	 * 
	 * @return
	 */
	@RequestMapping(value = "/pkgk", method = RequestMethod.GET)
	public String pkgk() {
		PoorSurveyPojo ps = jzfpService.getCurSurvey();
		List<PoorStrategyPojo> poorStrategyList = jzfpService.getCurStrategy();
		List<PoorStatisPojo> poorReasonList = jzfpService.getCurStatis(1);

		// 贫困概况
		setAttribute("poorStrategyList", poorStrategyList);

		// 致贫原因
		setAttribute("poorReasonList", JsonUtil.toJson(poorReasonList));

		// 脱贫策略
		setAttribute("ps", ps);

		getPKRKGZ();
		getPKTZ();
		getPlan();

		return "ztfx/jzfp/poorPeople";
	}

	private void getPKRKGZ() {
		List<PoorPopulationPojo> ppList = jzfpService.getCurPopulationFiveYear();

		String pp_year = "";
		String pp_pooring = "";
		String pp_poored = "";
		for (PoorPopulationPojo pp : ppList) {
			pp_year += pp.getYear() + ",";
			pp_pooring += pp.getPooring() + ",";
			pp_poored += pp.getPoored() + ",";
		}
		// 贫困人口跟踪
		setAttribute("pp_year", "[" + pp_year.substring(0, pp_year.length() - 1) + "]");
		setAttribute("pp_pooring", "[" + pp_pooring.substring(0, pp_pooring.length() - 1) + "]");
		setAttribute("pp_poored", "[" + pp_poored.substring(0, pp_poored.length() - 1) + "]");
	}

	private void getPKTZ() {
		List<PoorStatisPojo> incomeList = jzfpService.getCurStatis(2);
		List<PoorStatisPojo> poorTypeList = jzfpService.getCurStatis(3);
		List<PoorStatisPojo> ablityList = jzfpService.getCurStatis(4);
		List<PoorStatisPojo> houseList = jzfpService.getCurStatis(5);

		String incomeData = "";
		String incomeType = "";
		int i = 0;
		for (PoorStatisPojo income : incomeList) {
			incomeData += "[" + (++i) + "," + income.getPopulations() + "],";
			incomeType += "\"" + income.getType_name() + "\",";
		}

		String poorType = "";
		String poorTypeData = "";
		i = 0;
		for (PoorStatisPojo pojo : poorTypeList) {
			poorType += "\"" + pojo.getType_name() + "\",";
			poorTypeData += "[" + (++i) + "," + pojo.getPopulations() + "],";
		}

		String ablityType = "";
		String ablityData = "";
		i = 0;
		for (PoorStatisPojo pojo : ablityList) {
			ablityType += "\"" + pojo.getType_name() + "\",";
			ablityData += "[" + (++i) + "," + pojo.getPopulations() + "],";
		}

		String houseType = "";
		String houseData = "";
		i = 0;
		for (PoorStatisPojo pojo : houseList) {
			houseType += "\"" + pojo.getType_name() + "\",";
			houseData += "[" + (++i) + "," + pojo.getPopulations() + "],";
		}
		// 贫困特征-年收入
		setAttribute("incomeData", "[" + incomeData.substring(0, incomeData.length() - 1) + "]");
		setAttribute("incomeType", "[" + incomeType.substring(0, incomeType.length() - 1) + "]");
		// 贫困特征-贫困类型
		setAttribute("poorTypeData", "[" + poorTypeData.substring(0, poorTypeData.length() - 1) + "]");
		setAttribute("poorType", "[" + poorType.substring(0, poorType.length() - 1) + "]");
		// 贫困特征-脱贫能力
		setAttribute("ablityData", "[" + ablityData.substring(0, ablityData.length() - 1) + "]");
		setAttribute("ablityType", "[" + ablityType.substring(0, ablityType.length() - 1) + "]");
		// 贫困特征-家庭人口
		setAttribute("houseData", "[" + houseData.substring(0, houseData.length() - 1) + "]");
		setAttribute("houseType", "[" + houseType.substring(0, houseType.length() - 1) + "]");
	}

	private void getPlan() {
		List<PoorPlanPojo> planList = jzfpService.getSSWPlan();

		String regon = "[ \"武山县\", \"清水县\", \"秦州区\", \"秦安县\", \"张家川\", \"麦积区\", \"甘谷县\"]";
		String regon_2016 = "";
		String regon_2017 = "";
		String regon_2018 = "";
		String regon_2019 = "";
		String regon_2020 = "";

		String reason = "[ \"武山县\", \"清水县\", \"秦州区\", \"秦安县\", \"张家川\", \"麦积区\", \"甘谷县\"]";
		String reason_2016 = "";
		String reason_2017 = "";
		String reason_2018 = "";
		String reason_2019 = "";
		String reason_2020 = "";
		List<Integer> years = new ArrayList<Integer>();
		for (PoorPlanPojo pojo : planList) {
			String regen_str = "[" + pojo.getWushan() + "," + pojo.getQingshui() + "," + pojo.getQinzhou() + ","
					+ pojo.getQinan() + "," + pojo.getZhangjiachuan() + "," + pojo.getMaiji() + "," + pojo.getGangu()
					+ "]";
			String reason_str = "[" + pojo.getChanye() + "," + pojo.getZijin() + "," + pojo.getShehui() + ","
					+ pojo.getJishu() + "," + pojo.getYdbq() + "," + pojo.getBzjz() + "," + pojo.getStandby5() + "]";
			if (pojo.getYear() == 2016) {
				regon_2016 = regen_str;
				reason_2016 = reason_str;
			} else if (pojo.getYear() == 2017) {
				regon_2017 = regen_str;
				reason_2017 = reason_str;
			} else if (pojo.getYear() == 2018) {
				regon_2018 = regen_str;
				reason_2018 = reason_str;
			} else if (pojo.getYear() == 2019) {
				regon_2019 = regen_str;
				reason_2019 = reason_str;
			} else if (pojo.getYear() == 2020) {
				regon_2020 = regen_str;
				reason_2020 = reason_str;
			}
			years.add(pojo.getYear());

		}

		setAttribute("plan", planList.get(0));
		setAttribute("regon", regon);
		setAttribute("regon_2016", regon_2016);
		setAttribute("regon_2017", regon_2017);
		setAttribute("regon_2018", regon_2018);
		setAttribute("regon_2019", regon_2019);
		setAttribute("regon_2020", regon_2020);

		setAttribute("reason", reason);
		setAttribute("reason_2016", reason_2016);
		setAttribute("reason_2017", reason_2017);
		setAttribute("reason_2018", reason_2018);
		setAttribute("reason_2019", reason_2019);
		setAttribute("reason_2020", reason_2020);
		setAttribute("years", years);
	}

	private void getPlanBin() {
		List<PoorPlanPojo> planList = jzfpService.getSSWPlan();

		String regon = "[ \"武山县\", \"清水县\", \"秦州区\", \"秦安县\", \"张家川\", \"麦积区\", \"甘谷县\"]";
		String regons[] = { "武山县", "清水县", "秦州区", "秦安县", "张家川", "麦积区", "甘谷县" };
		String regon_2016 = "";
		String regon_2017 = "";
		String regon_2018 = "";
		String regon_2019 = "";
		String regon_2020 = "";

		String reason = "[ \"武山县\", \"清水县\", \"秦州区\", \"秦安县\", \"张家川\", \"麦积区\", \"甘谷县\"]";
		String reason_2016 = "";
		String reason_2017 = "";
		String reason_2018 = "";
		String reason_2019 = "";
		String reason_2020 = "";

		PoorPlanPojo count_plan = new PoorPlanPojo();
		count_plan.setWushan("0");
		count_plan.setQingshui("0");
		count_plan.setQinzhou("0");
		count_plan.setQinan("0");
		count_plan.setZhangjiachuan("0");
		count_plan.setMaiji("0");
		count_plan.setGangu("0");

		for (PoorPlanPojo pojo : planList) {

			count_plan.setWushan((Float.parseFloat(count_plan.getWushan()) + Float.parseFloat(pojo.getWushan())) + "");
			count_plan.setQingshui(
					(Float.parseFloat(count_plan.getQingshui()) + Float.parseFloat(pojo.getQingshui())) + "");
			count_plan
					.setQinzhou((Float.parseFloat(count_plan.getQinzhou()) + Float.parseFloat(pojo.getQinzhou())) + "");
			count_plan.setQinan((Float.parseFloat(count_plan.getQinan()) + Float.parseFloat(pojo.getQinan())) + "");
			count_plan.setZhangjiachuan(
					(Float.parseFloat(count_plan.getZhangjiachuan()) + Float.parseFloat(pojo.getZhangjiachuan())) + "");
			count_plan.setMaiji((Float.parseFloat(count_plan.getMaiji()) + Float.parseFloat(pojo.getMaiji())) + "");
			count_plan.setGangu((Float.parseFloat(count_plan.getGangu()) + Float.parseFloat(pojo.getGangu())) + "");

			String regen_str = "[" + pojo.getWushan() + "," + pojo.getQingshui() + "," + pojo.getQinzhou() + ","
					+ pojo.getQinan() + "," + pojo.getZhangjiachuan() + "," + pojo.getMaiji() + "," + pojo.getGangu()
					+ "]";
			String reason_str = "[{ value :" + pojo.getChanye() + ",name:\"武山县\"},{ value:" + pojo.getZijin()
					+ ",name:\"清水县\"},{ value :" + pojo.getShehui() + ",name:\"秦州区\"},{ value :" + pojo.getJishu()
					+ ",name:\"秦安县\"},{ value :" + pojo.getYdbq() + ",name:\"张家川\"},{ value :" + pojo.getBzjz()
					+ ",name:\"麦积区\"},{ value :" + pojo.getStandby5() + ",name:\"甘谷县\"}]";
			if (pojo.getYear() == 2016) {
				regon_2016 = regen_str;
				reason_2016 = reason_str;
			} else if (pojo.getYear() == 2017) {
				regon_2017 = regen_str;
				reason_2017 = reason_str;
			} else if (pojo.getYear() == 2018) {
				regon_2018 = regen_str;
				reason_2018 = reason_str;
			} else if (pojo.getYear() == 2019) {
				regon_2019 = regen_str;
				reason_2019 = reason_str;
			} else if (pojo.getYear() == 2020) {
				regon_2020 = regen_str;
				reason_2020 = reason_str;
			}

		}

		setAttribute("plan", count_plan);
		setAttribute("regon", regon);
		setAttribute("regons", regons);
		setAttribute("regon_2016", regon_2016);
		setAttribute("regon_2017", regon_2017);
		setAttribute("regon_2018", regon_2018);
		setAttribute("regon_2019", regon_2019);
		setAttribute("regon_2020", regon_2020);

		setAttribute("reason", reason);
		setAttribute("reason_2016", reason_2016);
		setAttribute("reason_2017", reason_2017);
		setAttribute("reason_2018", reason_2018);
		setAttribute("reason_2019", reason_2019);
		setAttribute("reason_2020", reason_2020);

		setAttribute("year", 2016);
	}
}
