package com.alexdevp.starwars.services;


import com.alexdevp.starwars.model.Planet;
import com.alexdevp.starwars.model.PlanetsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PlanetsService {

    @GET("planets")
    Call<PlanetsResponse> getPlanets();

    @GET("planets/{planetId}/")
    Call<Planet> getPlanet(@Path("planetId") int planetId, @Query("format") String format);
}
