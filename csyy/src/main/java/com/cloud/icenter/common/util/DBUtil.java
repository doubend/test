package com.cloud.icenter.common.util;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;


/**
 * 
* @ClassName: DBUtil 
* @Description: TODO(这里用一句话描述这个类的作用) 
* jdbc 获取值以及设置参数值
* @author Chen_JIAN
* @date 2015年10月12日 上午11:08:59 
*
 */

public class DBUtil {
	
	public static Object getValue(String columType,ResultSet rs,int columIndex) throws SQLException{
		Object obje=null;
		if("Date".equalsIgnoreCase(columType)){
			obje=rs.getDate(columIndex);
		}else if("TIMESTAMP".equals(columType)){
			obje=rs.getTimestamp(columIndex);
		}else if("Clob".equalsIgnoreCase(columType)){
			Clob	clob=rs.getClob(columIndex);
	    return (clob != null ? clob.getSubString(1, (int) clob.length()) : null); 
			
		}else if("Byte".equalsIgnoreCase(columType)){
			obje=rs.getByte(columIndex);
		}else if("Blob".equalsIgnoreCase(columType)){
			Blob	blob=rs.getBlob(columIndex);
			return (blob!=null ?blob.getBytes(1,(int) blob.length()) : null);
			
		}else{
			
			obje= rs.getObject(columIndex);
		}
		return obje;
		
	}
	
public static void setValue( PreparedStatement ps ,Object obje,int index) throws NumberFormatException, SQLException{
	if(obje instanceof Integer){
		ps.setInt(index, Integer.valueOf(obje.toString()));
//		System.out.println(obje.getClass().getSimpleName());
	}else if(obje instanceof String){
		ps.setString(index, String.valueOf(obje));
//		System.out.println(obje.getClass().getSimpleName()); 
	}else if(obje instanceof Float){
		ps.setFloat(index, Float.valueOf(obje.toString()));	
	}else if(obje instanceof Double){
		ps.setDouble(index, Double.valueOf(obje.toString()));
	}else if(obje instanceof Date){
		ps.setTimestamp(index, (Timestamp) obje);
	}else if(obje instanceof Byte){
		ps.setByte(index,(Byte) obje);
	}else if(obje instanceof Byte[]){
		ps.setBytes(index, (byte[]) obje);
	}else if(obje instanceof InputStream){
		ps.setBinaryStream(index, (InputStream) obje);
	}else if(obje instanceof Blob){
		ps.setBlob(index, (Blob) obje);
	}else if(obje instanceof Clob){
		ps.setClob(index, (Clob) obje);
	}else{
		ps.setObject(index, obje);


	}
	
}
public static void main(String[] args) {

	 Object[] obje=new Object[]{1,"2"};
	 for (int i = 0; i < obje.length; i++) {
		
		if(obje[i] instanceof Integer){
			System.out.println(obje[i].getClass().getSimpleName()); 
		}else if(obje[i] instanceof String){
			System.out.println(obje[i].getClass().getSimpleName()); 
			
		}else if(obje[i] instanceof Byte){
			System.out.println(obje[i].getClass().getSimpleName()); 
			
		}else if(obje[i] instanceof byte[]){
			System.out.println(obje[i].getClass().getSimpleName());
		}
	}
}


}
