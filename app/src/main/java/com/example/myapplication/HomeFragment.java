package com.example.myapplication;

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

import static androidx.recyclerview.widget.RecyclerView.HORIZONTAL;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

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

        HomeViewModel model = new ViewModelProvider(this).get(HomeViewModel.class);
        model.getUsers().observe(getViewLifecycleOwner(), sokudenAdapter::submitList);
        model.getUsers().observe(getViewLifecycleOwner(), waitingAdapter::submitList);
        binding.callUserList.setAdapter(sokudenAdapter);
        binding.waitingUserList.setAdapter(waitingAdapter);

        return binding.getRoot();
    }
}
