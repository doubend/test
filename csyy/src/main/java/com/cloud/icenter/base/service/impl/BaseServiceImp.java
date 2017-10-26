package com.cloud.icenter.base.service.impl;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.icenter.hibernate.IDAO;
import com.cloud.icenter.common.util.Pagination;
import com.cloud.icenter.common.util.QueryCondition;
import com.cloud.icenter.common.util.Custom;
import com.cloud.icenter.common.util.Ignore;
import com.cloud.icenter.common.util.QueryOper;
import com.cloud.icenter.base.service.IBaseService;
import com.cloud.icenter.base.service.ISQLService;

/**
 * 
* @ClassName: BaseServiceImp 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Chen_JIAN
* @date 2015年7月10日 下午4:36:17 
* 基础抽象业务实现类
* @param <M> 
* @param <QM> 页面查询条件封装对象
* @param <PK>
 */

@Transactional
@Service
public  abstract class BaseServiceImp<M, QM extends M, PK extends Serializable> implements IBaseService<M, QM, PK> {

	private Logger log=Logger.getLogger(getClass());
	private IDAO<M, PK>  baseDAO;
	@Resource(name="SQLServiceImp")
	private ISQLService  sqlService;
	
	
	public ISQLService getSqlService() {
		return sqlService;
	}

	public void setSqlService(ISQLService sqlService) {
		this.sqlService = sqlService;
	}

	public IDAO<M, PK> getBaseDAO() {
		return baseDAO;
	}

	public void setBaseDAO(IDAO<M, PK> baseDAO) {
		this.baseDAO = baseDAO;
	}

	@Override
	public M save(M entity) {
		return baseDAO.save(entity);
	}

	@Override
	public void batSave(List<M> entity) {
        baseDAO.batSave(entity);		
	}

	@Override
	public void update(Object entity) {
		baseDAO.update(entity);		
	}

	@Override
	public M megre(M entity) throws Exception {
		return baseDAO.megre(entity);
	}

	@Override
	public int megre(String propertyName, Object value, Map<String, Object> pams) {
		return baseDAO.megre(propertyName, value, pams);
	}

	@Override
	public void delete(Class<M> clazz, PK id) {
          baseDAO.delete(clazz, id);
          
	}

	@Override
	public void delete(M clazz) {
         baseDAO.delete(clazz);
         
	}

	@Override
	public void delete(Class<M> clazz, Object[] ids) {
       baseDAO.delete(clazz, ids);		
	}

	@Override
	public M getById(Class<M> clazz, PK id) {
		return baseDAO.getById(clazz, id);
	}

	@Override
	public List<M> getAll(Class<M> clazz) {
		return baseDAO.getAll(clazz);
	}

	@Override
	public List<M> get(Class<M> clazz, QM queryConditions, String orderBy,
			int currentPage, int pageSize) {
		return baseDAO.get(clazz, builderByCondition(queryConditions), orderBy, currentPage, pageSize);
	}

	@Override
	public List<M> get(Class<M> clazz, QM queryConditions) {
		return baseDAO.get(clazz, builderByCondition(queryConditions));
	}

	@Override
	public List<M> get(Class<M> clazz, QM queryConditions, String orderBy) {
		return baseDAO.get(clazz, builderByCondition(queryConditions), orderBy);
	}

	@Override
	public Object getSingleResult(Class<M> clazz, QM queryConditions) {
		return baseDAO.getSingleResult(clazz, builderByCondition(queryConditions));
	}

	@Override
	public long getRecordCount(Class<M> clazz, QM queryConditions) {
		return baseDAO.getRecordCount(clazz,builderByCondition(queryConditions));
	}

	@Override
	public List<M> getByJPQL(String jpql, Object... objects) {
		return baseDAO.getByJPQL(jpql, objects);
	}

	@Override
	public int executeJpql(String jpql, Object... objects) {
		return baseDAO.executeJpql(jpql, objects);
	}

	@Override
	public Pagination<M> getPagination(Class<M> clazz, QM queryConditions,
			String orderBy, int currentPage, int pageSize) {
		return baseDAO.getPagination(clazz,builderByCondition(queryConditions), orderBy, currentPage, pageSize);
	}

	@Override
	public Object getUniqueResultByJpql(String jpql, Object... objects) {
		
		return baseDAO.getUniqueResultByJpql(jpql, objects);
	}

	@Override
	public List<QueryCondition> builderByCondition(QM queryConditions) {
		List<QueryCondition>  list=null;
		if(queryConditions!=null){
			try {
				list=builderByCondition(queryConditions,queryConditions.getClass());
				list.addAll(builderByCondition(queryConditions,queryConditions.getClass().getSuperclass()));		
			} catch (Exception e) {
				log.error("组装查询对象出现异常！"+e.getMessage());
			}
		  
		}
		return list;
	}
	
	public List<QueryCondition> builderByCondition(QM queryModel,Class<?> queryConditions) throws Exception{
//		System.out.println(">>>>>>>"+queryConditions.getSimpleName());
		List<QueryCondition>  list=new ArrayList<QueryCondition>(0);
		  Field[] modelFields= queryConditions.getDeclaredFields();
		  String type=null;
		  Object value=null;
		  for (Field field : modelFields) {
				field.setAccessible(true);
			  value=this.getFieldvalue(field, queryModel);
			    if(field.isAnnotationPresent(Ignore.class)||field.getName().equals("serialVersionUID")||value==null){
			    	continue;
			    }
			    type = field.getType().getSimpleName();	
			    System.out.println(field.getName()+">>>"+type);
				if (type.equals("Set") || type.equals("List") || type.equals("Map")) {
					continue;
				}
//				System.out.println(field.getName()+">>>>>>>>>>>"+value);
				
			  QueryCondition query=new QueryCondition();
			
			  //判断属性上是否有自定义查询标注，如果有则根据标注获取相关的操作符和字段名
			  if(field.isAnnotationPresent(QueryOper.class)){
	    		  QueryOper queryOper= field.getAnnotation(QueryOper.class);
	    		  query.setOperator(queryOper.formula());
	    		  //看是否有自定义字段名（例如区间查询的时候就会设置）
	    		  if(StringUtils.isNotBlank(queryOper.field())){
	    			  query.setField(queryOper.field());
	    		  }else{
	    			  query.setField(field.getName()); 
	    		  }
	    		  query.setValue(value);
	    	  }else if(field.isAnnotationPresent(Custom.class)){
	    		  query.setOperator(QueryCondition.CUSTOM);
	    		  query.setCustomJPQL(String.valueOf(value));
	    		  
	    	  }else{
	    		  query.setField(field.getName());
	    		  //默认操作符设置为=
	    		  query.setOperator("=");
	    		  query.setValue(value);
	    	  }
			  list.add(query);
		}
		
		return list;
		
		
	}

	@Override
	public int delByKeys(String keyName, Object value) {
		return this.baseDAO.delByKeys(keyName, value);
	}
	private Object getFieldvalue(Field field,Object obj ){
		field.setAccessible(true);
		Object  val=null;
		  try {
			  val=field.get(obj);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
					e.printStackTrace();
		}
		  return val;
	}

	@Override
	public List<?> getByJPQL(String jpql, Class<?> clazz, Object... objects) {
	       
		return this.baseDAO.getByJPQL(jpql, clazz, objects);
	}

	@Override
	public List<?> querySQLTOBean(String sql, Class<?> clazz, Object... parms) {
		return this.baseDAO.querySQLTOBean(sql, clazz, parms);
	}
}
