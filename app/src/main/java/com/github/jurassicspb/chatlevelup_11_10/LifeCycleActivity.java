package com.github.jurassicspb.chatlevelup_11_10;

/**
 * Created by Мария on 22.10.2016.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class LifeCycleActivity extends AppCompatActivity {
    public static final String EXTRA_TEST = LifeCycleActivity.class.getName() + "extra_test";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_relative);
        Log.d(LifeCycleActivity.class.getSimpleName(), "onCreate");

        Intent i = getIntent();
        String arg = i.getStringExtra(EXTRA_TEST);
        Log.d(LifeCycleActivity.class.getSimpleName(), arg);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LifeCycleActivity.class.getSimpleName(), "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LifeCycleActivity.class.getSimpleName(), "onResume");
    }

    @Override
    protected void onPause() {
        Log.d(LifeCycleActivity.class.getSimpleName(), "onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(LifeCycleActivity.class.getSimpleName(), "onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(LifeCycleActivity.class.getSimpleName(), "onDestroy");
        super.onDestroy();
    }
}
