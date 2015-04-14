package com.example.christain.myapplication;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by Christain on 15/4/15.
 */
public class MyApplication extends Application {

    private static class SingletonHolder {
        private static final MyApplication INSTANCE = new MyApplication();
    }

    public static final MyApplication getInstance() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(getApplicationContext());
    }

}
