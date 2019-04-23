package com.example.spinner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NamesMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_names_menu);


            TextView textView=(TextView) findViewById(R.id.txt_bundle);
            Bundle bundle=getIntent().getExtras();
            String data=bundle.get("data").toString();
            textView.setText(data);
        }
}
