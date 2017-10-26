package com.cloud.icenter.system.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.icenter.base.controller.BaseAction;
import com.cloud.icenter.common.utils.JsonResult;
import com.cloud.icenter.common.utils.Md5Util;
import com.cloud.icenter.common.utils.Pagination;
import com.cloud.icenter.system.onlineuser.pojo.OnlineUser;
import com.cloud.icenter.system.organ.pojo.Organ;
import com.cloud.icenter.system.organ.service.OrganService;
import com.cloud.icenter.system.user.pojo.User;
import com.cloud.icenter.system.user.service.UserService;

/**
 * 用户管理
 * @author zhangle
 */
@Controller
@RequestMapping(value="/system/user_setup")
public class UserSetupAction extends BaseAction {
	
	@Autowired private UserService userService;
	@Autowired private OrganService organService;
    
    /**
     * 在线用户列表页
     * @return
     */
	@RequestMapping(method=RequestMethod.GET)
    public String setup() {
		setAttribute("loginUser", getLoginUser());
    	return "system/user/user-setup";
    }
    
	@RequestMapping(value="/basic",method=RequestMethod.POST)
	@ResponseBody
    public JsonResult setupUser(User param) {
		
		User loginUser=getLoginUser();
		User user=userService.get(loginUser.getUserId());	//从数据库查询出最新的用户对象
		user.setNickname(param.getNickname());
		user.setDescription(param.getDescription());
		userService.update(user);						//修改用户信息
		
		loginUser.setNickname(param.getNickname());		//刷新"登录用户对象"
		loginUser.setDescription(param.getDescription());
		return jsonResult(200, "OK");
	}
	
	@RequestMapping(value="/password",method=RequestMethod.POST)
	@ResponseBody
    public JsonResult setupPassword(String oldpwd,String newpwd) {
		
		User loginUser=getLoginUser();
		User user=userService.get(loginUser.getUserId());						//从数据库查询出最新的用户对象
		
		String _oldpwd=Md5Util.makePassword(oldpwd, user.getSalt());		//检查原密码是否正确
		if(!_oldpwd.equals(user.getPassword())) {
			return jsonResult(-1, "原密码不正确!");
		}
		try {
			userService.updatePassword(user.getUserId(), newpwd);
		} catch(Exception e) {
			return jsonResult(-1, e.getMessage());
		}
		return jsonResult(200, "OK");
	}
	
	@RequestMapping(value="/emp",method=RequestMethod.POST)
	@ResponseBody
    public JsonResult setupEmp(String empId) {
		
		OnlineUser loginUser=getLoginUser();
		organService.setMainEmployee(loginUser.getUserId(), empId);
		
		//刷新用户组织信息
		Organ emp=organService.getMainEmployee(loginUser.getUserId());
		if(emp!=null) {
			List<Organ> emps=organService.getOrgansByUserId(loginUser.getUserId());
			Organ dept=organService.getMainDepartment(loginUser.getUserId());
			List<Organ> parents=organService.getParents(emp.getOrgId());
			loginUser.setEmployee(emp);
			loginUser.setEmployees(emps);
			loginUser.setDepartment(dept);
			loginUser.setParents(parents);
		}
		return jsonResult(200, "OK");
	}
	
	/**
     * 当前用户对应的所有员工列表
     */
	@RequestMapping(value="/emps",method=RequestMethod.POST)
    public void emps() {
    	User loginUser = getLoginUser();
    	
    	 List<Organ> emps = organService.getOrgansByUserId(loginUser.getUserId());
		for(int i=0; i<emps.size();i++) {
			Organ emp = emps.get(i);
			List<Organ> parents = organService.getParents(emp.getOrgId());
			
			StringBuilder sb = new StringBuilder("/");
			for(int j=parents.size()-1; j>=0; j--) {
				Organ p = parents.get(j);
				sb.append(p.getName());
				if(j>0) sb.append("/");
			}
			emp.setName(sb.toString());
		}
		
		Pagination<Organ> pagin=new Pagination<Organ>(0,10000);
    	pagin.setPageSize(emps.size());
    	pagin.setTotalCount(emps.size());
    	pagin.setDataList(emps);
    	printJson(pagin);
    }
}
