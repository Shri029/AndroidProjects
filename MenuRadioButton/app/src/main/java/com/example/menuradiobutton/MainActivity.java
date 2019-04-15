package com.example.menuradiobutton;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private Context v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radio_group);
        radioGroup.clearCheck();
        RadioButton rb = radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = group.findViewById(checkedId);
                if (null != rb ) {
                    Toast.makeText(MainActivity.this, rb.getText(), Toast.LENGTH_SHORT).show();

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

                    case R.id.admin: //** Start a new Activity Admin.java *//*
                        Intent intent= new Intent( MainActivity.this, Admin.class);
                        startActivity(intent);
                        break;

                    case R.id.faculty:
                        //** Start a new Faculty Activity Using Intent *//*
                        break;

                    case R.id.student:
                        //** Start a new Student-> Student.java Activity Using Intent *//*
                        break;

                }

            }
        });
    }

    public void onClear(View v) {
        /* Clears all selected radio buttons to default */
        radioGroup.clearCheck();
    }

    public void onSubmit(final View v) {
        final RadioButton rb = radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
        Toast.makeText(MainActivity.this, rb.getText(), Toast.LENGTH_SHORT).show();

    }

}

