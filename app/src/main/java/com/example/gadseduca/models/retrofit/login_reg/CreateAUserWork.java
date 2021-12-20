package com.example.gadseduca.models.retrofit.login_reg;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.example.gadseduca.models.retrofit.login_reg.RegisterLoginRetrofitAPI;
import com.example.gadseduca.models.retrofit.login_reg.RetrofitClientForLoginorRegistration;
import com.example.gadseduca.models.retrofit.login_reg.UsersList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CreateAUserWork extends Worker {
    UsersList usersList;
    public CreateAUserWork(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        Retrofit retrofitClientForLoginorRegistration = RetrofitClientForLoginorRegistration.getRetrofitinstance();
        RegisterLoginRetrofitAPI registerLoginRetrofitAPI = retrofitClientForLoginorRegistration.create(RegisterLoginRetrofitAPI.class);
        UsersList usersList= this.usersList;
        Call<UsersList> call = registerLoginRetrofitAPI.createUser(usersList);

        call.enqueue(new Callback<UsersList>() {
            @Override
            public void onResponse(Call<UsersList> call, Response<UsersList> response) {
                UsersList responseFromApi = response.body();
                String resonseString = "User: "+ responseFromApi.getFirstname()+" has been stored";
                Toast.makeText(getApplicationContext(),resonseString,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<UsersList> call, Throwable t) {
                String fail = "User: "+ usersList.getFirstname()+" wasnot stored: ceck your internet, "+t.getMessage();
                Toast.makeText(getApplicationContext(),fail,Toast.LENGTH_LONG);
            }
        });

        return null;
    }


    public void registeruser(UsersList usersList) {
            this.usersList = usersList;

    }
}
