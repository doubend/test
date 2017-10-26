package com.cloud.icenter.yyzx.fzjc.fr.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cloud.icenter.base.controller.BaseAction;
import com.cloud.icenter.common.utils.JsonUtil;
import com.cloud.icenter.yyzx.fzjc.fr.pojo.FRCapitalPojo;
import com.cloud.icenter.yyzx.fzjc.fr.pojo.FREconNsPojo;
import com.cloud.icenter.yyzx.fzjc.fr.pojo.FREconPojo;
import com.cloud.icenter.yyzx.fzjc.fr.pojo.FRQyhyPojo;
import com.cloud.icenter.yyzx.fzjc.fr.pojo.FRQyinfoPojo;
import com.cloud.icenter.yyzx.fzjc.fr.pojo.FRRegonPojo;
import com.cloud.icenter.yyzx.fzjc.fr.pojo.FRTop5Pojo;
import com.cloud.icenter.yyzx.fzjc.fr.pojo.FRTop8Pojo;
import com.cloud.icenter.yyzx.fzjc.fr.pojo.FRZxwPojo;
import com.cloud.icenter.yyzx.fzjc.fr.service.FRService;

/**
 * 精准扶贫后台
 * 
 * @author dbchega
 */
@Controller
@RequestMapping(value = "/fr")
public class FrAction extends BaseAction {

	@Autowired
	private FRService frService;

	/**
	 * 专题分析-精准扶贫-脱贫规划
	 * 
	 * @return
	 */
	@RequestMapping(value = "/frfb", method = RequestMethod.GET)
	public String tpgh() {
		String qyType = "[ \"微型企业\", \"小型企业\", \"中型企业\" ]";
		List<FRZxwPojo> zxwList = frService.getFiveYearZxw();
		String curFiveYear = "";
		String qy_wx = "";
		String qy_xx = "";
		String qy_zx = "";

		for (FRZxwPojo pojo : zxwList) {
			curFiveYear += pojo.getYear() + ",";
			qy_wx += pojo.getWei() + ",";
			qy_xx += pojo.getXiao() + ",";
			qy_zx += pojo.getZhong() + ",";

		}

		setAttribute("qyType", qyType);
		setAttribute("curFiveYear", "[" + curFiveYear.substring(0, curFiveYear.length() - 1) + "]");
		setAttribute("qy_wx", "[" + qy_wx.substring(0, qy_wx.length() - 1) + "]");
		setAttribute("qy_xx", "[" + qy_xx.substring(0, qy_xx.length() - 1) + "]");
		setAttribute("qy_zx", "[" + qy_zx.substring(0, qy_zx.length() - 1) + "]");

		List<FRCapitalPojo> capitalList = frService.getCurCapital();
		String jjType = "";
		String jjData = "";

		for (FRCapitalPojo pojo : capitalList) {
			jjType += "\"" + pojo.getType() + "\",";
			jjData += pojo.getNum() + ",";
		}
		List<FRCapitalPojo> cList = new ArrayList<FRCapitalPojo>();
		cList.add(capitalList.get(0));
		cList.add(capitalList.get(1));
		cList.add(capitalList.get(2));
		cList.add(capitalList.get(3));
		cList.add(capitalList.get(4));
		cList.add(capitalList.get(5));
		setAttribute("capitalList", cList);
		setAttribute("jjType", "[" + jjType.substring(0, jjType.length() - 1) + "]");
		setAttribute("jjData", "[" + jjData.substring(0, jjData.length() - 1) + "]");

		List<FRRegonPojo> regonList = frService.getCurRegon();
		String regon = "";
		String regonData = "";

		for (FRRegonPojo pojo : regonList) {
			regon += "\"" + pojo.getRegon() + "\",";
			regonData += pojo.getNum() + ",";

		}

		setAttribute("regon", "[" + regon.substring(0, regon.length() - 1) + "]");
		setAttribute("regonData", "[" + regonData.substring(0, regonData.length() - 1) + "]");

		List<FREconPojo> econList = frService.getCurEcon();
		List<FREconNsPojo> econNsList = frService.getCurEconNs();

		int econCount = 0;
		float econNsCount = 0;
		for (FREconPojo pojo : econList) {
			econCount += pojo.getNum();
		}

		for (FREconNsPojo pojo : econNsList) {
			econNsCount += pojo.getNsnum();
		}

		try {
			setAttribute("econList", JsonUtil.toJson(econList));
		} catch (Exception e) {
			e.printStackTrace();
		}
		setAttribute("econNsList", JsonUtil.toJson(econNsList));
		setAttribute("econCount", econCount);
		setAttribute("econNsCount", econNsCount);

		List<FRQyhyPojo> qyhyList = frService.getCurQyhy();
		String hy_type = "";
		String hy_new = "";
		String hy_del = "";
		String hy_new_gm = "";
		String hy_del_gm = "";

		for (FRQyhyPojo pojo : qyhyList) {
			hy_type += "\"" + pojo.getName() + "\",";
			hy_new += (pojo.getAdd() * -1) + ",";
			hy_del += pojo.getDel() + ",";
			hy_new_gm += (pojo.getAddgm() * -1) + ",";
			hy_del_gm += pojo.getDelgm() + ",";
		}
		setAttribute("hy_type", "[" + hy_type.substring(0, hy_type.length() - 1) + "]");
		setAttribute("hy_new", "[" + hy_new.substring(0, hy_new.length() - 1) + "]");
		setAttribute("hy_del", "[" + hy_del.substring(0, hy_del.length() - 1) + "]");
		setAttribute("hy_new_gm", "[" + hy_new_gm.substring(0, hy_new_gm.length() - 1) + "]");
		setAttribute("hy_del_gm", "[" + hy_del_gm.substring(0, hy_del_gm.length() - 1) + "]");
		return "fzjc/fr/distribution";
	}

	/**
	 * 专题分析-精准扶贫-贫困概况
	 * 
	 * @return
	 */
	@RequestMapping(value = "/frgm", method = RequestMethod.GET)
	public String pkgk() {
		List<FRQyinfoPojo> qyinfoList = frService.getCurQyinfo();
		String qy_type = "";
		String qy_num = "";
		String qy_num_gmys = "";
		String qy_cyry = "";
		float xiaoshouzonghe = 0;

		for (FRQyinfoPojo pojo : qyinfoList) {
			qy_type += "\"" + pojo.getType() + "\",";
			qy_num += pojo.getNum() + ",";
			qy_num_gmys += pojo.getGmnum() + ",";
			qy_cyry += pojo.getCynum() + ",";
			xiaoshouzonghe += pojo.getXsnum();
		}
		setAttribute("qy_type", "[" + qy_type.substring(0, qy_type.length() - 1) + "]");
		setAttribute("qy_num", "[" + qy_num.substring(0, qy_num.length() - 1) + "]");
		setAttribute("qy_num_gmys", "[" + qy_num_gmys.substring(0, qy_num_gmys.length() - 1) + "]");
		setAttribute("qy_cyry", "[" + qy_cyry.substring(0, qy_cyry.length() - 1) + "]");
		setAttribute("xiaoshouzonghe", xiaoshouzonghe);
		setAttribute("qy_xiaoshou", JsonUtil.toJson(qyinfoList));

		List<FRQyhyPojo> qyhyList = frService.getCurQyhy();
		String hy_type = "";
		String hy_new = "";
		String hy_del = "";
		String hy_new_gm = "";
		String hy_del_gm = "";

		for (FRQyhyPojo pojo : qyhyList) {
			hy_type += "\"" + pojo.getName() + "\",";
			hy_new += (pojo.getAdd() * -1) + ",";
			hy_del += pojo.getDel() + ",";
			hy_new_gm += (pojo.getAddgm() * -1) + ",";
			hy_del_gm += pojo.getDelgm() + ",";
		}
		setAttribute("hy_type", "[" + hy_type.substring(0, hy_type.length() - 1) + "]");
		setAttribute("hy_new", "[" + hy_new.substring(0, hy_new.length() - 1) + "]");
		setAttribute("hy_del", "[" + hy_del.substring(0, hy_del.length() - 1) + "]");
		setAttribute("hy_new_gm", "[" + hy_new_gm.substring(0, hy_new_gm.length() - 1) + "]");
		setAttribute("hy_del_gm", "[" + hy_del_gm.substring(0, hy_del_gm.length() - 1) + "]");

		List<FRTop5Pojo> top5List = frService.getCurTop5();
		String top5_type = "";
		String top5_year = "";
		String top5_1 = "";
		String top5_2 = "";
		String top5_3 = "";
		String top5_4 = "";
		String top5_5 = "";

		for (FRTop5Pojo pojo : top5List) {
			top5_type = "[\"" + pojo.getTop_one_name() + "\",\"" + pojo.getTop_two_name() + "\",\""
					+ pojo.getTop_thr_name() + "\",\"" + pojo.getTop_four_name() + "\",\"" + pojo.getTop_five_name()
					+ "\"]";
			top5_year += "\"" + pojo.getYear() + "\",";
			top5_1 += pojo.getTop_one_num() + ",";
			top5_2 += pojo.getTop_two_num() + ",";
			top5_3 += pojo.getTop_thr_num() + ",";
			top5_4 += pojo.getTop_four_num() + ",";
			top5_5 += pojo.getTop_five_num() + ",";
		}
		setAttribute("top5_type", top5_type);
		setAttribute("top5_year", "[" + top5_year.substring(0, top5_year.length() - 1) + "]");
		setAttribute("top5_1", "[" + top5_1.substring(0, top5_1.length() - 1) + "]");
		setAttribute("top5_2", "[" + top5_2.substring(0, top5_2.length() - 1) + "]");
		setAttribute("top5_3", "[" + top5_3.substring(0, top5_3.length() - 1) + "]");
		setAttribute("top5_4", "[" + top5_4.substring(0, top5_4.length() - 1) + "]");
		setAttribute("top5_5", "[" + top5_5.substring(0, top5_5.length() - 1) + "]");

		List<FRTop8Pojo> top8List = frService.getCurTop8();
		String top8_type = "";
		String top8_year = "";
		String top8_1 = "";
		String top8_2 = "";
		String top8_3 = "";
		String top8_4 = "";

		for (FRTop8Pojo pojo : top8List) {
			top8_type = "[\"" + pojo.getTop_one_name() + "\",\"" + pojo.getTop_two_name() + "\",\""
					+ pojo.getTop_thr_name() + "\",\"" + pojo.getTop_four_name() + "\",\"" + pojo.getTop_five_name()
					+ "\",\"" + pojo.getTop_six_name() + "\",\"" + pojo.getTop_seven_name() + "\",\""
					+ pojo.getTop_eight_name() + "\"]";
			top8_year += "\"" + pojo.getYear() + "\",";
			String str = "[" + pojo.getTop_one_num() + "," + pojo.getTop_two_num() + "," + pojo.getTop_thr_num() + ","
					+ pojo.getTop_four_num() + "," + pojo.getTop_five_num() + "," + pojo.getTop_six_num() + ","
					+ pojo.getTop_seven_num() + "," + pojo.getTop_eight_num() + "]";
			if (pojo.getYear() == 2014) {
				top8_1 = str;
			} else if (pojo.getYear() == 2015) {
				top8_2 = str;
			} else if (pojo.getYear() == 2016) {
				top8_3 = str;
			} else if (pojo.getYear() == 2017) {
				top8_4 = str;
			}
		}
		setAttribute("top8_type", top8_type);
		setAttribute("top8_year", "[" + top8_year.substring(0, top8_year.length() - 1) + "]");
		setAttribute("top8_1", top8_1);
		setAttribute("top8_2", top8_2);
		setAttribute("top8_3", top8_3);
		setAttribute("top8_4", top8_4);
		return "fzjc/fr/scale";
	}
}
