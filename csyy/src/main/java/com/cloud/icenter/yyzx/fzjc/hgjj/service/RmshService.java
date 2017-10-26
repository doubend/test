package com.cloud.icenter.yyzx.fzjc.hgjj.service;

import java.util.List;

import com.cloud.icenter.base.service.BaseService;
import com.cloud.icenter.yyzx.fzjc.hgjj.pojo.RmshGksj;
import com.cloud.icenter.yyzx.fzjc.hgjj.pojo.RmshLnsh;
import com.cloud.icenter.yyzx.fzjc.hgjj.pojo.RmshShru;
import com.cloud.icenter.yyzx.fzjc.hgjj.pojo.RmshXfjg;

public interface RmshService extends BaseService<RmshGksj>{
	
	public RmshGksj getRmshGksj();
	
	public List<RmshLnsh> getRmshLnshList();
	
	public List<RmshXfjg> getRmshXfjgList();
	
	public RmshShru getRmshShruList();

}
