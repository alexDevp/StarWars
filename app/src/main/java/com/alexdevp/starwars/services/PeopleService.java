package com.alexdevp.starwars.services;


import com.alexdevp.starwars.model.PeopleResponse;
import com.alexdevp.starwars.model.People;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PeopleService {

    @GET("people")
    Call<PeopleResponse> getPeople();

    @GET("people/{peopleId}/")
    Call<People> getPeople(@Path("peopleId") int peopleId, @Query("format") String format);
}
