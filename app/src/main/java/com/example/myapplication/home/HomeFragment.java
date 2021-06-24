package com.example.myapplication.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.FragmentHomeBinding;

import dagger.hilt.android.AndroidEntryPoint;

import static androidx.recyclerview.widget.RecyclerView.HORIZONTAL;

@AndroidEntryPoint
public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private HomeViewModel homeViewModel;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(
            @NonNull @org.jetbrains.annotations.NotNull LayoutInflater inflater,
            @Nullable @org.jetbrains.annotations.Nullable ViewGroup container,
            @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {


        binding = FragmentHomeBinding.inflate(inflater, container, false);

        binding.callUserList.setLayoutManager(new LinearLayoutManager(getContext(),HORIZONTAL,false));
        HomeSokudenUserAdapter sokudenAdapter = new HomeSokudenUserAdapter();

        binding.waitingUserList.setLayoutManager(new GridLayoutManager(getContext(),2, RecyclerView.VERTICAL,false));
        HomeWaitingUserAdapter waitingAdapter = new HomeWaitingUserAdapter();

        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        homeViewModel.getUsers().observe(getViewLifecycleOwner(), sokudenAdapter::submitList);
        homeViewModel.getUsers().observe(getViewLifecycleOwner(), waitingAdapter::submitList);
        binding.callUserList.setAdapter(sokudenAdapter);
        binding.waitingUserList.setAdapter(waitingAdapter);

        return binding.getRoot();
    }
}
