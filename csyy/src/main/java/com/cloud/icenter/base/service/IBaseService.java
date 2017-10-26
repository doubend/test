package com.cloud.icenter.base.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.cloud.icenter.common.util.Pagination;
import com.cloud.icenter.common.util.QueryCondition;

/**
 * 
* @ClassName: IBaseService 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Chen_JIAN
* @date 2015年7月10日 下午4:24:20 
*  公共基础业务接口
* @param <M>
* @param <QM>
* @param <PK>
 */
public interface IBaseService<M,QM extends M,PK extends Serializable>  {
    
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
	public int delByKeys(String keyName, Object value) ;
    public void delete(M clazz);
    
    /**
     * 根据主键批量删除实体
     * @param <T>
     * @param clazz   实体类的Class
     * @param id      主键数组
     */
    public  void delete(Class<M> clazz,Object[] ids);
    
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
    public  List<M> get(Class<M> clazz,QM queryConditions,String orderBy,int currentPage,int pageSize);
    
    
    /**
     * 根据条件集合查询记录
     * @param <T>
     * @param clazz
     * @param queryConditions  查询条件集合
     * @return
     */
    public  List<M> get(Class<M> clazz,QM queryConditions);
    
    /**
     * 根据条件集合查询记录
     * @param <T>
     * @param clazz
     * @param queryConditions  查询条件集合
     * @param orderBy          排序,如 order by id desc
     * @return
     */
    public  List<M> get(Class<M> clazz,QM queryConditions,String orderBy);
    
    /**
     * 根据条件集合查询单条记录
     * @param clazz
     * @param queryConditions  查询条件集合
     * @return
     */
    public  Object getSingleResult(Class<M> clazz,QM queryConditions);
    
    /**
     * 根据条件查询记录数量
     * @param clazz
     * @param queryConditions  查询条件集合
     * @return
     */
    public long getRecordCount(Class<M> clazz,QM queryConditions);
    
    /**
     * 根据jpql查询
     * @param <T>
     * @param jpql
     * @param objects
     * @return
     */
    public  List<M> getByJPQL(String jpql,Object...objects);
    public  List<?> getByJPQL(String jpql,Class<?> clazz,Object...objects);
    
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
     * @param orderBy           排序字段 如： id desc
     * @param currentPage       当前页
     * @param pageSize          每页显示记录数
     * @return
     */
    public  Pagination<M> getPagination(Class<M> clazz,QM queryConditions,String orderBy,int currentPage,int pageSize);
    
    /**
     * 查找唯一结果
     * @param jpql
     * @param objects
     * @return
     */
    public Object getUniqueResultByJpql(String jpql,Object...objects);
    
    /**
     * 
     * builderByCondition(这里用一句话描述这个方法的作用)
     * 根据查询条件实体
     * 组装条件查询对象
     * @param queryConditions
     * @return List<QueryCondition>
     * @exception 
     * @version  1.0.0
     * @date 2015年7月10日 
     *
     */
    public List<QueryCondition> builderByCondition(QM queryConditions);
  
    
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
