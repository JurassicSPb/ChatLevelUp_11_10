package com.github.jurassicspb.chatlevelup_11_10;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

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
            doSignUp();

//            Intent intent = new Intent(this, ProfileActivity2.class);
//            intent.putExtra("key_extra", "value");
//            startActivity(intent);
        }

    }
    private void doSignUp(){
        String hello = "Hello";
        new Thread(() -> {
            OkHttpClient client = new OkHttpClient();
            RequestBody body = RequestBody
                    .create(MediaType.parse("application/json; charset=utf-8"), hello);
            Request request = new Request.Builder()
                    .url("http://192.168.3.205:8080/levelupchat/register")
                    .post(body)
                    .build();
            try {
                Response response = client.newCall(request).execute();
                Log.d(RegisterActivity.class.getSimpleName(), response.body().string());
            } catch (IOException e) {
                Log.e(RegisterActivity.class.getSimpleName(), Log.getStackTraceString(e));
            }
//            try {
//                URL url = new URL("http://91.122.56.48:8080/levelupchat/register");
//                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//                connection.setRequestMethod("POST");
//                connection.setDoInput(true);
//                connection.setDoInput(true);
//                connection.setRequestProperty("Content-length", String.valueOf(hello.getBytes().length));
//
//                OutputStream os = connection.getOutputStream();
//                os.write(hello.getBytes("UTF-8"));
//                connection.connect();
//
//                int responseCode = connection.getResponseCode();
//
//                InputStream is = connection.getInputStream();
//                ByteArrayOutputStream byteArrayStream = new ByteArrayOutputStream();
//                byte[] buffer = new byte[4096];
//                int length;
//                while ((length = is.read(buffer)) != -1){
//                    byteArrayStream.write(buffer, 0, length);
//                }
//                String response = byteArrayStream.toString();
//                Log.d(RegisterActivity.class.getSimpleName(), "RESPONSE code: "+ responseCode + "body: " + response);
//                is.close();
//            } catch (IOException e) {
//                Log.e(RegisterActivity.class.getSimpleName(), Log.getStackTraceString(e));
//            }
        }).start();
    }
    private void ToastResult(int result) {
        Toast toast = Toast.makeText(this, result, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }


}
