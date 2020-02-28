package com.example.fleetdynamics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;

public class DeliveryActivity extends AppCompatActivity {
    static final int REQUEST_IMAGE_CAPTURE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);


    }
    private void ClickPhoto()
    {
        Intent takePicture = new Intent (MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePicture.resolveActivity(getPackageManager()) != null)
        {
            startActivityForResult(takePicture, REQUEST_IMAGE_CAPTURE);
        }


    }
}

