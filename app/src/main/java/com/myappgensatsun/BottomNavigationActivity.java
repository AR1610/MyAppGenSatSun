package com.myappgensatsun;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavigationActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);
        bottomNavigationView = findViewById(R.id.bottom_nav);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment fragment = null;

                        if (item.getItemId() == R.id.item_home) {

                            fragment = new AFragment();
                            Toast.makeText(BottomNavigationActivity.this, "Home", Toast.LENGTH_SHORT).show();
                            toolbar.setTitle("Home");
                        } else if (item.getItemId() == R.id.item_profile) {
                            toolbar.setTitle("Profile");
                            fragment = new BFragment();

                        }

                        if (fragment != null) {

                            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                            fragmentTransaction.replace(R.id.frame, fragment);
                            fragmentTransaction.commit();
                        }
                        return true;
                    }
                });

    }
}