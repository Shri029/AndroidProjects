
package com.example.fireapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class Save extends AppCompatActivity {

    DatabaseReference databaseStudents;
    EditText text_name, text_phone, text_email, text_dob;
    Button submit, stu_list, btnGetData;
/*    ListView listStudents;
    List<Student> students;

    public Save() {
        students = new ArrayList<>();
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);

        databaseStudents = FirebaseDatabase.getInstance().getReference("Student");

        text_name = (EditText) findViewById(R.id.name);
        text_phone = (EditText) findViewById(R.id.phone);
        text_email = (EditText) findViewById(R.id.email);
        text_dob = (EditText) findViewById(R.id.dob);

        submit = (Button) findViewById(R.id.submit);
     //   stu_list = (Button) findViewById(R.id.stu_list);

        btnGetData= findViewById(R.id.btnGetData);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addStudent();
            }
        });

        btnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent( Save.this, AccessDataActivity.class);
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
            } else {
                //if the value is not given displaying a toast
                Toast.makeText(this, "Please enter Valid details!!!!", Toast.LENGTH_LONG).show();
            }
        }
}
