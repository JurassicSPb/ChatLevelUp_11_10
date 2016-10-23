package com.github.jurassicspb.chatlevelup_11_10;

/**
 * Created by Мария on 22.10.2016.
 */

public class User {
    private String name;
    private String description;
    private String firstLetter;

    public User(String name, String description, String firstLetter) {
        this.name = name;
        this.description=description;
        this.firstLetter=firstLetter;
    }
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getFirstLetter() {
        return firstLetter;
    }
}
