/**
 * 
 */
package com.cloud.icenter.system.organ.pojo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenericGenerator;

import com.cloud.icenter.base.pojo.Pojo;

/**
 * @author YHUA
 *
 */
@Entity
@Table(name = "T_DMP_SYS_ORG_USER")
public class OrganUser extends Pojo {
	private static final long serialVersionUID = 1911360677153807042L;
	
	/**
	 * 主键
	 */
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	@Column(name = "ID", unique = true, nullable = false, length = 32)
	private String id;
	
	/**
	 * 组织机构ID
	 */
	@Column(name = "ORG_ID" , length = 32 , nullable = false)
	private String orgId;
	
	/**
	 * 人员ID
	 */
	@Column(name = "USER_ID" , length = 32 , nullable = false)
	private String userId;
	
	/**
	 * 创建时间
	 */
	@Column(name = "CREATE_AT" , nullable = false)
	private Timestamp createAt;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Timestamp getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}
}
