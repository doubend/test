package com.cloud.icenter.yyzx.cszc.tjfx.controller;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cloud.icenter.yyzx.cszc.security.pojo.QueryPojo;
import com.cloud.icenter.yyzx.cszc.tjfx.service.EducationInfoService;

/**
 * 教育信息统计
 * @date 2017年3月 9日
 * @author dxliug
 */
@Controller
@RequestMapping(value="/education/info")
public class EducationInfoController {
     
 private static final Logger logger = Logger.getLogger(EducationInfoController.class);
	
   @Autowired
   private EducationInfoService educationInfoService;
	/**
	 * 教育情况
	 * @return
	 */
	@RequestMapping(value="/list")
	public String toEmployment(){
		return "/cszc/statistics/educationInfo";
	}
	/**
	 * 查询教育机构数量
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/queryTeacherOffice")
	@ResponseBody
	public String queryEmployment(QueryPojo pojo){
		 List<Map<String,Object>> queryTeacherOffice;
		try {
			setQueryYear(pojo);
			 queryTeacherOffice = educationInfoService.queryTeacherOffice(pojo, "getTeaOffice");
		} catch (Exception e) {
			logger.info("查询教育情况失败"+ e.getMessage());
			throw e;
		}
		return JSON.toJSONString(queryTeacherOffice);
	}
	  
	 private void setQueryYear(QueryPojo pojo) {
			if(StringUtils.isEmpty(pojo.getNian())){
					Calendar c=Calendar.getInstance();
					pojo.setNian(String.valueOf(c.get(Calendar.YEAR)));
					
				}
		}
	
	 /**
	  * 查询老师和学生的人数  分小学 初中 高中
	  *  1 初中毕业的人数是否还包括小学毕业的人数
	  * @param pojo
	  * @return
	  */
	@ResponseBody
    @RequestMapping(value="/queryReceiveEd")
    public String queryReceiveEd(QueryPojo pojo){
		List<Map<String,Object>> obj;
		try {
   		    /*setQueryYear(pojo);*/
   		    pojo.setBefNian(Integer.toString((Integer.parseInt(pojo.getNian())-1)));
   		    obj=educationInfoService.findBaseListBySfz(pojo);
   	 } catch (Exception e) {
			logger.info("查询受教育情况失败"+e.getMessage());
			throw e;
		}
      return JSON.toJSONString(obj);
   }
	
}