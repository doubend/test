/**
 * 
 */
package com.cloud.icenter.system.organ.dao;

import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.system.organ.pojo.Organ;
import com.cloud.icenter.system.organ.pojo.OrganUser;

/**
 * @author YHUA
 *
 */
public interface OrganUserDao extends BaseDao<OrganUser> {
	/**
	 * 根据组织机构ID，删除组织机构与人员的关联关系
	 * @param orgId
	 */
	public void deleteFromOrgId(String orgId);
	
	/**
	 * 根据人员ID，删除该人员与组织机构的关联关系
	 * @param userId
	 */
	public void deleteFromUserId(String userId);
	
	public OrganUser findByUserIdAndOrgId(String userId, String orgId);
	
	/**
	 * 查找人员与组织机构的关联关系
	 * @param excludeOrgId 需要排除在外的组织机构ID（允许为空）
	 * @param userId 人员ID
	 * @return
	 */
	public List<OrganUser> findByUserId(String[] excludeOrgIds , String userId);
	
	public List<OrganUser> findByOrgId(String orgId);
	
	public List<Organ> findByUserId(String userId);
	
	public void delete(OrganUser organUser);
}
