package com.alexdevp.starwars.ui.adapters.local.Repository;

import android.content.Context;

import com.alexdevp.starwars.dataSource.SwAPIDataSource;
import com.alexdevp.starwars.model.Film;
import com.alexdevp.starwars.model.FilmsResponse;
import com.alexdevp.starwars.services.FilmsService;
import com.alexdevp.starwars.ui.adapters.local.AppDatabase;
import com.alexdevp.starwars.ui.adapters.local.DAO.FilmDAO;
import com.alexdevp.starwars.ui.adapters.local.PreferencesManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DatabaseRepositoryFilms {

    public static Film getFilmByTitle(Context context, String title) {
        return AppDatabase.getInstance(context).getFilmDao().getFilmByTitle(title);
    }

    public static void getFilm(Context context, final OnDataAvailableCallBack<Film[]> callback) {
        final FilmDAO filmDAO = AppDatabase.getInstance(context).getFilmDao();

        new Thread(() -> {
            long lastSavedDate = PreferencesManager.getLastSavedDateFilms(context);
            Film[] films = filmDAO.getFilms();
            callback.onSuccess(films);

            if (lastSavedDate < System.currentTimeMillis() - (5 * 60 * 1000) || films.length == 0) {
                FilmsService filmService = SwAPIDataSource.getFilmsService();

                Call<FilmsResponse> call = filmService.getFilms();
                call.enqueue(new Callback<FilmsResponse>() {
                    @Override
                    public void onResponse(Call<FilmsResponse> call, Response<FilmsResponse> response) {
                        if (response.isSuccessful()) {
                            final Film[] filmsResponse = response.body().getResults();
                            new Thread(() -> {
                                filmDAO.deleteAllFilms();
                                filmDAO.addFilms(filmsResponse);
                                PreferencesManager.saveLastSavedDateFilms(context, System.currentTimeMillis());
                                callback.onSuccess(filmsResponse);
                            }).start();
                        }
                    }

                    @Override
                    public void onFailure(Call<FilmsResponse> call, Throwable t) {
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
