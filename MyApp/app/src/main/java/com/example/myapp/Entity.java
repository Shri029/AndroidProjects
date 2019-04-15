package com.example.myapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import com.example.myapp.Adapter.MyAdapter;

import java.lang.Object;


public class Entity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private Context v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entity);


        radioGroup = findViewById(R.id.radio_group);
        radioGroup.clearCheck();
        RadioButton rb = radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = group.findViewById(checkedId);
                if (null != rb ) {
                  Toast.makeText(Entity.this, rb.getText(), Toast.LENGTH_SHORT).show();

                }

            }
        });



        Button Submit = findViewById(R.id.submit);

         Submit.setOnClickListener(new View.OnClickListener() {

             boolean visible;

            public void onClick(View view) {


                final int selectedId=radioGroup.getCheckedRadioButtonId();
               // Toast.makeText(Entity.this,String.valueOf(selectedId),Toast.LENGTH_LONG).show();

                switch (selectedId) {

                    case R.id.admin: //** Start a new Activity MyCards.java *//*
                       Intent intent= new Intent( Entity.this, RecycleViewTestActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.faculty:
                        break;

                }

/*
                final ViewGroup transitionsContainer = (ViewGroup)view.findViewById(R.id.transitions_container);
                final TextView text = (TextView) transitionsContainer.findViewById(R.id.text);
                TransitionManager.beginDelayedTransition(transitionsContainer);
                visible = !visible;
                text.setVisibility(visible ? View.VISIBLE : View.GONE);*/
            }
        });
    }

    public void onClear(View v) {
        /* Clears all selected radio buttons to default */
        radioGroup.clearCheck();
    }

    public void onSubmit(final View v) {
        final RadioButton rb = radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
        Toast.makeText(Entity.this, rb.getText(), Toast.LENGTH_SHORT).show();

    }
}

