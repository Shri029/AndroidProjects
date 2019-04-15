package com.example.firebaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.List;

public class Save extends AppCompatActivity {

    DatabaseReference databaseStudents;
    EditText text_name, text_phone, text_email, text_dob;
    Button submit, stud;
    ListView listStudents;
    List<Student> students = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);
    }


}
