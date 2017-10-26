package com.cloud.icenter.yyzx.cstz.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.multipart.MultipartFile;

import com.cloud.icenter.base.controller.ModelAction;
import com.cloud.icenter.common.utils.JsonResult;
import com.cloud.icenter.yyzx.cstz.pojo.CstzYwtzPojo;
import com.cloud.icenter.yyzx.cstz.pojo.CstzYwzbPojo;
import com.cloud.icenter.yyzx.cstz.pojo.CstzYwzbsjPojo;
import com.cloud.icenter.yyzx.cstz.service.CstzYwtzService;
import com.cloud.icenter.yyzx.cstz.service.CstzYwzbService;
import com.cloud.icenter.yyzx.cszc.zygl.pojo.BjmbPojo;
import com.cloud.icenter.yyzx.cszc.zygl.pojo.JbxxPojo;

/** 
* @author zhucy 
* @version 2017年4月5日 下午2:48:44 
* 说明 
*/
@Controller
@RequestMapping("/cstzYwzbAction")
public class CstzYwzbAction extends ModelAction<CstzYwzbPojo>{
	
	@Autowired
	private CstzYwzbService cstzYwzbService;
	
	@Autowired
	private CstzYwtzService cstzYwtzService;
	
	
	/**
	 * 跳转到业务指标列表页面
	 * @return
	 */
	@RequestMapping(value="/toYwzbList",method=RequestMethod.GET)
    public String toYwzbList() {
    	return "cstz/ywzb-list";
    }
	
	/**
	 * 查询业务指标数据
	 * @param param
	 */
	@RequestMapping(value="/queryYwzb",method=RequestMethod.POST)
	public void queryYwzb(CstzYwzbPojo param){
		DetachedCriteria criteria=getPagination().getCriteria();
		if(!StringUtils.isEmpty(param.getYwzbmc())) {
			criteria.add(Restrictions.like("ywzbmc", param.getYwzbmc(),MatchMode.ANYWHERE));
		}
		if(!StringUtils.isEmpty(param.getCode())) {
			criteria.add(Restrictions.like("code", param.getCode(),MatchMode.ANYWHERE));
		}
		criteria.add(Restrictions.eq("deleteStatus", "0"));
		criteria.addOrder(Order.desc("createTime"));
		cstzYwzbService.find(getPagination());
		printJson(getPagination());
	}
	
	/**
	 * 查询业务指标数据(下拉框)
	 * @param param
	 */
	@RequestMapping(value="/getYwzb",method=RequestMethod.POST)
	public void getYwzb(){
		DetachedCriteria criteria=getPagination().getCriteria();
		criteria.add(Restrictions.eq("deleteStatus", "0"));
		criteria.addOrder(Order.desc("createTime"));
		printJson(cstzYwzbService.find(criteria));
	}
	
	
	/**
	 * 跳转新增页面
	 * @return
	 */
	@RequestMapping(value="/toYwzbAdd",method=RequestMethod.GET)
    public String toYwzbAdd() {
    	return "cstz/ywzb-add";
    }
	
	
	/**
	 * 跳转到修改页面
	 * @return
	 */
	@RequestMapping(value="/toYwzbUpdate/{id}",method=RequestMethod.GET)
    public String toYwzbUpdate(@PathVariable String id) {
		CstzYwzbPojo cstzYwzbPojo = cstzYwzbService.get(id);
		setAttribute("cstzYwzbPojo", cstzYwzbPojo);
    	return "cstz/ywzb-update";
    }
	
	/**
	 * 资源基本信息保存
	 * @param bjmbPojo
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
   	@ResponseBody
   	public JsonResult doAdd(CstzYwzbPojo cstzYwzbPojo , @RequestParam(value="file",required=false) MultipartFile file,  
            HttpServletRequest request) throws Exception {
		//通过业务指标名称进行重复判断
		DetachedCriteria criteria = DetachedCriteria.forClass(CstzYwzbPojo.class);
		criteria.add(Restrictions.eq("ywzbmc", cstzYwzbPojo.getYwzbmc()))
			.add(Restrictions.eq("deleteStatus", "0"));
		List<CstzYwzbPojo> cstzYwzbPojos = (List<CstzYwzbPojo>) this.cstzYwzbService.find(criteria);
		if (null != cstzYwzbPojos && cstzYwzbPojos.size() > 0 ) {
			return jsonResult(-1, "指标名称已存在!");
		}
		//通过业务指标名称进行重复判断
		DetachedCriteria criteria1 = DetachedCriteria.forClass(CstzYwzbPojo.class);
		criteria1.add(Restrictions.eq("code", cstzYwzbPojo.getCode()))
		.add(Restrictions.eq("deleteStatus", "0"));;
		List<CstzYwzbPojo> cstzYwzbPojos1 = (List<CstzYwzbPojo>) this.cstzYwzbService.find(criteria1);
		if (null != cstzYwzbPojos1 && cstzYwzbPojos1.size() > 0 ) {
			return jsonResult(-1, "指标编码已存在!");
		}
		//获得物理路径webapp所在路径  
        String pathRoot = request.getSession().getServletContext().getRealPath("");  
        String path="";  
//        if(!file.isEmpty()){
//        	String fileName = file.getOriginalFilename();
//            // 获取上传文件扩展名
//            String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
//            // 对扩展名进行小写转换
//            fileExt = fileExt.toLowerCase();
//            // 图片文件大小过滤
//            if (!"jpg".equals(fileExt) && !"jpeg".equals(fileExt) && !"png".equals(fileExt) && !"bmp".equals(fileExt)
//                    && !"gif".equals(fileExt)) {
//                return jsonResult(-1, "无效图片类型!");
//            }
//            //生成uuid作为文件名称  
//            String uuid = UUID.randomUUID().toString().replace("-", "");
//            String contentType=file.getContentType();  
//            //获得文件后缀名称  
//            String imageName=contentType.substring(contentType.indexOf("/")+1);  
//            path="/image/cstz/"+uuid+"."+imageName;  
//            file.transferTo(new File(pathRoot+path));  
//        }  
        cstzYwzbPojo.setTbdz(path);
		cstzYwzbPojo.setCreateTime(new Date());
		cstzYwzbPojo.setCreator(getLoginUser().getCreatorId());
		cstzYwzbPojo.setDeleteStatus("0");
		cstzYwzbService.add(cstzYwzbPojo);
   		return jsonResult(200, "OK");
   	}
	
	
	/**
	 * 资源基本信息修改
	 * @param bjmbPojo
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
   	@ResponseBody
   	public JsonResult doUpdate(CstzYwzbPojo cstzYwzbPojo , @RequestParam(value="file",required=false) MultipartFile file,  
            HttpServletRequest request) throws Exception {
		CstzYwzbPojo oldPojo = cstzYwzbService.get(cstzYwzbPojo.getId());
		//通过业务指标名称进行重复判断
		if (!cstzYwzbPojo.getYwzbmc().equals(oldPojo.getYwzbmc())) {
			DetachedCriteria criteria = DetachedCriteria.forClass(CstzYwzbPojo.class);
			criteria.add(Restrictions.eq("ywzbmc", cstzYwzbPojo.getYwzbmc()))
				.add(Restrictions.eq("deleteStatus", "0"));
			List<CstzYwzbPojo> cstzYwzbPojos = (List<CstzYwzbPojo>) this.cstzYwzbService.find(criteria);
			if (null != cstzYwzbPojos && cstzYwzbPojos.size() > 0 ) {
				return jsonResult(-1, "指标名称已存在!");
			}
		}
		//通过业务指标名称进行重复判断
		if (!cstzYwzbPojo.getCode().equals(oldPojo.getCode())) {
			DetachedCriteria criteria1 = DetachedCriteria.forClass(CstzYwzbPojo.class);
			criteria1.add(Restrictions.eq("code", cstzYwzbPojo.getCode()))
			.add(Restrictions.eq("deleteStatus", "0"));;
			List<CstzYwzbPojo> cstzYwzbPojos1 = (List<CstzYwzbPojo>) this.cstzYwzbService.find(criteria1);
			if (null != cstzYwzbPojos1 && cstzYwzbPojos1.size() > 0 ) {
				return jsonResult(-1, "指标编码已存在!");
			}
		}
		//获得物理路径webapp所在路径  
        String pathRoot = request.getSession().getServletContext().getRealPath("");  
        String path="";  
//        if(null != file){//修改了图标
//        	String fileName = file.getOriginalFilename();
//            // 获取上传文件扩展名
//            String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
//            // 对扩展名进行小写转换
//            fileExt = fileExt.toLowerCase();
//            // 图片文件大小过滤
//            if (!"jpg".equals(fileExt) && !"jpeg".equals(fileExt) && !"png".equals(fileExt) && !"bmp".equals(fileExt)
//                    && !"gif".equals(fileExt)) {
//                return jsonResult(-1, "无效图片类型!");
//            }
//            //生成uuid作为文件名称  
//            String uuid = UUID.randomUUID().toString().replace("-", "");
//            String contentType=file.getContentType();  
//            //获得文件后缀名称  
//            String imageName=contentType.substring(contentType.indexOf("/")+1);  
//            path="/image/cstz/"+uuid+"."+imageName;  
//            file.transferTo(new File(pathRoot+path));  
//            cstzYwzbPojo.setTbdz(path);//获取新图标地址
//            //删除原来的图片
//            delFile(pathRoot+oldPojo.getTbdz());
//        }else{//未修改图标
//        	cstzYwzbPojo.setTbdz(oldPojo.getTbdz());
//        }
		if (null != oldPojo) {
			cstzYwzbPojo.setCreateTime(oldPojo.getCreateTime());
			cstzYwzbPojo.setCreator(oldPojo.getCreator());
		}
		cstzYwzbPojo.setDeleteStatus("0");
		cstzYwzbPojo.setUpdateTime(new Date());
		cstzYwzbService.update(cstzYwzbPojo);
   		return jsonResult(200, "OK");
   	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult doDelete(@PathVariable String id , HttpServletRequest request) {
		String pathRoot = request.getSession().getServletContext().getRealPath("");
		CstzYwzbPojo oldPojo = cstzYwzbService.get(id);
		DetachedCriteria criteria = DetachedCriteria.forClass(CstzYwtzPojo.class);
		criteria.add(Restrictions.eq("ywzbId", oldPojo.getId()))
			.add(Restrictions.eq("deleteStatus", "0"));
		List<CstzYwtzPojo> cstzYwtzPojos = (List<CstzYwtzPojo>) this.cstzYwzbService.find(criteria);
		if (null != cstzYwtzPojos && cstzYwtzPojos.size() > 0 ) {
			return jsonResult(-1, "指标已经关联指标集,不允许删除,请先删除关联的指标集!");
		}
		//先删除图片资源
//		delFile(pathRoot+oldPojo.getTbdz());
		oldPojo.setDeleteStatus("1");
		cstzYwzbService.update(oldPojo);//逻辑删除
		return jsonResult(200, "OK");
	}
	
	/**
	 * 删除图片
	 * @param filePath
	 */
	public void delFile(String filePath){
		File file = new File(filePath);
		file.delete();
	}
	
}
