package com.cloud.icenter.common.util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.cloud.icenter.common.util.DBUtil;



/**
 * 
* @ClassName: MapList 
* @Description: TODO(这里用一句话描述这个类的作用)  
* 
* 将数据集的每一列数据都封装成一个map
* key --列名称  val-该列的数据集
* @author Chen_JIAN
* @date 2015年10月12日 上午11:11:43 
*
 */
public class MapList implements ResultSetExtractor<Map<String, List<Object>>>{



	@Override
	public Map<String, List<Object>> extractData(ResultSet rs)
			throws SQLException, DataAccessException {
		// TODO Auto-generated method stub 
		Map<String, List<Object>> map=new HashMap<String, List<Object>>(0);
		 ResultSetMetaData rsmd = rs.getMetaData();   
		 int columnLength =rsmd.getColumnCount();
		 String columName=null;	 
			while (rs.next()) {
			for (int i = 1; i <=columnLength; i++) {
				columName=rsmd.getColumnName(i).toLowerCase();
				System.out.println(columName+"..."+DBUtil.getValue(rsmd.getColumnTypeName(i), rs, i));
				  if(map.containsKey(columName)){
					  map.get(columName).add(DBUtil.getValue(rsmd.getColumnTypeName(i), rs, i));
				  }else{
					  List<Object> data=new ArrayList<Object>(0);
					  data.add(DBUtil.getValue(rsmd.getColumnTypeName(i), rs, i));
					  map.put(columName, data);
				  }
				}
			}
		return map;
	}

}
