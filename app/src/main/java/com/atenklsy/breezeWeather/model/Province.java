package com.atenklsy.breezeWeather.model;

import java.io.Serializable;

/**
 * Province实体类
 *
 * @author atenklsy
 */
public class Province implements Serializable {
    private int proId;
    private String proName;

    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }
}
