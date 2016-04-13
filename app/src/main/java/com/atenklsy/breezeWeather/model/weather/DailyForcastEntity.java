package com.atenklsy.breezeWeather.model.weather;

import java.io.Serializable;

/**
 * Created by atenklsy on 2016/5/29 11:42.
 * E-address:atenk@qq.com.
 */


public  class DailyForcastEntity implements Serializable {
    private AstroEntity astro;
    private CondEntity cond;
    private String date;
    private String hum;
    private String pcpn;
    private String pop;
    private String pres;
    private TemEntity tem;
    private String vis;
    private WindEntity wind;

    public AstroEntity getAstro() {
        return astro;
    }

    public void setAstro(AstroEntity astro) {
        this.astro = astro;
    }

    public CondEntity getCond() {
        return cond;
    }

    public void setCond(CondEntity cond) {
        this.cond = cond;
    }

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

    public String getPcpn() {
        return pcpn;
    }

    public void setPcpn(String pcpn) {
        this.pcpn = pcpn;
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

    public TemEntity getTem() {
        return tem;
    }

    public void setTem(TemEntity tem) {
        this.tem = tem;
    }

    public String getVis() {
        return vis;
    }

    public void setVis(String vis) {
        this.vis = vis;
    }

    public WindEntity getWind() {
        return wind;
    }

    public void setWind(WindEntity wind) {
        this.wind = wind;
    }

    @Override
    public String toString() {
        return "DailyForcastEntity{" +
                "astro=" + astro +
                ", cond=" + cond +
                ", date='" + date + '\'' +
                ", hum='" + hum + '\'' +
                ", pcpn='" + pcpn + '\'' +
                ", pop='" + pop + '\'' +
                ", pres='" + pres + '\'' +
                ", tem=" + tem +
                ", vis='" + vis + '\'' +
                ", wind=" + wind +
                '}';
    }

    public static class AstroEntity implements Serializable {
        private String sr;
        private String ss;

        public String getSr() {
            return sr;
        }

        public void setSr(String sr) {
            this.sr = sr;
        }

        public String getSs() {
            return ss;
        }

        public void setSs(String ss) {
            this.ss = ss;
        }

        @Override
        public String toString() {
            return "AstroEntity{" +
                    "sr='" + sr + '\'' +
                    ", ss='" + ss + '\'' +
                    '}';
        }
    }

    public static class CondEntity implements Serializable {
        private String code_d;
        private String code_n;
        private String text_d;
        private String text_n;

        public String getCode_d() {
            return code_d;
        }

        public void setCode_d(String code_d) {
            this.code_d = code_d;
        }

        public String getCode_n() {
            return code_n;
        }

        public void setCode_n(String code_n) {
            this.code_n = code_n;
        }

        public String getText_d() {
            return text_d;
        }

        public void setText_d(String text_d) {
            this.text_d = text_d;
        }

        public String getText_n() {
            return text_n;
        }

        public void setText_n(String text_n) {
            this.text_n = text_n;
        }

        @Override
        public String toString() {
            return "CondEntity{" +
                    "code_d='" + code_d + '\'' +
                    ", code_n='" + code_n + '\'' +
                    ", text_d='" + text_d + '\'' +
                    ", text_n='" + text_n + '\'' +
                    '}';
        }
    }

    public static class TemEntity implements Serializable {
        private String max;
        private String min;

        public String getMax() {
            return max;
        }

        public void setMax(String max) {
            this.max = max;
        }

        public String getMin() {
            return min;
        }

        public void setMin(String min) {
            this.min = min;
        }

        @Override
        public String toString() {
            return "TemEntity{" +
                    "max='" + max + '\'' +
                    ", min='" + min + '\'' +
                    '}';
        }
    }

    public static class WindEntity implements Serializable {
        private String deg;
        private String dir;
        private String sc;
        private String spd;

        public String getDeg() {

            return deg;
        }

        public void setDeg(String deg) {
            this.deg = deg;
        }

        public String getDir() {
            return dir;
        }

        public void setDir(String dir) {
            this.dir = dir;
        }

        public String getSc() {
            return sc;
        }

        public void setSc(String sc) {
            this.sc = sc;
        }

        public String getSpd() {
            return spd;
        }

        public void setSpd(String spd) {
            this.spd = spd;
        }

        @Override
        public String toString() {
            return "WindEntity{" +
                    "deg='" + deg + '\'' +
                    ", dir='" + dir + '\'' +
                    ", sc='" + sc + '\'' +
                    ", spd='" + spd + '\'' +
                    '}';
        }
    }

}