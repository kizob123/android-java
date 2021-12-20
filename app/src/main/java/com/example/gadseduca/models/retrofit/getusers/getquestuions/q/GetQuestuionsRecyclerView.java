package com.example.gadseduca.models.retrofit.getusers.getquestuions.q;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gadseduca.R;
import com.example.gadseduca.models.retrofit.QuestionsList;

import java.util.List;

public class GetQuestuionsRecyclerView extends RecyclerView.Adapter<GetQuestuionsRecyclerView.QuestionListViewHolder> {
    private List<QuestionsList> questionsLists;
    private Context context;

    public GetQuestuionsRecyclerView(List<QuestionsList> questionsLists, Context context) {
        this.questionsLists = questionsLists;
        this.context = context;
    }

    @NonNull
    @Override
    public GetQuestuionsRecyclerView.QuestionListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycer_questions_list,parent,false);
        return new QuestionListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GetQuestuionsRecyclerView.QuestionListViewHolder holder, int position) {
        QuestionsList questionsList = questionsLists.get(position);
        holder.title.setText(questionsList.getTopic());
        holder.details.setText(questionsList.getDetails());
        holder.user_name.setText(questionsList.getUser_id());
        holder.date.setText(questionsList.getDate_time_posted());

    }

    @Override
    public int getItemCount() {

        return questionsLists.size();
    }

    public class QuestionListViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView details;
        TextView user_name;
        TextView date;
        public QuestionListViewHolder(@NonNull View itemView) {
            super(itemView);
            title= itemView.findViewById(R.id.question_title);
            details= itemView.findViewById(R.id.question_det);
            user_name= itemView.findViewById(R.id.user_name);
            date= itemView.findViewById(R.id.time_posted);
        }
    }
}
