package com.github.jurassicspb.chatlevelup_11_10;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Мария on 20.10.2016.
 */

public class ProfileActivity2 extends AppCompatActivity{
    private ImageView view;
    private Button logout;
    private EditText info1;
    private EditText info2;
    private EditText info3;
    private TextView name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);
        view = (ImageView) findViewById(R.id.profile_photo);
        view.setImageResource(R.drawable.photo_small);
        logout = (Button) findViewById(R.id.logout);
        info1 = (EditText) findViewById(R.id.info1);
        info2 = (EditText) findViewById(R.id.info2);
        info3 = (EditText) findViewById(R.id.info3);
        name = (TextView) findViewById(R.id.name);

        Intent i = getIntent();
//        String arg  = i.getStringExtra("key_extra");
//        Log.d(RegisterActivity.class.getSimpleName(), arg);


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonLogoutClicked();
            }
        });

    }
    private void onButtonLogoutClicked() {
        finish();
    }

}
