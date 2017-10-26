package com.cloud.icenter.yyzx.dpzs.lz.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.common.query.Tourism;
import com.cloud.icenter.yyzx.dpzs.lz.dao.TicketNowDao;
import com.cloud.icenter.yyzx.dpzs.lz.pojo.TicketDay;
import com.cloud.icenter.yyzx.dpzs.lz.pojo.TicketNow;

/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-31 09:43:47
*/
@Repository
public class TicketNowDaoImpl extends BaseDaoImpl<Tourism> implements TicketNowDao {
	/**
	 * 实时数据，每小时更新一次
	 * 获取最近1小时的景区票务量数据
	 * @return
	 */
	public List<Tourism> getHourTicket(){
		
		try{
			String sql="SELECT IFNULL(t.zpwl,0) as zpwl,IFNULL(t.ryl,0)as ryl,IFNULL(t.jdl,0)as jdl,IFNULL(t.rycl,0)"
            +"as rycl,IFNULL(t.jqrll,0)as jqrll,IFNULL(t.sycw,0)as sycw,"
            +"IFNULL(t.jqrlxz,0)as jqrlxz FROM t_whly_pwl_now t   "
            +"  where  rq=(SELECT MAX(rq) from t_whly_pwl_now ) and sjdbm=HOUR(NOW())";
			/*String sql="SELECT * FROM t_whly_pwl_now where sjdbm=9 and rq='2017-04-01'";*/
			
			Query query=createSQLQuery(sql);	
			List<Tourism> hourTicketList=query.list();
			return hourTicketList;
		} 
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}