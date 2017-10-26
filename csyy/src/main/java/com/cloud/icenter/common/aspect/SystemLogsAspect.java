package com.cloud.icenter.common.aspect;

import java.util.Arrays;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.cloud.icenter.base.pojo.Pojo;
import com.cloud.icenter.base.service.BaseService;
import com.cloud.icenter.common.utils.StringUtil;
import com.cloud.icenter.system.logs.pojo.Logs;
import com.cloud.icenter.system.logs.service.LogsService;
import com.cloud.icenter.system.onlineuser.service.OnlineUserService;
import com.cloud.icenter.system.user.pojo.User;

/**
 * 系统模块-日志记录类
 * @author zhanngle
 */
@Aspect
@Component
public class SystemLogsAspect {

	@Autowired private LogsService logsService;
	@Autowired private OnlineUserService onlineUserService;
	
	@Pointcut("@target(com.cloud.icenter.system.logs.pojo.Logging)")
	public void logging() {}
	
	@Pointcut("execution(public * delete(..))")
	public void deleteMethod() {}
	
	@Pointcut("execution(public * update(..))")
	public void updateMethod() {}
	
	@Pointcut("execution(public * add(..))")
	public void addMethod() {}
	
	@PostConstruct
	public void startup() {
		Logs logs=newLogs("system", "", "startup", "启动系统");
		logsService.add(logs);
	}
	
	@PreDestroy
	public void shutdown() {
		Logs logs=newLogs("system", "", "shutdown", "关闭系统");
		logsService.add(logs);
	}
	
	/**
	 * 对登录用户进行记录
	 */
	@AfterReturning(value="bean(onlineUserServiceImpl) && addMethod()")
	public void login() {
		Logs logs = newLogs("system","User","login","用户登录");
		logsService.add(logs);
	}
	
	/**
	 * 对注销用户进行记录
	 */
	@Before(value="bean(onlineUserServiceImpl) && deleteMethod()")
	public void logout() {
		Logs logs = newLogs("system","User","logout","用户注销");
		logsService.add(logs);
	}
	
	/**
	 * 对删除操作进行记录
	 * @param dao
	 * @param id
	 */
	@Before(value="logging() && deleteMethod() && target(service) && args(id)",argNames="service,id")
	public void delete(BaseService<Object> service,Object id) {

		if(service==null || id==null) return;
		
		Object pojo=null;
		if(id instanceof String) {
			pojo=service.get((String)id);
		} else if(id instanceof String) {
			pojo=service.get((String)id);
		}
		if(pojo==null) return;
		if(pojo instanceof Logs) return;
		
		Logs logs =newLogs(pojo,"delete");
		logsService.add(logs);
	}
	
	/**
	 * 对添加操作进行记录
	 * 拦截service层,再这里要考虑不能死循环添加日志,因此判断pojo是否Logs类
	 * @param bean
	 */
	@AfterReturning(value="logging() && addMethod() && target(service) && args(pojo)",argNames="service,pojo")
	public void add(BaseService<Object> service,Pojo pojo) {
		
		if(pojo==null) return;
		/*if(pojo instanceof Logs || pojo instanceof DataVisitLog) return;*/
		if(pojo instanceof Logs) return;
		Logs logs =newLogs(pojo,"add");
		logsService.add(logs);
	}
	
	/**
	 * 对更新操作进行记录
	 * 拦截service层,再这里要考虑不能死循环添加日志,因此判断pojo是否Logs类
	 * @param bean
	 */
	@AfterReturning(value="logging() && updateMethod() && target(service) && args(pojo)",argNames="service,pojo")
	public void update(BaseService<Object> service,Pojo pojo) {
		
		if(pojo==null) return;
		if(pojo instanceof Logs) return;
		
		Logs logs =newLogs(pojo,"update");
		logsService.add(logs);
	}
	
	/**
	 * 为任意加了@Logging的方法,增加日志记录
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
	@Around("@annotation(com.cloud.icenter.system.logs.pojo.Logging)")
	public Object logMethod(ProceedingJoinPoint pjp) throws Throwable {
		
		long start=System.currentTimeMillis();
	    Object result = pjp.proceed();
	    long end=System.currentTimeMillis();
	    
	    String module=getModule(pjp.getTarget());
	    String entity=getEntity(pjp.getTarget());
	    String type=pjp.getSignature().getName();
	    String remark="elapsed time:"+(end-start)+"ms,"+result+"="+toStringForArgs(pjp.getArgs());
	    
	    Logs logs =newLogs(module,entity,type,remark);
		logsService.add(logs);
		
	    return result;
	}

	/**
	 * 将参数转换为字符串
	 * @param args
	 * @return
	 */
	private String toStringForArgs(Object[] args) {
		
		if(args==null || args.length==0) return "()";
		StringBuilder sb=new StringBuilder();
		sb.append("(");
		for(int i=0;i<args.length;i++) {
			if(args[i] instanceof Object[]) {
				sb.append(Arrays.toString((Object[])args[i]));
			} else {
				sb.append(args[i].toString());
			}
			if(i<args.length-1) sb.append(",");
		}
		sb.append(")");
		return sb.toString();
	}
	
	/**
	 * 快速创建一个logs对象
	 * @param module
	 * @param entity
	 * @param type
	 * @param remark
	 * @return
	 */
	private Logs newLogs(String module,String entity,String type,String remark) {
		
		Logs logs=new Logs();
		
		try {
			User user=onlineUserService.getLoginUser(getRequest());
			if(user!=null) {
				logs.setUsername(user.getUsername());
			}
			logs.setHost(getRequest().getRemoteAddr());
		} catch (Exception e) {}
		
		logs.setModule(module);
		logs.setEntity(entity);
		logs.setType(type);
		logs.setCreatedAt(new Date());
		logs.setDescription(StringUtil.getString(remark, 500));
		return logs;
	}
	
	/**
	 *  快速创建一个logs对象
	 * @param pojo
	 * @param type
	 * @return
	 */
	private Logs newLogs(Object pojo,String type) {
		return newLogs(getModule(pojo),getEntity(pojo),type,getRemark(pojo));
	}
	
	/**
	 * 获取模块名
	 * @param clazz
	 * @return
	 */
	private String getModule(Object pojo) {
		Class clazz=pojo.getClass();
		String[] name=clazz.getName().split("\\.");
		return name.length>=4?name[3]:clazz.getSimpleName();
	}
	
	/**
	 * 获取实体名
	 * @param pojo
	 * @return
	 */
	private String getEntity(Object pojo) {
		return pojo.getClass().getSimpleName();
	}
	
	/**
	 * 获取备注
	 * @param pojo
	 * @return
	 */
	private String getRemark(Object pojo) {
		return pojo.toString();
	}
	
	/**
	 * 获取request对象
	 * @return
	 */
	private HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		return request;
	}
}
