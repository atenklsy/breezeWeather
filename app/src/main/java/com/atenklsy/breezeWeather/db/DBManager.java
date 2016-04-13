package com.atenklsy.breezeWeather.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import com.atenklsy.breezeWeather.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;

/**
 * Created by atenklsy on 2016/5/18 11:27.
 * E-address:atenk@qq.com.
 */
public class DBManager {
    private static String DBName = "allcities.db";
    private static String PACKAGE_NAME = "com.atenklsy.breezeWeather";
    public static final String DB_PATH = "/data" + Environment.getDataDirectory().getAbsolutePath() + "/" +
            PACKAGE_NAME;  //在手机里存放数据库(/data/data/com.atenklsy.breezeWeather/allcities.db)
    private final int BUFFER_SIZE = 40000;
    private Context mContext;
    private SQLiteDatabase database;

    public DBManager(Context context) {
        mContext = context;
    }

    public void closeDatabase() {
        database.close();
    }

    public SQLiteDatabase getDatabase() {
        return database;
    }

    public void openDatabase() {
        database = openDatabase(DB_PATH + "/" + DBName);
    }

    public SQLiteDatabase openDatabase(String DBfile) {
        try {
            if (!(new File(DBfile).exists())) {
                InputStream in = mContext.getResources().openRawResource(R.raw.allcities);
                FileOutputStream fos = new FileOutputStream(DBfile);
                byte[] buffer = new byte[BUFFER_SIZE];
                int count = 0;
                while ((count = in.read(buffer)) > 0) {
                    fos.write(buffer, 0, count);
                }
                fos.close();
                in.close();
            }

            SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(DBfile, null);
            return db;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
