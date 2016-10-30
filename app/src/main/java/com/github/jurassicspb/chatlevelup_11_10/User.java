package com.github.jurassicspb.chatlevelup_11_10;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Мария on 22.10.2016.
 */

public class User extends RealmObject{
    @PrimaryKey
    private String id;
    private String name;
    private String description;
    private String firstLetter;
    private String image;

    public User() {
    }

    public User(String id, String name, String firstLetter) {
        this.id = id;
        this.name = name;
        this.firstLetter=firstLetter;
    }

//    public User(String name, String description, String firstLetter) {
//        this.name = name;
//        this.description=description;
//        this.firstLetter=firstLetter;
//    }

    public String getId() {
        return id;
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

    public String getImage() {
        return image;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFirstLetter(String firstLetter) {
        this.firstLetter = firstLetter;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
