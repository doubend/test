package com.cloud.icenter.yyzx.dpzs.lz.dao.impl;

import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.cloud.icenter.base.dao.impl.BaseDaoImpl;
import com.cloud.icenter.yyzx.dpzs.lz.dao.WeatherTodayDao;
import com.cloud.icenter.yyzx.dpzs.lz.pojo.WeatherToday;
/**
* Created with gender.
* @author: yaoli
* Date: 2017-03-31 09:42:47
*/
@Repository
public class WeatherTodayDaoImpl extends BaseDaoImpl<WeatherToday> implements WeatherTodayDao {

    @Override
    public WeatherToday getLastByArea(String area) {
        String sql = "select id id,weather_json weatherJson,area area,create_time createTime from t_zwfw_qx_jt where area=(:area) order by create_time desc";
        SQLQuery query=createSQLQuery(sql);
        query.setString("area", area);
        query.setMaxResults(1);
        query.setResultTransformer(Transformers.aliasToBean(WeatherToday.class));
        WeatherToday w = (WeatherToday) query.uniqueResult();
        return w;
    }

}