package com.cloud.icenter.system.code.service;

import com.cloud.icenter.base.service.BaseService;
import com.cloud.icenter.system.code.pojo.ResourceCode;

public interface ResourceCodeService extends BaseService<ResourceCode> {
	
	/**
	 * 启用
	 * @param id
	 */
	public void startCode(String id);
	
	/**
	 * 检查资源的状态
	 * @param id
	 * @return
	 */
	public boolean checkStatus(String id);
	
	/**
	 * 获取当前状态为：启用状态的标识符生成规则
	 * @return
	 */
	public ResourceCode getUsed();
	
	/**
	 * 获取当前委办局的最新编码
	 * @param organId
	 * @return
	 */
	public String getCurrentCode(String organId);
}
