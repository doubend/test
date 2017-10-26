package com.cloud.icenter.yyzx.fzjc.rk.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cloud.icenter.base.controller.BaseAction;
import com.cloud.icenter.yyzx.fzjc.rk.service.PmigrantService;
/**
 * 辅助决策--人口基本信息
 * @date 2017年9月19日
 * @author dxliug
 */
@Controller
@RequestMapping(value="/fzjc/pop")
public class PopController extends BaseAction{
	@Autowired
	private PmigrantService pmigrantService;
	
	/**
	 * 辅助决策—人口——人口分布
	 * @return
	 */
	@RequestMapping(value="/rkfb",method=RequestMethod.GET)
    public String distribution() {
    	return "fzjc/rk/distribution";
    }
	
	
	/**
	 * 辅助决策—人口——流动人口
	 * @return
	 */
	@RequestMapping(value="/ldrk",method=RequestMethod.GET)
    public String flowPop() {
		List<Map<String, Object>> result = this.pmigrantService.getLcAndLr();
		setAttribute("outsum", "0");
		setAttribute("intosum", "0");
		if (null != result && result.size() > 0) {
			Map<String, Object> obj = result.get(0);
			if (null != obj.get("outsum")) {
				setAttribute("outsum", obj.get("outsum"));
			}
			if (null != obj.get("intosum")) {
				setAttribute("intosum", obj.get("intosum"));
			}
		}
    	return "fzjc/rk/flowPop";
    }
	
}
