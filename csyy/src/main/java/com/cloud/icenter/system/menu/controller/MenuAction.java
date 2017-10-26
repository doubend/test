package com.cloud.icenter.system.menu.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
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
import com.cloud.icenter.common.utils.TreeNode;
import com.cloud.icenter.system.auth.service.AuthService;
import com.cloud.icenter.system.function.pojo.Function;
import com.cloud.icenter.system.function.service.FunctionService;
import com.cloud.icenter.system.menu.pojo.Menu;
import com.cloud.icenter.system.menu.service.MenuService;

/**
 * 菜单管理
 * 
 * @author zhangle
 */
@Controller
@RequestMapping(value = "/system/menu")
public class MenuAction extends ModelAction<Menu> {

	@Autowired
	private MenuService menuService;
	@Autowired
	private AuthService authService;
	@Autowired
	private FunctionService functionService;

	@RequestMapping(method = RequestMethod.GET)
	public String list() {
		return "system/menu/menu-list";
	}

	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public String query() {
		return "system/menu/menu-query";
	}

	@RequestMapping(value = "/query", method = RequestMethod.POST)
	public void query(Menu param) {

		String id = getId();

		List<Menu> menus = menuService.getChildren(id, null);
		List<TreeNode> tree = new ArrayList<TreeNode>(menus.size());

		for (Menu m : menus) {
			TreeNode node = new TreeNode();
			node.setId(m.getMenuId());
			node.setText(m.getName());
			if (m.getType() == Menu.TYPE_DIRECTORY) {
				node.setState(TreeNode.STATE_CLOSED);
				node.setIconCls("fa fa-folder");
			} else {
				node.setState(TreeNode.STATE_OPEN);
				node.setIconCls("fa fa-file");
			}
			node.getAttributes().put("parentId", m.getParentId());
			node.getAttributes().put("type", m.getType());
			tree.add(node);
		}
		printJson(tree);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(@RequestParam(required = false) String parentId) {
		if (!StringUtils.isBlank(parentId)) {
			Menu parent = menuService.get(parentId);
			setAttribute("parent", parent);
		}
		return "system/menu/menu-update";
	}

	// postJson对应@RequestBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult doAdd(@RequestBody Menu menu) {
		menu.setCreatorId(getLoginUser().getUserId());
		List<?> ss = menuService.findName(menu.getName());
		if(ss.size()==0){	
			menuService.add(menu);
			return jsonResult(200, "OK");
		}else{
			return jsonResult(-1, "Failed");

		}
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable String id) {
		Menu menu = menuService.get(id);
		setAttribute("menu", menu);
		if (!StringUtils.isBlank(menu.getParentId())) {
			Menu parent = menuService.get(menu.getParentId());
			setAttribute("parent", parent);
		}
		return "system/menu/menu-update";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult doUpdate(@PathVariable String id, @RequestBody Menu param) {
		Menu menu = menuService.get(id);
		if (menu == null) {
			return jsonResult(-1, "菜单不存在!");
		}
		menu.setName(param.getName());
		menu.setType(param.getType());
		menu.setStatus(param.getStatus());
		menu.setExpand(param.getExpand());
		menu.setUrl(param.getUrl());
		menu.setIcon(param.getIcon());
		menu.setIconOpen(param.getIconOpen());
		menu.setDescription(param.getDescription());
		// add by YHT
		menu.setCheckedFunctionId(param.getCheckedFunctionId());
		menu.setUncheckdFunctionId(param.getUncheckdFunctionId());
		try {
			menuService.update(menu);
			return jsonResult(200, "OK");
		} catch (Exception e) {
			return jsonResult(-1, e.getMessage());
		}
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult doDelete(@PathVariable String id) {
		menuService.delete(id);
		return jsonResult(200, "OK");
	}

	/**
	 * 移动节点
	 * 
	 * @param targetId
	 *            目标节点id
	 * @param sourceId
	 *            源节点id
	 * @param point
	 *            操作类型 取值范围: append,top,bottom
	 */
	@RequestMapping(value = "/move", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult move(@RequestParam String targetId,
			@RequestParam String sourceId, @RequestParam String point) {
		menuService.move(targetId, sourceId, point);
		return jsonResult(200, "OK");
	}

	@RequestMapping(value = "/refresh_cache", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult refreshCache() {
		authService.refreshCache();
		return jsonResult(200, "OK");
	}

	/**
	 * 为角色分配功能时,返回功能的树形组件的json对象 add by YHT
	 */
	@RequestMapping(value = "/func_tree", method = { RequestMethod.GET,
			RequestMethod.POST })
	public void funcTree() {
		String id = getId();
		List<Function> functions = functionService.getChildren(id,
				Function.STATUS_DEFAULT);
		List tree = new ArrayList(functions.size());
		String menuId = getParameter("menuId");
		List<Function> selectedFunctions = Collections.EMPTY_LIST;
		if (!StringUtils.isBlank(menuId)) {
			selectedFunctions = functionService.getChildrenForMenu(menuId, id,
					null);
		}

		for (Function f : functions) {
			TreeNode node = new TreeNode();
			node.setId(f.getFuncId());
			node.setText(f.getName());
			if (f.getType() == Function.TYPE_DIRECTORY) {
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

	@RequestMapping(value = "/menu_function", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String funcTreeStupe() {
		return "system/menu/menu-function";
	}

	@RequestMapping(value = "/functionTreeStupe/{menuId}", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult functionTreeStupe(@PathVariable String menuId,
			@RequestParam("checkedFunctionId[]") String[] checkedFuncId,
			@RequestParam("uncheckdFunctionId[]") String[] uncheckFuncId) {
		Menu menu = menuService.get(menuId);
		if(checkedFuncId!=null && checkedFuncId[0]=="0")
		{	
			checkedFuncId=null;
		}
		menu.setCheckedFunctionId(checkedFuncId);
		menu.setUncheckdFunctionId(uncheckFuncId);
		try {
			menuService.update(menu);
			return jsonResult(200, "OK");
		} catch (Exception e) {
			return jsonResult(-1, e.getMessage());
		}
	}

}
