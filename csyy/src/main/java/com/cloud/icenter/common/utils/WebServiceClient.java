package com.cloud.icenter.common.utils;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.dynamic.DynamicClientFactory;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.log4j.Logger;

/***
 * 
 * @ClassName: WebserviceClient
 * @Description: TODO(这里用一句话描述这个类的作用) Webservice 动态客户端
 * @author Chen_JIAN
 * @date 2015年9月11日 下午11:16:13
 *
 */
public class WebServiceClient {

	private Logger log = Logger.getLogger(WebServiceClient.class);
	private DynamicClientFactory objDynamicClientFactory = null;
	// private final String URL=SystemConfig.getProperty("hibernate.dialect");
	private Client client = null;

	public WebServiceClient connect(String url) {
		log.info("webService WSDL请求地址为：" + url);
		this.objDynamicClientFactory = JaxWsDynamicClientFactory.newInstance();
		this.client = objDynamicClientFactory.createClient(url);
		return this;

	}

	public Object send(String methodName, Object[] pams) {
		try {
			return this.client.invoke(methodName, pams)[0];
		} catch (Exception e) {
			e.printStackTrace();
			log.error("调用webService服务出现异常！\n执行的服务方法名为[" + methodName + "]\n传人参数为[" + pams.toString() + "]");
		}
		return null;
	}

	public static String getParameter(String data, String para) {
		String result = "";
		StringBuffer reStr = new StringBuffer();
		reStr.append("<");
		reStr.append(para);
		reStr.append(">");
		reStr.append("(.*?)");
		reStr.append("</");
		reStr.append(para);
		reStr.append(">");
		Pattern pattern = Pattern.compile(reStr.toString());
		Matcher matcher = pattern.matcher(data);
		if (matcher.find()) {
			result = matcher.group(1);
		}

		return result;
	}

	public static void main(String[] args) throws IOException, Exception {

		String url = "http://10.15.81.1:8099/BSSP/services/GetMsgFromMQService?wsdl";
		String method = "getMsgByMQ";
		String mqname = "SJZH";
		WebServiceClient client = new WebServiceClient();
		Object str = client.connect(url).send(method, new Object[] { mqname });
		System.out.println(str);

	}

}
