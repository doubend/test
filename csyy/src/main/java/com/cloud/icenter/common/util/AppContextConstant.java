package com.cloud.icenter.common.util;

/**
 * 
* @ClassName: AppContextConstant 
* @Description: TODO(这里用一句话描述这个类的作用) 
* 系统静态变量
* @author Chen_JIAN
* @date 2015年7月2日 下午2:39:05 
*
 */
public class AppContextConstant {
	/**
	 * session user key
	 */
	public static final String USER="CUR_USER";
	
	public static final String DEPT_INFO="DEPT_INFO";
	
	public static final String USER_KEY="USER_KEY";
	
	/**
	 * 图片上传的后缀
	 */
	public static final String IMG_EXT="JPG|PNG|GIF";
	
	
	public static final String USER_TOKEN="token";
	
	public static final String LOGIN_SUCCESSFUL="successful";
	
	public static final String LOGIN_FAILURE="failure";
	
	public static final String LOGIN_FAILURE_MSG="LOGIN_FAILURE_MSG";
	
	
	
	
	
	public static final String IS_Login="login";
	
	public static final String superAdmin="superAdmin";
	
	//统一认证接收同步事件的签名安全因子 缓存里的key名称
	public static final String TYRZ_SIGN="tyyz_syn_sign";

	//统一认证登陆地址
	public static final String  TYRZ_LOGIN="tyyz_login_url";
}
