package com.example.fleetdynamics;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

// Author Teddy Teasdale

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    //Button backButton;
    private DrawerLayout drawer;
    private TextView NavEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // backButton = findViewById(R.id.button);

        //backButton.setOnClickListener(v -> startActivity(new Intent(MainActivity.this,CollectionFragment.class)));
        //{

        //}

        //Button logOutbutton = (Button) findViewById(R.id.LogOutButton);
        //logOutbutton.setOnClickListener(new View.OnClickListener() {
            //public void onClick(View v) {
                //startActivity(new Intent(MainActivity.this, LoginActivity.class));
            //}
        //});





        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer ,toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();




        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View headerView = navigationView.getHeaderView(0);
        FirebaseAuth fAuth = FirebaseAuth.getInstance();

        if(!(fAuth.getCurrentUser() == null))
        {
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            String email = user.getEmail();
            NavEmail = headerView.findViewById(R.id.nav_email);
            NavEmail.setText(email);
        }



        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new JobListFragment()).addToBackStack(null).commit();
        navigationView.setCheckedItem(R.id.nav_joblist);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
    {
        switch (menuItem.getItemId())
        {
            case R.id.nav_joblist:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new JobListFragment()).addToBackStack(null).commit();
                break;
                // TO BE IMPLEMENTED WITH OTHER SCREENS UPON MERGE
         //   case R.id.nav_joblist:
         //       getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new JobListFragment());
         //       break;
         //   case R.id.nav_joblist:
         //       getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new JobListFragment());
         //       break;
            case R.id.nav_logout:
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                break;

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed()
    {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);

        }
        else
        {
            super.onBackPressed();
        }
    }
}
