package com.cloud.icenter.yyzx.fzjc.whly.service.impl;

import java.util.List;

import org.apache.cxf.annotations.Logging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.icenter.base.service.impl.BaseServiceImpl;
import com.cloud.icenter.yyzx.fzjc.whly.dao.AgeGradeDao;
import com.cloud.icenter.yyzx.fzjc.whly.pojo.AgeGrade;
import com.cloud.icenter.yyzx.fzjc.whly.service.AgeGradeService;
/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-15 10:51:43
*/
@Logging
@Service
public class AgeGradeServiceImp extends BaseServiceImpl<AgeGrade>  implements AgeGradeService{
	@Autowired
	private AgeGradeDao ageDao;
	public List<AgeGrade> getAgeGrade(){
		return ageDao.getAgeGrade();
	}
}