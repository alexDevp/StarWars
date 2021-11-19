package com.alexdevp.starwars.dataSource;

import com.alexdevp.starwars.services.FilmsService;
import com.alexdevp.starwars.services.PeopleService;
import com.alexdevp.starwars.services.PlanetsService;
import com.alexdevp.starwars.services.SpeciesService;
import com.alexdevp.starwars.services.StarshipsService;
import com.alexdevp.starwars.services.VehiclesService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SwAPIDataSource {


    private static Retrofit retrofit;
    private static PeopleService peopleService;
    private static PlanetsService planetsService;
    private static FilmsService filmsService;
    private static SpeciesService speciesService;
    private static VehiclesService vehiclesService;
    private static StarshipsService starshipsService;

    private static final String BASE_URL = "https://swapi.dev/api/";

    private static Retrofit getRetrofit() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static PeopleService getPeopleService() {
        if (peopleService == null) {
            peopleService = getRetrofit().create(PeopleService.class);
        }
        return peopleService;
    }

    public static PlanetsService getPlanetsService() {
        if (planetsService == null) {
            planetsService = getRetrofit().create(PlanetsService.class);
        }
        return planetsService;
    }

    public static FilmsService getFilmsService() {
        if (filmsService == null) {
            filmsService = getRetrofit().create(FilmsService.class);
        }
        return filmsService;
    }

    public static SpeciesService getSpeciesService() {
        if (speciesService == null) {
            speciesService = getRetrofit().create(SpeciesService.class);
        }
        return speciesService;
    }

    public static VehiclesService getVehiclesService() {
        if (vehiclesService == null) {
            vehiclesService = getRetrofit().create(VehiclesService.class);
        }
        return vehiclesService;
    }

    public static StarshipsService getStarshipsService() {
        if (starshipsService == null) {
            starshipsService = getRetrofit().create(StarshipsService.class);
        }
        return starshipsService;
    }

}
