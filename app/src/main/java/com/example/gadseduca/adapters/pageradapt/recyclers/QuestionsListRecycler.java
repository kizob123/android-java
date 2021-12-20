package com.example.gadseduca.adapters.pageradapt.recyclers;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class QuestionsListRecycler extends RecyclerView.Adapter<QuestionsListRecycler.QuestionsListViewholder> {
    @NonNull
    @Override
    public QuestionsListRecycler.QuestionsListViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionsListRecycler.QuestionsListViewholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class QuestionsListViewholder extends RecyclerView.ViewHolder{
        public QuestionsListViewholder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
