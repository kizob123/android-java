package com.example.gadseduca.parts;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gadseduca.R;
import com.example.gadseduca.models.retrofit.QuestionsList;
import com.example.gadseduca.models.retrofit.getusers.getquestuions.GetUsersAPI;
import com.example.gadseduca.models.retrofit.getusers.getquestuions.GetUsersRecyclerView;
import com.example.gadseduca.models.retrofit.getusers.getquestuions.RetrofitForGetUsersListUI;
import com.example.gadseduca.models.retrofit.getusers.getquestuions.q.GetQuestuionAPI;
import com.example.gadseduca.models.retrofit.getusers.getquestuions.q.GetQuestuionsRecyclerView;
import com.example.gadseduca.models.retrofit.login_reg.UsersList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class QuestionsFragment extends Fragment {
    List<QuestionsList> questionsLists;

    public QuestionsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    private void getRecycled(List<QuestionsList> questionsLists, View view){
        RecyclerView RV1 = view.findViewById(R.id.q_lists);
        final GetQuestuionsRecyclerView getQuestuionsRecyclerView = new GetQuestuionsRecyclerView(questionsLists,getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        RV1.setLayoutManager(linearLayoutManager);
        RV1.setAdapter(getQuestuionsRecyclerView);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_questions, container, true);
        Retrofit retrofit = RetrofitForGetUsersListUI.getRetrofitinstance();
        GetQuestuionAPI getQuestuionAPI = retrofit.create(GetQuestuionAPI.class);
        Call<List<QuestionsList>> call = getQuestuionAPI.getQuestionList();
        call.enqueue(new Callback<List<QuestionsList>>() {
            @Override
            public void onResponse(Call<List<QuestionsList>> call, Response<List<QuestionsList>> response) {
                if(response.isSuccessful()){
                    List<QuestionsList>questionsLists = response.body();
                    getRecycled(questionsLists,view);
                }
            }

            @Override
            public void onFailure(Call<List<QuestionsList>> call, Throwable t) {

            }
        });
        return view;
    }
}