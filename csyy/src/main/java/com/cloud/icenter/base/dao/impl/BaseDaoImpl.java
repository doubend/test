package com.cloud.icenter.base.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.common.constants.Constants;
import com.cloud.icenter.common.utils.Pagination;
import com.cloud.icenter.common.utils.PagingUtil;

/**
 * hibernate的dao基础实现类
 * @author zhangle
 * @param <T>
 */
public abstract class BaseDaoImpl<T> implements BaseDao<T> {

	@Autowired 
	private SessionFactory sessionFactory;
	private Class<T> entityClass;
	
	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		try {
			entityClass =(Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		} catch(Exception e) {}
	}
	
	/**
	 * 获取hibernate的session对象
	 * @return
	 */
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void add(T po) {
		getSession().save(po);
	}
	
	@Override
	public String save(T po) {
		Serializable id = getSession().save(po);
		return id.toString();
	}
	
	@Override
	public void update(T po) {
		getSession().update(po);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public T get(String id) {
		return (T) getSession().get(entityClass, id);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public T get(Long id) {
		return (T) getSession().get(entityClass, id);
	}
	
	@Override
	public void delete(String id) {
		executeUpdate("delete "+entityClass.getName()+" where id=?",id);
	}
	
	@Override
	public void delete(Long id) {
		executeUpdate("delete "+entityClass.getName()+" where id=?",id);
	}
	
	@Override
	public void logicDelete(String id) {
		executeUpdate("update "+entityClass.getName()+" set status=?  where id=?",String.valueOf(Constants.DATA_STATUS_INVALID), id);
	}
	
	@Override
	public void logicDeleted(String id) {
		executeUpdate("update "+entityClass.getName()+" set deleted=?  where id=?",Constants.DATA_STATUS_INVALID, id);
	}
	
	@Override
	public void logicDel(String id) {
		executeUpdate("update "+entityClass.getName()+" set isDel=?  where id=?",String.valueOf(Constants.DATA_STATUS_INVALID), id);
	}
	
	@Override
	public List<T> find(DetachedCriteria detachedCriteria) {
		Criteria criteria=detachedCriteria.getExecutableCriteria(getSession());
		return criteria.list();
	}
	
	@Override
	public void find(Pagination<T> pagin) {
		
		Criteria criteria=pagin.getCriteria().getExecutableCriteria(getSession());
		long count=countRow(criteria);
		pagin.setTotalCount(count);
		
		//如果只有0条记录,那么无需再查数据库,直接返回一个空list
		if(count==0) {
			pagin.setDataList(Collections.EMPTY_LIST);
		} else {
			criteria.setProjection(null);
			criteria.setFirstResult(pagin.getStartResult());
			criteria.setMaxResults(pagin.getPageSize());
			pagin.setDataList(criteria.list());
		}
	}
	
	/**
	 * 快速统计Criteria的总行数
	 * @param criteria
	 * @return
	 */
	protected long countRow(Criteria criteria) {
		criteria.setProjection(Projections.rowCount());
		try {
			List result=criteria.list();
			return (Long)result.get(0);
		} catch(Exception e) {
			return 0;
		}
	}
	
	/**
	 * 当field字段的值等于value时返回该对象
	 */
	protected <T> T get(Class<T> clazz,String field,Object value) {
		Criteria criteria=getSession().createCriteria(clazz);
		criteria.add(Restrictions.eq(field, value));
		List<T> result= criteria.list();
		
		if(result==null || result.isEmpty()) return null;
		return result.get(0);
	}
	
	/**
	 * 获取下一个排序号
	 * @param field		排序号实体属性名
	 * @return
	 */
	public Integer getNextSeqNum(String property) {
		Criteria criteria=getCriteria().setProjection(Projections.max(property));
		try {
			List result=criteria.list();
			return Integer.parseInt(result.get(0)+"")+1;	
		} catch(Exception e) {
			return 1;
		}
	}
	
	/**
	 * 获取下一排序号,默认排序属性为:seqNum
	 * @return
	 */
	public Integer getNextSeqNum() {
		return getNextSeqNum("seqNum");
	}
	
	protected Criteria getCriteria() {
		return getSession().createCriteria(entityClass);
	}
	
	protected Criteria getCriteria(Class<?> clazz) {
		return getSession().createCriteria(clazz);
	}
	
	/**
	 * 从配制文件获取命名sql
	 * @param name
	 * @return
	 */
	protected Query getNamedQuery(String name) {
		return getSession().getNamedQuery(name);
	}
	
	/**
	 * 快速执行命名查询
	 * @param hql
	 * @return
	 */
	protected List executeNamedQuery(String name,Object... params) {
		Query query=getSession().getNamedQuery(name);
		if(params!=null) {
			for(int i=0;i<params.length;i++) {
				query.setParameter(i, params[i]);
			}
		}
		return query.list();
	}
	
	/**
	 * 快速创建Query对象
	 * @param hql
	 * @return
	 */
	protected Query createQuery(String hql) {
		return getSession().createQuery(hql);
	}
	/**
	 * 快速创建SQLQuery对象
	 * @param sql
	 * @return
	 */
	protected SQLQuery createSQLQuery(String sql) {
		return getSession().createSQLQuery(sql);
	}
	/**
	 * 快速创建SQLQuery对象
	 * sql查询
	 * @param sql,参数数组
	 * @return List
	 */
	protected List createSqlQuery(String sql, Object...params) {
		Query query = createSQLQuery(sql);
		if (params != null) {
			for (int i=0;i<params.length;i++) {
				query.setParameter(i, params[i]);
			}
		}
		return query.list();
	}
	/**
	 * 快速执行Query对象
	 * hql查询
	 * @param hql,参数数组
	 * @return List
	 */
	protected List executeQuery(String hql,Object... params) {
		Query query=createQuery(hql);
		if(params!=null) {
			for(int i=0;i<params.length;i++) {
				query.setParameter(i, params[i]);
			}
		}
		return query.list();
	}
	
	/**
	 * 快速执行Query对象,并且分页查询
	 * hql查询
	 * @param hql,参数数组
	 * @return List
	 */
	protected List executeSqlQueryByPage(String sql, Pagination<T> page, Object... params) {
		Query query=createSQLQuery(sql);
		if(params!=null) {
			for(int i=0;i<params.length;i++) {
				query.setParameter(i, params[i]);
			}
		}
		query.setFirstResult((page.getPage()-1) * page.getPageSize());
		query.setMaxResults(page.getPage() * page.getPageSize());
		return query.list();
	}
	
	/**
	 * 快速执行sql更新
	 * @param sql sql语句,参数数组
	 * @return int 执行结果 
	 */
	protected int executeSqlUpdate(String sql, Object...params) {
		Query query = createSQLQuery(sql);
		if (params != null) {
			for (int i=0;i<params.length;i++) {
				query.setParameter(i, params[i]);
			}
		}
		return query.executeUpdate();
	}
	/**
	 * 快速执行hql更新
	 * @param hql,参数数组
	 * @return
	 */
	protected int executeUpdate(String hql,Object... params) {
		Query query=createQuery(hql);
		if(params!=null) {
			for(int i=0;i<params.length;i++) {
				query.setParameter(i, params[i]);
			}
		}
		return query.executeUpdate();
	}
	/**
	 * 获取Query
	 * @param sql,args,PagingUtil
	 * @return
	 * 要分页(list记录  跟  总记录数)---自定义分页
	 */
	public Map<String,?> getPageObjectBySql(String sql,Object[] args,PagingUtil pagingUtil){
		SQLQuery query = createSQLQuery(sql);//记录
		SQLQuery querySize = createSQLQuery("select count(1) from ("+sql+") BieMing ");//总记录数
		//参数匹配
		if (args != null) {
            for (int i = 0;i<args.length;i++) {
            	if(args[i] instanceof String){
            		query.setString(i, String.valueOf(args[i]));
            		querySize.setString(i, String.valueOf(args[i]));
            	}else if(args[i] instanceof Integer){
            		query.setInteger(i, Integer.parseInt(String.valueOf(args[i])));
            		querySize.setString(i, String.valueOf(args[i]));
            	}
            }
        }
		Map<String,Object> map = new HashMap<String,Object>();
		int size = querySize.list().size();//总记录数
		if(size>0){
			map.put("total", querySize.list().get(0));
			query.setFirstResult(pagingUtil.getPageStart());
			query.setMaxResults(pagingUtil.getRows());
			//查询结果是map对象，省去创建pojo;
			map.put("rows",query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list());
		}else{
			map.put("total",0);
			map.put("rows","");
		}
		return map;
	}
	/**
	 * 获取Query
	 * @param sql,args,
	 * @return list记录---自定义查询列表
	 */
	public List<Map<String,Object>> getListMapBySql(String sql,Object[] args){
		SQLQuery query = createSQLQuery(sql);//记录
		//参数匹配
		if (args != null) {
            for (int i = 0;i<args.length;i++) {
            	if(args[i] instanceof String){
            		query.setString(i, String.valueOf(args[i]));
            	}else if(args[i] instanceof Integer){
            		query.setInteger(i, Integer.parseInt(String.valueOf(args[i])));
            	}
            }
        }
		return query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
	}
	/**
	 * @param sql 数组
	 * 批量插入、或者更新数据
	 */
	public void batchUpdBySql(String[] sql){
		Session session = getSession();
	    int index = 1;
	    for (int i = 0; i < sql.length; i++){
	      session.createSQLQuery(sql[i]).executeUpdate();
	      if(index % 20 == 0){
	    	  session.flush();
	    	  session.clear();
	      }
	      index++;
	    }
	}
	/**
	 * 批量插入与更新数据
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void bachSaveOrUpdateObject(Collection<T> coll) {
		Session session = getSession();
		Iterator<T> it = coll.iterator();
		int index = 1;
		while(it.hasNext()){
			session.saveOrUpdate(it.next());
			if(index%20 == 0){
				session.flush();
				session.clear();
			}
			index = index+1;
		}
	}
	/**
	 * 批量插入数据
	 */
	@Override
	public void bachSaveObject(Collection<T> coll) {
		Session session = getSession();
		Iterator<T> it = coll.iterator();
		int index = 1;
		while(it.hasNext()){
			session.save(it.next());
			if(index%20 == 0){
				session.flush();
				session.clear();
			}
			index = index+1;
		}
	}
}
