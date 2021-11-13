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

    @GET("films/?format=json")
    Call<FilmsResponse> getFilms(@Query("page") int page);

    @GET("films/{filmsId}/")
    Call<Film> getFilm(@Path("filmId") int filmId, @Query("format") String format);
}
