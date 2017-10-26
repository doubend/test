package com.cloud.icenter.yyzx.cszc.tjfx.dao;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.common.query.CategorySum;
import com.cloud.icenter.yyzx.cszc.dtzs.pojo.CszcDetailsPojo;
import com.cloud.icenter.yyzx.cszc.dtzs.pojo.CszcInfoPojo;
import com.cloud.icenter.yyzx.cszc.tjfx.pojo.BaseInfo;



/**
* Created with gender.
* @author: liyao,whcai
* Date: 2017-04-23 17:57:20
*/
public interface BaseInfoDao extends BaseDao<BaseInfo> {
	public List<String> getYears();
	public List<CategorySum> getRegionCount(String year);
	public List<CategorySum> getYearCount(String ejflbh);
	public List<CategorySum> getRepairTimeByReason();
	public List<CategorySum> getRepairTimeByRegion();
	
	/**
	 * 通过部件名称查询城市资产
	 * @param zcmc
	 * @return
	 */
	public List<CszcInfoPojo> queryCszcByName(String zcmc);
	
	/**
	 * 查询城市资产
	 * @param zcmc   资产名称
	 * @param xzqmc  行政区名称
	 * @param ztmc   状态名称
	 */
	public List<CszcInfoPojo> queryCszcByZcmcAndQxAndZt(String zcmc, String xzqmc, String ztmc);
	
	/**
	 * 根据资产名称和资产状态按区查询资产数量
	 * @param zcmc
	 * @param zczt 资产状态代码[1,2,3,4]
	 * @return
	 */
	public List<Integer> getCountByZcmcAndZczt(String zcmc, int zczt);
	
	public List<CategorySum> supplyResult(List inRes);
	
	/**
	 * 根据资产名称查询资产近年发展情况
	 * @param zcmc
	 * @return
	 */
	public List<Integer> getCountByZcmcAndYear(String zcmc);
	
	/**
	 * 根据资产名称查询资产各状态数量
	 * @param zcmc
	 * @return
	 */
	public List<Integer> getCszcZtfb(String zcmc);
	
	/**
	 * 根据资产名称获取资产详情
	 * @param zcmc 资产名称
	 * @param zymc 资源名称
	 * @param zczt 资产状态
	 * @param xzqmc行政区划名称
	 * @return
	 */
	public List<CszcDetailsPojo> getCszcDetailsInfo(String zcmc, String zymc, String zczt, String xzqmc);
	
	/**
	 * 获取各类城市资产数量
	 * @return
	 */
	public List<Integer> getAllCszcCount();
	
	/**
	 * 获取各类型学校数量
	 * @return
	 */
	public List<Integer> getXxlxCount();
	
	/**
	 * 根据学校类型获取各区县学校数量
	 * @param xxlx
	 * @return
	 */
	public List<Integer> getSchoolCountByXxlx(String xxlx);
	
	/**
	 * 获取城市资产各一级分类各区县数量
	 * @param zclx
	 * @return
	 */
	public List<Integer> getCszcCountQyfb(String zclx);
	
	/**
	 * 获取各类型学校数量统计
	 * @return
	 */
	public List<Integer> getSchoolCount();
	
	/**
	 * 获取教育资金分布情况
	 * @return
	 */
	public List<Map<String, Object>> getJyzjFbqk();
	
	/**
	 * 获取学校生源分布情况
	 * @return
	 */
	public List<Map<String, Object>> getXxsyFbqk();
	
	/**
	 * 获取小学招生人数分布情况
	 * @return
	 */
	public List<Integer> getZsrsFbqk();
	
	/**
	 * 获取义务教育适龄人口分布情况
	 * @return
	 */
	public List<Integer> getSlrkFbqk();
	
	/**
	 * 各类型基础设施不同年份坐标获取
	 */
	public JSONObject getAllData(String ejflbh);
	
	/**
	 * 获取城市资产树结构模型数据
	 * @return
	 */
	public JSONArray queryCszcModelData();
}