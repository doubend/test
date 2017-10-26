package com.cloud.icenter.yyzx.dpzs.dp.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.cloud.icenter.base.controller.ModelAction;
import com.cloud.icenter.common.utils.JsonUtil;
import com.cloud.icenter.common.utils.Pagination;
import com.cloud.icenter.common.utils.StringUtil;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpzsJjfzGmgyPojo;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpzsJjfzPojo;
import com.cloud.icenter.yyzx.dpzs.dp.service.DpzsJjfzGmgyService;
import com.cloud.icenter.yyzx.dpzs.dp.service.DpzsJjfzService;

/** 
* @author zhucy 
* @version 2017年3月27日 下午5:33:33 
* 大屏展示>经济发展
*/
@Controller
@RequestMapping("/dp/dpzsJjfzAction")
public class DpzsJjfzAction extends ModelAction<DpzsJjfzPojo>{
	@Autowired
	private DpzsJjfzService dpzsJjfzService;
	
	@Autowired
	private DpzsJjfzGmgyService dpzsJjfzGmgyService;
	
	@RequestMapping(value = "/toJjfz",method=RequestMethod.GET)
	public String toJjfz(){
		List<DpzsJjfzPojo> dpzsJjfzPojos = this.dpzsJjfzService.getList();
		if (null != dpzsJjfzPojos && dpzsJjfzPojos.size() > 0 ) {
			BigDecimal total = BigDecimal.ZERO;
			total = dpzsJjfzPojos.get(0).getNycz()
					.add(dpzsJjfzPojos.get(0).getLycz())
					.add(dpzsJjfzPojos.get(0).getMycz())
					.add(dpzsJjfzPojos.get(0).getYycz());
			dpzsJjfzPojos.get(0).setNyczzb(dpzsJjfzPojos.get(0).getNycz().multiply(new BigDecimal(100)).divide(total,2,BigDecimal.ROUND_HALF_UP));
			dpzsJjfzPojos.get(0).setLyczzb(dpzsJjfzPojos.get(0).getLycz().multiply(new BigDecimal(100)).divide(total,2,BigDecimal.ROUND_HALF_UP));
			dpzsJjfzPojos.get(0).setMyczzb(dpzsJjfzPojos.get(0).getMycz().multiply(new BigDecimal(100)).divide(total,2,BigDecimal.ROUND_HALF_UP));
			dpzsJjfzPojos.get(0).setYyczzb(dpzsJjfzPojos.get(0).getYycz().multiply(new BigDecimal(100)).divide(total,2,BigDecimal.ROUND_HALF_UP));
			setAttribute("po", dpzsJjfzPojos.get(0));//获取数据基本信息
		}
		//获取规模以上工业增加值及增速
		List<DpzsJjfzGmgyPojo> list = this.dpzsJjfzGmgyService.getDpzsJjfzGmgyList();
		List<Integer> yearList = new ArrayList<Integer>();
		List<BigDecimal> zjzList = new ArrayList<BigDecimal>();
		List<BigDecimal> zsList = new ArrayList<BigDecimal>();
		if (null != list && list.size() > 0) {
			for (int i = list.size()-1; i >= 0; i--) {
				System.out.println(list.get(i).getYear());
				yearList.add(list.get(i).getYear());
				zjzList.add(list.get(i).getZjz());
				zsList.add(list.get(i).getZs());
			}
		}
		//获取省内排名
		List<Map<String, Object>> snpm = this.dpzsJjfzGmgyService.getSnpm();
		setAttribute("snpm", snpm);
		setAttribute("yearList", JsonUtil.toJson(yearList));
		setAttribute("zjzList", JsonUtil.toJson(zjzList));
		setAttribute("zsList", JsonUtil.toJson(zsList));
		return "dpzs/dp/jjfz";
	}
	
}
