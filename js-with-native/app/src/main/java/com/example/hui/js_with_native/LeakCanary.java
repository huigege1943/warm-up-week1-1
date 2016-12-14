package com.example.hui.js_with_native;

import android.app.Application;

/**
 * Created by hui on 2016/12/14.
 */

public class LeakCanary extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (com.squareup.leakcanary.LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        com.squareup.leakcanary.LeakCanary.install(this);
        // Normal app init code...
    }
}