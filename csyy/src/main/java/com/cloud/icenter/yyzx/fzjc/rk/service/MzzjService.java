package com.cloud.icenter.yyzx.fzjc.rk.service;

import java.util.List;

import com.cloud.icenter.base.service.BaseService;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Agestructure;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Distribution;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.MzzjAreaResult;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.MzzjResult;

/**
 * 民族宗教service
 * @date 2017年9月27日
 * @author dxliug
 */
public interface MzzjService extends BaseService<MzzjResult> {
    /**
     * 民族宗教人口数与占比
     * @return
     */
	List<MzzjResult> getRenkMzzj(String year);
      /**
       * 民族宗教区域分布图
       * @param year
       * @return
       */
	List<MzzjAreaResult> getRenkMzzjArea(String year);
	/**
	 * 信教男女年龄段人口
	 * @param year
	 * @return
	 */
	List<Agestructure> getRenkMzzjAge(String year);

}
