package com.cloud.icenter.yyzx.dpzs.lz.dao.impl;

import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.dpzs.lz.dao.WeatherFutureDao;
import com.cloud.icenter.yyzx.dpzs.lz.pojo.WeatherFuture;
/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-31 09:42:47
*/
@Repository
public class WeatherFutureDaoImpl extends BaseDaoImpl<WeatherFuture> implements WeatherFutureDao {

    @Override
    public WeatherFuture getLastByArea(String area) {
        String sql = "select id id,weather_json weatherJson,area area,create_time createTime from t_zwfw_qx_jl where area=(:area) order by create_time desc";
        SQLQuery query=createSQLQuery(sql);
        query.setString("area", area);
        query.setMaxResults(1);
        query.setResultTransformer(Transformers.aliasToBean(WeatherFuture.class));
        WeatherFuture w = (WeatherFuture) query.uniqueResult();
        return w;
    }

}