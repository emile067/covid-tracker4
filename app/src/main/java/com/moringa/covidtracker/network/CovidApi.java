package com.moringa.covidtracker.network;

import com.moringa.covidtracker.models.Cases;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CovidApi {
    //declare call function of the cases with country as the parameter to pass
    @GET("cases")
    Call<Cases> getCases(
            @Query("country") String country
    );
}
