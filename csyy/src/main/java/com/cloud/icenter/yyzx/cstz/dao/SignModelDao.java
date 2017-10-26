
package com.cloud.icenter.yyzx.cstz.dao;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.cstz.pojo.CstzAllBusPojo;
import com.cloud.icenter.yyzx.cstz.pojo.CstzCommonPojo;
import com.cloud.icenter.yyzx.cstz.pojo.SignModel;
import com.cloud.icenter.yyzx.cstz.pojo.ZbphPojo;

/**
* Created with gender.
* @author: whcai
* Date: 2017-03-20 15:49:08
*/
public interface SignModelDao extends BaseDao<SignModel> {

	/**
	 * 获取最新体征数据
	 * @return
	 */
	public List<CstzCommonPojo> getTheNewestSign();
	
	/**
	  * @author zhucy 
	  * @version 2017年7月25日 上午9:53:18 
	  * 说明:获取当前体征下级分值较低的体征数据
	 */
	public List<CstzCommonPojo> getZcTzsjById(String id);
	
	public List<CstzCommonPojo> getZcTzsjByName(String name);
	
	/**
	 * 获取综合体征最新日期
	 * @return
	 */
	public Map<String, Integer> getTheNewestDate();
	
	/**
	 * 获取该体征和它的下级体征ID集合
	 * @return
	 */
	public List<Integer> getJuniorSignID(String tzmc);
	
	/**
	 * 根据二级体征名称获取该体征最下级业务体征的ID集合
	 * @return
	 */
	public List<Integer> getJuniorBusID(String tzmc);
	
	/**
	 * 获取最新该体征和它下级体征数据(该方法已废弃！)
	 * @return
	 */
	public List<Map<String,Object>> getJuniorSign(List<Integer> lstSignID);
	
	/**
	 * 获取最新该体征和它下级体征数据
	 */
	public List<CstzCommonPojo> getJuniorSignData(String tzmc);
	
	/**
	 * 获取最新该体征和它下级体征数据
	 */
	public List<CstzCommonPojo> getJuniorSignDataByID(String tzID);
	
	/**
	 * 获取四级体征占综合体征复合权重(该方法已废弃！)
	 * @return
	 */
	public Map<String, Float> getFourthComplexQz(List<Integer> lstID);
	
	/**
	 * 获取四级体征占综合体征复合权重
	 * @return
	 */
	public List<CstzCommonPojo> getBusSignComplexQz();
	
	/**
	 * 获取第四级体征占第二级体征复合权重
	 * @param tzmc
	 * @return
	 */
	public List<CstzCommonPojo> getComplexQzByTzmc(String tzmc);
	
	/**
	 * 获取第四级体征根据体征贡献值排序后的集合
	 * @return
	 */
	public List<CstzCommonPojo> getSignContributionSort(List<CstzCommonPojo> lstQz);
	
	/**
	 * 获取某二级体征下的所有第四级体征根据体征贡献值排序后的集合
	 * @param tzmc
	 * @return
	 */
	public List<CstzCommonPojo> getSignContributionByTzmc(List<CstzCommonPojo> lstQz, String tzmc);
	
	/**
	 * 获取最差指标Top5
	 * @return
	 */
	public List<CstzCommonPojo> getWorstTop(List<CstzCommonPojo> lstSign, int topNum);
	
	/**
	 * 获取最优指标Top5
	 * @return
	 */
	public List<CstzCommonPojo> getOptimalTop(List<CstzCommonPojo> lstSign, int topNum);
	
	/**
	 * 获取全部指标
	 * @param mapQz
	 * @return
	 */
	public List<CstzAllBusPojo> getAllBusIndex(List<CstzCommonPojo> lstQz, int topNum);
	
	/**
	 * 根据体征ID和年份查询历史体征值
	 * @param signID
	 * @param nf
	 * @return
	 */
	/** zhucy 20170613注释 **/
//	public List<Double> getLstzByIdAndYear(String tzID, int nf);
	public Map<String, Object> getLstzByIdAndYear(String tzID, int nf);
	
	/**
	 * 根据体征名称和年份查询历史体征值
	 * @param signID
	 * @param nf
	 * @return
	 */
	/** zhucy 20170613注释 **/
//	public List<Double> getLstzByNameAndYear(String tzmc, int nf);
	public Map<String, Object> getLstzByNameAndYear(String tzmc, int nf);
	
	/**
	 * 获取专题体征一级页面指标排行数据
	 * @param tzmc
	 * @return
	 */
	public List<CstzCommonPojo> getZttzOneIndexRank(String tzID);
	
	/**
	 * 获取专题体征一级页面指标排行数据 zhucy 20170616
	 * @param tzmc
	 * @return
	 */
	public List<ZbphPojo> getZttzOneIndexRankNew(String tzID);
	
	/**
	 * 获取专题体征二级页面数据
	 * @param signID
	 * @return
	 */
	public List<CstzCommonPojo> getZttzTwoData(String tzID);
	
	/**
	 * 根据体征ID获取最新体征数据（历史体征页面）
	 * @param signID
	 * @return
	 */
	public List<CstzCommonPojo> getNewestZhtzData(String tzmc);
	
	/**
	 * 根据周或者月获取最近时间的体征数据
	 * @param tzmc
	 * @param nf
	 * @param index
	 * @return
	 */
	public Map<String, Object> getLstzByIndex(String tzmc, int nf, int index);
	
	public Map<String, Object> getLstzByIndexById(String tzID, int nf, int index);
	
	/**
	 * 查询城市体征模型数据
	 * @return
	 */
	public JSONArray queryCstzModelData();
	
	/**
	 * 综合体征一级页面指标排行数据获取
	 * @param type 数据类型 0：最差 1：最优 2：全部
	 * @return
	 */
	public List<ZbphPojo> getZhtzYjZbphData(int type);
	
	/**
	 * 
	 * @param tzmc 体征名称
	 * @param type 数据类型 0：最差 1：最优 2：全部
	 * @return
	 */
	public List<ZbphPojo> geteZhtzEjZbphData(String tzmc,int type);
}