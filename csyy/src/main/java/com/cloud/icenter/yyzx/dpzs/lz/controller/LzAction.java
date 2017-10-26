package com.cloud.icenter.yyzx.dpzs.lz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cloud.icenter.base.controller.BaseAction;
import com.cloud.icenter.yyzx.dpzs.lz.pojo.LzJtcxPojo;
import com.cloud.icenter.yyzx.dpzs.lz.pojo.LzMinshengPojo;
import com.cloud.icenter.yyzx.dpzs.lz.service.LzService;

/**
 * 精准扶贫后台
 * 
 * @author dbchega
 */
@Controller
@RequestMapping(value = "/lz")
public class LzAction extends BaseAction {
	private static final int SHUCAI = 1;// 蔬菜
	private static final int ROUDAN = 2;// 肉蛋
	private static final int ZHUSHI = 3;// 主食

	@Autowired
	private LzService lzService;

	/**
	 * 专题分析-精准扶贫-脱贫规划
	 * 
	 * @return
	 */
	@RequestMapping(value = "/rmsh", method = RequestMethod.GET)
	public String rmsh() {

		List<LzMinshengPojo> shucaiList = lzService.getCurMinsheng(SHUCAI);
		List<LzMinshengPojo> roudanList = lzService.getCurMinsheng(ROUDAN);
		List<LzMinshengPojo> zhushiList = lzService.getCurMinsheng(ZHUSHI);

		setAttribute("shucaiList", shucaiList);
		setAttribute("roudanList", roudanList);
		setAttribute("zhushiList", zhushiList);

		return "dpzs/lz/column-People";
	}

	/**
	 * 专题分析-精准扶贫-脱贫规划
	 * 
	 * @return
	 */
	@RequestMapping(value = "/jtcx", method = RequestMethod.GET)
	public String jtcx() {

		LzJtcxPojo jtcx = lzService.getCurJtcx();
		setAttribute("jtcx", jtcx);

		return "dpzs/lz/column-traffic";
	}

}
