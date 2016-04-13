package com.atenklsy.breezeWeather.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.atenklsy.breezeWeather.R;
import com.atenklsy.breezeWeather.model.City;
import com.atenklsy.breezeWeather.model.County;
import com.atenklsy.breezeWeather.model.Province;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据库的开启与读入、取出操作
 */
public class breezeWeatherDB {

    private Context mContext;

    public breezeWeatherDB(Context context) {
        mContext = context;
    }

    /**
     * 从数据库读取全国所有省份的信息
     *
     * @return list
     */
    public List<Province> loadProvinces(SQLiteDatabase db) {
        List<Province> provinceList = new ArrayList<Province>();
        Cursor cursor = db.query("T_Province", null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            Province province = new Province();
            province.setProId(cursor.getInt(cursor.getColumnIndex("ProSort")));
            province.setProName(cursor.getString(cursor.getColumnIndex("ProName")));
            provinceList.add(province);
        }
        cursor.close();
        return provinceList;
    }

    /**
     * 从City表中加载数据
     *
     * @return
     */
    public List<City> loadCities(SQLiteDatabase db, int ProID) {
        List<City> cityList = new ArrayList<City>();
        Cursor cursor = db.query("T_City", null, "ProID = ?", new String[]{String.valueOf(ProID)}, null, null, null);
        while (cursor.moveToNext()) {
            City city = new City();
            city.setCityName(cursor.getString(cursor.getColumnIndex("CityName")));
            city.setCityId(cursor.getInt(cursor.getColumnIndex("CitySort")));
            cityList.add(city);
        }
        cursor.close();
        return cityList;
    }


//    public List<County> loadCounties(int cityId) {
//        List<County> list = new ArrayList<County>();
//        Cursor cursor = db.query("County", null, null, null, null, null, null);
//        while (cursor.moveToNext()) {
//            County county = new County();
//            county.setId(cursor.getInt(cursor.getColumnIndex("id")));
//            county.setCountyCode(cursor.getString(cursor.getColumnIndex("county_code")));
//            county.setCountyName(cursor.getString(cursor.getColumnIndex("county_name")));
//            county.setCityId(cityId);
//            list.add(county);
//        }
//
//        return list;
//    }


}
