package com.cloud.icenter.yyzx.fzjc.rk.controller;

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
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Agestructure;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Distribution;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Newborn;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Scale;
import com.cloud.icenter.yyzx.fzjc.rk.service.PdistributionServie;

/**
 * 人口分布
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "/fzjc/distribution")
public class PdistributionController extends BaseAction {

	@Autowired
	private PdistributionServie pdistributionServie;
      /**
       * 人口分布查询
       * @param year
       * @return
       */
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

	public static void main(String[] args) {
		Calendar a = Calendar.getInstance();
		System.out.println(a.get(Calendar.YEAR));// 得到年
	}

}
