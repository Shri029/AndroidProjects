package com.example.authentication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseApp.initializeApp(MainActivity.this);

        mAuth = FirebaseAuth.getInstance();
        FirebaseApp.initializeApp(this);

        Intent intent = new Intent(this, Auth.class);
        startActivity(intent);
        finish();
    }

    /* Delete  above three lines and uncomment below on start method to avoid multiple signin process. */




/*
    public void onStart(){
        super.onStart();

        FirebaseUser currentUser= mAuth.getCurrentUser();

        if(currentUser == null) {

            Intent intent = new Intent(this, Auth.class);
            startActivity(intent);
            finish();
        }
        else
        {
            Intent intent = new Intent(this, AfterLogin.class);
            startActivity(intent);

        }

    }*/
}
