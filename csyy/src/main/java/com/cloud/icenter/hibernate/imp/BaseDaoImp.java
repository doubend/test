package com.cloud.icenter.hibernate.imp;


import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.hibernate.IDAO;
import com.cloud.icenter.common.util.Pagination;
import com.cloud.icenter.common.util.QueryCondition;
import com.cloud.icenter.common.util.ReflectUtil;


/**
 * 
* @ClassName: BaseDaoImp 
* @Description: TODO(这里用一句话描述这个类的作用) 
* 底层基础DAO实现类
* @author Chen_JIAN
* @date 2015年7月10日 下午2:26:24 
* @param <M>
* @param <QM>
* @param <PK>
 */
@Repository
public abstract class BaseDaoImp<M ,PK extends Serializable> implements IDAO<M, PK> {
	
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public M save(M entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public void batSave(List<M> entity) {
       for (M m : entity) {
		
    	   this.save(m);
	}
	}

	@Override
	public void update(Object entity) {
	   em.refresh(entity);
	}

	@Override
	public M megre(M entity) throws Exception {
		return em.merge(entity);
	}

	@Override
	public int megre(String propertyName, Object value, Map<String, Object> pams) {
		StringBuffer JPQ = new StringBuffer(" update  " + getEntityName()
				+ " as entity set");
		if (pams == null || pams.size() == 0) {
			return 0;
		}
		Set<String> key = pams.keySet();
		for (String string : key) {
			JPQ.append("entity.").append(string).append("=")
					.append(pams.get(string)).append(",");
		}
		JPQ.deleteCharAt(JPQ.length() - 1);// 去掉最后一个逗号
		JPQ.append(" where entity.").append(propertyName).append("=:")
				.append(propertyName);
		return em.createQuery(JPQ.toString()).setParameter(propertyName, value)
				.executeUpdate();
	}

	@Override
	public void delete(Class<M> clazz, PK id) {
		M entity = em.find(clazz, id);
		if (entity != null) {
			em.remove(entity);
		}		
	}

	@Override
	public void delete(M entity) {
       em.refresh(entity);		
	}

	@Override
	public void delete(Class<M> clazz, Object[] ids) {
	    M entity = null;
        for(Object id : ids) {
            entity = em.find(clazz, id);
            em.remove(entity);
        }		
	}

	public int delByKeys(String keyName, Object value) {
		StringBuffer JPQ = new StringBuffer(" delete from " + getEntityName()
				+ " as entity");
		JPQ.append(" where entity.").append(keyName).append(" in (")
				.append(value).append(")");
		//System.out.println(JPQ.toString());
		return em.createQuery(JPQ.toString()).executeUpdate();
	}
	@Override
	public M getById(Class<M> clazz, PK id) {
		return em.find(clazz, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<M> getAll(Class<M> clazz) {
	     String className = clazz.getSimpleName();
	        StringBuffer jpql = new StringBuffer("select o from ");
	        jpql.append(className).append(" o ");
	        return em.createQuery(jpql.toString()).getResultList();
	}


	@Override
	public Object getUniqueResultByJpql(String jpql, Object... objects) {
		Query query = em.createQuery(jpql);
        if (objects != null) {
        	 for(int i = 0,position=1 ; i < objects.length ; i ++,position++){
	                query.setParameter(position, objects[i]);
	            }
        }
        return query.getSingleResult();
	}
	
	



	/**
	 * 获取值对象名称
	 * @return
	 */
	private String getEntityName() {
		return ReflectUtil.<Class<M>>getModelClass(this.getClass(), 0).getSimpleName();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<M> get(Class<M> clazz, List<QueryCondition> queryConditions,
			String orderBy, int currentPage, int pageSize) {
		 Query query = getQuery(clazz, queryConditions, orderBy, false);
	        if(currentPage == 0 && pageSize == 0) {
	            return query.getResultList();
	        }else {
	            return query.setFirstResult((currentPage-1)*pageSize).setMaxResults(pageSize).getResultList();
	        }
	        
	}

	@Override
	public List<M> get(Class<M> clazz, List<QueryCondition> queryConditions) {
		 return get(clazz, queryConditions, null, 0, 0);
	}

	@Override
	public List<M> get(Class<M> clazz, List<QueryCondition> queryConditions,
			String orderBy) {
		 return get(clazz, queryConditions, orderBy, 0, 0);
	}

	@Override
	public Object getSingleResult(Class<M> clazz,
			List<QueryCondition> queryConditions) {
	     Query query = getQuery(clazz, queryConditions, null, false);
	        return query.getSingleResult();
	}

	@Override
	public long getRecordCount(Class<M> clazz,
			List<QueryCondition> queryConditions) {
		 Query query = getQuery(clazz, queryConditions, null, true);
	        Object result = query.getSingleResult();
	        long recordCount = 0L;
	        if(result != null) {
	            recordCount = ((Long)result).longValue();
	        }
	        return recordCount;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<M> getByJPQL(String jpql, Object... objects) {
		 Query query = em.createQuery(jpql);
	        if(objects != null) {
	            if (objects != null) {
	            	 for(int i = 0,position=1 ; i < objects.length ; i ++,position++){
	 	                query.setParameter(position, objects[i]);
	 	            }
	            }
	        }
	        return query.getResultList();
	}

	@Override
	public int executeJpql(String jpql, Object... objects) {
		  Query query = em.createQuery(jpql);
	        if (objects != null) {
	            for(int i = 0,position=1 ; i < objects.length ; i ++,position++){
	                query.setParameter(position, objects[i]);
	            }
	        }
	        return query.executeUpdate();
	}

	@Override
	public Pagination<M> getPagination(Class<M> clazz,
			List<QueryCondition> queryConditions, String orderBy,
			int currentPage, int pageSize) {
		 List<M> recordList = get(clazz, queryConditions, orderBy, currentPage, pageSize);
	        long recordCount = getRecordCount(clazz, queryConditions);
	        return new Pagination<M>(currentPage, pageSize, recordCount, recordList);
	}
	

	@Override
	public Query getQuery(Class<M> clazz, List<QueryCondition> queryConditions,
			String orderBy, boolean isQueryMotal) {
        String className = clazz.getSimpleName();
        String preJPQL = isQueryMotal?"select count(*) from ":"select o from ";
        StringBuffer jpql = new StringBuffer(preJPQL);
        jpql.append(className).append(" o where 1=1 ");
        Query query = null;
        if(queryConditions != null && queryConditions.size() > 0) {
            //构造jpql语句
            Iterator<QueryCondition> iterator = queryConditions.iterator();
            while(iterator.hasNext()) {
                QueryCondition queryCondition = iterator.next();
                if(queryCondition!=null) {
                    if(queryCondition.getOperator().equals(QueryCondition.CUSTOM)) {
                        jpql.append(" and (").append(queryCondition.getCustomJPQL()).append(")");
                    }
                    if(queryCondition.getValue() != null && !"".equals(queryCondition.getValue())) {
                    	
                        //如果占位符名称是*.*格式，则换成*_*格式。且：和名称之间不能有空格
//                        String placeholder = queryCondition.getField().indexOf(".")!=-1 ? queryCondition.getField().replace(".", "_"):queryCondition.getField();
                            jpql.append(" and o.").append(queryCondition.getField().trim());
                              //处理前后缀模糊匹配操作符
                             if(queryCondition.getOperator().equals(QueryCondition.PQ)){
                            	 jpql.append(" ").append(QueryCondition.LK).append("?");//append(":").append(placeholder.trim());
                            }else if(queryCondition.getOperator().equals(QueryCondition.SQ)){
                            	 jpql.append(" ").append(QueryCondition.LK).append("?");//.append(placeholder.trim());
                            }else{
                            	 jpql.append(" ").append(queryCondition.getOperator()).append("?");//.append(placeholder.trim());
                            }
                           
                    }
                }
                
            }
        }
        if(StringUtils.isNotBlank(orderBy)) {
            jpql.append(" ").append("order by ").append(orderBy);
        }
        
        query = em.createQuery(jpql.toString());
        
        if(queryConditions != null && queryConditions.size() > 0) {
            //为参数赋值
            Iterator<QueryCondition> iterator2 = queryConditions.iterator();
            int position=0;
            while(iterator2.hasNext()) {
            
                QueryCondition queryCondition = iterator2.next();
                if(queryCondition!=null) {
                	  if(queryCondition.getOperator().equals(QueryCondition.CUSTOM)) {
                		   continue;
                	  }
                		position++;
                    if(queryCondition.getValue() != null && !"".equals(queryCondition.getValue())) {
                        //将占位符中的.替换成_
                        queryCondition.setField(queryCondition.getField().indexOf(".") != -1 ? queryCondition.getField().replace(".", "_"):queryCondition.getField());
                    	//全模糊匹配
                        if(queryCondition.getOperator().equals(QueryCondition.LK)) {
                            query.setParameter(position, "%"+queryCondition.getValue()+"%");
                          //前缀模糊匹配  
                        }else if(queryCondition.getOperator().equals(QueryCondition.PQ)){
                        	 query.setParameter(position, queryCondition.getValue()+"%");
                        	//后缀模糊匹配
                        }else if(queryCondition.getOperator().equals(QueryCondition.SQ)){
                        	 query.setParameter(position, "%"+queryCondition.getValue());
                        }else {
//                            query.setParameter(queryCondition.getField(), queryCondition.getValue());
                        	query.setParameter(position, queryCondition.getValue());
                        
                        }
                    }
                }
                
            }
        }
        return query;
    }

	@Override
	public List<?> getByJPQL(String jpql, Class<?> clazz, Object... objects) {
		 Query query = em.createQuery(jpql,clazz);
	     
	            if (objects != null) {
	            	 for(int i = 0,position=1 ; i < objects.length ; i ++,position++){
	 	                query.setParameter(position, objects[i]);
	 	            }
	            }
	    
	        return query.getResultList();
	}

	@Override
	public List<?> querySQLTOBean(String sql, Class<?> clazz, Object... objects) {
		// TODO Auto-generated method stub
		if(StringUtils.isNotBlank(sql)){
			 Query query =em.createNativeQuery(sql);
			 for(int i = 0,position=1 ; i < objects.length ; i ++,position++){
	                query.setParameter(position, objects[i]);
	            }
			 query.unwrap(SQLQuery.class).setResultTransformer(Transformers.aliasToBean(clazz));
			 return query.getResultList();
		}
		return null;
	}
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
}
