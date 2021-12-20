package com.example.gadseduca.models.retrofit.getusers.getquestuions.q;

import com.example.gadseduca.models.retrofit.QuestionsList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface GetQuestuionAPI {
    @GET("questions")
    Call<List<QuestionsList>> getQuestionList();
    @POST("questions")
    Call<QuestionsList> createQuestion(@Body QuestionsList questionsList);
}
