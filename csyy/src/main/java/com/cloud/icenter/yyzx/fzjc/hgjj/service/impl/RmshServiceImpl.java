package com.cloud.icenter.yyzx.fzjc.hgjj.service.impl;

import java.util.List;

import org.apache.cxf.annotations.Logging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.yyzx.fzjc.hgjj.dao.RmshDao;
import com.cloud.icenter.yyzx.fzjc.hgjj.pojo.RmshGksj;
import com.cloud.icenter.yyzx.fzjc.hgjj.pojo.RmshLnsh;
import com.cloud.icenter.yyzx.fzjc.hgjj.pojo.RmshShru;
import com.cloud.icenter.yyzx.fzjc.hgjj.pojo.RmshXfjg;
import com.cloud.icenter.yyzx.fzjc.hgjj.service.RmshService;
/**
 * 人民生活
 * @author Administrator
 *
 */
@Logging
@Service
public class RmshServiceImpl extends BaseServiceImpl<RmshGksj> implements RmshService {
	
	@Autowired
	private RmshDao rmshDao;

	@Override
	public RmshGksj getRmshGksj() {
		return rmshDao.getRmshGksj();
	}

	@Override
	public List<RmshLnsh> getRmshLnshList() {
		return rmshDao.getRmshLnshList();
	}

	@Override
	public List<RmshXfjg> getRmshXfjgList() {
		return rmshDao.getRmshXfjgList();
	}

	@Override
	public RmshShru getRmshShruList() {
		return rmshDao.getRmshShruList();
	}

}
