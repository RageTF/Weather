package com.example.rage.weather.retrofit;

import com.example.rage.weather.retrofit.gson.AllWeather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Rage on 27.10.2016.
 */

public interface ApiOpenWeather {

    @GET("/data/2.5/forecast")
    Call<AllWeather> getWeather(@Query("q") String city, @Query("id") String id, @Query("APPID") String appid);

}
