package com.cloud.icenter.base.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.base.service.BaseService;
import com.cloud.icenter.common.utils.Pagination;

/**
 * service基础实现类,实现了基础的增删改查方法
 * 
 * @author zhangle
 * @param <T>
 */
@Transactional
public abstract class BaseServiceImpl<T> implements BaseService<T> {

	@Autowired
	protected BaseDao<T> baseDao;

	/**
	 * getBaseDao()的默认实现,子类可覆盖此方法
	 * 
	 * @return
	 */
	protected BaseDao<T> getBaseDao() {
		return baseDao;
	}

	@Override
	public void add(T obj) {
		getBaseDao().add(obj);
	}

	@Override
	public String save(T obj) {
		return getBaseDao().save(obj);
	}

	@Override
	public void delete(String id) {
		getBaseDao().delete(id);
	}

	@Override
	public void delete(Long id) {
		getBaseDao().delete(id);
	}

	@Override
	public void logicDelete(String id) {
		getBaseDao().logicDelete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public T get(String id) {
		T obj = getBaseDao().get(id);
		return obj;
	}

	@Override
	@Transactional(readOnly = true)
	public T get(Long id) {
		T obj = getBaseDao().get(id);
		return obj;
	}

	@Override
	public void update(T obj) {
		getBaseDao().update(obj);
	}

	@Override
	public void logicDeleted(String id) {
		getBaseDao().logicDeleted(id);
	}

	@Override
	public void logicDel(String id) {
		getBaseDao().logicDel(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<T> find(DetachedCriteria criteria) {
		return getBaseDao().find(criteria);
	}

	@Override
	@Transactional(readOnly = true)
	public void find(Pagination<T> pagin) {
		getBaseDao().find(pagin);
	}
}
