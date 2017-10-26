package com.cloud.icenter.system.onlineuser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.icenter.base.controller.BaseAction;
import com.cloud.icenter.common.utils.JsonResult;
import com.cloud.icenter.common.utils.Pagination;
import com.cloud.icenter.system.onlineuser.pojo.OnlineUser;
import com.cloud.icenter.system.onlineuser.service.OnlineUserService;

/**
 * 用户管理
 * @author zhangle
 */
@Controller
@RequestMapping(value="/system/online_user")
public class OnlineUserAction extends BaseAction {
	
	@Autowired private OnlineUserService onlineUserService;

    /**
     * 在线用户列表页
     * @return
     */
	@RequestMapping(method=RequestMethod.GET)
    public String online() {
    	return "system/user/user-online-list";
    }
    
    /**
     * 查询在线用户
     */
	@RequestMapping(value="/query",method=RequestMethod.POST)
    public void query() {
    	Pagination<OnlineUser> pagin=new Pagination<OnlineUser>(0,10000);
    	List<OnlineUser> users=onlineUserService.getOnlineUsers();
    	pagin.setPageSize(users.size());
    	pagin.setTotalCount(users.size());
    	pagin.setDataList(users);
    	printJson(pagin);
    }
	
	@RequestMapping(value="/logout/{sessionId}",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult logout(@PathVariable String sessionId) {
		if(getSession().getId().equals(sessionId)) {
			return jsonResult(-1, "不能注销当前登录用户!");
		}
		onlineUserService.delete(sessionId);
		return jsonResult(200, "OK");
	}
}
