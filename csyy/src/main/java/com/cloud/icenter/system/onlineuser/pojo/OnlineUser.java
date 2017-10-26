package com.cloud.icenter.system.onlineuser.pojo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import org.apache.commons.beanutils.BeanUtils;

import com.cloud.icenter.common.utils.SpringUtil;
import com.cloud.icenter.system.onlineuser.service.OnlineUserService;
import com.cloud.icenter.system.organ.pojo.Organ;
import com.cloud.icenter.system.role.pojo.Role;
import com.cloud.icenter.system.user.pojo.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 在线用户
 * @author zhangle
 */
public class OnlineUser extends User implements HttpSessionBindingListener {

	private String ip;
	private String sessionId;
	private List<Role> roles;		//用户拥有的角色
	private Organ employee;		//用户的主要员工对象
	private List<Organ> employees;	//用户的所有员工对象
	private Organ department;		//用户的主要部门对象
	private List<Organ> parents;	//主要员工对象的所有直系父节点,包括本员工节点
	
	private transient HttpSession session;
	private transient OnlineUserService onlineUserService;
	
	public OnlineUser(HttpServletRequest request,User user) {
		this(request.getSession(),user);
		this.ip=request.getRemoteAddr();
	}
	
	public OnlineUser(HttpSession session,User user) {
		try {
			BeanUtils.copyProperties(this, user);
		} catch (Exception e) {}
		this.sessionId=session.getId();
		this.session=session;
		this.onlineUserService=SpringUtil.getBean(OnlineUserService.class);
	}
	
	@Override
	public void valueBound(HttpSessionBindingEvent event) {}
	
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		try {	
			//有时,tomcat重启,恢复session数据时,onlineUserService与session为null,此处可以捕捉异常,避免前台报错.
			if(onlineUserService.get(session.getId())!=null) {
				onlineUserService.delete(session.getId());
			}
		} catch (Exception e) {}
	}
	
	public int compareTo(OnlineUser user) {
		if(user==null) return 1;
		return this.getLogonAt().compareTo(user.getLogonAt());
	}
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	@JsonIgnore
	public HttpSession getSession() {
		return session;
	}
	public void setSession(HttpSession session) {
		this.session = session;
	}
	@JsonIgnore
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public Organ getEmployee() {
		return employee;
	}

	public void setEmployee(Organ employee) {
		this.employee = employee;
	}
	
	public List<Organ> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Organ> employees) {
		this.employees = employees;
	}

	public Organ getDepartment() {
		return department;
	}

	public void setDepartment(Organ department) {
		this.department = department;
	}

	public List<Organ> getParents() {
		return parents;
	}

	public void setParents(List<Organ> parents) {
		this.parents = parents;
	}
	
	/**
	 * 判断登录用户是否拥有某角色
	 * @param roleName
	 * @return
	 */
	public boolean hasRole(String roleName) {
		
		if(roles==null || roles.isEmpty()) return false;
		
		for(Role r:roles) {
			if(r.getRoleName().equals(roleName)) return true;
		}
		return false;
	}
}
