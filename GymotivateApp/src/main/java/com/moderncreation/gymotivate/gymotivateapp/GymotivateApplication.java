package com.moderncreation.gymotivate.gymotivateapp;

import android.app.Application;
import android.content.Context;

/**
 * Created by xsun on 3/11/14.
 */
public class GymotivateApplication extends Application {

    private static GymotivateApplication sInstance;

    public static GymotivateApplication getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }

    public static Context getAppContext() {
        return sInstance.getApplicationContext();
    }
}

