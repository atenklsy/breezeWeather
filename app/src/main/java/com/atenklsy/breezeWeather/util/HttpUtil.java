package com.atenklsy.breezeWeather.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by atenklsy on 2016/4/9 15:20.
 * E-address:atenk@qq.com.
 */

/**
 * 提示，android中已经不能再mainUi里面做请求网络等耗时操作，必须在子线程里面进行，所以要开启线程！
 * 如果出现ANR等情况，则是犯了以上错误！
 */
public class HttpUtil {
    public static void sendHttpRequest(final String address, final HttpCallbackListener listener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                try {
                    URL url = new URL(address);
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.connect();
                    connection.setConnectTimeout(8000);
                    InputStreamReader in = new InputStreamReader(connection.getInputStream());
                    BufferedReader reader = new BufferedReader(in);
                    StringBuffer response = new StringBuffer();
                    String line = "";
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    if (listener != null) {
                        listener.onFinish(response.toString());
                    }
                } catch (Exception e) {
                    if (listener != null) {
                        listener.onError(e);
                    }
                } finally {
                    if (connection != null) {
                        connection.disconnect();
                    }
                }
            }
        }).start();
    }

    /**
     * 回调接口，调用上面的请求网络方法，需要重写一下两个方法，在onFinish中有请求得到的response参数
     */
    public interface HttpCallbackListener {
        void onFinish(String response);

        void onError(Exception e);
    }
}
