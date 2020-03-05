package com.example.fleetdynamics;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class JobListFragment extends Fragment
{

    RecyclerView recyclerview = null;
    ArrayList<Job> jobs = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {



        View view = inflater.inflate(R.layout.fragment_joblist, container, false);
        super.onCreate(savedInstanceState);

        recyclerview = view.findViewById(R.id.JobListView);
        recyclerview.setHasFixedSize(true);
        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));

        InitJobList();

        return view;
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
                        job.setJobId(i);

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
