package com.github.jurassicspb.chatlevelup_11_10;

import android.app.Application;

import io.realm.Realm;

/**
 * Created by Мария on 29.10.2016.
 */

public class App extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}
