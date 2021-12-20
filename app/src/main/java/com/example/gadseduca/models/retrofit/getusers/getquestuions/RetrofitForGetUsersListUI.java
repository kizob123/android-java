package com.example.gadseduca.models.retrofit.getusers.getquestuions;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitForGetUsersListUI {
    private  static Retrofit registerRetrofit;
    public static final String BASE_URL = "http://10.0.2.2:3000/";
    public static Retrofit getRetrofitinstance(){
        if(registerRetrofit==null){
            registerRetrofit= new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return registerRetrofit;
    }//emmersion7734$$$@@33
}
