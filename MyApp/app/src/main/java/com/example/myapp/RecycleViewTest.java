package com.example.myapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;
import com.example.myapp.Adapter.MyAdapter;
import com.example.myapp.Models.Child;
import com.example.myapp.Models.Parent;
import com.example.myapp.Models.TitleCreator;

import java.lang.Object;
import java.util.ArrayList;
import java.util.List;

public class RecycleViewTest extends AppCompatActivity {

    RecyclerView recyclerView;

    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        ((MyAdapter) recyclerView.getAdapter()).onSaveInstanceState(outState);

    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin1);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);



        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MyAdapter adapter = new MyAdapter(this, initData());
        adapter.setParentClickableViewAnimationDefaultDuration();
        adapter.setParentAndIconExpandOnClick(true);
        recyclerView.setAdapter(adapter);
    }

    private List<ParentObject> initData(){

        TitleCreator titleCreator = TitleCreator.get(this);
        List<Parent> titles = titleCreator.getAll();

        List<ParentObject> parentObject = new ArrayList<>();

        for(Parent title: titles){

            List<Object> childList = new ArrayList<>();
            childList.add(new Child("Hello Hey Tin Tin", "Shivi Shivi Shivi Shivi"));
            title.setChildObjectList(childList);
            parentObject.add(title);
        }
        return parentObject;
    }
}

