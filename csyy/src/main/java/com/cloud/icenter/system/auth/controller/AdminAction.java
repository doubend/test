package com.cloud.icenter.system.auth.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cloud.icenter.base.controller.BaseAction;
import com.cloud.icenter.common.utils.TreeNode;
import com.cloud.icenter.system.auth.service.AuthService;
import com.cloud.icenter.system.function.pojo.Function;
import com.cloud.icenter.system.menu.pojo.Menu;
import com.cloud.icenter.system.onlineuser.pojo.OnlineUser;

import javassist.bytecode.analysis.ControlFlow.Node;

/**
 * 后台首页
 * @author zhangle
 */
@Controller
public class AdminAction extends BaseAction {
	
	@Autowired private AuthService authService;
	
	/**
	 * 后台框架页
	 */
	@RequestMapping(value="/admin",method=RequestMethod.GET)
	public String admin() {
		OnlineUser loginUser=getLoginUser();
		setAttribute("loginUser", loginUser);
		List<Menu> menus=authService.checkMenu(loginUser, null);
		setAttribute("menus", menus);
		
		return "system/admin";
	}
	
	@RequestMapping(value="/admin/menu",method={RequestMethod.GET,RequestMethod.POST})
	public void GetMenu() {
		OnlineUser loginUser=getLoginUser();
		//setAttribute("loginUser", loginUser);
		List<Menu> menus=authService.checkMenu(loginUser, null);
		printJson(menus);
	}
	/**
	 * 主要工作区
	 * @return
	 */
	@RequestMapping(value="/admin/main",method=RequestMethod.GET)
	public String main() {
		return "system/admin-main";
	}
	
	@RequestMapping(value="/admin/getallmenu",method={RequestMethod.GET,RequestMethod.POST})
	public void getAllMenu(){
		OnlineUser loginUser=getLoginUser();
		List<Menu> menus=authService.checkMenu(loginUser, null);
		List<TreeNode> tree=new ArrayList<TreeNode>(menus.size());
		
		for(Menu m:menus) {
			TreeNode node=new TreeNode();
			node.setId(m.getMenuId());
			node.setText(m.getName());
			if(m.getType()==Menu.TYPE_DIRECTORY) {
				node.setState(TreeNode.STATE_CLOSED);
				if(StringUtils.isBlank(m.getIcon())) {
					node.setIconCls("icon-pict");
				} else {
					node.setIconCls(m.getIcon());
				}
			} else {
				node.setState(TreeNode.STATE_OPEN);
				if(StringUtils.isBlank(m.getIcon())) {
					node.setIconCls("icon-pict");
				} else {
					node.setIconCls(m.getIcon());
				}
			}
			//node.setChildren(node,m.getMenuId());
			node.getAttributes().put("parentId", m.getParentId());
			node.getAttributes().put("type", m.getType());
			node.getAttributes().put("url", m.getUrl());
			getChildren(node);
			tree.add(node);
		}
		printJson(tree);
	}
	
	/**
	 * 加载左边的子菜单
	 */
	@RequestMapping(value="/admin/leftmenu/{menuId}",method={RequestMethod.GET,RequestMethod.POST})
	public void leftmenu(@PathVariable String menuId) {
		
		OnlineUser loginUser=getLoginUser();
		List<Menu> menus=authService.checkMenu(loginUser, menuId);
		List<TreeNode> tree=new ArrayList<TreeNode>(menus.size());
		
		for(Menu m:menus) {
			TreeNode node=new TreeNode();
			node.setId(m.getMenuId());
			node.setText(m.getName());
			if(m.getType()==Menu.TYPE_DIRECTORY) {
				node.setState(TreeNode.STATE_CLOSED);
				if(StringUtils.isBlank(m.getIcon())) {
					node.setIconCls("fa fa-folder");
				} else {
					node.setIconCls(m.getIcon());
				}
			} else {
				node.setState(TreeNode.STATE_OPEN);
				if(StringUtils.isBlank(m.getIcon())) {
					node.setIconCls("fa fa-file");
				} else {
					node.setIconCls(m.getIcon());
				}
			}
			//node.setChildren(node,m.getMenuId());
			node.getAttributes().put("parentId", m.getParentId());
			node.getAttributes().put("type", m.getType());
			node.getAttributes().put("url", m.getUrl());
			getChildren(node);
			tree.add(node);
		}
		printJson(tree);
	}
	
	public void getChildren(TreeNode pnode) {
		OnlineUser loginUser=getLoginUser();
		List<Menu> menus=authService.checkMenu(loginUser, pnode.getId());
		List<TreeNode> tree=new ArrayList<TreeNode>(menus.size());
		for(Menu m:menus) {
			TreeNode node=new TreeNode();
			node.setId(m.getMenuId());
			node.setText(m.getName());
			if(m.getType()==Menu.TYPE_DIRECTORY) {
				node.setState(TreeNode.STATE_CLOSED);
				if(StringUtils.isBlank(m.getIcon())) {
					node.setIconCls("fa fa-folder");
				} else {
					node.setIconCls(m.getIcon());
				}
			} else {
				node.setState(TreeNode.STATE_OPEN);
				if(StringUtils.isBlank(m.getIcon())) {
					node.setIconCls("fa fa-file");
				} else {
					node.setIconCls(m.getIcon());
				}
			}
			node.getAttributes().put("parentId", m.getParentId());
			node.getAttributes().put("type", m.getType());
			node.getAttributes().put("url", m.getUrl());
			getChildren(node);
			tree.add(node);
		}
		pnode.setChildren(tree);
	}
	
	/**
	 * 加载左边的子菜单
	 */
	@RequestMapping(value="/admin/Getleftmenu/{menuId}",method={RequestMethod.GET,RequestMethod.POST})
	public void Getleftmenu(@PathVariable String menuId) {
		
		OnlineUser loginUser=getLoginUser();
		List<Function> functions=authService.checkFunction(loginUser, menuId);
		List<TreeNode> tree=new ArrayList<TreeNode>(functions.size());
		
		for(Function m:functions) {
			TreeNode node=new TreeNode();
			node.setId(m.getFuncId());
			node.setText(m.getName());
			if(m.getType()==Menu.TYPE_DIRECTORY) {
				node.setState(TreeNode.STATE_CLOSED);
			} else {
				node.setState(TreeNode.STATE_OPEN);
				//if(StringUtils.isBlank(m.getIcon())) {
					node.setIconCls("icon-pict");
				//} else {
				//	node.setIconCls(m.getIcon());
				//}
			}
			node.getAttributes().put("parentId", m.getParentId());
			node.getAttributes().put("type", m.getType());
			node.getAttributes().put("url", m.getUrl());
			tree.add(node);
		}
		printJson(tree);
	}
	
}
