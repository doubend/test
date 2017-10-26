package com.cloud.icenter.hibernate;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import com.cloud.icenter.common.util.Pagination;
import com.cloud.icenter.common.util.QueryCondition;
/** 
* @ClassName: IDAO 
* @Description: TODO(这里用一句话描述这个类的作用) 
* 底层基础DAO接口
* @author Chen_JIAN
* @date 2015年7月10日 下午1:33:01 
* @param <M> 对象实体
* @param <QM> 条件查询封装对象
* @param <PK> 实体主键
 */
public interface IDAO< M ,PK extends Serializable> {
    
    /**
     * 新增实体
     * @param entity  要新增的实体
     */
    public M save(M entity);
    
    /**
     * batSave(这里用一句话描述这个方法的作用)
     * 批量新增实体
     * @param entity void
     * @exception 
     * @version  1.0.0
     * @date 2015年7月10日 
     *
     */
    public void batSave(List<M>entity);
    
    /**
     * 更新实体
     * @param entity  要更新的实体
     */
    public void update(Object entity);
    
    /**
     * 
     * megre(这里用一句话描述这个方法的作用)
     * 
     * @param entity
     * @return
     * @throws Exception M
     * @exception 
     * @version  1.0.0
     * @date 2015年7月10日 
     *
     */
	public abstract M megre(M entity) throws Exception;
    
	/**
	 * 根据实体属性进行更新实体
	 * @param propertyName 属性名称
	 * @param value       属性值
	 * @param pams    要进行更新的属性参数以及数值   Map
	 *  key-要更新的属性名称    value-要更新的属性的数值
	 * @return
	 */
	public abstract int megre(String propertyName, Object value,Map<String, Object> pams);
    
    /**
     * 根据主键删除实体
     * @param <T>
     * @param clazz   实体类的Class
     * @param id      主键
     */
    public  void delete(Class<M> clazz,PK  id);
    
    public void delete(M clazz);
    
    /**
     * 根据主键批量删除实体
     * @param <T>
     * @param clazz   实体类的Class
     * @param id      主键数组
     */
    public  void delete(Class<M> clazz,Object[] ids);
    
    /**
     * 
     * delByKeys(这里用一句话描述这个方法的作用)
     * 
     * @param keyName
     * @param value
     * @return int
     * @exception 
     * @version  1.0.0
     * @date 2015年7月20日 
     *
     */
	public int delByKeys(String keyName, Object value) ;
    
    /**
     * 根据主键查询
     * @param <T>
     * @param clazz  实体类的Class
     * @param id     主键
     * @return
     */
    public  M getById(Class<M> clazz,PK id);
    
    /**
     * 查询所有记录
     * @param <T>
     * @param clazz 实体类的Class
     * @return
     */
    public  List<M> getAll(Class<M> clazz);
    
    
    /**
     * 根据条件集合查询记录
     * @param <T>
     * @param clazz
     * @param queryConditions 查询条件集合
     * @param orderBy         排序,如 order by id desc
     * @param currentPage     当前页
     * @param pageSize        每页显示记录数
     * @return 
     */
    public  List<M> get(Class<M> clazz,List<QueryCondition> queryConditions,String orderBy,int currentPage,int pageSize);
    
    
    /**
     * 根据条件集合查询记录
     * @param <T>
     * @param clazz
     * @param queryConditions  查询条件集合
     * @return
     */
    public  List<M> get(Class<M> clazz,List<QueryCondition> queryConditions);
    
    /**
     * 根据条件集合查询记录
     * @param <T>
     * @param clazz
     * @param queryConditions  查询条件集合
     * @param orderBy          排序,如 order by id desc
     * @return
     */
    public  List<M> get(Class<M> clazz,List<QueryCondition> queryConditions,String orderBy);
    
    /**
     * 根据条件集合查询单条记录
     * @param clazz
     * @param queryConditions  查询条件集合
     * @return
     */
    public  Object getSingleResult(Class<M> clazz,List<QueryCondition> queryConditions);
    
    /**
     * 根据条件查询记录数量
     * @param clazz
     * @param queryConditions  查询条件集合
     * @return
     */
    public long getRecordCount(Class<M> clazz,List<QueryCondition> queryConditions);
    
    /**
     * 根据jpql查询
     * @param <T>
     * @param jpql
     * @param objects
     * @return
     */
    public  List<M> getByJPQL(String jpql,Object...objects);
    
    
    /**
     * 
     * getByJPQL(这里用一句话描述这个方法的作用)
     * jpql查询
     * 根据指定的实体封装结果集
     * 
     * @param jpql
     * @param clazz
     * @param objects
     * @return List<?>
     * @exception 
     * @version  1.0.0
     * @date 2015年8月7日 
     *
     */
    public  List<?> getByJPQL(String jpql,Class<?>clazz,Object...objects);
    
    /**
     * 执行jpql语句
     * @param jpql
     * @param objects
     * @return
     */
    public int executeJpql(String jpql,Object...objects);
    
    /**
     * 分页查询
     * @param <T>
     * @param clazz
     * @param queryConditions   查询条件集合
     * @param orderBy           排序字段 如：order by id desc
     * @param currentPage       当前页
     * @param pageSize          每页显示记录数
     * @return
     */
    public  Pagination<M> getPagination(Class<M> clazz,List<QueryCondition> queryConditions,String orderBy,int currentPage,int pageSize);
    
    /**
     * 查找唯一结果
     * @param jpql
     * @param objects
     * @return
     */
    public Object getUniqueResultByJpql(String jpql,Object...objects);
    
    /**
     * 
     * getQuery(这里用一句话描述这个方法的作用)
     *  组装查询条件返回 Query对象
     * @param clazz
     * @param queryConditions
     * @param orderBy
     * @param isQueryMotal 是否查询记录总数, true 则查询记录总数
     * @return Query
     * @exception 
     * @version  1.0.0
     * @date 2015年7月10日 
     *
     */
    public  Query getQuery(Class<M> clazz, List<QueryCondition> queryConditions,String orderBy,boolean isQueryMotal);
    
    /***
     * 
     * querySQLTOBean(这里用一句话描述这个方法的作用)
     * 执行原生SQL指定实体封装结果集
     * 
     * @param sql
     * @param clazz
     * @param parms
     * @return List<?>
     * @exception 
     * @version  1.0.0
     * @date 2015年8月7日 
     *
     */
    
    
    public List<?>querySQLTOBean(String sql,Class<?>clazz,Object ...parms);
    
    
    


}
