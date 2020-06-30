package com.example.simpleapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {


    private Button buttonRegister;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewSignin;

    private ProgressBar progressBar;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        buttonRegister = (Button) findViewById(R.id.buttonLogin);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPass);

        textViewSignin =(TextView) findViewById(R.id.textSignin);

        progressBar = new ProgressBar(this);
        firebaseAuth = FirebaseAuth.getInstance();

        if ((firebaseAuth.getCurrentUser() != null)) {
            finish();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editTextEmail.getText().toString().trim();
                String pass = editTextPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    //empty email
                    Toast.makeText(Register.this, "Please enter Email", Toast.LENGTH_SHORT).show();
                    editTextEmail.setError("Please enter Email");
                    return;
                }

                if (TextUtils.isEmpty(pass)) {
                    //empty password
                    Toast.makeText(Register.this, "Please enter password", Toast.LENGTH_SHORT).show();
                    editTextPassword.setError("Please enter password");
                    return;
                }

                progressBar.getProgress();
                firebaseAuth.createUserWithEmailAndPassword(email, pass) .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //user registered
                            startActivity(new Intent(getApplicationContext(), Home.class));
                            Toast.makeText(Register.this, "Registered Successfully!!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(Register.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.clearAnimation();
                        }


                    }
                });

            }
        });

        textViewSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }

    }