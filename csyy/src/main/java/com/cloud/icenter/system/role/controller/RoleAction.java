package com.cloud.icenter.system.role.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.icenter.base.controller.ModelAction;
import com.cloud.icenter.common.utils.JsonResult;
import com.cloud.icenter.common.utils.TreeNode;
import com.cloud.icenter.system.function.pojo.Function;
import com.cloud.icenter.system.function.service.FunctionService;
import com.cloud.icenter.system.role.pojo.Role;
import com.cloud.icenter.system.role.service.RoleService;
import com.cloud.icenter.system.user.service.UserService;

/**
 * 角色管理
 * @author zhangle
 */
@Controller
@RequestMapping(value="/system/role")
public class RoleAction extends ModelAction<Role> {

	@Autowired private RoleService roleService;
	@Autowired private FunctionService  functionService;
	@Autowired private UserService userService;
    @RequestMapping(method=RequestMethod.GET)
	public String list() {
		return "system/role/role-list";
	}
    
    @RequestMapping(value="/query",method=RequestMethod.GET)
    public String query() {
    	return "system/role/role-query";
    }
    
    @RequestMapping(value="/query",method=RequestMethod.POST)
	public void query(Role param) {
		
		DetachedCriteria criteria=getPagination().getCriteria();
		if(!StringUtils.isEmpty(param.getRoleName())) {
			criteria.add(Restrictions.like("roleName", param.getRoleName(),MatchMode.ANYWHERE));
		}
		if(param.getStatus()!=null) {
			criteria.add(Restrictions.eq("status", param.getStatus()));
		}
		criteria.addOrder(Order.asc("seqNum"));
		roleService.find(getPagination());
		printJson(getPagination());
	}
	
    @RequestMapping(value="/add",method=RequestMethod.GET)
	public String add() {
		return "system/role/role-update";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult doAdd(@RequestBody Role role) {
		role.setCreatorId(getLoginUser().getUserId());
		roleService.add(role);
		return jsonResult(200, "OK");
	}
	
	/**
	 * 检查角色是否存在
	 * @param name
	 * @return code:200 表示不存在,code:-1 表示已存在
	 */
	@RequestMapping(value="/check_role",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult checkRole(String name) {
		boolean exist=roleService.getRoleByName(name)!=null;
		boolean isChinese=userService.isChinese(name);
		if(exist||isChinese) {
			return jsonResult(-1, "already exists");
		} else {
			return jsonResult(200, "not exist");
		}
	}
	
	@RequestMapping(value="/update/{id}",method=RequestMethod.GET)
	public String update(@PathVariable String id) {
		Role role=roleService.get(id);
		setAttribute("role", role);
		return "system/role/role-update";
	}
	
	@RequestMapping(value="/update/{id}",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult doUpdate(@PathVariable String id,@RequestBody Role param) {
		
		Role role=roleService.get(id);
		role.setRoleName(param.getRoleName());
		role.setStatus(param.getStatus());
		role.setDescription(param.getDescription());
		role.setRoleCode(param.getRoleCode());//角色编码code @author：liule
		role.setCheckedFunctionId(param.getCheckedFunctionId());
		role.setUncheckdFunctionId(param.getUncheckdFunctionId());
		roleService.update(role);
		return jsonResult(200, "OK");
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult doDelete(@PathVariable String id) {
		roleService.delete(id);
		return jsonResult(200, "OK");
	}
	
	/**
	 * 为角色分配功能时,返回功能的树形组件的json对象
	 */
    @RequestMapping(value="/func_tree",method={RequestMethod.GET,RequestMethod.POST})
	public void funcTree() {
		
		String id=getId();
		List<Function> functions=functionService.getChildren(id, Function.STATUS_DEFAULT);
		List tree=new ArrayList(functions.size());
		
		String roleId=getParameter("roleId");
    	List<Function> selectedFunctions=Collections.EMPTY_LIST;
    	if(!StringUtils.isBlank(roleId)) {
    		selectedFunctions=functionService.getChildrenForRole(roleId, id,null);
    	}
		
		for(Function f:functions) {
			TreeNode node=new TreeNode();
			node.setId(f.getFuncId());
			node.setText(f.getName());
			if(f.getType()==Function.TYPE_DIRECTORY) {
				node.setState(TreeNode.STATE_CLOSED);
				node.setIconCls("fa fa-folder");
			} else {
				node.setState(TreeNode.STATE_OPEN);
				node.setIconCls("fa fa-file");
			}
			node.setChecked(selectedFunctions.contains(f));
			node.getAttributes().put("parentId", f.getParentId());
			node.getAttributes().put("type", f.getType());
			tree.add(node);
		}
		printJson(tree);
	}
    
    @RequestMapping(value="/sort",method=RequestMethod.GET)
   	public String sort() {
   		return "system/role/role-sort";
   	}
   	
   	@RequestMapping(value="/sort",method=RequestMethod.POST)
   	@ResponseBody
   	public JsonResult doSort(@RequestBody Role[] roles) {
   		roleService.sort(roles);
   		return jsonResult(200, "OK");
   	}
}
