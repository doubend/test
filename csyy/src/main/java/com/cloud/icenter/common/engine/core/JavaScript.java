package com.cloud.icenter.common.engine.core;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * 
 * <p>Title:JavaScript</p>
 * <p>Description: 运用脚本引擎进行表达式运算 </p>
 * <p>Copyright: Copyright (c) </p>
 * <p>Company: XXXX</p>
 * <p>Date:2015年1月12日</p>
 * @author CHEN_JIAN
 * @version 1.0
 */
public class JavaScript  {
	public static Object MathValue( String exp) throws ScriptException{
		ScriptEngineManager factory = new ScriptEngineManager();  
		ScriptEngine engine = factory.getEngineByName("JavaScript");  
		if (exp.equals(""))
			return "";
		Object o = engine.eval(exp);
		return o;
	}
	
	
	public static void main(String[] args) throws ScriptException {
		String dd="\"('3','44','99')\"!=null";
		System.out.println(JavaScript .MathValue(dd));;
//		String userName = "1' or '1'='1";
//		String password = "123456";
//		userName = StringEscapeUtils.escapeSql(userName);
//		password = StringEscapeUtils.escapeSql(password);
//		String sql = "SELECT COUNT(userId) FROM t_user WHERE userName='"+ userName + "' AND password ='" + password + "'";
//		System.out.println(sql);
	}

	
//private void test(){
//		String userName = "1' or '1'='1";String password = "123456";
//		userName = StringEscapeUtils.escapeSql(userName);
//		password = StringEscapeUtils.escapeSql(password);
//		String sql = "SELECT COUNT(userId) FROM t_user WHERE userName='"+ userName + "' AND password ='" + password + "'";
//		System.out.println(sql);
//}
	
}
