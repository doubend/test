package com.cloud.icenter.common.engine.core;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Element;

import com.alibaba.fastjson.JSONObject;
import com.cloud.icenter.common.engine.cache.EngineContext;
import com.cloud.icenter.common.engine.cache.SQLContext;
import com.cloud.icenter.common.engine.util.XmlDom4jUitl;

/**
 * 
 * <p>Title:SQLXmlEngine</p>
 * <p>Description: SQLxml解析引擎    </p>
 * <p>Copyright: Copyright (c) </p>
 * <p>Company: XXXX</p>
 * <p>Date:2015年1月2日</p>
 * @author CHEN_JIAN
 * @version 1.0
 */
public class SQLXmlEngine {
  private Logger logger = Logger.getLogger(SQLXmlEngine.class);
   private   String xmlPath="querys.xml,query.xml";
   private   XmlDom4jUitl dom;
   private String basePath;
   
  
public SQLXmlEngine(){
	this.basePath=System.getProperty("user.dir")+"/src/main/resources"+File.separator;
	
};
public SQLXmlEngine( String basePath,String xmlPath) throws Exception{
	this.xmlPath=xmlPath;
	this.basePath=System.getProperty("user.dir")+File.separator+basePath+File.separator;
	init();
}   

/**
 * 将所有SQL配置文件载入缓存
 * @throws Exception 
 */
@SuppressWarnings("unchecked")
	public void init() throws Exception {
	logger.info("SQL解析引擎初始化...");
		List<Element> list = null;
		String[] path = xmlPath.split(",");
		if(path==null){
			logger.error("SQLxml解析引擎没有找到SQL配置文件的加载路径!");
			
			throw new Exception("SQLxml解析引擎没有找到SQL配置文件的加载路径!");	
		}
		dom = new XmlDom4jUitl();
		
		for (String string : path) {
			dom.load(basePath + string);
			list = dom.getRootElement().elements();
			for (Element element : list) {
				String key = element.attributeValue("key");
				String type = element.getName();
				String tag = element.asXML();
				JSONObject json = new JSONObject();
				json.put("key", key);
				json.put("type", type);
				json.put("tag", SQLXmlUtil.fromXmlToTag(tag));
				EngineContext.put(key, json);
			}
		}
//	EngineContext.write();
	}   
public static void main(String[] args) throws Exception {
	SQLXmlEngine engine=new SQLXmlEngine();
	 engine.init();

	 Map<String,Object> map=new HashMap<String,Object>();
	 map.put("userWxmpId",129);
	 map.put("keyWord", "'3','44','99'");
	 
//	 WxmpReplyInfo info=new WxmpReplyInfo();
//	 info.setKeyWord("dddd");
//	 info.setUserId(999)
//	 info.setUserWxmpId(8888);

    System.out.println(SQLContext.getSQL("replyTextInfo",map)); ;


}

}

