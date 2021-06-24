package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.example.myapplication.database.User;
import com.example.myapplication.database.UserRepository;
import com.example.myapplication.databinding.ActivityDetailUserBinding;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class UserDetailActivity extends AppCompatActivity {

    @Inject
    UserRepository userRepository;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDetailUserBinding binding = ActivityDetailUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();
        long userId = intent.getLongExtra("EXTRA_USER_ID",0L);
        binding.setUser(userRepository.getUserList().stream().filter(user -> user.getId() == userId).findFirst().orElse(new User(0L, "はなこ", 28,"東京")));
    }
}