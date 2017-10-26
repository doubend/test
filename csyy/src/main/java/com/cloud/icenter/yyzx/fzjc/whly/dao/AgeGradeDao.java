package com.cloud.icenter.yyzx.fzjc.whly.dao;

import java.util.List;

import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.fzjc.whly.pojo.AgeGrade;


/**
* Created with gender.
* @author: yuhaitao
* Date: 2017-03-15 10:51:43
*/
public interface AgeGradeDao extends BaseDao<AgeGrade> {
	public List<AgeGrade> getAgeGrade();
}