package com.cloud.icenter.yyzx.cszc.tjfx.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.cszc.tjfx.dao.EducationDao;
import com.cloud.icenter.yyzx.cszc.tjfx.pojo.WhcdNCPojo;
import com.cloud.icenter.yyzx.cszc.tjfx.pojo.WhcdPojo;
/**
 * 教育分析--文化程度分析
 * @date 2017年10月11日
 * @author dxliug
 */
@Repository
public class EducationDaoImpl extends BaseDaoImpl<WhcdPojo> implements EducationDao{
	private static final Logger logger = Logger.getLogger(EducationDaoImpl.class);

	@Override
	public List<WhcdPojo> getWhcdResult(String year,String areas) {
		String sql = "SELECT * FROM t_cszc_jyfzfx_whcd  WHERE delete_state = 0 and tyear = "+ year+" and area = "+ "\""+areas+"\"";
		try {
			Query query = createSQLQuery(sql).addEntity(WhcdPojo.class);
			List<WhcdPojo> list = query.list();
			return list;
		} catch (Exception e) {
			logger.info("文化基本信息查询失败"+e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<WhcdPojo> getWhcdArea(String year, String areas) {
		String sql = "SELECT * FROM t_cszc_jyfzfx_whcd  WHERE delete_state = 0 and tyear = "+ year+" and area != "+ "\""+areas+"\"";
		try {
			Query query = createSQLQuery(sql).addEntity(WhcdPojo.class);
			List<WhcdPojo> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<WhcdPojo> getWhcdZB(String year, String areas) {
		String sql = "SELECT * FROM t_cszc_jyfzfx_whcd  WHERE delete_state = 0 and  area = " + "\""+areas+"\""+"order by tyear desc";
		try {
			Query query = createSQLQuery(sql).addEntity(WhcdPojo.class);
			List<WhcdPojo> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<WhcdNCPojo> getWhcdNC(String year, String areas) {
		String sql = "SELECT * FROM t_cszc_jyfzfx_nc_whcd  WHERE delete_state = 0 and tyear = "+year;
		try {
			Query query = createSQLQuery(sql).addEntity(WhcdNCPojo.class);
			List<WhcdNCPojo> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
