package com.mavpokit.mockwebserverapp;

import okhttp3.HttpUrl;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Alex on 30.08.2016.
 */
public class ApiProvider {
    public static SOVapi provide(HttpUrl url){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        SOVapi sovapi = retrofit.create(SOVapi.class);
        return sovapi;
    }
}
