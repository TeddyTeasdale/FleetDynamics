package com.example.fleetdynamics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class collectionActivity extends AppCompatActivity
{

    private static final int CAMERA_REQUEST = 123;
    private ImageView imageView;
    private ArrayList<Bitmap> vehiclePhotos = new ArrayList<>();
    int screen = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);
        TextView title = findViewById(R.id.titleView);
        String screen1 = "";

        if(!(getIntent().getStringExtra("screenNumber") == null))
        {
            screen1 = getIntent().getStringExtra("screenNumber");
            screen = Integer.parseInt(screen1);
            vehiclePhotos = (ArrayList<Bitmap>) getIntent().getSerializableExtra("myArrayList");
        }

        switch(screen)
        {
            case 0:
                title.setText("Vehicle Front Photo");
                startCamera();
                break;
            case 1:
                title.setText("Vehicle Back Photo");
                startCamera();
                break;
            case 2:
                title.setText("Vehicle Left Side Photo");
                startCamera();
                break;
            case 3:
                title.setText("Vehicle Right Side Photo");
                startCamera();
                break;
            case 4:

                startActivity(new Intent(collectionActivity.this, summaryActivity.class));
                System.out.println(vehiclePhotos.size());

                break;
        }



    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(requestCode == CAMERA_REQUEST && resultCode == RESULT_OK)
        {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            vehiclePhotos.add(screen, photo);
            imageView.setImageBitmap(photo);
        }
        screen++;
        String screen1 = String.valueOf(screen);

        Intent intent = new Intent(getBaseContext(), collectionActivity.class);
        intent.putExtra("screenNumber", screen1);
        intent.putExtra("myArrayList", vehiclePhotos);
        startActivity(intent);
    }


    public void startCamera()
    {
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


}