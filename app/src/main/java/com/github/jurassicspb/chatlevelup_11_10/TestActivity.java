package com.github.jurassicspb.chatlevelup_11_10;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Мария on 15.10.2016.
 */

public class TestActivity extends AppCompatActivity{
    private Button buttonSI;
    private Button buttonSU;
    private EditText editEmail;
    private EditText editPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.authorisation_test);
        buttonSI = (Button) findViewById(R.id.buttonSI);
        buttonSU = (Button) findViewById(R.id.buttonSU);
        editEmail = (EditText) findViewById(R.id.email);
        editPassword = (EditText) findViewById(R.id.password);


        buttonSI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonSIClicked();
            }
        });
    }
            private void onButtonSIClicked(){
            if (editEmail.getText().length()==0 || editPassword.getText().length()==0) {
                ToastResult(R.string.login_failed);
            } else {
                ToastResult(R.string.login_success);
            }
    }
    private void ToastResult(int result){
        Toast toast = Toast.makeText(this,result, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }


}
