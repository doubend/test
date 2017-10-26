package com.cloud.icenter.yyzx.dpzs.lz.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.common.query.Industry;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.PrimaryIndustry;
import com.cloud.icenter.yyzx.dpzs.lz.dao.IndustryIncomeDao;
import com.cloud.icenter.yyzx.dpzs.lz.pojo.IndustryIncome;
import com.cloud.icenter.yyzx.dpzs.lz.pojo.TicketNow;

/**
 * Created with gender.
 * 
 * @author: yaoli Date: 2017-03-31 09:45:23
 */
@Repository
public class IndustryIncomeDaoImpl extends BaseDaoImpl<Industry> implements IndustryIncomeDao {
	public List<Industry> getIndustryIncome() {
		Calendar now = Calendar.getInstance();
		int year = now.get(now.YEAR);
		try {
			String sql = "SELECT hybmc,sr,increase,nf FROM t_whly_hy_sr  where nf=  " + year;
			Query query = createSQLQuery(sql);
			List<Industry> industryIncome = query.list();
			return industryIncome;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
}