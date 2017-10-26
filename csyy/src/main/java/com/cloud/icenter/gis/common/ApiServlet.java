package com.cloud.icenter.gis.common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;


/**
 * Servlet implementation class ApiServlet
 */

public class ApiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		try { 
			PrintWriter out=response.getWriter();
			out.println(getScript(request));
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private String getScript(HttpServletRequest request){
		StringBuffer script = new StringBuffer();
		JSONObject json=new JSONObject();
		String path = request.getContextPath();		
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		json.put("apiURL", basePath+"js/assets/plugins/");
		json.put("appUrl", basePath);
		
		String vecLayer=ContantsLoader.getProperty("veclayer").toString();
		json.put("vecLayer", vecLayer);	
		String vecAnnoLayer=ContantsLoader.getProperty("vecannolayer").toString();
		json.put("vecAnnoLayer", vecAnnoLayer);
		
		String ztturl=ContantsLoader.getProperty("ztturl").toString();
		json.put("ztturl",ztturl);
		
		String geoServiceUrl=ContantsLoader.getProperty("geoserviceurl").toString();
		json.put("geoServiceUrl", geoServiceUrl);
		
		script.append("var gisConfig="+json.toString()+";");
		
		script.append("document.writeln(\"<script type='text/javascript' src='"+basePath+"js/assets/plugins/arcgis/init.js'></script>\");");
		return script.toString();
		//return "";
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
