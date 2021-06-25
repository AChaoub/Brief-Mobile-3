package com.example.breakingbad.service;


import com.example.breakingbad.model.ActeurBrB;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ActeurRepoService {

   @GET("characters")
   public Call<ActeurBrB> getAllActeurs();

   @GET("characters/{query}")
   public Call<ActeurBrB> getActeur(@Path(value = "query",encoded = true) String query);

   @GET("characters")
   public Call<ActeurBrB> getActeurByName(@Query("name") String query);

}
