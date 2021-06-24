package com.example.myapplication.message;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentMessagesFromUserBinding;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.stream.Collectors;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MessagesFromUserFragment extends Fragment {

    private FragmentMessagesFromUserBinding binding;
    private MessageViewModel messageViewModel;
    private long userId;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        binding = FragmentMessagesFromUserBinding.inflate(inflater,container,false);
        assert getArguments() != null;
        userId = getArguments().getLong("userId");
        messageViewModel = new ViewModelProvider(this).get(MessageViewModel.class);
        MessageFromUserAdapter messageFromUserAdapter = new MessageFromUserAdapter(messageViewModel);
        messageViewModel.getMessages().observe(getViewLifecycleOwner(),messageList -> {
                messageFromUserAdapter.submitList(messageList.stream().filter(list -> list.getFromUserId() == userId).collect(Collectors.toList()));
        });
        binding.messageFromUserList.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false));
        binding.messageFromUserList.setAdapter(messageFromUserAdapter);
        return binding.getRoot();
    }
}
