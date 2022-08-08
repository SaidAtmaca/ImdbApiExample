package com.said.imdbapiexample.Api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieApi {

    @GET("en/API/Top250Movies/k_6axre216")
    Call<ItemsInfo> getData();
}
