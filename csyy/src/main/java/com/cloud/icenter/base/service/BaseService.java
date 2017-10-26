package com.cloud.icenter.base.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.cloud.icenter.common.utils.Pagination;

/**
 * service基础接口,定义了基本的增删改查方法
 * @author zhangle
 * @param <T>
 */
public interface BaseService<T> {

	public T get(String id);
	
	public T get(Long id);
	
	public void add(T obj);
	
	public String save(T obj);
	
	public void update(T obj);
	
	public void delete(String id);
	
	public void delete(Long id);
	
	public void logicDelete(String id);
	
	public void logicDeleted(String id);
	
	public void logicDel(String id);
	
	public List<?> find(DetachedCriteria criteria);
	
	public void find(Pagination<T> pagin);
}
