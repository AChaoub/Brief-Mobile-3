package com.example.breakingbad.service;

import com.example.breakingbad.model.ActeurGOT;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GOTActeurServiceRepo {

    @GET("Characters/{query}")
    public Call<ActeurGOT> getGOT(@Path(value = "query") String query);

    @GET("Characters")
    public Call<List<ActeurGOT>> getAllActors();
}
