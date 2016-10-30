package com.github.jurassicspb.chatlevelup_11_10;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Мария on 15.10.2016.
 */

public class RegisterActivity extends AppCompatActivity {
    private Button buttonSI;
    private Button buttonSU;
    private EditText editEmail;
    private EditText editPassword;
    private EditText repeatPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_test);
        buttonSI = (Button) findViewById(R.id.buttonSI);
        buttonSU = (Button) findViewById(R.id.buttonSU);
        editEmail = (EditText) findViewById(R.id.email);
        editPassword = (EditText) findViewById(R.id.password);
        repeatPassword = (EditText) findViewById(R.id.repeat_password);


        buttonSU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonSUClicked();
            }
        });
    }

    private void onButtonSUClicked() {
        if (editEmail.getText().length() == 0 || editPassword.getText().length() == 0 || repeatPassword.getText().length() == 0) {
            ToastResult(R.string.register_failed1);
        } else if (!(editPassword.getText().toString().equals(repeatPassword.getText().toString()))) {
            ToastResult(R.string.register_failed3);

        } else if (editPassword.getText().length() < 8 || repeatPassword.getText().length() < 8) {
            ToastResult(R.string.register_failed2);
        } else {
            ToastResult(R.string.register_success);
            Intent intent = new Intent(this, ProfileActivity2.class);
            intent.putExtra("key_extra", "value");
            startActivity(intent);
        }

    }

    private void ToastResult(int result) {
        Toast toast = Toast.makeText(this, result, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }


}
