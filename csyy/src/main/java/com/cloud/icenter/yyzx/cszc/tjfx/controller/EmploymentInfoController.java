package  com.cloud.icenter.yyzx.cszc.tjfx.controller;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.cloud.icenter.yyzx.cszc.security.pojo.QueryPojo;
import com.cloud.icenter.yyzx.cszc.tjfx.service.EmploymentInfoService;


/**   
 * @author dxliug
 * @date 2017年4月10日 下午2:44:32  
 * 
 * @TODO 就业信息controller
 */ 
@Controller
@RequestMapping(value="/employmentAnaly")
public class EmploymentInfoController{

	@Autowired EmploymentInfoService employmentService;
	/**
	 * 就业信息
	 */
	@RequestMapping(value="/base")
	public ModelAndView specialpopulation(){
		ModelAndView view=new ModelAndView("/cszc/statistics/jiuye"); 
		return view; 
	} 
    /**
     * 查询的为去年的年份
     * @param pojo
     * @return
     */
	@RequestMapping(value="/getEmploymentByYear",method=RequestMethod.POST)
    @ResponseBody
    public String queryEmploymentByYear(QueryPojo pojo) {
    	if(StringUtils.isEmpty(pojo.getNian())){
    		Calendar c=Calendar.getInstance();
    		pojo.setNian(String.valueOf(c.get(Calendar.YEAR)-1));
    	}
    	List<Map<String,String>> employmentByYear = employmentService.getEmploymentByYear("queryEmploymentByYear",pojo);
    	String resJson = JSONObject.toJSONString(employmentByYear);
    	return resJson;
    }
	 /**
     * 查询的为2016年的数据
     * @param pojo
     * @return
     */
	@RequestMapping(value="/queryThreeIndustryByYear",method=RequestMethod.POST)
	@ResponseBody
	public String queryThreeIndustryByYear(QueryPojo pojo) {
		
		if(StringUtils.isEmpty(pojo.getNian())){
			Calendar c=Calendar.getInstance();
			pojo.setNian(String.valueOf(c.get(Calendar.YEAR)-1));
		}
	    List<Map<String, String>> queryThreeIndustryByYear = employmentService.queryThreeIndustryByYear("queryThreeIndustryByYear",pojo);
		String resJson = JSONObject.toJSONString(queryThreeIndustryByYear);
		return resJson;
	}
	
	@RequestMapping(value="/queryOnceEmployment",method=RequestMethod.POST)
	@ResponseBody
	public String queryOnceEmployment(QueryPojo pojo) {
		
		if(StringUtils.isEmpty(pojo.getNian())){
			Calendar c=Calendar.getInstance();
			pojo.setNian(String.valueOf(c.get(Calendar.YEAR)-1));
		}
		List<Map<String,String>> queryOnceEmployment = employmentService.queryOnceEmployment("queryOnceEmployment",pojo);
		String resJson = JSONObject.toJSONString(queryOnceEmployment);
		return resJson;
	}
	
	@RequestMapping(value="/queryEdudegree",method=RequestMethod.POST)
	@ResponseBody
	public String queryEdudegree(QueryPojo pojo) {
		
		if(StringUtils.isEmpty(pojo.getNian())){
			Calendar c=Calendar.getInstance();
			pojo.setNian(String.valueOf(c.get(Calendar.YEAR)-1));
		}
		List<Map<String,String>> queryOnceEmployment = employmentService.queryEdudegree("queryEdudegree",pojo);
		String resJson = JSONObject.toJSONString(queryOnceEmployment);
		return resJson;
	}
	
	
}