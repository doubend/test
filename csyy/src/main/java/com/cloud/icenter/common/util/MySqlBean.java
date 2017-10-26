package com.cloud.icenter.common.util;

import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * MySQL数据库操作类
 * @author whcai
 *
 */
public class MySqlBean {
	
	private DBConfigure dbConfigure = null;
    private Connection con = null;
    private Statement stmt = null;
    private PreparedStatement preStmt = null; 

    public MySqlBean(DBConfigure dbConfigure) {
        this.dbConfigure = dbConfigure;
    }
    
    /**
     * 获取当前连接
     * 
     * @return 返回当前连接connection
     */
    public Connection getConnection(){
        if(this.con == null)
        	getDirectConnect();
    	
        return this.con;
    }
    
    /**
     * 直接连接数据库，效率低
     * 
     * @throws Exception 连接失败异常
     */
    private void getDirectConnect() {
        if(this.con == null){
            try {
                Class.forName(dbConfigure.getJdbcDriver());
            } catch (ClassNotFoundException e) {
                System.out.println(" class not found: " + e.getMessage());
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
     * 通过数据库连接池连接，效率高
     * 需要配置数据库连接池
     * @throws Exception 连接失败异常
     */
    public void getConnectFromdataPool()throws Exception{
        if (this.con == null) {
            Context initCtx = new InitialContext();
            DataSource ds = (DataSource) initCtx.lookup(this.dbConfigure.getDatapool());
            if (ds != null)
                con = ds.getConnection();
        }
    }
    
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
     * 查询
     * @param sql
     * @return
     * @throws SQLException
     */
    public ResultSet selectSQL(String sql) {  
        ResultSet rs = null;  
        try {  
        	if (!isConnected())
                this.getDirectConnect();
        	if (this.preStmt == null)
        		preStmt = con.prepareStatement(sql);
         
            rs = preStmt.executeQuery(sql);  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        return rs;  
    }  
  
    /**
     * 插入
     * @param sql
     * @return
     * @throws SQLException
     */ 
    public boolean insertSQL(String sql) {  
        try {  
        	if (!isConnected())
                this.getDirectConnect();
        	if (this.preStmt == null)
        		preStmt = con.prepareStatement(sql);
        	
        	preStmt.executeUpdate();  
            return true;  
        } catch (SQLException e) {  
            System.out.println("插入数据库时出错：");  
            e.printStackTrace();  
        } catch (Exception e) {  
            System.out.println("插入时出错：");  
            e.printStackTrace();  
        }  
        return false;  
    }  
    
    /**
     * 删除
     * @param sql
     * @return
     * @throws SQLException
     */
    public boolean deleteSQL(String sql) {  
        try {  
        	if (!isConnected())
                this.getDirectConnect();
        	if (this.preStmt == null)
        		preStmt = con.prepareStatement(sql);
        	
        	preStmt.executeUpdate();  
            return true;  
        } catch (SQLException e) {  
            System.out.println("删除数据库时出错：");  
            e.printStackTrace();  
        } catch (Exception e) {  
            System.out.println("删除时出错：");  
            e.printStackTrace();  
        }  
        return false;  
    }  
    
    /**
     * 更新
     * @param sql
     * @return
     * @throws SQLException
     */
    public boolean updateSQL(String sql) {  
        try {  
        	if (!isConnected())
                this.getDirectConnect();
        	if (this.preStmt == null)
        		preStmt = con.prepareStatement(sql);
        	
        	preStmt.executeUpdate();  
            return true;  
        } catch (SQLException e) {  
            System.out.println("更新数据库时出错：");  
            e.printStackTrace();  
        } catch (Exception e) {  
            System.out.println("更新时出错：");  
            e.printStackTrace();  
        }  
        return false;  
    } 
    
    /**
     * 执行sql语句
     * @param sql
     * @return
     * @throws SQLException
     */
    public ResultSet ExcuteQuery(String sql) {
        ResultSet rs = null;
        try {
            if (!isConnected())
                this.getDirectConnect();
            if (this.stmt == null)
                stmt = con.createStatement();
            
            rs = stmt.executeQuery(sql);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
