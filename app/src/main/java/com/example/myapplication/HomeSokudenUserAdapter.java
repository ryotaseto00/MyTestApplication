package com.example.myapplication;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.database.User;
import com.example.myapplication.databinding.SokudenUserItemBinding;

import org.jetbrains.annotations.NotNull;

public class HomeSokudenUserAdapter extends ListAdapter<User, RecyclerView.ViewHolder> {

    public HomeSokudenUserAdapter(){
        super(User.DIFF_CALLBACK)
    }

    @NonNull
    @NotNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerView.ViewHolder holder, int position) {
        holder.bin
    }

    private static class SokudenUserViewHolder extends RecyclerView.ViewHolder{

        private SokudenUserItemBinding binding;

        public SokudenUserViewHolder(@NonNull @NotNull SokudenUserItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }

        public static void bind(User user){
            this.binding.
        }

    }
}

