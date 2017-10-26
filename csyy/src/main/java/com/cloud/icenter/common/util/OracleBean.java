package com.cloud.icenter.common.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Oracle数据库操作类
 * @author whcai
 *
 */
public class OracleBean {
	
	private DBConfigure dbConfigure = null;
    private Connection con = null;
    private Statement stmt = null;  
    
    public OracleBean(DBConfigure dbConfigure) {
        this.dbConfigure = dbConfigure;
    }
    
    /**
     * 获取数据库连接
     * @return
     */
    public Connection getConnection(){
        if(this.con == null)
        	getDirectConnect();
    	
        return this.con;
    }
    
    /**
     * 获取数据库连接
     * @return
     */
    private void getDirectConnect(){
    	if(this.con == null){
            try {
                Class.forName(dbConfigure.getJdbcDriver());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
    
            try {
                con = DriverManager.getConnection(dbConfigure.getDatabaseURL(), 
                		dbConfigure.getDatabaseUser(), dbConfigure.getDatebasePassword());
            } catch (SQLException sqlex) {
                sqlex.printStackTrace();
            }
    	}
    }
    
    /**
     * 关闭数据库连接
     * @throws SQLException
     */
    public void disConnect() throws SQLException {
        try {
            if (stmt != null) {
            	stmt.close();
                //注意调用close后，该变量不为null，如果再以stmt!=null为条件，将引发错误
            	stmt=null;
            }

            if (con != null) {
                con.close();
                //注意调用close后，与数据库的连接返还给了数据库连接池，但该变量不为null，
                //如果再以判断conn!=null为条件，将引发错误
                con=null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("-Database disConnection error ");
        }
    }
    
    public boolean isConnected() {
        return (con != null);
    }
    
    /**
     * 执行查询
     * @param sql
     * @return
     */
    public ResultSet ExcuteQuery(String sql) {
        ResultSet rs = null;
        try {
            if (!isConnected())
                this.getDirectConnect();
            if (this.stmt == null)
            	this.stmt = con.createStatement();
            
            rs = stmt.executeQuery(sql);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
