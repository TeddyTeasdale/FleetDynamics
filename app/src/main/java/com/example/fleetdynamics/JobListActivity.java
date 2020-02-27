package com.example.fleetdynamics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class JobListActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_list);
        InitJobList();
    }

    public void InitJobList()
    {
        // .child can be used to seperate the pathing out more logically
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("Job");

        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String address1 = dataSnapshot.child("1").child("Address").getValue(String.class);

                System.out.println(address1);
                System.out.println(myRef.getKey());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });




    }
}
