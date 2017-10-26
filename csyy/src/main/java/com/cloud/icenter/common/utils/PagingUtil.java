package com.cloud.icenter.common.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @description 自定义分页
 * @author wangbin
 * @date 2015/12/22
 *
 */
public class PagingUtil {

	public static final int MAX_PAGE_SIZE = 50;// 每页最大记录数限制

	private int page = 1;// 当前页
	private int pages = 0;// 总页数
	private int rows = 15;// 每页记录数
	private int total = 0;// 总记录数

	private int pageStart;// 分页开始数

	private List<Object> list;// 数据List

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if (page < 1) {
			page = 1;
		}
		this.page = page;
	}

	public int getPages() {
		pages = this.getTotal() / this.getRows();
		if (this.getTotal() % this.getRows() > 0) {
			pages++;
		}
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		if (rows < 1) {
			rows = 1;
		} else if (rows > MAX_PAGE_SIZE) {
			rows = MAX_PAGE_SIZE;
		}
		this.rows = rows;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPageStart() {
		return (page - 1) * rows;
	}

	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}

	public List<Object> getList() {
		return list;
	}

	public void setList(List<Object> list) {
		this.list = list;
	}

	/**
	  *
	  * @param pageNo 当前页码
	  * @param pageSize 页数
	  * @param list  所有集合
	  * @return
	  * @throws Exception
	  */
	public static List<?> page(int pageNo, int pageSize, List<?> list)
			throws Exception {
		List<Object> result = new ArrayList<Object>();
		if (list != null && list.size() > 0) {
			int allCount = list.size();
			int pageCount = (allCount + pageSize - 1) / pageSize;
			if (pageNo >= pageCount) {
				pageNo = pageCount;
			}
			int start = (pageNo - 1) * pageSize;
			int end = pageNo * pageSize;
			if (end >= allCount) {
				end = allCount;
			}
			for (int i = start; i < end; i++) {
				result.add(list.get(i));
			}
		}
		return result;
	}
	
}
