/**
 * 
 */
package com.cloud.icenter.system.organ.service;

import java.util.List;

import com.cloud.icenter.base.service.BaseService;
import com.cloud.icenter.system.organ.pojo.OrganUser;

/**
 * @author 	YHUA
 *
 */
public interface OrganUserService extends BaseService<OrganUser> {
	/**
	 * 根据组织机构ID，删除该组织机构与人员的关联关系
	 * 不会判断人员是否存在于其他组织的关系
	 * @param orgId
	 */
	public void deleteFromOrgId(String orgId);
	
	/**
	 * 根据人员ID，删除该人员与组织机构的关系
	 * 不会判断人员是否存在于其他组织的关系
	 * @param userId
	 */
	public void deleteFromUserId(String userId);
	
	/**
	 * 为组织机构批量添加人员
	 * @param userIds
	 * @param orgId
	 */
	public void addBatch(String[] userIds , String orgId);
	
	/**
	 * 将用户添加进默认组织机构
	 * @param userId
	 */
	public void addUserToOther(String userId);
	
	/**
	 * 根据组织机构ID与人员ID，确定唯一关系
	 * @param userId
	 * @param orgId
	 * @return
	 */
	public OrganUser findByUserIdAndOrgId(String userId , String orgId);
	
	public List<OrganUser> findByOrgId(String orgId);
	
	public List<OrganUser> findByUserId(String[] excludeOrgIds , String userId);
}
