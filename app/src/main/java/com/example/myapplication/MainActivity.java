package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.home.HomeFragment;
import com.example.myapplication.message.MessageFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        BottomNavigationView bottomNavigationView = binding.bottomNavigation;
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