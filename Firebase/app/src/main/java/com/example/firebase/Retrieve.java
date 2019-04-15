package com.example.firebase;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Retrieve extends AppCompatActivity {

    DatabaseReference databaseStudents;
    List<Student> students = new ArrayList<>();
    ListView listStudents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve);

        databaseStudents = FirebaseDatabase.getInstance().getReference("Student");
    }


    protected void onStart(){

        super.onStart();

        databaseStudents.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                students.clear();


                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting artist
                    Student student = postSnapshot.getValue(Student.class);
                    //adding artist to the list
                    students.add(student);
                }

                listStudents = findViewById(R.id.listStudents);
                //creating adapter
                if(!students.isEmpty()) {
                    StudentList studentAdapter = new StudentList(Retrieve.this, students);
                    //attaching adapter to the listview
                    listStudents.setAdapter(studentAdapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
