package com.cloud.icenter.system.code.controller;

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
import com.cloud.icenter.common.utils.JsonResult;
import com.cloud.icenter.system.code.pojo.ResourceCode;
import com.cloud.icenter.system.code.service.ResourceCodeService;
import com.cloud.icenter.system.data.utils.DictConstans;

/**
 * 编码管理Action
 * @author ynxiea
 *
 */
@Controller
@RequestMapping(value = "/resourceCode")
public class ResourceCodeAction extends ModelAction<ResourceCode> {

	@Autowired
	private ResourceCodeService codeService;
	
	/**
	 * 查询初始化列表
	 * @return
	 */
	@RequestMapping(value="/init")
	public String init() {
		return "/system/code/code-list";
	}
	
	/**
	 * 查询数据
	 */
	@RequestMapping(value = "/query", method = RequestMethod.POST)
	public void query(ResourceCode param) {
		DetachedCriteria criteria = getPagination().getCriteria();
		if(!StringUtils.isEmpty(param.getCodeName())) {
			criteria.add(Restrictions.like("codeName",param.getCodeName().trim(),MatchMode.ANYWHERE));
		}
		criteria.addOrder(Order.desc("createDate"));
		codeService.find(getPagination());
		printJson(getPagination());
	}
	
	/**
	 * 新增初始化
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add() {
		return "/system/code/code-add";
	}
	
	/**
	 * 新增
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/doAdd",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult doAdd(@RequestBody ResourceCode code) {
		try {
			if (code != null) {
				code.setCreateUserId(getLoginUser().getUserId());
				code.setCreateDate(new Date());
				code.setEditDate(new Date());
				code.setEditUserId(getLoginUser().getUserId());
				code.setIsUse(DictConstans.DATA_STATUS_INVALID);
				codeService.add(code);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(-1, "新增出错！错误信息为："+e.getMessage());
		}
		return jsonResult(200, "OK");
	}
	
	/**
	 * 修改初始化页面
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/update/{id}",method=RequestMethod.GET)
	public String update(@PathVariable String id) {
		ResourceCode code = codeService.get(id);
		setAttribute("code", code);
		return "/system/code/code-update";
	}
	
	/**
	 * 执行更新操作
	 * @param id
	 * @param param
	 * @return
	 */
	@RequestMapping(value="/doUpdate/{id}",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult doUpdate(@PathVariable String id,@RequestBody ResourceCode param) {
		try {
			ResourceCode code = codeService.get(id);
			if (code != null && param != null) {
				code.setCodeName(param.getCodeName());
				code.setPreCode(param.getPreCode());
				code.setGrowType(param.getGrowType());
				code.setIsUseOrgan(param.getIsUseOrgan());
				code.setSpliptSign(param.getSpliptSign());
				code.setDes(param.getDes());
				codeService.update(code);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(-1, "修改出错！错误信息为："+e.getMessage());
		}
		return jsonResult(200, "OK");
	}
	
	/**
	 * 查看详情
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/view/{id}",method=RequestMethod.GET)
	public String view(@PathVariable String id) {
		ResourceCode code = codeService.get(id);
		setAttribute("code", code);
		return "/system/code/code-view";
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete/{id}",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult doDelete(@PathVariable String id) {
		try {
			boolean flag = codeService.checkStatus(id);
			if (flag) {
				codeService.delete(id);
			} else {
				return jsonResult(-1, "删除失败！失败原因为：当前编码规则为启用状态，不允许删除!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(-1, "删除出错！错误信息为：" +e.getMessage());
		}
		return jsonResult(200, "OK");
	}
	
	/**
	 * 启用
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/start/{id}",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult start(@PathVariable String id) {
		try {
			codeService.startCode(id);
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(-1, "启动出错！错误信息为：" +e.getMessage());
		}
		return jsonResult(200, "OK");
	}
	
}
