package com.atenklsy.breezeWeather.model.weather;

import java.io.Serializable;

/**
 * Created by atenklsy on 2016/5/29 11:41.
 * E-address:atenk@qq.com.
 */



public  class NowEntity implements Serializable {
    private DailyForcastEntity.CondEntity cond;

    private String fl;
    private String hum;
    private String pcpn;
    private String pres;
    private String tem;
    private String vis;
    private DailyForcastEntity.WindEntity wind;

    public DailyForcastEntity.CondEntity getCond() {
        return cond;
    }

    public void setCond(DailyForcastEntity.CondEntity cond) {
        this.cond = cond;
    }

    public String getFl() {
        return fl;
    }

    public void setFl(String fl) {
        this.fl = fl;
    }

    public String getHum() {
        return hum;
    }

    public void setHum(String hum) {
        this.hum = hum;
    }

    public String getPcpn() {
        return pcpn;
    }

    public void setPcpn(String pcpn) {
        this.pcpn = pcpn;
    }

    public String getPres() {
        return pres;
    }

    public void setPres(String pres) {
        this.pres = pres;
    }

    public String getTem() {
        return tem;
    }

    public void setTem(String tem) {
        this.tem = tem;
    }

    public String getVis() {
        return vis;
    }

    public void setVis(String vis) {
        this.vis = vis;
    }

    public DailyForcastEntity.WindEntity getWind() {
        return wind;
    }

    public void setWind(DailyForcastEntity.WindEntity wind) {
        this.wind = wind;
    }

    @Override
    public String toString() {
        return "NowEntity{" +
                "cond=" + cond +
                ", fl='" + fl + '\'' +
                ", hum='" + hum + '\'' +
                ", pcpn='" + pcpn + '\'' +
                ", pres='" + pres + '\'' +
                ", tem='" + tem + '\'' +
                ", vis='" + vis + '\'' +
                ", wind=" + wind +
                '}';
    }
}