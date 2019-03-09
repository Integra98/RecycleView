package com.example.mytweet;

public class Tweet {

    private String userName;
    private String data;
    private String company;
    private int img;
    private int ava;
    private boolean like;


    public Tweet(String userName, String data, String company, int img, int ava, boolean like) {
        this.userName = userName;
        this.data = data;
        this.company = company;
        this.img = img;
        this.ava = ava;
        this.like = like;
    }

    public String getName() {
        return userName;
    }

    public void setName(String userName) {
        this.userName = userName;
    }

    public String getData() {
        return data;
    }

    public void setData(String surname) {
        this.data = data;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String phone) {
        this.company = company;
    }

    public int getImage() {
        return img;
    }

    public void setImage(int img) {
        this.img = img;
    }

    public int getAva() {
        return ava;
    }

    public void setAva(int img) {
        this.ava = ava;
    }

    public boolean getLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }
}
