
package com.cloud.icenter.yyzx.fzjc.nync.dao;

import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.fzjc.nync.pojo.SpecialProduct;


/**
* @author: yaoli
* Date: 2017-03-02 18:32:42
*/
public interface SpecialProductDao extends BaseDao<SpecialProduct> {
	public List<SpecialProduct> getSpecialSummary();
	public List<SpecialProduct> getSpecialInvestment(int specialType);
}