package com.cloud.icenter.yyzx.common.util.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.google.common.collect.Maps;

public class HttpUtil {

	/**
	 * ZIP文件
	 */
	public static final String HTTP_MIME_ZIP = "application/zip";
	/**
	 * Excel文件
	 */
	public static final String HTTP_MIME_XLS = "application/vnd.ms-excel";
	/**
	 * 二进制输出，支持所有文件
	 */
	public static final String HTTP_MIME_ALL = "application/octet-stream";

	public static Map<String, Object> httpRequestParamaterWrap(
			HttpServletRequest request) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		Enumeration<String> enumeration = request.getParameterNames();
		while (enumeration.hasMoreElements()) {
			String key = enumeration.nextElement();
			String value = request.getParameter(key);
			if (null != value && (value = value.trim()).length() > 0) {
				try {
					value = URLDecoder.decode(value, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				result.put(key, value);
			}
		}
		return result;
	}

	/**
	 * 根据请求浏览器类型(Chrome、Firefox、IE)获取下载文件名
	 * 
	 * @param request
	 *            请求HttpServletRequest
	 * @param oldName
	 *            文件名
	 * @return
	 */
	public static String getNewName(HttpServletRequest request, String oldName) {
		String agent = request.getHeader("USER-AGENT");
		String result = "";
		try {
			if (null != agent && -1 != agent.indexOf("Chrome")) { // Chrome
				result = new String(oldName.getBytes("UTF-8"), "iso-8859-1");
			} else if (null != agent && -1 != agent.indexOf("Firefox")) { // Firefox
				result = "=?UTF-8?B?"
						+ (new String(
								org.apache.commons.codec.binary.Base64
										.encodeBase64(oldName.getBytes("UTF-8"))))
						+ "?=";
			} else {// IE7++
				result = java.net.URLEncoder.encode(oldName, "UTF-8");
				result = StringUtils.replace(result, "+", "%20");
			}
		} catch (UnsupportedEncodingException e) {
			result = oldName;
		}
		return result;
	}

	/**
	 * 下载文件到客户端
	 * 
	 * @Title sendFile
	 * @Description TODO
	 * @param request
	 * @param response
	 * @param fileName
	 *            文件路径
	 * @param downLoadName
	 *            下载文件名
	 * @param contentType
	 *            文件类型
	 * @date 2015年11月19日-上午9:34:25
	 * @update
	 *
	 */
	public static void sendFile(HttpServletRequest request,
			HttpServletResponse response, String fileName, String downLoadName,
			String contentType) {
		File file = new File(fileName);
		if (!file.exists()) {
			return;
		}
		InputStream in = null;
		try {
			in = new FileInputStream(file);
			sendFile(request, response, in, downLoadName, contentType);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (null != in) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 下载文件到客户端
	 * 
	 * @Title sendFile
	 * @Description TODO
	 * @param request
	 * @param response
	 * @param in
	 *            文件输入流
	 * @param downLoadName
	 *            下载文件名
	 * @param contentType
	 *            类型
	 * @date 2015年11月19日-上午9:35:13
	 * @update
	 *
	 */
	public static void sendFile(HttpServletRequest request,
			HttpServletResponse response, InputStream in, String downLoadName,
			String contentType) {
		response.setContentType(contentType);
		downLoadName = HttpUtil.getNewName(request, downLoadName);
		OutputStream out = null;
		try {
			int fileSize = 0;
			fileSize = in.available();
			response.setHeader("content-disposition", "attachment;filename=\""
					+ downLoadName + "\";size=" + fileSize);
			out = response.getOutputStream();
			byte[] b = new byte[1024];
			int len = 0;
			while ((len = in.read(b)) != -1) {
				out.write(b, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != out) {
					out.flush();
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
