package com.example.myapplication.message;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.database.Message;
import com.example.myapplication.database.User;
import com.example.myapplication.database.UserDataDiffCallback;
import com.example.myapplication.databinding.MessageItemBinding;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class MessageAdapter extends ListAdapter<User, RecyclerView.ViewHolder> {

    private final MessageViewModel messageViewModel;
    private final MessageFragment fragment;

    public MessageAdapter(MessageViewModel messageViewModel, MessageFragment fragment) {
        super(new UserDataDiffCallback());
        this.messageViewModel = messageViewModel;
        this.fragment = fragment;
    }

    @NonNull
    @NotNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        MessageItemBinding binding = MessageItemBinding.inflate(layoutInflater,parent,false);
        return new MessageViewHolder(binding);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerView.ViewHolder holder, int position) {
        User user = getItem(position);
        MessageViewHolder messageViewHolder = (MessageViewHolder) holder;
        messageViewHolder.bind(user,messageViewModel,fragment);
    }


    private static class MessageViewHolder extends RecyclerView.ViewHolder{

        private final MessageItemBinding binding;

        public MessageViewHolder(@NonNull @NotNull MessageItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        @RequiresApi(api = Build.VERSION_CODES.N)
        public void bind(User user, MessageViewModel messageViewModel, MessageFragment fragment){
            binding.setUser(user);
            binding.setMessage(
                    Objects.requireNonNull(
                            messageViewModel.getMessages().getValue()).stream().filter(
                                    message -> message.getFromUserId() == user.getId()
                    ).reduce((first,second) -> second).orElse(new Message(0L,0L)));
            binding.latestMessage.setOnClickListener(view -> {
                Bundle bundle = new Bundle();
                bundle.putLong("userId",user.getId());
                MessagesFromUserFragment messagesFromUserFragment = new MessagesFromUserFragment();
                messagesFromUserFragment.setArguments(bundle);
                fragment.getParentFragmentManager().beginTransaction()
                .replace(R.id.frame_layout,messagesFromUserFragment).addToBackStack("")
                .commit();
            });
        }

    }
}
