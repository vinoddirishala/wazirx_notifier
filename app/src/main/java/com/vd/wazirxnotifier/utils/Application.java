package com.vd.wazirxnotifier.utils;

import com.androidnetworking.AndroidNetworking;

/**
 * Created by Vinod Dirishala on 10-11-2021 16:16
 **/
public class Application extends android.app.Application {


    @Override
    public void onCreate() {
        super.onCreate();
        AndroidNetworking.initialize(getApplicationContext());
    }
}
