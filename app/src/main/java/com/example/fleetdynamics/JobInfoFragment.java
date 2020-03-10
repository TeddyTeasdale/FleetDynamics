package com.example.fleetdynamics;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageException;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class JobInfoFragment extends Fragment
{
    private DatabaseReference databaseReference;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        final View view = inflater.inflate(R.layout.fragment_jobinfo, container, false);
        Job job = new Job();
        job.setCustomerName(getArguments().getString("Customer"));
        job.getVehicle().setModel(getArguments().getString("vehicleMake"));
        job.getVehicle().setReg(getArguments().getString("vehicleReg"));
        job.setJobLocation(getArguments().getString("Address"));
        job.setType(getArguments().getString("JobType"));

        TextView vehicle = view.findViewById(R.id.jobinfoVehicle);
        TextView customer = view.findViewById(R.id.jobinfoCustomer);
        TextView address = view.findViewById(R.id.jobinfoAddress);
        TextView type = view.findViewById(R.id.jobinfoType);



        vehicle.setText(job.getVehicle().getModel());
        customer.setText(job.getCustomerName());
        address.setText(job.getJobLocation());
        type.setText(job.getType());

        FirebaseStorage storage = FirebaseStorage.getInstance();

        final ArrayList<ImageView> vehicleimages= new ArrayList<>();
        ImageView imageView1 = view.findViewById(R.id.vehicleImage1);
        ImageView imageView2 = view.findViewById(R.id.vehicleImage2);
        ImageView imageView3 = view.findViewById(R.id.vehicleImage3);
        ImageView imageView4 = view.findViewById(R.id.vehicleImage4);

        vehicleimages.add(imageView1);
        vehicleimages.add(imageView2);
        vehicleimages.add(imageView3);
        vehicleimages.add(imageView4);

        /**
            StorageReference ref = storage.getReference("/VehicleImages/"+ job.getVehicle().getReg());
            System.out.println(ref.toString());
            //gs://fleet-dynamics.appspot.com/VehicleImages/DI58GHY/0.jpg

        for(int i = 0; i<4 ; i++)
        {
            Glide.with(view)
                    .load(ref.toString() +"/"+ i +".jpg")
                    .into(vehicleimages.get(i));

        }

        **/









        return view;
    }



}
