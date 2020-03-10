package com.example.fleetdynamics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class collectionActivity extends AppCompatActivity
{
    private static final int CAMERA_REQUEST = 123;
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);

        imageView = (ImageView) this.findViewById(R.id.imageView3);
        Button photoButton = (Button) this.findViewById(R.id.DamageMapButton);
        photoButton.setOnClickListener(new View.OnClickListener()
        {


            //@Override
            public void onClick(View v)
            {
                Intent cameraIntent = new Intent
                        (android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(requestCode == CAMERA_REQUEST && resultCode == RESULT_OK)
        {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);
        }
    }


    //android.content.Intent intent = new android.content.Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);

    //startActivityForResult(cameraIntent, CAMERA_REQUEST);





}
