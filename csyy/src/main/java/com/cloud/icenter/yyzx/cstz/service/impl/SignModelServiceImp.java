
package com.cloud.icenter.yyzx.cstz.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.system.logs.pojo.Logging;
import com.cloud.icenter.yyzx.cstz.dao.SignModelDao;
import com.cloud.icenter.yyzx.cstz.pojo.CstzAllBusPojo;
import com.cloud.icenter.yyzx.cstz.pojo.CstzCommonPojo;
import com.cloud.icenter.yyzx.cstz.pojo.SignModel;
import com.cloud.icenter.yyzx.cstz.pojo.ZbphPojo;
import com.cloud.icenter.yyzx.cstz.service.SignModelService;

/**
* Created with gender.
* @author: whcai
* Date: 2017-03-20 15:49:08
*/
@Logging
@Service
public class SignModelServiceImp extends BaseServiceImpl<SignModel>  implements SignModelService{

	@Autowired
	private SignModelDao signModelDao;
	
	public List<CstzCommonPojo> getTheNewestSign(){
		return signModelDao.getTheNewestSign();
	}
	
	public Map<String, Integer> getTheNewestDate(){
		return signModelDao.getTheNewestDate();
	}
	
	public List<Integer> getJuniorSignID(String tzmc){
		return signModelDao.getJuniorSignID(tzmc);
	}
	
	public List<Integer> getJuniorBusID(String tzmc){
		return signModelDao.getJuniorBusID(tzmc);
	}
	
	public List<Map<String,Object>> getJuniorSign(List<Integer> lstSignID){
		return signModelDao.getJuniorSign(lstSignID);
	}
	
	public List<CstzCommonPojo> getJuniorSignData(String tzmc){
		return signModelDao.getJuniorSignData(tzmc);
	}
	
	public List<CstzCommonPojo> getJuniorSignDataByID(String tzID){
		return signModelDao.getJuniorSignDataByID(tzID);
	}
	
	public Map<String, Float> getFourthComplexQz(List<Integer> lstID){
		return signModelDao.getFourthComplexQz(lstID);
	}

	public List<CstzCommonPojo> getComplexQzByTzmc(String tzmc){
		return signModelDao.getComplexQzByTzmc(tzmc);
	}
	
	public List<CstzCommonPojo> getBusSignComplexQz(){
		return signModelDao.getBusSignComplexQz();
	}
	
	public List<CstzCommonPojo> getSignContributionSort(List<CstzCommonPojo> lstQz){
		return signModelDao.getSignContributionSort(lstQz);
	}
	
	public List<CstzCommonPojo> getSignContributionByTzmc(List<CstzCommonPojo> lstQz, String tzmc){
		return signModelDao.getSignContributionByTzmc(lstQz, tzmc);
	}
	
	public List<CstzCommonPojo> getWorstTop(List<CstzCommonPojo> lstSign, int topNum){
		return signModelDao.getWorstTop(lstSign, topNum);
	}
	
	public List<CstzCommonPojo> getOptimalTop(List<CstzCommonPojo> lstSign, int topNum){
		return signModelDao.getOptimalTop(lstSign, topNum);
	}
	
	public List<CstzAllBusPojo> getAllBusIndex(List<CstzCommonPojo> lstQz, int topNum){
		return signModelDao.getAllBusIndex(lstQz, topNum);
	}
	/** zhucy 20170613注释 **/
//	public List<Double> getLstzByIdAndYear(String tzID, int nf){
//		return signModelDao.getLstzByIdAndYear(tzID, nf);
//	}
	
	public Map<String, Object> getLstzByIdAndYear(String tzID, int nf){
		return signModelDao.getLstzByIdAndYear(tzID, nf);
	}
	/** zhucy 20170613注释 **/
//	public List<Double> getLstzByNameAndYear(String tzmc, int nf){
//		return signModelDao.getLstzByNameAndYear(tzmc, nf);
//	}
	
	public Map<String, Object> getLstzByNameAndYear(String tzmc, int nf){
		return signModelDao.getLstzByNameAndYear(tzmc, nf);
	}
	
	public List<CstzCommonPojo> getZttzOneIndexRank(String tzID){
		return signModelDao.getZttzOneIndexRank(tzID);
	}
	
	public List<CstzCommonPojo> getZttzTwoData(String tzID){
		return signModelDao.getZttzTwoData(tzID);
	}
	
	public List<CstzCommonPojo> getNewestZhtzData(String tzmc){
		return signModelDao.getNewestZhtzData(tzmc);
	}

	@Override
	public Map<String, Object> getLstzByIndex(String tzmc, int nf, int index) {
		return signModelDao.getLstzByIndex(tzmc, nf, index);
	}

	@Override
	public Map<String, Object> getLstzByIndexById(String tzID, int nf, int index) {
		return signModelDao.getLstzByIndexById(tzID, nf, index);
	}

	public JSONArray queryCstzModelData(){
		return signModelDao.queryCstzModelData();
	}

	@Override
	public List<ZbphPojo> getZhtzYjZbphData(int type) {
		// TODO Auto-generated method stub
		return signModelDao.getZhtzYjZbphData(type);
	}

	@Override
	public List<ZbphPojo> geteZhtzEjZbphData(String tzmc, int type) {
		// TODO Auto-generated method stub
		return signModelDao.geteZhtzEjZbphData(tzmc, type);
	}

	@Override
	public List<ZbphPojo> getZttzOneIndexRankNew(String tzID) {
		// TODO Auto-generated method stub
		return signModelDao.getZttzOneIndexRankNew(tzID);
	}

	@Override
	public List<CstzCommonPojo> getZcTzsjById(String id) {
		return signModelDao.getZcTzsjById(id);
	}

	@Override
	public List<CstzCommonPojo> getZcTzsjByName(String name) {
		
		return signModelDao.getZcTzsjByName(name);
		
	}
}