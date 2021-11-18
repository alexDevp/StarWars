package com.alexdevp.starwars.ui.adapters.local;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.alexdevp.starwars.model.Planet;

import java.util.List;


@Dao
public interface PlanetDAO {
    @Query("SELECT * from Planet")
    Planet[] getPlanets();

    @Query("SELECT * FROM Planet WHERE name=:namePlanet")
    Planet getPlanetByName(String namePlanet);

    @Query("DELETE FROM Planet")
    void deleteAllPlanets();

    @Insert
    void addPlanets(Planet[] planets);

    //@Query("SELECT * FROM message WHERE timestamp > :timestamp")
    //List<Message> getNewMessages(long timestamp);
}
