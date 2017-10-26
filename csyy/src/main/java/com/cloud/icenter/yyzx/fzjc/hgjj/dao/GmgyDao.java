package com.cloud.icenter.yyzx.fzjc.hgjj.dao;

import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.fzjc.hgjj.pojo.GmgyCzgc;
import com.cloud.icenter.yyzx.fzjc.hgjj.pojo.GmgyLnsh;
import com.cloud.icenter.yyzx.fzjc.hgjj.pojo.GmgyTop;

/**
 * 规模工业
 * @author Administrator
 *
 */
public interface GmgyDao extends BaseDao<GmgyLnsh>{
	
	public List<GmgyLnsh> getGmgyLnshList();
	
	public List<GmgyTop> getGmgyTopList();
	
	public List<GmgyCzgc> getGmgyCzgcList();

}
