package com.cloud.icenter.yyzx.dpzs.dp.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.icenter.base.controller.BaseAction;
import com.cloud.icenter.common.utils.JsonResult;
import com.cloud.icenter.common.utils.JsonUtil;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpFrFrfbPojo;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpFrFrqyryPojo;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpFrFrzbPojo;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpFrQyjyzqPojo;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpJtcxCzcPojo;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpJtcxFzPojo;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpJtcxZbPojo;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpJzfpFpcxPojo;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpJzfpPkcPojo;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpJzfpcsPojo;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpJzfprwPojo;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpJzfpzjPojo;
import com.cloud.icenter.yyzx.dpzs.dp.service.DpFrService;
import com.cloud.icenter.yyzx.dpzs.dp.service.DpJtcxService;
import com.cloud.icenter.yyzx.dpzs.dp.service.DpJzfpService;
import com.cloud.icenter.yyzx.dpzs.dp.service.DpRkService;
import com.cloud.icenter.yyzx.fzjc.fr.pojo.FRCapitalPojo;
import com.cloud.icenter.yyzx.fzjc.fr.pojo.FRQyhyPojo;
import com.cloud.icenter.yyzx.fzjc.fr.pojo.FRRegonPojo;
import com.cloud.icenter.yyzx.fzjc.fr.pojo.FRZxwPojo;
import com.cloud.icenter.yyzx.fzjc.fr.service.FRService;
import com.cloud.icenter.yyzx.fzjc.hgjj.pojo.RmshGksj;
import com.cloud.icenter.yyzx.fzjc.hgjj.pojo.RmshLnsh;
import com.cloud.icenter.yyzx.fzjc.hgjj.pojo.RmshShru;
import com.cloud.icenter.yyzx.fzjc.hgjj.pojo.RmshXfjg;
import com.cloud.icenter.yyzx.fzjc.hgjj.service.RmshService;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Agestructure;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Distribution;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Eduincome;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Jobdistribution;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Migrant;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Migration;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Newborn;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Outflowsource;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Rkmd;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Scale;
import com.cloud.icenter.yyzx.fzjc.rk.service.PdistributionServie;
import com.cloud.icenter.yyzx.fzjc.rk.service.PmigrantService;
import com.cloud.icenter.yyzx.ztfx.jzfp.pojo.PoorPopulationPojo;
import com.cloud.icenter.yyzx.ztfx.jzfp.pojo.PoorStatisPojo;
import com.cloud.icenter.yyzx.ztfx.jzfp.pojo.PoorStrategyPojo;
import com.cloud.icenter.yyzx.ztfx.jzfp.pojo.PoorSurveyPojo;

@Controller
@RequestMapping(value = "/dp")
public class DpAction extends BaseAction {

	@Autowired
	private FRService frService;
	@Autowired
	private DpFrService dpFrService;

	@Autowired
	private DpJzfpService dpJzfpService;

	@Autowired
	private DpRkService dpRkService;

	@Autowired
	private DpJtcxService dpJtcxService;

	@RequestMapping(value = "/fr", method = RequestMethod.GET)
	public String fr() {
		// 企业经营周期
		List<DpFrQyjyzqPojo> qyjyzqList = dpFrService.getCurQyjyzq();
		setAttribute("qyjyzqList", qyjyzqList);

		// 企业法人注册注销分析
		int zc_count = 0;
		List<String> frzx_type_list = new ArrayList<String>();
		List<Integer> frzx_data_zc_list = new ArrayList<Integer>();
		List<Integer> frzx_data_gmys_zc_list = new ArrayList<Integer>();
		List<Integer> frzx_data_zx_list = new ArrayList<Integer>();
		List<Integer> frzx_data_gmys_zx_list = new ArrayList<Integer>();
		List<FRQyhyPojo> frzxList = dpFrService.getCurQyhy();
		for (FRQyhyPojo pojo : frzxList) {
			frzx_type_list.add(pojo.getName());
			frzx_data_zc_list.add(pojo.getAdd());
			frzx_data_gmys_zc_list.add(pojo.getAddgm());
			frzx_data_zx_list.add(pojo.getDel() * -1);
			frzx_data_gmys_zx_list.add(pojo.getDelgm() * -1);

			zc_count += pojo.getAdd();
		}
		setAttribute("frzx_type", JsonUtil.toJson(frzx_type_list));
		setAttribute("frzx_data_zc", JsonUtil.toJson(frzx_data_zc_list));
		setAttribute("frzx_data_gmys_zc", JsonUtil.toJson(frzx_data_gmys_zc_list));
		setAttribute("frzx_data_zx", JsonUtil.toJson(frzx_data_zx_list));
		setAttribute("frzx_data_gmys_zx", JsonUtil.toJson(frzx_data_gmys_zx_list));

		// 近年企业法人区域分布变化
		List<Integer> zhangjiachuan = new ArrayList<Integer>();
		List<Integer> qinan = new ArrayList<Integer>();
		List<Integer> wushan = new ArrayList<Integer>();
		List<Integer> qingshui = new ArrayList<Integer>();
		List<Integer> gangu = new ArrayList<Integer>();
		List<Integer> maiji = new ArrayList<Integer>();
		List<Integer> qinzhou = new ArrayList<Integer>();
		List<Integer> tianshui = new ArrayList<Integer>();
		String regonList[] = { "张家川", "秦安县", "武山县", "清水县", "甘谷县", "麦积区", "秦州区", "天水市" };

		for (String regonName : regonList) {
			List<FRRegonPojo> frqyList = dpFrService.getRegonByNameSevevYear(regonName);
			List<Integer> temp = new ArrayList<Integer>();
			for (FRRegonPojo regon : frqyList) {
				temp.add(regon.getNum());
			}

			if (regonName.equals("张家川")) {
				zhangjiachuan.addAll(temp);
			} else if (regonName.equals("秦安县")) {
				qinan.addAll(temp);
			} else if (regonName.equals("武山县")) {
				wushan.addAll(temp);
			} else if (regonName.equals("清水县")) {
				qingshui.addAll(temp);
			} else if (regonName.equals("甘谷县")) {
				gangu.addAll(temp);
			} else if (regonName.equals("麦积区")) {
				maiji.addAll(temp);
			} else if (regonName.equals("秦州区")) {
				qinzhou.addAll(temp);
			} else if (regonName.equals("天水市")) {
				tianshui.addAll(temp);
			}
		}

		List<Integer> year = getCurYears(5);

		setAttribute("regon", JsonUtil.toJson(regonList));
		setAttribute("zhangjiachuan", JsonUtil.toJson(zhangjiachuan));
		setAttribute("qinan", JsonUtil.toJson(qinan));
		setAttribute("wushan", JsonUtil.toJson(wushan));
		setAttribute("qingshui", JsonUtil.toJson(qingshui));
		setAttribute("gangu", JsonUtil.toJson(gangu));
		setAttribute("maiji", JsonUtil.toJson(maiji));
		setAttribute("qinzhou", JsonUtil.toJson(qinzhou));
		setAttribute("tianshui", JsonUtil.toJson(tianshui));
		setAttribute("year", JsonUtil.toJson(year));

		// 近5年中小微企业数量变化趋势
		String zxwList[] = { "企业" };

		List<FRZxwPojo> zxwdataList = dpFrService.getSevenYearZxw();
		List<Integer> wei = new ArrayList<Integer>();
		List<Integer> xiao = new ArrayList<Integer>();
		List<Integer> zhong = new ArrayList<Integer>();
		List<Integer> wxzyear = new ArrayList<Integer>();
		for (FRZxwPojo pojo : zxwdataList) {
			wei.add(pojo.getWei());
			xiao.add(pojo.getXiao());
			zhong.add(pojo.getZhong());
			if (pojo.getYear() > 2012) {
				wxzyear.add(pojo.getYear());
			}
			if (pojo.getYear() == 2017) {
				// 企业大数据
				setAttribute("cur_zxw", pojo);
			}
		}
		setAttribute("zxw", JsonUtil.toJson(zxwList));
		setAttribute("wei", JsonUtil.toJson(wei));
		setAttribute("xiao", JsonUtil.toJson(xiao));
		setAttribute("zhong", JsonUtil.toJson(zhong));
		setAttribute("year6", JsonUtil.toJson(wxzyear));

		// 企业大数据
		setAttribute("zc_count", zc_count);

		// 近年主要行业企业数与从业人员变化
		String renyuanList[] = { "7大行业企业", "农林牧渔企业", "文化旅游企业", "7大行业人员", "农林牧渔人员", "文化旅游人员" };
		List<DpFrFrqyryPojo> qyryList = new ArrayList();// dpFrService.getQyryByYear(2011);

		List<Integer> ry0 = new ArrayList<Integer>();
		List<Integer> ry1 = new ArrayList<Integer>();
		List<Integer> ry2 = new ArrayList<Integer>();
		List<Integer> ry3 = new ArrayList<Integer>();
		List<Integer> ry4 = new ArrayList<Integer>();
		List<Integer> ry5 = new ArrayList<Integer>();
		List<Integer> ry_year = new ArrayList<Integer>();
		for (DpFrFrqyryPojo pojo : qyryList) {
			ry0.add(pojo.getQdhy());
			ry1.add(pojo.getNlmy());
			ry2.add(pojo.getWhly());
			ry3.add(pojo.getQdhyry());
			ry4.add(pojo.getNlmyry());
			ry5.add(pojo.getWhlyry());
			ry_year.add(pojo.getYear());
		}
		setAttribute("renyuan", JsonUtil.toJson(renyuanList));
		setAttribute("ry0", JsonUtil.toJson(ry0));
		setAttribute("ry1", JsonUtil.toJson(ry1));
		setAttribute("ry2", JsonUtil.toJson(ry2));
		setAttribute("ry3", JsonUtil.toJson(ry3));
		setAttribute("ry4", JsonUtil.toJson(ry4));
		setAttribute("ry5", JsonUtil.toJson(ry5));
		setAttribute("ry_year", JsonUtil.toJson(ry_year));

		List<FRCapitalPojo> capitalList = frService.getCurCapital();
		String jjType = "";
		String jjData = "";

		for (FRCapitalPojo pojo : capitalList) {
			jjType += "\"" + pojo.getType() + "\",";
			jjData += pojo.getNum() + ",";
		}
		setAttribute("jjType", "[" + jjType.substring(0, jjType.length() - 1) + "]");
		setAttribute("jjData", "[" + jjData.substring(0, jjData.length() - 1) + "]");
		// 企业行业
		String[] qyhys = { "工业", "建筑业", "批发", "零售业", "交通运输", "住宿餐饮", "高科技", "仓储物流" };

		// 企业法人分布-行业
		List<DpFrFrfbPojo> hyList = new ArrayList<DpFrFrfbPojo>();

		for (String str : qyhys) {
			List<DpFrFrzbPojo> zb = dpFrService.getCurFrzb(2017, str, null);
			hyList.add(new DpFrFrfbPojo(str, zb.size()));
		}
		setAttribute("frhyfb", JsonUtil.toJson(hyList));

		// 大屏-法人-地图
		List<DpFrFrzbPojo> gongye = dpFrService.getCurFrzb(2017, qyhys[0], null);
		List<DpFrFrzbPojo> jianzhuye = dpFrService.getCurFrzb(2017, qyhys[1], null);
		List<DpFrFrzbPojo> pifa = dpFrService.getCurFrzb(2017, qyhys[2], null);
		List<DpFrFrzbPojo> lingshouye = dpFrService.getCurFrzb(2017, qyhys[3], null);
		List<DpFrFrzbPojo> jiaotong = dpFrService.getCurFrzb(2017, qyhys[4], null);
		List<DpFrFrzbPojo> canyin = dpFrService.getCurFrzb(2017, qyhys[5], null);
		List<DpFrFrzbPojo> gaokeji = dpFrService.getCurFrzb(2017, qyhys[6], null);
		List<DpFrFrzbPojo> wuliu = dpFrService.getCurFrzb(2017, qyhys[7], null);

		setAttribute("qyhys", JsonUtil.toJson(qyhys));
		setAttribute("gongye", JsonUtil.toJson(gongye));
		setAttribute("jianzhuye", JsonUtil.toJson(jianzhuye));
		setAttribute("pifa", JsonUtil.toJson(pifa));
		setAttribute("lingshouye", JsonUtil.toJson(lingshouye));
		setAttribute("jiaotong", JsonUtil.toJson(jiaotong));
		setAttribute("canyin", JsonUtil.toJson(canyin));
		setAttribute("gaokeji", JsonUtil.toJson(gaokeji));
		setAttribute("wuliu", JsonUtil.toJson(wuliu));

		// 企业性质
		String[] qyxzs = { "国有企业", "集体企业", "合资企业", "港澳台", "国有控股" };

		// 企业法人分布-行业
		List<DpFrFrfbPojo> xzList = new ArrayList<DpFrFrfbPojo>();

		for (String str : qyxzs) {
			List<DpFrFrzbPojo> zb = dpFrService.getCurFrzb(2017, null, str);
			xzList.add(new DpFrFrfbPojo(str, zb.size()));
		}
		setAttribute("frxzfb", JsonUtil.toJson(xzList));

		// 大屏-法人-地图
		List<DpFrFrzbPojo> guoyou = dpFrService.getCurFrzb(2017, null, qyxzs[0]);
		List<DpFrFrzbPojo> jiti = dpFrService.getCurFrzb(2017, null, qyxzs[1]);
		List<DpFrFrzbPojo> hezi = dpFrService.getCurFrzb(2017, null, qyxzs[2]);
		List<DpFrFrzbPojo> gat = dpFrService.getCurFrzb(2017, null, qyxzs[3]);
		List<DpFrFrzbPojo> gykonggu = dpFrService.getCurFrzb(2017, null, qyxzs[4]);

		setAttribute("qyxzs", JsonUtil.toJson(qyxzs));
		setAttribute("guoyou", JsonUtil.toJson(guoyou));
		setAttribute("jiti", JsonUtil.toJson(jiti));
		setAttribute("hezi", JsonUtil.toJson(hezi));
		setAttribute("gat", JsonUtil.toJson(gat));
		setAttribute("gykonggu", JsonUtil.toJson(gykonggu));

		return "dpzs/dp/fr";
	}

	@RequestMapping(value = "/jzfp", method = RequestMethod.GET)
	public String jzfp() {
		// 脱贫概况
		PoorSurveyPojo ps = dpJzfpService.getCurSurvey();
		setAttribute("ps", ps);

		// 致贫原因
		List<PoorStatisPojo> poorReasonList = dpJzfpService.getCurStatis(1);
		List<String> poorReason = new ArrayList<String>();
		List<Integer> poorReasonData = new ArrayList<Integer>();
		for (PoorStatisPojo pojo : poorReasonList) {
			poorReason.add(pojo.getType_name());
			poorReasonData.add(pojo.getPopulations());
		}

		setAttribute("poorReason", JsonUtil.toJson(poorReason));
		setAttribute("poorReasonData", JsonUtil.toJson(poorReasonData));

		// 脱贫能力
		List<PoorStatisPojo> ablityList = dpJzfpService.getCurStatis(4);
		List<String> nlType = new ArrayList<String>();
		List<Integer> nlData = new ArrayList<Integer>();
		for (PoorStatisPojo pojo : ablityList) {
			nlType.add(pojo.getType_name());
			nlData.add(pojo.getPopulations() / 100);
		}

		setAttribute("nlType", JsonUtil.toJson(nlType));
		setAttribute("nlData", JsonUtil.toJson(nlData));

		// 贫困人口跟踪
		List<PoorPopulationPojo> ppList = dpJzfpService.getCurPopulationFiveYear();
		List<Integer> yearFive = new ArrayList<Integer>();
		List<Integer> poorPerson = new ArrayList<Integer>();
		List<Integer> poorOut = new ArrayList<Integer>();
		for (PoorPopulationPojo pojo : ppList) {
			yearFive.add(pojo.getYear());
			poorPerson.add(pojo.getPooring());
			poorOut.add(pojo.getPoored());
		}

		setAttribute("yearFive", JsonUtil.toJson(yearFive));
		setAttribute("poorPerson", JsonUtil.toJson(poorPerson));
		setAttribute("poorOut", JsonUtil.toJson(poorOut));

		// 贫困类型
		List<PoorStatisPojo> poorTypeList = dpJzfpService.getCurStatis(3);
		List<String> poorType = new ArrayList<String>();
		for (PoorStatisPojo pojo : poorTypeList) {
			poorType.add(pojo.getType_name());
		}

		setAttribute("poorType", JsonUtil.toJson(poorType));
		setAttribute("poorTypeData", JsonUtil.toJson(poorTypeList));

		// 扶贫成效
		DpJzfpFpcxPojo fpcx = dpJzfpService.getCurFpcx();
		String regonList[] = { "秦州区", "麦积区", "甘谷县", "清水县", "武山县", "秦安县", "张家川" };
		List<Integer> regonData = new ArrayList<Integer>();
		regonData.add(fpcx.getQinzhou());
		regonData.add(fpcx.getMaiji());
		regonData.add(fpcx.getGangu());
		regonData.add(fpcx.getQingshui());

		regonData.add(fpcx.getWushan());
		regonData.add(fpcx.getQinan());
		regonData.add(fpcx.getZhangjiachuan());
		setAttribute("regonData", JsonUtil.toJson(regonData));
		setAttribute("regon", JsonUtil.toJson(regonList));

		// 贫困村分布
		int type = 0;
		List<DpJzfpPkcPojo> pkc0List = dpJzfpService.getCurPkc(type);
		List<DpJzfpPkcPojo> pkc1List = dpJzfpService.getCurPkc(++type);
		List<DpJzfpPkcPojo> pkc2List = dpJzfpService.getCurPkc(++type);
		setAttribute("pkc0List", JsonUtil.toJson(pkc0List));
		setAttribute("pkc1List", JsonUtil.toJson(pkc1List));
		setAttribute("pkc2List", JsonUtil.toJson(pkc2List));

		// 扶贫资金
		DpJzfpzjPojo fpzj = dpJzfpService.getCurFpzj();
		String acDactList[] = { "低保", "五保", "医疗", "农合" };
		List<Integer> acData = new ArrayList<Integer>();
		acData.add(fpzj.getQu());
		acData.add(fpzj.getShi());
		acData.add(fpzj.getSheng());
		acData.add(fpzj.getGuojia());
		setAttribute("acData", JsonUtil.toJson(acData));

		setAttribute("acDact", JsonUtil.toJson(acDactList));
		setAttribute("zongji", fpzj.getZongji());

		// 扶贫任务
		DpJzfprwPojo fprw = dpJzfpService.getCurFprw();
		setAttribute("fprw", fprw);

		// 扶贫策略
		List<PoorStrategyPojo> psList = dpJzfpService.getCurStrategyTop4();
		setAttribute("psList", psList);

		// 扶贫措施
		List<DpJzfpcsPojo> csList = dpJzfpService.getCurFpcs();
		setAttribute("csList", csList);

		return "dpzs/dp/jzfp";
	}

	@RequestMapping(value = "/rk", method = RequestMethod.GET)
	public String rk() {
		List<Agestructure> ageList = dpRkService.getAgestructureList();
		List<String> ageType = new ArrayList<String>();
		List<Integer> manValue = new ArrayList<Integer>();
		List<Integer> womanValue = new ArrayList<Integer>();
		for (Agestructure pojo : ageList) {
			ageType.add(pojo.getSegment_min() + "-" + pojo.getSegment_max() + "岁");
			manValue.add(pojo.getMan_val() * -1);
			womanValue.add(pojo.getWom_val());
		}
		setAttribute("ageType", JsonUtil.toJson(ageType));
		setAttribute("manValue", JsonUtil.toJson(manValue));
		setAttribute("womanValue", JsonUtil.toJson(womanValue));

		List<Newborn> newBornList = dpRkService.getNewBornList();
		setAttribute("newBornList", newBornList);

		List<Rkmd> rkmdList = new ArrayList<Rkmd>();
		for (Newborn born : newBornList) {
			rkmdList.add(new Rkmd(born.getCity(), born.getTotal_population()));
		}
		setAttribute("rkmdValue", JsonUtil.toJson(rkmdList));

		int rk_count = 0;
		int rk_man = 0;
		int rk_woman = 0;
		int rk_0_1 = 0;
		int rk_0_14_man = 0;
		int rk_0_14_woman = 0;
		int rk_15_64_man = 0;
		int rk_15_64_woman = 0;
		int rk_65_man = 0;
		int rk_65_woman = 0;

		for (Agestructure pojo : ageList) {
			if (pojo.getSegment_max() <= 1) {
				rk_0_1 += pojo.getMan_val() + pojo.getWom_val();
			}

			if (pojo.getSegment_max() <= 14) {
				rk_0_14_man += pojo.getMan_val();
				rk_0_14_woman += pojo.getWom_val();
			} else if (pojo.getSegment_min() > 14 && pojo.getSegment_max() < 65) {
				rk_15_64_man += pojo.getMan_val();
				rk_15_64_woman += pojo.getWom_val();
			} else {
				rk_65_man += pojo.getMan_val();
				rk_65_woman += pojo.getWom_val();
			}
			rk_man += pojo.getMan_val();
			rk_woman += pojo.getWom_val();
			rk_count += pojo.getMan_val() + pojo.getWom_val();
		}

		setAttribute("year", 2017);
		setAttribute("rk_count", rk_count);
		setAttribute("rk_man", rk_man);
		setAttribute("rk_woman", rk_woman);
		setAttribute("rk_0_1", rk_0_1);
		setAttribute("rk_0_14_man", rk_0_14_man);
		setAttribute("rk_0_14_woman", rk_0_14_woman);
		setAttribute("rk_15_64_man", rk_15_64_man);
		setAttribute("rk_15_64_woman", rk_15_64_woman);
		setAttribute("rk_65_man", rk_65_man);
		setAttribute("rk_65_woman", rk_65_woman);

		return "dpzs/dp/rk";
	}

	@RequestMapping(value = "/jtcx", method = RequestMethod.GET)
	public String jtcx() {
		List<DpJtcxCzcPojo> czcList = dpJtcxService.getCurCzc();
		List<DpJtcxZbPojo> zbList = dpJtcxService.getCurZb();
		setAttribute("czcList", JsonUtil.toJson(czcList));
		setAttribute("zbList", zbList);

		List<DpJtcxFzPojo> fzList = dpJtcxService.getCurFiveYear();
		List<String> year = new ArrayList<String>();
		List<Integer> gjxl = new ArrayList<Integer>();
		List<Integer> gjcxfdl = new ArrayList<Integer>();
		List<Integer> gjwr = new ArrayList<Integer>();
		List<Integer> gjrjzkl = new ArrayList<Integer>();
		List<Integer> czwr = new ArrayList<Integer>();
		List<Integer> czrjzkl = new ArrayList<Integer>();
		List<Integer> hyc = new ArrayList<Integer>();
		List<Integer> hyzl = new ArrayList<Integer>();

		for (DpJtcxFzPojo pojo : fzList) {
			year.add(pojo.getYear() + "");
			gjxl.add(pojo.getGjxl());
			gjcxfdl.add(pojo.getGjcxfdl());
			gjwr.add(pojo.getGjwr());
			gjrjzkl.add(pojo.getGjrjzkl());
			czwr.add(pojo.getCzwr());
			czrjzkl.add(pojo.getCzrjzkl());
			hyc.add(pojo.getHyc());
			hyzl.add(pojo.getHyzl());
		}

		setAttribute("year", JsonUtil.toJson(year));
		setAttribute("gjxl", JsonUtil.toJson(gjxl));
		setAttribute("gjcxfdl", JsonUtil.toJson(gjcxfdl));
		setAttribute("gjwr", JsonUtil.toJson(gjwr));
		setAttribute("gjrjzkl", JsonUtil.toJson(gjrjzkl));
		setAttribute("czwr", JsonUtil.toJson(czwr));
		setAttribute("czrjzkl", JsonUtil.toJson(czrjzkl));
		setAttribute("hyc", JsonUtil.toJson(hyc));
		setAttribute("hyzl", JsonUtil.toJson(hyzl));

		return "dpzs/dp/jt";
	}

	private List<Integer> getCurYears(int count) {
		Calendar now = Calendar.getInstance();
		int curYear = now.get(Calendar.YEAR);
		List<Integer> year = new ArrayList<Integer>();
		for (int i = 0; i < count; i++) {
			year.add(curYear - count + i);
		}

		return year;
	}

	/**
	 * 大屏展示—人口
	 * 
	 * @return
	 */
	@RequestMapping(value = "/toDpRk", method = RequestMethod.GET)
	public String toDpRk() {
		return "dpzs/dp/rk";
	}

	@Autowired
	private RmshService rmshService;

	@RequestMapping(value = "/toPage", method = RequestMethod.GET)
	public String toPage() {
		return "fzjc/hgjj/peopleLive";
	}

	/**
	 * 人民生活页面左上角基本概况数据
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getRmshGksj", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public JsonResult getRmshGksj() {
		RmshGksj rmshGksj = rmshService.getRmshGksj();
		return jsonResult(200, "数据获取成功", rmshGksj);
	}

	/**
	 * 历年数据变化情况
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getRmshLnshList", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public JsonResult getRmshLnshList() {
		List<RmshLnsh> list = rmshService.getRmshLnshList();
		return jsonResult(200, "数据获取成功", list);
	}

	/**
	 * 居民消费价格基本情况
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getRmshXfjgList", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public JsonResult getRmshXfjgList() {
		List<RmshXfjg> list = rmshService.getRmshXfjgList();
		return jsonResult(200, "数据获取成功", list);
	}

	/**
	 * 城镇居民人均可支配收入情况
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getRmshShruList", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public JsonResult getRmshShruList() {
		RmshShru shru = rmshService.getRmshShruList();
		return jsonResult(200, "数据获取成功", shru);
	}

	@Autowired
	private PdistributionServie pdistributionServie;

	@RequestMapping(value = "/getPdistributionByYear", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public JsonResult getPdistributionByYear(@RequestParam(required = false) String year) {
		if (year == null) {
			Calendar a = Calendar.getInstance();
			year = a.get(Calendar.YEAR) + "";
		}
		List<Distribution> plist = pdistributionServie.getPdistributionByYear(year);
		return jsonResult(200, "数据获取成功", plist);
	}

	@RequestMapping(value = "/getSixNumber", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public JsonResult getSixNumber() {
		List<Scale> plist = pdistributionServie.getSixNumber();
		return jsonResult(200, "数据获取成功", plist);
	}
     /**
      * 查询新生儿性别比
      * @return
      */
	@RequestMapping(value = "/getNewBornList", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public JsonResult getNewBornList() {
		List<Newborn> plist = pdistributionServie.getNewBornList();
		return jsonResult(200, "数据获取成功", plist);
	}

	@RequestMapping(value = "/getAgestructureList", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public JsonResult getAgestructureList() {
		List<Agestructure> alist = pdistributionServie.getAgestructureList();
		return jsonResult(200, "数据获取成功", alist);
	}

	@Autowired
	private PmigrantService pmigrantService;

	/**
	 * 全市流动人口变化
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getMigrantList", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public JsonResult getMigrantList() {
		List<Migrant> mlist = pmigrantService.getMigrantList();
		return jsonResult(200, "数据获取成功", mlist);
	}

	/**
	 * 流出人口学历及收入（元）
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getEduincomeList", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public JsonResult getEduincomeList() {
		List<Eduincome> elist = pmigrantService.getEduincomeList();
		return jsonResult(200, "数据获取成功", elist);
	}

	/**
	 * 流出(入)人口职业分布(单位：万人)
	 * 
	 * @param type
	 *            1流出人口，2流入人口
	 * @return json
	 */
	@RequestMapping(value = "/getJobdistributionByType", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public JsonResult getJobdistributionByType(@RequestParam String type) {
		List<Jobdistribution> jlist = pmigrantService.getJobdistributionByType(type);
		return jsonResult(200, "数据获取成功", jlist);
	}

	/**
	 * 流出人口来源分布
	 * 
	 * @param year
	 *            年份
	 * @return json
	 */
	@RequestMapping(value = "/getOutflowsourceListByYear", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public JsonResult getOutflowsourceListByYear(@RequestParam(required = false) String year) {
		List<Outflowsource> jlist = pmigrantService.getOutflowsourceListByYear(year);
		return jsonResult(200, "数据获取成功", jlist);
	}

	/**
	 * 人口流动图
	 * 
	 * @return json
	 */
	@RequestMapping(value = "/getMigrationList", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public JsonResult getMigrationList() {
		List<Migration> jlist = pmigrantService.getMigrationList();
		return jsonResult(200, "数据获取成功", jlist);
	}

	/**
	 * 获取地图数据 type 1 流出 0流入
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getDtsj", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public JsonResult getDtsj(String type) {
		List<Migration> jlist = pmigrantService.getDtsj(type);
		return jsonResult(200, "数据获取成功", jlist);
	}

}
