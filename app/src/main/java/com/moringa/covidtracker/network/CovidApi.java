package com.moringa.covidtracker.network;

import com.moringa.covidtracker.models.Cases;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CovidApi {
    @GET("cases")
    Call<Cases> getRestaurants(
            @Query("country") String country
    );
}
