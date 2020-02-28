package com.example.fleetdynamics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class JobListActivity extends AppCompatActivity
{

    RecyclerView recyclerview = null;
    ArrayList<Job> jobs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_list);
        recyclerview = findViewById(R.id.JobListView);
        recyclerview.setHasFixedSize(true);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));

        InitJobList();
    }

    public void InitJobList()
    {
        // .child can be used to seperate the pathing out more logically
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("Job");

            myRef.addListenerForSingleValueEvent(new ValueEventListener()
            {

                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    boolean empty = false;
                    int i = 1;
                    while(!empty)
                    {
                        Job job = new Job ();

                        if(dataSnapshot.child(String.valueOf(i)).exists())
                        {
                            job.setJobLocation(dataSnapshot.child(String.valueOf(i)).child("Address").getValue(String.class));
                            job.setCustomerName(dataSnapshot.child(String.valueOf(i)).child("Customer").getValue(String.class));
                            job.setType(dataSnapshot.child(String.valueOf(i)).child("JobType").getValue(String.class));
                            job.setVehicle(dataSnapshot.child(String.valueOf(i)).child("Vehicle").getValue(String.class));

                            System.out.println(job.getCustomerName());
                            System.out.println(job.getJobLocation());
                            System.out.println(job.getType());
                            System.out.println(job.getVehicle());

                        }
                        else
                            {

                            empty = true;

                        }

                        jobs.add(job);
                        i++;
                    }

                    RecyclerviewAdapter adapter = new RecyclerviewAdapter(jobs);
                    recyclerview.setAdapter(adapter);
                }

                @Override
                public void onCancelled(DatabaseError databaseError)
                {
                    System.out.println("database error");
                }

            });







    }
}
