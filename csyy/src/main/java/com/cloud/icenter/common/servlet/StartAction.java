package com.cloud.icenter.common.servlet;

import java.io.File;

import javax.servlet.http.HttpServlet;

import com.cloud.icenter.common.utils.EHcacheUtils;
import com.cloud.icenter.system.data.utils.DictUtils;

/**
 * 自启动servlet
 * @author menglit
 *
 */
public class StartAction extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void init() {
    	//获取缓存文件的路径
    	String	cachePath = getServletContext().getRealPath(getCacheFilePath());
    	EHcacheUtils.EHCACHE_CONFIG_PATH = cachePath;
    	//初始化缓存配置
    	EHcacheUtils.init();
    	//缓存数据字典
    	DictUtils.cache();
    }
    
    /**
     * 获取缓存文件的路径
     * @return
     */
	private String getCacheFilePath() {
		String common = File.separator;
		StringBuffer path = new StringBuffer(common);
		path.append("WEB-INF").append(common).append("classes").append(common).append("ehcache.xml");
		return path.toString();
	}
}
