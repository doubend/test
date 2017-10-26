package com.cloud.icenter.yyzx.yqzs.ggzs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cloud.icenter.base.controller.BaseAction;
@Controller
@RequestMapping(value="/PublicOpinion")
public class PublicOpinionController extends BaseAction{
	/**
	 * 辅助决策—舆情首页
	 * @return
	 */
	@RequestMapping(value="/sy",method=RequestMethod.GET)
    public String syInfo() {
    	return "consensus/shyq";
    }
	/**
	 * 辅助决策—公共展示
	 * @return
	 */
	@RequestMapping(value="/ggzs",method=RequestMethod.GET)
    public String ggzsInfo() {
    	return "consensus/ggzs";
    }
	/**
	 * 辅助决策—指挥大厅
	 * @return
	 */
	@RequestMapping(value="/zhdt",method=RequestMethod.GET)
    public String zhdtInfo() {
    	return "consensus/zhdt";
    }
}
