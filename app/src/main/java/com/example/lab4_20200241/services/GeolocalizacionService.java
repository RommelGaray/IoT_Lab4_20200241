package com.example.lab4_20200241.services;

import com.example.lab4_20200241.dto.Geolocalizacion;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GeolocalizacionService {
    @GET("/geo/1.0/direct")
    Call<Geolocalizacion> getGeolocalizacion(@Query("q") String ciudadOficial,
                                   @Query("limit") int limit,
                                   @Query("appid") String appid);

}
