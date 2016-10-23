package com.github.jurassicspb.chatlevelup_11_10;

/**
 * Created by Мария on 23.10.2016.
 */

public class Chat{
    private String id;
    //
    private String title;
    private String author;
    private String[] participants;
    //
    private String lastMessage;
    private long created;
    //
    private long updated;
    private String firstLetter;

    public Chat(String title, String lastMessage) {
        this.title = title;
        this.lastMessage = lastMessage;
        this.updated = DateUtil.now();
    }

    public String getTitle() {
        return title;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public long getUpdated() {
        return updated;
    }

    public String getFirstLetter() {
        return firstLetter;
    }
}