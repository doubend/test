
package com.cloud.icenter.yyzx.cszc.tjfx.service.impl;

import java.util.List;

import org.apache.cxf.annotations.Logging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.yyzx.common.query.CategorySum;
import com.cloud.icenter.yyzx.cszc.tjfx.dao.RepairInfoDao;
import com.cloud.icenter.yyzx.cszc.tjfx.pojo.RepairInfo;
import com.cloud.icenter.yyzx.cszc.tjfx.service.RepairInfoService;

/**
* Created with gender.
* @author: liyao
* Date: 2017-04-19 14:27:14
*/
@Logging
@Service
public class RepairInfoServiceImp extends BaseServiceImpl<RepairInfo>  implements RepairInfoService{
	@Autowired private RepairInfoDao repairDao;
	public List<CategorySum> getCountByBjlx(String code){
		return repairDao.getCountByBjlx(code);
	}
	public List<CategorySum> getYhpc(String code,String status){
		return repairDao.getYhpc(code, status);
	}
	public List<CategorySum> getSjsysm(){
		return repairDao.getSjsysm();
	}
	public List<CategorySum> predictNextYear(){
		return repairDao.predictNextYear();
	}
	public List<CategorySum> predictYearAfterYear(){
		return repairDao.predictYearAfterYear();
	}
	
	public List<Integer> getLjyhcsByZcmc(String zcmc){
		return repairDao.getLjyhcsByZcmc(zcmc);
	}
}