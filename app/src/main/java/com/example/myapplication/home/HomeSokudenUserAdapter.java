package com.example.myapplication.home;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.database.UserDataDiffCallback;
import com.example.myapplication.database.User;
import com.example.myapplication.databinding.SokudenUserItemBinding;

import org.jetbrains.annotations.NotNull;

public class HomeSokudenUserAdapter extends ListAdapter<User, RecyclerView.ViewHolder> {
    public HomeSokudenUserAdapter(){
        super(new UserDataDiffCallback());
    }
    @NonNull
    @NotNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        SokudenUserItemBinding binding = SokudenUserItemBinding.inflate(layoutInflater,parent,false);
        return new SokudenUserViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerView.ViewHolder holder, int position) {
        User user = getItem(position);
        SokudenUserViewHolder userViewHolder =  (SokudenUserViewHolder) holder;
        userViewHolder.bind(user);
    }

    private static class SokudenUserViewHolder extends RecyclerView.ViewHolder{

        private final SokudenUserItemBinding binding;

        public SokudenUserViewHolder(@NonNull @NotNull SokudenUserItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(User user){
            binding.setUser(user);
        }

    }
}

