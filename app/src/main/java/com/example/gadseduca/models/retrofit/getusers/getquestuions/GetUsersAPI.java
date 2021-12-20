package com.example.gadseduca.models.retrofit.getusers.getquestuions;

import com.example.gadseduca.models.retrofit.login_reg.UsersList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface GetUsersAPI {
    @GET("user")
    Call<List<UsersList>> getUser();
}
