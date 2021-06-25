package com.example.breakingbad.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ActeurBrB {


    @SerializedName("char_id")
    private int id;
    private String name;
    private String birthday;
    private String img;
    private String nickname;

    public ActeurBrB(int id, String name, String birthday,  String img, String nickname) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.img = img;
        this.nickname = nickname;
    }

    public ActeurBrB(){
       super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
