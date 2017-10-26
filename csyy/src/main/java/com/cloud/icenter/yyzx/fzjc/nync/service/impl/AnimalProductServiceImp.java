
package com.cloud.icenter.yyzx.fzjc.nync.service.impl;

import java.util.List;

import org.apache.cxf.annotations.Logging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.yyzx.fzjc.nync.dao.AnimalProductDao;
import com.cloud.icenter.yyzx.fzjc.nync.pojo.AnimalProduct;
import com.cloud.icenter.yyzx.fzjc.nync.service.AnimalProductService;
/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-08 15:37:41
*/
@Logging
@Service
public class AnimalProductServiceImp extends BaseServiceImpl<AnimalProduct>  implements AnimalProductService{
	@Autowired
	private AnimalProductDao animalProductDao;
	public List<AnimalProduct> getHistoryPrice(int lb){
		return animalProductDao.getHistoryPrice(lb);
	}
}