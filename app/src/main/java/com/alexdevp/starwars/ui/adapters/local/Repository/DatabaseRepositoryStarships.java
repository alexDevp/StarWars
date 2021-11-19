package com.alexdevp.starwars.ui.adapters.local.Repository;

import android.content.Context;

import com.alexdevp.starwars.dataSource.SwAPIDataSource;
import com.alexdevp.starwars.model.Starship;
import com.alexdevp.starwars.model.StarshipsResponse;
import com.alexdevp.starwars.model.Vehicle;
import com.alexdevp.starwars.model.VehiclesResponse;
import com.alexdevp.starwars.services.StarshipsService;
import com.alexdevp.starwars.services.VehiclesService;
import com.alexdevp.starwars.ui.adapters.local.AppDatabase;
import com.alexdevp.starwars.ui.adapters.local.DAO.StarshipDAO;
import com.alexdevp.starwars.ui.adapters.local.DAO.VehicleDAO;
import com.alexdevp.starwars.ui.adapters.local.PreferencesManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DatabaseRepositoryStarships {

    public static Starship getStarshipByName(Context context, String name) {
        return AppDatabase.getInstance(context).getStarshipDao().getStarshipByName(name);
    }

    public static void getStarships(Context context, final OnDataAvailableCallBack<Starship[]> callback) {
        final StarshipDAO starshipDAO = AppDatabase.getInstance(context).getStarshipDao();

        new Thread(() -> {
            long lastSavedDate = PreferencesManager.getLastSavedDateStarships(context);
            Starship[] starships = starshipDAO.getStarships();
            callback.onSuccess(starships);


            if (lastSavedDate < System.currentTimeMillis() - (5 * 60 * 1000) || starships.length == 0) {
                StarshipsService starshipsService = SwAPIDataSource.getStarshipsService();

                Call<StarshipsResponse> call = starshipsService.getStarships();
                call.enqueue(new Callback<StarshipsResponse>() {
                    @Override
                    public void onResponse(Call<StarshipsResponse> call, Response<StarshipsResponse> response) {
                        if (response.isSuccessful()) {
                            final Starship[] starshipsResponse = response.body().getResults();
                            new Thread(() -> {
                                starshipDAO.deleteAllStarships();
                                starshipDAO.addStarships(starshipsResponse);
                                PreferencesManager.saveLastSavedDateStarships(context, System.currentTimeMillis());
                                callback.onSuccess(starshipsResponse);
                            }).start();
                        }
                    }

                    @Override
                    public void onFailure(Call<StarshipsResponse> call, Throwable t) {
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
