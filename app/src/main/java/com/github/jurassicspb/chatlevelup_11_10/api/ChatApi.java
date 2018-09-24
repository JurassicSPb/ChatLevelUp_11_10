package com.github.jurassicspb.chatlevelup_11_10.api;

import com.github.jurassicspb.chatlevelup_11_10.Chat;

import okhttp3.OkHttpClient;

/**
 * Created by Мария on 19.11.2016.
 */

public class ChatApi {
    private static final ChatApi instance = new ChatApi();
    private OkHttpClient client;

    private ChatApi(){
        client=new OkHttpClient();
    }
    public static ChatApi getInstance(){
        return instance;
    }

}
