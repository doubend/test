package com.cloud.icenter.base.controller;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.core.ResolvableType;

import com.cloud.icenter.common.utils.Pagination;

public abstract class ModelAction<T> extends BaseAction {
	
	private Class<T> clazz;
	public ModelAction() {
		ResolvableType resolvableType = ResolvableType.forClass(getClass());
		this.clazz=(Class<T>) resolvableType.getSuperType().getGeneric(0).resolve();
	}
	
	/**
	 * 获取页号
	 * @return
	 */
	public int getPage() {
		return getIntParameter("page", 1);
	}
	
	/**
	 * 获取每页查询多少行
	 * @return
	 */
	public int getPageSize() {
		return getIntParameter("rows", Pagination.DEFAULT_PAGE_SIZE);
	}

	/**
	 * 获取分页器
	 * @return
	 */
	public Pagination<T> getPagination() {
		Pagination<T> pagin=(Pagination<T>) getAttribute("pagin");
		if(pagin==null) {
			pagin=new Pagination<T>(getPage(),getPageSize());
			pagin.buildCriteria(clazz);
			setAttribute("pagin", pagin);
		}
		return pagin;
	}
	
	/**
	 * 获取分页器
	 * @return
	 */
	public <E> Pagination<E> newPagination(Class<E> e) {
		Pagination<E> pagin=new Pagination<E>(getPage(),getPageSize());
		pagin.buildCriteria(e);
		return pagin;
	}
	
	public T getModel() {
		T model=(T) getAttribute("model");
		if(model==null) {
			try {
				model = clazz.newInstance();
				BeanUtils.populate(model, getRequest().getParameterMap());
				setAttribute("model", model);
			} catch (Exception e) {
				throw new RuntimeException("获取模型对象失败!", e);
			}
		}
		return model;
	}
	
	/**
	 * 快速获取id参数
	 * @return
	 */
	protected String getId() {
		return getParameter("id");
	}
}
