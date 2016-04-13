package com.atenklsy.breezeWeather.model.weather;

import java.io.Serializable;
import java.util.List;


/**
 * Created by atenklsy on 2016/5/17 17:27.
 * E-address:atenk@qq.com.
 */

/**
 * Weather
 * basic	Object
 * daily_forecast	Array
 * hourly_forecast	Array
 * now	Object
 * status	ok
 * suggestion	Object
 */
public class Weather implements Serializable {

    private AqiEntity aqi;
    /**
     * city	赣州
     * cnty	中国
     * id	CN101240701
     * lat	25.832000
     * lon	114.916000
     * update	Object
     */
    private BasicEntity basic;
    /**
     * astro Object
     * cond	Object
     * date	2016-05-17
     * hum	56
     * pcpn	0.0
     * pop	0
     * pres	1012
     * tmp	Object
     * vis	10
     * wind	Object
     */
    private List<DailyForcastEntity> daily_forcast;
    /**
     * date	2016-05-17 19:00
     * hum	73
     * pop	0
     * pres	1011
     * tmp	28
     * wind	Object
     */
    private List<HourlyForcastEntity> hourly_forcast;
    /**
     * cond	Object
     * fl	32
     * hum	45
     * pcpn	0
     * pres	1011
     * tmp	26
     * vis	10
     * wind	Object
     */
    private NowEntity now;
    private String status;
    /**
     * comf	Object
     * cw Object
     * drsg	Object
     * flu Object
     * sport Object
     * trav	Object
     * uv Object
     */
    private SuggestionEntity suggestion;

    public AqiEntity getAqi() {
        return aqi;
    }

    public void setAqi(AqiEntity aqi) {
        this.aqi = aqi;
    }

    public BasicEntity getBasic() {
        return basic;
    }

    public void setBasic(BasicEntity basic) {
        this.basic = basic;
    }

    public List<DailyForcastEntity> getDaily_forcast() {
        return daily_forcast;
    }

    public void setDaily_forcast(List<DailyForcastEntity> daily_forcast) {
        this.daily_forcast = daily_forcast;
    }

    public List<HourlyForcastEntity> getHourly_forcast() {
        return hourly_forcast;
    }

    public void setHourly_forcast(List<HourlyForcastEntity> hourly_forcast) {
        this.hourly_forcast = hourly_forcast;
    }

    public NowEntity getNow() {
        return now;
    }

    public void setNow(NowEntity now) {
        this.now = now;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public SuggestionEntity getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(SuggestionEntity suggestion) {
        this.suggestion = suggestion;
    }


    @Override
    public String toString() {
        return "Weather{" +
                "aqi=" + aqi +
                ", basic=" + basic +
                ", daily_forcast=" + daily_forcast +
                ", hourly_forcast=" + hourly_forcast +
                ", now=" + now +
                ", status='" + status + '\'' +
                ", suggestion=" + suggestion +
                '}';
    }
}



/*
{
    "HeWeather data service 3.0": [
        {
            "basic": {
                "city": "赣州",
                "cnty": "中国",
                "id": "CN101240701",
                "lat": "25.832000",
                "lon": "114.916000",
                "update": {
                    "loc": "2016-05-17 18:52",
                    "utc": "2016-05-17 10:52"
                }
            },
            "daily_forecast": [
                {
                    "astro": {
                        "sr": "05:33",
                        "ss": "19:00"
                    },
                    "cond": {
                        "code_d": "103",
                        "code_n": "101",
                        "txt_d": "晴间多云",
                        "txt_n": "多云"
                    },
                    "date": "2016-05-17",
                    "hum": "56",
                    "pcpn": "0.0",
                    "pop": "0",
                    "pres": "1012",
                    "tmp": {
                        "max": "30",
                        "min": "19"
                    },
                    "vis": "10",
                    "wind": {
                        "deg": "212",
                        "dir": "无持续风向",
                        "sc": "微风",
                        "spd": "4"
                    }
                },
                {
                    "astro": {
                        "sr": "05:32",
                        "ss": "19:00"
                    },
                    "cond": {
                        "code_d": "104",
                        "code_n": "104",
                        "txt_d": "阴",
                        "txt_n": "阴"
                    },
                    "date": "2016-05-18",
                    "hum": "54",
                    "pcpn": "1.5",
                    "pop": "86",
                    "pres": "1011",
                    "tmp": {
                        "max": "28",
                        "min": "22"
                    },
                    "vis": "10",
                    "wind": {
                        "deg": "181",
                        "dir": "无持续风向",
                        "sc": "微风",
                        "spd": "1"
                    }
                },
                {
                    "astro": {
                        "sr": "05:32",
                        "ss": "19:01"
                    },
                    "cond": {
                        "code_d": "302",
                        "code_n": "302",
                        "txt_d": "雷阵雨",
                        "txt_n": "雷阵雨"
                    },
                    "date": "2016-05-19",
                    "hum": "65",
                    "pcpn": "4.9",
                    "pop": "82",
                    "pres": "1008",
                    "tmp": {
                        "max": "30",
                        "min": "23"
                    },
                    "vis": "10",
                    "wind": {
                        "deg": "187",
                        "dir": "无持续风向",
                        "sc": "微风",
                        "spd": "0"
                    }
                },
                {
                    "astro": {
                        "sr": "05:31",
                        "ss": "19:01"
                    },
                    "cond": {
                        "code_d": "306",
                        "code_n": "307",
                        "txt_d": "中雨",
                        "txt_n": "大雨"
                    },
                    "date": "2016-05-20",
                    "hum": "73",
                    "pcpn": "2.7",
                    "pop": "73",
                    "pres": "1008",
                    "tmp": {
                        "max": "29",
                        "min": "23"
                    },
                    "vis": "10",
                    "wind": {
                        "deg": "184",
                        "dir": "无持续风向",
                        "sc": "微风",
                        "spd": "0"
                    }
                },
                {
                    "astro": {
                        "sr": "05:31",
                        "ss": "19:02"
                    },
                    "cond": {
                        "code_d": "306",
                        "code_n": "300",
                        "txt_d": "中雨",
                        "txt_n": "阵雨"
                    },
                    "date": "2016-05-21",
                    "hum": "96",
                    "pcpn": "50.1",
                    "pop": "67",
                    "pres": "1009",
                    "tmp": {
                        "max": "27",
                        "min": "21"
                    },
                    "vis": "8",
                    "wind": {
                        "deg": "189",
                        "dir": "无持续风向",
                        "sc": "微风",
                        "spd": "8"
                    }
                },
                {
                    "astro": {
                        "sr": "05:31",
                        "ss": "19:02"
                    },
                    "cond": {
                        "code_d": "104",
                        "code_n": "101",
                        "txt_d": "阴",
                        "txt_n": "多云"
                    },
                    "date": "2016-05-22",
                    "hum": "82",
                    "pcpn": "3.3",
                    "pop": "34",
                    "pres": "1010",
                    "tmp": {
                        "max": "26",
                        "min": "21"
                    },
                    "vis": "10",
                    "wind": {
                        "deg": "223",
                        "dir": "无持续风向",
                        "sc": "微风",
                        "spd": "10"
                    }
                },
                {
                    "astro": {
                        "sr": "05:30",
                        "ss": "19:03"
                    },
                    "cond": {
                        "code_d": "104",
                        "code_n": "300",
                        "txt_d": "阴",
                        "txt_n": "阵雨"
                    },
                    "date": "2016-05-23",
                    "hum": "89",
                    "pcpn": "5.5",
                    "pop": "49",
                    "pres": "1011",
                    "tmp": {
                        "max": "28",
                        "min": "21"
                    },
                    "vis": "9",
                    "wind": {
                        "deg": "6",
                        "dir": "无持续风向",
                        "sc": "微风",
                        "spd": "9"
                    }
                }
            ],
            "hourly_forecast": [
                {
                    "date": "2016-05-17 19:00",
                    "hum": "73",
                    "pop": "0",
                    "pres": "1011",
                    "tmp": "28",
                    "wind": {
                        "deg": "81",
                        "dir": "东风",
                        "sc": "微风",
                        "spd": "2"
                    }
                },
                {
                    "date": "2016-05-17 22:00",
                    "hum": "81",
                    "pop": "0",
                    "pres": "1013",
                    "tmp": "26",
                    "wind": {
                        "deg": "45",
                        "dir": "东北风",
                        "sc": "微风",
                        "spd": "1"
                    }
                }
            ],
            "now": {
                "cond": {
                    "code": "101",
                    "txt": "多云"
                },
                "fl": "32",
                "hum": "45",
                "pcpn": "0",
                "pres": "1011",
                "tmp": "26",
                "vis": "10",
                "wind": {
                    "deg": "213",
                    "dir": "南风",
                    "sc": "3-4",
                    "spd": "10"
                }
            },
            "status": "ok",
            "suggestion": {
                "comf": {
                    "brf": "较舒适",
                    "txt": "白天天气晴好，您在这种天气条件下，会感觉早晚凉爽、舒适，午后偏热。"
                },
                "cw": {
                    "brf": "较适宜",
                    "txt": "较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"
                },
                "drsg": {
                    "brf": "热",
                    "txt": "天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。"
                },
                "flu": {
                    "brf": "少发",
                    "txt": "各项气象条件适宜，无明显降温过程，发生感冒机率较低。"
                },
                "sport": {
                    "brf": "较适宜",
                    "txt": "天气较好，户外运动请注意防晒。推荐您进行室内运动。"
                },
                "trav": {
                    "brf": "适宜",
                    "txt": "天气较好，但丝毫不会影响您出行的心情。温度适宜又有微风相伴，适宜旅游。"
                },
                "uv": {
                    "brf": "弱",
                    "txt": "紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。"
                }
            }
        }
    ]
}
 */
