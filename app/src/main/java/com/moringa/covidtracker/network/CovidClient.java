package com.moringa.covidtracker.network;

import com.moringa.covidtracker.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CovidClient {

    private static Retrofit retrofit = null;
    private static final String BASE_URL = Constants.COVID_BASE_URL;

    public static Retrofit getCases(){
        if(retrofit==null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
