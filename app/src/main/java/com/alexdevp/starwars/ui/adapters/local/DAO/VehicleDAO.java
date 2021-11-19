package com.alexdevp.starwars.ui.adapters.local.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.alexdevp.starwars.model.Vehicle;

@Dao
public interface VehicleDAO {
    @Query("SELECT * from Vehicle")
    Vehicle[] getVehicles();

    @Query("SELECT * FROM Vehicle WHERE name=:nameVehicle")
    Vehicle getVehicleByName(String nameVehicle);

    @Query("DELETE FROM Vehicle")
    void deleteAllVehicles();

    @Insert
    void addVehicles(Vehicle[] vehicles);
}
