package com.cloud.icenter.common.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.util.StringUtils;


/**
 * JDBC工具类
 * @author byl
 *
 */
public class JDBCUtil {
	
	public JDBCUtil() {  
        super();  
    }  
  
    public static Connection getConnection(String url,String username,String password , DataBaseType dbType) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
    	Class.forName(dbType.getDriverName());
    	//设置超时时间，暂时解决错误密码等待时间
    	DriverManager.setLoginTimeout(10);
        return DriverManager.getConnection(url, username, password);
    }  
    
    public static Connection getConnection(String dbIp , String port , String dbName , String userName , String password , String instanceName , DataBaseType dbType) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{
    	if(!StringUtil.isEmpty(dbIp) && !StringUtil.isEmpty(userName) && !StringUtil.isEmpty(password) && dbType != null){
    		return getConnection(getJdbcConnectionUrl(dbIp, dbName, port, instanceName, dbType), userName, password, dbType);
    	}
    	return null;
    }
  
    public static void close(ResultSet rs, Statement st, Connection conn) throws SQLException {  
        try {  
            if (rs != null) {  
                rs.close();  
  
            }  
        }finally{  
            try {  
                if(st!=null){  
                    st.close();  
                }  
            }finally{  
                if(conn!=null){  
                    conn.close();  
                }  
            }  
        }  
  
    }  
  
	/**
	 * jdbc url解析
	 * @param url
	 * @return
	 */
	public static DataBaseObj parse(String url){
		if(!StringUtil.isEmpty(url)){
			DataBaseObj dbo = new DataBaseObj();
			
			url = url.replace("jdbc:oracle:thin:@", "");
			String[] params = url.split(":");
			dbo.setHost(params[0]);
			dbo.setPort(params[1]);
			dbo.setDbName(params[2]);
			
			return dbo;
		}
		return null;
	}
	
	/**
	 * 将IP地址和databaseName根据数据库类型，转换成标准的连接URL
	 * @param dbIp
	 * @param dbName
	 * @param dbType
	 * @param 
	 * @return
	 */
	public static String getJdbcConnectionUrl(String dbIp , String dbName , String port , String instanceName , DataBaseType dbType){
		if(StringUtils.hasText(dbName) && StringUtils.hasText(port) && StringUtils.hasText(dbIp) && dbType != null){
			if(DataBaseType.MYSQL.equals(dbType)){
				//MYSQL
				return String.format(dbType.getDriverUrl(), dbIp , port , dbName);
			}else if(DataBaseType.ORACLE.equals(dbType)){
				//Oracle
				return String.format(dbType.getDriverUrl(), dbIp , port , dbName);
			}else if(DataBaseType.SQLSERVER.equals(dbType)){
				//Sql Server
				if(StringUtils.hasText(instanceName)){
					return String.format(dbType.getDriverUrl(), dbIp , port , instanceName , dbName);
				}
			}
		}
		return null;
	}
	
	public enum DataBaseType
	{
		MYSQL("com.mysql.jdbc.Driver", "jdbc:mysql://%s:%s/%s?useUnicode=true&characterEncoding=utf8" , "jdbc:mysql://%s:%s/") , 
		ORACLE("oracle.jdbc.driver.OracleDriver", "jdbc:oracle:thin:@%s:%s:%s" , ""),
		SQLSERVER("com.microsoft.sqlserver.jdbc.SQLServerDriver" , "jdbc:sqlserver://%s:%s;instanceName=%s;DatabaseName=%s" , "");
		private String driverName;
		private String driverUrl;
		private String noDbNameUrl;
		
		DataBaseType(String driverName , String driverUrl , String noDbNameUrl)
		{
			this.driverName = driverName;
			this.driverUrl = driverUrl;
			this.noDbNameUrl = noDbNameUrl;
		}
		
		public String getDriverName()
		{
			return driverName;
		}
		
		public String getDriverUrl()
		{
			return driverUrl;
		}

		public String getNoDbNameUrl()
		{
			return noDbNameUrl;
		}
	}
}

