package com.cloud.icenter.yyzx.cszc.zygl.service;

import org.springframework.web.multipart.MultipartFile;

import com.cloud.icenter.base.service.BaseService;
import com.cloud.icenter.yyzx.cszc.zygl.pojo.HospitalPojo;

/** 
* @author zhucy 
* @version 2017年3月21日 下午2:53:05 
* 城市资源医院历史信息
*/
public interface HospitalService extends BaseService<HospitalPojo>{
	
	/**
	 * 导入城市资源基本信息
	 * @param file
	 * @return
	 * @throws Exception 
	 */
	String readExcelData(MultipartFile file,String userId) throws Exception;
}
