
package com.cloud.icenter.yyzx.fzjc.rkgx.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.icenter.base.controller.ModelAction;
import com.cloud.icenter.common.utils.JsonResult;
import com.cloud.icenter.common.utils.JsonUtil;
import com.cloud.icenter.common.utils.PagingUtil;
import com.cloud.icenter.yyzx.fzjc.rkgx.service.RenkJbxxService;
import com.cloud.icenter.yyzx.fzjc.rkgx.pojo.RenkJbxx;
import com.cloud.icenter.yyzx.fzjc.rkgx.pojo.SerchParam;


/**
 * 
 * @date 2017年9月19日
 * @author dxliug
 */
@Controller
@RequestMapping(value="/fzjc/rkgx")
public class RenkJbxxAction extends ModelAction<RenkJbxx>  {

@Autowired private RenkJbxxService renkJbxxService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String list() {
		return "renkjbxx/renkjbxx-list";
	}
    
    @RequestMapping(value="/query",method=RequestMethod.GET)
    public String query() {
    	return "renkjbxx/renkjbxx-query";
    }
    
   @RequestMapping(value="/add",method=RequestMethod.GET)
	public String add() {
		return "renkjbxx/renkjbxx-add";
	}
    
     /**
 	 * 查询
     * @throws ParseException 
 	 */
     @RequestMapping(value="/query",method=RequestMethod.POST)
 	public void query(SerchParam param) throws ParseException {
    	DetachedCriteria criteria=getPagination().getCriteria();
 
    	if(!StringUtils.isEmpty(param.getName())){
    		criteria.add(Restrictions.like("xingming", param.getName(), MatchMode.ANYWHERE));
    	}
    	if(!StringUtils.isEmpty(param.getSfz())){
    		criteria.add(Restrictions.like("sfzhm", param.getSfz(), MatchMode.ANYWHERE));
    	}
    	if(!StringUtils.isEmpty(param.getXb())){
    		criteria.add(Restrictions.like("xingbie", param.getXb(), MatchMode.ANYWHERE));
    	}
    	if(!StringUtils.isEmpty(param.getQxdm())){
    		criteria.add(Restrictions.like("jzdxzqhbm", param.getQxdm(), MatchMode.ANYWHERE));
    	}
    	if(!StringUtils.isEmpty(param.getMz())){
    		if("汉".equals(param.getMz()) || "回".equals(param.getMz())){
    			criteria.add(Restrictions.like("minzu", param.getMz(), MatchMode.ANYWHERE));
    		}
    		else{
    			criteria.add(Restrictions.ne("minzu", "汉"));
    			criteria.add(Restrictions.ne("minzu", "回"));
    		}
    	}
    	
    	if(!StringUtils.isEmpty(param.getKssj()) && !StringUtils.isEmpty(param.getJssj())){
    		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        	Date ksDate = format.parse(param.getKssj());
        	Date jsDate = format.parse(param.getJssj());
    		criteria.add(Restrictions.between("csrq", ksDate, jsDate));
    	}
    	 
    	//criteria.addOrder(Order.desc("XingMing"));
    	
 		renkJbxxService.find(getPagination());
 		String json = JsonUtil.toJson(getPagination().getDataList()); 
 		printJson(json);
 	}
     
     
    
    @RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult doAdd(@RequestBody RenkJbxx renkJbxx) {
		try {
		//renkJbxx.setCreateDate(new Date());
		//renkJbxx.setCreateUserId(getLoginUser().getUserId());
		renkJbxxService.add(renkJbxx);
		} catch (Exception e) {
			return jsonResult(-1, e.getMessage());
		}
		return jsonResult(200, "OK");
	}
    
    @RequestMapping(value="/update/{id}",method=RequestMethod.GET)
	public String update(@PathVariable String id) {
		RenkJbxx renkJbxx=renkJbxxService.get(id);
		setAttribute("renkJbxx", renkJbxx);
		return "renkjbxx/renkjbxx-update";
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult doDelete(@PathVariable String id) {
		try {
		renkJbxxService.delete(id);
		} catch (Exception e) {
			return jsonResult(-1, e.getMessage());
		}
		return jsonResult(200, "OK");
	}

	@RequestMapping(value="/update/{id}",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult doUpdate(@PathVariable String id,@RequestBody RenkJbxx param) {
		try {
		//param.setEditDate(new Date());
		//param.setEditUserId(getLoginUser().getUserId());
		RenkJbxx renkJbxx=renkJbxxService.get(id);
						
		renkJbxx.setSfzhm (param.getSfzhm ()); // 身份证号码 				
		renkJbxx.setXingming (param.getXingming ()); // 姓名 				
		renkJbxx.setCsrq (param.getCsrq ()); // 出生日期：YYYY-MM-DD 				
		renkJbxx.setXingbie (param.getXingbie ()); // 性别：0男；1女 				
		renkJbxx.setMinzu (param.getMinzu ()); // 民族 				
		renkJbxx.setLphbsm (param.getLphbsm ()); // 楼牌号标识码 				
		renkJbxx.setXqmc (param.getXqmc ()); // 小区名称 				
		renkJbxx.setLph (param.getLph ()); // 楼牌号 				
		renkJbxx.setXxdz (param.getXxdz ()); // 详细地址 				
		renkJbxx.setJzdxzqhbm (param.getJzdxzqhbm ()); // 居住地行政区划编码 				
		renkJbxx.setJzdxzqhmc (param.getJzdxzqhmc ()); // 居住地行政区划名称：大武口区 				
		renkJbxx.setDcrq (param.getDcrq ()); // 调查日期：YYYY-MM-DD 				
		renkJbxx.setSwzt (param.getSwzt ()); // 死亡状态：0生；1死 				
		renkJbxx.setSwrq (param.getSwrq ()); // 死亡日期：YYYY-MM-DD 				
		renkJbxx.setKsrzrq (param.getKsrzrq ()); // 开始入住日期：YYYY-MM-DD 				
		renkJbxx.setCssj (param.getCssj ()); // 出生时间：HH:MM:SS 				
		renkJbxx.setCsdxzqhbm (param.getCsdxzqhbm ()); // 出生地行政区划编码 				
		renkJbxx.setCsdxzqhmc (param.getCsdxzqhmc ()); // 出生地行政区划名称 				
		renkJbxx.setGuoji (param.getGuoji ()); // 国籍 				
		renkJbxx.setCsyebm (param.getCsyebm ()); // 出生婴儿别名 				
		renkJbxx.setMqrkbsm (param.getMqrkbsm ()); // 母亲人口标识码 				
		renkJbxx.setMqsfzhm (param.getMqsfzhm ()); // 母亲身份证号码 				
		renkJbxx.setMqxm (param.getMqxm ()); // 母亲姓名 				
		renkJbxx.setMqnl (param.getMqnl ()); // 母亲年龄 				
		renkJbxx.setMqgj (param.getMqgj ()); // 母亲国籍 				
		renkJbxx.setMqmz (param.getMqmz ()); // 母亲民族：汉族\回族\维吾尔族\蒙古族 等 				
		renkJbxx.setFqrkbsm (param.getFqrkbsm ()); // 父亲人口标识码 				
		renkJbxx.setFqsfzhm (param.getFqsfzhm ()); // 父亲身份证号码 				
		renkJbxx.setFqxm (param.getFqxm ()); // 父亲姓名 				
		renkJbxx.setFqnl (param.getFqnl ()); // 父亲年龄 				
		renkJbxx.setFqgj (param.getFqgj ()); // 父亲国籍 				
		renkJbxx.setFqmz (param.getFqmz ()); // 父亲民族：汉族\回族\维吾尔族\蒙古族 等 				
		renkJbxx.setJsjgmc (param.getJsjgmc ()); // 接生机构名称 				
		renkJbxx.setFzrq (param.getFzrq ()); // 发证日期：YYYY-MM-DD 		
		renkJbxxService.update(renkJbxx);
		} catch (Exception e) {
			return jsonResult(-1, e.getMessage());
		}
		return jsonResult(200, "OK");
	}

}

