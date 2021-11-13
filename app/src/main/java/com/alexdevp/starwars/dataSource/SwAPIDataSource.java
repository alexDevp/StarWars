package com.alexdevp.starwars.dataSource;

import com.alexdevp.starwars.services.PlanetsService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SwAPIDataSource {

    private static Retrofit retrofit;
    private static PlanetsService planetsService;


    public static PlanetsService getPlanetsService() {
        if (planetsService == null) {
            planetsService = getRetrofit().create(PlanetsService.class);
        }
        return planetsService;
    }

    private static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://swapi.co/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
