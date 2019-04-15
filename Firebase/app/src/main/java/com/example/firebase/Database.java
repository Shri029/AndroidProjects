package com.example.firebase;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Database extends AppCompatActivity {

    DatabaseReference databaseStudents;
    EditText text_name, text_phone, text_email, text_dob;
    Button submit, stud;
    ListView listStudents;
    List<Student> students = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        databaseStudents = FirebaseDatabase.getInstance().getReference("Student");

        text_name = findViewById(R.id.name);
        text_phone = findViewById(R.id.phone);
        text_email = findViewById(R.id.email);
        text_dob = findViewById(R.id.dob);
        listStudents = findViewById(R.id.listStudents);

        submit = findViewById(R.id.submit);
        stud = findViewById(R.id.stu_list);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addStudent();
            }
        });

        stud.setOnClickListener( new View.OnClickListener(){

            public void onClick(View view) {

              Intent intent = new Intent( Database.this, Retrieve.class);
              startActivity(intent);

            }

        });


    }
    

    private void addStudent() {

        String Name = text_name.getText().toString().trim();
        String Phone = text_phone.getText().toString().trim();
        String Email = text_email.getText().toString().trim();
        String DOB = text_dob.getText().toString().trim();

        if (!TextUtils.isEmpty(Name)) {

            String id = databaseStudents.push().getKey();

            Student student = new Student(id, Name, Phone, Email, DOB);

            databaseStudents.child(id).setValue(student);

            text_name.setText("");
            text_phone.setText("");
            text_email.setText("");
            text_dob.setText("");

            Toast.makeText(this, "Student added", Toast.LENGTH_LONG).show();
        }
        else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please enter Valid details!!!!", Toast.LENGTH_LONG).show();
        }
    }
}
