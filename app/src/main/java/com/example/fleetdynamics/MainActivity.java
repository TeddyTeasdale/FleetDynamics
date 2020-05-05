package com.example.fleetdynamics;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        boolean performSync = prefs.getBoolean("perform_Sync",true);
        String syncInterval = prefs.getString("sync_interval", "30");
        String fullName = prefs.getString("full_name", "");
        String email = prefs.getString("email_address","");


        Toast.makeText(this, performSync + "", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, syncInterval, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, fullName, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, email, Toast.LENGTH_SHORT).show();



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.drawer_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.settings:
                startActivity(new Intent(this, Settings.class));
                break;
        }
        return super.onOptionsItemSelected(item);
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
