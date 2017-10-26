package com.cloud.icenter.common.loader;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.dom4j.Element;
import org.springframework.core.io.Resource;

import com.alibaba.fastjson.JSONObject;
import com.cloud.icenter.common.engine.cache.EngineContext;
import com.cloud.icenter.common.engine.core.SQLXmlUtil;
import com.cloud.icenter.common.engine.util.XmlDom4jUitl;


/***
 * 
* @ClassName: LoaderSQLXML 
* @Description: TODO(这里用一句话描述这个类的作用) 
* SQLXML 文件装载器
* 将 sql 配置文件载入内存中
* @author Chen_JIAN
* @date 2015年7月23日 下午3:35:27 
*
 */
public class LoaderSQLXML {
	  private Logger logger = Logger.getLogger(this.getClass());
	// 持有一个Resource属性
	private List<Resource> resource;
    private   XmlDom4jUitl dom;

    
    public LoaderSQLXML(List<Resource> resource) throws Exception{
    	this.resource=resource;
    	init();
    	
    }
	
	@SuppressWarnings("unchecked")
	public void init() throws Exception {
		logger.info("SQL解析引擎初始化...");
		List<Element> list = null;
		dom = new XmlDom4jUitl();
		if (!resource.isEmpty()) {

			for (Resource res : resource) {
				if (res != null && res.exists()) {
					if (res.isReadable()) {
						
						 try {
							 logger.info("加载配置SQL配置文件["+res.getFilename()+"]");
							dom.load(res.getInputStream());
							
							list = dom.getRootElement().elements();
							for (Element element : list) {
								String key = element.attributeValue("key");
								String type = element.getName();
								String tag = element.asXML();
								JSONObject json = new JSONObject();
								json.put("key", key);
								json.put("type", type);
								json.put("tag", SQLXmlUtil.fromXmlToTag(tag));
								if(EngineContext.containsKey(key)){
									throw new Exception("key="+key+"已经存在不能重复,请检查"+res.getFilename()+"SQL配置文件!");	
								}
								EngineContext.put(key, json);
							}
						} catch (IOException e) {
							throw new Exception("SQLxml解析引擎解析"+res.getFilename()+"配置文件出现异常！");	
						}
					}
				}

			}

		}

	}


	public List<Resource> getResource() {
		return resource;
	}

	public void setResource(List<Resource> resource) {
		this.resource = resource;
	}

	

}
