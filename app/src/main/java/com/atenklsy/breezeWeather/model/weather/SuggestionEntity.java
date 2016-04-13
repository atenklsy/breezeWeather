package com.atenklsy.breezeWeather.model.weather;

import java.io.Serializable;

/**
 * Created by atenklsy on 2016/5/29 11:40.
 * E-address:atenk@qq.com.
 */



public class SuggestionEntity implements Serializable {
    private ComfEntity comf;
    private CwEntity cw;
    private DrsgEntity drsg;
    private FluEntity flu;
    private SportEntity sport;
    private TravEntity trav;
    private UvEntity uv;

    public ComfEntity getComf() {
        return comf;
    }

    public void setComf(ComfEntity comf) {
        this.comf = comf;
    }

    public CwEntity getCw() {
        return cw;
    }

    public void setCw(CwEntity cw) {
        this.cw = cw;
    }

    public DrsgEntity getDrsg() {
        return drsg;
    }

    public void setDrsg(DrsgEntity drsg) {
        this.drsg = drsg;
    }

    public FluEntity getFlu() {
        return flu;
    }

    public void setFlu(FluEntity flu) {
        this.flu = flu;
    }

    public SportEntity getSport() {
        return sport;
    }

    public void setSport(SportEntity sport) {
        this.sport = sport;
    }

    public TravEntity getTrav() {
        return trav;
    }

    public void setTrav(TravEntity trav) {
        this.trav = trav;
    }

    public UvEntity getUv() {
        return uv;
    }

    public void setUv(UvEntity uv) {
        this.uv = uv;
    }

    @Override
    public String toString() {
        return "SuggestionEntity{" +
                "comf=" + comf +
                ", cw=" + cw +
                ", drsg=" + drsg +
                ", flu=" + flu +
                ", sport=" + sport +
                ", trav=" + trav +
                ", uv=" + uv +
                '}';
    }

    public static class ComfEntity implements Serializable {
        private String brf;
        private String txt;

        public String getBrf() {
            return brf;
        }

        public void setBrf(String brf) {
            this.brf = brf;
        }

        public String getTxt() {
            return txt;
        }

        public void setTxt(String txt) {
            this.txt = txt;
        }

        @Override
        public String toString() {
            return "ComfEntity{" +
                    "brf='" + brf + '\'' +
                    ", txt='" + txt + '\'' +
                    '}';
        }
    }

    public static class DrsgEntity implements Serializable {
        private String brf;
        private String txt;

        public String getBrf() {
            return brf;
        }

        public void setBrf(String brf) {
            this.brf = brf;
        }

        public String getTxt() {
            return txt;
        }

        public void setTxt(String txt) {
            this.txt = txt;
        }

        @Override
        public String toString() {
            return "DrsgEntity{" +
                    "brf='" + brf + '\'' +
                    ", txt='" + txt + '\'' +
                    '}';
        }
    }

    public static class CwEntity implements Serializable {
        private String brf;
        private String txt;

        public String getBrf() {
            return brf;
        }

        public void setBrf(String brf) {
            this.brf = brf;
        }

        public String getTxt() {
            return txt;
        }

        public void setTxt(String txt) {
            this.txt = txt;
        }

        @Override
        public String toString() {
            return "CwEntity{" +
                    "brf='" + brf + '\'' +
                    ", txt='" + txt + '\'' +
                    '}';
        }
    }

    public static class DrswEntity implements Serializable {
        private String brf;
        private String txt;

        public String getBrf() {
            return brf;
        }

        public void setBrf(String brf) {
            this.brf = brf;
        }

        public String getTxt() {
            return txt;
        }

        public void setTxt(String txt) {
            this.txt = txt;
        }

        @Override
        public String toString() {
            return "DrswEntity{" +
                    "brf='" + brf + '\'' +
                    ", txt='" + txt + '\'' +
                    '}';
        }
    }

    public static class FluEntity implements Serializable {
        private String brf;
        private String txt;

        public String getTxt() {
            return txt;
        }

        public void setTxt(String txt) {
            this.txt = txt;
        }

        public String getBrf() {
            return brf;
        }

        public void setBrf(String brf) {
            this.brf = brf;
        }

        @Override
        public String toString() {
            return "FluEntity{" +
                    "brf='" + brf + '\'' +
                    ", txt='" + txt + '\'' +
                    '}';
        }
    }

    public static class SportEntity implements Serializable {
        private String brf;
        private String txt;

        public String getBrf() {
            return brf;
        }

        public void setBrf(String brf) {
            this.brf = brf;
        }

        public String getTxt() {
            return txt;
        }

        public void setTxt(String txt) {
            this.txt = txt;
        }

        @Override
        public String toString() {
            return "SportEntity{" +
                    "brf='" + brf + '\'' +
                    ", txt='" + txt + '\'' +
                    '}';
        }
    }

    public static class TravEntity implements Serializable {
        private String brf;
        private String txt;

        public String getTxt() {
            return txt;
        }

        public void setTxt(String txt) {
            this.txt = txt;
        }

        public String getBrf() {
            return brf;
        }

        public void setBrf(String brf) {
            this.brf = brf;
        }

        @Override
        public String toString() {
            return "TravEntity{" +
                    "brf='" + brf + '\'' +
                    ", txt='" + txt + '\'' +
                    '}';
        }
    }

    public static class UvEntity implements Serializable {
        private String brf;
        private String txt;

        public String getBrf() {
            return brf;
        }

        public void setBrf(String brf) {
            this.brf = brf;
        }

        public String getTxt() {
            return txt;
        }

        public void setTxt(String txt) {
            this.txt = txt;
        }

        @Override
        public String toString() {
            return "UvEntity{" +
                    "brf='" + brf + '\'' +
                    ", txt='" + txt + '\'' +
                    '}';
        }
    }
}