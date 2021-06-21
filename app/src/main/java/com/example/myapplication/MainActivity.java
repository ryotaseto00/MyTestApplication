package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.home: {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frame_layout, new HomeFragment())
                            .commit();
                    return true;
                }
                case R.id.message: {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frame_layout, new MessageFragment())
                            .commit();
                    return true;
                }
                case R.id.board: {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frame_layout,new BoardFragment())
                            .commit();
                    return true;
                }
            }
            return false;
        });
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_layout, new HomeFragment())
                .commit();
    }
}