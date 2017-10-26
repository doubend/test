
package com.cloud.icenter.yyzx.fzjc.nync.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.common.query.AnimalClCl;
import com.cloud.icenter.yyzx.fzjc.nync.dao.PlantingBasicDao;
import com.cloud.icenter.yyzx.fzjc.nync.pojo.PlantingBasic;
/**
* @author: yaoli
* Date: 2017-03-02 18:32:09
*/
@Repository
public class PlantingBasicDaoImpl extends BaseDaoImpl<PlantingBasic> implements PlantingBasicDao {

	public List<PlantingBasic> getCropsValues(){
		List<PlantingBasic> cropsList=new ArrayList<PlantingBasic>();
		cropsList=getValuesByCategory();		
		return cropsList;
	}
	private List<PlantingBasic> getValuesByCategory(){
		try{
			
			String sql="SELECT * FROM `t_nync_zzy_jbxx`  ORDER by nf desc,zldm LIMIT 5";
			Query query=createSQLQuery(sql).addEntity(PlantingBasic.class);			
			List<PlantingBasic> croplist= query.list();			
			return croplist;
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	
}