package com.atenklsy.breezeWeather;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.atenklsy.breezeWeather.api.Constant;
import com.atenklsy.breezeWeather.db.DBManager;
import com.atenklsy.breezeWeather.db.breezeWeatherDB;
import com.atenklsy.breezeWeather.model.City;
import com.atenklsy.breezeWeather.model.Province;
import com.atenklsy.breezeWeather.model.weather.Weather;
import com.atenklsy.breezeWeather.util.HttpUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by atenklsy on 2016/4/9 15:58.
 * E-address:atenk@qq.com.
 */
public class ChooseAreaActivity extends Activity {
    private static final int LEVEL_PROVINCE = 0;
    private static final int LEVEL_CITY = 1;
    List<String> dataList = new ArrayList<String>();
    int currentLevel;
    TextView titleText;
    DBManager mDBManager;
    Intent weatherIntent;
    ArrayAdapter<String> adapter;
    ListView lvChooseArea;
    List<Province> provinceList;
    List<City> cityList;
    Province selectedProvince;
    City selectedCity;
    breezeWeatherDB mbreezeWeatherDB;
    Weather weatherInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_choosearea);
        lvChooseArea = (ListView) findViewById(R.id.lvChooseArea);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dataList);
        lvChooseArea.setAdapter(adapter);

        titleText = (TextView) findViewById(R.id.titleText);
        //数据库操作类，可以加载省级以及市级城市
        mbreezeWeatherDB = new breezeWeatherDB(this);
        //打开数据库，到时候可以get数据库
        mDBManager = new DBManager(this);
        mDBManager.openDatabase();

        lvChooseArea.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (currentLevel == LEVEL_PROVINCE) {
                    selectedProvince = provinceList.get(position);
                    queryCities();
                } else if (currentLevel == LEVEL_CITY) {
                    selectedCity = cityList.get(position);
                    String newName = replaceCityName(selectedCity.getCityName());
                    queryFromServer(newName);
                    Toast.makeText(getApplication(), newName, Toast.LENGTH_SHORT).show();
                    //将数据传给WeatherActivity
                    Intent weatherIntent = new Intent(ChooseAreaActivity.this, WeatherActivity.class);
                    weatherIntent.putExtra("weatherInfo", weatherInfo);
//                    intent.putExtra();
//                    startActivity(weatherIntent);
                    setResult(1, weatherIntent);
                    //setResult(weatherIntent,0);

                }
            }
        });
        queryProvinces();
    }

    public String replaceCityName(String cityName) {
        return cityName.replace("维吾尔族自治区", "").replace("回族自治区", "").replace("藏族自治州", "")
                .replace("藏族羌族自治州", "").replace("朝鲜族自治州", "").replace("林区", "").replace("土家族苗族自治州", "")
                .replace("壮族苗族自治州", "").replace("哈尼族彝族自治州", "").replace("彝族自治州", "").replace("白族自治州", "")
                .replace("回族自治州", "").replace("傣族景颇族自治州", "").replace("傣族自治州", "").replace("哈萨克自治州", "")
                .replace("蒙古族壮族自治州", "").replace("蒙古族藏族自治州", "").replace("蒙古自治州", "").replace("布依族苗族自治州", "")
                .replace("壮族苗族自治州", "").replace("傈傈族自治州", "").replace("苗族侗族自治州", "").replace("傈傈族自治州", "")
                .replace("黎族苗族自治县", "").replace("黎族自治县", "").replace("壮族", "").replace("地区", "").replace("自治州", "")
                .replace("市", "").replace("自治区", "").replace("省", "").replace("特别行政区", "").replace("盟", "");

    }

    //从数据库里面取数据，否则就从网络上请求数据，解析后存到数据库，再取
    private void queryProvinces() {
        provinceList = mbreezeWeatherDB.loadProvinces(mDBManager.getDatabase());
        if (provinceList.size() > 0) {
            dataList.clear();
            for (Province province : provinceList) {
                dataList.add(province.getProName());
            }
            adapter.notifyDataSetChanged();
            lvChooseArea.setSelection(0);
            currentLevel = LEVEL_PROVINCE;
        }
        titleText.setText("中国");
    }

    private void queryCities() {
        cityList = mbreezeWeatherDB.loadCities(mDBManager.getDatabase(), selectedProvince.getProId());
        Log.d("atenklsy", "市级列表" + cityList);
        if (cityList.size() > 0) {
            dataList.clear();
            for (City city : cityList) {
                dataList.add(city.getCityName());
            }
            adapter.notifyDataSetChanged();
            lvChooseArea.setSelection(0);
            currentLevel = LEVEL_CITY;
        }
        titleText.setText(replaceCityName(selectedProvince.getProName()));
    }

    public void queryFromServer(String newName) {
        //当前城市的address由城市名+key组成
        String address = Constant.REQUESTINFO + newName + Constant.KEY;
        //请求网络数据
        HttpUtil.sendHttpRequest(address, new HttpUtil.HttpCallbackListener() {
            //获取网络数据成功
            @Override
            public void onFinish(String response) {
                Log.d("atenklsy", "请求到网络数据了" + response);
                //调用解析数据的方法
//                Utility.parseData(response);
                parseData(response);
            }

            //获取网络数据失败
            @Override
            public void onError(Exception e) {
                Log.d("atenklsy", "请求数据出错了！");
                e.printStackTrace();
            }
        });
    }

    //专门的解析数据方法
    private void parseData(String response) {
        Weather weatherInfo = null;
//        Gson gson = new Gson();
//        weatherInfo = gson.fromJson(response, Weather.class);
        weatherInfo = JSON.parseObject(response, Weather.class);
        Log.d("atenklsy", "我的weatherInfo如下" + weatherInfo);
        if (weatherInfo.getStatus() != null) {
            //如果状态值为不为空，则解析数据正常
            Log.d("atenklsy", "解析结果2" + weatherInfo.getStatus());

        } else {
            //如果状态只为空，则解析数据出错
            Log.d("ateknlsy", "Status==null!!!!!!");
        }


    }


//    private void queryCounties() {
//        countyList = mbreezeWeatherDB.loadCounties(selectedCity.getId());
//        if (countyList.size() > 0) {
//            dataList.clear();
//            for (County county : countyList) {
//                dataList.add(county.getCountyName());
//            }
//            adapter.notifyDataSetChanged();
//            lvChooseArea.setSelection(0);
//            currentLevel = LEVEL_COUNTY;
//        } else {
//            queryFromServer("", "county");
//        }
//    }


//    private void queryFromServer(final String code, final String type) {
//        String address;
//        if (!TextUtils.isEmpty(code)) {
//            address = "http://www.weather.com.cn/data/list3/city" + code + ".xml";
//        } else {
//            address = "http://www.weather.com.cn/data/list3/city.xml";
//        }
//        showProgressDialog();
//        HttpUtil.sendHttpRequest(address, new HttpUtil.HttpCallbackListener() {
//            @Override
//            public void onFinish(String response) {
//                boolean result = false;
//                if ("province".equals(type)) {
////                   如果传入的类型是省级，则从数据库里拿到省级的数据
//                    result = Utility.handleProvinceResponse(mbreezeWeatherDB, response);
//                } else if ("city".equals(type)) {
//                    result = Utility.handleCityResponse(mbreezeWeatherDB, response, selectedProvince.getId());
//                } else if ("county".equals(type)) {
//                    result = Utility.handleCountyResponse(mbreezeWeatherDB, response, selectedCity.getId());
//                }
//
//                if (result) {
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
////                            closeProgressDialog();
//                            if ("province".equals(type)) {
//                                queryProvinces();
//                            } else if ("city".equals(type)) {
//                                queryCities();
//                            } else if ("county".equals(type)) {
//                                queryCounties();
//                            }
//                        }
//                    });
//                }
//            }
//
//            @Override
//            public void onError(Exception e) {
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        closeProgressDialog();
//                        Toast.makeText(getApplicationContext(), "加载失败", Toast.LENGTH_SHORT).show();
//                    }
//                });
//            }
//        });
//
//    }

    /**
     * 开启进度对话框
     */
    private void showProgressDialog() {

    }

    /*
    关闭进度对话框
     */
    private void closeProgressDialog() {

    }

    /*
    捕捉返回键，如果当前级别为县级，则查询市级，
    如果当前为市级，则查询县级
     */
    public void onBackPressed() {
        if (currentLevel == LEVEL_CITY) {
            queryProvinces();
            if (selectedProvince.getProId() >= 1) {
                lvChooseArea.setSelection(selectedProvince.getProId() - 1);
            }
            lvChooseArea.setSelection(selectedProvince.getProId());

        } else {
            //否则则返回天气界面，当前暂未实现
            finish();
        }
    }
}
