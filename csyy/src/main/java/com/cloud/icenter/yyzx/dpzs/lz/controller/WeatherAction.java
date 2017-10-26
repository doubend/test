package com.cloud.icenter.yyzx.dpzs.lz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cloud.icenter.base.controller.BaseAction;
import com.cloud.icenter.yyzx.dpzs.lz.pojo.WeatherFuture;
import com.cloud.icenter.yyzx.dpzs.lz.pojo.WeatherToday;
import com.cloud.icenter.yyzx.dpzs.lz.service.WeatherFutureService;
import com.cloud.icenter.yyzx.dpzs.lz.service.WeatherTodayService;

/**
 * 气象
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value="/lz/weather")
public class WeatherAction extends BaseAction{
    
    @Autowired
    private WeatherFutureService weatherFutureService;
    @Autowired
    private WeatherTodayService weatherTodayService;
    /**
     * 立柱气象
     * @return
     */
    @RequestMapping(value="/toQxJsp",method=RequestMethod.GET)
    public String toQxJsp(){
        try {
//            //武山县
//            JSONObject wsjson = readJsonFromUrl("http://api.k780.com:88/?app=weather.future&weaid=101160906&appkey="+appkey+"&sign="+sign+"&format=json");
//            setAttribute("wsjson", wsjson);
//            //秦州区
//            JSONObject qzjson = readJsonFromUrl("http://api.k780.com:88/?app=weather.future&weaid=101160901&appkey="+appkey+"&sign="+sign+"&format=json");
//            setAttribute("qzjson", qzjson);
//            //秦安县
//            JSONObject qajson = readJsonFromUrl("http://api.k780.com:88/?app=weather.future&weaid=101160904&appkey="+appkey+"&sign="+sign+"&format=json");
//            setAttribute("qajson", qajson);
//            //清水县
//            JSONObject qsjson = readJsonFromUrl("http://api.k780.com:88/?app=weather.future&weaid=101160903&appkey="+appkey+"&sign="+sign+"&format=json");
//            setAttribute("qsjson", qsjson);
//            //甘谷县
//            JSONObject ggjson = readJsonFromUrl("http://api.k780.com:88/?app=weather.future&weaid=101160905&appkey="+appkey+"&sign="+sign+"&format=json");
//            setAttribute("ggjson", ggjson);
//            //张家川
//            JSONObject zjcjson = readJsonFromUrl("http://api.k780.com:88/?app=weather.future&weaid=101160907&appkey="+appkey+"&sign="+sign+"&format=json");
//            setAttribute("zjcjson", zjcjson);
//            //麦积区
//            JSONObject mjcjson = readJsonFromUrl("http://api.k780.com:88/?app=weather.future&weaid=101160908&appkey="+appkey+"&sign="+sign+"&format=json");
//            setAttribute("mjcjson", mjcjson);
//            
//            //以下是当前天气
//            //武山县
//            JSONObject n_wsjson = readJsonFromUrl("http://api.k780.com:88/?app=weather.today&weaid=101160906&appkey="+appkey+"&sign="+sign+"&format=json");
//            setAttribute("n_wsjson", n_wsjson);
//            //秦州区
//            JSONObject n_qzjson = readJsonFromUrl("http://api.k780.com:88/?app=weather.today&weaid=101160901&appkey="+appkey+"&sign="+sign+"&format=json");
//            setAttribute("n_qzjson", n_qzjson);
//            //秦安县
//            JSONObject n_qajson = readJsonFromUrl("http://api.k780.com:88/?app=weather.today&weaid=101160904&appkey="+appkey+"&sign="+sign+"&format=json");
//            setAttribute("n_qajson", n_qajson);
//            //清水县
//            JSONObject n_qsjson = readJsonFromUrl("http://api.k780.com:88/?app=weather.today&weaid=101160903&appkey="+appkey+"&sign="+sign+"&format=json");
//            setAttribute("n_qsjson", n_qsjson);
//            //甘谷县
//            JSONObject n_ggjson = readJsonFromUrl("http://api.k780.com:88/?app=weather.today&weaid=101160905&appkey="+appkey+"&sign="+sign+"&format=json");
//            setAttribute("n_ggjson", n_ggjson);
//            //张家川
//            JSONObject n_zjcjson = readJsonFromUrl("http://api.k780.com:88/?app=weather.today&weaid=101160907&appkey="+appkey+"&sign="+sign+"&format=json");
//            setAttribute("n_zjcjson", n_zjcjson);
//            //麦积区
//            JSONObject n_mjcjson = readJsonFromUrl("http://api.k780.com:88/?app=weather.today&weaid=101160908&appkey="+appkey+"&sign="+sign+"&format=json");
//            setAttribute("n_mjcjson", n_mjcjson);
            
            
            //武山县
            WeatherFuture wsf = weatherFutureService.getLastByArea("101160906");
            if (wsf != null) {
                JSONArray wsfa = JSON.parseArray(wsf.getWeatherJson());
                setAttribute("wsf", wsfa);
            }
            //秦州区
            WeatherFuture qzf = weatherFutureService.getLastByArea("101160901");
            if (qzf != null) {
                JSONArray qzfa = JSON.parseArray(qzf.getWeatherJson());
                setAttribute("qzf", qzfa);
            }
            //秦安县
            WeatherFuture qaf = weatherFutureService.getLastByArea("101160904");
            if (qaf != null) {
                JSONArray qafa = JSON.parseArray(qaf.getWeatherJson());
                setAttribute("qaf", qafa);
            }
            //清水县
            WeatherFuture qsf = weatherFutureService.getLastByArea("101160903");
            if (qsf != null) {
                JSONArray qsfa = JSON.parseArray(qsf.getWeatherJson());
                setAttribute("qsf", qsfa);
            }
            //甘谷县
            WeatherFuture ggf = weatherFutureService.getLastByArea("101160905");
            if (ggf != null) {
                JSONArray ggfa = JSON.parseArray(ggf.getWeatherJson());
                setAttribute("ggf", ggfa);
            }
            //张家川
            WeatherFuture zjcf = weatherFutureService.getLastByArea("101160907");
            if (zjcf != null) {
                JSONArray zjcfa = JSON.parseArray(zjcf.getWeatherJson());
                setAttribute("zjcf", zjcfa);
            }
            //麦积区
            WeatherFuture mjcf = weatherFutureService.getLastByArea("101160908");
            if (mjcf != null) {
                JSONArray mjcfa = JSON.parseArray(mjcf.getWeatherJson());
                setAttribute("mjcf", mjcfa);
            }
            
            
            //武山县
            WeatherToday wst = weatherTodayService.getLastByArea("101160906");
            if (wst != null) {
                JSONObject wsta = JSON.parseObject(wst.getWeatherJson());
                setAttribute("wst", wsta);
            }
            //秦州区
            WeatherToday qzt = weatherTodayService.getLastByArea("101160901");
            if (qzt != null) {
                JSONObject qzfa = JSON.parseObject(qzt.getWeatherJson());
                setAttribute("qzt", qzfa);
            }
            //秦安县
            WeatherToday qat = weatherTodayService.getLastByArea("101160904");
            if (qat != null) {
                JSONObject qata = JSON.parseObject(qat.getWeatherJson());
                setAttribute("qat", qata);
            }
            //清水县
            WeatherToday qst = weatherTodayService.getLastByArea("101160903");
            if (qst != null) {
                JSONObject qsta = JSON.parseObject(qst.getWeatherJson());
                setAttribute("qst", qsta);
            }
            //甘谷县
            WeatherToday ggt = weatherTodayService.getLastByArea("101160905");
            if (ggt != null) {
                JSONObject ggta = JSON.parseObject(ggt.getWeatherJson());
                setAttribute("ggt", ggta);
            }
            //张家川
            WeatherToday zjct = weatherTodayService.getLastByArea("101160907");
            if (zjct != null) {
                JSONObject zjcta = JSON.parseObject(zjct.getWeatherJson());
                setAttribute("zjct", zjcta);
            }
            //麦积区
            WeatherToday mjct = weatherTodayService.getLastByArea("101160908");
            if (mjct != null) {
                JSONObject mjcta = JSON.parseObject(mjct.getWeatherJson());
                setAttribute("mjct", mjcta);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/dpzs/lz/weather";
    }
    
    

}

