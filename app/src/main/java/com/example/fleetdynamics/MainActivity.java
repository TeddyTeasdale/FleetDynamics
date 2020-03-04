package com.example.fleetdynamics;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

// Author Teddy Teasdale

public class MainActivity extends AppCompatActivity
{
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button logOutbutton = (Button) findViewById(R.id.LogOutButton);
        //logOutbutton.setOnClickListener(new View.OnClickListener() {
            //public void onClick(View v) {
                //startActivity(new Intent(MainActivity.this, LoginActivity.class));
            //}
        //});
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle



    }

}
