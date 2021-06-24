package com.example.myapplication.message;

import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.UserDetailActivity;
import com.example.myapplication.database.Message;
import com.example.myapplication.database.MessageDataDiffCallback;
import com.example.myapplication.database.User;
import com.example.myapplication.databinding.MessageFromUserItemBinding;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class MessageFromUserAdapter extends ListAdapter<Message,RecyclerView.ViewHolder> {

    private final MessageViewModel messageViewModel;

    public MessageFromUserAdapter(MessageViewModel messageViewModel) {
        super(new MessageDataDiffCallback());
        this.messageViewModel = messageViewModel;
    }

    @NonNull
    @NotNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        MessageFromUserItemBinding binding = MessageFromUserItemBinding.inflate(layoutInflater,parent,false);
        return new MessageFromUserViewHolder(binding);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerView.ViewHolder holder, int position) {
        Message message = getItem(position);
        MessageFromUserViewHolder messageViewHolder = (MessageFromUserViewHolder) holder;
        messageViewHolder.bind(message,messageViewModel);
    }


    private static class MessageFromUserViewHolder extends RecyclerView.ViewHolder{

        private final MessageFromUserItemBinding binding;

        public MessageFromUserViewHolder(@NonNull @NotNull MessageFromUserItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        @RequiresApi(api = Build.VERSION_CODES.N)
        public void bind(Message message, MessageViewModel messageViewModel){
            binding.setMessage(message);
            binding.setUser(
                    Objects.requireNonNull(
                            messageViewModel.getUsers().getValue()).stream().filter(
                            user -> user.getId() == message.getFromUserId()
                    ).findFirst().orElse(new User(0L, "はなこ", 28,"東京") ));
            binding.userPhoto.setOnClickListener(v -> {
                Intent intent = new Intent(v.getContext(), UserDetailActivity.class);
                intent.putExtra("EXTRA_USER_ID",binding.getUser().getId());
                v.getContext().startActivity(intent);
            });
        }

    }
}
