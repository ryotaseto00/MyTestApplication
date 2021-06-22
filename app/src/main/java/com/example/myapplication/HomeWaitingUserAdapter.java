package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.database.User;
import com.example.myapplication.databinding.WaitingUserItemBinding;

import org.jetbrains.annotations.NotNull;

public class HomeWaitingUserAdapter extends ListAdapter<User, RecyclerView.ViewHolder> {

    public HomeWaitingUserAdapter(){
        super(new UserDataDiffCallback());
    }

    @NonNull
    @NotNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        WaitingUserItemBinding binding = WaitingUserItemBinding.inflate(layoutInflater,parent,false);
        return new WaitingUserViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerView.ViewHolder holder, int position) {
        User user = getItem(position);
        WaitingUserViewHolder userViewHolder =  (WaitingUserViewHolder) holder;
        userViewHolder.bind(user);
    }

    private static class WaitingUserViewHolder extends RecyclerView.ViewHolder{

        private final WaitingUserItemBinding binding;

        public WaitingUserViewHolder(@NonNull @NotNull WaitingUserItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }

        public void bind(User user){
            binding.setUser(user);
        }

    }
}
