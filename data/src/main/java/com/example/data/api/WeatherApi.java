package com.example.data.api;

import com.example.data.api.model.WeatherResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface WeatherApi {
    @GET("forecast")
    Single<WeatherResponse> getWeatherForecast(@Header ("X-Yandex-API-Key")String apiKey,
                                               @Query(value = "lat") String latitude,
                                               @Query("lon") String longitude,
                                               @Query("lang") String language,
                                               @Query("hours") Boolean hours);
}
