package com.atenklsy.breezeWeather;

/**
 * 任务
 * 0.手动更新
 * //判断时间，再读数据
 * 1.自动更新
 * //服务自动更新
 */

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.atenklsy.breezeWeather.api.Constant;
import com.atenklsy.breezeWeather.util.HttpUtil;
import com.atenklsy.breezeWeather.util.Utility;

public class WeatherActivity extends Activity implements View.OnClickListener {
    Button btnChooseArea, btnRefreshWeather;
    TextView tvCounty, tvRefreshTime, tvCurrentDay, tvCurrentTemp, tvCurrentText;
    Intent getWeatherIntent;
    String cityName, address;
    SharedPreferences sp;
    private Handler showWeatherHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
//           在主界面显示天气
            showWeather();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_weather);
        initView();
    }

    private void initView() {
        //标题名
        tvCounty = (TextView) findViewById(R.id.tvCounty);
        //更新时间
        tvRefreshTime = (TextView) findViewById(R.id.tvRefreshTime);
        //当前日期
        tvCurrentDay = (TextView) findViewById(R.id.tvCurrentDay);
        //当前温度
        tvCurrentTemp = (TextView) findViewById(R.id.tvCurrentTemp);
        //当前天气描述
        tvCurrentText = (TextView) findViewById(R.id.tvCurrentText);
        //选择城市
        btnChooseArea = (Button) findViewById(R.id.btnChooseArea);
        //手动更新天气
        btnRefreshWeather = (Button) findViewById(R.id.btnRefreshWeather);
        btnChooseArea.setOnClickListener(this);
        btnRefreshWeather.setOnClickListener(this);
        initData();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnChooseArea:
                getWeatherIntent = new Intent(WeatherActivity.this, ChooseAreaActivity.class);
//                startActivityForResult(getWeatherIntent, 0);
                startActivity(getWeatherIntent);
                break;
            case R.id.btnRefreshWeather:
                //再请求一次网络？
                break;

        }

    }

    void initData() {

        cityName = WeatherActivity.this.getIntent().getStringExtra("cityName");
        Toast.makeText(this, cityName, Toast.LENGTH_LONG).show();
        requestDataFromAddress(cityName);

    }

    private void requestDataFromAddress(final String mCityName) {
        if (!TextUtils.isEmpty(cityName)) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    address = Constant.REQUESTINFO + mCityName + Constant.KEY;
                    //请求网络数据
                    HttpUtil.sendHttpRequest(address, new HttpUtil.HttpCallbackListener() {
                        //获取网络数据成功
                        @Override
                        public void onFinish(String response) {
                            Log.d("atenklsy", "请求到网络数据了" + response);
                            //调用解析数据的方法
                            //处理数据1.handleMessage（解析，并存入Prefence）
                            Utility.parseData(response, WeatherActivity.this);
                            // Message weatherMsg = showWeatherHandler.obtainMessage();
                            showWeatherHandler.sendEmptyMessage(0);


                        }

                        @Override
                        public void onError(Exception e) {
                            Log.d("atenklsy", "请求数据出错了！");
                            e.printStackTrace();
                        }
                    });
                }
            }).start();

        } else {
            //从之前的数据里面取数数据然后放上去
//            查询北京的天气
            showWeather();
        }
    }

    /**
     * 将2016-1-1转成2016年1月1日
     */
    private String handleLocTime(String locDay) {
        String[] realTime = locDay.split("\\-");
        //将2016-1-1分成2016,1,1三个字符串存入数组
        String year = realTime[0];
        String month = realTime[1];
        String day = realTime[2];
        String castDay = year + "年" + month + "月" + day + "日";
        return castDay;
    }

    /**
     * 显示天气数据
     */

    private void showWeather() {
        sp = PreferenceManager.getDefaultSharedPreferences(this);
        //将日期分割开来，空格分隔符：\\s+
        String[] loc = sp.getString("loc", "").split("\\s+");
        //日期
        String locDay = loc[0];
        //时间
        String locTime = loc[1];
        String castDay = handleLocTime(locDay);
        tvCounty.setText(sp.getString("city", ""));
        tvRefreshTime.setText("更新时间:" + locTime);
        tvCurrentDay.setText(castDay);
        tvCurrentTemp.setText(sp.getString("tmp", "") + "℃");
        tvCurrentText.setText(sp.getString("txt", ""));
    }

}
