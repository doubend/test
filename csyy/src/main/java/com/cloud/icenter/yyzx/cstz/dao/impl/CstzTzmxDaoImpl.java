package com.cloud.icenter.yyzx.cstz.dao.impl;

import java.util.Collection;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.cstz.dao.CstzTzmxDao;
import com.cloud.icenter.yyzx.cstz.pojo.CstzCommonPojo;
import com.cloud.icenter.yyzx.cstz.pojo.CstzTzmxPojo;
/** 
* @author zhucy 
* @version 2017年4月12日 上午9:21:38 
* 说明 
*/
@Repository
public class CstzTzmxDaoImpl extends BaseDaoImpl<CstzTzmxPojo> implements CstzTzmxDao{
	
	@Override
	public void add(CstzTzmxPojo obj) {

		if (getChild(obj.getParentId(), obj.getTzmc()) != null) {
			throw new RuntimeException("重复的体征模型名称!");
		}
		obj.setSeqNum(getNextSeqNum());
		if (StringUtils.isBlank(obj.getParentId())) {
			obj.setParentId(null);
		}
		super.add(obj);
	}

	@Override
	public void update(CstzTzmxPojo obj) {

		if (StringUtils.isBlank(obj.getParentId())) {
			obj.setParentId(null);
		}
		CstzTzmxPojo cstzTzmxPojo = getChild(obj.getParentId(), obj.getTzmc());
		if (cstzTzmxPojo == null) {
			super.update(obj);
			return;
		}

		if (cstzTzmxPojo.getId().equals(obj.getId())) {
			getSession().merge(obj);
		} else {
			throw new RuntimeException("重复的体征模型名称!");
		}

	}
	
	@Override
	public void delete(String id) {
		List<CstzTzmxPojo> list = getCriteria().add(Restrictions
				.eq("parentId", id)).list();
		if(null != list && list.size() > 0 ){
			throw new RuntimeException("此体征模型下含有子体征,请先删除子体征!");
		}
		//验证是否有关联的处理,不能执行删除操作(后续添加)
//		CstzTzmxPojo cstzTzmxPojo = get(id);
//		List<JbxxPojo> jbxxPojos = jbxxService.getListByFenlei(bjmbPojo.getDm());
//		if(null != list && list.size() > 0 ){
//			throw new RuntimeException("此分类下含有资源信息,请先删除资源信息!");
//		}
		super.delete(id);
	}
	
	
	/**
	 * 获取子节点
	 * 
	 * @param parentId
	 *            父节点id
	 * @param name
	 *            子节点名称
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private CstzTzmxPojo getChild(String parentId, String name) {
		List<CstzTzmxPojo> cstzTzmxPojos = getCriteria()
				.add(StringUtils.isBlank(parentId) ? Restrictions
						.isNull("parentId") : Restrictions.eq("parentId",
						parentId)).add(Restrictions.eq("tzmc", name))
				.add(Restrictions.eq("deleteStatus", "0")).list();
		if (cstzTzmxPojos.isEmpty())
			return null;
		return cstzTzmxPojos.get(0);
	}
	

	@Override
	public List<CstzTzmxPojo> getChildren(String parentId, String status) {
		Criteria criteria = getCriteria();
		if (StringUtils.isBlank(parentId)) {
			criteria.add(Restrictions.isNull("parentId"));
		} else {
			criteria.add(Restrictions.eq("parentId", parentId));
		}
		if (status != null) {
			criteria.add(Restrictions.eq("deleteStatus", status));
		}
		criteria.addOrder(Order.asc("seqNum"));
		return criteria.list();
	}

	@Override
	public void move(String targetId, String sourceId, String point) {
		CstzTzmxPojo target = get(targetId);
		CstzTzmxPojo source = get(sourceId);
		if (target.getType() == CstzTzmxPojo.TYPE_LEAF && point.equals("append")) {
			throw new RuntimeException("移动分类失败:叶子节点不允许追加子节点!");
		}

		if (point.equals("append")) { // 如果是追加操作,那么直接追加到父节点下
			source.setParentId(target.getId());
			source.setSeqNum(getNextSeqNum());
			update(source);
		} else { // 否则是排序操作,那么移动为与目标节点同级,再执行同级排序
			source.setParentId(target.getParentId());
			source.setSeqNum(getNextSeqNum());
			update(source);

			sortForMove(target, source, point);
		}
		
	}

	@Override
	public boolean checkTzmc(String tzmc) {
		if(StringUtils.isBlank(tzmc)) 
			return false;
		Criteria criteria = getCriteria();
		criteria.add(Restrictions.eq("tzmc", tzmc));
		return criteria.list().size() > 0;
	}

	@Override
	public CstzTzmxPojo getCstzTzmxPojoById(String id) {
		List<CstzTzmxPojo> list = getCriteria().add(
				Restrictions.eq("id", id)).list();
		if (null != list && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	
	
	/**
	 * 为移动操作排序
	 * 
	 * @param target
	 * @param source
	 * @param point
	 */
	private void sortForMove(CstzTzmxPojo target, CstzTzmxPojo source, String point) {
		List<CstzTzmxPojo> children = getChildren(target.getParentId(), null);
		int index = 0;
		for (; index < children.size(); index++) {
			CstzTzmxPojo f = children.get(index);
			if (target.equals(f)) {
				if (point.equals("top")) { // 插入源节点到适当的位置
					children.add(index, source);
				} else if (point.equals("bottom")) {
					children.add(index + 1, source);
					index = index + 1; // 保存源节点的索引号
				}
				break;
			}
		}
		children.remove(children.size() - 1); // 删除重复的源节点(固定为最后一个节点),因为前面循环中,插入了一个源节点

		Integer _seqNum = source.getSeqNum(); // 保存源节点的排序号
		for (; index < children.size(); index++) { // 重新设置源节点和之后的节点排序号
			CstzTzmxPojo f = children.get(index);
			if (index < children.size() - 1) {
				f.setSeqNum(children.get(index + 1).getSeqNum());
			} else {
				f.setSeqNum(_seqNum);
			}
		}
	}

	@Override
	public boolean checkYwtzId(String ywtzId) {
		if(StringUtils.isBlank(ywtzId)) 
			return false;
		Criteria criteria = getCriteria();
		criteria.add(Restrictions.eq("ywtzId", ywtzId)).add(Restrictions.eqOrIsNull("deleteStatus", "0"));
		return criteria.list().size() > 0;
	}
	
	/**
	 * 批量更新权重
	 */
	@Override
	public void bachSaveOrUpdateObject(Collection<CstzTzmxPojo> coll) {
		// TODO Auto-generated method stub
		super.bachSaveOrUpdateObject(coll);
	}
	
	/**
	 * 获取最大排序值
	 * @return
	 */
	public int getMaxXssx(){
		String sql = "SELECT MAX(xssx) AS seqNum FROM t_cstz_tzmx ";
		try {
			Query query = createSQLQuery(sql);
			query.setResultTransformer(Transformers.aliasToBean(CstzTzmxPojo.class));
			List<CstzTzmxPojo> list = query.list();
			if (null != list && list.size() > 0 ) {
				int seqNum = list.get(0).getSeqNum();
				return seqNum+1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 57;
	}

}
