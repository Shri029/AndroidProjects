package com.example.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.recyclerview.MyListAdapter;
import com.example.recyclerview.MyListData;
import com.example.recyclerview.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        InputCreator inputCreator = InputCreator.get(this);
        List<MyListData> tile = inputCreator.getAll();


        /*MyListData[] myListData = new MyListData[] {
                new MyListData("Email", true, false, false, false),
                new MyListData("Info", false, false, false, false),
                new MyListData("Delete", false, false, false, false),
                new MyListData("Dialer", false, true, false, false),
                new MyListData("Alert", false, false, false, false),
                new MyListData("Map", false, false, false, false),
                new MyListData("Email", false, false, false, false),
                new MyListData("Info", false, false, true, false),
                new MyListData("Delete", false, false, false, false),
                new MyListData("Dialer", false, false, false, false),
                new MyListData("Alert", true, false, false, false),
                new MyListData("Map", false, false, false, false),
        };*/

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        MyListAdapter adapter = new MyListAdapter(tile);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}