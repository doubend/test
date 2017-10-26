package com.cloud.icenter.yyzx.cstz.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cloud.icenter.base.controller.ModelAction;
import com.cloud.icenter.common.utils.JsonResult;
import com.cloud.icenter.common.utils.PagingUtil;
import com.cloud.icenter.common.utils.StringUtil;
import com.cloud.icenter.yyzx.cstz.pojo.CstzTzmxPojo;
import com.cloud.icenter.yyzx.cstz.pojo.CstzYwtzPojo;
import com.cloud.icenter.yyzx.cstz.pojo.CstzYwzbPojo;
import com.cloud.icenter.yyzx.cstz.service.CstzTzmxService;
import com.cloud.icenter.yyzx.cstz.service.CstzYwtzService;
import com.cloud.icenter.yyzx.cstz.service.CstzYwzbService;

/** 
* @author zhucy 
* @version 2017年4月5日 下午2:48:44 
* 说明 
*/
@Controller
@RequestMapping("/cstzYwtzAction")
public class CstzYwtzAction extends ModelAction<CstzYwtzPojo>{
	
	@Autowired
	private CstzYwtzService cstzYwtzService;
	
	@Autowired
	private CstzYwzbService cstzYwzbService;
	
	@Autowired
	private CstzTzmxService cstzTzmxService;
	
	
	/**
	 * 跳转到业务体征列表页面
	 * @return
	 */
	@RequestMapping(value="/toYwtzList",method=RequestMethod.GET)
    public String toYwtzList() {
    	return "cstz/ywtz-list";
    }
	
	/**
	 * 查询业务体征数据
	 * @param param
	 */
	@RequestMapping(value="/getList",method=RequestMethod.POST)
	@ResponseBody
	public Object queryYwtz(CstzYwtzPojo param,PagingUtil pagingUtil){
		Map<String, ?> result = this.cstzYwtzService.getYwtzList(pagingUtil, param.getCode(), param.getYwzbmc());
		return result;
	}
	
	
	
	/**
	 * 跳转新增页面
	 * @return
	 */
	@RequestMapping(value="/toYwtzAdd",method=RequestMethod.GET)
    public String toYwtzAdd() {
    	return "cstz/ywtz-add";
    }
	
	
	/**
	 * 跳转到修改页面
	 * @return
	 */
	@RequestMapping(value="/toYwtzUpdate/{id}",method=RequestMethod.GET)
    public String toYwtzUpdate(@PathVariable String id) {
		CstzYwtzPojo cstzYwtzPojo = cstzYwtzService.get(id);
		setAttribute("cstzYwtzPojo", cstzYwtzPojo);
		//阈值区间分割处理
		if (!StringUtil.isEmpty(cstzYwtzPojo.getYz())) {
			String [] args = cstzYwtzPojo.getYz().split(",");
			for (int i = 0; i < args.length; i++) {
				int index = i+1;
				setAttribute("yz"+index, args[i]);
			}
		}
    	return "cstz/ywtz-update";
    }
	
	/**
	 * 体征信息保存
	 * @param bjmbPojo
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
   	@ResponseBody
   	public JsonResult doAdd(CstzYwtzPojo cstzYwtzPojo , @RequestParam(value="file",required=false) MultipartFile file,  
            HttpServletRequest request) throws Exception {
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
        cstzYwtzPojo.setTbdz(path);
		cstzYwtzPojo.setCreateTime(new Date());
		cstzYwtzPojo.setCreator(getLoginUser().getCreatorId());
		cstzYwtzPojo.setDeleteStatus("0");
		cstzYwtzService.add(cstzYwtzPojo);
   		return jsonResult(200, "OK");
   	}
	
	
	/**
	 * 体征信息修改
	 * @param bjmbPojo
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
   	@ResponseBody
   	public JsonResult doUpdate(CstzYwtzPojo cstzYwtzPojo , @RequestParam(value="file",required=false) MultipartFile file,  
            HttpServletRequest request) throws Exception {
		CstzYwtzPojo oldPojo = cstzYwtzService.get(cstzYwtzPojo.getId());
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
//            cstzYwtzPojo.setTbdz(path);//获取新图标地址
//            //删除原来的图片
//            delFile(pathRoot+oldPojo.getTbdz());
//        }else{//未修改图标
//        	cstzYwtzPojo.setTbdz(oldPojo.getTbdz());
//        }
		if (null != oldPojo) {
			cstzYwtzPojo.setCreateTime(oldPojo.getCreateTime());
			cstzYwtzPojo.setCreator(oldPojo.getCreator());
		}
		cstzYwtzPojo.setDeleteStatus("0");
		cstzYwtzPojo.setUpdateTime(new Date());
		cstzYwtzService.update(cstzYwtzPojo);
   		return jsonResult(200, "OK");
   	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult doDelete(@PathVariable String id) {
		CstzYwtzPojo oldPojo = cstzYwtzService.get(id);
		//判断是否关联模型树,关联则不允许删除
		DetachedCriteria criteria = DetachedCriteria.forClass(CstzTzmxPojo.class);
		criteria.add(Restrictions.eq("ywtzId", oldPojo.getId()))
			.add(Restrictions.eq("deleteStatus", "0"));
		List<CstzTzmxPojo> cstzTzmxPojos = (List<CstzTzmxPojo>) this.cstzTzmxService.find(criteria);
		if (null != cstzTzmxPojos && cstzTzmxPojos.size() > 0 ) {
			return jsonResult(-1, "指标集已经关联体征模型,不允许删除,请先删除关联的体征模型!");
		}
		oldPojo.setDeleteStatus("1");
		cstzYwtzService.update(oldPojo);//逻辑删除
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
	
	@RequestMapping(value="/checkYwzbId/{id}",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult checkYwzbId(@PathVariable String id){
		//判断指标是否已经存在
		CstzYwtzPojo pojo = this.cstzYwtzService.getCstzYwtzPojoByYwzbId(id);
		if (null != pojo) {
			if (pojo.getDeleteStatus().equals("1")) {
				return jsonResult(200, "ok");
			}else{
				return jsonResult(-1, "当前指标已经存在,请重新选择指标!");
			}
		}else{
			return jsonResult(200, "ok");
		}
	}
	
	
	/**
	 * 查询业务体征数据(体征模型树选择)
	 * @param param
	 */
	@RequestMapping(value="/queryYwtzForTzmx",method=RequestMethod.POST)
	public void queryYwtzForTzmx(){
		DetachedCriteria criteria=getPagination().getCriteria();
		criteria.add(Restrictions.eq("deleteStatus", "0"));
		criteria.addOrder(Order.desc("createTime"));
		List<CstzYwtzPojo> list = (List<CstzYwtzPojo>) cstzYwtzService.find(criteria);
		for (CstzYwtzPojo cstzYwtzPojo : list) {
			CstzYwzbPojo cstzYwzbPojo = this.cstzYwzbService.get(cstzYwtzPojo.getYwzbId());
			if (null != cstzYwzbPojo) {
				cstzYwtzPojo.setYwzbmc(cstzYwzbPojo.getYwzbmc());
			}
		}
		List<CstzYwtzPojo> newList = new ArrayList<CstzYwtzPojo>();
		CstzYwtzPojo pojo = new CstzYwtzPojo();
		pojo.setId("zidingyi");
		pojo.setYwzbmc("---请选择---");
		newList.add(pojo);
		newList.addAll(list);
		printJson(newList);
	}
}
