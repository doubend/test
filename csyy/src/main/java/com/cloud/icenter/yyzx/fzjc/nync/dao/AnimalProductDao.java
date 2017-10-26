
package com.cloud.icenter.yyzx.fzjc.nync.dao;


import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.fzjc.nync.pojo.AnimalProduct;

/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-08 15:37:41
*/
public interface AnimalProductDao extends BaseDao<AnimalProduct> {
	public List<AnimalProduct> getHistoryPrice(int lb);
}