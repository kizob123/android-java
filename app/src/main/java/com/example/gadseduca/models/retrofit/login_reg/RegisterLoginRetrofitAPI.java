package com.example.gadseduca.models.retrofit.login_reg;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RegisterLoginRetrofitAPI {
    @POST("user")
    Call<UsersList> createUser(@Body UsersList usersList);

}
