package com.alexdevp.starwars.ui.adapters.local;

import android.content.Context;

import com.alexdevp.starwars.dataSource.SwAPIDataSource;
import com.alexdevp.starwars.model.Planet;
import com.alexdevp.starwars.model.PlanetsResponse;
import com.alexdevp.starwars.services.PlanetsService;
import com.alexdevp.starwars.ui.adapters.local.AppDatabase;
import com.alexdevp.starwars.ui.adapters.local.PlanetDAO;
import com.alexdevp.starwars.ui.adapters.local.PreferencesManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DatabaseRepository {


    //PLANETS REPOSITORY

    public static Planet getPlanetbyName(Context context, String name) {
        return AppDatabase.getInstance(context).getPlanetDao().getPlanetByName(name);
    }

    public static void getPlanets(Context context, final OnDataAvailableCallBack<Planet[]> callback) {
        final PlanetDAO planetDAO = AppDatabase.getInstance(context).getPlanetDao();

        new Thread(() -> {
            long lastSavedDate = PreferencesManager.getLastSavedDatePlanets(context);
            Planet[] planets = planetDAO.getPlanets();
            callback.onSuccess(planets);


            if (lastSavedDate < System.currentTimeMillis() - (5 * 60 * 1000) || planets.length == 0) {
                PlanetsService planetsService = SwAPIDataSource.getPlanetsService();

                Call<PlanetsResponse> call = planetsService.getPlanets();
                call.enqueue(new Callback<PlanetsResponse>() {
                    @Override
                    public void onResponse(Call<PlanetsResponse> call, Response<PlanetsResponse> response) {
                        if (response.isSuccessful()) {
                            final Planet[] planetsResponse = response.body().getResults();
                            new Thread(() -> {
                                planetDAO.deleteAllPlanets();
                                planetDAO.addPlanets(planetsResponse);
                                PreferencesManager.saveLastSavedDatePlanets(context, System.currentTimeMillis());
                                callback.onSuccess(planetsResponse);
                            }).start();
                        }
                    }

                    @Override
                    public void onFailure(Call<PlanetsResponse> call, Throwable t) {
                        callback.onError(t.getMessage());
                    }
                });
            }
        }).start();

    }

    public interface OnDataAvailableCallBack<T> {
        void onSuccess(T values);
        void onError(String Error);
    }

    //FILMS REPOSITORY

}
