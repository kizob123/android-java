package com.example.gadseduca.models.retrofit.getusers.getmessages;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GetMessagesRecyclerView extends RecyclerView.Adapter<GetMessagesRecyclerView.MessagesViewHolder> {
    @NonNull
    @Override
    public GetMessagesRecyclerView.MessagesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull GetMessagesRecyclerView.MessagesViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MessagesViewHolder extends RecyclerView.ViewHolder {
        public MessagesViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
