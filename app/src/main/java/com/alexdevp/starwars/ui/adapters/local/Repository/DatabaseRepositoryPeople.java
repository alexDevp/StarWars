package com.alexdevp.starwars.ui.adapters.local.Repository;

import android.content.Context;

import com.alexdevp.starwars.dataSource.SwAPIDataSource;
import com.alexdevp.starwars.model.People;
import com.alexdevp.starwars.model.PeopleResponse;
import com.alexdevp.starwars.services.PeopleService;
import com.alexdevp.starwars.ui.adapters.local.AppDatabase;
import com.alexdevp.starwars.ui.adapters.local.DAO.PeopleDAO;
import com.alexdevp.starwars.ui.adapters.local.PreferencesManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DatabaseRepositoryPeople {

    public static People getPeopleByName(Context context, String name) {
        return AppDatabase.getInstance(context).getPeopleDao().getPeopleByName(name);
    }

    public static void getPeople(Context context, final OnDataAvailableCallBack<People[]> callback) {
        final PeopleDAO peopleDAO = AppDatabase.getInstance(context).getPeopleDao();

        new Thread(() -> {
            long lastSavedDate = PreferencesManager.getLastSavedDatePeople(context);
            People[] people = peopleDAO.getPeople();
            callback.onSuccess(people);

            if (lastSavedDate < System.currentTimeMillis() - (5 * 60 * 1000) || people.length == 0) {
                PeopleService peopleService = SwAPIDataSource.getPeopleService();

                Call<PeopleResponse> call = peopleService.getPeople();
                call.enqueue(new Callback<PeopleResponse>() {
                    @Override
                    public void onResponse(Call<PeopleResponse> call, Response<PeopleResponse> response) {
                        if (response.isSuccessful()) {
                            final People[] peopleResponse = response.body().getResults();
                            new Thread(() -> {
                                peopleDAO.deleteAllPeople();
                                peopleDAO.addPeople(peopleResponse);
                                PreferencesManager.saveLastSavedDatePeople(context, System.currentTimeMillis());
                                callback.onSuccess(peopleResponse);
                            }).start();
                        }
                    }

                    @Override
                    public void onFailure(Call<PeopleResponse> call, Throwable t) {
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
