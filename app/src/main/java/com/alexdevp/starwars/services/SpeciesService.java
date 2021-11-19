package com.alexdevp.starwars.services;

import com.alexdevp.starwars.model.Specie;
import com.alexdevp.starwars.model.SpeciesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SpeciesService {

    @GET("species")
    Call<SpeciesResponse> getSpecies();

    @GET("species/{specieId}/")
    Call<Specie> getSpecie(@Path("speciesId") int specieId, @Query("format") String format);
}
