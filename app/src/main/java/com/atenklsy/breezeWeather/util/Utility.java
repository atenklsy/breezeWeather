package com.atenklsy.breezeWeather.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;


import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by atenklsy on 2016/4/9 15:33.
 * E-address:atenk@qq.com.
 */
public class Utility {
    static SharedPreferences.Editor editor;
    static String status;
    private static Context mContext;

    /**
     * 从网路上获取数据response
     * 然后简单的Json解析
     * 之后放入SharedPreference中
     */
    public static void parseData(String response, Context context) {
        mContext = context;
        try {
            //解析第一个{}
            JSONObject JsonObj = new JSONObject(response);
            //解析第一个[]
            org.json.JSONArray weatherService3 = JsonObj.getJSONArray("HeWeather data service 3.0");
            JSONObject mainBody = weatherService3.getJSONObject(0);
            /************************************主体mainBody************************************/
            /**
             * status ok
             */
            String status = mainBody.getString("status");
//            org.json.JSONArray alarms = mainBody.getJSONArray("alarms");
//            JSONObject alarmsEntity = alarms.getJSONObject(0);
//            //alarms的数组
//            /**
//             * level	橙色
//             * stat	预警中
//             * title	辽宁省大连市气象台发布高温橙色预警
//             * txt	大连市气象台2015年07月14日13时31分发布高温橙色预警信号:预计14日下午至傍晚，旅顺口区局部最高气温将达到37℃以上,请注意防范。
//             * type	高温
//             */
//            String level = alarmsEntity.getString("level");
//            String stat = alarmsEntity.getString("stat");
//            String title = alarmsEntity.getString("title");
//            String Alarmtxt = alarmsEntity.getString("txt");
//            String type = alarmsEntity.getString("type");
            JSONObject aqiEntity = mainBody.getJSONObject("aqi");
            JSONObject cityEntity = aqiEntity.getJSONObject("city");

            /**
             * aqi	71
             * co	1
             * no2	75
             * o3	101
             * pm10	89
             * pm25	44
             * qlty	良
             * so2	27
             */
            String aqi = cityEntity.getString("aqi");
            String co = cityEntity.getString("co");
            String no2 = cityEntity.getString("no2");
            String o3 = cityEntity.getString("o3");
            String pm10 = cityEntity.getString("pm10");
            String pm25 = cityEntity.getString("pm25");
            String qlty = cityEntity.getString("qlty");
            String so2 = cityEntity.getString("so2");
            JSONObject basicEntity = mainBody.getJSONObject("basic");
            /**
             * city	大连
             * cnty	中国
             * id	CN101070201
             * lat	38.944000
             * lon	121.576000
             */
            String city = basicEntity.getString("city");
            String cnty = basicEntity.getString("cnty");
            String id = basicEntity.getString("id");
            String lat = basicEntity.getString("lat");
            String lon = basicEntity.getString("lon");
            JSONObject updateEntity = basicEntity.getJSONObject("update");
            //更新时间
            String loc = updateEntity.getString("loc");
            JSONObject nowEntity = mainBody.getJSONObject("now");
            /**
             * fl	33
             * hum	28
             * pcpn	0
             * pres	1005
             * tmp	32
             * vis	10
             */

            String fl = nowEntity.getString("fl");
            String hum = nowEntity.getString("hum");
            String pcpn = nowEntity.getString("pcpn");
            String pres = nowEntity.getString("pres");
            String tmp = nowEntity.getString("tmp");
            String vis = nowEntity.getString("vis");
            JSONObject condEntity = nowEntity.getJSONObject("cond");
            /**
             * txt 晴
             */
            String txt = condEntity.getString("txt");

            JSONObject windEntity = nowEntity.getJSONObject("wind");
            /**
             * deg	350
             * dir	东北风
             * sc	4-5
             * spd	11
             */
            String spd = windEntity.getString("spd");
            String deg = windEntity.getString("deg");
            String dir = windEntity.getString("dir");
            String sc = windEntity.getString("sc");
            Log.d("atenklsy", "状态：" + status + "\n" + "城市：" + city + "\n" + "气温：" + tmp + "\n" + "天气：" + txt + "\n" + "更新时间：" + loc);

            editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
            editor.putString("status", status);
            editor.putString("city", city);
            editor.putString("tmp", tmp);
            editor.putString("txt", txt);
            editor.putString("spd", spd);
            editor.putString("dir", dir);
            editor.putString("sc", sc);
            editor.putString("loc", loc);
            editor.putString("city", city);
            editor.commit();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public static String getCurTime() {
        //日期格式
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        //获得当前系统时间
        Date date = new Date(System.currentTimeMillis());
//        Log.d("atenklsy","获得的时间是："+ dateFormat.format(date));
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
/**
 * {
 * {
 * "HeWeather data service 3.0": [
 * {
 * "basic": {
 * "city": "大连",
 * "cnty": "中国",
 * "id": "CN101070201",
 * "lat": "38.944000",
 * "lon": "121.576000",
 * "update": {
 * "loc": "2015-07-15 10:43",
 * "utc": "2015-07-15 02:46:14"
 * }
 * },
 * "status": "ok",
 * "aqi": {
 * "city": {
 * "aqi": "71",
 * "co": "1",
 * "no2": "75",
 * "o3": "101",
 * "pm10": "89",
 * "pm25": "44",
 * "qlty": "良",
 * "so2": "27"
 * }
 * },
 * "alarms": [
 * {
 * "level": "橙色",
 * "stat": "预警中",
 * "title": "辽宁省大连市气象台发布高温橙色预警",
 * "txt": "大连市气象台2015年07月14日13时31分发布高温橙色预警信号:预计14日下午至傍晚，旅顺口区局部最高气温将达到37℃以上,请注意防范。
 * ",
 * "type": "高温"
 * }
 * ],
 * "now": {
 * "cond": {
 * "code": "100",
 * "txt": "晴"
 * },
 * "fl": "33",
 * "hum": "28",
 * "pcpn": "0",
 * "pres": "1005",
 * "tmp": "32",
 * "vis": "10",
 * "wind": {
 * "deg": "350",
 * "dir": "东北风",
 * "sc": "4-5",
 * "spd": "11"
 * }
 * },
 * "daily_forecast": [
 * {
 * "date": "2015-07-15",
 * "astro": {
 * "sr": "04:40",
 * "ss": "19:19"
 * },
 * "cond": {
 * "code_d": "100",
 * "code_n": "101",
 * "txt_d": "晴",
 * "txt_n": "多云"
 * },
 * "hum": "48",
 * "pcpn": "0.0",
 * "pop": "0",
 * "pres": "1005",
 * "tmp": {
 * "max": "33",
 * "min": "24"
 * },
 * "vis": "10",
 * "wind": {
 * "deg": "192",
 * "dir": "东南风",
 * "sc": "4-5",
 * "spd": "11"
 * }
 * },
 * {
 * "date": "2015-07-16",
 * "astro": {
 * "sr": "04:40",
 * "ss": "19:18"
 * },
 * "cond": {
 * "code_d": "104",
 * "code_n": "104",
 * "txt_d": "阴",
 * "txt_n": "阴"
 * },
 * "hum": "82",
 * "pcpn": "2.7",
 * "pop": "82",
 * "pres": "1008",
 * "tmp": {
 * "max": "27",
 * "min": "23"
 * },
 * "vis": "10",
 * "wind": {
 * "deg": "116",
 * "dir": "东南风",
 * "sc": "4-5",
 * "spd": "11"
 * }
 * },
 * {
 * "date": "2015-07-17",
 * "astro": {
 * "sr": "04:41",
 * "ss": "19:17"
 * },
 * "cond": {
 * "code_d": "101",
 * "code_n": "100",
 * "txt_d": "多云",
 * "txt_n": "晴"
 * },
 * "hum": "70",
 * "pcpn": "0.1",
 * "pop": "11",
 * "pres": "1006",
 * "tmp": {
 * "max": "28",
 * "min": "22"
 * },
 * "vis": "10",
 * "wind": {
 * "deg": "172",
 * "dir": "西风",
 * "sc": "4-5",
 * "spd": "11"
 * }
 * }
 * ],
 * "hourly_forecast": [
 * {
 * "date": "2015-07-15 10:00",
 * "hum": "51",
 * "pop": "0",
 * "pres": "1006",
 * "tmp": "32",
 * "wind": {
 * "deg": "127",
 * "dir": "东南风",
 * "sc": "微风",
 * "spd": "4"
 * }
 * },
 * {
 * "date": "2015-07-15 13:00",
 * "hum": "49",
 * "pop": "0",
 * "pres": "1005",
 * "tmp": "34",
 * "wind": {
 * "deg": "179",
 * "dir": "南风",
 * "sc": "微风",
 * "spd": "7"
 * }
 * },
 * {
 * "date": "2015-07-15 16:00",
 * "hum": "54",
 * "pop": "0",
 * "pres": "1005",
 * "tmp": "31",
 * "wind": {
 * "deg": "216",
 * "dir": "西南风",
 * "sc": "微风",
 * "spd": "6"
 * }
 * },
 * {
 * "date": "2015-07-15 19:00",
 * "hum": "62",
 * "pop": "0",
 * "pres": "1005",
 * "tmp": "29",
 * "wind": {
 * "deg": "192",
 * "dir": "西南风",
 * "sc": "微风",
 * "spd": "4"
 * }
 * },
 * {
 * "date": "2015-07-15 22:00",
 * "hum": "62",
 * "pop": "0",
 * "pres": "1006",
 * "tmp": "26",
 * "wind": {
 * "deg": "154",
 * "dir": "东南风",
 * "sc": "微风",
 * "spd": "10"
 * }
 * }
 * ],
 * "suggestion": {
 * "comf": {
 * "brf": "较舒适",
 * "txt": "白天天气晴好，您在这种天气条件下，会感觉早晚凉爽、舒适，午后偏热。"
 * },
 * "cw": {
 * "brf": "较不宜",
 * "txt": "较不宜洗车，未来一天无雨，风力较大，如果执意擦洗汽车，要做好蒙上污垢的心理准备。"
 * },
 * "drsg": {
 * "brf": "炎热",
 * "txt": "天气炎热，建议着短衫、短裙、短裤、薄型T恤衫等清凉夏季服装。"
 * },
 * "flu": {
 * "brf": "少发",
 * "txt": "各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。"
 * },
 * "sport": {
 * "brf": "较适宜",
 * "txt": "天气较好，但风力较大，推荐您进行室内运动，若在户外运动请注意防风。"
 * },
 * "trav": {
 * "brf": "适宜",
 * "txt": "天气较好，是个好天气哦。稍热但是风大，能缓解炎热的感觉，适宜旅游，可不要错过机会呦！"
 * },
 * "uv": {
 * "brf": "强",
 * "txt": "紫外线辐射强，建议涂擦SPF20左右、PA++的防晒护肤品。避免在10点至14点暴露于日光下。"
 * }
 * }
 * }
 * ]
 * }
 */
