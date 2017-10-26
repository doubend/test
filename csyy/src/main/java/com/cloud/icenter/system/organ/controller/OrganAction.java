package com.cloud.icenter.system.organ.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
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
import com.cloud.icenter.common.constants.Constants;
import com.cloud.icenter.common.utils.JsonResult;
import com.cloud.icenter.common.utils.Pagination;
import com.cloud.icenter.common.utils.SystemConfig;
import com.cloud.icenter.common.utils.TreeNode;
import com.cloud.icenter.system.function.pojo.Function;
import com.cloud.icenter.system.function.service.FunctionService;
import com.cloud.icenter.system.organ.pojo.Organ;
import com.cloud.icenter.system.organ.pojo.OrganData;
import com.cloud.icenter.system.organ.service.OrganService;
import com.cloud.icenter.system.organ.service.OrganUserService;
import com.cloud.icenter.system.role.pojo.Role;
import com.cloud.icenter.system.role.service.RoleService;
import com.cloud.icenter.system.user.pojo.User;
import com.cloud.icenter.system.user.service.UserService;
import com.mysql.fabric.xmlrpc.base.Array;

@Controller
@RequestMapping(value = "/system/organ")
public class OrganAction extends ModelAction<Organ> {

	@Autowired
	private OrganService organService;
	@Autowired
	private FunctionService functionService;
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;

	@Autowired
	private OrganUserService organUserService;

	@RequestMapping(method = RequestMethod.GET)
	public String list() {
		return "system/organ/organ-list";
	}
	/*
	 * 跳转到/jsp/system/organ/organ_tree.jsp页面
	 * 所有选择组织结构的弹出窗口均可使用
	 * 弹出所有组织机
	 * */
	@RequestMapping(value = "/toOrganTree", method = RequestMethod.GET)
	public String toOrganTree() {
		return "system/organ/organ_tree";
	}

	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public String query() {
		return "system/organ/organ-query";
	}

	@RequestMapping(value = "/addRoot" , method = RequestMethod.GET)
	public String addRoot(){
		return "system/organ/organ-root";
	}
	@RequestMapping(value = "/addRelation/{id}" , method = RequestMethod.GET)
	public String addRelation(@PathVariable String id){
		Organ organ = organService.get(id);
		if(organ.getUserId() !=null || "".equals(organ.getUserId())){
			Organ organ2 = organService.get(organ.getUserId());
			String name = organ2.getName();
			String orgId = organ2.getOrgId();
			setAttribute("treeName", name);
			setAttribute("treeOrgId", orgId);
		}
		setAttribute("organ", organ);

		return "system/organ/organ-relation";
	}
	/**
	 * 选择组织
	 */
	@RequestMapping(value = "/select/organSelectTree", method = RequestMethod.POST)
	public void organSelectTree() {
		String id = getId();
		String selectedId = getParameter("selectedId");
		if (id != null || (id == null && selectedId == null)) {
			expandEalChildren(id);
		} else if (id == null && selectedId != null) {
			expandEalChildren(selectedId);
		}
	}
	/**
	 * 扩展显示下级子节点
	 * @param parentId
	 */
	private void expandEalChildren(String parentId) {
		List<TreeNode> tree = getDeptTreeNodeByParentId_1(parentId);
		List<TreeNode> trees = new ArrayList<TreeNode>();
		for (TreeNode node : tree) {
			if(Constants.ZTK_SYS_CODE.equals(node.getSysCode()) || Constants.JCK_SYS_CODE.equals(node.getSysCode())){
				continue;
			}
			if (StringUtils.isBlank(parentId)) { // 如果是顶级节点,那么继续加载下面的二级节点
				String _pid = node.getId();
				List<TreeNode> branch = getDeptTreeNodeByParentId_1(_pid);
				node.setState(TreeNode.STATE_OPEN);
				node.setChildren(branch);
				trees.add(node);
			}else{
				printJson(tree);
			}
		}
		if(trees.size() >0) {
			printJson(trees);
		}
	}
	/**
	 * 获取父节点下的所有子节点(TreeNode对象) 不包括叶子节点
	 * @author liule
	 * @param parentId
	 * @return
	 */
	private List<TreeNode> getDeptTreeNodeByParentId_1(String parentId) {
		List<Organ> organs = organService.getChildren(parentId, Organ.STATUS_DEFAULT);
		organs.addAll(organService.getChildren(parentId, Organ.STATUS_DISABLE));
		List<TreeNode> tree = new ArrayList<TreeNode>(organs.size());
		for (Organ o : organs) {
			tree.add(convert_1(o));
		}
		return tree;
	}
	/**
	 * 将organ对象转换为treenode对象
	 * @author liule
	 * @param organ
	 * @return
	 */
	private TreeNode convert_1(Organ organ) {
		TreeNode node = new TreeNode();
		node.setId(organ.getOrgId());
		node.setText(organ.getName());
		node.setSysCode(organ.getSysCode());
		if(StringUtils.isEmpty(organ.getParentId())){
			//顶级节点
			node.setState(TreeNode.STATE_CLOSED);
		}else{
			//子节点
			node.setState(TreeNode.STATE_CLOSED);
		}
		node.getAttributes().put("parentId", organ.getParentId());
		node.getAttributes().put("type", organ.getType());

		return node;
	}
	/**
	 * 
	 * @param id
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/relationUpdate/{id}", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult doRelationUpdate(@PathVariable String id, Organ param) {
		try {
			organService.update(param);
			return jsonResult(200, "OK");
		} catch (Exception e) {
			return jsonResult(-1, e.getMessage());
		}
	}
	//根据当前登录用户，获取其组织机构信息
	@RequestMapping(value = "/getOrgs" , method = RequestMethod.POST)
	public void getLoginUserOrgs(){
		final String userId = this.getLoginUser().getUserId();
		//if("dev".equals(this.getLoginUser().getUsername())){
		//显示所有组织机构
		expandChildren(this.getId());
		/*}else{
			//如果是人员，则查找人员所属机构，组织结构
			List<Organ> organList = organService.findByUserId(userId);
			List<TreeNode> parentList = new ArrayList<>();
			if(organList != null && !organList.isEmpty()){
				final StringBuilder temp = new StringBuilder("");
				for(Organ org : organList){
					if(temp.indexOf(org.getOrgId()) > -1){
						continue;
					}
					temp.append(org.getPath());
					TreeNode treeNode = getParent(org , null);
					parentList.add(treeNode);
				}
			}
			printJson(parentList);
		}*/
	}

	private TreeNode getParent(Organ organ , TreeNode children){
		TreeNode treeNode = convert(organ);
		if(children != null){
			treeNode.setChildren(Arrays.asList(children));
		}
		if(!StringUtils.isEmpty(organ.getParentId())){
			Organ parent = organService.get(organ.getParentId());
			TreeNode parentNode = this.getParent(parent, treeNode);
			return parentNode;
		}
		return treeNode;
	}

	/*private TreeNode getParent(Organ organ){
		if(!StringUtils.isEmpty(organ.getPath())){
			String[] ids = organ.getPath().split("/");
			for(String id : ids){

			}
		}else{
			return convert(organ);
		}
	}*/

	/**
	 * 新增页面
	 * 
	 * @param parentId
	 * @return
	 */
	@RequestMapping(value = "/add/{parentId}", method = RequestMethod.GET)
	public String add(@PathVariable String parentId) {
		if (!StringUtils.isBlank(parentId)) {
			Organ parent = organService.get(parentId);
			setAttribute("parent", parent);
		}
		return "system/organ/organ-update";
	}

	@RequestMapping(value = "/validateSyscode/{sysCode}", method = RequestMethod.GET)
	@ResponseBody
	public String validateSyscode(@PathVariable String sysCode) {
		if (!StringUtils.isBlank(sysCode)) {
			Organ organ = organService.getOrganBySyscode(sysCode);
			if(organ == null){
				return "0";
			}
		}
		return "1";
	}

	/**
	 * 修改页面
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable String id) {
		Organ organ = organService.get(id);
		setAttribute("organ", organ);
		if (!StringUtils.isBlank(organ.getParentId())) {
			Organ parent = organService.get(organ.getParentId());
			setAttribute("parent", parent);
			return "system/organ/organ-update";
		} else {
			return "system/organ/organ-root";
		}
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/adduser/{id}" , method = RequestMethod.GET)
	public String addUser(@PathVariable String id){
		setAttribute("orgId", id);
		return "system/organ/org-adduser";
	}

	/**
	 * 
	 * @param param
	 */
	@RequestMapping(value = "/query", method = RequestMethod.POST)
	public void query(Organ param) {
		String id = getId();
		String selectedId = getParameter("selectedId");
		if (id != null || (id == null && selectedId == null)) {
			expandChildren(id);
		} else if (id == null && selectedId != null) {
			expandParents(selectedId);
		}
	}

	/**
	 * 新增保存
	 * 
	 * @param organ
	 * @return
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult add(Organ organ) {
		organ.setCreatorId(getLoginUser().getUserId());
		try {
			organService.add(organ);
		} catch (Exception e) {
			return jsonResult(-1, e.getMessage());
		}
		return jsonResult(200, null);
	}

	/**
	 * 
	 * @param id
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult doUpdate(@PathVariable String id, Organ param) {
		try {
			organService.update(param);
			return jsonResult(200, "OK");
		} catch (Exception e) {
			return jsonResult(-1, e.getMessage());
		}
	}

	/**
	 * 删除组织机构
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult doDelete(@PathVariable String id) {
		//删除时，连同子部门一同删除
		organService.deleteOrgan(id);
		return jsonResult(200, "OK");
	}

	/**
	 * 组织机构添加人员
	 * @param id
	 * @param userIds
	 * @return
	 */
	@RequestMapping(value = "/addusers/{id}" , method = RequestMethod.POST)
	@ResponseBody
	public JsonResult addUsers(@PathVariable String id , @RequestParam("userIds[]")String[] userIds){
		try{
			this.organUserService.addBatch(userIds, id);
			return jsonResult(200, null);
		}catch(Exception e){
			return jsonResult(-1, e.getMessage());
		}
	}

	/**
	 * 根据ID，删除人员与组织机构的关系
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/removeUser" , method = RequestMethod.POST)
	@ResponseBody
	public JsonResult removeUser(@RequestParam("id")String organUserId){
		try{
			organUserService.delete(organUserId);
			return jsonResult(200, null);
		}catch(Exception e){
			return jsonResult(-1, e.getMessage());
		}
	}

	/**
	 * 扩展显示下级子节点
	 * 
	 * @param parentId
	 */
	private void expandChildren(String parentId) {
		List<TreeNode> tree = getTreeNodeByParentId(parentId);
		if (StringUtils.isBlank(parentId)) { // 如果是顶级节点,那么继续加载下面的二级节点
			for (TreeNode node : tree) {
				String _pid = node.getId();
				List<TreeNode> branch = getTreeNodeByParentId(_pid);
				node.setState(TreeNode.STATE_OPEN);
				node.setChildren(branch);
			}
		}
		printJson(tree);
	}

	/**
	 * 扩展显示所有级别的父节点
	 * 
	 * @param organId
	 */
	private void expandParents(String organId) {
		List<TreeNode> tree = null;
		List<Organ> parents = organService.getParents(organId); // 获取所有父节点,包括本节点
		for (Organ p : parents) { // 从本节点开始,逐级往上查询父节点
			List<TreeNode> branch = getTreeNodeByParentId(p.getParentId());// 获取所有子节点
			if (tree == null) {
				tree = branch;
			} else {
				for (TreeNode node : branch) {
					if (node.getId().equals(p.getOrgId())) {
						node.setChildren(tree);
						node.setState(TreeNode.STATE_OPEN);
						tree = branch;
						break;
					}
				}
			}
		}
		if (!tree.isEmpty()) { // 给树的第一个节点设置属性selectedId,用于前端获取后,将此节点选中
			tree.get(0).getAttributes().put("selectedId", organId);
		}
		printJson(tree);
	}

	//////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 查询组织机构信息，不包含组织机构下的人员，只显示部门组织信息
	 */
	@RequestMapping(value = "/queryDept", method = RequestMethod.POST)
	public void queryDept() {
		// 查询机构和机构下的部门信息
		String parentId = getId();
		if (parentId == null) {
			List<TreeNode> tree = organService.queryOrganTree(Organ.TYPE_FOLDER, Organ.TYPE_DEPARTMENT);
			printJson(tree);
		}
	}

	/**
	 * 查询组织机构信息 提供与：查询条件为所属机构的方法
	 */
	@RequestMapping(value = "/queryOrgan", method = RequestMethod.POST)
	public void queryOrgan() {
		String parentId = getId();
		if (parentId == null) {
			List<TreeNode> tree = new ArrayList<TreeNode>();
			// 设置根节点为：全部
			TreeNode root = new TreeNode();
			root.setId(""); // 根节点：设置为空
			root.setText("全部"); // 待审核
			root.setState(TreeNode.STATE_OPEN); // 设置节点状态：打开
			root.setIconCls("fa fa-folder"); // 设置节点图标为：文件夹

			List<Organ> list = organService.getByType(Organ.TYPE_FOLDER);
			if (list != null && !list.isEmpty()) {
				List<TreeNode> children = organService.queryOrganTree(list.get(0).getOrgId(), true);
				root.setChildren(children); // 根节点设置子节点
			}

			tree.add(root); // 根节点放入到tree当中
			printJson(tree); // 相应请求
		}
	}

	/*
	 * 根据父节点，获取子节点部门，异步加载
	 * 
	 * @RequestMapping(value = "/queryDept", method = RequestMethod.POST) public
	 * void queryDept() { String parentId = getId(); List<TreeNode> tree =
	 * getDeptTreeNodeByParentId(parentId); if (StringUtils.isBlank(parentId)) {
	 * // 如果是顶级节点,那么继续加载下面的二级节点 for (TreeNode node : tree) { String _pid =
	 * node.getId(); List<TreeNode> branch = getDeptTreeNodeByParentId(_pid);
	 * node.setState(TreeNode.STATE_OPEN); node.setChildren(branch); } }
	 * printJson(tree); }
	 */

	@RequestMapping(value = "/queryEnable", method = RequestMethod.POST)
	public void queryEnable(String loadChildren) {
		String id = getId();
		String selectedId = getParameter("selectedId");

		if (id != null || (id == null && selectedId == null)) {
			expandEnableChildren(id, loadChildren);
		} else if (id == null && selectedId != null) {
			expandParents(selectedId);
		}
	}

	/**
	 * 高级查询
	 * 
	 * @param param
	 */
	@RequestMapping(value = "/doquery", method = RequestMethod.POST)
	public void doQuery(Organ param) {
		DetachedCriteria criteria = getPagination().getCriteria();
		if (!StringUtils.isBlank(getModel().getName())) {
			criteria.add(Restrictions.like("name", getModel().getName(), MatchMode.ANYWHERE));
		}
		if (!StringUtils.isBlank(getModel().getShortName())) {
			criteria.add(Restrictions.like("shortName", getModel().getShortName(), MatchMode.ANYWHERE));
		}
		if (getModel().getType() != null) {
			criteria.add(Restrictions.eq("type", getModel().getType()));
		}
		if (getModel().getMain() != null) {
			criteria.add(Restrictions.eq("main", getModel().getMain()));
		}
		if (!StringUtils.isBlank(getModel().getParentId())) {
			criteria.add(Restrictions.eq("parentId", getModel().getParentId()));
		}
		criteria.add(Restrictions.eq("status", Organ.STATUS_DEFAULT));
		criteria.addOrder(Order.desc("seqNum"));
		organService.find(getPagination());
		printJson(getPagination());
	}

	/**
	 * 扩展显示下级子节点
	 * 
	 * @param parentId
	 */
	private void expandEnableChildren(String parentId, String loadChildren) {

		List<Organ> organs = organService.getChildren(parentId, Organ.STATUS_DEFAULT);
		List<TreeNode> tree = new ArrayList<TreeNode>(organs.size());

		for (Organ o : organs) {
			tree.add(convert(o));
		}
		if (StringUtils.isBlank(parentId) && StringUtils.isEmpty(loadChildren)) { // 如果是顶级节点,那么继续加载下面的二级节点
			for (TreeNode node : tree) {
				String _pid = node.getId();
				List<TreeNode> branch = getEnableTreeNodeByParentId(_pid);
				node.setState(TreeNode.STATE_OPEN);
				node.setChildren(branch);

				for (TreeNode sub : branch) {
					sub.setState(TreeNode.STATE_OPEN);
					sub.setChildren(getEnableTreeNodeByParentId(sub.getId()));
				}
			}
		}
		printJson(tree);
	}

	/**
	 * 获取父节点下的所有子节点(TreeNode对象)
	 * 
	 * @param parentId
	 * @return
	 */
	private List<TreeNode> getEnableTreeNodeByParentId(String parentId) {
		List<Organ> organs = organService.getChildren(parentId, Organ.STATUS_DEFAULT);
		List<TreeNode> tree = new ArrayList<TreeNode>(organs.size());

		for (Organ o : organs) {
			tree.add(convert(o));
		}
		return tree;
	}
	/**
	 * 获取父节点下的所有子节点(TreeNode对象)
	 * 
	 * @param parentId
	 * @return
	 */
	private List<TreeNode> getTreeNodeByParentId(String parentId) {
		List<Organ> organs = organService.getChildren(parentId, Organ.STATUS_DEFAULT);
		organs.addAll(organService.getChildren(parentId, Organ.STATUS_DISABLE));
		List<TreeNode> tree = new ArrayList<TreeNode>(organs.size());

		for (Organ o : organs) {
			tree.add(convert(o));
		}
		return tree;
	}

	/**
	 * 获取父节点下的所有子节点(TreeNode对象) 不包括叶子节点
	 * 
	 * @param parentId
	 * @return
	 */
	private List<TreeNode> getDeptTreeNodeByParentId(String parentId) {
		List<Organ> organs = organService.getChildrenDept(parentId, Organ.STATUS_DEFAULT);
		organs.addAll(organService.getChildrenDept(parentId, Organ.STATUS_DISABLE));
		List<TreeNode> tree = new ArrayList<TreeNode>(organs.size());

		for (Organ o : organs) {
			tree.add(convert(o));
		}
		return tree;
	}

	/**
	 * 将organ对象转换为treenode对象
	 * 
	 * @param organ
	 * @return
	 */
	private TreeNode convert(Organ organ) {

		TreeNode node = new TreeNode();
		node.setId(organ.getOrgId());
		node.setText(organ.getName());
		node.setSysCode(organ.getSysCode());
		if(StringUtils.isEmpty(organ.getParentId())){
			//顶级节点
			node.setState(TreeNode.STATE_CLOSED);
			node.setIconCls("fa fa-folder");
		}else{
			//子节点
			node.setState(TreeNode.STATE_CLOSED);
			node.setIconCls("fa fa-sitemap");
		}
		/*if (organ.getType() == Organ.TYPE_ENTERPRISE) {
			node.setState(TreeNode.STATE_CLOSED);
			node.setIconCls("fa fa-cube");
		} else if (organ.getType() == Organ.TYPE_DEPARTMENT) {
			node.setState(TreeNode.STATE_CLOSED);
			node.setIconCls("fa fa-sitemap");
		} else if (organ.getType() == Organ.TYPE_FOLDER) {
			node.setState(TreeNode.STATE_CLOSED);
			node.setIconCls("fa fa-folder");
		} else {
			node.setState(TreeNode.STATE_OPEN);
			if (StringUtils.isBlank(organ.getSex()) || organ.getSex().equals(Organ.SEX_MALE)) {
				node.setIconCls("fa fa-user");
			} else {
				node.setIconCls("fa fa-female");
			}
		}*/
		node.getAttributes().put("parentId", organ.getParentId());
		node.getAttributes().put("type", organ.getType());

		return node;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult doAdd(Organ organ) {
		organ.setCreatorId(getLoginUser().getUserId());
		try {
			organService.add(organ);
		} catch (Exception e) {
			return jsonResult(-1, e.getMessage());
		}
		return jsonResult(200, "OK");
	}

	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	public String detail(@PathVariable String id) {
		Organ organ = organService.get(id);
		setAttribute("organ", organ);
		if (!StringUtils.isBlank(organ.getParentId())) {
			Organ parent = organService.get(organ.getParentId());
			setAttribute("parent", parent);
		}
		return "system/organ/organ-detail";
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
	public JsonResult move(@RequestParam String targetId, @RequestParam String sourceId, @RequestParam String point) {
		organService.move(targetId, sourceId, point);
		return jsonResult(200, "OK");
	}

	// ====排序代码====
	@RequestMapping(value = "/sort", method = RequestMethod.GET)
	public String sort() {
		return "system/organ/organ-sort";
	}

	@RequestMapping(value = "/sort_data", method = RequestMethod.POST)
	public void sortData(@RequestParam(required = false) String parentId) {
		List<Organ> organs = organService.getChildren(parentId, Organ.STATUS_DEFAULT);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("rows", organs);
		map.put("total", organs.size());
		printJson(map);
	}

	@RequestMapping(value = "/sort", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult doSort(@RequestBody Organ[] organs) {
		organService.sort(organs);
		return jsonResult(200, "OK");
	}

	// ====选择用户代码====
	@RequestMapping(value = "/select_user", method = RequestMethod.GET)
	public String selectUser() {
		return "system/organ/organ-user";
	}

	@RequestMapping(value = "/select_user", method = RequestMethod.POST)
	public void selectUser(User param) {
		Pagination<User> pagin = newPagination(User.class);
		DetachedCriteria criteria = pagin.getCriteria();
		if (!StringUtils.isEmpty(param.getUsername())) {
			criteria.add(Restrictions.like("username", param.getUsername(), MatchMode.ANYWHERE));
		}
		if (!StringUtils.isEmpty(param.getNickname())) {
			criteria.add(Restrictions.like("nickname", param.getNickname(), MatchMode.ANYWHERE));
		}
		if (param.getStatus() != null) {
			criteria.add(Restrictions.eq("status", param.getStatus()));
		}
		criteria.addOrder(Order.desc("createdAt"));
		userService.find(pagin);
		printJson(pagin);
	}

	// ====权限设置代码====
	@RequestMapping(value = "/function_setup", method = RequestMethod.GET)
	public String functionSetup() {
		return "system/organ/organ-function";
	}

	@RequestMapping(value = "/function_setup/{organId}", method = RequestMethod.GET)
	public void queryFunction(@PathVariable String organId, @RequestParam(required = false) String id) {

		List<Function> functions = functionService.getChildren(id, Function.STATUS_DEFAULT);
		List<TreeNode> tree = new ArrayList<TreeNode>(functions.size());

		List<Function> selectedFunctions = Collections.EMPTY_LIST;
		if (!StringUtils.isBlank(organId)) {
			selectedFunctions = functionService.getChildrenForOrgan(organId, id, null);
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

	@RequestMapping(value = "/function_setup/{organId}", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult doFunctionSetup(@PathVariable String organId,
			@RequestParam("checkedFuncId[]") String[] checkedFuncId,
			@RequestParam("uncheckFuncId[]") String[] uncheckFuncId) {
		organService.functionSetup(organId, checkedFuncId, uncheckFuncId);
		return jsonResult(200, "OK");
	}

	// ====数据绑定代码====
	@RequestMapping(value = "/data_binding", method = RequestMethod.GET)
	public String dataBinding() {
		return "system/organ/organ-data";
	}

	@RequestMapping(value = "/data_binding/{organId}", method = RequestMethod.GET)
	public void queryDataBinding(@PathVariable String organId) {
		List<OrganData> organDatas = organService.getOrganDataByOrganId(organId);
		printJson(organDatas);
	}

	@RequestMapping(value = "/data_binding/{organId}", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult doDataBinding(@PathVariable String organId, @RequestBody OrganData[] datas) {

		if (datas == null)
			return null;
		User loginUser = getLoginUser();
		for (OrganData data : datas) {
			if (StringUtils.isBlank(data.getId())) {
				data.setCreatorId(loginUser.getUserId());
			}
		}
		organService.addOrganDatas(organId, datas);
		return jsonResult(200, "OK");
	}

	// ====选择组织代码====
	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public String select() {
		return "system/organ/organ-select";
	}
	/**
	 * 选择组织机构-按组织查询 去掉了人员类型的节点
	 */
	@RequestMapping(value = "/select/organ_tree", method = RequestMethod.POST)
	public void organTree(@RequestParam(required = false) String id) {

		List<TreeNode> tree = getTreeNodeByParentId(id, Organ.TYPE_EMPLOYEE);
		if (StringUtils.isBlank(id)) { // 如果是顶级节点,那么继续加载下面的二级节点
			for (TreeNode node : tree) {
				String parentId = node.getId();
				List<TreeNode> branch = getTreeNodeByParentId(parentId, Organ.TYPE_EMPLOYEE);
				node.setState(TreeNode.STATE_OPEN);
				node.setChildren(branch);
			}
		}
		printJson(tree);
	}
	/**
	 * 选择组织机构-按角色查询
	 */
	@RequestMapping(value = "/select/role_tree", method = RequestMethod.POST)
	public void roleTree() {

		List<Role> roles = roleService.findAll();
		List<TreeNode> tree = new ArrayList<TreeNode>(roles.size());

		String guestRoleName = SystemConfig.getProperty("system.role.guest");
		for (Role r : roles) {
			if (r.getRoleName().equals(guestRoleName))
				continue;
			TreeNode node = new TreeNode();
			node.setId(r.getRoleId());
			node.setText(r.getRoleName());
			node.setChecked(false);
			node.setIconCls("icon-star");
			tree.add(node);
		}
		printJson(tree);
	}

	/**
	 * 为选择组织窗口执行查询
	 */
	@RequestMapping(value = "/select/query", method = RequestMethod.POST)
	public void queryOrgan(@RequestParam(required = false) String queryType,
			@RequestParam(required = false) String id) {

		if (StringUtils.isBlank(queryType) || queryType.equals("organ")) {
			DetachedCriteria criteria = getPagination().getCriteria();
			if (!StringUtils.isBlank(getModel().getName())) {
				criteria.add(Restrictions.like("name", getModel().getName(), MatchMode.ANYWHERE));
			}
			if (!StringUtils.isBlank(getModel().getShortName())) {
				criteria.add(Restrictions.like("shortName", getModel().getShortName(), MatchMode.ANYWHERE));
			}
			if (!StringUtils.isBlank(id)) {
				criteria.add(Restrictions.eq("parentId", id));
			}
			criteria.add(Restrictions.eq("status", Organ.STATUS_DEFAULT));
			criteria.addOrder(Order.desc("seqNum"));

			organService.find(getPagination());
			printJson(getPagination());
		} else if (queryType.equals("role")) {
			List<Organ> organs = organService.getOrgansByRoleId(id);
			printJson(organs);
		}
	}

	/**
	 * 获取父节点下的子节点(TreeNode对象)
	 * 
	 * @param parentId
	 *            父节点id
	 * @param excludeType
	 *            排除的节点类型
	 * @return
	 */
	private List<TreeNode> getTreeNodeByParentId(String parentId, int excludeType) {
		List<Organ> organs = organService.getChildren(parentId, Organ.STATUS_DEFAULT);
		List<TreeNode> tree = new ArrayList<TreeNode>(organs.size());

		for (Organ o : organs) {
			if (o.getType() == excludeType)
				continue;
			tree.add(convert(o));
		}
		return tree;
	}
}
