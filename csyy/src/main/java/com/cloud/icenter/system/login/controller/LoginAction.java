package com.cloud.icenter.system.login.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cloud.icenter.base.controller.BaseAction;
import com.cloud.icenter.common.constants.Constants;
import com.cloud.icenter.common.utils.CacheUtil;
import com.cloud.icenter.common.utils.DateUtil;
import com.cloud.icenter.common.utils.Encoding;
import com.cloud.icenter.common.utils.Md5Util;
import com.cloud.icenter.common.utils.RSACoder;
import com.cloud.icenter.common.utils.RSAUtil;
import com.cloud.icenter.common.utils.RandomValidateCode;
import com.cloud.icenter.common.utils.StringUtil;
import com.cloud.icenter.common.utils.SystemConfig;
import com.cloud.icenter.system.onlineuser.pojo.OnlineUser;
import com.cloud.icenter.system.onlineuser.service.OnlineUserService;
import com.cloud.icenter.system.organ.pojo.Organ;
import com.cloud.icenter.system.organ.service.OrganService;
import com.cloud.icenter.system.role.pojo.Role;
import com.cloud.icenter.system.role.service.RoleService;
import com.cloud.icenter.system.user.pojo.User;
import com.cloud.icenter.system.user.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 登录管理
 * 
 * @author zhangle
 */
@Controller
public class LoginAction extends BaseAction {

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

	private static String LOGIN_PAGE = "system/login";

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String execute() {
		return LOGIN_PAGE;
	}

	private static String LOGIN_CHUPING_PAGE = "system/cp";

	@RequestMapping(value = "/cp", method = RequestMethod.GET)
	public String cp() {
		return LOGIN_CHUPING_PAGE;
	}

	@RequestMapping(value = "/getPublicKey", method = RequestMethod.POST)
	public void getPublicKey() throws Exception {
		printJsonResult(200, rSAUtil.generateKeyPair());
	}

	@RequestMapping(value = "/ValidateCode", method = RequestMethod.GET)
	public void ValidateCode() throws IOException {
		HttpServletResponse response = getResponse();
		response.setContentType("image/jpeg");// 设置相应类型,告诉浏览器输出的内容为图片
		response.setHeader("Pragma", "No-cache");// 设置响应头信息，告诉浏览器不要缓存此内容
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expire", 0);
		RandomValidateCode randomValidateCode = new RandomValidateCode();
		try {
			randomValidateCode.getRandcode(getRequest(), response);// 输出图片方法
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/login/{username}", method = RequestMethod.GET)
	public ModelAndView logins(@PathVariable String username) {

		// onlineUserService.delete(getSession().getId());
		// 根据用户名获取用户对象,如果不能获取用户对象,那么返回登录页面
		// User user = userService.getUserByName(username);
		// 登录成功操作
		// loginSuccess(user);
		return new ModelAndView("redirect:/admin");
		// printJsonResult(200, getRequest().getContextPath() + "/admin");
	}

	@RequestMapping(value = "/csv", method = RequestMethod.POST)
	public void downloadCSV() throws UnsupportedEncodingException {
		try {
			getRequest().setCharacterEncoding("UTF-8");
			getResponse().setCharacterEncoding("UTF-8");
			getResponse().setContentType("application/csv;charset=UTF-8");
			getResponse().setHeader(
					"Content-Disposition",
					"attachment; filename=\""
							+ DateUtil.format(new Date(), "yyyyMMddhhmmss")
							+ ".csv\"");
			getResponse().getWriter().print(getRequest().getParameter("data"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 登录操作
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void login(
			@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "password", required = true) String password) {

		// 根据用户名获取用户对象,如果不能获取用户对象,那么返回登录页面
		User user = userService.getUserByName(username);
		if (user == null) {
			printJsonResult(-1, "用户名或密码错误,登录失败!");
			return;
		}

		// 检查输入的密码是否正确,如果不正确,那么返回登录页面
		String _pwd = Md5Util.makePassword(password, user.getSalt());
		if (!user.getPassword().equals(_pwd)) {
			printJsonResult(-1, "用户名或密码错误,登录失败!");
			return;
		}

		if (user.getStatus() == User.STATUS_LOCKED) {
			printJsonResult(-1, "用户被锁定,不能登录,请联系系统管理员!");
			return;
		}

		// 登录成功操作
		loginSuccess(user);
		printJsonResult(200, getRequest().getContextPath() + "/admin");
	}

	/**
	 * 登录操作,需要在webxml中配置排除验证
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/RSAlogin", method = RequestMethod.POST)
	public void RSAlogin(String username, String password, String pk,
			String code) {
		try {
			if (Constants.ENABLE_VERIFY_CODE) {
				String validateCode = getRequest().getSession()
						.getAttribute(Constants.VERIFY_CODE_SESSION_KEY)
						.toString();

				if (!validateCode.equals(code.toUpperCase())) {
					printJsonResult(-1, "验证码错误,登录失败!");
					return;
				}
			}
			// 根据用户名获取用户对象,如果不能获取用户对象,那么返回登录页面

			username = rSAUtil.decryptString(pk, username);
			password = rSAUtil.decryptString(pk, password);

			User user = userService.getUserByName(username);
			if (user == null) {
				printJsonResult(-1, "用户名或密码错误,登录失败!");
				return;
			}

			// 检查输入的密码是否正确,如果不正确,那么返回登录页面
			String _pwd = Md5Util.makePassword(password, user.getSalt());
			if (!user.getPassword().equals(_pwd)) {
				printJsonResult(-1, "用户名或密码错误,登录失败!");
				return;
			}

			if (user.getStatus() == User.STATUS_LOCKED) {
				printJsonResult(-1, "用户被锁定,不能登录,请联系系统管理员!");
				return;
			}
			onlineUserService.delete(getSession().getId());
			// 登录成功操作
			loginSuccess(user);
			printJsonResult(200, getRequest().getContextPath() + "/index");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("登录出现错误!", e);
			throw new RuntimeException(e);
		} finally {
			rSAUtil.deletekeyPair(pk);
		}
	}
	
	
	/**
	 * 登录操作,需要在webxml中配置排除验证
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/RSAloginCp", method = RequestMethod.POST)
	public void RSAloginCp(String username, String password, String pk,
			String code) {
		try {
			if (Constants.ENABLE_VERIFY_CODE) {
				String validateCode = getRequest().getSession()
						.getAttribute(Constants.VERIFY_CODE_SESSION_KEY)
						.toString();

				if (!validateCode.equals(code.toUpperCase())) {
					printJsonResult(-1, "验证码错误,登录失败!");
					return;
				}
			}
			// 根据用户名获取用户对象,如果不能获取用户对象,那么返回登录页面

			username = rSAUtil.decryptString(pk, username);
			password = rSAUtil.decryptString(pk, password);

			User user = userService.getUserByName(username);
			if (user == null) {
				printJsonResult(-1, "用户名或密码错误,登录失败!");
				return;
			}

			// 检查输入的密码是否正确,如果不正确,那么返回登录页面
			String _pwd = Md5Util.makePassword(password, user.getSalt());
			if (!user.getPassword().equals(_pwd)) {
				printJsonResult(-1, "用户名或密码错误,登录失败!");
				return;
			}

			if (user.getStatus() == User.STATUS_LOCKED) {
				printJsonResult(-1, "用户被锁定,不能登录,请联系系统管理员!");
				return;
			}
			onlineUserService.delete(getSession().getId());
			// 登录成功操作
			loginSuccess(user);
			printJsonResult(200, getRequest().getContextPath() + "/indexcp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("登录出现错误!", e);
			throw new RuntimeException(e);
		} finally {
			rSAUtil.deletekeyPair(pk);
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
			Organ emp = organService.getMainEmployee(user.getUserId());
			if (emp != null) {
				List<Organ> emps = organService.getOrgansByUserId(user
						.getUserId());
				Organ dept = organService.getMainDepartment(user.getUserId());
				List<Organ> parents = organService.getParents(emp.getOrgId());
				onlineUser.setEmployee(emp);
				onlineUser.setEmployees(emps);
				onlineUser.setDepartment(dept);
				onlineUser.setParents(parents);
			}

			onlineUserService.add(onlineUser);
		} catch (Exception e) {
			logger.error("登录出现错误!", e);
			throw new RuntimeException(e);
		}
	}

	/**
	 * 从统一认证接收公钥
	 * 
	 * @param publickeyId
	 * @param secritUid
	 * @return
	 */
	@RequestMapping(value = "/acceptPublicKey")
	public void acceptPublicKey(String code) {
		if (StringUtils.isBlank(code))
			printText("FAILURE#param[code] is error");
		else
			printText("SUCCESS#" + CacheUtil.putPublickey(code)); // 将公钥放入缓存
	}

	/**
	 * 从统一认证登录
	 * 
	 * @param publickeyId
	 * @param secritUid
	 * @return
	 */
	@RequestMapping(value = "/ssologin")
	public String SSOCheckLoign(
			@RequestParam(value = "code") String publickeyId,
			@RequestParam(value = "param") String secritUid) {
		// ModelAndView view = new ModelAndView("forward:/sso/TransitProxy");
		Object publickey = CacheUtil.getPublickey(publickeyId);
		System.out.println(publickey);
		if (publickey != null && !"".equals(publickey)) {
			byte[] decodedData = null;
			try {
				String newKey = Encoding.decoding(String.valueOf(publickey));
				decodedData = RSACoder.decryptByPublicKey(
						new sun.misc.BASE64Decoder().decodeBuffer(secritUid),
						newKey);
			} catch (Exception e) {
				throw new RuntimeException("统一认证用户信息密文解密出现异常！["
						+ e.getMessage() + "]");
			}
			String userKey = new String(decodedData);
			logger.info("解密后账号: " + userKey);
			User user = userService.getUserByName(userKey);
			// 根据用户id校验用户信息，如果用户信息匹配失败，那就跳转到错误提示页面
			if (user == null) {
				throw new RuntimeException("账号为[" + userKey
						+ "]的用户没有同步到数据管理平台!");
			}
			onlineUserService.delete(getSession().getId());
			// 登录成功操作
			loginSuccess(user);
			return redirect("/admin");
			// printJsonResult(200, getRequest().getContextPath() + "/admin");
		} else {
			throw new RuntimeException("公钥不存在！");
		}
	}

	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public void error() {
		printJsonResult(-1, "帐号没有同步数据管理平台!");
	}

	/**
	 * 注销用户
	 * 
	 * @return
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		onlineUserService.delete(getSession().getId());
		return redirect("/login");
	}

	/**
	 * 注销用户
	 * 
	 * @return
	 */
	@RequestMapping(value = "/timeout", method = RequestMethod.GET)
	public String timeout() {
		setAttribute("syncLogin", SystemConfig.getProperty("sync.login"));
		return "system/login";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String indexs() {
		// setAttribute("syncLogin", SystemConfig.getProperty("sync.login"));
		OnlineUser loginUser = getLoginUser();
		setAttribute("loginUser", loginUser);
		return "index";
	}
	
	@RequestMapping(value = "/indexcp", method = RequestMethod.GET)
	public String indexsCp() {
		// setAttribute("syncLogin", SystemConfig.getProperty("sync.login"));
		OnlineUser loginUser = getLoginUser();
		setAttribute("loginUser", loginUser);
		return "navigation/navigation";
	}
}
