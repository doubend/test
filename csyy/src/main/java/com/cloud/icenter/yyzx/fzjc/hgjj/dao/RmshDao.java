package com.cloud.icenter.yyzx.fzjc.hgjj.dao;

import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.fzjc.hgjj.pojo.RmshGksj;
import com.cloud.icenter.yyzx.fzjc.hgjj.pojo.RmshLnsh;
import com.cloud.icenter.yyzx.fzjc.hgjj.pojo.RmshShru;
import com.cloud.icenter.yyzx.fzjc.hgjj.pojo.RmshXfjg;
/**
 * 人民生活
 * @author Administrator
 *
 */
public interface RmshDao  extends BaseDao<RmshGksj>{
	
	public RmshGksj getRmshGksj();
	
	
	public List<RmshLnsh> getRmshLnshList();
	
	
	public List<RmshXfjg> getRmshXfjgList();
	
	
	public RmshShru getRmshShruList();

}
