package com.example.authentication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class Auth extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private ProgressDialog progress;

    EditText phone;
    EditText OTP;
    String codeSent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(Auth.this);
        setContentView(R.layout.activity_auth);

        mAuth = FirebaseAuth.getInstance();

        phone = findViewById(R.id.phone);
        OTP= findViewById(R.id.OTP);
        Button verificationCode = findViewById(R.id.verification_code);
        Button signIn = findViewById(R.id.sign_in);



        verificationCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              sendVerificationCode();
            }
        });

       signIn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String code= OTP.getText().toString();

                //Manual verification

                if(code.isEmpty()){

                    OTP.setError("Phone Number is required!");
                    OTP.requestFocus();
                    return;
                }

                verifySignInCode(code);
            }
        });


    }

    private void sendVerificationCode(){

    /*    progress=new ProgressDialog(this);
        progress.setIndeterminate(true);
        progress.setMessage("Sending OTP");
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.show();
*/

        String phoneNumber = phone.getText().toString();

        if(phoneNumber.isEmpty()){

            phone.setError("Phone Number is required!");
            phone.requestFocus();
            return;
        }

        if(phoneNumber.length()<10){

            phone.setError("Please enter a valid Phone!");
            phone.requestFocus();
            return;
        }

        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                "+91" + phoneNumber,        // Phone number to verify
                60,                 // Timeout duration
                TimeUnit.SECONDS,   // Unit of timeout
                this,               // Activity (for callback binding)
                mCallbacks);        // OnVerificationStateChangedCallbacks
    }


        PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks= new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

                String code = phoneAuthCredential.getSmsCode();

                //sometime the code is not detected automatically
                //in this case the code will be null
                //so user has to manually enter the code
                if (code != null) {
                    OTP.setText(code);

                    verifySignInCode(code);
                }


            }

            @Override
            public void onVerificationFailed(FirebaseException e) {

                Toast.makeText(Auth.this, e.getMessage(), Toast.LENGTH_LONG).show();

            }

            @Override
            public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);
                codeSent = s;
            }

        };

    private void verifySignInCode(String code){




        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(codeSent, code);
        signInWithPhoneAuthCredential(credential);
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            Toast.makeText(Auth.this, "Login Successful", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(Auth.this, AfterLogin.class);
                            startActivity(intent);
                        }
                        else {

                            if(task.getException() instanceof FirebaseAuthInvalidCredentialsException){
                                Toast.makeText(Auth.this, "Invalid Credentials", Toast.LENGTH_LONG).show();
                            }

                        }
                    }
                });
    }
}
