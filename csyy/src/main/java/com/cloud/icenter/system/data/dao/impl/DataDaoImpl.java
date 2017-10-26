package com.cloud.icenter.system.data.dao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.base.pojo.SysDict;
import com.cloud.icenter.system.data.dao.DataDao;

@Repository
public class DataDaoImpl extends BaseDaoImpl<SysDict> implements DataDao {

	@Override
	public void add(SysDict obj) {
		obj.setSeqNum(getNextSeqNum());
		if(StringUtils.isBlank(obj.getParentId())) {
			obj.setParentId(null);
		}
		else {
			SysDict parent = get(obj.getParentId());
			if (null!=parent) {
				obj.setPath((StringUtils.isBlank(parent.getPath())?"":parent.getPath())+parent.getDictId()+"/");
			}
		}
		obj.setCreatedAt(new Date());
		super.add(obj);
	}
	
	@Override
	public void update(SysDict obj) {
		if(StringUtils.isBlank(obj.getParentId())) {
			obj.setParentId(null);
		}
		else {
			SysDict parent = get(obj.getParentId());
			if (null!=parent) {
				obj.setPath((StringUtils.isBlank(parent.getPath())?"":parent.getPath())+parent.getDictId()+"/");
			}
		}
		super.update(obj);
	}
	/**
	 * 递归删除菜单
	 */
	@Override
	public void delete(String id) {
		
		List<SysDict> datas=getChildren(id, null);
		for(SysDict m:datas) {
			if(m.getType()==SysDict.TYPE_LEAF) {	//如果是叶子节点,那么直接删除,否则是目录节点,需要递归删除所有子节点
				super.delete(m.getDictId());
			} else {
				delete(m.getDictId());
			}
		}
		super.delete(id);
	}
	
	@Override
	public List<SysDict> getChildren(String parentId,Integer status) {
		Criteria criteria=getCriteria();
		if(StringUtils.isBlank(parentId)) {
			criteria.add(Restrictions.isNull("parentId"));
		} else {
			criteria.add(Restrictions.eq("parentId", parentId));
		}
		if(status!=null) {
			criteria.add(Restrictions.eq("status", status));
		}
		criteria.addOrder(Order.asc("seqNum"));
		
		return criteria.list();
	}

	@Override
	public List<SysDict> getChildren(String code) {
		
		DetachedCriteria subquery=DetachedCriteria.forClass(SysDict.class)
				.add(Restrictions.eq("code", code))
				.add(Restrictions.eq("status", SysDict.STATUS_DEFAULT))
				.setProjection(Projections.property("id"));
		
		Criteria criteria=getCriteria()
				.add(Restrictions.eq("status", SysDict.STATUS_DEFAULT))
				.add(Subqueries.propertyEq("parentId", subquery))
				.addOrder(Order.asc("seqNum"));
		
		return criteria.list();
	}

	@Override
	public SysDict getByCode(String code) {
		if(StringUtils.isBlank(code)) return null;
		return super.get(SysDict.class, "code", code);
	}
	
	/**
	 * 根据code和value获取数据
	 * @param code
	 * @param value
	 * @return
	 */
	@Override
	public SysDict getByCode(String code,String value) {
		
		SysDict data=getByCode(code);
		if(data==null)	return null;
		
		Criteria criteria=getCriteria()
			.add(Restrictions.eq("parentId", data.getDictId()));
		if(!StringUtils.isBlank(value)){
			criteria.add(Restrictions.eq("value", value));
		}
		List<SysDict> datas=criteria.list();
		if(datas.isEmpty()) return null;
		return datas.get(0);
	}

	@Override
	public void move(String targetId, String sourceId, String point) {
		SysDict target=get(targetId);
		SysDict source=get(sourceId);
		
		if(target.getType()==SysDict.TYPE_LEAF && point.equals("append")) {
			throw new RuntimeException("移动菜单失败:叶子节点不允许追加子节点!");
		}
		
		if(point.equals("append")) {				//如果是追加操作,那么直接追加到父节点下
			source.setParentId(target.getDictId());
			source.setSeqNum(getNextSeqNum());
			update(source);
		} else {									//否则是排序操作,那么移动为与目标节点同级,再执行同级排序
			source.setParentId(target.getParentId());
			source.setSeqNum(getNextSeqNum());
			update(source);
			
			sortForMove(target, source, point);
		}
	}

	/**
	 * 为移动操作排序
	 * @param target
	 * @param source
	 * @param point
	 */
	private void sortForMove(SysDict target, SysDict source,String point) {
		List<SysDict> children=getChildren(target.getParentId(), null);
		int index=0;
		for(;index<children.size();index++) {
			SysDict m=children.get(index);
			if(target.equals(m)) {
				if(point.equals("top")) {			//插入源节点到适当的位置
					children.add(index,source);
				} else if(point.equals("bottom")) {
					children.add(index+1,source);
					index=index+1;					//保存源节点的索引号
				}
				break;
			}
		}
		children.remove(children.size()-1);			//删除重复的源节点(固定为最后一个节点),因为前面循环中,插入了一个源节点
		
		long _seqNum=source.getSeqNum();			//保存源节点的排序号
		for(;index<children.size();index++) {		//重新设置源节点和之后的节点排序号
			SysDict m=children.get(index);
			if(index<children.size()-1) {
				m.setSeqNum(children.get(index+1).getSeqNum());
			} else {
				m.setSeqNum(_seqNum);
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SysDict> getSysDictById(List<String> ids) {
		String hql = "from SysDict s where s.id in ( :ids )";
		List<SysDict> list = createQuery(hql).setParameterList("ids", ids).list();
		return list;
	}

	@Override
	public SysDict getByTextAndType(String text, int type) {
		String hql = "from SysDict s where s.text = :text and s.type = :type and s.status = :status";
		SysDict sys = (SysDict) createQuery(hql).setParameter("text", text)
												.setParameter("type", type)
												.setParameter("status", SysDict.STATUS_DEFAULT)
												.uniqueResult();
		return sys;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SysDict> getAllDict() {
		Criteria criteria=getCriteria();
		criteria.add(Restrictions.eq("status", SysDict.STATUS_DEFAULT));
		criteria.addOrder(Order.asc("seqNum"));
		return criteria.list();
	}


	

}
