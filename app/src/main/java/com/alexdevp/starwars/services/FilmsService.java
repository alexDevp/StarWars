package com.alexdevp.starwars.services;


import com.alexdevp.starwars.model.Film;
import com.alexdevp.starwars.model.FilmsResponse;
import com.alexdevp.starwars.model.Planet;
import com.alexdevp.starwars.model.PlanetsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface FilmsService {

    @GET("films")
    Call<FilmsResponse> getFilms();

    @GET("films/{filmId}/")
    Call<Film> getFilm(@Path("filmId") int filmId, @Query("format") String format);
}
