package com.cloud.icenter.yyzx.dpzs.lz.dao;


import com.cloud.icenter.base.dao.BaseDao;
import com.cloud.icenter.yyzx.dpzs.lz.pojo.WeatherFuture;
/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-31 09:42:47
*/
public interface WeatherFutureDao extends BaseDao<WeatherFuture> {

    WeatherFuture getLastByArea(String area);

}