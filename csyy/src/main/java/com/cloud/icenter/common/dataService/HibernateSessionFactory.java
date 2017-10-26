package com.cloud.icenter.common.dataService;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.cloud.icenter.common.utils.SystemConfig;

/**
 * Configures and provides access to Hibernate sessions, tied to the current
 * thread of execution. Follows the Thread Local Session pattern, see
 * {@link http://hibernate.org/42.html }.
 */
public class HibernateSessionFactory {

	private String url;
	private String username;
	private String password;
	private String sessionKey;

	public String getSessionKey() {
		return sessionKey;
	}

	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}

	private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
	private static org.hibernate.SessionFactory sessionFactory;

	private static Configuration configuration = new Configuration();
	//private static Properties props =new Properties();
	// private static StandardServiceRegistryBuilder serviceRegistryBuilder =
	// new StandardServiceRegistryBuilder();

	/*
	 * static { try { SetConfiguration(); StandardServiceRegistryBuilder builder
	 * = new
	 * StandardServiceRegistryBuilder().applySettings(configuration.getProperties
	 * ()); sessionFactory = configuration.buildSessionFactory(builder.build());
	 * } catch (Exception e) {
	 * System.err.println("%%%% Error Creating SessionFactory %%%%");
	 * e.printStackTrace(); } }
	 */
	public HibernateSessionFactory(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
		this.sessionKey = url + username + password;
		
	}

	private void SetConfiguration() {
		configuration.setProperty("hibernate.connection.driver_class",
				SystemConfig.getProperty("jdbc.driver"));
		configuration.setProperty("hibernate.connection.url", url);
		configuration.setProperty("hibernate.connection.username", username);
		configuration.setProperty("hibernate.connection.password", password);
		configuration.setProperty("hibernate.dialect",
				SystemConfig.getProperty("hibernate.dialect"));
		configuration.setProperty("hibernate.c3p0.max_size",
				SystemConfig.getProperty("hibernate.c3p0.max_size"));
		configuration.setProperty("hibernate.c3p0.min_size",
				SystemConfig.getProperty("hibernate.c3p0.min_size"));
		configuration.setProperty("hibernate.c3p0.timeout",
				SystemConfig.getProperty("hibernate.c3p0.timeout"));
		configuration.setProperty("hibernate.c3p0.max_statements",
				SystemConfig.getProperty("hibernate.c3p0.max_statements"));
		configuration.setProperty("hibernate.c3p0.idle_test_period",
				SystemConfig.getProperty("hibernate.c3p0.idle_test_period"));
		configuration.setProperty("hibernate.c3p0.acquire_increment",
				SystemConfig.getProperty("hibernate.c3p0.acquire_increment"));
		configuration.setProperty("hibernate.c3p0.validate",
				SystemConfig.getProperty("hibernate.c3p0.validate"));
	}

	/**
	 * Returns the ThreadLocal Session instance. Lazy initialize the
	 * <code>SessionFactory</code> if needed.
	 * 
	 * @return Session
	 * @throws HibernateException
	 */
	public Session getSession() throws HibernateException {
		Session session = threadLocal.get();

		if (session == null || !session.isOpen()) {
			if (sessionFactory == null) {
				buildSessionFactory();
			}
			session = (sessionFactory != null) ? sessionFactory.openSession()
					: null;
			threadLocal.set(session);
		}
		return session;
	}

	/**
	 * Rebuild hibernate session factory
	 * 
	 */
	public void buildSessionFactory() {
		try {
			SetConfiguration();
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties());
			sessionFactory = configuration.buildSessionFactory(builder.build());
		} catch (Exception e) {
			System.err.println("%%%% Error Creating SessionFactory %%%%");
			e.printStackTrace();
		}
	}

	/**
	 * Close the single hibernate session instance.
	 * 
	 * @throws HibernateException
	 */
	public void closeSession() throws HibernateException {
		Session session = threadLocal.get();
		threadLocal.set(null);
		if (session != null) {
			session.close();
		}
	}

	/**
	 * return session factory
	 * 
	 */
	public org.hibernate.SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			buildSessionFactory();
		}
		return sessionFactory;
	}

}