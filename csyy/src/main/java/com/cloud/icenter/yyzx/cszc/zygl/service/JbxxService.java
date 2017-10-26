package com.cloud.icenter.yyzx.cszc.zygl.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.cloud.icenter.base.service.BaseService;
import com.cloud.icenter.yyzx.cszc.zygl.pojo.JbxxPojo;

/** 
* @author zhucy 
* @version 2017年3月21日 下午2:45:53 
* 城市资源基本信息
*/
public interface JbxxService extends BaseService<JbxxPojo>{
	
	/**
	 * 导入城市资源基本信息
	 * @param file
	 * @return
	 * @throws Exception 
	 */
	Map<String, Object> readExcelData(MultipartFile file,String userId,String bjmbId) throws Exception;
	
	/**
	 * 通过资源所属分类查询资源记录
	 * @param fenlei
	 * @return
	 */
	List<JbxxPojo> getListByFenlei(String fenlei);
	
	/**
	 * 创建错误文件数据
	 * @param list
	 * @return
	 */
    String createErrorFile(List<JbxxPojo> list);
	
}
