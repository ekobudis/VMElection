package com.vimasolusi.vmelection.apihelper;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;

public interface ApiService {

    // Fungsi ini untuk memanggil API http://10.0.2.2/api/login.php
    @FormUrlEncoded
    @POST("login")
    Call<ResponseBody> loginRequest(@Field("username") String username,
                                    @Field("password") String password);

    // Fungsi ini untuk memanggil API http://10.0.2.2/mahasiswa/register.php
    @FormUrlEncoded
    @POST("register")
    Call<ResponseBody> registerRequest(@Field("nama") String nama,
                                       @Field("email") String email,
                                       @Field("password") String password);

    /*@FormUrlEncoded
    @GET("tps/{anggota_id}") //tampilkan wilayah tugas anggota


    @FormUrlEncoded
    @GET("anggota/{anggota_id}") //Edit Data Aggota


    @FormUrlEncoded
    @PATCH("anggota/{anggota_id}") //Update Data ANggota


    @FormUrlEncoded
    @GET("tps/{tps_id}/linmas/new") // Buat Data Linmas Per TPS*/

}
