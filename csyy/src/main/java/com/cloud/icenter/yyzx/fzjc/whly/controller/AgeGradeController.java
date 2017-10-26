package com.cloud.icenter.yyzx.fzjc.whly.controller;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.icenter.base.controller.ModelAction;
import com.cloud.icenter.common.utils.JsonUtil;
import com.cloud.icenter.yyzx.fzjc.whly.pojo.AgeGrade;
import com.cloud.icenter.yyzx.fzjc.whly.service.AgeGradeService;


/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-15 10:51:43
*/
@Controller
@RequestMapping(value="/agegrade")
public class AgeGradeController extends ModelAction<AgeGrade>  {
/*
 * 游客特征——游客年龄结构
 */
@Autowired private AgeGradeService ageGradeService;
	
	@RequestMapping(value="/getAge",method=RequestMethod.POST)
	public void getAgeGrade(){
		String result=JsonUtil.toJson(ageGradeService.getAgeGrade());
		printJson(result);
	}

}

