package com.cloud.icenter.yyzx.cszc.zygl.service;

import org.springframework.web.multipart.MultipartFile;

import com.cloud.icenter.base.service.BaseService;
import com.cloud.icenter.yyzx.cszc.zygl.pojo.XsjlPojo;

/** 
* @author zhucy 
* @version 2017年3月23日 上午11:21:58 
* 养护记录
*/
public interface XsjlService extends BaseService<XsjlPojo>{
	/**
	 * 导入养护记录信息
	 * @param file
	 * @return
	 * @throws Exception 
	 */
	String readExcelData(MultipartFile file, String id,String userId) throws Exception;
}
