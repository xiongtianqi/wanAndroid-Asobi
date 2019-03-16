package me.tq.asobiandroid.app;

import android.app.Application;

public class AsobiApplication extends Application {

    private static AsobiApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static AsobiApplication getApp() {
        return instance;
    }
}
