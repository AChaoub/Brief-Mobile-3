package com.example.breakingbad.service;

import com.example.breakingbad.model.ContinentsGOT;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GOTContinentServiceRepo {

    @GET("Continents/{query}")
    public Call<ContinentsGOT> getGOT(@Path(value = "query") String query);
}
