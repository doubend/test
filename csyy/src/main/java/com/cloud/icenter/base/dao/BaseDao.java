package com.cloud.icenter.base.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.cloud.icenter.common.utils.Pagination;

/**
 * dao基础接口
 * @author zhangle
 * @param <T>
 */
public interface BaseDao<T> {
	
	public T get(String id);
	
	public T get(Long id);
	
	public void add(T po);
	
	public String save(T po);
	
	public void update(T po);
	
	public void delete(String id);
	
	public void delete(Long id);
	
	public void logicDelete(String id);
	
	public List<T> find(DetachedCriteria criteria);
	
	public void find(Pagination<T> pagin);
	
	/**
	 * @param id
	 * 逻辑删除，删除字段名称为deleted，数据类型位整型
	 */
	public void logicDeleted(String id);
	
	public void logicDel(String id);
	
	//批量新增
	public void bachSaveObject(Collection<T> coll);
	
	public void batchUpdBySql(String[] sql);
	//批量插入与更新
	void bachSaveOrUpdateObject(Collection<T> coll);
	
}
