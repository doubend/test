package com.cloud.icenter.common.utils;
/**
 * http请求状态码
 * @author chenhu
 * 2015-12-22
 */
public class HttpStatusCode {
 	//错误请求 服务器不理解请求的语法
	public static int code400 = 400;
	//成功
	public static int code200 = 200;
	//（未授权） 请求要求身份验证。 对于需要登录的网页，服务器可能返回此响应。
	public static int code401 = 401;
	//（禁止） 服务器拒绝请求。
	public static int code403 = 403;
	//（未找到） 服务器找不到请求的网页。
	public static int code404 = 404;
	//405 （方法禁用） 禁用请求中指定的方法
	public static int code405 = 405;
	//（不接受） 无法使用请求的内容特性响应请求的网页。
	public static int code406 = 406;
	// （请求超时） 服务器等候请求时发生超时。
	public static int code408 = 408;
	//（服务器内部错误） 服务器遇到错误，无法完成请求。
	public static int code500 = 500;
	//（错误网关） 服务器作为网关或代理，从上游服务器收到无效响应
	public static int code502 = 502;
	//服务不可用
	public static int code503 = 503;
	//（网关超时） 服务器作为网关或代理，但是没有及时从上游服务器收到请求。
	public static int code504 = 504;
	//（HTTP 版本不受支持） 服务器不支持请求中所用的 HTTP 协议版本
	public static int code505 = 505;
}
