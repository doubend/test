package com.cloud.icenter.yyzx.fzjc.rk.dao;

import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Agestructure;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.MzzjAreaResult;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.MzzjResult;

/**
 * 民族宗教dao
 * @date 2017年9月27日
 * @author dxliug
 */
public interface MzzjDao extends BaseDao<MzzjResult>{
    
	List<MzzjResult> getRenkMzzj(String year);

	List<MzzjAreaResult> getRenkMzzjArea(String year);

	List<Agestructure> getRenkMzzjAge(String year);

}
