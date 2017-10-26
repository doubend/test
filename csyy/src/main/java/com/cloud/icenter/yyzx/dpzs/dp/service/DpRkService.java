package com.cloud.icenter.yyzx.dpzs.dp.service;

import java.util.List;

import com.cloud.icenter.yyzx.fzjc.rk.pojo.Agestructure;
import com.cloud.icenter.yyzx.fzjc.rk.pojo.Newborn;

public interface DpRkService {
	public List<Agestructure> getAgestructureList();
	public List<Newborn> getNewBornList();
}
