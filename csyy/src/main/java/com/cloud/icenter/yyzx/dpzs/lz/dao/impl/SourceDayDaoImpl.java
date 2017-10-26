package com.cloud.icenter.yyzx.dpzs.lz.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.common.query.Tourism;
import com.cloud.icenter.yyzx.dpzs.lz.dao.SourceDayDao;
import com.cloud.icenter.yyzx.dpzs.lz.pojo.ServiceCategory;
import com.cloud.icenter.yyzx.dpzs.lz.pojo.SourceDay;

/**
 * Created with gender.
 * 
 * @author: yaoli Date: 2017-03-31 09:44:46
 */
@Repository
public class SourceDayDaoImpl extends BaseDaoImpl<SourceDay> implements SourceDayDao {

	/*
	 * 查询近一周游客来源数据 统计top6
	 */
	public List<Tourism> getDaySource() {
		Calendar now = Calendar.getInstance();
		StringBuffer sb = new StringBuffer("");
		sb.append("SELECT hjszdsmc,SUM(kll)as account ");
		sb.append("FROM t_whly_ly_ri ");
		sb.append("WHERE day>date_sub(curdate(),interval 7 day) ");
		sb.append("group by hjszdsmc ");
		sb.append("ORDER BY account DESC ");
		sb.append("limit 6 ");
		try {
			Query query = createSQLQuery(sb.toString());
			List<Tourism> result = query.list();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}