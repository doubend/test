package com.cloud.icenter.yyzx.cszc.zygl.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.cszc.zygl.dao.JbxxDao;
import com.cloud.icenter.yyzx.cszc.zygl.pojo.JbxxPojo;

/** 
* @author zhucy 
* @version 2017年3月21日 下午2:37:26 
* 城市资源基本信息
*/
@Repository
public class JbxxDaoImpl extends BaseDaoImpl<JbxxPojo> implements JbxxDao {

	@Override
	public List<JbxxPojo> getListByFenlei(String fenlei) {
		List<JbxxPojo> list = new ArrayList<JbxxPojo>();
		list = getCriteria().add(Restrictions.eq("ssejflid", fenlei))
				.add(Restrictions.eq("deleteStatus", "0")).list();
		List<JbxxPojo> list1 = new ArrayList<JbxxPojo>();
		list1 = getCriteria().add(Restrictions.eq("ssyjflid", fenlei))
				.add(Restrictions.eq("deleteStatus", "0")).list();
		list.addAll(list1);
		return list;
	}

	
}
