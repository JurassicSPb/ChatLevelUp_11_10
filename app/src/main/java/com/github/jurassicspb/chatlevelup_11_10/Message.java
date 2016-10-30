package com.github.jurassicspb.chatlevelup_11_10;

/**
 * Created by Мария on 23.10.2016.
 */

public class Message {
    private String id;
    //
    private String sender;
    private String chatId;
    //
    private long created;
    //
    private String body;

    public Message(String body) {
        this.body = body;
        created = DateUtil.now();
    }

    public String getSender() {

        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public long getCreated() {
        return created;
    }

    public String getBody() {
        return body;
    }
}