package com.example.myapplication.message;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.FragmentMessageBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MessageFragment extends Fragment {

    private FragmentMessageBinding binding;
    private MessageViewModel messageViewModel;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(
            @NonNull @org.jetbrains.annotations.NotNull LayoutInflater inflater,
            @Nullable @org.jetbrains.annotations.Nullable ViewGroup container,
            @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {

        binding = FragmentMessageBinding.inflate(inflater, container, false);
        binding.messageList.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false));
        messageViewModel = new ViewModelProvider(this).get(MessageViewModel.class);
        MessageAdapter messageAdapter = new MessageAdapter(messageViewModel,this);
        messageViewModel.getUsers().observe(getViewLifecycleOwner(), messageAdapter::submitList);
        binding.messageList.setAdapter(messageAdapter);

        return binding.getRoot();
    }


}
