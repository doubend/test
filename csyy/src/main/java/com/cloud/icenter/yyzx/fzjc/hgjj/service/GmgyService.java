package com.cloud.icenter.yyzx.fzjc.hgjj.service;

import java.util.List;

import com.cloud.icenter.base.service.BaseService;
import com.cloud.icenter.yyzx.fzjc.hgjj.pojo.GmgyCzgc;
import com.cloud.icenter.yyzx.fzjc.hgjj.pojo.GmgyLnsh;
import com.cloud.icenter.yyzx.fzjc.hgjj.pojo.GmgyTop;

public interface GmgyService extends BaseService<GmgyLnsh>{
	
	public List<GmgyLnsh> getGmgyLnshList();
	
	public List<GmgyTop> getGmgyTopList();
	
	List<GmgyCzgc> getGmgyCzgcList();

}
