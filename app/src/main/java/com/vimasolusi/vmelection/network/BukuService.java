package com.vimasolusi.vmelection.network;

import com.vimasolusi.vmelection.etities.BukuResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface BukuService {

    @GET("buku")
    Call<BukuResult> getBuku();

    @GET("buku/{judul}")
    Call<BukuResult> getBuku(@Path("judul") String judul);
}
