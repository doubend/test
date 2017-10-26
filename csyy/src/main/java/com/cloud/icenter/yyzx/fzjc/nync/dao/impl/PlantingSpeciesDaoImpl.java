package com.cloud.icenter.yyzx.fzjc.nync.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.fzjc.nync.dao.PlantingSpeciesDao;
import com.cloud.icenter.yyzx.fzjc.nync.pojo.PlantingSpecies;
/**
* Created with gender.
* @author: yaoli
* Date: 2017-06-20 11:48:22
*/
@Repository
public class PlantingSpeciesDaoImpl extends BaseDaoImpl<PlantingSpecies> implements PlantingSpeciesDao {
	//获取粮食、夏粮、秋粮面积、产量
		public List<PlantingSpecies> getAreaClByName(String qy){
			try{
				String sql="SELECT * FROM `t_nync_zzy_lb` where qy='"+qy+"'  and zldm in(1,2,3) ORDER BY zldm,nf  ";
				Query query=createSQLQuery(sql).addEntity(PlantingSpecies.class);			
				List<PlantingSpecies> croplist= query.list();			
				return croplist;
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return null;
		}
		//获取粮食、经济作物、其它作物面积
		public List<PlantingSpecies> getAreaByName(String qy){
			try{
				String sql="SELECT * FROM `t_nync_zzy_lb` where qy='"+qy+"'  and zldm in(1,4,5) ORDER BY zldm,nf  ";
				Query query=createSQLQuery(sql).addEntity(PlantingSpecies.class);			
				List<PlantingSpecies> croplist= query.list();			
				return croplist;
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return null;
		}
		//获取果品种植面积、产量、面积增量、产量增量
		public List<PlantingSpecies> getFruitByName(String qy){
			try{
				String sql="SELECT * FROM `t_nync_zzy_lb` where qy='"+qy+"'  and zldm=6 ORDER BY zldm,nf  ";
				Query query=createSQLQuery(sql).addEntity(PlantingSpecies.class);			
				List<PlantingSpecies> croplist= query.list();			
				return croplist;
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return null;
		}
}