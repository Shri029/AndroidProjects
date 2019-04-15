package com.example.myapp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.MenuInflater;
import android.view.View;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class Admin1 extends AppCompatActivity {

    List<Tile> cardTile;
    RecyclerView recyclerView;


    private ActionMenuView actionMenuViewenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);


        WindowManager windowmanager = (WindowManager)this.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dimension = new DisplayMetrics();
        windowmanager.getDefaultDisplay().getMetrics(dimension);
        final int height = dimension.heightPixels;

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        cardTile = new ArrayList<>();


        cardTile.add(new Tile(1, "Greetings, I am Ayush Malik. " +
                "text is appearing small don't worry, will work on it.", "Hello"));
        cardTile.add(new Tile(1, "Hello I am Shivani", "Hello"));
        cardTile.add(new Tile(1, "Gmail", "Hello"));
        cardTile.add(new Tile(1, "Gmail", "Hello"));
        cardTile.add(new Tile(1, "Gmail", "Hello"));
        cardTile.add(new Tile(1, "Gmail", "Hello"));
        cardTile.add(new Tile(1, "Gmail", "Hello"));
        cardTile.add(new Tile(1, "Gmail", "Hello"));
        cardTile.add(new Tile(1, "Gmail", "Hello"));


        CardRecyclerViewAdapter adapter = new CardRecyclerViewAdapter(this, cardTile);

        recyclerView.setAdapter(adapter);

/*        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



}
