package com.cloud.icenter.yyzx.dpzs.dp.service;

import java.util.List;

import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpFrFrfbPojo;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpFrFrqyryPojo;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpFrFrzbPojo;
import com.cloud.icenter.yyzx.dpzs.dp.pojo.DpFrQyjyzqPojo;
import com.cloud.icenter.yyzx.fzjc.fr.pojo.FRQyhyPojo;
import com.cloud.icenter.yyzx.fzjc.fr.pojo.FRRegonPojo;
import com.cloud.icenter.yyzx.fzjc.fr.pojo.FRZxwPojo;

public interface DpFrService {
	public List<DpFrQyjyzqPojo> getCurQyjyzq();

	public List<DpFrQyjyzqPojo> getQyjyzqByYear(int year);

	public List<DpFrFrfbPojo> getCurFb();

	public List<FRRegonPojo> getRegonByNameSevevYear(String regonName);

	public List<FRQyhyPojo> getCurQyhy();

	public List<DpFrFrqyryPojo> getCurQyry();

	public List<DpFrFrqyryPojo> getQyryByYear(int year);

	public List<FRZxwPojo> getSevenYearZxw();
	
	public List<DpFrFrzbPojo> getCurFrzb(int year, String qyhy, String qyxz);
	
	

}
