package com.cloud.icenter.system.syssession.controller;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.icenter.base.controller.ModelAction;
import com.cloud.icenter.common.utils.DateUtil;
import com.cloud.icenter.common.utils.JsonResult;
import com.cloud.icenter.common.utils.Md5Util;
import com.cloud.icenter.common.utils.StringUtil;
import com.cloud.icenter.system.syssession.pojo.SysSession;
import com.cloud.icenter.system.syssession.service.SysSessionService;
import com.cloud.icenter.system.user.pojo.User;
import com.cloud.icenter.system.user.service.UserService;

/**
 * 数据签名公私钥对表 
 * 
 * @author yht 2015-07-10 first create
 */
@Controller
@RequestMapping(value = "/system/session")
public class SysSessionAction extends ModelAction<SysSession> {
	@Autowired
	private SysSessionService sysSessionService;
	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public String list() {
		return "system/session/syssession-list";
	}

	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public String query() {
		return "system/session/syssession-query";
	}

	@RequestMapping(value = "/query", method = RequestMethod.POST)
	public void query(SysSession syssession) {
		DetachedCriteria criteria = getPagination().getCriteria();
		if (!StringUtil.isEmpty(syssession.getUserName())) {
			criteria.add(Restrictions.like("userName", syssession.getUserName(), MatchMode.ANYWHERE));
		}
		criteria.add(Restrictions.isNull("deletedAt"));
		criteria.addOrder(Order.desc("createdAt"));
		sysSessionService.find(getPagination());
		
		printJson(getPagination());
	}

	/**
	 * 查询用户
	 */
	@RequestMapping(value = "/queryUser", method = RequestMethod.POST)
	public void queryUser() {
		DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		String q = getParameter("q");

		if (!StringUtils.isEmpty(q)) {
			criteria.add(Restrictions.like("username", q, MatchMode.ANYWHERE));
		}
		criteria.add(Restrictions.eq("status", 0));
		//userService.find(criteria);
		printJson(userService.find(criteria));
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		return "system/session/syssession-add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult doAdd(@RequestBody SysSession syssession) {
		try {
			User u =userService.get(syssession.getUserId());
			if (u==null) {
				return jsonResult(-1, "该用户不存在");
			}
			DetachedCriteria criteria = DetachedCriteria.forClass(SysSession.class);
			criteria.add(Restrictions.eq("userId", syssession.getUserId()));
			criteria.add(Restrictions.isNull("deletedAt"));
			if (sysSessionService.find(criteria).size()>0) {
				return jsonResult(-1, "该用户已有密钥");
			}
			Date toDate=DateUtil.parse(DateUtil.date2Str(syssession.getValidEndTime(), "yyyy-MM-dd") +" 23:59:59", "yyyy-MM-dd HH:mm:ss");
			syssession.setUserName(u.getUsername());
			syssession.setCreatedAt(new Date());
			syssession.setValidEndTime(toDate);
			syssession.setSecretKey(Md5Util.randomUUID());
			syssession.setSessionKey(Md5Util.randomUUID());
			sysSessionService.add(syssession);
		} catch (Exception e) {
			return jsonResult(-1, e.getMessage());
		}
		return jsonResult(200, "OK");
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable String id) {
		SysSession syssession = sysSessionService.get(id);
		setAttribute("syssession", syssession);
		return "system/session/syssession-update";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult doDelete(@PathVariable String id) {
		try {
			SysSession syssession = sysSessionService.get(id);
			syssession.setDeleted(1);
			syssession.setDeletedAt(new Date());
			sysSessionService.update(syssession);
		} catch (Exception e) {
			return jsonResult(-1, e.getMessage());
		}
		return jsonResult(200, "OK");
	}

	@RequestMapping(value = "/rebuidkey/{id}", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult reBuidKey(@PathVariable String id) {
		try {
			SysSession syssession = sysSessionService.get(id);
			//Date toDate=DateUtil.parse(getParameter("validEndTime")+" 23:59:59", "yyyy-MM-dd HH:mm:ss");
			syssession.setUserName(userService.get(syssession.getUserId()).getUsername());
			syssession.setSecretKey(Md5Util.randomUUID());
			syssession.setSessionKey(Md5Util.randomUUID());
			sysSessionService.update(syssession);
		} catch (Exception e) {
			return jsonResult(-1, e.getMessage());
		}
		return jsonResult(200, "OK");
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult doUpdate(@PathVariable String id,
			@RequestBody SysSession param) {
		try {
			SysSession syssession = sysSessionService.get(id);
			// syssession.setSessionId(param.getSessionId());
			// syssession.setCreatedAt(param.getCreatedAt());
			// syssession.setSessionKey(param.getSessionKey());
			// syssession.setSecretKey(param.getSecretKey());
			// syssession.setUserId(param.getUserId());
			Date toDate=DateUtil.parse(DateUtil.date2Str(param.getValidEndTime(), "yyyy-MM-dd") +" 23:59:59", "yyyy-MM-dd HH:mm:ss");
			syssession.setValidBeginTime(param.getValidBeginTime());
			syssession.setValidEndTime(toDate);
			syssession.setStatus(param.getStatus());
			// syssession.setDeleted(param.getDeleted());
			// syssession.setDeletedAt(param.getDeletedAt());
			sysSessionService.update(syssession);
		} catch (Exception e) {
			return jsonResult(-1, e.getMessage());
		}
		return jsonResult(200, "OK");
	}
}
