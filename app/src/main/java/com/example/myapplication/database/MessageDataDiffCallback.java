package com.example.myapplication.database;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.example.myapplication.database.Message;

import org.jetbrains.annotations.NotNull;

public class MessageDataDiffCallback extends DiffUtil.ItemCallback<Message> {

    @Override
    public boolean areItemsTheSame(@NonNull @NotNull Message oldItem, @NonNull @NotNull Message newItem) {
        return oldItem.getId() == newItem.getId();
    }

    @Override
    public boolean areContentsTheSame(@NonNull @NotNull Message oldItem, @NonNull @NotNull Message newItem) {
        return oldItem.equals(newItem);
    }
}
