package com.cloud.icenter.base.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cloud.icenter.common.utils.SystemConfig;

/**
 * 系统启动执行 系统启动将所有的“已启用”的任务放到任务队列中等待执行
 * 
 * @author wangjiaxi
 * @update 2015年12月15日
 */
public class StartAction extends HttpServlet {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final long serialVersionUID = 1L;

    @Override
    public void init() {
        logger.info("系统已经启动！！");
        ServletContext sc= this.getServletContext();
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
