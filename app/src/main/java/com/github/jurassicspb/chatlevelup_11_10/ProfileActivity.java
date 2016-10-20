package com.github.jurassicspb.chatlevelup_11_10;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Мария on 20.10.2016.
 */

public class ProfileActivity extends AppCompatActivity{
    private ImageView view;
    private Button logout;
    private TextView colorTop;
    private EditText colorRight;
    private TextView colorBottom;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);
        view = (ImageView) findViewById(R.id.profile_photo);
        view.setImageResource(R.drawable.blank_profile);
        logout = (Button) findViewById(R.id.logout);
        colorTop = (TextView) findViewById(R.id.color_top);
        colorRight = (EditText) findViewById(R.id.color_right);
        colorBottom = (TextView) findViewById(R.id.color_bottom);

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
