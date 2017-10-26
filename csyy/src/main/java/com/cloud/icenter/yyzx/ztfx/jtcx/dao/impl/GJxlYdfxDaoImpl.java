package com.cloud.icenter.yyzx.ztfx.jtcx.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.common.utils.StringUtil;
import com.cloud.icenter.yyzx.fzjc.hgjj.pojo.GmgyLnsh;
import com.cloud.icenter.yyzx.ztfx.jtcx.dao.GJxlYdfxDao;
import com.cloud.icenter.yyzx.ztfx.jtcx.pojo.GJxlYdfxPojo;

/** 
 * @author zhucy 
 * @version 2017年7月28日 上午11:20:14 
 * 说明 
 */
@Repository
public class GJxlYdfxDaoImpl extends BaseDaoImpl<GJxlYdfxPojo> implements GJxlYdfxDao{
	
	public String getYdsj(String name,String sxx){
		if (StringUtil.isEmpty(sxx)) {
			sxx = "0";
		}
		String sql = "SELECT * FROM t_gjxl_ydfx WHERE  name = '"+name+"' AND sxl = '"+sxx+"' ORDER BY date_time DESC LIMIT 1";
		Query query = createSQLQuery(sql).addEntity(GJxlYdfxPojo.class);
		List<GJxlYdfxPojo> list = query.list();
		if (null != list && list.size() > 0 ) {
			 return list.get(0).getYdsj();
		}
		return null;
	}

}
