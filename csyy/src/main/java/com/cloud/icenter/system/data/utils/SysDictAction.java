package com.cloud.icenter.system.data.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.icenter.base.controller.ModelAction;
import com.cloud.icenter.base.pojo.SysDict;

/**
 * 数据字典处理Action
 * @author ynxiea
 *
 */
@Controller
@RequestMapping(value = "/dict")
public class SysDictAction extends ModelAction<SysDict> {

	/**
	 * 根据字典码获取对应的文本
	 */
	@RequestMapping(value = "/getDictText/{code}/{value}", method = RequestMethod.GET)
	public @ResponseBody void getDicText(@PathVariable String code,@PathVariable String value) {
		String text = DictUtils.getDictNameByCodeAndValue(code,value);
		printText(text);
	}
	/**
	 * 根据字典码获取对应的文本
	 */
	@RequestMapping(value = "/getFlowStatusHtml/{code}/{value}", method = RequestMethod.GET)
	public @ResponseBody void getFlowStatusHtml(@PathVariable String code,@PathVariable String value) {
		String text = DictUtils.getDictNameByCodeAndValue(code,value);
		String html = "";
		//流程状态：0==未发起，1==审核中,2==已办结，3==退回
		if(DictConstans.FLOW_STATUS_0.equals(value)){
			html = "<span class='label label-danger'>"+text+"</span>";
		}else if(DictConstans.FLOW_STATUS_1.equals(value)){
			html = "<span class='label label-primary'>"+text+"</span>";
		}else if(DictConstans.FLOW_STATUS_2.equals(value)){
			html = "<span class='label label-success'>"+text+"</span>";
		}else if(DictConstans.FLOW_STATUS_3.equals(value)){
			html = "<span class='label label-warning'>"+text+"</span>";
		}
		printHtml(html);
	}
	/**
	 * 根据字典码获取对应的字典对象
	 */
	@RequestMapping(value = "/getDict/{code}", method = RequestMethod.GET)
	public @ResponseBody SysDict getDic(@PathVariable String code) {
		SysDict dic = DictUtils.getDictByCode(code);
		return dic;
	}
	/**
	 * 根据字典码获取对应的文本
	 */
	@RequestMapping(value = "/getApplyTypeHtml/{code}/{value}", method = RequestMethod.GET)
	public @ResponseBody List<Map<String,String>> getApplyTypeHtml(@PathVariable String code,@PathVariable String value) {
		List<SysDict> lt = DictUtils.getChildByCode(code);
		String[] arr = value.split(",");
		List<Map<String,String>> lt_= new ArrayList<Map<String,String>>();
		for(int i=0;i<arr.length;i++){
			for(SysDict sd:lt){
				if(arr[i].equals(sd.getValue())){
					Map<String,String> mres = new HashMap<String,String>();
					mres.put("value",sd.getValue());
					mres.put("text", sd.getText());
					lt_.add(mres);
				}
			}
		}
		return lt_;
	}
}
