package com.cloud.icenter.yyzx.cszc.tjfx.service;

import java.util.List;

import com.cloud.icenter.base.service.BaseService;
import com.cloud.icenter.yyzx.cszc.tjfx.pojo.WhcdNCPojo;
import com.cloud.icenter.yyzx.cszc.tjfx.pojo.WhcdPojo;

/**
 * 教育分析--文化程度分析
 * @date 2017年10月11日
 * @author dxliug
 */
public interface EducationService extends BaseService<WhcdPojo>{
    /**
     * 文化程度基本信息--学校数量--表格信息
     * @param year
     * @return
     */
	List<WhcdPojo> getWhcdResult(String year,String areas);
      /**
       * 表格信息
       * @param year
       * @param areas
       * @return
       */
	List<WhcdPojo> getWhcdArea(String year, String areas);
	/**
	 * 教育占比
	 * @param year
	 * @param areas
	 * @return
	 */
	List<WhcdPojo> getWhcdZB(String year, String areas);
	/**
	 * 农村城镇人口文化信息
	 * @param year
	 * @param areas
	 * @return
	 */
	List<WhcdNCPojo> getWhcdNC(String year, String areas);

}
