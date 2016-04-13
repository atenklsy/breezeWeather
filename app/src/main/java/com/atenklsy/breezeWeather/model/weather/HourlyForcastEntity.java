package com.atenklsy.breezeWeather.model.weather;

import java.io.Serializable;

/**
 * Created by atenklsy on 2016/5/29 11:41.
 * E-address:atenk@qq.com.
 */




public  class HourlyForcastEntity implements Serializable {
    private String date;
    private String hum;
    private String pop;
    private String pres;
    private String temp;
    private DailyForcastEntity.WindEntity wind;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHum() {
        return hum;
    }

    public void setHum(String hum) {
        this.hum = hum;
    }

    public String getPop() {
        return pop;
    }

    public void setPop(String pop) {
        this.pop = pop;
    }

    public String getPres() {
        return pres;
    }

    public void setPres(String pres) {
        this.pres = pres;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public DailyForcastEntity.WindEntity getWind() {
        return wind;
    }

    public void setWind(DailyForcastEntity.WindEntity wind) {
        this.wind = wind;
    }

    @Override
    public String toString() {
        return "HourlyForcastEntity{" +
                "date='" + date + '\'' +
                ", hum='" + hum + '\'' +
                ", pop='" + pop + '\'' +
                ", pres='" + pres + '\'' +
                ", temp='" + temp + '\'' +
                ", wind=" + wind +
                '}';
    }
}