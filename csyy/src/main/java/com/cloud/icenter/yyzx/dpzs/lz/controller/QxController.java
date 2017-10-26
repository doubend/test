package com.cloud.icenter.yyzx.dpzs.lz.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.cloud.icenter.base.controller.BaseAction;

/**
 * 气象
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value="/lz/water")
public class QxController extends BaseAction{
	
	/*天气接口所申请的appkey和sign,暂时在这里写死*/
	private final static String appkey = "24535";
	private final static String sign = "b90cba64bf6191088fc8fa2b62129470";
	
	/**
	 * 立柱气象
	 * @return
	 */
	@RequestMapping(value="/toQxJsp",method=RequestMethod.GET)
	public String toQxJsp(){
		try {
			//武山县
			JSONObject wsjson = readJsonFromUrl("http://api.k780.com:88/?app=weather.future&weaid=101160906&appkey="+appkey+"&sign="+sign+"&format=json");
			setAttribute("wsjson", wsjson);
			//秦州区
			JSONObject qzjson = readJsonFromUrl("http://api.k780.com:88/?app=weather.future&weaid=101160901&appkey="+appkey+"&sign="+sign+"&format=json");
			setAttribute("qzjson", qzjson);
			//秦安县
			JSONObject qajson = readJsonFromUrl("http://api.k780.com:88/?app=weather.future&weaid=101160904&appkey="+appkey+"&sign="+sign+"&format=json");
			setAttribute("qajson", qajson);
			//清水县
			JSONObject qsjson = readJsonFromUrl("http://api.k780.com:88/?app=weather.future&weaid=101160903&appkey="+appkey+"&sign="+sign+"&format=json");
			setAttribute("qsjson", qsjson);
			//甘谷县
			JSONObject ggjson = readJsonFromUrl("http://api.k780.com:88/?app=weather.future&weaid=101160905&appkey="+appkey+"&sign="+sign+"&format=json");
			setAttribute("ggjson", ggjson);
			//张家川
			JSONObject zjcjson = readJsonFromUrl("http://api.k780.com:88/?app=weather.future&weaid=101160907&appkey="+appkey+"&sign="+sign+"&format=json");
			setAttribute("zjcjson", zjcjson);
			//麦积区
			JSONObject mjcjson = readJsonFromUrl("http://api.k780.com:88/?app=weather.future&weaid=101160908&appkey="+appkey+"&sign="+sign+"&format=json");
			setAttribute("mjcjson", mjcjson);
			
			//以下是当前天气
			//武山县
			JSONObject n_wsjson = readJsonFromUrl("http://api.k780.com:88/?app=weather.today&weaid=101160906&appkey="+appkey+"&sign="+sign+"&format=json");
			setAttribute("n_wsjson", n_wsjson);
			//秦州区
			JSONObject n_qzjson = readJsonFromUrl("http://api.k780.com:88/?app=weather.today&weaid=101160901&appkey="+appkey+"&sign="+sign+"&format=json");
			setAttribute("n_qzjson", n_qzjson);
			//秦安县
			JSONObject n_qajson = readJsonFromUrl("http://api.k780.com:88/?app=weather.today&weaid=101160904&appkey="+appkey+"&sign="+sign+"&format=json");
			setAttribute("n_qajson", n_qajson);
			//清水县
			JSONObject n_qsjson = readJsonFromUrl("http://api.k780.com:88/?app=weather.today&weaid=101160903&appkey="+appkey+"&sign="+sign+"&format=json");
			setAttribute("n_qsjson", n_qsjson);
			//甘谷县
			JSONObject n_ggjson = readJsonFromUrl("http://api.k780.com:88/?app=weather.today&weaid=101160905&appkey="+appkey+"&sign="+sign+"&format=json");
			setAttribute("n_ggjson", n_ggjson);
			//张家川
			JSONObject n_zjcjson = readJsonFromUrl("http://api.k780.com:88/?app=weather.today&weaid=101160907&appkey="+appkey+"&sign="+sign+"&format=json");
			setAttribute("n_zjcjson", n_zjcjson);
			//麦积区
			JSONObject n_mjcjson = readJsonFromUrl("http://api.k780.com:88/?app=weather.today&weaid=101160908&appkey="+appkey+"&sign="+sign+"&format=json");
			setAttribute("n_mjcjson", n_mjcjson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/dpzs/lz/qx";
	}
	
	
	private static String readAll(Reader rd) throws IOException {
	    StringBuilder sb = new StringBuilder();
	    int cp;
	    while ((cp = rd.read()) != -1) {
	      sb.append((char) cp);
	    }
	    return sb.toString();
    }
	
	
	
	 public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
		  InputStream is = new URL(url).openStream();
		  try {
		     BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
		     String jsonText = readAll(rd);
		     JSONObject json = JSONObject.parseObject(jsonText);
		     return json;
		  } finally {
		     is.close();
		  }
	 }
	 
	 
	 public static void main(String[] args) {
		 JSONObject json = null ;
		try {
			json = readJsonFromUrl("http://api.k780.com:88/?app=weather.future&weaid=101160906&appkey="+appkey+"&sign="+sign+"&format=json");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println(json.toString());
	}

}
