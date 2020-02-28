package com.example.fleetdynamics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Jeni work






        // Micheal work







        // Hafsa

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
                                            public void onClick(View v) {
                                                startActivity(new Intent(MainActivity.this, DeliveryActivity.class));
                                            }
                                        });


        // James work








        //Teddy work
    }
}
