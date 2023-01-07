package com.example.habittrackerprojectjavaversion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class NextActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    homeFragment homeFrag = new homeFragment();
    habitFragment habitFrag = new habitFragment();
    taskFragment taskFrag = new taskFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        bottomNavigationView = findViewById(R.id.bottomNavigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, homeFrag).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch(item.getItemId()){
                    case R.id.homeItem:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, homeFrag).commit();
                        return true;
                    case R.id.habitItem:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, habitFrag).commit();
                        return true;
                    case R.id.taskItem:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, taskFrag).commit();
                        return true;
                    case R.id.testItem:
                        startActivity(new Intent(getApplicationContext(), home.class));
                        return true;
                }
                return false;
            }
        });
    }
}