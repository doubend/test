package com.cloud.icenter.yyzx.cstz.controller;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
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
import com.cloud.icenter.common.utils.StringUtil;
import com.cloud.icenter.common.utils.TreeNode;
import com.cloud.icenter.system.organ.pojo.OrganData;
import com.cloud.icenter.yyzx.cstz.pojo.CstzTzmxPojo;
import com.cloud.icenter.yyzx.cstz.pojo.CstzYwtzPojo;
import com.cloud.icenter.yyzx.cstz.service.CstzTzmxService;
import com.cloud.icenter.yyzx.cstz.service.CstzYwtzService;

/** 
* @author zhucy 
* @version 2017年4月12日 上午9:45:27 
* 说明 
*/
@Controller
@RequestMapping(value="/cstzTzmxAction")
public class CstzTzmxAction extends ModelAction<CstzTzmxPojo>{

	@Autowired
	private CstzTzmxService cstzTzmxService;
	
	@Autowired
	private CstzYwtzService cstzYwtzService;
	
	/**
	 * 跳转到体征模型tree页面
	 * @return
	 */
	@RequestMapping(value = "/toTzmx",method=RequestMethod.GET)
	public String toTzmx(){
		return "cstz/tzmxTree";
	}
	
	
	/**
	 * 跳转到体征模型tree页面
	 * @return
	 */
	@RequestMapping(value = "/toTzmxQz",method=RequestMethod.GET)
	public String toTzmxQz(){
		return "cstz/tzmxTree-qz";
	}
	
	/**
	 * 查询模型分类tree
	 * @param param
	 */
	@RequestMapping(value="/query",method=RequestMethod.POST)
	public void query(CstzTzmxPojo param) {
		
		String id=getId();
		
		List<CstzTzmxPojo> cstzTzmxPojos=cstzTzmxService.getChildren(id, "0");
		List tree=new ArrayList(cstzTzmxPojos.size());
		
		for(CstzTzmxPojo f:cstzTzmxPojos) {
			TreeNode node=new TreeNode();
			node.setId(f.getId());
			node.setText(f.getTzmc());
			if(f.getType()==CstzTzmxPojo.TYPE_DIRECTORY) {
				node.setState(TreeNode.STATE_CLOSED);
				node.setIconCls("fa fa-folder");
			} else {
				node.setState(TreeNode.STATE_OPEN);
				node.setIconCls("fa fa-file");
			}
			node.getAttributes().put("parentId", f.getParentId());
			node.getAttributes().put("type", f.getType());
			tree.add(node);
		}
		printJson(tree);
	}
	
	/**
	 * 查询模型分类tree,自动选中已选
	 * @param param
	 */
	@RequestMapping(value="/queryById",method=RequestMethod.POST)
	public void queryById() {
		
		String id=getId();
		
		List<CstzTzmxPojo> cstzTzmxPojos=cstzTzmxService.getChildren(id, "0");
		List tree=new ArrayList(cstzTzmxPojos.size());
		String checkId=getParameter("checkId");//选中的节点
		for(CstzTzmxPojo f:cstzTzmxPojos) {
			TreeNode node=new TreeNode();
			node.setId(f.getId());
			node.setText(f.getTzmc());
			if(f.getType()==CstzTzmxPojo.TYPE_DIRECTORY) {
				node.setState(TreeNode.STATE_CLOSED);
				node.setIconCls("fa fa-folder");
			} else {
				node.setState(TreeNode.STATE_OPEN);
				node.setIconCls("fa fa-file");
			}
			if(f.getId().equals(checkId)){//设置选中状态
				node.setChecked(true);
			}
			node.getAttributes().put("parentId", f.getParentId());
			node.getAttributes().put("type", f.getType());
			tree.add(node);
		}
		printJson(tree);
	}
	
	/**
	 * 跳转到添加模型页面
	 * @param parentId
	 * @return
	 */
	@RequestMapping(value="/toTzmxAdd/{parentId}",method=RequestMethod.GET)
   	public String add(@PathVariable String parentId) {
    	if(!StringUtils.isBlank(parentId)) {
    		CstzTzmxPojo parent=cstzTzmxService.get(parentId);
    		setAttribute("parent", parent);
    	}
   		return "cstz/tzmxTree-add";
   	}
	
	/**
	 * 跳转到修改模型页面
	 * @param id
	 * @return
	 */
   	@RequestMapping(value="/toTzmxUpdate/{id}",method=RequestMethod.GET)
   	public String update(@PathVariable String id) {
   		CstzTzmxPojo cstzTzmxPojo=cstzTzmxService.get(id);
   		setAttribute("cstzTzmxPojo", cstzTzmxPojo);
   		if(!StringUtils.isBlank(cstzTzmxPojo.getParentId())) {
   			CstzTzmxPojo parent=cstzTzmxService.get(cstzTzmxPojo.getParentId());
    		setAttribute("parent", parent);
    	}
   		return "cstz/tzmxTree-update";
   	}
   	
   	
   	@RequestMapping(value="/delete/{id}",method=RequestMethod.POST)
   	@ResponseBody
   	public JsonResult doDelete(@PathVariable String id) {
   		try {
   			CstzTzmxPojo cstzTzmxPojo = this.cstzTzmxService.get(id);
   			if (null != cstzTzmxPojo ) {
				if ("1".equals(cstzTzmxPojo.getIsDel())) {//可以删除
					List<CstzTzmxPojo> cstzTzmxPojos=cstzTzmxService.getChildren(id, "0");
		   			if (null != cstzTzmxPojos && cstzTzmxPojos.size() > 0) {
		   				return jsonResult(-1, "此体征模型节点下含有子节点不允许删除!");
					}
		   			cstzTzmxPojo.setTzzt("1");//体征状态改为禁用
		   			cstzTzmxPojo.setDeleteStatus("1");//删除状态改为已删除
					cstzTzmxService.update(cstzTzmxPojo);
				}else{
					return jsonResult(-1, "初始化数据不允许删除!");
				}
			}
   			
		} catch (Exception e) {
			return jsonResult(-1, e.getMessage());
		}
   		return jsonResult(200, "OK");
   	}
	
	
//	/**
//	 * 移动节点
//	 * @param targetId		目标节点id
//	 * @param sourceId		源节点id
//	 * @param point			操作类型	取值范围: append,top,bottom
//	 */
//	@RequestMapping(value="/move",method=RequestMethod.POST)
//   	@ResponseBody
//	public JsonResult move(@RequestParam String targetId,@RequestParam String sourceId,@RequestParam String point) {
//		cstzTzmxService.move(targetId, sourceId, point);
//		return jsonResult(200, "OK");
//	}
	
	/**
	 * 下级体征模型列表
	 * @param orgId
	 * @param params
	 */
	@RequestMapping(value = "/xjtzList/{id}" , method = RequestMethod.POST)
	public void xjtzList(@PathVariable String id){
		List<CstzTzmxPojo> cstzTzmxPojos=cstzTzmxService.getChildren(id, "0");
		printJson(cstzTzmxPojos);
	}
	
	/**
	 * 点击节点的时候,判断当前节点是否还可以添加子节点
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/checkIsAdd/{id}",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult checkIsAdd(@PathVariable String id){
		CstzTzmxPojo pojo = this.cstzTzmxService.get(id);
		if (null != pojo) {
			if (!pojo.getTzlx().equals("3")) {
				return jsonResult(200, "add");
			}
			return jsonResult(-1, "不能添加子节点");
		}
	    return null;
	}
	
	/**
	 * 新增或者修改时,判断选择的体征时候合法
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/checkYwtzId/{id}",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult checkYwtzId(@PathVariable String id){
		//判断业务体征是否已经存在
		boolean flag = this.cstzTzmxService.checkYwtzId(id);
		if (flag) {
			return jsonResult(-1, "当前业务体征已经存在,请重新选择!");
		}else{
			return jsonResult(200, "ok");
		}
	}
	
	
	/**
	 * 执行新增操作
	 * @param cstzTzmxPojo
	 * @param file
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
   	@ResponseBody
   	public JsonResult doAdd(CstzTzmxPojo cstzTzmxPojo , @RequestParam(value="file",required=false) MultipartFile file,  
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
        //处理关联的业务体征id
        if ("zidingyi".equals(cstzTzmxPojo.getYwtzId()) || StringUtil.isEmpty(cstzTzmxPojo.getYwtzId())) {
        	cstzTzmxPojo.setYwtzId(null);
		}else {
			 //获取体征编码
	        CstzYwtzPojo cstzYwtzPojo = this.cstzYwtzService.get(cstzTzmxPojo.getYwtzId());
	        if (null != cstzYwtzPojo) {
	        	cstzTzmxPojo.setCode(cstzYwtzPojo.getCode());//设置关联的业务体征编码
			}
		}
        cstzTzmxPojo.setSeqNum(this.cstzTzmxService.getMaxXssx());
        cstzTzmxPojo.setTbdz(path);
        cstzTzmxPojo.setCreateTime(new Date());
        cstzTzmxPojo.setCreator(getLoginUser().getCreatorId());
        cstzTzmxPojo.setDeleteStatus("0");
        cstzTzmxPojo.setTzzt("0");//设置体征默认状态
        cstzTzmxPojo.setQz(BigDecimal.ZERO);//设置默认权重(新添加数据默认为0)
        cstzTzmxPojo.setMrz(10);//设置体征默认值
        cstzTzmxPojo.setTzlx(this.getTzlx(cstzTzmxPojo.getParentId()));//设置体征类型
        cstzTzmxPojo.setIsDel("1");//用户自操作的数据都不是初始化数据,可以删除,标记为1
		try {
			cstzTzmxService.add(cstzTzmxPojo);
		} catch (Exception e) {
			if (e.getMessage().contains("体征")) {
				return jsonResult(-1, e.getMessage());
			}else{
				return jsonResult(-1, "系统异常！");
			}
			
		}
   		return jsonResult(200, "OK");
   	}
	
	/**
	 * 执行修改操作
	 * @param cstzTzmxPojo
	 * @param file
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
   	@ResponseBody
   	public JsonResult doUpdate(CstzTzmxPojo cstzTzmxPojo , @RequestParam(value="file",required=false) MultipartFile file,  
            HttpServletRequest request) throws Exception {
		CstzTzmxPojo oldPojo = cstzTzmxService.get(cstzTzmxPojo.getId());
		if (!cstzTzmxPojo.getTzmc().equals(oldPojo.getTzmc())) {//体征名称唯一性校验
			DetachedCriteria criteria = DetachedCriteria.forClass(CstzTzmxPojo.class);
			criteria.add(Restrictions.eq("tzmc", cstzTzmxPojo.getTzmc()))
			.add(Restrictions.eq("deleteStatus", "0"));
			List<CstzTzmxPojo> list = (List<CstzTzmxPojo>) this.cstzTzmxService.find(criteria);
			if (list.size() != 0) {
				return jsonResult(-1, "模型名称已存在！");
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
//            cstzTzmxPojo.setTbdz(path);//获取新图标地址
//            //删除原来的图片
//            delFile(pathRoot+oldPojo.getTbdz());
//        }else{//未修改图标
//        	cstzTzmxPojo.setTbdz(oldPojo.getTbdz());
//        }
		if (null != oldPojo) {
			cstzTzmxPojo.setCreateTime(oldPojo.getCreateTime());
			cstzTzmxPojo.setCreator(oldPojo.getCreator());
		}
		//处理关联的业务体征id
        if ("zidingyi".equals(cstzTzmxPojo.getYwtzId()) || StringUtil.isEmpty(cstzTzmxPojo.getYwtzId())) {
        	cstzTzmxPojo.setYwtzId(null);
		}else {
			 //获取体征编码
	        CstzYwtzPojo cstzYwtzPojo = this.cstzYwtzService.get(cstzTzmxPojo.getYwtzId());
	        if (null != cstzYwtzPojo) {
	        	cstzTzmxPojo.setCode(cstzYwtzPojo.getCode());//设置关联的业务体征编码
			}
		}
        cstzTzmxPojo.setSeqNum(oldPojo.getSeqNum());
		cstzTzmxPojo.setTzzt("0");//设置体征默认状态
        cstzTzmxPojo.setQz(oldPojo.getQz());//设置默认权重(新添加数据默认为0)
        cstzTzmxPojo.setMrz(10);//设置体征默认值
        cstzTzmxPojo.setTzlx(oldPojo.getTzlx());//设置体征类型
        cstzTzmxPojo.setIsDel("1");//用户自操作的数据都不是初始化数据,可以删除,标记为1
		cstzTzmxPojo.setDeleteStatus("0");
		cstzTzmxPojo.setUpdateTime(new Date());
		try {
			cstzTzmxService.update(cstzTzmxPojo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			if (e.getMessage().contains("体征")) {
				return jsonResult(-1, e.getMessage());
			}else{
				return jsonResult(-1, "系统异常！");
			}
		}
   		return jsonResult(200, "OK");
   	}
	
	/**
	 * 根据当前的父节点找出同级节点所属体征级别
	 * @param parentId
	 * @return
	 */
	public String getTzlx(String parentId){
		List<CstzTzmxPojo> cstzTzmxPojos=cstzTzmxService.getChildren(parentId, "0");
		if (null != cstzTzmxPojos && cstzTzmxPojos.size() > 0  ) {
			return cstzTzmxPojos.get(0).getTzlx();
		}
		return "3";
	}
	
	
	/**
	 * 删除图片
	 * @param filePath
	 */
	public void delFile(String filePath){
		File file = new File(filePath);
		file.delete();
	}
	
	/**
	 * 更新权重信息
	 * @param datas
	 * @return
	 */
	@RequestMapping(value="/saveQz",method=RequestMethod.POST)
   	@ResponseBody
	public JsonResult saveQz(@RequestBody CstzTzmxPojo[] datas){
		try {
			List<CstzTzmxPojo> batchList = new ArrayList<CstzTzmxPojo>();
			for (CstzTzmxPojo cstzTzmxPojo : datas) {
				CstzTzmxPojo pojo = this.cstzTzmxService.get(cstzTzmxPojo.getId());
				if (null != pojo) {
					pojo.setQz(cstzTzmxPojo.getQz());
					batchList.add(pojo);
				}
			}
			this.cstzTzmxService.bachSaveOrUpdateObject(batchList);
			return jsonResult(200, "ok");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return jsonResult(-1, "fail");
		}
	}
}
