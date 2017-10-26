package  com.cloud.icenter.yyzx.dpzs.lz.service;

import java.util.List;

import com.cloud.icenter.base.service.BaseService;
import com.cloud.icenter.yyzx.common.query.Tourism;
import com.cloud.icenter.yyzx.dpzs.lz.pojo.SourceDay;


/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-31 09:44:46
*/
public interface SourceDayService extends BaseService<SourceDay> {
	public List<Tourism> getDaySource();
}