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
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.atenklsy.breezeWeather.util.Utility;

public class WeatherActivity extends Activity implements View.OnClickListener {
    Button btnChooseArea, btnRefreshWeather;
    TextView tvCounty, tvRefreshTime, tvCurrentDay, tvCurrentTemp, tvCurrentText;
    Intent getWeatherIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_weather);
        initView();
        initData();
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
    }

    private void initData() {
//        tvCounty.setText();
//        tvRefreshTime.setText();
//        tvCurrentDay.setText();
//        tvCurrentTemp.setText();
//        tvCurrentText.setText();
        btnChooseArea.setOnClickListener(this);
        btnRefreshWeather.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnChooseArea:
                getWeatherIntent = new Intent(WeatherActivity.this, ChooseAreaActivity.class);
                //选择之后，会返回数据
                startActivityForResult(getWeatherIntent, 0);
                break;

            case R.id.btnRefreshWeather:
                //手动更新天气
                String curTime = Utility.getCurTime();
                break;

        }

    }

    /**
     * //从ChooseAreaActivity返回天气数据
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == resultCode) {
//           Weather weatherInfo =  data.getExtras("weatherInfo");
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
