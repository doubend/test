package com.cloud.icenter.yyzx.cszc.tjfx.controller;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.icenter.base.controller.ModelAction;
import com.cloud.icenter.common.utils.JsonUtil;
import com.cloud.icenter.yyzx.common.query.CategorySum;
import com.cloud.icenter.yyzx.cszc.tjfx.pojo.RepairInfo;
import com.cloud.icenter.yyzx.cszc.tjfx.service.RepairInfoService;
import com.cloud.icenter.yyzx.fzjc.whly.pojo.TourismTime;


/**
* Created with gender.
* @author: liyao
* Date: 2017-04-19 14:27:14
*/
@Controller
@RequestMapping(value="/repairinfo")
public class RepairInfoAction extends ModelAction<RepairInfo>  {

@Autowired private RepairInfoService repairInfoService;
	/*
	 * 公用设施养护页面
	 */	
    @RequestMapping(method=RequestMethod.GET)
	public String list() {	
		
		List<CategorySum>  jcss01=repairInfoService.getCountByBjlx("6205000101");
		List<CategorySum>  jcss02=repairInfoService.getCountByBjlx("6205000102");
		List<CategorySum>  jcss03=repairInfoService.getCountByBjlx("6205000103");
		List<CategorySum>  jcss04=repairInfoService.getCountByBjlx("6205000104");
		List<CategorySum>  jcss05=repairInfoService.getCountByBjlx("6205000105");
		List<CategorySum>  jcss06=repairInfoService.getCountByBjlx("6205000106");
		List<CategorySum>  jcss07=repairInfoService.getCountByBjlx("6205000107");
		List<CategorySum>  jcss08=repairInfoService.getCountByBjlx("6205000108");
		setAttribute("jcss01",JsonUtil.toJson(jcss01));
		setAttribute("jcss02",JsonUtil.toJson(jcss02));
		setAttribute("jcss03",JsonUtil.toJson(jcss03));
		setAttribute("jcss04",JsonUtil.toJson(jcss04));
		setAttribute("jcss05",JsonUtil.toJson(jcss05));
		setAttribute("jcss06",JsonUtil.toJson(jcss06));
		setAttribute("jcss07",JsonUtil.toJson(jcss07));
		setAttribute("jcss08",JsonUtil.toJson(jcss08));
		List<CategorySum>  jcssSh01=repairInfoService.getYhpc("6205000101","损坏");
		List<CategorySum>  jcssSh02=repairInfoService.getYhpc("6205000102","损坏");
		List<CategorySum>  jcssSh03=repairInfoService.getYhpc("6205000103","损坏");
		List<CategorySum>  jcssSh04=repairInfoService.getYhpc("6205000104","损坏");
		List<CategorySum>  jcssSh05=repairInfoService.getYhpc("6205000105","损坏");
		List<CategorySum>  jcssSh06=repairInfoService.getYhpc("6205000106","损坏");
		List<CategorySum>  jcssSh07=repairInfoService.getYhpc("6205000107","损坏");
		List<CategorySum>  jcssSh08=repairInfoService.getYhpc("6205000108","损坏");
		setAttribute("jcssSh01",JsonUtil.toJson(jcssSh01));
		setAttribute("jcssSh02",JsonUtil.toJson(jcssSh02));
		setAttribute("jcssSh03",JsonUtil.toJson(jcssSh03));
		setAttribute("jcssSh04",JsonUtil.toJson(jcssSh04));
		setAttribute("jcssSh05",JsonUtil.toJson(jcssSh05));
		setAttribute("jcssSh06",JsonUtil.toJson(jcssSh06));
		setAttribute("jcssSh07",JsonUtil.toJson(jcssSh07));
		setAttribute("jcssSh08",JsonUtil.toJson(jcssSh08));
		List<CategorySum>  jcssDs01=repairInfoService.getYhpc("6205000101","丢失");
		List<CategorySum>  jcssDs02=repairInfoService.getYhpc("6205000102","丢失");
		List<CategorySum>  jcssDs03=repairInfoService.getYhpc("6205000103","丢失");
		List<CategorySum>  jcssDs04=repairInfoService.getYhpc("6205000104","丢失");
		List<CategorySum>  jcssDs05=repairInfoService.getYhpc("6205000105","丢失");
		List<CategorySum>  jcssDs06=repairInfoService.getYhpc("6205000106","丢失");
		List<CategorySum>  jcssDs07=repairInfoService.getYhpc("6205000107","丢失");
		List<CategorySum>  jcssDs08=repairInfoService.getYhpc("6205000108","丢失");
		setAttribute("jcssDs01",JsonUtil.toJson(jcssDs01));
		setAttribute("jcssDs02",JsonUtil.toJson(jcssDs02));
		setAttribute("jcssDs03",JsonUtil.toJson(jcssDs03));
		setAttribute("jcssDs04",JsonUtil.toJson(jcssDs04));
		setAttribute("jcssDs05",JsonUtil.toJson(jcssDs05));
		setAttribute("jcssDs06",JsonUtil.toJson(jcssDs06));
		setAttribute("jcssDs07",JsonUtil.toJson(jcssDs07));
		setAttribute("jcssDs08",JsonUtil.toJson(jcssDs08));
		List<CategorySum>  jcssZy01=repairInfoService.getYhpc("6205000101","占用");
		List<CategorySum>  jcssZy02=repairInfoService.getYhpc("6205000102","占用");
		List<CategorySum>  jcssZy03=repairInfoService.getYhpc("6205000103","占用");
		List<CategorySum>  jcssZy04=repairInfoService.getYhpc("6205000104","占用");
		List<CategorySum>  jcssZy05=repairInfoService.getYhpc("6205000105","占用");
		List<CategorySum>  jcssZy06=repairInfoService.getYhpc("6205000106","占用");
		List<CategorySum>  jcssZy07=repairInfoService.getYhpc("6205000107","占用");
		List<CategorySum>  jcssZy08=repairInfoService.getYhpc("6205000108","占用");
		setAttribute("jcssZy01",JsonUtil.toJson(jcssZy01));
		setAttribute("jcssZy02",JsonUtil.toJson(jcssZy02));
		setAttribute("jcssZy03",JsonUtil.toJson(jcssZy03));
		setAttribute("jcssZy04",JsonUtil.toJson(jcssZy04));
		setAttribute("jcssZy05",JsonUtil.toJson(jcssZy05));
		setAttribute("jcssZy06",JsonUtil.toJson(jcssZy06));
		setAttribute("jcssZy07",JsonUtil.toJson(jcssZy07));
		setAttribute("jcssZy08",JsonUtil.toJson(jcssZy08));
		List<CategorySum>  sjsysm=repairInfoService.getSjsysm();
		setAttribute("sjsysm",JsonUtil.toJson(sjsysm));
		List<CategorySum>  predictNextYear=repairInfoService.predictNextYear();
		List<CategorySum>  predictYearAfterYear=repairInfoService.predictYearAfterYear();
		setAttribute("predictNextYear",JsonUtil.toJson(predictNextYear));
		setAttribute("predictYearAfterYear",JsonUtil.toJson(predictYearAfterYear));
		return "cszc/statistics/facilitiesMaintenance";
	}
	}

