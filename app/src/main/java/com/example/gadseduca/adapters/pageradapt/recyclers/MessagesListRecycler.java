package com.example.gadseduca.adapters.pageradapt.recyclers;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MessagesListRecycler extends RecyclerView.Adapter<MessagesListRecycler.MessagesListViewHOlder> {
    @NonNull
    @Override
    public MessagesListRecycler.MessagesListViewHOlder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MessagesListRecycler.MessagesListViewHOlder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MessagesListViewHOlder extends RecyclerView.ViewHolder {
        public MessagesListViewHOlder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
