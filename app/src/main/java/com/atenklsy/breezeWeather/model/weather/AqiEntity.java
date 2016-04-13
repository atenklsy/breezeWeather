package com.atenklsy.breezeWeather.model.weather;

import java.io.Serializable;

/**
 * Created by atenklsy on 2016/5/29 11:43.
 * E-address:atenk@qq.com.
 */

public  class AqiEntity implements Serializable {
    private CityEntity city;

    public CityEntity getCity() {
        return city;
    }

    public void setCity(CityEntity city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "AqiEntity{" +
                "city=" + city +
                '}';
    }

    public static class CityEntity implements Serializable {
        private String aqi;
        private String pm10;
        private String pm25;

        public String getAqi() {
            return aqi;
        }

        public void setAqi(String aqi) {
            this.aqi = aqi;
        }

        public String getPm10() {
            return pm10;
        }

        public void setPm10(String pm10) {
            this.pm10 = pm10;
        }

        public String getPm25() {
            return pm25;
        }

        public void setPm25(String pm25) {
            this.pm25 = pm25;
        }

        @Override
        public String toString() {
            return "CityEntity{" +
                    "aqi='" + aqi + '\'' +
                    ", pm10='" + pm10 + '\'' +
                    ", pm25='" + pm25 + '\'' +
                    '}';
        }
    }
}

