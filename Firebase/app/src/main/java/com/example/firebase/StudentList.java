package com.example.firebase;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class StudentList extends ArrayAdapter<Student> {

       private Activity context;
       TextView text_name, text_phone, text_email, text_dob;
       List<Student> students;


    public StudentList(@NonNull Activity context, List<Student> students) {
        super(context, R.layout.list_student, students);
        this.context = context;
        this.students = students;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_student, null, true);


        text_name = listViewItem.findViewById(R.id.nameS);
        text_phone = listViewItem.findViewById(R.id.phoneS);
        text_email = listViewItem.findViewById(R.id.emailS);
        text_dob = listViewItem.findViewById(R.id.dobS);


        Student student = students.get(position);
        text_name.setText(student.getName());
        text_phone.setText(student.getPhone());
        text_email.setText(student.getEmail());
        text_dob.setText(student.getDob());


        return listViewItem;
    }
}
