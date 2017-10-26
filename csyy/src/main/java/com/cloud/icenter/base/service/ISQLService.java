package com.cloud.icenter.base.service;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cloud.icenter.common.util.Pagination;

/**
 * 
* @ClassName: ISQLBaseService 
* @Description: TODO(这里用一句话描述这个类的作用) 
*  原生SQL基础服务接口
* @author Chen_JIAN
* @date 2015年6月24日 下午5:02:53 
*
 */
public interface ISQLService {
	/**
	   *  根据sql将查询出来的记录集
	   *  封装成指定对象的集合
	   * @param sql
	   * @param clazz
	   * @param params
	   * @return
	   */
	  public <T> List<T> query(String sql,Class<T> clazz,Object...params);
	  
	  /**
	   *  根据sql 将查询出来的单条记录
	   *  封装成指定对象
	   * @param sql
	   * @param clazz
	   * @param params
	   * @return
	   */
	  public  <T> T getSingleResult(String sql,Class<T> clazz,Object...params);
	  
	  /**
	   * 根据sql将查询出来的单条记录
	   * 封装成一个 JSONObject 对象
	   * @param sql
	   * @return
	   */
	  public JSONObject queryForJSONObject(String sql,Object...params) ;
	  
	  /**
	   * 
	   * queryJsonToList(这里用一句话描述这个方法的作用)
	   * 
	   * @param sql
	   * @param params
	   * @return List<JSONObject>
	   * @exception 
	   * @version  1.0.0
	   * @date 2015年9月17日 
	   *
	   */
	  
	  public List<JSONObject> queryJsonToList(String sql,Object...params) ;
	  
	  /**
	   * 根据sql将查询出来的记录集
	   * 封装成一个 JSONArray 集合
	   * @param sql
	   * @param params
	   * @return
	   */
	  public JSONArray queryJsonToArray(String sql, Object...params) ;
	  
	  
	  
	  /**
	   * 
	   * queryForMap(这里用一句话描述这个方法的作用)
	   * 
	   * 将数据集封装成一个map
	   * key --字段名
	   * val --该字段下的所有数据集
	   * 
	   * @param sql
	   * @param parmas
	   * @return Map<String,List<Object>>
	   * @exception 
	   * @version  1.0.0
	   * @date 2015年10月12日 
	   *
	   */
	  
	  public Map<String ,List<Object>> queryForMap(String sql ,Object...parmas);
	  
     /**
      * 根据组装好sql
      * 进行分页查询
      * @param sql
      * @param pageNow
      * @param pageSize
      * @param clazz
      * @param dbType
      * @param params
      * @return
      */
	  public <T> Pagination<T> getPagination(String sql, int pageNow, int pageSize,Class<T> clazz,Object... params);
	  
	  /**
	   * 根据组装的sql进行分页查询
	   * 返回一个分页的 JSONObject 对象
	   *    例如:
		    json.put("pageNow", pageNow);
			json.put("pageSize", pageSize);
			json.put("pageCount", pageCount);// 总页数
			json.put("prePage", prePage);// 上一页
			json.put("nextPage", nextPage);// 下一页
			json.put("count", recordCount);// 总记录数
			json.put("hasPrePage", hasPrePage);//是否有上一页
			json.put("hasNextPage", hasNextPage);//是否有下一页
			json.put("rows", JSONArray);//数据集
	   * @param sql
	   * @param pageNow
	   * @param pageSize
	   * @param dbType  数据库类型 mysql,oracle
	   * @param params
	   * @return
	   */
	  public JSONObject querJSONPage(String sql, int pageNow, int pageSize,Object... params);
	  
	  /**
	   * 统计总记录数
	   * @param sql
	   * @param params
	   * @return
	   */
	  
		public <T> int getSQLCount(String sql,Object...params);
		
		/**
		 * 
		 * bindRelation(这里用一句话描述这个方法的作用)
		 * 批量 绑定两张表的关系   
		 * @param sql 
		 * @param obj  要绑定主表的id
		 * @param ids  要绑定从表的id 数组
		 * @exception 
		 * @version  1.0.0
		 * @date 2015年8月11日 
		 *
		 */
		
		public void bindRelation(String sql, Object obj,Object ids[]);
		/**
		 * 
		 * update(这里用一句话描述这个方法的作用)
		 * 执行 插入、更新 sql
		 * @param sql
		 * @param params void
		 * @exception 
		 * @version  1.0.0
		 * @date 2015年9月17日 
		 *
		 */
		
		public void update(String sql,Object...params );
		
		/**
		 * 
		 * batUpdate(这里用一句话描述这个方法的作用)
		 * 批量执行sql
		 * @param sql
		 * @return int[]
		 * @exception 
		 * @version  1.0.0
		 * @date 2015年9月17日 
		 *
		 */
		
		public int[] batUpdate(String ...sql);
		
		
		/**
		 * 
		 * batUpdate(这里用一句话描述这个方法的作用)
		 * 根据sql对应的参数集合
		 * 进行批量插入
		 * @param sql
		 * @param batchArgs
		 * @return int[]
		 * @exception 
		 * @version  1.0.0
		 * @date 2015年9月17日 
		 *
		 */
		public int[] batUpdate(String sql,List<Object[]> batchArgs);
	  

}
