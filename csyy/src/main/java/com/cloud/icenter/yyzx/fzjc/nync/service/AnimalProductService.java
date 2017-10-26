package com.cloud.icenter.yyzx.fzjc.nync.service;

import java.util.List;

import com.cloud.icenter.base.service.BaseService;
import com.cloud.icenter.yyzx.fzjc.nync.pojo.AnimalProduct;



/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-08 15:37:41
*/
public interface AnimalProductService extends BaseService<AnimalProduct> {
	public List<AnimalProduct> getHistoryPrice(int lb);
}