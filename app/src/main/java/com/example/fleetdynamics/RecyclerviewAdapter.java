package com.example.fleetdynamics;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

// Author Teddy Teasdale

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.MyViewHolder>
{
    private ArrayList<Job> jobList;


    public static class MyViewHolder extends RecyclerView.ViewHolder{
        // each data item is just a string in this case
        public TextView customerTextView, addressTextView, vehicleTextView, jobTypeTextView;

        public MyViewHolder(View v) {
            super(v);
            customerTextView =  v.findViewById(R.id.CustomerNameTextView);
            addressTextView = v.findViewById(R.id.AddressTextView);
            vehicleTextView = v.findViewById(R.id.VehicleTextView);
            jobTypeTextView = v.findViewById(R.id.JobTypeTextView);
        }
    }

    public RecyclerviewAdapter(ArrayList<Job> jobList)
    {
        this.jobList = jobList;
    }

    @Override
    public RecyclerviewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                               int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_layout, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    public int getItemCount() {
        return jobList.size();
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        Job job = jobList.get(position);
        holder.customerTextView.setText(job.getCustomerName());
        holder.addressTextView.setText(job.getJobLocation());
        holder.jobTypeTextView.setText(job.getType());
        holder.vehicleTextView.setText(job.getVehicle().getModel());



    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
