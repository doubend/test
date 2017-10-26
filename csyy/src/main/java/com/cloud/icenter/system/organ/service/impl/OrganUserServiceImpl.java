/**
 * 
 */
package com.cloud.icenter.system.organ.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.system.organ.dao.OrganUserDao;
import com.cloud.icenter.system.organ.pojo.Organ;
import com.cloud.icenter.system.organ.pojo.OrganUser;
import com.cloud.icenter.system.organ.service.OrganUserService;

/**
 * @author YHUA
 *
 */
@Service
public class OrganUserServiceImpl extends BaseServiceImpl<OrganUser> implements OrganUserService {
	
	@Autowired
	private OrganUserDao organUserDao;
	
	/**
	 * 
	 *(non-Javadoc)
	 * @see com.cloud.icenter.system.organ.service.OrganUserService#deleteFromOrgId(java.lang.String)
	 *
	 */
	@Override
	public void deleteFromOrgId(String orgId) {
		if(!StringUtils.isEmpty(orgId)){
			organUserDao.deleteFromOrgId(orgId);
		}
	}

	/**
	 * 
	 *(non-Javadoc)
	 * @see com.cloud.icenter.system.organ.service.OrganUserService#deleteFromUserId(java.lang.String)
	 *
	 */
	@Override
	public void deleteFromUserId(String userId) {
		if(!StringUtils.isEmpty(userId)){
			organUserDao.deleteFromUserId(userId);
		}
	}

	/**
	 * 
	 *(non-Javadoc)
	 * @see com.cloud.icenter.system.organ.service.OrganUserService#addBatch(java.lang.String[], java.lang.String)
	 *
	 */
	@Override
	public void addBatch(String[] userIds, String orgId) {
		if(!StringUtils.isEmpty(orgId) && !ArrayUtils.isEmpty(userIds)){
			Timestamp now = new Timestamp(System.currentTimeMillis());
			for(String userId : userIds){
				//需要判断人员是否存在于other组织机构中如果存在，移除关系
				OrganUser temp = this.findByUserIdAndOrgId(userId, Organ.OTHER_ID);
				if(temp != null){
					//如果存在， 移除关系
					organUserDao.delete(temp);
				}
				OrganUser ou = new OrganUser();
				ou.setCreateAt(now);
				ou.setOrgId(orgId);
				ou.setUserId(userId);
				this.save(ou);
			}
			return;
		}
		throw new RuntimeException("缺少必要的参数!");
	}
	
	

	/**
	 * 
	 *(non-Javadoc)
	 * @see com.cloud.icenter.system.organ.service.OrganUserService#addUserToOther(java.lang.String)
	 *
	 */
	@Override
	public void addUserToOther(String userId) {
		if(!StringUtils.isEmpty(userId)){
			OrganUser temp = new OrganUser();
			temp.setOrgId(Organ.OTHER_ID);
			temp.setUserId(userId);
			temp.setCreateAt(new Timestamp(System.currentTimeMillis()));
			this.save(temp);
			return;
		}
		throw new RuntimeException("缺少必要的参数!");
	}

	/**
	 * 
	 *(non-Javadoc)
	 * @see com.cloud.icenter.system.organ.service.OrganUserService#findByUserIdAndOrgId(java.lang.String, java.lang.String)
	 *
	 */
	@Override
	public OrganUser findByUserIdAndOrgId(String userId, String orgId) {
		if(!StringUtils.isEmpty(userId) && !StringUtils.isEmpty(orgId)){
			return organUserDao.findByUserIdAndOrgId(userId, orgId);
		}
		return null;
	}
	
	/**
	 * 
	 *(non-Javadoc)
	 * @see com.cloud.icenter.base.service.impl.BaseServiceImpl#delete(java.lang.String)
	 *
	 */
	@Override
	public void delete(String id) {
		//覆盖原方法，新增逻辑
		//检查是否存在与其他正常组织机构的关联关系，否则新增一条记录到other机构
		OrganUser temp = this.get(id);
		List<OrganUser> tempList = organUserDao.findByUserId(new String[]{temp.getOrgId()}, temp.getUserId());
		if(tempList == null || tempList.isEmpty()){
			//如果除删除的关联关系外，不存在其他的关系，新增一条记录到other机构中
			OrganUser ou = new OrganUser();
			ou.setCreateAt(new Timestamp(System.currentTimeMillis()));
			ou.setOrgId(Organ.OTHER_ID);
			ou.setUserId(temp.getUserId());
			this.save(ou);
		}
		organUserDao.delete(temp);
	}

	/**
	 * 
	 *(non-Javadoc)
	 * @see com.cloud.icenter.system.organ.service.OrganUserService#findByOrgId(java.lang.String)
	 *
	 */
	@Override
	public List<OrganUser> findByOrgId(String orgId) {
		if(!StringUtils.isEmpty(orgId)){
			return organUserDao.findByOrgId(orgId);
		}
		return null;
	}

	/**
	 * 
	 *(non-Javadoc)
	 * @see com.cloud.icenter.system.organ.service.OrganUserService#findByUserId(java.lang.String[], java.lang.String)
	 *
	 */
	@Override
	public List<OrganUser> findByUserId(String[] excludeOrgIds, String userId) {
		return organUserDao.findByUserId(excludeOrgIds, userId);
	}
}
