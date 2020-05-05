
package com.example.fleetdynamics;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class RegisterActivity extends AppCompatActivity {

    public static final String TAG = "TAG";
    EditText myFullname, myEmail, myPassword;
    Button myRegisterBtn;
    TextView myLoginBtn;
    FirebaseAuth fAuth;
    ProgressBar myProgressBar;
    //Creating instance of firestore
    FirebaseFirestore fireStore;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        myFullname = findViewById(R.id.fullName);
        myEmail = findViewById(R.id.Email);
        myPassword = findViewById(R.id.password);
        myRegisterBtn = findViewById(R.id.registerBtn);
        myLoginBtn = findViewById(R.id.createText1);
        fAuth = FirebaseAuth.getInstance();
        fireStore= FirebaseFirestore.getInstance();
        myProgressBar = findViewById(R.id.progressBar);



        if(fAuth.getCurrentUser() != null)
        {
            //startActivity(new Intent (getApplicationContext(),MainActivity.class));
            //finish();
        }

        myRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = myEmail.getText().toString().trim();
                String password = myPassword.getText().toString().trim();
                final String fName =  myFullname.getText().toString();


                if (TextUtils.isEmpty(email)) {
                    myEmail.setError("Email is Required.");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    myPassword.setError("Password is Required.");
                    return;
                }

                if (password.length() < 6) {
                    myPassword.setError("Password should be at least 6 character.");
                    return;
                }

                myProgressBar.setVisibility(View.GONE);

                //Registering the user in firebase
                fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(RegisterActivity.this, "User Created", Toast.LENGTH_SHORT).show();
                            userID = fAuth.getCurrentUser().getUid();
                            DocumentReference documentReference = fireStore.collection("FleetDynamics Users").document(userID);
                            Map<String, Object> userData = new HashMap<>();
                            userData.put("fullName", fName);
                            userData.put("userEmail", email);
                            documentReference.set(userData).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d(TAG, "onSuccess: user profile is created for "+ userID);
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d(TAG, "onFailure: " + e.toString());
                                }
                            });

                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            myProgressBar.setVisibility(View.VISIBLE);
                        } else {
                            Toast.makeText(RegisterActivity.this, "Error !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            myProgressBar.setVisibility(View.GONE);
                        }

                    }
                });
            }
        });

        myLoginBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        });
    }
}