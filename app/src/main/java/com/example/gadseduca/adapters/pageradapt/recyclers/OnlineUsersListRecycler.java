package com.example.gadseduca.adapters.pageradapt.recyclers;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class OnlineUsersListRecycler extends RecyclerView.Adapter<OnlineUsersListRecycler.OnlineUsersViewHolder> {
    @NonNull
    @Override
    public OnlineUsersListRecycler.OnlineUsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull OnlineUsersListRecycler.OnlineUsersViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class OnlineUsersViewHolder extends RecyclerView.ViewHolder {
        public OnlineUsersViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
