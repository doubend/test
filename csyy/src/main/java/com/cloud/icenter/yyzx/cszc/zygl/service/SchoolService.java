package com.cloud.icenter.yyzx.cszc.zygl.service;

import org.springframework.web.multipart.MultipartFile;

import com.cloud.icenter.base.service.BaseService;
import com.cloud.icenter.yyzx.cszc.zygl.pojo.SchoolPojo;

/** 
* @author zhucy 
* @version 2017年3月21日 下午2:50:09 
* 城市资源学校历史信息 
*/
public interface SchoolService extends BaseService<SchoolPojo>{
	/**
	 * 导入学校历史信息
	 * @param file
	 * @return
	 * @throws Exception 
	 */
	String readExcelData(MultipartFile file,String userId) throws Exception;
}
