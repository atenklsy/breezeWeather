package com.atenklsy.breezeWeather.util;

import android.text.TextUtils;

import com.atenklsy.breezeWeather.model.City;
import com.atenklsy.breezeWeather.model.County;
import com.atenklsy.breezeWeather.model.Province;
import com.atenklsy.breezeWeather.db.breezeWeatherDB;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by atenklsy on 2016/4/9 15:33.
 * E-address:atenk@qq.com.
 * 将数据从网络中读取到后，清除其格式,并保存到数据库
 * 自己在数据库中将省市的内容写好后，就不要调用此方法了，因为其最终目的是将网络上请求得来的数据清除格式后存放在sqlite数据库之中
 */
public class Utility {
    /**
     * 从网路上获取数据response
     * 然后利用gson解析
     *
     * @param response
     */
    public static void parseData(String response) {

    }

    public static String getCurTime() {
        //日期格式
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        //获得当前系统时间
        Date date = new Date(System.currentTimeMillis());
        return dateFormat.format(date);
    }
//    public synchronized static boolean handleProvinceResponse(breezeWeatherDB mbreezeWeatherDB, String response) {
//        if (!TextUtils.isEmpty(response)) {
//            String[] allProcvices = response.split(",");
//            if (allProcvices != null && allProcvices.length > 0) {
//                for (String p : allProcvices) {
////                  盛装内容
//                    Province province = new Province();
//                    String[] array = p.split("\\|");
//                    province.setProvinceCode(array[0]);
//                    province.setProvinceName(array[1]);
//                    mbreezeWeatherDB.saveProvince(province);
//                }
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public static boolean handleCityResponse(breezeWeatherDB mbreezeWeatherDB, String response, int provinceId) {
//        if (!TextUtils.isEmpty(response)) {
//            String[] allCities = response.split(",");
//            if (allCities != null && allCities.length > 0) {
//                for (String p : allCities) {
//                    City city = new City();
//                    String[] array = p.split("\\|");
//                    city.setCityCode(array[0]);
//                    city.setCityName(array[1]);
//                    city.setProvinceId(provinceId);
//                    mbreezeWeatherDB.savaCity(city);
//                }
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public static boolean handleCountyResponse(breezeWeatherDB mbreezeWeatherDB, String response, int cityId) {
//        if (!TextUtils.isEmpty(response)) {
//            String[] allCounties = response.split(",");
//            if (allCounties != null && allCounties.length > 0) {
//                for (String p : allCounties) {
//                    County county = new County();
//                    String[] array = p.split("\\|");
//                    county.setCountyCode(array[0]);
//                    county.setCountyName(array[1]);
//                    county.setCityId(cityId);
//                    mbreezeWeatherDB.saveCounty(county);
//                }
//                return true;
//            }
//        }
//        return false;
//    }
}
