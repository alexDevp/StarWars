package com.alexdevp.starwars.services;


import com.alexdevp.starwars.model.Starship;
import com.alexdevp.starwars.model.StarshipsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface StarshipsService {

    @GET("starships")
    Call<StarshipsResponse> getStarships();

    @GET("starships/{starshipId}/")
    Call<Starship> getStarship(@Path("starshipId") int starshipId, @Query("format") String format);
}
