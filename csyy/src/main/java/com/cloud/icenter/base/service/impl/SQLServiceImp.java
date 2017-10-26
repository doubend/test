package com.cloud.icenter.base.service.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cloud.icenter.base.service.ISQLService;



import com.cloud.icenter.common.util.DBUtil;
import com.cloud.icenter.common.util.SQLBuildFactory;
import com.cloud.icenter.common.util.Pagination;
import com.cloud.icenter.common.util.JSONRowMapper;
import com.cloud.icenter.common.util.MapList;


/**
 * 
 * @ClassName: SQLServiceImp
 * @Description: TODO(这里用一句话描述这个类的作用) 原生态SQL操作服务实现类
 * @author Chen_JIAN
 * @date 2015年6月25日 上午10:13:22
 * 
 */
@Service(value="SQLServiceImp")
@Scope("prototype")
public class SQLServiceImp implements ISQLService {

	Logger logger = Logger.getLogger(getClass());

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static String dbType = "mysql";

	private List<Object> parameter;

	public List<Object> getParameter() {
		return parameter;
	}
  
	/**
	 * 设置参数
	 * @param pams
	 */
	public void setParameter(Object... pams) {
		this.parameter = new ArrayList<Object>(0);
		for (Object object : pams) {
			if (object instanceof Object[]) {

				Object[] obejs = (Object[]) object;
				for (int i = 0; i < obejs.length; i++) {

					parameter.add(obejs[i]);
				}
			} else {
				parameter.add(object);
			}

		}

	
	}

	public static String getDbType() {
		return dbType;
	}

	public static void setDbType(String dbType) {
		SQLServiceImp.dbType = dbType;
	}

	public JdbcTemplate getJdbcTemplate() {

		return jdbcTemplate;
	}

	@Override
	public <T> List<T> query(String sql, Class<T> clazz, Object... params) {
		
		try {
			setParameter(params);
			return this.getJdbcTemplate().query(sql,new BeanPropertyRowMapper<T>(clazz), this.getParameter().toArray());
		} catch (DataAccessException e) {
			logger.error("执行query方法出现异常["+e.getMessage()+"]");
			return null;
		}
	}

	@Override
	public <T> T getSingleResult(String sql, Class<T> clazz, Object... params) {

		try {
			setParameter(params);
			return this.getJdbcTemplate().queryForObject(sql,new BeanPropertyRowMapper<T>(clazz), this.getParameter().toArray());
		} catch (DataAccessException e) {
			logger.error("执行getSingleResult方法出现异常["+e.getMessage()+"]");
			
			return null;
		}

	}

	@Override
	public JSONObject queryForJSONObject(String sql, Object... params) {

		
	try {
		setParameter(params);
		return getJdbcTemplate().queryForObject(sql, new JSONRowMapper(),this.getParameter().toArray());
	} catch (DataAccessException e) {
		logger.error("根据sql将查询出来的单条记录 封装成一个 JSONObject对象出现异常["+e.getMessage()+"]");
		e.printStackTrace();
		return null;
	}

	 
	}

	@Override
	public List<JSONObject> queryJsonToList(String sql, Object... params) {

		try {
			setParameter(params);
			return getJdbcTemplate().query(sql, new JSONRowMapper(), this.getParameter().toArray());
		} catch (DataAccessException e) {
			
			logger.error("查询sql封装成List<JSONObject>出现异常["+e.getMessage()+"]");
		   return null;
		}
	}


	public JSONArray queryJsonToArray(String sql, Object... params) {
		try {
			return queryJsonToArray(sql, false, params);
		} catch (Exception e) {
			logger.error("执行queryJsonToArray方法出现异常["+e.getMessage()+"]");
			return null;
		}
	}
	public JSONArray queryJsonToArray(String sql,final boolean flag, Object... params) {

		setParameter(params);
		JSONArray jsonArray = this.getJdbcTemplate().query(sql, this.getParameter().toArray(),
				new ResultSetExtractor<JSONArray>() {
					@Override
					public JSONArray extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						JSONArray jsonArray = new JSONArray();
						JSONArray columns = new JSONArray();
		
						ResultSetMetaData rsmd = rs.getMetaData();
						int columnLength = rsmd.getColumnCount();
						int length=0;
						while (rs.next()) {
							JSONObject json = new JSONObject();
							for (int i = 1; i <= columnLength; i++) {

								json.put(rsmd.getColumnName(i).toLowerCase(),
										DBUtil.getValue(
												rsmd.getColumnTypeName(i), rs,
												i));
								if(length==0){
									JSONObject column = new JSONObject();
									if("sn1".equalsIgnoreCase(rsmd.getColumnName(i))){
										continue;
									}
									if(flag){
										column.put("field", rsmd.getColumnName(i).toLowerCase());
										column.put("title", rsmd.getColumnName(i).toLowerCase());
										column.put("width", 200);	
										columns.add(column);
									}
									
								
								
								}
							}
						
							jsonArray.add(json);
							length++;
						}
						if(flag){
							jsonArray.add(columns);
						}
				
						
			
						return jsonArray;
					}
				});
		return jsonArray;
	}
	
	
	


	@Override
	public <T> Pagination<T> getPagination(String sql, int pageNow,
			int pageSize, Class<T> clazz, Object... params) {
		int recordCount = this.getSQLCount(sql, params);
		sql = SQLBuildFactory.buildPageSql(sql, dbType, pageNow, pageSize);
        setParameter(params);
		return new Pagination<T>(pageNow, pageSize, recordCount,
				getJdbcTemplate().query(sql, getParameter().toArray(),
						new BeanPropertyRowMapper<T>(clazz)));

	}

	@Override
	public JSONObject querJSONPage(String sql, int pageNow, int pageSize,
			Object... params) {


		JSONObject json = new JSONObject();
		int recordCount = this.getSQLCount(sql, params);
		// 计算总页数
		int pageCount = (int) Math.ceil(recordCount / (double) pageSize);
		if (pageNow > pageCount) {
			pageNow = pageCount;
		}
		if(pageNow == 0)
			pageNow = 1;
		boolean hasNextPage, hasPrePage;

		// 下一页等于当前页加一
		int nextPage = pageNow + 1;
		if (nextPage > pageCount) {
			hasNextPage = false;// 没有下一页
			nextPage = pageCount;
		} else {
			hasNextPage = true;// 有下一页
		}
		// 上一页等于当前页减一
		int prePage = pageNow - 1;
		if (prePage < 1) {
			hasPrePage = false;// 没有上一页
			prePage = 1;
		} else {
			hasPrePage = true;// 有上一页
		}
		json.put("pageNow", pageNow);
		json.put("pageSize", pageSize);
		json.put("pageCount", pageCount);// 总页数
		json.put("prePage", prePage);// 上一页
		json.put("nextPage", nextPage);// 下一页
		json.put("total", recordCount);// 总记录数
		json.put("hasPrePage", hasPrePage);
		json.put("hasNextPage", hasNextPage);
		sql = SQLBuildFactory.buildPageSql(sql, dbType, pageNow, pageSize);
		JSONArray jsonArray=this.queryJsonToArray(sql,true, params);
		if(jsonArray!=null&&!jsonArray.isEmpty()){
			int size=jsonArray.size()-1;
			json.put("columns",jsonArray.get(size));
			jsonArray.remove(size);
		}
		json.put("rows",jsonArray );
		return json;
	}

	public <T> int getSQLCount(String sql, Object... params) {
		
		setParameter(params);

		if (sql == null)
			return 0;
		StringBuffer sqlsb = new StringBuffer("SELECT COUNT(1) FROM ( ");
		//mysql数据库的特殊处理AS countTable
		sqlsb.append(sql).append(" ) AS countTable");

	    try {
		    return	getJdbcTemplate().queryForObject(sqlsb.toString(), getParameter().toArray(),java.lang.Integer.class);
		} catch (DataAccessException e) {
			logger.error("执行sql统计总记录数出现异常["+e.getMessage()+"]");
		}
        return 0;
	}

	@Override
	public void bindRelation(String sql, Object obj, Object ids[]) {
		final Object Id = obj;
		final Object arry[] = ids;

		if (ids == null) {
			logger.error("绑定表关系时参数Ids数组为空[" + sql + "]");
			return;
		}
		this.getJdbcTemplate().batchUpdate(sql,
				new BatchPreparedStatementSetter() {

					@Override
					public void setValues(PreparedStatement ps, int i)
							throws SQLException {
						ps.setObject(1, Id);
						ps.setObject(2, arry[i]);

					}

					@Override
					public int getBatchSize() {
						// TODO Auto-generated method stub
						return arry.length;
					}
				});

	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void update(String sql, Object... params) {
		this.getJdbcTemplate().update(sql, params);

	}

	@Override
	public int[] batUpdate(String... sql) {

		return this.getJdbcTemplate().batchUpdate(sql);

	}

	public int[] batUpdate(String sql, List<Object[]> batchArgs) {

		return this.getJdbcTemplate().batchUpdate(sql, batchArgs);

	}

	@Override
	public Map<String, List<Object>> queryForMap(String sql, Object... params) {


		try {
			setParameter(params);
		   return	this.getJdbcTemplate().query(sql, new MapList(), this.getParameter().toArray());
		} catch (DataAccessException e) {
			logger.error("根据sql查询出的数据集封装成MAP出现异常["+e.getMessage()+"]");
			return null;
		}
	}

}
