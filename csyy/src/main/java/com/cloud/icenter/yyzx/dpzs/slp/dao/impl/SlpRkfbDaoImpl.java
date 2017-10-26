package com.cloud.icenter.yyzx.dpzs.slp.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.dpzs.slp.dao.SlpRkfbDao;
import com.cloud.icenter.yyzx.dpzs.slp.pojo.SlpRkNljgPojo;
import com.cloud.icenter.yyzx.dpzs.slp.pojo.SlpRkfbPojo;

/**
 * @三联屏-人口-低保人群
 */
@Repository
public class SlpRkfbDaoImpl extends BaseDaoImpl<SlpRkfbPojo> implements SlpRkfbDao {

	@Override
	public List<SlpRkfbPojo> getRkfbByYear(int year) {
		try {
			DetachedCriteria searDc = DetachedCriteria.forClass(SlpRkfbPojo.class);
			searDc.add(Restrictions.eq("year", year));
			return super.find(searDc);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public List<SlpRkNljgPojo> getRkNljgList() {
		String sql = "SELECT * FROM t_slp_renk_rkfb_nljg WHERE delete_state=0 " + " ORDER BY segment_min ASC";
		try {
			Query query = createSQLQuery(sql).addEntity(SlpRkNljgPojo.class);
			List<SlpRkNljgPojo> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
