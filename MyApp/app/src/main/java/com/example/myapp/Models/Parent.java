package com.example.myapp.Models;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import java.util.List;
import java.util.UUID;

public class Parent implements ParentObject{


    private List<Object> mchildrenList;
    private UUID _id;
    private String title;

    public Parent(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        _id= UUID.randomUUID();
    }

    public UUID getUuid() {
        return _id;
    }

    public void setUuid(UUID _id) {
        this._id = _id;
    }

    @Override
    public List<Object> getChildObjectList() {
        return mchildrenList;
    }

    @Override
    public void setChildObjectList(List<Object> list) {
        mchildrenList=list;
    }

}
