package com.emeryc.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //region Drawer Code
        drawerLayout = findViewById(R.id.DrawerMain);

        NavigationView navigationView = findViewById(R.id.nav_view);

        if(getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if (id == R.id.act1) {
                    Intent intentToComplete = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intentToComplete);

                } else if (id == R.id.act2) {
                    Intent intentComplete = new Intent(getApplicationContext(), SecondActivity.class);
                    startActivity(intentComplete);
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
        actionBarDrawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                R.string.nav_open,
                R.string.nav_close
        );
        if(drawerLayout != null)
            drawerLayout.addDrawerListener(actionBarDrawerToggle);
        if(actionBarDrawerToggle != null)
            actionBarDrawerToggle.syncState();

        //endregion
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item) && actionBarDrawerToggle != null)
        {
            return  true;
        }
        return super.onOptionsItemSelected(item);
    }
}
