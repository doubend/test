package com.cloud.icenter.yyzx.cszc.security.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.icenter.base.service.impl.SQLServiceImp;
import com.cloud.icenter.common.engine.cache.SQLContext;
import com.cloud.icenter.common.util.JSONRowMapper;
import com.cloud.icenter.yyzx.cszc.security.pojo.QueryPojo;
import com.cloud.icenter.yyzx.cszc.security.service.SecurityService;

/**
 * 社保实现类
 * @date 2017年4月7日
 * @author dxliug
 */
@Service(value="securityServiceImpl")
public class SecurityServiceImpl extends SQLServiceImp implements SecurityService{

	    private List<Object> parameter;
		
		public List<Object> getParameter() {
			return parameter;
		}
		@Autowired
		private JdbcTemplate jdbcTemplate;

		@Override
		public Map<String, Object> getSingle(String sql) {
			Map<String, Object> map=jdbcTemplate.queryForMap(sql);
			return map;
		}

		@Override
		public List<Map<String, Object>> getList(String sql) {
			List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
			return list;
		}

		@Override
		public List<JSONObject> getListPram(String sql, Object obj) {
			JSONObject jsonObject = SQLContext.get(sql, obj);
			Object[] pams = (Object[]) jsonObject.get("pams");
			setParameter(pams);
			return jdbcTemplate.query(sql, new JSONRowMapper(), this.getParameter().toArray());
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

		@Override
		public List<JSONObject> findBaseListBySfz(QueryPojo pojo, String sqlContext) {
			JSONObject jsonObject = SQLContext.get(sqlContext, pojo);
			Object[] pams = (Object[]) jsonObject.get("pams");
			return this.queryJsonToList(jsonObject.getString("sql"), pams);
		}
	
}
