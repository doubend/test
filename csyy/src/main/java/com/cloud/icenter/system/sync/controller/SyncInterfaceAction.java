package com.cloud.icenter.system.sync.controller;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.icenter.base.controller.ModelAction;
import com.cloud.icenter.common.utils.DESUtil;
import com.cloud.icenter.common.utils.HttpUtil;
import com.cloud.icenter.common.utils.JsonResult;
import com.cloud.icenter.common.utils.JsonUtil;
import com.cloud.icenter.common.utils.Md5Util;
import com.cloud.icenter.common.utils.RSAUtil;
import com.cloud.icenter.common.utils.SystemConfig;
import com.cloud.icenter.system.login.bean.SSOKey;
import com.cloud.icenter.system.sync.dto.OrganMsg;
import com.cloud.icenter.system.sync.dto.RoleMsg;
import com.cloud.icenter.system.sync.dto.UserMsg;
import com.cloud.icenter.system.sync.pojo.Synclog;
import com.cloud.icenter.system.sync.service.SyncService;


@Controller
@RequestMapping(value="/system/syncinterface")
public class SyncInterfaceAction  extends ModelAction<Object> {
	
	@Autowired
	private SyncService syncService;
	@Autowired
	private RSAUtil rsaUtil;

	private String appId;
	
	/**
	 * 全用户同步
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value="/syncAllUser",method=RequestMethod.GET)
	@ResponseBody
	public JsonResult syncAllUser(@RequestParam(value = "appid" , required = true)String appId) {
		try{
			//生成认证信息
			String requestTime = getSysdate();
			String authcode = getAuthcode(requestTime , appId);
			//获取解密需要用的秘钥信息
			SSOKey key = this.getSSOkey();
			JsonResult jsonresult = null;
			if(authcode==null || authcode.equals("")){
				return jsonResult(-1, "生成认证信息失败！");
			}
			if(key == null){
				return jsonResult(-1 , "获取秘钥信息失败!");
			}
			//获取全用户信息
			String getAllUser = SystemConfig.getProperty("tyrz.Url")+SystemConfig.getProperty("tyrz.sync.getAllUser");
			//统一认证返回的数据预先经过加密码处理，因此需要对其进行解密
			UserMsg[] userlist = null;
			String result = HttpUtil.HttpGet(getAllUser + "?appId="+this.appId
													 + "&requestTime=" + requestTime
													 + "&authcode=" + authcode);
			if(result!=null && !result.equals("")){
				jsonresult = JsonUtil.toObject(result, JsonResult.class);
			}
			if(jsonresult.getCode()!=200){
				return jsonresult;
			}else{
				String desKey = key.getPrivateexponent().substring(0, 32);
				String decString = DESUtil.decrypt((String)jsonresult.getData(), desKey);
				userlist = JsonUtil.toObject(decString, UserMsg[].class);
			}
			
			if(userlist==null || userlist.length==0){
				return jsonResult(-1, "获取用户信息失败！");
			}
			syncService.syncAllUser(userlist);
		}catch(Exception  e){  
            e.printStackTrace();
            return jsonResult(-1, "同步处理异常!");
        }
		return jsonResult(200, "OK");
	}
	
	/**
	 * 全用户同步
	 * @return
	 */
	@RequestMapping(value="/syncAllUser",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult syncAllUser2(@RequestParam(value = "requestTime", required = true) String requestTime,
								   @RequestParam(value = "authcode", required = true) String authcode,
								   @RequestParam(value = "usermsgstr", required = true) String usermsgstr,
								   @RequestParam(value = "appid" , required = true)String appId) {
		try{
			//生成认证信息
			if(!authcode.equals(getAuthcode(requestTime , appId))){
				return jsonResult(-1, "认证失败！");
			}
			SSOKey key = this.getSSOkey();
			if(key == null){
				return jsonResult(-1, "获取秘钥信息失败!");
			}
			//获取全用户信息
			UserMsg[] userlist = null;
			if(usermsgstr!=null && !usermsgstr.equals("")){
				//对用户信息进行解密
				String desKey = key.getPrivateexponent().substring(0, 32);
				usermsgstr = DESUtil.decrypt(usermsgstr, desKey);
				userlist = JsonUtil.toObject(usermsgstr, UserMsg[].class);
			}
			if(userlist==null || userlist.length==0){
				return jsonResult(-1, "解析用户信息失败！");
			}
			syncService.syncAllUser(userlist);
		}catch(Exception  e){
            e.printStackTrace();
            return jsonResult(-1, "同步处理异常!");
        }
		return jsonResult(200, "OK");
	}
	
	/**
	 * 全组织同步
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/syncAllOrg",method=RequestMethod.GET)
	@ResponseBody
	public JsonResult syncAllOrg(@RequestParam(value = "appid" , required = true)String appId) {
		try{
			//生成认证信息
			String requestTime = getSysdate();
			String authcode = getAuthcode(requestTime , appId);
			JsonResult jsonresult = null;
			if(authcode==null || authcode.equals("")){
				return jsonResult(-1, "生成认证信息失败！");
			}
			SSOKey key = this.getSSOkey();
			if(key == null){
				return jsonResult(-1, "获取秘钥信息失败!");
			}
			//获取全用户信息
			String getAllOrg = SystemConfig.getProperty("tyrz.Url")+SystemConfig.getProperty("tyrz.sync.getAllOrg");
			OrganMsg[] orglist = null;
			String result = HttpUtil.HttpGet(getAllOrg + "?appId="+this.appId
													 + "&requestTime=" + requestTime
													 + "&authcode=" + authcode);
			if(result!=null && !result.equals("")){
				jsonresult = JsonUtil.toObject(result, JsonResult.class);
			}
			if(jsonresult.getCode()!=200){
				return jsonresult;
			}else{
				String desKey = key.getPrivateexponent().substring(0, 32);
				String decString = DESUtil.decrypt((String)jsonresult.getData(), desKey);
				orglist = JsonUtil.toObject(decString, OrganMsg[].class);
			}
			
			
			if(orglist==null || orglist.length==0){
				return jsonResult(-1, "获取用户信息失败！");
			}
			syncService.syncAllOrg(orglist);
		}catch(Exception  e){  
            e.printStackTrace();
            return jsonResult(-1, "同步处理异常!");
        }
		return jsonResult(200, "OK");
	}
	
	/**
	 * 全组织同步
	 * @return
	 */
	@RequestMapping(value="/syncAllOrg",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult syncAllOrg2(@RequestParam(value = "requestTime", required = true) String requestTime,
								  @RequestParam(value = "authcode", required = true) String authcode,
								  @RequestParam(value = "organmsgstr" , required = true) String organmsgstr,
								  @RequestParam(value = "appid" , required = true)String appId) {
		try{
			//生成认证信息
			if(!authcode.equals(getAuthcode(requestTime , appId))){
				return jsonResult(-1, "认证失败！");
			}
			SSOKey key = this.getSSOkey();
			if(key == null){
				return jsonResult(-1, "获取秘钥信息失败!");
			}
			//获取全组织信息
			OrganMsg[] orglist = null;
			if(organmsgstr!=null && !organmsgstr.equals("")){
				String desKey = key.getPrivateexponent().substring(0, 32);
				organmsgstr = DESUtil.decrypt(organmsgstr, desKey);
				orglist = JsonUtil.toObject(organmsgstr, OrganMsg[].class);
			}
			if(orglist==null || orglist.length==0){
				return jsonResult(-1, "解析组织信息失败！");
			}
			syncService.syncAllOrg(orglist);
		}catch(Exception  e){
            e.printStackTrace();
            return jsonResult(-1, "同步处理异常!");
        }
		return jsonResult(200, "OK");
	}
	
	/**
	 * 全角色同步
	 * @return
	 */
	@RequestMapping(value="/syncAllRole",method=RequestMethod.GET)
	@ResponseBody
	public JsonResult syncAllRole(@RequestParam(value = "appid" , required = true)String appId) {
		try{
			//生成认证信息
			String requestTime = getSysdate();
			String authcode = getAuthcode(requestTime , appId);
			JsonResult jsonresult = null;
			if(authcode==null || authcode.equals("")){
				return jsonResult(-1, "生成认证信息失败！");
			}
			SSOKey key = this.getSSOkey();
			if(key == null){
				return jsonResult(-1, "获取秘钥信息失败!");
			}
			//获取全用户信息
			String getAllRole = SystemConfig.getProperty("tyrz.Url")+SystemConfig.getProperty("tyrz.sync.getAllRole");
			RoleMsg[] rolelist = null;
			
			String result = HttpUtil.HttpGet(getAllRole + "?appId="+this.appId
													 + "&requestTime=" + requestTime
													 + "&authcode=" + authcode);
			if(result!=null && !result.equals("")){
				jsonresult = JsonUtil.toObject(result, JsonResult.class);
			}
			if(jsonresult.getCode()!=200){
				return jsonresult;
			}else{
				String desKey = key.getPrivateexponent().substring(0, 32);
				String decString = DESUtil.decrypt((String)jsonresult.getData(), desKey);
				rolelist = JsonUtil.toObject(decString, RoleMsg[].class);
			}
			
			if(rolelist.length==0){
				return jsonResult(-1, "获取角色信息失败！");
			}
			syncService.syncAllRole(rolelist);
		}catch(Exception  e){  
            e.printStackTrace();
            return jsonResult(-1, "同步处理异常!");
        } 
		return jsonResult(200, "OK");
	}

	/**
	 * 全角色同步
	 * @return
	 */
	@RequestMapping(value="/syncAllRole",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult syncAllRole2(@RequestParam(value = "requestTime", required = true) String requestTime,
								   @RequestParam(value = "authcode", required = true) String authcode,
								   @RequestParam(value = "rolemsgstr", required = true) String rolemsgstr,
								   @RequestParam(value = "appid" , required = true)String appId) {
		try{
			//生成认证信息
			if(!authcode.equals(getAuthcode(requestTime , appId))){
				return jsonResult(-1, "认证失败！");
			}
			SSOKey key = this.getSSOkey();
			if(key == null){
				return jsonResult(-1, "获取秘钥信息失败!");
			}
			JsonResult jsonresult = null;
			//获取全角色信息
			RoleMsg[] rolelist = null;
			if(rolemsgstr!=null && !rolemsgstr.equals("")){
				String desKey = key.getPrivateexponent().substring(0, 32);
				rolemsgstr = DESUtil.decrypt(rolemsgstr, desKey);
				rolelist = JsonUtil.toObject(rolemsgstr, RoleMsg[].class);
			}
			if(rolelist==null || rolelist.length==0){
				return jsonResult(-1, "解析角色信息失败！");
			}
			syncService.syncAllRole(rolelist);
		}catch(Exception  e){
            e.printStackTrace();
            return jsonResult(-1, "同步处理异常!");
        }
		return jsonResult(200, "OK");
	}
	
	/**
	 * 获取同步日志，按日志内容进行同步
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/syncByLog",method=RequestMethod.GET)
	@ResponseBody
	public JsonResult syncByLog(@RequestParam(value = "starttime", required = true) String starttime,
								@RequestParam(value = "endtime", required = true) String endtime , 
								@RequestParam(value = "appid" , required = true)String appId) {
		String returnmsg = "";
		try{
			//生成认证信息
			String requestTime = getSysdate();
			String authcode = getAuthcode(requestTime , appId);
			JsonResult jsonresult = null;
			if(authcode==null || authcode.equals("")){
				return jsonResult(-1, "生成认证信息失败！");
			}
			SSOKey key = this.getSSOkey();
			if(key == null){
				return jsonResult(-1, "获取秘钥信息失败!");
			}
			//获取全用户信息
			String getSynclog = SystemConfig.getProperty("tyrz.Url")+SystemConfig.getProperty("tyrz.sync.getSynclog");
			Synclog[] syncloglist =null;
			String result = HttpUtil.HttpGet(getSynclog + "?appId="+this.appId
													 + "&requestTime=" + requestTime
													 + "&authcode=" + authcode
													 + "&starttime=" + starttime
													 + "&endtime=" + endtime);
			if(result!=null && !result.equals("")){
				jsonresult = JsonUtil.toObject(result, JsonResult.class);
			}
			if(jsonresult.getCode()!=200){
				return jsonresult;
			}else{
				String desKey = key.getPrivateexponent().substring(0, 32);
				String decString = DESUtil.decrypt((String)jsonresult.getData(), desKey);
				syncloglist = JsonUtil.toObject(decString, Synclog[].class);
			}
			
			if(syncloglist==null || syncloglist.length==0){
				return jsonResult(0, "无更新日志！");
			}
			returnmsg = "更新" +syncloglist.length+ "条";
			for(Synclog synclog : syncloglist){
				String syncTable = synclog.getSyncTable();
				String syncType = synclog.getSyncType();
				String syncId = synclog.getSyncId();
				if(syncTable.equals("User")){
					if(syncType.equals("delete")){
						syncService.deleteUser(syncId);
					}else{
						JsonResult json= this.syncUser(syncId , appId);
						if(json.getCode()!=200){
							returnmsg = returnmsg + " | 更新用户"+syncId+"失败!";
						}
					}
				}
				if(syncTable.equals("Organ")){
					if(syncType.equals("delete")){
						syncService.deleteOrgan(syncId);
					}else{
						JsonResult json= this.syncOrg(syncId , appId);
						if(json.getCode()!=200){
							returnmsg = returnmsg + " | 更新组织"+syncId+"失败!";
						}
					}
				}
				if(syncTable.equals("Role")){
					if(syncType.equals("delete")){
						syncService.deleteRole(syncId);
					}else{
						JsonResult json= this.syncRole(syncId , appId);
						if(json.getCode()!=200){
							returnmsg = returnmsg + " | 更新角色"+syncId+"失败!";
						}
					}
				}
			}
		}catch(Exception  e){  
            e.printStackTrace();
            return jsonResult(-1, "同步处理异常!");
        } 
		return jsonResult(200, returnmsg);
	}

	/**
	 * 单用户同步
	 * @return
	 */
	@RequestMapping(value="/syncUser",method=RequestMethod.GET)
	@ResponseBody
	public JsonResult syncUser(@RequestParam(value = "username", required = true) String username,@RequestParam(value = "appid" , required = true)String appid) {
		try{
			//生成认证信息
			String requestTime = getSysdate();
			String authcode = getAuthcode(requestTime , appid);
			JsonResult jsonresult = null;
			if(authcode==null || authcode.equals("")){
				return jsonResult(-1, "生成认证信息失败！");
			}
			SSOKey key = this.getSSOkey();
			if(key == null){
				return jsonResult(-1, "获取秘钥信息失败!");
			}
			//获取全用户信息
			String getUser = SystemConfig.getProperty("tyrz.Url")+SystemConfig.getProperty("tyrz.sync.getUser");
			UserMsg userMsg= null;
			String result = HttpUtil.HttpGet(getUser + "?appId="+this.appId
												  + "&requestTime=" + requestTime
												  + "&authcode=" + authcode
												  + "&username=" + username);
			if(result!=null && !result.equals("")){
				jsonresult = JsonUtil.toObject(result, JsonResult.class);
			}
			if(jsonresult.getCode()!=200){
				return jsonresult;
			}else{
				String desKey = key.getPrivateexponent().substring(0, 32);
				String decString = DESUtil.decrypt((String)jsonresult.getData(), desKey);
				userMsg = JsonUtil.toObject(decString, UserMsg.class);
			}
			
			if(userMsg==null){
				return jsonResult(-1, "获取用户信息失败！");
			}
			syncService.syncUser(userMsg);
		}catch(Exception  e){  
            e.printStackTrace();
            return jsonResult(-1, "同步处理异常!");
        }
		return jsonResult(200, "OK");
	}

	/**
	 * 单用户同步
	 * @return
	 */
	@RequestMapping(value="/syncUser",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult syncUser2(@RequestParam(value = "requestTime", required = true) String requestTime,
							    @RequestParam(value = "authcode", required = true) String authcode,
							    @RequestParam(value = "syncType", required = true) String syncType,
							    @RequestParam(value = "usermsgstr", required = true) String usermsgstr,
							    @RequestParam(value = "appid" , required = true)String appId) {
		try{
			//生成认证信息
			if(!authcode.equals(getAuthcode(requestTime , appId))){
				return jsonResult(-1, "认证失败！");
			}
			SSOKey key = this.getSSOkey();
			if(key == null){
				return jsonResult(-1, "获取秘钥信息失败!");
			}
			//获取用户信息
			UserMsg userMsg= null;
			if(usermsgstr!=null && !usermsgstr.equals("")){
				String desKey = key.getPrivateexponent().substring(0, 32);
				usermsgstr = DESUtil.decrypt(usermsgstr, desKey);
				userMsg = JsonUtil.toObject(usermsgstr, UserMsg.class);
			}
			if(userMsg==null){
				return jsonResult(-1, "获取用户信息失败！");
			}
			if(syncType.equals("1")){
				syncService.syncUser(userMsg);
			}else if(syncType.equals("2")){
				syncService.deleteUser(userMsg.getUsername());
			}
		}catch(Exception  e){  
            e.printStackTrace();
            return jsonResult(-1, "同步处理异常!");
        }
		return jsonResult(200, "OK");
	}
	
	/**
	 * 单组织同步
	 * @return
	 */
	@RequestMapping(value="/syncOrg",method=RequestMethod.GET)
	@ResponseBody
	public JsonResult syncOrg(@RequestParam(value = "orgId", required = true) String orgId , @RequestParam(value = "appid" , required = true)String appId) {
		try{
			//生成认证信息
			String requestTime = getSysdate();
			String authcode = getAuthcode(requestTime , appId);
			JsonResult jsonresult = null;
			if(authcode==null || authcode.equals("")){
				return jsonResult(-1, "生成认证信息失败！");
			}
			SSOKey key = this.getSSOkey();
			if(key == null){
				return jsonResult(-1, "获取秘钥信息失败!");
			}
			//获取全用户信息
			String getOrg = SystemConfig.getProperty("tyrz.Url")+SystemConfig.getProperty("tyrz.sync.getOrg");
			OrganMsg organMsg= null;
			String result = HttpUtil.HttpGet(getOrg + "?appId="+this.appId
												 + "&requestTime=" + requestTime
												 + "&authcode=" + authcode
												 + "&orgId=" + orgId);
			if(result!=null && !result.equals("")){
				jsonresult = JsonUtil.toObject(result, JsonResult.class);
			}
			if(jsonresult.getCode()!=200){
				return jsonresult;
			}else{
				String desKey = key.getPrivateexponent().substring(0, 32);
				String decString = DESUtil.decrypt((String)jsonresult.getData(), desKey);
				organMsg = JsonUtil.toObject(decString, OrganMsg.class);
			}
			
			if(organMsg==null){
				return jsonResult(-1, "获取组织信息失败！");
			}
			syncService.syncOrgan(organMsg);
		}catch(Exception  e){  
            e.printStackTrace();
            return jsonResult(-1, "同步处理异常!");
        }
		return jsonResult(200, "OK");
	}

	/**
	 * 单组织同步
	 * @return
	 */
	@RequestMapping(value="/syncOrg",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult syncOrg2(@RequestParam(value = "requestTime", required = true) String requestTime,
							   @RequestParam(value = "authcode", required = true) String authcode,
							   @RequestParam(value = "syncType", required = true) String syncType,
							   @RequestParam(value = "organmsgstr", required = true) String organmsgstr , 
							   @RequestParam(value = "appid" , required = true)String appId) {
		try{
			//生成认证信息
			if(!authcode.equals(getAuthcode(requestTime , appId))){
				return jsonResult(-1, "认证失败！");
			}
			SSOKey key = this.getSSOkey();
			if(key == null){
				return jsonResult(-1, "获取秘钥信息失败!");
			}
			//获取组织信息
			OrganMsg organMsg= null;
			if(organmsgstr!=null && !organmsgstr.equals("")){
				String desKey = key.getPrivateexponent().substring(0, 32);
				organmsgstr = DESUtil.decrypt(organmsgstr, desKey);
				organMsg = JsonUtil.toObject(organmsgstr, OrganMsg.class);
			}
			if(organMsg==null){
				return jsonResult(-1, "获取组织信息失败！");
			}
			if(syncType.equals("1")){
				syncService.syncOrgan(organMsg);
			}else if(syncType.equals("2")){
				syncService.deleteOrgan(organMsg.getOrgId());
			}
		}catch(Exception  e){  
            e.printStackTrace();
            return jsonResult(-1, "同步处理异常!");
        }
		return jsonResult(200, "OK");
	}
	
	/**
	 * 单角色同步
	 * @return
	 */
	@RequestMapping(value="/syncRole",method=RequestMethod.GET)
	@ResponseBody
	public JsonResult syncRole(@RequestParam(value = "rolename", required = true) String rolename , @RequestParam(value = "appid" , required = true)String appId) {
		try{
			//生成认证信息
			String requestTime = getSysdate();
			String authcode = getAuthcode(requestTime , appId);
			JsonResult jsonresult = null;
			if(authcode==null || authcode.equals("")){
				return jsonResult(-1, "生成认证信息失败！");
			}
			SSOKey key = this.getSSOkey();
			if(key == null){
				return jsonResult(-1, "获取秘钥信息失败!");
			}
			//获取全用户信息
			String getRole = SystemConfig.getProperty("tyrz.Url")+SystemConfig.getProperty("tyrz.sync.getRole");
			RoleMsg roleMsg= null;
			String result = HttpUtil.HttpGet(getRole + "?appId="+this.appId
												  + "&requestTime=" + requestTime
												  + "&authcode=" + authcode
												  + "&rolename=" + rolename);
			if(result!=null && !result.equals("")){
				jsonresult = JsonUtil.toObject(result, JsonResult.class);
			}
			if(jsonresult.getCode()!=200){
				return jsonresult;
			}else{
				String desKey = key.getPrivateexponent().substring(0, 32);
				String decString = DESUtil.decrypt((String)jsonresult.getData(), desKey);
				roleMsg = JsonUtil.toObject(decString, RoleMsg.class);
			}
			
			if(roleMsg==null){
				return jsonResult(-1, "获取组织信息失败！");
			}
			syncService.syncRole(roleMsg);
		}catch(Exception  e){  
            e.printStackTrace();
            return jsonResult(-1, "同步处理异常!");
        }
		return jsonResult(200, "OK");
	}
	
	/**
	 * 单角色同步
	 * @return
	 */
	@RequestMapping(value="/syncRole",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult syncRole2(@RequestParam(value = "requestTime", required = true) String requestTime,
							    @RequestParam(value = "authcode", required = true) String authcode,
							    @RequestParam(value = "syncType", required = true) String syncType,
							    @RequestParam(value = "rolemsgstr", required = true) String rolemsgstr ,
							    @RequestParam(value = "appid" , required = true)String appId) {
		try{
			//生成认证信息
			if(!authcode.equals(getAuthcode(requestTime , appId))){
				return jsonResult(-1, "认证失败！");
			}
			SSOKey key = this.getSSOkey();
			if(key == null){
				return jsonResult(-1, "获取秘钥信息失败!");
			}
			//获取角色信息
			RoleMsg roleMsg= null;
			if(rolemsgstr!=null && !rolemsgstr.equals("")){
				String desKey = key.getPrivateexponent().substring(0, 32);
				rolemsgstr = DESUtil.decrypt(rolemsgstr, desKey);
				roleMsg = JsonUtil.toObject(rolemsgstr, RoleMsg.class);
			}
			if(roleMsg==null){
				return jsonResult(-1, "获取角色信息失败！");
			}
			if(syncType.equals("1")){
				syncService.syncRole(roleMsg);
			}else if(syncType.equals("2")){
				syncService.deleteRole(roleMsg.getRoleName());
			}
		}catch(Exception  e){  
            e.printStackTrace();
            return jsonResult(-1, "同步处理异常!");
        }
		return jsonResult(200, "OK");
	}

	
	private String getUrl(HttpServletRequest httprequest){
		StringBuffer url = httprequest.getRequestURL();
		return url.substring(0,
			   url.indexOf(httprequest.getContextPath())
			   +httprequest.getContextPath().length()
			   );
		
	}
	
	public String getSysdate(){
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
		return dateFormat.format(new Date());
	}
	
	/**
	 * 生成接口认证串
	 * @param requestTime
	 * @return
	 */
	public String getAuthcode(String requestTime , String appid){
		String authcode =null;
		try{
			getSession().getServletContext().setAttribute("appId", appid);
			this.appId = appid;
			SSOKey key = this.getSSOkey();
			//生成认证信息
			PublicKey newpublickey = rsaUtil.getPublicKey(key.getModulus(), key.getPublicexponent());
			byte[] checkcodebyte = null;
			checkcodebyte =rsaUtil.encrypt(newpublickey,(appId+requestTime).getBytes());
			authcode = Md5Util.toMd5(Base64.encodeBase64String(checkcodebyte));
		}catch(Exception  e){  
            e.printStackTrace();
        } 
		return authcode;
	}
	
	/**
	 * 获取私钥，用于数据解密
	 * @param appid
	 * @return
	 */
	private SSOKey getSSOkey(){
		Object keyobj = getSession().getAttribute("privatekey");
		SSOKey key = null;
		if(keyobj == null){
			//调用统一认证接口，获取秘钥信息
			String getPrivateKey = SystemConfig.getProperty("tyrz.Url")+SystemConfig.getProperty("tyrz.getKey");
			String result = HttpUtil.HttpGet(getPrivateKey + "?appId="+appId.toString());
			if(result!=null && !result.equals("")){
				key = JsonUtil.toObject(result, SSOKey.class);
				getSession().setAttribute("privatekey",key);
			}
		}else{
			key = (SSOKey)keyobj;
		}
		return key;
	}
}
