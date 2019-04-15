package com.example.myapp;

public class Tile {


    private int id;
    private String title;
    private String subTitle;

    public Tile(int id, String title, String subTitle){

        this.id=id;
        this.title=title;
        this.subTitle=subTitle;

    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }
}
