package com.cloud.icenter.yyzx.cstz.dao.impl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.common.utils.StringUtil;
import com.cloud.icenter.yyzx.cstz.dao.CstzTzzssjDao;
import com.cloud.icenter.yyzx.cstz.dao.CstzYwtzDao;
import com.cloud.icenter.yyzx.cstz.dao.CstzYwzbDao;
import com.cloud.icenter.yyzx.cstz.dao.CstzYwzbsjDao;
import com.cloud.icenter.yyzx.cstz.pojo.CstzTzzssjPojo;
import com.cloud.icenter.yyzx.cstz.pojo.CstzYwtzPojo;
import com.cloud.icenter.yyzx.cstz.pojo.CstzYwzbPojo;
import com.cloud.icenter.yyzx.cstz.pojo.CstzYwzbsjPojo;
import com.cloud.icenter.yyzx.cstz.service.CstzTzzssjService;
import com.cloud.icenter.yyzx.cstz.service.CstzYwzbService;
import com.cloud.icenter.yyzx.cstz.service.CstzYwzbsjService;
import com.cloud.icenter.yyzx.fzjc.hgjj.pojo.GmgyLnsh;

/**
 * @author zhucy
 * @version 2017年4月5日 下午2:38:06 说明
 */
@Repository
public class CstzYwzbDaoImpl extends BaseDaoImpl<CstzYwzbPojo> implements
		CstzYwzbDao {
	// BigDecimal保留小数位
	public final static int SCALE = 3;

	// BigDecimal四舍五入
	public final static int ROUND_HALF_UP = BigDecimal.ROUND_HALF_UP;

	@Autowired
	private CstzYwzbsjDao cstzYwzbsjDao;

	@Autowired
	private CstzYwtzDao cstzYwtzDao;

	@Autowired
	private CstzTzzssjDao cstzTzzssjDao;

	@Autowired
	private CstzTzzssjService cstzTzzssjService;
	@Autowired
	private CstzYwzbsjService cstzYwzbsjService;

	/**
	 * 指标计算(由业务指标值转换成体征指数)
	 */
	@Override
	public void zbCal() {
		// 获取有效业务指标数据
		List<CstzYwzbPojo> cstzYwzbPojos = getCriteria().add(
				Restrictions.eq("deleteStatus", "0")).list();
		for (CstzYwzbPojo cstzYwzbPojo : cstzYwzbPojos) {
			// 获取业务指标数据值
			DetachedCriteria criteria = DetachedCriteria
					.forClass(CstzYwzbsjPojo.class);
			// 无历史数据
			criteria.add(Restrictions.eq("ywzbId", cstzYwzbPojo.getId())).add(
					Restrictions.eq("deleteStatus", "0"));
			// 有历史数据
			// criteria.add(Restrictions.eq("ywzbId", cstzYwzbPojo.getId()));
			criteria.addOrder(Order.desc("dataTime"));
			List<CstzYwzbsjPojo> cstzYwzbsjPojos = this.cstzYwzbsjDao
					.find(criteria);
			if (null != cstzYwzbsjPojos && cstzYwzbsjPojos.size() > 0) {
				for (CstzYwzbsjPojo cstzYwzbsjPojo : cstzYwzbsjPojos) {
					if (!StringUtil.isEmpty(cstzYwzbsjPojo.getYwzbsj())) {
						// 业务指标值转换成BigDecimal,便于后续计算体征指数,Excel B
						BigDecimal ywzbsj = new BigDecimal(
								cstzYwzbsjPojo.getYwzbsj());
						// 获取关联的业务体征信息,阈值等信息
						DetachedCriteria cstzYwtzCriteria = DetachedCriteria
								.forClass(CstzYwtzPojo.class);
						cstzYwtzCriteria.add(Restrictions.eq("ywzbId",
								cstzYwzbPojo.getId()));
						List<CstzYwtzPojo> cstzYwtzPojos = this.cstzYwtzDao
								.find(cstzYwtzCriteria);
						if (null != cstzYwtzPojos && cstzYwtzPojos.size() > 0) {
							CstzYwtzPojo cstzYwtzPojo = cstzYwtzPojos.get(0);
							String yzStr = cstzYwtzPojo.getYz();// 阈值区间 ,
																// 如{0,10,50,100}
							String ylzcfw = cstzYwtzPojo.getYlzcfw();// 优良中差范围区间,如
																		// {0，2，5，8，10}
							String zyzbs = cstzYwtzPojo.getZyzbs();// 最优值标识位
																	// 0:越大越好
																	// 1:越小越好
							if (!StringUtil.isEmpty(yzStr)
									&& !StringUtil.isEmpty(ylzcfw)) {// 阈值处理,优良中差处理
								BigDecimal yz1 = BigDecimal.ZERO;
								BigDecimal yz2 = BigDecimal.ZERO;
								BigDecimal yz3 = BigDecimal.ZERO;
								BigDecimal yz4 = BigDecimal.ZERO;
								// 阈值分段
								String[] yzArr = yzStr.split(",");
								if (zyzbs.equals("0")) {// 越大越好 如:100,50,10,0
									yz1 = new BigDecimal(yzArr[3]);// F
									yz2 = new BigDecimal(yzArr[2]);// G
									yz3 = new BigDecimal(yzArr[1]);// H
									yz4 = new BigDecimal(yzArr[0]);// I
								} else {// 越小越好 如:0,10,50,100
									yz1 = new BigDecimal(yzArr[0]);// F
									yz2 = new BigDecimal(yzArr[1]);// G
									yz3 = new BigDecimal(yzArr[2]);// H
									yz4 = new BigDecimal(yzArr[3]);// I
								}

								// 优良中差分段
								String[] ylzcArr = ylzcfw.split(",");
								BigDecimal ylzc1 = new BigDecimal(ylzcArr[0]);// 0
																				// N
								BigDecimal ylzc2 = new BigDecimal(ylzcArr[1]);// 2
																				// M
								BigDecimal ylzc3 = new BigDecimal(ylzcArr[2]);// 5
																				// L
								BigDecimal ylzc4 = new BigDecimal(ylzcArr[3]);// 8
																				// K
								BigDecimal ylzc5 = new BigDecimal(ylzcArr[4]);// 10
																				// J
								BigDecimal tzz = BigDecimal.ZERO;// 体征指数默认值0
								// 计算体征指数值
								if (zyzbs.equals("1")) {// 越大越好 如:100,50,10,0
									if (ywzbsj.compareTo(yz2) == -1) {// 公式一
										tzz = ylzc5
												.subtract(
														(ywzbsj.divide(yz2,
																SCALE,
																ROUND_HALF_UP))
																.multiply((ylzc5
																		.subtract(ylzc4))))
												.setScale(SCALE, ROUND_HALF_UP);
									} else if ((ywzbsj.compareTo(yz2) == 0 || ywzbsj
											.compareTo(yz2) == 1)
											&& ywzbsj.compareTo(yz3) == -1) {// 公式二
										tzz = ylzc4
												.subtract(
														((ywzbsj.subtract(yz2))
																.divide(yz3,
																		SCALE,
																		ROUND_HALF_UP))
																.multiply((ylzc4
																		.subtract(ylzc3))))
												.setScale(SCALE, ROUND_HALF_UP);
									} else if ((ywzbsj.compareTo(yz3) == 0 || ywzbsj
											.compareTo(yz3) == 1)
											&& ywzbsj.compareTo(yz4) == -1) {// 公式三
										tzz = ylzc3
												.subtract(
														((ywzbsj.subtract(yz3))
																.divide(yz4,
																		SCALE,
																		ROUND_HALF_UP))
																.multiply((ylzc3
																		.subtract(ylzc2))))
												.setScale(SCALE, ROUND_HALF_UP);
									} else if (ywzbsj.compareTo(yz4) == 0
											|| ywzbsj.compareTo(yz4) == 1) {// 公式四
										tzz = ylzc2
												.subtract(
														((ywzbsj.subtract(yz4))
																.divide(ywzbsj,
																		SCALE,
																		ROUND_HALF_UP))
																.multiply((ylzc2
																		.subtract(ylzc1))))
												.setScale(SCALE, ROUND_HALF_UP);
									}
								} else {// 越小越好 如:0,10,50,100
									if (ywzbsj.compareTo(yz3) == -1) {// 公式一
										tzz = (ywzbsj.divide(yz2, SCALE,
												ROUND_HALF_UP)).multiply(ylzc2)
												.setScale(SCALE, ROUND_HALF_UP);
									} else if ((ywzbsj.compareTo(yz3) == 0 || ywzbsj
											.compareTo(yz3) == 1)
											&& ywzbsj.compareTo(yz2) == -1) {// 公式二
										tzz = ylzc2
												.add(((ywzbsj.subtract(yz3))
														.divide(ywzbsj, SCALE,
																ROUND_HALF_UP))
														.multiply(
																(ylzc3.subtract(ylzc2)))
														.setScale(SCALE,
																ROUND_HALF_UP));
									} else if ((ywzbsj.compareTo(yz2) == 0 || ywzbsj
											.compareTo(yz2) == 1)
											&& ywzbsj.compareTo(yz1) == -1) {// 公式三
										tzz = ylzc3
												.add(((ywzbsj.subtract(yz2))
														.divide(ywzbsj, SCALE,
																ROUND_HALF_UP))
														.multiply(
																(ylzc4.subtract(ylzc3)))
														.setScale(SCALE,
																ROUND_HALF_UP));
									} else if (ywzbsj.compareTo(yz1) == 0
											|| ywzbsj.compareTo(yz1) == 1) {// 公式四
										tzz = ylzc4
												.add(((ywzbsj.subtract(yz1))
														.divide(ywzbsj, SCALE,
																ROUND_HALF_UP))
														.multiply(
																(ylzc5.subtract(ylzc4)))
														.setScale(SCALE,
																ROUND_HALF_UP));
									}
								}

								// if (tzz.compareTo(BigDecimal.ZERO) == 0) {
								// if (ywzbsj.compareTo(BigDecimal.ZERO) != 0) {
								// double b=(Math.random()*10);//产生0-10的整数随机数
								// tzz =
								// BigDecimal.valueOf(b).setScale(SCALE,ROUND_HALF_UP);
								// System.out.println(">>>>>>>>>>>>>>>>>>>>>>这是随机数，假的！"+tzz);
								// }
								//
								// }
								// 计算体征指数值所在优良中差段位
								String ylzc = "";
								if ((tzz.compareTo(ylzc1) == 0 || tzz
										.compareTo(ylzc1) == 1)
										&& tzz.compareTo(ylzc2) == -1) {// 0 <=
																		// tzz <
																		// 2
									ylzc = "差";
								} else if ((tzz.compareTo(ylzc2) == 0 || tzz
										.compareTo(ylzc2) == 1)
										&& tzz.compareTo(ylzc3) == -1) {// 2 <=
																		// tzz <
																		// 5
									ylzc = "中";
								} else if ((tzz.compareTo(ylzc3) == 0 || tzz
										.compareTo(ylzc3) == 1)
										&& tzz.compareTo(ylzc4) == -1) {// 5 <=
																		// tzz <
																		// 8
									ylzc = "良";
								} else if ((tzz.compareTo(ylzc4) == 0 || tzz
										.compareTo(ylzc4) == 1)
										&& (tzz.compareTo(ylzc5) == -1 || tzz
												.compareTo(ylzc5) == 0)) {// 8
																			// <=
																			// tzz
																			// <=10
									ylzc = "优";
								}
								System.out.println(cstzYwzbPojo.getYwzbmc()
										+ "<>" + "体征指数:" + tzz + "<>优良中差:"
										+ ylzc);
								// 把体征指数新增或者更新到体征指数数据表中
								this.saveOrUpdateTzzssj(cstzYwtzPojo.getId(),
										tzz, ylzc, cstzYwzbsjPojo.getDataTime());
								// 把计算过的数据更新为历史数据
								cstzYwzbsjPojo.setDeleteStatus("1");
								this.cstzYwzbsjService.update(cstzYwzbsjPojo);
							}
						}
					}
				}

			}
		}
	}

	/**
	 * 新增或者更新体征指数到体征指数数据表中
	 * 
	 * @param tzId
	 *            业务体征ID
	 * @param tzz
	 *            体征指数
	 * @param tzzk
	 *            体征状况:优、良、中、差
	 */
	public void saveOrUpdateTzzssj(String tzId, BigDecimal tzz, String tzzk,
			Date date) {
		CstzTzzssjPojo cstzTzzssjPojo = new CstzTzzssjPojo();
		cstzTzzssjPojo.setTzId(tzId);
		cstzTzzssjPojo.setTzz(tzz);
		cstzTzzssjPojo.setTzzk(tzzk);
		cstzTzzssjPojo.setDataTime(date);
		cstzTzzssjPojo.setCreateTime(new Date());
		cstzTzzssjPojo.setDeleteStatus("0");
		this.cstzTzzssjService.add(cstzTzzssjPojo);
		// DetachedCriteria criteria =
		// DetachedCriteria.forClass(CstzTzzssjPojo.class);
		// criteria.add(Restrictions.eq("tzId", tzId));
		// List<CstzTzzssjPojo> cstzTzzssjPojos =
		// this.cstzTzzssjDao.find(criteria);
		// if (null != cstzTzzssjPojos && cstzTzzssjPojos.size() > 0) {//更新
		// CstzTzzssjPojo cstzTzzssjPojo = cstzTzzssjPojos.get(0);
		// cstzTzzssjPojo.setTzz(tzz);
		// cstzTzzssjPojo.setTzzk(tzzk);
		// cstzTzzssjPojo.setDataTime(new Date());
		// this.cstzTzzssjDao.update(cstzTzzssjPojo);
		// }else{//新增
		// CstzTzzssjPojo cstzTzzssjPojo = new CstzTzzssjPojo();
		// cstzTzzssjPojo.setTzId(tzId);
		// cstzTzzssjPojo.setTzz(tzz);
		// cstzTzzssjPojo.setTzzk(tzzk);
		// cstzTzzssjPojo.setDataTime(new Date());
		// cstzTzzssjPojo.setCreateTime(new Date());
		// cstzTzzssjPojo.setDeleteStatus("0");
		// this.cstzTzzssjDao.save(cstzTzzssjPojo);
		// }
	}

	public static void main(String[] args) {
		double b = (Math.random() * 10);// 产生0-10的整数随机数
		System.out
				.println(BigDecimal.valueOf(b).setScale(SCALE, ROUND_HALF_UP));
	}

	@Override
	public void initData() {
		String clearDataSql = "truncate table t_cstz_tzzssj;";
		this.executeSqlUpdate(clearDataSql, null);
		String updateStatusSql = "update t_cstz_ywzbsj set delete_status=0 ;";
		this.executeSqlUpdate(updateStatusSql, null);
	}

	private static Date getStartTime() {
		Calendar todayStart = Calendar.getInstance();
		todayStart.set(Calendar.HOUR_OF_DAY, 0);
		todayStart.set(Calendar.MINUTE, 0);
		todayStart.set(Calendar.SECOND, 0);
		return todayStart.getTime();
	}

	private static Date getEndTime() {
		Calendar todayEnd = Calendar.getInstance();
		todayEnd.set(Calendar.HOUR_OF_DAY, 23);
		todayEnd.set(Calendar.MINUTE, 59);
		todayEnd.set(Calendar.SECOND, 59);
		return todayEnd.getTime();
	}

	@Override
	public void zbCalDs() {
		String sql = "SELECT t2.id,t2.ywzb_id,AVG(t2.ywzbsj) ywzbsj,t2.data_time,t2.create_time,t2.update_time,"
				+ "	t2.delete_time,t2.delete_status,t2.creator"
				+ " FROM t_cstz_ywzb t1,t_cstz_ywzbsj t2 WHERE t1.code=t2.ywzb_id "
				+ " AND t1.sjpl='年' AND YEAR(t2.data_time)= YEAR(NOW()) "
				+ " GROUP BY t2.ywzb_id "
				+ " UNION ALL"
				+ " SELECT t2.id,t2.ywzb_id,AVG(t2.ywzbsj) ywzbsj,t2.data_time,t2.create_time,t2.update_time,"
				+ " t2.delete_time,t2.delete_status,t2.creator"
				+ " FROM t_cstz_ywzb t1,t_cstz_ywzbsj t2 WHERE t1.code=t2.ywzb_id "
				+ " AND t1.sjpl='月' AND YEAR(t2.data_time)= YEAR(NOW()) AND MONTH(t2.data_time)= MONTH(NOW()) "
				+ " GROUP BY t2.ywzb_id "
				+ " UNION ALL"
				+ " SELECT t2.id,t2.ywzb_id,AVG(t2.ywzbsj) ywzbsj,t2.data_time,t2.create_time,t2.update_time,"
				+ " t2.delete_time,t2.delete_status,t2.creator"
				+ " FROM t_cstz_ywzb t1,t_cstz_ywzbsj t2 WHERE t1.code=t2.ywzb_id AND t1.sjpl not in ('年','月') "
				+ " AND YEAR(t2.data_time)= YEAR(NOW()) AND MONTH(t2.data_time)= MONTH(NOW()) AND DAY(t2.data_time)= DAY(NOW())"
				+ " GROUP BY t2.ywzb_id";
		Query query = createSQLQuery(sql).addEntity(CstzYwzbsjPojo.class);
		List<CstzYwzbsjPojo> cstzYwzbsjPojos = query.list();
		if (null != cstzYwzbsjPojos && cstzYwzbsjPojos.size() > 0) {
			for (CstzYwzbsjPojo cstzYwzbsjPojo : cstzYwzbsjPojos) {
				if (!StringUtil.isEmpty(cstzYwzbsjPojo.getYwzbsj())) {
					// 业务指标值转换成BigDecimal,便于后续计算体征指数,Excel B
					BigDecimal ywzbsj = new BigDecimal(
							cstzYwzbsjPojo.getYwzbsj());
					// 获取关联的业务体征信息,阈值等信息
					DetachedCriteria cstzYwtzCriteria = DetachedCriteria
							.forClass(CstzYwtzPojo.class);
					cstzYwtzCriteria.add(Restrictions.eq("ywzbId",
							cstzYwzbsjPojo.getYwzbId()));
					List<CstzYwtzPojo> cstzYwtzPojos = this.cstzYwtzDao
							.find(cstzYwtzCriteria);
					if (null != cstzYwtzPojos && cstzYwtzPojos.size() > 0) {
						CstzYwtzPojo cstzYwtzPojo = cstzYwtzPojos.get(0);
						String yzStr = cstzYwtzPojo.getYz();// 阈值区间 ,
															// 如{0,10,50,100}
						String ylzcfw = cstzYwtzPojo.getYlzcfw();// 优良中差范围区间,如
																	// {0，2，5，8，10}
						String zyzbs = cstzYwtzPojo.getZyzbs();// 最优值标识位 0:越大越好
																// 1:越小越好
						if (!StringUtil.isEmpty(yzStr)
								&& !StringUtil.isEmpty(ylzcfw)) {// 阈值处理,优良中差处理
							BigDecimal yz1 = BigDecimal.ZERO;
							BigDecimal yz2 = BigDecimal.ZERO;
							BigDecimal yz3 = BigDecimal.ZERO;
							BigDecimal yz4 = BigDecimal.ZERO;
							// 阈值分段
							String[] yzArr = yzStr.split(",");
							if (zyzbs.equals("0")) {// 越大越好 如:100,50,10,0
								yz1 = new BigDecimal(yzArr[3]);// F
								yz2 = new BigDecimal(yzArr[2]);// G
								yz3 = new BigDecimal(yzArr[1]);// H
								yz4 = new BigDecimal(yzArr[0]);// I
							} else {// 越小越好 如:0,10,50,100
								yz1 = new BigDecimal(yzArr[0]);// F
								yz2 = new BigDecimal(yzArr[1]);// G
								yz3 = new BigDecimal(yzArr[2]);// H
								yz4 = new BigDecimal(yzArr[3]);// I
							}

							// 优良中差分段
							String[] ylzcArr = ylzcfw.split(",");
							BigDecimal ylzc1 = new BigDecimal(ylzcArr[0]);// 0 N
							BigDecimal ylzc2 = new BigDecimal(ylzcArr[1]);// 2 M
							BigDecimal ylzc3 = new BigDecimal(ylzcArr[2]);// 5 L
							BigDecimal ylzc4 = new BigDecimal(ylzcArr[3]);// 8 K
							BigDecimal ylzc5 = new BigDecimal(ylzcArr[4]);// 10
																			// J
							BigDecimal tzz = BigDecimal.ZERO;// 体征指数默认值0
							// 计算体征指数值
							if (zyzbs.equals("1")) {// 越大越好 如:100,50,10,0
								if (ywzbsj.compareTo(yz2) == -1) {// 公式一
									tzz = ylzc5.subtract(
											(ywzbsj.divide(yz2, SCALE,
													ROUND_HALF_UP))
													.multiply((ylzc5
															.subtract(ylzc4))))
											.setScale(SCALE, ROUND_HALF_UP);
								} else if ((ywzbsj.compareTo(yz2) == 0 || ywzbsj
										.compareTo(yz2) == 1)
										&& ywzbsj.compareTo(yz3) == -1) {// 公式二
									tzz = ylzc4.subtract(
											((ywzbsj.subtract(yz2)).divide(yz3,
													SCALE, ROUND_HALF_UP))
													.multiply((ylzc4
															.subtract(ylzc3))))
											.setScale(SCALE, ROUND_HALF_UP);
								} else if ((ywzbsj.compareTo(yz3) == 0 || ywzbsj
										.compareTo(yz3) == 1)
										&& ywzbsj.compareTo(yz4) == -1) {// 公式三
									tzz = ylzc3.subtract(
											((ywzbsj.subtract(yz3)).divide(yz4,
													SCALE, ROUND_HALF_UP))
													.multiply((ylzc3
															.subtract(ylzc2))))
											.setScale(SCALE, ROUND_HALF_UP);
								} else if (ywzbsj.compareTo(yz4) == 0
										|| ywzbsj.compareTo(yz4) == 1) {// 公式四
									tzz = ylzc2.subtract(
											((ywzbsj.subtract(yz4)).divide(
													ywzbsj, SCALE,
													ROUND_HALF_UP))
													.multiply((ylzc2
															.subtract(ylzc1))))
											.setScale(SCALE, ROUND_HALF_UP);
								}
							} else {// 越小越好 如:0,10,50,100
								if (ywzbsj.compareTo(yz3) == -1) {// 公式一
									tzz = (ywzbsj.divide(yz2, SCALE,
											ROUND_HALF_UP)).multiply(ylzc2)
											.setScale(SCALE, ROUND_HALF_UP);
								} else if ((ywzbsj.compareTo(yz3) == 0 || ywzbsj
										.compareTo(yz3) == 1)
										&& ywzbsj.compareTo(yz2) == -1) {// 公式二
									tzz = ylzc2.add(((ywzbsj.subtract(yz3))
											.divide(ywzbsj, SCALE,
													ROUND_HALF_UP)).multiply(
											(ylzc3.subtract(ylzc2))).setScale(
											SCALE, ROUND_HALF_UP));
								} else if ((ywzbsj.compareTo(yz2) == 0 || ywzbsj
										.compareTo(yz2) == 1)
										&& ywzbsj.compareTo(yz1) == -1) {// 公式三
									tzz = ylzc3.add(((ywzbsj.subtract(yz2))
											.divide(ywzbsj, SCALE,
													ROUND_HALF_UP)).multiply(
											(ylzc4.subtract(ylzc3))).setScale(
											SCALE, ROUND_HALF_UP));
								} else if (ywzbsj.compareTo(yz1) == 0
										|| ywzbsj.compareTo(yz1) == 1) {// 公式四
									tzz = ylzc4.add(((ywzbsj.subtract(yz1))
											.divide(ywzbsj, SCALE,
													ROUND_HALF_UP)).multiply(
											(ylzc5.subtract(ylzc4))).setScale(
											SCALE, ROUND_HALF_UP));
								}
							}

							// 计算体征指数值所在优良中差段位
							String ylzc = "";
							if ((tzz.compareTo(ylzc1) == 0 || tzz
									.compareTo(ylzc1) == 1)
									&& tzz.compareTo(ylzc2) == -1) {// 0 <= tzz
																	// < 2
								ylzc = "差";
							} else if ((tzz.compareTo(ylzc2) == 0 || tzz
									.compareTo(ylzc2) == 1)
									&& tzz.compareTo(ylzc3) == -1) {// 2 <= tzz
																	// < 5
								ylzc = "中";
							} else if ((tzz.compareTo(ylzc3) == 0 || tzz
									.compareTo(ylzc3) == 1)
									&& tzz.compareTo(ylzc4) == -1) {// 5 <= tzz
																	// < 8
								ylzc = "良";
							} else if ((tzz.compareTo(ylzc4) == 0 || tzz
									.compareTo(ylzc4) == 1)
									&& (tzz.compareTo(ylzc5) == -1 || tzz
											.compareTo(ylzc5) == 0)) {// 8 <=
																		// tzz
																		// <=10
								ylzc = "优";
							}
							DetachedCriteria cstzYwzbCriteria = DetachedCriteria
									.forClass(CstzYwzbPojo.class);
							cstzYwzbCriteria.add(Restrictions.eq("id",
									cstzYwzbsjPojo.getYwzbId()));
							List<CstzYwzbPojo> cstzYwzbPojos = this.find(cstzYwzbCriteria);
							System.out.println(cstzYwzbPojos.get(0).getYwzbmc() + "<>"
									+ "体征指数:" + tzz + "<>优良中差:" + ylzc);
							// 把体征指数新增或者更新到体征指数数据表中
							this.saveOrUpdateTzzssj(cstzYwtzPojo.getId(), tzz,
									ylzc, new Date());
							// 把计算过的数据更新为历史数据
							cstzYwzbsjPojo.setDeleteStatus("1");
							this.cstzYwzbsjService.update(cstzYwzbsjPojo);
						}
					}
				}
			}

		}
	}
}
