package com.cloud.icenter.common.util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;







import org.springframework.jdbc.core.RowMapper;

import com.alibaba.fastjson.JSONObject;
import com.cloud.icenter.common.util.DBUtil;

/**
 * 
 * <p>Title:JSONRowMapper</p>
 * <p>Description: 将查询出来的数据封装成一个   JSONObject 数据对象  </p>
 * <p>Copyright: Copyright (c) </p>
 * <p>Company: XXXX</p>
 * <p>Date:2014年8月14日</p>
 * @author CHEN_JIAN
 * @version 1.0
 */
public class JSONRowMapper implements RowMapper<JSONObject> {

	@Override
	public JSONObject mapRow(ResultSet rs, int rowNum) throws SQLException {
		 ResultSetMetaData rsmd = rs.getMetaData();   
		 int columnLength =rsmd.getColumnCount();
		 JSONObject json=new JSONObject();
		for (int i = 1; i <=columnLength; i++) {
		
//			 System.out.println(rsmd.getColumnName(i)+">>"+rsmd.getColumnClassName(i));
				 json.put(rsmd.getColumnName(i),DBUtil.getValue(rsmd.getColumnTypeName(i), rs, i));
				 
			}

		return json;
	}

	
}
