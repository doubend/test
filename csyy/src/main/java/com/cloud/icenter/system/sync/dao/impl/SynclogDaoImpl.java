package com.cloud.icenter.system.sync.dao.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.system.organ.pojo.Organ;
import com.cloud.icenter.system.role.pojo.Role;
import com.cloud.icenter.system.sync.dao.SynclogDao;
import com.cloud.icenter.system.sync.pojo.Synclog;
import com.cloud.icenter.system.user.pojo.User;


@Repository
public class SynclogDaoImpl extends BaseDaoImpl<Synclog> implements SynclogDao{

	@Override
	@Transactional(readOnly=true)
	public List<Synclog> getSynclog(String starttime, String endtime) {
		List<Synclog> l = null;
		String queryString = "from Synclog a where a.createdAt between str_to_date('"+starttime+"','%Y%m%d%H%i%s') and str_to_date('"+endtime+"','%Y%m%d%H%i%s')"
							+ " and not exists (select 1 from Synclog where createdAt between str_to_date('"+starttime+"','%Y%m%d%H%i%s') and str_to_date('"+endtime+"','%Y%m%d%H%i%s')"
									+ " and a.syncTable=syncTable and a.syncId=syncId and a.createdAt<createdAt)";
		Query q = getSession().createQuery(queryString);
		l = q.list();
		return l;
	}

	
	/**
	 *  保存Synclog日志
	 * @param Logs
	 * @return
	 */
	public void saveSynclog(Object pojo,String type) {
		Synclog synclog = null;
		if(pojo instanceof Organ){
			Organ organ = (Organ)pojo;
			synclog=newSynclog(pojo,organ.getOrgId(),type);
		}
		
		else if(pojo instanceof Role){
			Role role = (Role)pojo;
			synclog=newSynclog(pojo,role.getRoleId(),type);
		}
		
		else if(pojo instanceof User){
			User user = (User)pojo;
			synclog=newSynclog(pojo,user.getUserId(),type);
		}
		if(synclog!=null){
			super.add(synclog);
		}
	}
	
	/**
	 *  快速创建一个Synclog对象
	 * @param Logs
	 * @return
	 */
	private Synclog newSynclog(Object pojo,String SyncId,String type) {
		Synclog synclog = new Synclog();
		synclog.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		synclog.setSyncTable(pojo.getClass().getSimpleName());
		synclog.setSyncType(type);
		synclog.setSyncId(SyncId);
		return synclog;
	}
	
	
}
