package com.alexdevp.starwars.services;


import com.alexdevp.starwars.model.Film;
import com.alexdevp.starwars.model.FilmsResponse;
import com.alexdevp.starwars.model.Vehicle;
import com.alexdevp.starwars.model.VehiclesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface VehiclesService {

    @GET("vehicles")
    Call<VehiclesResponse> getVehicles();

    @GET("vehicles/{vehicleId}/")
    Call<Vehicle> getVehicle(@Path("vehicleId") int vehicleId, @Query("format") String format);
}
