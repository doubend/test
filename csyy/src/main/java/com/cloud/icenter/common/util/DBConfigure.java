package com.cloud.icenter.common.util;

import com.cloud.icenter.common.constants.Constants;

/**
 * 数据库配置类
 * @author whcai
 */
public class DBConfigure {
	/**
	 * 静态类
	 */
    //private static DBConfigure instance = null;

    private String jdbcDriver;   // ="com.mysql.jdbc.Driver"
    private String dbURL;        //="jdbc:mysql://localhost:3306/zwmh"
    private String dbUser;       //="root";
    private String dbPassword;   //="123456";
    /** 数据库连接池名称*/
    private String datapool="java:comp/env/jdbc/hdptdep";
    
    /**
     * 构造函数
     * @param dbType 数据库类型：MySQL，Oracle
     */
    public DBConfigure(String dbType){
    	if(dbType.equalsIgnoreCase(Constants.DB_MYSQL))
    		this.jdbcDriver = "com.mysql.jdbc.Driver";
    	if(dbType.equalsIgnoreCase(Constants.DB_ORACLE))
    		this.jdbcDriver = "oracle.jdbc.driver.OracleDriver";
    }
    
    
    /**
     * 单例函数
     * @return 一个实例
     */
   /* public static DBConfigure getInstance() {
        if (instance == null) {
            instance = new DBConfigure();
        }
        return instance;
    }*/

    public String getDatabaseUser() {
        return this.dbUser;
    }

    public void setDatabaseUser(String dbUser) {
        this.dbUser = dbUser;
    }

    public String getDatebasePassword() {
        return this.dbPassword;
    }

    public void setDatebasePassword(String datebasePassword) {
        this.dbPassword = datebasePassword;
    }

    public String getDatabaseURL() {
        return this.dbURL;
    }

    public void setDatabaseURL(String databaseURL) {
        this.dbURL = databaseURL;
    }

    public String getJdbcDriver() {
        return this.jdbcDriver;
    }

    /*
    public void setJdbcDriver(String jdbcDriver) {
        this.jdbcDriver = jdbcDriver;
    } */
    
    public String getDatapool() {
        return datapool;
    }

    public void setDatapool(String datapool) {
        this.datapool = datapool;
    }
}
