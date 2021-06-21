package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.example.myapplication.database.User;

import org.jetbrains.annotations.NotNull;

public class UserDataDiffCallback extends DiffUtil.ItemCallback<User> {

    @Override
    public boolean areItemsTheSame(@NonNull @NotNull User oldItem, @NonNull @NotNull User newItem) {
        return oldItem.getId() == newItem.getId();
    }

    @Override
    public boolean areContentsTheSame(@NonNull @NotNull User oldItem, @NonNull @NotNull User newItem) {
        return oldItem.equals(newItem);
    }
}
