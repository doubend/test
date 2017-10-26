package com.cloud.icenter.yyzx.cszc.zygl.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.cszc.zygl.dao.BjmbDao;
import com.cloud.icenter.yyzx.cszc.zygl.pojo.BjmbPojo;
import com.cloud.icenter.yyzx.cszc.zygl.pojo.JbxxPojo;
import com.cloud.icenter.yyzx.cszc.zygl.service.JbxxService;

/** 
* @author zhucy 
* @version 2017年3月24日 下午2:09:25 
* 资源分类>部件码表
*/
@Repository
public class BjmbDaoImpl extends BaseDaoImpl<BjmbPojo> implements BjmbDao{
	
	@Autowired
	private JbxxService jbxxService;
	
	@Override
	public void add(BjmbPojo obj) {

		if (getChild(obj.getSjbh(), obj.getMc()) != null) {
			throw new RuntimeException("重复的分类名!");
		}
		obj.setSeqNum(getNextSeqNum());
		if (StringUtils.isBlank(obj.getSjbh())) {
			obj.setSjbh(null);
		}
		super.add(obj);
	}

	@Override
	public void update(BjmbPojo obj) {

		if (StringUtils.isBlank(obj.getSjbh())) {
			obj.setSjbh(null);
		}
		BjmbPojo bjmbPojo = getChild(obj.getSjbh(), obj.getMc());
		if (bjmbPojo == null) {
			super.update(obj);
			return;
		}

		if (bjmbPojo.getId().equals(obj.getId())) {
			getSession().merge(obj);
		} else {
			throw new RuntimeException("重复的分类名!");
		}

	}
	
	@Override
	public void delete(String id) {
		List<BjmbPojo> list = getCriteria().add(Restrictions
				.eq("sjbh", id)).add(Restrictions.eq("deleteStatus", "0")).list();
		if(null != list && list.size() > 0 ){
			throw new RuntimeException("此分类下含有子分类,请先删除子分类!");
		}
		BjmbPojo bjmbPojo = get(id);
		List<JbxxPojo> jbxxPojos = jbxxService.getListByFenlei(bjmbPojo.getId());
		if(null != jbxxPojos && jbxxPojos.size() > 0 ){
			throw new RuntimeException("此分类下含有资产信息,请先删除资产信息!");
		}
		//物理删除
		bjmbPojo.setDeleteStatus("1");
		super.update(bjmbPojo);
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
	private BjmbPojo getChild(String parentId, String name) {
		List<BjmbPojo> bjmbPojos = getCriteria()
				.add(StringUtils.isBlank(parentId) ? Restrictions
						.isNull("sjbh") : Restrictions.eq("sjbh",
						parentId)).add(Restrictions.eq("mc", name))
				.add(Restrictions.eq("deleteStatus", "0")).list();
		if (bjmbPojos.isEmpty())
			return null;
		return bjmbPojos.get(0);
	}

	@Override
	public List<BjmbPojo> getChildren(String parentId, String status) {
		Criteria criteria = getCriteria();
		if (StringUtils.isBlank(parentId)) {
			criteria.add(Restrictions.isNull("sjbh"));
		} else {
			criteria.add(Restrictions.eq("sjbh", parentId));
		}
		if (status != null) {
			criteria.add(Restrictions.eq("deleteStatus", status));
		}
		criteria.addOrder(Order.asc("seqNum"));
		return criteria.list();
	}
	
	
	@Override
	public void move(String targetId, String sourceId, String point) {
		BjmbPojo target = get(targetId);
		BjmbPojo source = get(sourceId);

		if (target.getType() == BjmbPojo.TYPE_LEAF && point.equals("append")) {
			throw new RuntimeException("移动分类失败:叶子节点不允许追加子节点!");
		}

		if (point.equals("append")) { // 如果是追加操作,那么直接追加到父节点下
			source.setSjbh(target.getId());
			source.setSeqNum(getNextSeqNum());
			update(source);
		} else { // 否则是排序操作,那么移动为与目标节点同级,再执行同级排序
			source.setSjbh(target.getSjbh());
			source.setSeqNum(getNextSeqNum());
			update(source);

			sortForMove(target, source, point);
		}
	}
	
	
	/**
	 * 为移动操作排序
	 * 
	 * @param target
	 * @param source
	 * @param point
	 */
	private void sortForMove(BjmbPojo target, BjmbPojo source, String point) {
		List<BjmbPojo> children = getChildren(target.getSjbh(), null);
		int index = 0;
		for (; index < children.size(); index++) {
			BjmbPojo f = children.get(index);
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
			BjmbPojo f = children.get(index);
			if (index < children.size() - 1) {
				f.setSeqNum(children.get(index + 1).getSeqNum());
			} else {
				f.setSeqNum(_seqNum);
			}
		}
	}


	@Override
	public boolean checkDm(String dm) {
		if(StringUtils.isBlank(dm)) 
			return false;
		Criteria criteria = getCriteria();
		criteria.add(Restrictions.eq("dm", dm)).add(Restrictions.eq("deleteStatus", "0"));
		return criteria.list().size() > 0;
	}

	@Override
	public BjmbPojo getBjmbPojoByDm(String dm) {
		List<BjmbPojo> list = getCriteria().add(
				Restrictions.eq("dm", dm)).list();
		if (null != list && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	
	
}
