/**
 * 
 */
package com.cloud.icenter.system.organ.dao.impl;

import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.system.organ.dao.OrganUserDao;
import com.cloud.icenter.system.organ.pojo.Organ;
import com.cloud.icenter.system.organ.pojo.OrganUser;

/**
 * 
 *  类注释
 * 
 * <p>
 * <p>
 * @项目        dzenWeb
 * <p>
 * @作者:       YHUA
 * <p>
 * @日期:       2016年9月18日
 * <p>
 * @负责人:     YHUA
 * <p>
 * @负责小组:   
 * <p>
 * <p>
 */
@Repository
public class OrganUserDaoImpl extends BaseDaoImpl<OrganUser> implements OrganUserDao {

	/**
	 * 
	 *(non-Javadoc)
	 * @see com.cloud.icenter.system.organ.dao.OrganUserDao#deleteFromOrgId(java.lang.String)
	 *
	 */
	@Override
	public void deleteFromOrgId(final String orgId) {
		final String hql = " DELETE OrganUser WHERE orgId = :orgId ";
		Query query = this.createQuery(hql);
		query.setParameter("orgId", orgId);
		query.executeUpdate();
	}

	/**
	 * 
	 *(non-Javadoc)
	 * @see com.cloud.icenter.system.organ.dao.OrganUserDao#deleteFromUserId(java.lang.String)
	 *
	 */
	@Override
	public void deleteFromUserId(final String userId) {
		final String hql = " DELETE OrganUser WHERE userId = :userId ";
		Query query = this.createQuery(hql);
		query.setParameter("userId", userId);
		query.executeUpdate();
	}

	/**
	 * 
	 *(non-Javadoc)
	 * @see com.cloud.icenter.system.organ.dao.OrganUserDao#findByUserIdAndOrgId(java.lang.String, java.lang.String)
	 *
	 */
	@Override
	public OrganUser findByUserIdAndOrgId(String userId, String orgId) {
		final String hql = " FROM OrganUser WHERE userId = :userId AND orgId = :orgId ";
		Query query = this.createQuery(hql);
		query.setParameter("userId", userId);
		query.setParameter("orgId", orgId);
		return (OrganUser)query.uniqueResult();
	}

	/**
	 * 
	 *(non-Javadoc)
	 * @see com.cloud.icenter.system.organ.dao.OrganUserDao#findByUserId(java.lang.String, java.lang.String)
	 *
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<OrganUser> findByUserId(String[] excludeOrgIds, String userId) {
		final StringBuilder hql = new StringBuilder(" FROM OrganUser WHERE userId = :userId ");
		if(!ArrayUtils.isEmpty(excludeOrgIds)){
			hql.append(" AND orgId NOT IN (:orgId) ");
		}
		Query query = this.createQuery(hql.toString());
		query.setParameter("userId", userId);
		if(!ArrayUtils.isEmpty(excludeOrgIds)){
			query.setParameterList("orgId", excludeOrgIds);
		}
		return query.list();
	}

	/**
	 * 
	 *(non-Javadoc)
	 * @see com.cloud.icenter.system.organ.dao.OrganUserDao#findByOrgId(java.lang.String)
	 *
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<OrganUser> findByOrgId(String orgId) {
		final String hql = " FROM OrganUser WHERE orgId = :orgId ";
		Query query = this.createQuery(hql);
		query.setParameter("orgId", orgId);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Organ> findByUserId(String userId) {
		final String hql = " FROM OrganUser WHERE userId = :userId ";
		Query query = this.createQuery(hql);
		query.setParameter("userId", userId);
		return query.list();
	}

	/**
	 * 
	 *(non-Javadoc)
	 * @see com.cloud.icenter.system.organ.dao.OrganUserDao#delete(com.cloud.icenter.system.organ.pojo.OrganUser)
	 *
	 */
	@Override
	public void delete(OrganUser organUser) {
		this.getSession().delete(organUser);
	}
}
