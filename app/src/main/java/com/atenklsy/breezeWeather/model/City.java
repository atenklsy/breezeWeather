package com.atenklsy.breezeWeather.model;

import java.io.Serializable;

/**
 * City实体类
 *
 * @author atenklsy
 */


public class City implements Serializable{

    private int proId;
    private int cityId;
    private String cityName;

    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
