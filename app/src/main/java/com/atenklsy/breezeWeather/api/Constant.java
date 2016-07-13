package com.atenklsy.breezeWeather.api;

/**
 * Created by atenklsy on 2016/5/17 17:03.
 * E-address:atenk@qq.com.
 * HOST+CITYlIST+KEY,可以请求全国城市
 */
//    https://api.heweather.com/x3/weather?city=北京&key=ab7216b8c079499589ade737059fb662
public class Constant {
    //和风天气api主HOST
    public final static String HOST = "https://api.heweather.com/x3/";
    //按照cityid来获取相应城市的天气情况
    public final static String WEATHERINFO = "weather?city=";
    //和风天气的专属KEY。
    public final static String KEY = "&key=ab7216b8c079499589ade737059fb662";
    public final static String REQUESTINFO = HOST + WEATHERINFO;

}
