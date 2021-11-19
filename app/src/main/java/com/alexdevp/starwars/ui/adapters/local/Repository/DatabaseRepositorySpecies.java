package com.alexdevp.starwars.ui.adapters.local.Repository;

import android.content.Context;

import com.alexdevp.starwars.dataSource.SwAPIDataSource;
import com.alexdevp.starwars.model.Specie;
import com.alexdevp.starwars.model.SpeciesResponse;
import com.alexdevp.starwars.services.SpeciesService;
import com.alexdevp.starwars.ui.adapters.local.AppDatabase;
import com.alexdevp.starwars.ui.adapters.local.DAO.SpecieDAO;
import com.alexdevp.starwars.ui.adapters.local.PreferencesManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DatabaseRepositorySpecies {

    public static Specie getSpeciesByName(Context context, String name) {
        return AppDatabase.getInstance(context).getSpecieDao().getSpecieByName(name);
    }

    public static void getSpecies(Context context, final OnDataAvailableCallBack<Specie[]> callback) {
        final SpecieDAO specieDAO = AppDatabase.getInstance(context).getSpecieDao();

        new Thread(() -> {
            long lastSavedDate = PreferencesManager.getLastSavedDateSpecies(context);
            Specie[] species = specieDAO.getSpecies();
            callback.onSuccess(species);


            if (lastSavedDate < System.currentTimeMillis() - (5 * 60 * 1000) || species.length == 0) {
                SpeciesService speciesService = SwAPIDataSource.getSpeciesService();

                Call<SpeciesResponse> call = speciesService.getSpecies();
                call.enqueue(new Callback<SpeciesResponse>() {
                    @Override
                    public void onResponse(Call<SpeciesResponse> call, Response<SpeciesResponse> response) {
                        if (response.isSuccessful()) {
                            final Specie[] speciesResponse = response.body().getResults();
                            new Thread(() -> {
                                specieDAO.deleteAllSpecies();
                                specieDAO.addSpecies(speciesResponse);
                                PreferencesManager.saveLastSavedDateSpecies(context, System.currentTimeMillis());
                                callback.onSuccess(speciesResponse);
                            }).start();
                        }
                    }

                    @Override
                    public void onFailure(Call<SpeciesResponse> call, Throwable t) {
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
}
