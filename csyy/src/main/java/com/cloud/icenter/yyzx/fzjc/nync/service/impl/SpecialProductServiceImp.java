package com.cloud.icenter.yyzx.fzjc.nync.service.impl;

import java.util.List;

import org.apache.cxf.annotations.Logging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.yyzx.fzjc.nync.dao.SpecialProductDao;
import com.cloud.icenter.yyzx.fzjc.nync.pojo.SpecialProduct;
import com.cloud.icenter.yyzx.fzjc.nync.service.SpecialProductService;

/**
* @author: yaoli
* Date: 2017-03-02 18:32:42
*/
@Logging
@Service
public class SpecialProductServiceImp extends BaseServiceImpl<SpecialProduct>  implements SpecialProductService{
	@Autowired
	private SpecialProductDao specialProductDao;
	public List<SpecialProduct> getSpecialSummary(){
		return specialProductDao.getSpecialSummary();
	}
	public List<SpecialProduct> getSpecialInvestment(int specialType){
		return specialProductDao.getSpecialInvestment(specialType);
	}
}