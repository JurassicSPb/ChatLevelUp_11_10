package com.github.jurassicspb.chatlevelup_11_10;

/**
 * Created by Мария on 22.10.2016.
 */

public class User {
    private String name;
    private String description;

    public User(String name, String description) {
        this.name = name;
        this.description=description;
    }
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
