package com.example.data.api;

import com.example.data.api.model.YahooWeatherResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {
    String RESPONSE_FORMAT = "json";
    String ENVIRONMENT = "json";

    @GET("yql")
    Single<YahooWeatherResponse> getWeatherForecast(@Query(value = "q") String query,
                                                    @Query(RESPONSE_FORMAT) String format,
                                                    @Query(ENVIRONMENT) String env);
}
