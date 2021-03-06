package com.cloud.icenter.common.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DoubleConverter;
import org.apache.commons.beanutils.converters.FloatConverter;
import org.apache.commons.beanutils.converters.IntegerConverter;
import org.apache.commons.beanutils.converters.LongConverter;
import org.apache.commons.beanutils.converters.ShortConverter;
import org.apache.commons.beanutils.converters.SqlDateConverter;
import org.apache.commons.beanutils.converters.SqlTimeConverter;
import org.apache.commons.beanutils.converters.SqlTimestampConverter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.cloud.icenter.common.utils.SystemConfig;

/**
 * 系统初始化操作
 * @author zhangle
 */
public class ApplicationListener implements ServletContextListener {
  
	private static final Log logger = LogFactory.getLog(ApplicationListener.class);

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		logger.info("正在关闭...");
	}
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		logger.info("正在启动...");
		
		ServletContext sc=event.getServletContext();
		initSystemConfigFile(sc);
		registerConverter();
		initServletContextAttributes(sc);
	}
	
	/**
	 * 初始化系统配置文件
	 */
	private void initSystemConfigFile(ServletContext sc) {
		String configFile=sc.getRealPath(sc.getInitParameter("systemConfigLocation"));
		SystemConfig.configure(configFile);
	}
	
	/**
	 * 注册ConvertUtils的类型转换器
	 */
	private void registerConverter() {
		ConvertUtils.register(new ShortConverter(null), Short.class);
		ConvertUtils.register(new IntegerConverter(null), Integer.class);
		ConvertUtils.register(new LongConverter(null), Long.class);
		ConvertUtils.register(new FloatConverter(null), Float.class);
	    ConvertUtils.register(new DoubleConverter(null), Double.class);
	    ConvertUtils.register(new DateConverter(null), java.util.Date.class);
	    ConvertUtils.register(new SqlDateConverter(null), java.sql.Date.class);
	    ConvertUtils.register(new SqlTimeConverter(null), java.sql.Time.class);
	    ConvertUtils.register(new SqlTimestampConverter(null), java.sql.Timestamp.class);
	}
	
	/**
	 * 初始化系统全局属性
	 * @param sc
	 */
	private void initServletContextAttributes(ServletContext sc) {
		sc.setAttribute("contextPath", sc.getContextPath());
		sc.setAttribute("contextTitle", SystemConfig.getProperty("common.system.title"));
		sc.setAttribute("systemCopyright", SystemConfig.getProperty("common.system.copyright"));
		sc.setAttribute("isShowValidateCode", SystemConfig.getProperty("isShowValidateCode"));
		//sc.setAttribute("syncLogin", SystemConfig.getProperty("sync.login"));
	}
}
