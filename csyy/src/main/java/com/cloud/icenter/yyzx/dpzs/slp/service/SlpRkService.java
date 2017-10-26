package com.cloud.icenter.yyzx.dpzs.slp.service;

import java.util.List;

import com.cloud.icenter.yyzx.dpzs.slp.pojo.SlpRkDbPojo;
import com.cloud.icenter.yyzx.dpzs.slp.pojo.SlpRkDbrqPojo;
import com.cloud.icenter.yyzx.dpzs.slp.pojo.SlpRkNljgPojo;
import com.cloud.icenter.yyzx.dpzs.slp.pojo.SlpRkfbPojo;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Agestructure;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Newborn;

public interface SlpRkService {

	public List<SlpRkDbPojo> getCurDbFiveYear();

	public SlpRkDbPojo getDbByYear(int year);

	public List<SlpRkDbrqPojo> getCurDbrq();

	public List<SlpRkfbPojo> getRkfbByYear(int year);
	
	public List<Newborn> getNewBornList();

	public List<SlpRkNljgPojo> getRkNljgList();

}
