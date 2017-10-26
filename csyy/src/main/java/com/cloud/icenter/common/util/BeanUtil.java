package com.cloud.icenter.common.util;


/**
 * 
* @ClassName: BeanUtil 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Chen_JIAN
* @date 2015年9月14日 下午2:30:31 
*
 */

public class BeanUtil {
	
	
	/**
	 * 
	 * isBlank(这里用一句话描述这个方法的作用)
	 * 判断对象是否为空
	 * @param obj
	 * @return boolean
	 * @exception 
	 * @version  1.0.0
	 * @date 2015年9月20日 
	 *
	 */
	
	public static boolean isBlank(Object obj){
	    if(obj!=null&&!"".equals(obj)){
	    	return false;
	    }
		return true;
	}

}
