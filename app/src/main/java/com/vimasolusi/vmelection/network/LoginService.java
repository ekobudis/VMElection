package com.vimasolusi.vmelection.network;

import com.vimasolusi.vmelection.etities.BukuResult;
import com.vimasolusi.vmelection.etities.UserResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface LoginService {

    @GET("login")
    Call<UserResult> getUsers();

    @POST("login")
    Call<UserResult> getUsers(@Path("username") String judul);
}
