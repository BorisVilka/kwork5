package com.example.c;

import android.app.Application;
import android.util.Log;

import com.yandex.mobile.ads.common.InitializationListener;
import com.yandex.mobile.ads.common.MobileAds;

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        MobileAds.initialize(this, () -> Log.d("TAG", "SDK initialized"));
    }
}
