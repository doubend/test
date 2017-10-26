package com.cloud.icenter.yyzx.cszc.zygl.controller;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import org.springframework.web.multipart.MultipartFile;

import com.cloud.icenter.base.controller.ModelAction;
import com.cloud.icenter.common.utils.JsonResult;
import com.cloud.icenter.common.utils.StringUtil;
import com.cloud.icenter.yyzx.common.util.excel.HttpUtil;
import com.cloud.icenter.yyzx.cstz.pojo.CstzYwzbsjPojo;
import com.cloud.icenter.yyzx.cszc.zygl.pojo.BjmbPojo;
import com.cloud.icenter.yyzx.cszc.zygl.pojo.JbxxPojo;
import com.cloud.icenter.yyzx.cszc.zygl.pojo.SchoolPojo;
import com.cloud.icenter.yyzx.cszc.zygl.pojo.XsjlPojo;
import com.cloud.icenter.yyzx.cszc.zygl.service.BjmbService;
import com.cloud.icenter.yyzx.cszc.zygl.service.JbxxService;
import com.cloud.icenter.yyzx.cszc.zygl.service.XsjlService;

/** 
* @author zhucy 
* @version 2017年3月20日 下午5:15:53 
* 城市资源>资源管理
*/
@Controller
@RequestMapping("/zygl")
public class ZyglAction extends ModelAction<JbxxPojo>{
	@Autowired
	private JbxxService jbxxService;
	
	@Autowired
	private XsjlService xsjlService;
	
	@Autowired
	private BjmbService bjmbService;
	
	/**
	 * 跳转到资源登记页面
	 * @return
	 */
	@RequestMapping(value="/toZydj",method=RequestMethod.GET)
    public String toZydj() {
    	return "cszc/zygl/zydj";
    }
	
	/**
	 * 跳转到添加养护页面
	 * @return
	 */
	@RequestMapping(value="/toYhAdd/{id}",method=RequestMethod.GET)
	public String toYhAdd(@PathVariable String id){
		JbxxPojo jbxxPojo = jbxxService.get(id);
		setAttribute("id", id);
		return "cszc/zygl/yh-add";
	}
	
	
	/**
	 * 跳转到资源养护记录页面
	 * @return
	 */
	@RequestMapping(value="/toShowXsjl/{id}",method=RequestMethod.GET)
	public String toShowXsjl(@PathVariable String id){
		setAttribute("id", id);
		return "cszc/zygl/xsjl-list";
	}
	/**
	 * 查询基本部件
	 */
	@RequestMapping(value="/queryJbxx",method=RequestMethod.POST)
	public void queryJbxx(JbxxPojo param){
		DetachedCriteria criteria=getPagination().getCriteria();
		if(!StringUtils.isEmpty(param.getZymc())) {
			criteria.add(Restrictions.like("zymc",param.getZymc(),MatchMode.ANYWHERE));
		}
		if(!StringUtils.isEmpty(param.getSsyjflid())) {
			criteria.add(Restrictions.eq("ssyjflid",param.getSsyjflid()));
		}
		if(!StringUtils.isEmpty(param.getSsejflid())) {
			criteria.add(Restrictions.eq("ssejflid",param.getSsejflid()));
		}
		criteria.add(Restrictions.eq("deleteStatus","0"));
		criteria.addOrder(Order.desc("createTime"));
		jbxxService.find(getPagination());
		List<JbxxPojo> list = getPagination().getDataList();
		for (JbxxPojo jbxxPojo : list) {
			if (!StringUtil.isEmpty(jbxxPojo.getSsejflid())) {
				BjmbPojo bjmbPojo = bjmbService.get(jbxxPojo.getSsejflid());
				if (null != bjmbPojo) {
					jbxxPojo.setSsejflbh(bjmbPojo.getMc());
				}
			}
			
		}
		getPagination().setDataList(list);
		printJson(getPagination());
	}
	/**
	 * 查询基本部件-通过资源分类id
	 */
	@RequestMapping(value="/queryJbxx/{id}",method=RequestMethod.POST)
	public void queryJbxx(@PathVariable String id){
		DetachedCriteria criteria=getPagination().getCriteria();
		BjmbPojo  bjmbPojo = this.bjmbService.get(id);
		criteria.add(Restrictions.eq("ssejflbh", bjmbPojo.getDm()));
		criteria.addOrder(Order.desc("createTime"));
		jbxxService.find(getPagination());
		printJson(getPagination());
	}
	
	/**
	 * 导入城市基本信息
	 * @param file
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/importExcel",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult importExcel(MultipartFile file, HttpServletRequest request){
		String bjmbId = request.getParameter("bjmbId");
	    Map<String, Object> result = new HashMap<String,Object>();
		try {
			result = this.jbxxService.readExcelData(file,getLoginUser().getCreatorId(),bjmbId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			String msg = e.getMessage();
			if (msg.contains("MSG")) {
				return jsonResult(0, msg.replace("MSG_", ""));
			}else{
				e.printStackTrace();
			}
		}
	    if ("dataIsNull".equals(result.get("msg"))) {
	        return jsonResult(0, "文件内容不能为空!");
        }
//	    Object errorObj = result.get("error");
//	    List<JbxxPojo> error = null;
//	    if (null != errorObj) {
//	    	error = (List<JbxxPojo>)errorObj;
//	    	String errorFileName = this.jbxxService.createErrorFile(error);
//            return jsonResult(1, "导入成功", errorFileName);
//		}
	   return jsonResult(1, "导入成功!");
	}
	
	 /**
	  * 下载错误数据
	  * @param request
	  * @param response
	  */
	 @RequestMapping("/downLoadError")
	 public void downLoadError(HttpServletRequest request,
	            HttpServletResponse response) {
	        String fileName = request.getParameter("fileName");
	        String tempPath = System.getProperty("java.io.tmpdir");
	        File file = new File(tempPath + File.separator + fileName);
	        if (!file.exists() || !file.isFile()) {// 文件不存在，自动跳转404
	            return;
	        }
	        String httpMime = "";
	        if (fileName.endsWith(".zip")) {
	            httpMime = HttpUtil.HTTP_MIME_ZIP;
	        } else {
	            httpMime = HttpUtil.HTTP_MIME_XLS;
	        }
	        
	        HttpUtil.sendFile(request, response, file.getPath(), file.getName(),
	                httpMime);
	    }
	
	
	/**
	 * 跳转到资源新增页面
	 * @return
	 */
	@RequestMapping(value="/toZydjAdd",method=RequestMethod.GET)
    public String toZydjAdd() {
    	return "cszc/zygl/jbxx-add";
    }
	
	
	/**
	 * 跳转到资源修改页面
	 * @return
	 */
	@RequestMapping(value="/toZydjUpdate/{id}",method=RequestMethod.GET)
    public String toZydjUpdate(@PathVariable String id) {
		JbxxPojo jbxxPojo = jbxxService.get(id);
		setAttribute("jbxxPojo", jbxxPojo);
    	return "cszc/zygl/jbxx-update";
    }
	
	/**
	 * 跳转到资源详情页面
	 * @return
	 */
	@RequestMapping(value="/toZydjInfo/{id}",method=RequestMethod.GET)
    public String toZydjInfo(@PathVariable String id) {
		JbxxPojo jbxxPojo = jbxxService.get(id);
		if (!StringUtil.isEmpty(jbxxPojo.getSsejflid())) {
			BjmbPojo bjmbPojo = bjmbService.get(jbxxPojo.getSsejflid());
			if (null != bjmbPojo) {
				jbxxPojo.setSsejflbh(bjmbPojo.getMc());
			}
		}
		setAttribute("jbxxPojo", jbxxPojo);
    	return "cszc/zygl/jbxx-info";
    }
	
	/**
	 * 资源基本信息保存
	 * @param bjmbPojo
	 * @return
	 */
	@RequestMapping(value="/add/{fId}",method=RequestMethod.POST)
   	@ResponseBody
   	public JsonResult doAdd(@RequestBody JbxxPojo jbxxPojo , @PathVariable String fId) {
		jbxxPojo.setCreatorId(getLoginUser().getUserId());
		jbxxPojo.setCreateTime(new Date());
		jbxxPojo.setDeleteStatus("0");
		BjmbPojo bjmbPojo = bjmbService.get(fId);
		if (null != bjmbPojo) {
			jbxxPojo.setSsyjflid(bjmbPojo.getSjbh());
			jbxxPojo.setSsejflid(bjmbPojo.getId());
			//编码处理,获取后两位
			String ejbh = bjmbPojo.getDm();//二级分类代码
			if (!StringUtil.isEmpty(ejbh)) {
				String newStr = ejbh.substring(ejbh.length()-2,ejbh.length());//二级分类代码
				jbxxPojo.setSsejflbh(newStr);
				String newStr1 = ejbh.substring(ejbh.length()-4,ejbh.length()-2);//一级分类代码
				jbxxPojo.setSsyjflbh(newStr1);
			}
		}else{
			return jsonResult(-1, "fail");
		}
		
		try {
			jbxxService.add(jbxxPojo);
			return jsonResult(200, "OK");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonResult(-1, "fail");
   	}
	
	
	/**
	 * 资源基本信息修改
	 * @param bjmbPojo
	 * @return
	 */
	@RequestMapping(value="/update/{fId}",method=RequestMethod.POST)
   	@ResponseBody
   	public JsonResult doUpdate(@PathVariable String fId , @RequestBody JbxxPojo jbxxPojo) {
		JbxxPojo oldPojo = jbxxService.get(jbxxPojo.getId());
		if ("noChange".equals(fId)) {
			jbxxPojo.setSsejflbh(oldPojo.getSsejflbh());
			jbxxPojo.setSsyjflbh(oldPojo.getSsyjflbh());
			jbxxPojo.setSsejflid(oldPojo.getSsejflid());
			jbxxPojo.setSsyjflid(oldPojo.getSsyjflid());
		}else{
			BjmbPojo bjmbPojo = bjmbService.get(fId);
			if (null != bjmbPojo) {
				jbxxPojo.setSsyjflid(bjmbPojo.getSjbh());
				jbxxPojo.setSsejflid(bjmbPojo.getId());
				//编码处理,获取后两位
				String ejbh = bjmbPojo.getDm();//二级分类代码
				if (!StringUtil.isEmpty(ejbh)) {
					String newStr = ejbh.substring(ejbh.length()-2,ejbh.length());//二级分类代码
					jbxxPojo.setSsejflbh(newStr);
					String newStr1 = ejbh.substring(ejbh.length()-4,ejbh.length()-2);//一级分类代码
					jbxxPojo.setSsyjflbh(newStr1);
				}
			}else{
				return jsonResult(-1, "fail");
			}
		}
		jbxxPojo.setCreateTime(oldPojo.getCreateTime());
		jbxxPojo.setCreatorId(getLoginUser().getUserId());
		jbxxPojo.setUpdateTime(new Date());
		jbxxPojo.setDeleteStatus("0");
		try {
			jbxxService.update(jbxxPojo);
			return jsonResult(200, "OK");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonResult(-1, "fail");
   	}
	
	@RequestMapping(value="/toBjmbFunction",method=RequestMethod.GET)
    public String toBjmbFunction() {
    	return "cszc/zygl/bjmb-function";
    }
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult doDelete(@PathVariable String id , HttpServletRequest request) {
		JbxxPojo jbxxPojo = this.jbxxService.get(id);
		DetachedCriteria criteria = DetachedCriteria.forClass(XsjlPojo.class);
		criteria.add(Restrictions.eq("jbxxId", jbxxPojo.getId())).add(Restrictions.eq("deleteStatus", "0"));
		List<XsjlPojo> xsjlPojos = (List<XsjlPojo>) this.xsjlService.find(criteria);
		if (null != xsjlPojos && xsjlPojos.size() > 0 ) {
			return jsonResult(-1, "请先删除资产下养护记录,再删除此资产信息!");
		}
		jbxxPojo.setDeleteStatus("1");
		this.jbxxService.update(jbxxPojo);
		//查看是否有养护记录
		return jsonResult(200, "OK");
	}
	
	public static void main(String[] args) {
		String str = "123.221111";
		System.out.println(str.matches("[1-9]{1}[0-9]{2}[.]{1}[0-9]{1,6}"));
	}
}
