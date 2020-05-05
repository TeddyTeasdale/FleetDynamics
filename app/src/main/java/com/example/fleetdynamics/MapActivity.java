package com.example.fleetdynamics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com/maps"));
        startActivity(intent);
    }
    public void mapOnClick(View v)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com/maps"));
        Button openMap = (Button) v;
        ((Button) v).setText("clicked");
        startActivity(intent);
    };
}
