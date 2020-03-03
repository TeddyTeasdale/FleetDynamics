package com.example.fleetdynamics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button logOutbutton = (Button) findViewById(R.id.LogOutButton);
        logOutbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });


        Button jobSchedulebutton = (Button) findViewById(R.id.JobScheduleButton);
        jobSchedulebutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, JobListActivity.class));
            }
        });

        Button DamageMap = (Button) findViewById(R.id.DamageMapButton);
        jobSchedulebutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DamageSearch.class));
            }
        });

        Button Collection = (Button) findViewById(R.id.CollectionButton);
        jobSchedulebutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, collectionActivity.class));
            }
        });

        Button Delivery = (Button) findViewById(R.id.DeliveryButton);
        jobSchedulebutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DeliveryActivity.class));
            }
        });
    }

}
