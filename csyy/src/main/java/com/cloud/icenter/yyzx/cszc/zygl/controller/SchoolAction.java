package com.cloud.icenter.yyzx.cszc.zygl.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cloud.icenter.base.controller.ModelAction;
import com.cloud.icenter.common.utils.JsonResult;
import com.cloud.icenter.yyzx.cszc.zygl.pojo.HospitalPojo;
import com.cloud.icenter.yyzx.cszc.zygl.pojo.SchoolPojo;
import com.cloud.icenter.yyzx.cszc.zygl.service.SchoolService;

/** 
* @author zhucy 
* @version 2017年3月21日 下午3:08:17 
* 城市资源学校历史信息
*/
@Controller
@RequestMapping("/schoolAction")
public class SchoolAction extends ModelAction<SchoolPojo>{
	@Autowired
	private SchoolService schoolService;
	
	
	/**
	 * 学校历史信息
	 */
	@RequestMapping(value="/querySchool",method=RequestMethod.POST)
	public void querySchool(SchoolPojo param){
		DetachedCriteria criteria=getPagination().getCriteria();
		if(!StringUtils.isEmpty(param.getZymc())) {
			criteria.add(Restrictions.like("xxmc",param.getZymc(),MatchMode.ANYWHERE));
		}
		if(!StringUtils.isEmpty(param.getBjbsm())) {
			criteria.add(Restrictions.like("bjbsm", param.getBjbsm(),MatchMode.ANYWHERE));
		}
		criteria.add(Restrictions.eq("deleteStatus", "0"));
		criteria.addOrder(Order.desc("createTime"));
		schoolService.find(getPagination());
		printJson(getPagination());
	}
	
	
	/**
	 * 导入学校历史信息
	 * @param file
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/importExcel",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult importExcel(MultipartFile file, HttpServletRequest request){
	    String status = null;
		try {
			status = this.schoolService.readExcelData(file,getLoginUser().getCreatorId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			String msg = e.getMessage();
			if (msg.contains("MSG")) {
				return jsonResult(0, msg.replace("MSG_", ""));
			}else{
				e.printStackTrace();
			}
		}
	    if ("dataIsNull".equals(status)) {
	        return jsonResult(0, "文件内容不能为空!");
        }
	   return jsonResult(1, "导入成功!");
	}
	
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult doDelete(@PathVariable String id , HttpServletRequest request) {
		SchoolPojo schoolPojo = this.schoolService.get(id);
		schoolPojo.setDeleteStatus("1");
		schoolService.update(schoolPojo);//逻辑删除
		return jsonResult(200, "OK");
	}
}
