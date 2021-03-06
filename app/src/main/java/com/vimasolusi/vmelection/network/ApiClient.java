package com.vimasolusi.vmelection.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public  static final String BASE_URL = "http://127.0.0.1:8000/api/";

    private  static Retrofit mRetrofit;

    public  static  Retrofit getRetrofit(){
        if(mRetrofit == null){
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return  mRetrofit;
    }
}
