package com.cloud.icenter.yyzx.cszc.tjfx.dao;

import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.cszc.tjfx.pojo.CszcJyfzfxDqPoJo;
import com.cloud.icenter.yyzx.cszc.tjfx.pojo.CszcJyfzfxDsjPojo;
import com.cloud.icenter.yyzx.cszc.tjfx.pojo.CszcJyfzfxNfPoJo;

/** 
* @author zhucy 
* @version 2017年4月20日 下午5:43:26 
* 说明 
*/
public interface CszcJyfzfxDao extends BaseDao<CszcJyfzfxNfPoJo>{
	/**
	 * 基础教育发展
	 * @return
	 */
	List<CszcJyfzfxNfPoJo> getJcjyfz();
	
	/**
	 * 职业教育发展
	 * @return
	 */
	List<CszcJyfzfxNfPoJo> getZyjyfz();
	
	/**
	 * 基础教育分布
	 * @return
	 */
	List<CszcJyfzfxDqPoJo> getJcjyfb();
	
	/**
	 * 教育发展详情
	 * @return
	 */
	List<CszcJyfzfxNfPoJo> getJyfzxq();
	
	/**
	 * 教育大事记
	 * @return
	 */
	List<CszcJyfzfxDsjPojo> getDsjTopSix();
	
	/**
	 * 教育大事记列表
	 * @return
	 */
	List<CszcJyfzfxDsjPojo> getDsjList();
}
