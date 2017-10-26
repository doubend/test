package com.cloud.icenter.system.user.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.icenter.base.controller.ModelAction;
import com.cloud.icenter.common.utils.JsonResult;
import com.cloud.icenter.common.utils.Pagination;
import com.cloud.icenter.common.utils.SystemConfig;
import com.cloud.icenter.common.utils.TreeNode;
import com.cloud.icenter.system.organ.service.OrganService;
import com.cloud.icenter.system.role.pojo.Role;
import com.cloud.icenter.system.role.service.RoleService;
import com.cloud.icenter.system.user.pojo.User;
import com.cloud.icenter.system.user.service.UserService;

/**
 * 用户管理
 * @author zhangle
 */
@Controller
@RequestMapping(value="/system/user")
public class UserAction extends ModelAction<User>{
	
    @Autowired private UserService userService;
    @Autowired private RoleService roleService;
    
    @Autowired
    private OrganService organService;
    
    /**
     * 跳到用户列表页面
     */
    @RequestMapping(method=RequestMethod.GET)
	public String list() {
		return "system/user/user-list";
	}
    
    @RequestMapping(value="/query",method=RequestMethod.GET)
    public String query() {
    	return "system/user/user-query";
    }
    
    /**
	 * 查询用户
	 */
    @RequestMapping(value="/query",method=RequestMethod.POST)
	public void query(User param) {
		DetachedCriteria criteria=getPagination().getCriteria();
		if(!StringUtils.isEmpty(param.getUsername())) {
			criteria.add(Restrictions.like("username",param.getUsername(),MatchMode.ANYWHERE));
		}
		if(!StringUtils.isEmpty(param.getNickname())) {
			criteria.add(Restrictions.like("nickname", param.getNickname(),MatchMode.ANYWHERE));
		}
		if(param.getStatus()!=null) {
			criteria.add(Restrictions.eq("status", param.getStatus()));
		}
		criteria.addOrder(Order.desc("createdAt"));
		userService.find(getPagination());
		printJson(getPagination());
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add() {
		return "system/user/user-add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult doAdd(@RequestBody User user) {
		user.setCreatorId(getLoginUser().getUserId());
		userService.addUser(user);
		return jsonResult(200, "OK");
	}
	
	/**
	 * 检查用户是否存在
	 * @param username
	 * @return code:200 表示不存在,code:-1 表示已存在
	 */
	@RequestMapping(value="/check_user",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult checkUser(String username) {
		boolean exist=userService.getUserByName(username)!=null;
		boolean isChinese=userService.isChinese(username);
		if(exist||isChinese) {
			return jsonResult(-1, "already exists");
		} else {
			return jsonResult(200, "not exist");
		}
	}
	
	@RequestMapping(value="/update/{id}",method=RequestMethod.GET)
	public String update(@PathVariable String id) {
		User user=userService.get(id);
		setAttribute("user", user);
		return "system/user/user-update";
	}
	
	@RequestMapping(value="/update/{id}",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult doUpdate(@PathVariable String id,@RequestBody User param) {
		
		User user=userService.get(id);
		user.setNickname(param.getNickname());
		user.setStatus(param.getStatus());
		user.setDescription(param.getDescription());
		user.setCheckedRoleId(param.getCheckedRoleId());
		user.setDataRight(param.getDataRight());
		userService.update(user);
		
		return jsonResult(200, "OK");
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult doDelete(@PathVariable String id) {
		userService.delete(id);
		return jsonResult(200, "OK");
	}
    
    /**
	 * 为用户分配角色时,返回角色的树形组件的json对象
	 */
	@RequestMapping(value="/role_tree",method={RequestMethod.GET,RequestMethod.POST})
    public void roleTree(@RequestParam(value="userId",required=false) String userId) {
    	
		List<Role> roles=roleService.findAll();
    	List<TreeNode> tree=new ArrayList<TreeNode>(roles.size());
		
    	List<Role> selectedRoles=Collections.EMPTY_LIST;
    	if(!StringUtils.isBlank(userId)) {
    		selectedRoles=roleService.findRoleByUserId(userId,null);
    	}
    	
    	String guestRoleName=SystemConfig.getProperty("system.role.guest");
    	String devRoleName=SystemConfig.getProperty("system.role.developer");
		for(Role r:roles) {
			if(r.getRoleName().equals(guestRoleName)) continue;	//guest角色不能被分配
			if(r.getRoleName().equals(devRoleName)) {				//只有拥有developer角色的用户才能分配developer角色给别人
				if(!getLoginUser().hasRole(devRoleName)) continue;
			}
			
			TreeNode node=new TreeNode();
			node.setId(r.getRoleId());
			node.setText(r.getRoleName());
			node.setChecked(selectedRoles.contains(r));
			node.setIconCls("fa fa-user-secret");
			tree.add(node);
		}
		printJson(tree);
    }
	
	@RequestMapping(value="/password/{id}",method=RequestMethod.GET)
	public String password(@PathVariable String id) {
		User user=userService.get(id);
		setAttribute("user", user);
		return "system/user/user-password";
	}
	
	@RequestMapping(value="/password/{id}",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult doPassword(@PathVariable String id,@RequestParam String password) {
		try {
			userService.updatePassword(id, password);
		} catch(Exception e) {
			return jsonResult(-1, e.getMessage());
		}
		return jsonResult(200, "OK");
	}
    

	
	/**
	 * 获取在某个组织机构内的所有人员列表
	 * 包含子机构
	 * @param orgId
	 */
	@RequestMapping(value = "/orgUserList/{orgId}" , method = RequestMethod.POST)
	public void getUserByOrgId(@PathVariable String orgId , @RequestParam(value = "params" , required = false)String params){
		List<String> childrenIds = organService.getAllChildrenIds(orgId, User.STATUS_DEFAULT);
		Pagination<User> pagin = this.getPagination();
		childrenIds.add(orgId);
		userService.findByOrgId(pagin, childrenIds.toArray(new String[0]), params);
		printJson(pagin);
	}
	
	/**
	 * 根据orgId 获取不在某个组织机构的人员列表
	 * @param orgId
	 * @param params
	 */
	@RequestMapping(value = "/notInOrgUsers" , method = RequestMethod.POST)
	public void getNotInOrgIdUsers(@RequestParam("orgId")String orgId , @RequestParam(value = "params" , required = false)String params){
		Pagination<User> pagin = this.getPagination();
		userService.findNotInOrg(pagin, orgId, params);
		printJson(pagin);
	}
	
}
