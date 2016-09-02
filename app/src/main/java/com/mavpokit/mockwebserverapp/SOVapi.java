package com.mavpokit.mockwebserverapp;



import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Alex on 30.08.2016.
 */
public interface SOVapi {
    @GET("2.2/search?order=desc&sort=activity&site=stackoverflow")
    Call<ListAnswer> search(@Query("tagged") String searchText);

}