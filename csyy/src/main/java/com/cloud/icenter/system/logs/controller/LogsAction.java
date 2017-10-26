package com.cloud.icenter.system.logs.controller;

import java.util.Date;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.icenter.base.controller.ModelAction;
import com.cloud.icenter.common.utils.DateUtil;
import com.cloud.icenter.common.utils.JsonResult;
import com.cloud.icenter.common.utils.StringUtil;
import com.cloud.icenter.system.logs.pojo.Logs;
import com.cloud.icenter.system.logs.service.LogsService;

@Controller
@RequestMapping(value="/system/logs")
public class LogsAction extends ModelAction<Logs> {
	
	@Autowired private LogsService logsService;
	
	/**
     * 跳到日志列表页面
     */
    @RequestMapping(method=RequestMethod.GET)
	public String list() {
		return "system/logs/logs-list";
	}
    
    @RequestMapping(value="/query",method=RequestMethod.GET)
    public String query() {
    	return "system/logs/logs-query";
    }
    
    @RequestMapping(value="/query",method=RequestMethod.POST)
	public void query(Logs param) {
		
		DetachedCriteria criteria=getPagination().getCriteria();
		if(!StringUtil.isEmpty(param.getUsername())) {
			criteria.add(Restrictions.like("username", param.getUsername(),MatchMode.ANYWHERE));
		}
		if(!StringUtil.isEmpty(param.getHost())) {
			criteria.add(Restrictions.like("host", param.getHost(),MatchMode.ANYWHERE));
		}
		if(!StringUtil.isEmpty(param.getModule())) {
			criteria.add(Restrictions.like("module", param.getModule(),MatchMode.ANYWHERE));
		}
		if(!StringUtil.isEmpty(param.getEntity())) {
			criteria.add(Restrictions.like("entity", param.getEntity(),MatchMode.ANYWHERE));
		}
		if(!StringUtil.isEmpty(param.getType())) {
			criteria.add(Restrictions.eq("type", param.getType()));
		}
		if(!StringUtil.isEmpty(getParameter("fromDate"))) {
			Date fromDate=DateUtil.parse(getParameter("fromDate"), "yyyy-MM-dd");
			criteria.add(Restrictions.ge("createdAt", fromDate));
		}
		if(!StringUtil.isEmpty(getParameter("toDate"))) {
			Date toDate=DateUtil.parse(getParameter("toDate")+" 23:59:59", "yyyy-MM-dd HH:mm:ss");
			criteria.add(Restrictions.le("createdAt", toDate));
		}
		
		criteria.addOrder(Order.desc("createdAt"));
		logsService.find(getPagination());
		printJson(getPagination());
	}
    
    @RequestMapping(value="/view/{id}",method=RequestMethod.GET)
	public String view(@PathVariable String id) {
		Logs logs=logsService.get(id);
		setAttribute("logs", logs);
		return "system/logs/logs-view";
	}
    
    @RequestMapping(value="/clear",method=RequestMethod.GET)
    public String clear() {
    	return "system/logs/logs-clear";
    }
    @RequestMapping(value="/doClear",method=RequestMethod.POST)
    @ResponseBody
    public JsonResult doClear(@RequestParam(value="type",required=false) String type,
			@RequestParam(value="fromDate",required=false) String fromDate, @RequestParam(value="toDate",required=false) String toDate){
    	Date _fromDate = null;
    	Date _toDate = null;

		if(!StringUtil.isEmpty(fromDate)) {
			_fromDate = DateUtil.parse(fromDate, "yyyy-MM-dd");
		}
		if(!StringUtil.isEmpty(toDate)) {
			_toDate = DateUtil.parse(toDate+" 23:59:59", "yyyy-MM-dd HH:mm:ss");
		}
		logsService.deleteBetween(type,_fromDate, _toDate);
		return jsonResult(200, "OK");
    }
}
