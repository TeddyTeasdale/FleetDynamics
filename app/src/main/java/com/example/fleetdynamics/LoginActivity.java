package com.example.fleetdynamics;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity
{
    EditText myEmail, myPassword;
    Button myLoginBtn;
    TextView myCreateBtn;
    ProgressBar progressBar;
    FirebaseAuth fAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        myEmail = findViewById(R.id.Email);
        myPassword = findViewById(R.id.password);
        progressBar = findViewById(R.id.progressBar);
        fAuth = FirebaseAuth.getInstance();
        myLoginBtn = findViewById(R.id.loginBtn);
        myCreateBtn = findViewById(R.id.createText);

        myLoginBtn.setOnClickListener(new View.OnClickListener()
                                    {
                                        @Override
                                        public void onClick(View v)
                                        {
                                            String email =  myEmail.getText().toString().trim();
                                            String password = myPassword.getText().toString().trim();

                                            if(TextUtils.isEmpty(email))
                                            {
                                                myEmail.setError("Email is Required.");
                                                return;
                                            }

                                            if(TextUtils.isEmpty(password))
                                            {
                                                myPassword.setError("Password is Required.");
                                                return;
                                            }

                                            if(password.length() <6)
                                            {
                                                myPassword.setError("Password should be at least 6 character.");
                                                return;
                                            }


                                            //authenticate the user
                                            //Registering the user in firebase
                                            fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                                @Override
                                                public void onComplete(@NonNull Task<AuthResult> task)
                                                {
                                                    if(task.isSuccessful())
                                                    {
                                                        Toast.makeText(LoginActivity.this, "Logged in Sucessfully", Toast.LENGTH_SHORT).show();
                                                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                                    }
                                                    else
                                                    {
                                                        Toast.makeText(LoginActivity.this, "Error !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                                    }

                                                }
                                            });


                                        }
                                     });
        myCreateBtn.setOnClickListener(new View.OnClickListener()
        {

            public void onClick(View v)
            {
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
            }
        });
    }
}
