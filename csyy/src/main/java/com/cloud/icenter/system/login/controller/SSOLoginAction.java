package com.cloud.icenter.system.login.controller;

import java.nio.charset.Charset;
import java.security.interfaces.RSAPrivateKey;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cloud.icenter.base.controller.BaseAction;
import com.cloud.icenter.common.utils.HttpUtil;
import com.cloud.icenter.common.utils.JsonUtil;
import com.cloud.icenter.common.utils.RSAUtil;
import com.cloud.icenter.common.utils.SystemConfig;
import com.cloud.icenter.system.login.bean.SSOKey;
import com.cloud.icenter.system.onlineuser.pojo.OnlineUser;
import com.cloud.icenter.system.onlineuser.service.OnlineUserService;
import com.cloud.icenter.system.organ.pojo.Organ;
import com.cloud.icenter.system.organ.pojo.OrganUser;
import com.cloud.icenter.system.organ.service.OrganService;
import com.cloud.icenter.system.organ.service.OrganUserService;
import com.cloud.icenter.system.role.pojo.Role;
import com.cloud.icenter.system.role.service.RoleService;
import com.cloud.icenter.system.user.pojo.User;
import com.cloud.icenter.system.user.service.UserService;

/**
 * 统一认证管理
 * 
 * @author wuym
 */
@Controller
public class SSOLoginAction extends BaseAction {
	private static final Log logger = LogFactory.getLog(LoginAction.class);

	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private OrganService organService;
	@Autowired
	private OnlineUserService onlineUserService;
	@Autowired
	private RSAUtil rSAUtil;
	
	@Autowired
	private OrganUserService orgUserService;

	/**
	 * 统一认证登录成功后回调
	 * 
	 * @return
	 * @throws Exception
	 * by wuym
	 */
	@RequestMapping(value = "/SSOLoginSuccess", method = RequestMethod.GET)
	public void SSOLoginSuccess(@RequestParam(value = "username" )String rsausername,
								@RequestParam(value = "checkfreetime" )String rsacheckfreetime,
								@RequestParam(value = "uid" )String uid,
								@RequestParam(value = "sign" )String rsign , 
								@RequestParam(value = "appid" )String appId) {
		try {
			this.getSession().setAttribute("appId", appId);
			rsign = rsign.replace("%2B", "+");
			rsign = rsign.replace("%20", " ");
			
			rsausername = rsausername.replace("%2B", "+");
			rsausername = rsausername.replace("%20", " ");
			
			rsacheckfreetime = rsacheckfreetime.replace("%2B", "+");
			rsacheckfreetime = rsacheckfreetime.replace("%20", " ");
			//获取密钥
			SSOKey key = getSSOKey(appId);
			RSAUtil rsaUtil = new RSAUtil();
			RSAPrivateKey privateKey = RSAUtil.getPrivateKey(key.getModulus(), key.getPrivateexponent());
			//判断链接是否已经失效（3分钟内有效）
			String sign = new String(rsaUtil.decrypt(privateKey, Base64.decodeBase64(rsign)));
			Long timestamp = Long.parseLong(sign);
			String nowDate = HttpUtil.HttpGet(SystemConfig.getProperty("tyrz.Url")+"/system/appinterface/getTime");
			if(nowDate==null){
				handleException(new RuntimeException("与接入系统网络连接异常!"));
			}
			Long nd = Long.parseLong(nowDate);
			Long diff = nd - timestamp;
			Long min = diff / 1000;  //秒
			if(min > 180){
				handleException(new RuntimeException("登录连接已失效!"));
			}
			
			//解析登录名
			String username = new String(rsaUtil.decrypt(privateKey, Base64.decodeBase64(rsausername)));
			// 根据用户名获取用户对象,如果不能获取用户对象,那么返回登录页面
			User user = userService.getUserByName(username);
			if (user == null) {
				handleException(new RuntimeException("用户名本地不存在，请检查用户同步情况!"));
			}
			if (user.getStatus() == User.STATUS_LOCKED) {
				handleException(new RuntimeException("用户被锁定,不能登录,请联系系统管理员!"));
			}
			onlineUserService.delete(getSession().getId());
			// 登录成功操作
			loginSuccess(user);
			
			//设置session中用户凭证和下次验证时间
			String checkfreetime = new String(rsaUtil.decrypt(privateKey, Base64.decodeBase64(rsacheckfreetime)));
			
			//计算下次认证时间并记录到会话缓存
			Calendar nowdate = Calendar.getInstance();
			nowdate.add(Calendar.SECOND, Integer.parseInt(checkfreetime));
			Date checktime = nowdate.getTime();
			getSession().setAttribute("username", username);
			getSession().setAttribute("checkfreetime", checkfreetime);
			getSession().setAttribute("checktime", checktime);
			getSession().setAttribute("ssouid", uid);
			
			//登录成功后转到首页
			getRequest().getRequestDispatcher("/").forward(getRequest(),getResponse());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("登录出现错误!", e);
			throw new RuntimeException(e);
		}
	}

	
	/**
	 * 登录成功
	 * 
	 * @param user
	 */
	private void loginSuccess(User user) {
		// 更新用户登录时间与次数
		user.setLoginNum(user.getLoginNum() + 1);
		user.setLogonAt(new Timestamp(System.currentTimeMillis()));
		userService.updateLoginParams(user);

		// 清空密码,不保存在内存中
		user.setPassword(null);
		user.setSalt(null);

		try {
			// 创建在线用户对象
			OnlineUser onlineUser = new OnlineUser(getRequest(), user);

			// 缓存用户关联的角色
			List<Role> roles = roleService.findRoleByUserId(user.getUserId(),
					Role.STATUS_DEFAULT);
			onlineUser.setRoles(roles);

			// 缓存用户在组织机构中的关系
			// 缓存用户在组织机构中的关系
			List<OrganUser> orgUsers = orgUserService.findByUserId(null, user.getUserId());
			if(orgUsers != null && !orgUsers.isEmpty()){
				Organ emp = organService.get(orgUsers.get(0).getOrgId());
				if(emp != null){
					onlineUser.setDepartment(emp);
				}
			}
			/*Organ emp = organService.getMainEmployee(user.getUserId());
			if (emp != null) {
				List<Organ> emps = organService.getOrgansByUserId(user
						.getUserId());
				Organ dept = organService.getMainDepartment(user.getUserId());
				List<Organ> parents = organService.getParents(emp.getOrgId());
				onlineUser.setEmployee(emp);
				onlineUser.setEmployees(emps);
				onlineUser.setDepartment(dept);
				onlineUser.setParents(parents);
			}*/

			onlineUserService.add(onlineUser);
		} catch (Exception e) {
			logger.error("登录出现错误!", e);
			throw new RuntimeException(e);
		}
	}

	/**
	 * 注销用户
	 * 
	 * @return
	 */
//	@RequestMapping(value = "/logout", method = RequestMethod.GET)
//	public String logout() {
//    	String tyrzUrl = SystemConfig.getProperty("tyrz.Url");
//    	String url = tyrzUrl+SystemConfig.getProperty("tyrz.logoutUrl");
//		onlineUserService.delete(getSession().getId());
//		getSession().removeAttribute("username");
//		return redirect(url);
//	}
	
	/**
	 * 用于公钥不存在时获取公钥
	 * @return
	 */
	public SSOKey getSSOKey(String appId){
		SSOKey key = null;
		getSession().getServletContext().setAttribute("appId", appId);
		//查看服务器缓存中是否存在appId若不存在则像认证服务器获取
		/*Object appId = getSession().getServletContext().getAttribute("appId");
		if(appId==null){
			String getAppId = SystemConfig.getProperty("tyrz.Url")+SystemConfig.getProperty("tyrz.getAppId");
			appId = HttpUtil.HttpGet(getAppId+"?appUrl="+getUrl(getRequest()));
			if(appId!=null && !appId.equals("")){
				getSession().getServletContext().setAttribute("appId", appId);
			}
		}
		appId = appId.toString();*/
		//查看会话中是否存在密钥，若不存在则向认证服务器获取
		Object keyobj = getSession().getAttribute("privatekey");
		if(keyobj==null){
			String getPricateKey = SystemConfig.getProperty("tyrz.Url")+SystemConfig.getProperty("tyrz.getKey");
			String result = HttpUtil.HttpGet(getPricateKey+"?appId="+appId.toString());
			if(result!=null && !result.equals("")){
				key = JsonUtil.toObject(result, SSOKey.class);
				getSession().setAttribute("privatekey",key);
			}
		}else{
			key = (SSOKey)keyobj;
		}
		return key;
	}
	
	private String getUrl(HttpServletRequest httprequest){
		StringBuffer url = httprequest.getRequestURL();
		return url.substring(0,
			   url.indexOf(httprequest.getContextPath())
			   +httprequest.getContextPath().length()
			   );
		
	}
	
}
