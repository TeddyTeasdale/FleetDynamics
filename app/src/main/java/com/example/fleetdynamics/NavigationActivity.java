package com.example.fleetdynamics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NavigationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);


        Button logOutbutton = (Button) findViewById(R.id.LogOutButton);
        logOutbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(NavigationActivity.this, MainActivity.class));
            }
    });


        Button jobSchedulebutton = (Button) findViewById(R.id.JobScheduleButton);
        jobSchedulebutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(NavigationActivity.this, JobListActivity.class));
            }
        });


}
}