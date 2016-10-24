package com.github.jurassicspb.chatlevelup_11_10;

/**
 * Created by Мария on 23.10.2016.
 */

public class Chat implements Comparable<Chat>{
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

    public Chat(String title, String lastMessage, String firstLetter) {
        this.title = title;
        this.lastMessage = lastMessage;
        this.updated = DateUtil.now();
        this.firstLetter=firstLetter;
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
    @Override
    public int compareTo(Chat object) {
        if ((Long) this.getUpdated() < (Long) object.getUpdated())
            return -1;
        if (this.getUpdated() == object.getUpdated())
            return 0;

        return 1;
    }
}