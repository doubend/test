
package com.cloud.icenter.yyzx.cszc.tjfx.dao;

import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.common.query.CategorySum;
import com.cloud.icenter.yyzx.cszc.tjfx.pojo.RepairInfo;

/**
* Created with gender.
* @author: liyao
* Date: 2017-04-19 14:27:14
*/
public interface RepairInfoDao extends BaseDao<RepairInfo> {
	public List<CategorySum> getCountByBjlx(String code);
	public List<CategorySum> getYhpc(String code,String status);
	public List<CategorySum> getSjsysm();
	public List<CategorySum> predictNextYear();
	public List<CategorySum> predictYearAfterYear();
	
	/**
     * 获取累计养护次数
     * @param zcmc
     * @return
     */
    public List<Integer> getLjyhcsByZcmc(String zcmc);
}