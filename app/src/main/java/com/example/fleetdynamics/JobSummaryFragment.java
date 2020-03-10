package com.example.fleetdynamics;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class JobSummaryFragment extends Fragment
{

    private View myView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
         View view = inflater.inflate(R.layout.fragment_jobsummary, container, false);

        ArrayList<Bitmap> photos = getArguments().getParcelableArrayList("myArrayList");
        System.out.println(photos.size());
        ImageView img1 = view.findViewById(R.id.summaryView);
        ImageView img2 = view.findViewById(R.id.summaryView2);
        ImageView img3 = view.findViewById(R.id.summaryView3);
        ImageView img4 = view.findViewById(R.id.summaryView1);
        img1.toString();

        img1.setImageBitmap(photos.get(0));
        img2.setImageBitmap(photos.get(1));
        img3.setImageBitmap(photos.get(2));
        img4.setImageBitmap(photos.get(3));

        Button logOutbutton = (Button) view.findViewById(R.id.summaryButton);
        logOutbutton.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
        
        }
        });


        return view;
    }





}
