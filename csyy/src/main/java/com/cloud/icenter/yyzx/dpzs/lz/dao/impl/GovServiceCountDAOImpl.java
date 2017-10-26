package com.cloud.icenter.yyzx.dpzs.lz.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.dpzs.lz.dao.IGovServiceCountDAO;
import com.cloud.icenter.yyzx.dpzs.lz.pojo.GovServiceCount;

@Repository
public class GovServiceCountDAOImpl extends BaseDaoImpl<GovServiceCount> implements IGovServiceCountDAO {
	
	public static final Logger logger = LoggerFactory.getLogger(GovServiceCountDAOImpl.class);
	
	@Autowired 
	private SessionFactory sessionFactory;
	
	@Autowired 
	private SessionFactory sessionFactory_cj;

	/*
	 * 统计当日 1:已预受理；2：正在受理；3：已受理；4：已办结；
	 */

	@SuppressWarnings("unchecked")
	@Override
	public List<GovServiceCount> getDayData() {
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH) + 1;
		int day = now.get(Calendar.DAY_OF_MONTH);
		try {
			String sql = "SELECT * FROM t_tszw_bjtj WHERE NOWDAY = "
					+ day
					+ " AND NOWMONTH = "
					+ month
					+ " AND NOWYEAR = "
					+ year + " ORDER BY CREATE_DATE DESC";
			Query query = getSessionCj().createSQLQuery(sql).addEntity(GovServiceCount.class);
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public GovServiceCount getCurrDayData() {
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH) + 1;
		int day = now.get(Calendar.DAY_OF_MONTH);
		List<GovServiceCount> data = new ArrayList<GovServiceCount>();
		try {
			String sql = "SELECT * FROM t_zwfw_sx_tj WHERE NOWDAY = "
					+ day + " AND NOWMONTH = " + month + " AND NOWYEAR = "
					+ year + " ORDER BY CREATE_DATE DESC";
			Query query = getSession().createSQLQuery(sql).addEntity(GovServiceCount.class);
			data = query.list();
			if (data == null || data.size() <= 0) {
				return null;
			}
			return data.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Integer updateData(GovServiceCount govServiceCount) {
		logger.debug("===更新-" + govServiceCount.getYear() + "年" + govServiceCount.getMonth() + "月" + govServiceCount.getDay() + "日行政审批数据！");
		try {
			String sql = "UPDATE t_zwfw_sx_tj SET NOWYEARACCEPTING=:yearAccepting, NOWYEARACCEPTED=:yearAccepted,NOWYEARHANDLE=:yearHandle, NOWYEARHANDLED=:yearHandled"
					+ ", NOWMONTHACCEPTING=:monthAccepting, NOWMONTHACCEPTED=:monthAccepted, NOWMONTHHANDLE=:monthHandle, NOWMONTHHANDLED=:monthHandled"
					+ ", NOWDAYACCEPTING=:dayAccepting, NOWDAYACCEPTED=:dayAccepted, NOWDAYHANDLE=:dayHandle, NOWDAYHANDLED=:dayHandled"
					+ ", CREATE_DATE=:createdDate WHERE NOWDAY=:day AND NOWMONTH=:month  AND NOWYEAR=:year";
			Query updateQuery = getSession().createSQLQuery(sql).addEntity(GovServiceCount.class);
			updateQuery.setString("yearAccepting", govServiceCount.getYearAccepting());
			updateQuery.setString("yearAccepted", govServiceCount.getYearAccepted());
			updateQuery.setString("yearHandle", govServiceCount.getYearHandle());
			updateQuery.setString("yearHandled", govServiceCount.getYearHandled());
			updateQuery.setString("monthAccepting", govServiceCount.getMonthAccepting());
			updateQuery.setString("monthAccepted", govServiceCount.getMonthAccepted());
			updateQuery.setString("monthHandle", govServiceCount.getMonthHandle());
			updateQuery.setString("monthHandled", govServiceCount.getMonthHandled());
			updateQuery.setString("dayAccepting", govServiceCount.getDayAccepting());
			updateQuery.setString("dayAccepted", govServiceCount.getDayAccepted());
			updateQuery.setString("dayHandle", govServiceCount.getDayHandle());
			updateQuery.setString("dayHandled", govServiceCount.getDayHandled());
			updateQuery.setTimestamp("createdDate", govServiceCount.getCreatedDate());
			updateQuery.setString("day", govServiceCount.getDay());
			updateQuery.setString("month", govServiceCount.getMonth());
			updateQuery.setString("year", govServiceCount.getYear());
			return updateQuery.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * 获取hibernate的session对象
	 * @return
	 */
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	/**
	 * 获取hibernate的session对象
	 * @return
	 */
	protected Session getSessionCj() {
		return sessionFactory_cj.getCurrentSession();
	}
	
	
}
