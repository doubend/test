package com.cloud.icenter.yyzx.fzjc.whly.service;

import java.util.List;

import com.cloud.icenter.base.service.BaseService;
import com.cloud.icenter.yyzx.fzjc.whly.pojo.AgeGrade;

/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-15 10:51:43
*/
public interface AgeGradeService extends BaseService<AgeGrade> {
	public List<AgeGrade> getAgeGrade();
}