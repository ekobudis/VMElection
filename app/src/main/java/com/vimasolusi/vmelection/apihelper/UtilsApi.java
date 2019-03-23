package com.vimasolusi.vmelection.apihelper;

public class UtilsApi {

    public static final String BASE_URL_API = "http:/127.0.0.1/api/";

    // Mendeklarasikan Interface BaseApiService
    public static ApiService getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(ApiService.class);
    }

}
