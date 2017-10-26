
package com.cloud.icenter.yyzx.fzjc.nync.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.fzjc.nync.dao.AnimalProductDao;
import com.cloud.icenter.yyzx.fzjc.nync.pojo.AnimalHusbandry;
import com.cloud.icenter.yyzx.fzjc.nync.pojo.AnimalProduct;
import com.cloud.icenter.yyzx.fzjc.nync.pojo.SpecialProduct;

/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-08 15:37:41
*/
@Repository
public class AnimalProductDaoImpl extends BaseDaoImpl<AnimalProduct> implements AnimalProductDao {
	/*
	 * 根据类别获取最近一个年度的畜牧产品价格数据
	 * lb[1:猪肉；2：牛肉；3：羊肉；4：鸡蛋；]
	 */
	public List<AnimalProduct> getHistoryPrice(int lb){
		Calendar now=Calendar.getInstance();
		int year=now.get(now.YEAR)-1;
		try{
			DetachedCriteria criteria=DetachedCriteria.forClass(AnimalProduct.class);			
			criteria.add(Restrictions.eq("lb", lb));
			criteria.addOrder(Order.asc("year"));
			return super.find(criteria);			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}