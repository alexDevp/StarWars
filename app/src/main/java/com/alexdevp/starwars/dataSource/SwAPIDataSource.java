package com.alexdevp.starwars.dataSource;

import com.alexdevp.starwars.services.PlanetsService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SwAPIDataSource {


    private static Retrofit retrofit;
    private static PlanetsService planetsService;
    private static final String BASE_URL = "https://swapi.dev/api/" ;

    private static Retrofit getRetrofit() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static PlanetsService getPlanetsService() {
        if (planetsService == null) {
            planetsService = getRetrofit().create(PlanetsService.class);
        }
        return planetsService;
    }





}
