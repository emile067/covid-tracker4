package com.moringa.covidtracker.network;

import com.moringa.covidtracker.Constants;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CovidClient {

    private static Retrofit retrofit = null;
    private static final String BASE_URL = Constants.COVID_BASE_URL;

    public static CovidApi getCases(){
        if(retrofit==null){
//            OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                    .addInterceptor(new Interceptor() {
//                        @Override
//                        public Response intercept(Chain chain) throws IOException {
//                            Request newRequest  = chain.request().newBuilder()
//                                    .build();
//                            return chain.proceed(newRequest);
//                        }
//                    })
//                    .build();


            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(CovidApi.class);
    }
}
