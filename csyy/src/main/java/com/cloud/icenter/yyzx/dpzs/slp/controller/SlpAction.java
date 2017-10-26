package com.cloud.icenter.yyzx.dpzs.slp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cloud.icenter.base.controller.BaseAction;
import com.cloud.icenter.common.utils.JsonUtil;
import com.cloud.icenter.yyzx.dpzs.slp.pojo.SlpJtcxRdmapPojo;
import com.cloud.icenter.yyzx.dpzs.slp.pojo.SlpJtcxTenPojo;
import com.cloud.icenter.yyzx.dpzs.slp.pojo.SlpJtcxTimePojo;
import com.cloud.icenter.yyzx.dpzs.slp.pojo.SlpRkDbPojo;
import com.cloud.icenter.yyzx.dpzs.slp.pojo.SlpRkDbrqPojo;
import com.cloud.icenter.yyzx.dpzs.slp.pojo.SlpRkNljgPojo;
import com.cloud.icenter.yyzx.dpzs.slp.pojo.SlpRkfbPojo;
import com.cloud.icenter.yyzx.dpzs.slp.service.SlpJtcxService;
import com.cloud.icenter.yyzx.dpzs.slp.service.SlpRkService;

@Controller
@RequestMapping(value = "/slp")
public class SlpAction extends BaseAction {

	@Autowired
	private SlpRkService slpRkService;
	@Autowired
	private SlpJtcxService slpJtcxService;

	@RequestMapping(value = "/rk", method = RequestMethod.GET)
	public String fr() {

		// 低保大数据
		SlpRkDbPojo db = slpRkService.getDbByYear(2017);
		setAttribute("db", db);

		// 人口分布
		List<SlpRkfbPojo> fbList = slpRkService.getRkfbByYear(2017);
		setAttribute("fbList", fbList);

		// 年龄分析男
		List<SlpRkNljgPojo> manList = slpRkService.getRkNljgList();
		List<String> man = new ArrayList<String>();
		List<Integer> mandata = new ArrayList<Integer>();
		List<String> woman = new ArrayList<String>();
		List<Integer> womandata = new ArrayList<Integer>();
		int women = 0;
		int men = 0;
		for (SlpRkNljgPojo pojo : manList) {
			man.add(pojo.getSegment_min() + "-" + pojo.getSegment_max() + "岁");
			mandata.add(pojo.getMan_val() * -1);
			men += pojo.getMan_val();
			woman.add(pojo.getSegment_min() + "-" + pojo.getSegment_max() + "岁");
			womandata.add(pojo.getWom_val());
			women += pojo.getWom_val();
		}

		setAttribute("men", men);
		setAttribute("man", JsonUtil.toJson(man));
		setAttribute("mandata", JsonUtil.toJson(mandata));
		setAttribute("women", women);
		setAttribute("woman", JsonUtil.toJson(woman));
		setAttribute("womandata", JsonUtil.toJson(womandata));

		// 低保人群分析
		List<SlpRkDbrqPojo> dbrqList = slpRkService.getCurDbrq();
		setAttribute("dbrq", JsonUtil.toJson(dbrqList));

		// 人数,月补助标准,社会资金
		List<SlpRkDbPojo> db_five = slpRkService.getCurDbFiveYear();
		List<Integer> year = new ArrayList<Integer>();
		List<Integer> cz = new ArrayList<Integer>();
		List<Integer> nc = new ArrayList<Integer>();
		List<Integer> czbz = new ArrayList<Integer>();

		List<Integer> ncbz = new ArrayList<Integer>();
		List<Integer> czdbzj = new ArrayList<Integer>();
		List<Integer> ncdbzj = new ArrayList<Integer>();
		List<Integer> nctkry = new ArrayList<Integer>();
		for (SlpRkDbPojo pojo : db_five) {
			year.add(pojo.getYear());
			cz.add(pojo.getCz());
			nc.add(pojo.getNc());
			czbz.add(pojo.getCzbz());

			ncbz.add(pojo.getNcbz());
			czdbzj.add(pojo.getCzdbzj());
			ncdbzj.add(pojo.getNcdbzj());
			nctkry.add(pojo.getNctkry());
		}

		setAttribute("year", JsonUtil.toJson(year));
		setAttribute("cz", JsonUtil.toJson(cz));
		setAttribute("nc", JsonUtil.toJson(nc));
		setAttribute("czbz", JsonUtil.toJson(czbz));

		setAttribute("ncbz", JsonUtil.toJson(ncbz));
		setAttribute("czdbzj", JsonUtil.toJson(czdbzj));
		setAttribute("ncdbzj", JsonUtil.toJson(ncdbzj));
		setAttribute("nctkry", JsonUtil.toJson(nctkry));

		return "dpzs/slp/rk";
	}

	@RequestMapping(value = "/jtcx", method = RequestMethod.GET)
	public String jtcx() {
		// 十大城市热点
		List<SlpJtcxTenPojo> ten = slpJtcxService.getTenHotspot();
		setAttribute("ten", ten.toArray());

		// 地图上的热点
		String yestoday = "2017-04-10";
		List<SlpJtcxRdmapPojo> rdList = slpJtcxService.getYesterdayRd();

		List<SlpJtcxRdmapPojo> rdList_00_04 = new ArrayList<SlpJtcxRdmapPojo>();
		List<SlpJtcxRdmapPojo> rdList_04_08 = new ArrayList<SlpJtcxRdmapPojo>();
		List<SlpJtcxRdmapPojo> rdList_08_12 = new ArrayList<SlpJtcxRdmapPojo>();
		List<SlpJtcxRdmapPojo> rdList_12_16 = new ArrayList<SlpJtcxRdmapPojo>();
		List<SlpJtcxRdmapPojo> rdList_16_20 = new ArrayList<SlpJtcxRdmapPojo>();
		List<SlpJtcxRdmapPojo> rdList_20_24 = new ArrayList<SlpJtcxRdmapPojo>();

		for (SlpJtcxRdmapPojo pojo : rdList) {
			if (pojo.getRq().compareTo(yestoday + "-00-00") >= 0 && pojo.getRq().compareTo(yestoday + "-04-00") < 0) {
				rdList_00_04.add(pojo);
			} else if (pojo.getRq().compareTo(yestoday + "-04-00") >= 0
					&& pojo.getRq().compareTo(yestoday + "-08-00") < 0) {
				rdList_04_08.add(pojo);
			} else if (pojo.getRq().compareTo(yestoday + "-08-00") >= 0
					&& pojo.getRq().compareTo(yestoday + "-12-00") < 0) {
				rdList_08_12.add(pojo);
			} else if (pojo.getRq().compareTo(yestoday + "-12-00") >= 0
					&& pojo.getRq().compareTo(yestoday + "-16-00") < 0) {
				rdList_12_16.add(pojo);
			} else if (pojo.getRq().compareTo(yestoday + "-16-00") >= 0
					&& pojo.getRq().compareTo(yestoday + "-20-00") < 0) {
				rdList_16_20.add(pojo);
			} else if (pojo.getRq().compareTo(yestoday + "-20-00") >= 0
					&& pojo.getRq().compareTo(yestoday + "-24-00") < 0) {
				rdList_20_24.add(pojo);
			}
		}

		setAttribute("rdList0", JsonUtil.toJson(rdList_00_04));
		setAttribute("rdList1", JsonUtil.toJson(rdList_04_08));
		setAttribute("rdList2", JsonUtil.toJson(rdList_08_12));
		setAttribute("rdList3", JsonUtil.toJson(rdList_12_16));
		setAttribute("rdList4", JsonUtil.toJson(rdList_16_20));
		setAttribute("rdList5", JsonUtil.toJson(rdList_20_24));

		// 24小时热点
		List<SlpJtcxTimePojo> timeRdList = slpJtcxService.getTimeHotspot();

		List<SlpJtcxTimePojo> time_00_04 = new ArrayList<SlpJtcxTimePojo>();
		List<SlpJtcxTimePojo> time_04_08 = new ArrayList<SlpJtcxTimePojo>();
		List<SlpJtcxTimePojo> time_08_12 = new ArrayList<SlpJtcxTimePojo>();
		List<SlpJtcxTimePojo> time_12_16 = new ArrayList<SlpJtcxTimePojo>();
		List<SlpJtcxTimePojo> time_16_20 = new ArrayList<SlpJtcxTimePojo>();
		List<SlpJtcxTimePojo> time_20_24 = new ArrayList<SlpJtcxTimePojo>();

		for (SlpJtcxTimePojo pojo : timeRdList) {
			if (pojo.getRq().compareTo(yestoday + "-00-00") >= 0 && pojo.getRq().compareTo(yestoday + "-04-00") < 0) {
				time_00_04.add(pojo);
			} else if (pojo.getRq().compareTo(yestoday + "-04-00") >= 0
					&& pojo.getRq().compareTo(yestoday + "-08-00") < 0) {
				time_04_08.add(pojo);
			} else if (pojo.getRq().compareTo(yestoday + "-08-00") >= 0
					&& pojo.getRq().compareTo(yestoday + "-12-00") < 0) {
				time_08_12.add(pojo);
			} else if (pojo.getRq().compareTo(yestoday + "-12-00") >= 0
					&& pojo.getRq().compareTo(yestoday + "-16-00") < 0) {
				time_12_16.add(pojo);
			} else if (pojo.getRq().compareTo(yestoday + "-16-00") >= 0
					&& pojo.getRq().compareTo(yestoday + "-20-00") < 0) {
				time_16_20.add(pojo);
			} else if (pojo.getRq().compareTo(yestoday + "-20-00") >= 0
					&& pojo.getRq().compareTo(yestoday + "-24-00") < 0) {
				time_20_24.add(pojo);
			}
		}

		setAttribute("timeList0", JsonUtil.toJson(time_00_04));
		setAttribute("timeList1", JsonUtil.toJson(time_04_08));
		setAttribute("timeList2", JsonUtil.toJson(time_08_12));
		setAttribute("timeList3", JsonUtil.toJson(time_12_16));
		setAttribute("timeList4", JsonUtil.toJson(time_16_20));
		setAttribute("timeList5", JsonUtil.toJson(time_20_24));

		return "dpzs/slp/jtcx";
	}
}
