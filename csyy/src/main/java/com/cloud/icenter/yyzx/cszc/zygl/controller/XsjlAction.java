package com.cloud.icenter.yyzx.cszc.zygl.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cloud.icenter.base.controller.ModelAction;
import com.cloud.icenter.common.utils.JsonResult;
import com.cloud.icenter.yyzx.cszc.zygl.pojo.HospitalPojo;
import com.cloud.icenter.yyzx.cszc.zygl.pojo.JbxxPojo;
import com.cloud.icenter.yyzx.cszc.zygl.pojo.XsjlPojo;
import com.cloud.icenter.yyzx.cszc.zygl.service.JbxxService;
import com.cloud.icenter.yyzx.cszc.zygl.service.XsjlService;

/** 
* @author zhucy 
* @version 2017年3月23日 下午3:02:41 
* 养护记录
*/
@Controller
@RequestMapping("/xsjl")
public class XsjlAction extends ModelAction<XsjlPojo>{
	
	@Autowired
	private XsjlService xsjlService;
	
	@Autowired
	private JbxxService jbxxService;
	/**
	 * 增加养护记录
	 * @param xsjlPojo
	 * @return
	 */
	@RequestMapping(value="/saveYh",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult saveYh(@RequestBody XsjlPojo xsjlPojo) {
		//获取代码
		JbxxPojo jbxxPojo = this.jbxxService.get(xsjlPojo.getJbxxId());
		//天水市城市代码620500
		String code = "620500"+jbxxPojo.getSsyjflbh()+jbxxPojo.getSsejflbh();
		xsjlPojo.setDm(code);
		xsjlPojo.setDeleteStatus("0");
		xsjlPojo.setCreatorId(getLoginUser().getUserId());
		xsjlPojo.setCreateTime(new Date());
		xsjlService.add(xsjlPojo);
		return jsonResult(200, "OK");
	}
	
	
	/**
	 * 养护记录查询
	 */
	@RequestMapping(value="/queryXsjl/{id}",method=RequestMethod.POST)
	public void queryXsjl(@PathVariable String id){
		DetachedCriteria criteria=getPagination().getCriteria();
		criteria.add(Restrictions.eq("jbxxId", id));
		criteria.add(Restrictions.eq("deleteStatus", "0"));
		criteria.addOrder(Order.desc("createTime"));
		xsjlService.find(getPagination());
		printJson(getPagination());
	}
	
	
	/**
	 * 导入养护记录信息
	 * @param file
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/importExcel/{id}",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult importExcel(@PathVariable String id,MultipartFile file, HttpServletRequest request){
		String status = "";
		try {
			status = this.xsjlService.readExcelData(file,id,getLoginUser().getUserId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			String msg = e.getMessage();
			if (msg.contains("MSG")) {
				return jsonResult(0, msg.replace("MSG_", ""));
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
		XsjlPojo xsjlPojo = this.xsjlService.get(id);
		xsjlPojo.setDeleteStatus("1");
		xsjlService.update(xsjlPojo);//逻辑删除
		return jsonResult(200, "OK");
	}
}
