package com.example.androidwearsincronizaciodatos;

import android.app.Application;
import android.widget.TextView;

/**
 * Created by Indogroup02 on 24/10/2017.
 */

public class MyApplication extends Application {

    private static MyApplication instance;
    private static String stringFromWear;


    public static MyApplication getInstance(){return instance;}

    public static void setStringFromWear(String stringFromWear) {
        MyApplication.stringFromWear = stringFromWear;
    }

    public static String getStringFromWear(){
        return stringFromWear;
    }

    @Override
    public void onCreate(){
        super.onCreate();

        instance = this;
    }






}
