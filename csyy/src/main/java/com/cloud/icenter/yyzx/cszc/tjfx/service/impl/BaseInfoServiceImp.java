package com.cloud.icenter.yyzx.cszc.tjfx.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.cxf.annotations.Logging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.yyzx.common.query.CategorySum;
import com.cloud.icenter.yyzx.cszc.dtzs.pojo.CszcDetailsPojo;
import com.cloud.icenter.yyzx.cszc.dtzs.pojo.CszcInfoPojo;
import com.cloud.icenter.yyzx.cszc.tjfx.dao.BaseInfoDao;
import com.cloud.icenter.yyzx.cszc.tjfx.pojo.BaseInfo;
import com.cloud.icenter.yyzx.cszc.tjfx.service.BaseInfoService;

/**
* Created with gender.
* @author: liyao,whcai
* Date: 2017-04-23 17:57:20
*/
@Logging
@Service
public class BaseInfoServiceImp extends BaseServiceImpl<BaseInfo>  implements BaseInfoService{
	@Autowired private BaseInfoDao baseInfoDao;
	public List<String> getYears(){
		return baseInfoDao.getYears();
	}
	public List<CategorySum> getRegionCount(String year){
		return baseInfoDao.getRegionCount(year);
		}
	public List<CategorySum> getYearCount(String ejflbh){
		return baseInfoDao.getYearCount(ejflbh);
	}

	public List<CategorySum> getRepairTimeByReason(){
		return baseInfoDao.getRepairTimeByReason();
	}
	public List<CategorySum> getRepairTimeByRegion(){
		return baseInfoDao.getRepairTimeByRegion();
	}
	
	public List<CszcInfoPojo> queryCszcByName(String zcmc){
		return baseInfoDao.queryCszcByName(zcmc);
	}
	
	public List<CszcInfoPojo> queryCszcByZcmcAndQxAndZt(String zcmc, String xzqmc, String ztmc){
		return baseInfoDao.queryCszcByZcmcAndQxAndZt(zcmc, xzqmc, ztmc);
	}
	
	public List<Integer> getCountByZcmcAndZczt(String zcmc, int zczt){
		return baseInfoDao.getCountByZcmcAndZczt(zcmc, zczt);
	}
	
	public List<CategorySum> supplyResult(List inLst){
		return baseInfoDao.supplyResult(inLst);
	}

	public List<Integer> getCountByZcmcAndYear(String zcmc){
		return baseInfoDao.getCountByZcmcAndYear(zcmc);
	}

	public List<Integer> getCszcZtfb(String zcmc){
		return baseInfoDao.getCszcZtfb(zcmc);
	}
	
	public List<CszcDetailsPojo> getCszcDetailsInfo(String zcmc, String zymc, String zczt, String xzqmc){
		return baseInfoDao.getCszcDetailsInfo(zcmc, zymc, zczt, xzqmc);
	}

	public List<Integer> getAllCszcCount(){
		return baseInfoDao.getAllCszcCount();
	}

	public List<Integer> getXxlxCount(){
		return baseInfoDao.getXxlxCount();
	}
	
	public List<Integer> getSchoolCountByXxlx(String xxlx){
		return baseInfoDao.getSchoolCountByXxlx(xxlx);
	}
	
	public List<Integer> getCszcCountQyfb(String zclx){
		return baseInfoDao.getCszcCountQyfb(zclx);
	}
	
	public List<Integer> getSchoolCount(){
		return baseInfoDao.getSchoolCount();
	}
	
	public List<Map<String, Object>> getJyzjFbqk(){
		return baseInfoDao.getJyzjFbqk();
	}

	public List<Map<String, Object>> getXxsyFbqk(){
		return baseInfoDao.getXxsyFbqk();
	}
	
	public List<Integer> getZsrsFbqk(){
		return baseInfoDao.getZsrsFbqk();
	}
	
	public List<Integer> getSlrkFbqk(){
		return baseInfoDao.getSlrkFbqk();
	}
	
	public JSONObject getAllData(String ejflbh){
		return baseInfoDao.getAllData(ejflbh);
	}
	
	public JSONArray queryCszcModelData(){
		return baseInfoDao.queryCszcModelData();
	}
}