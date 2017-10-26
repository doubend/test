package com.cloud.icenter.yyzx.fzjc.fr.service;

import java.util.List;

import com.cloud.icenter.yyzx.fzjc.fr.pojo.FRCapitalPojo;
import com.cloud.icenter.yyzx.fzjc.fr.pojo.FREconNsPojo;
import com.cloud.icenter.yyzx.fzjc.fr.pojo.FREconPojo;
import com.cloud.icenter.yyzx.fzjc.fr.pojo.FRQyhyPojo;
import com.cloud.icenter.yyzx.fzjc.fr.pojo.FRQyinfoPojo;
import com.cloud.icenter.yyzx.fzjc.fr.pojo.FRRegonPojo;
import com.cloud.icenter.yyzx.fzjc.fr.pojo.FRTop5Pojo;
import com.cloud.icenter.yyzx.fzjc.fr.pojo.FRTop8Pojo;
import com.cloud.icenter.yyzx.fzjc.fr.pojo.FRZxwPojo;

public interface FRService {
	public List<FRCapitalPojo> getCurCapital();

	public List<FRCapitalPojo> getCapitalByYear(int year);

	public List<FREconPojo> getCurEcon();

	public List<FREconPojo> getEconByYear(int year);

	public List<FREconNsPojo> getCurEconNs();

	public List<FREconNsPojo> getEconNsByYear(int year);

	public List<FRRegonPojo> getCurRegon();

	public List<FRRegonPojo> getRegonByYear(int year);

	public List<FRZxwPojo> getFiveYearZxw();

	public FRZxwPojo getZxwByYear(int year);

	public List<FRQyhyPojo> getCurQyhy();

	public List<FRQyhyPojo> getQyhyByYear(int year);

	public List<FRQyinfoPojo> getCurQyinfo();

	public List<FRQyinfoPojo> getQyinfoByYear(int year);

	public List<FRTop5Pojo> getCurTop5();

	public List<FRTop8Pojo> getCurTop8();
}
