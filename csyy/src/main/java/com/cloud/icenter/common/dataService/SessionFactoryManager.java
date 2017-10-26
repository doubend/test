/**
 * 
 */
package com.cloud.icenter.common.dataService;

import java.util.HashMap;

import org.springframework.stereotype.Component;

/**
 * @author yuhaitao SessionFactory管理类
 */
@Component
public class SessionFactoryManager {

	private HashMap<String, HibernateSessionFactory> keyMap = new HashMap<String, HibernateSessionFactory>(
			50);

	/*
	 * 添加数据源
	 * */
	public void CreateSessionFactory(String url, String username,
			String password) {
		HibernateSessionFactory sf =  new HibernateSessionFactory(url, username,
				password);
		if (!keyMap.containsKey(sf.getSessionKey())) {
			this.keyMap.put(sf.getSessionKey(), sf);
		}
	}
	/*
	 * 删除数据源
	 * */
	public void RemoveSessionFactory(String key) {
		if (keyMap.containsKey(key)) {
			this.keyMap.remove(key);
		}
	}
	/*
	 * 获取数据源
	 * */
	public HibernateSessionFactory GetSessionFactory(String url, String username,
			String password) {
		String key=url+username+password;
		HibernateSessionFactory sf = null;
		if (keyMap.containsKey(key)) {
			sf = this.keyMap.get(key);
		}
		else {
			CreateSessionFactory(url,username,password);
			sf = this.keyMap.get(key);
		}
		return sf;
	}

}
